from sqlalchemy import select
from sqlalchemy.orm import Session

from src.models.contact import Contact
from src.models.policy import Policy
from src.schemas.policy import GetPolicySchema
from src.utils.database import DB
from src.utils.model.contact_builder import build_contact, build_contact_response


def build_policy(create_policy_schema):
    policy = Policy(policy_number=create_policy_schema.policy_number,
                    policyholder=build_contact(create_policy_schema.policyholder),
                    insured=build_contact(create_policy_schema.insured),
                    effective_date=create_policy_schema.effective_date, )
    return policy


def build_policy_response(policy):
    with Session(DB.get_instance().engine) as session:
        policyholder_query = select(Contact).where(Contact.id == policy.policyholder_id)
        policyholder = session.execute(policyholder_query).scalar()

        insured_query = select(Contact).where(Contact.id == policy.insured_id)
        insured = session.execute(insured_query).scalar()

    policy_response = GetPolicySchema(id=policy.id,
                                      policy_number=policy.policy_number,
                                      policyholder=build_contact_response(policyholder),
                                      insured=build_contact_response(insured),
                                      effective_date=policy.effective_date,)
    return policy_response
