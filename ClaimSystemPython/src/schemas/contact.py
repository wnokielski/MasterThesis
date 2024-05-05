from pydantic import BaseModel, Field, AliasPath
from datetime import datetime

from src.schemas.location import CreateLocationSchema, GetLocationSchema


class CreateContactSchema(BaseModel):
    first_name: str = Field(validation_alias=AliasPath('firstName'))
    last_name: str = Field(validation_alias=AliasPath('lastName'))
    date_of_birth: datetime = Field(validation_alias=AliasPath('dateOfBirth'))
    nin: str
    primary_address: CreateLocationSchema = Field(validation_alias=AliasPath('primaryAddress'))


class GetContactSchema(BaseModel):
    first_name: str
    last_name: str
    date_of_birth: datetime
    nin: str
    primary_address: GetLocationSchema
