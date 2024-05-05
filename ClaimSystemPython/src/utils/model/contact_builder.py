from sqlalchemy import select
from sqlalchemy.orm import Session

from src.models.contact import Contact
from src.models.location import Location
from src.schemas.contact import GetContactSchema
from src.utils.database import DB
from src.utils.model.location_builder import build_location, build_location_response


def build_contact(create_contact_schema):
    contact = Contact(first_name=create_contact_schema.first_name,
                      last_name=create_contact_schema.last_name,
                      date_of_birth=create_contact_schema.date_of_birth,
                      nin=create_contact_schema.nin,
                      primary_address=build_location(create_contact_schema.primary_address))
    return contact


def build_contact_response(contact):
    with Session(DB.get_instance().engine) as session:
        primary_address_query = select(Location).where(Location.id == contact.primary_address_id)
        primary_address = session.execute(primary_address_query).scalar()

    contact_response = GetContactSchema(id=contact.id,
                                        first_name=contact.first_name,
                                        last_name=contact.last_name,
                                        date_of_birth=contact.date_of_birth,
                                        nin=contact.nin,
                                        primary_address=build_location_response(primary_address))
    return contact_response
