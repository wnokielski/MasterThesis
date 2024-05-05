from sqlalchemy import Column, Integer, String, ForeignKey, Date
from sqlalchemy.orm import MappedColumn, Relationship

from src.models.base import Base


class Claim(Base):
    __tablename__ = 'Claim'

    id = Column(Integer, primary_key=True)
    claim_number = Column(String(20))
    description = Column(String(200))
    policy_id = MappedColumn(ForeignKey('Policy.id'))
    policy = Relationship('Policy', cascade="all", foreign_keys=[policy_id])
    loss_location_id = MappedColumn(ForeignKey('Location.id'))
    loss_location = Relationship('Location', cascade="all", foreign_keys=[loss_location_id])
    loss_date = Column(Date)
    reporter_id = MappedColumn(ForeignKey('Contact.id'))
    reporter = Relationship('Contact', cascade="all", foreign_keys=[reporter_id])
    claimant_id = MappedColumn(ForeignKey('Contact.id'))
    claimant = Relationship('Contact', cascade="all", foreign_keys=[claimant_id])
