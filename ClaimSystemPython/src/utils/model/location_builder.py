from src.models.location import Location
from src.schemas.location import GetLocationSchema


def build_location(create_location_schema):
    location = Location(address=create_location_schema.address,
                        postal_code=create_location_schema.postal_code,
                        city=create_location_schema.city,
                        country=create_location_schema.country)
    return location


def build_location_response(location):
    location_response = GetLocationSchema(id=location.id,
                                          address=location.address,
                                          postal_code=location.postal_code,
                                          city=location.city,
                                          country=location.country)
    return location_response