from sqlalchemy import Column, Integer, String, ForeignKey, Date
from sqlalchemy.orm import MappedColumn, Relationship

from src.models.base import Base


class Location(Base):
    __tablename__ = 'Location'

    id = Column(Integer, primary_key=True)
    address = Column(String(40))
    postal_code = Column(String(10))
    city = Column(String(40))
    country = Column(String(40))
