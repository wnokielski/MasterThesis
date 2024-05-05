from sqlalchemy import Column, Integer, String, ForeignKey, Date
from sqlalchemy.orm import MappedColumn, Relationship

from src.models.base import Base


class Contact(Base):
    __tablename__ = 'Contact'

    id = Column(Integer, primary_key=True)
    first_name = Column(String(40))
    last_name = Column(String(40))
    date_of_birth = Column(Date)
    nin = Column(String(20))
    primary_address_id = MappedColumn(ForeignKey('Location.id'))
    primary_address = Relationship('Location', cascade="all", foreign_keys=[primary_address_id])
