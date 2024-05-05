from sqlalchemy import select
from sqlalchemy.orm import Session

from src.models.claim import Claim
from src.models.contact import Contact
from src.models.location import Location
from src.models.policy import Policy
from src.schemas.claim import GetClaimSchema
from src.utils.claim_number_generator import generate_claim_number
from src.utils.database import DB
from src.utils.model.contact_builder import build_contact, build_contact_response
from src.utils.model.location_builder import build_location, build_location_response
from src.utils.model.policy_builder import build_policy, build_policy_response


def build_claim(create_claim_schema):
    claim = Claim(claim_number=generate_claim_number(),
                  description=create_claim_schema.description,
                  policy=build_policy(create_claim_schema.policy),
                  loss_location=build_location(create_claim_schema.loss_location),
                  loss_date=create_claim_schema.loss_date,
                  reporter=build_contact(create_claim_schema.reporter),
                  claimant=build_contact(create_claim_schema.claimant))
    return claim


def build_claim_response(claim):
    with Session(DB.get_instance().engine) as session:
        policy_query = select(Policy).where(Policy.id == claim.policy_id)
        policy = session.execute(policy_query).scalar()

        reporter_query = select(Contact).where(Contact.id == claim.reporter_id)
        reporter = session.execute(reporter_query).scalar()

        claimant_query = select(Contact).where(Contact.id == claim.claimant_id)
        claimant = session.execute(claimant_query).scalar()

        loss_location_query = select(Location).where(Location.id == claim.loss_location_id)
        loss_location = session.execute(loss_location_query).scalar()

    claim_response = GetClaimSchema(id=claim.id,
                                    claim_number=claim.claim_number,
                                    description=claim.description,
                                    policy=build_policy_response(policy),
                                    loss_location=build_location_response(loss_location),
                                    loss_date=claim.loss_date,
                                    reporter=build_contact_response(reporter),
                                    claimant=build_contact_response(claimant))
    return claim_response
