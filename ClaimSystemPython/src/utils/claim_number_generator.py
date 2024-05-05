from sqlalchemy import select
from sqlalchemy.orm import Session

from src.models.claim import Claim
from src.utils.database import DB


def generate_claim_number():
    next_sequence_number = __get_claim_count() + 1
    number = str(next_sequence_number)
    while len(number) < 9:
        number = "0" + number
    claim_number = "CL" + number
    return claim_number

def __get_claim_count():
    with Session(DB.get_instance().engine) as session:
        count = session.query(Claim).count()
        return count