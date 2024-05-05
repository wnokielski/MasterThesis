from sqlalchemy import select
from sqlalchemy.orm import Session

from src.models.claim import Claim
from src.utils.database import DB
from src.utils.model.claim_builder import build_claim, build_claim_response


def get_claim_by_claim_number(claim_number):
    with Session(DB.get_instance().engine) as session:
        query = select(Claim).where(Claim.claim_number == claim_number)
        claim = session.execute(query).scalar()
    return build_claim_response(claim)


def create_claim(create_claim_schema):
    with Session(DB.get_instance().engine) as session:
        claim = build_claim(create_claim_schema)

        session.add(claim)
        session.flush()
        session.refresh(claim)
        claim_number = claim.claim_number
        session.commit()

    return claim_number


def update_claim(claim_number, fields):
    with Session(DB.get_instance().engine) as session:
        query = select(Claim).where(Claim.claim_number == claim_number)
        claim = session.execute(query).scalar()

        if "description" in fields:
            claim.description = fields["description"]
        if "lossDate" in fields:
            claim.loss_date = fields["lossDate"]

        session.add(claim)
        session.commit()


def delete_claim(claim_number):
    with Session(DB.get_instance().engine) as session:
        query = select(Claim).where(Claim.claim_number == claim_number)
        claim = session.execute(query).scalar()

        session.delete(claim)
        session.commit()
