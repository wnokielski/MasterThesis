from sqlalchemy import Column, Integer, String, ForeignKey, Date
from sqlalchemy.orm import MappedColumn, Relationship

from src.models.base import Base


class Policy(Base):
    __tablename__ = 'Policy'

    id = Column(Integer, primary_key=True)
    policy_number = Column(String(20))
    policyholder_id = MappedColumn(ForeignKey('Contact.id'))
    policyholder = Relationship('Contact', cascade="all", foreign_keys=[policyholder_id])
    insured_id = MappedColumn(ForeignKey('Contact.id'))
    insured = Relationship('Contact', cascade="all", foreign_keys=[insured_id])
    effective_date = Column(Date)
