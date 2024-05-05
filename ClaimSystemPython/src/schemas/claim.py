from datetime import datetime

from pydantic import BaseModel, Field, AliasPath

from src.schemas.contact import CreateContactSchema, GetContactSchema
from src.schemas.location import CreateLocationSchema, GetLocationSchema
from src.schemas.policy import CreatePolicySchema, GetPolicySchema


class CreateClaimSchema(BaseModel):
    description: str
    policy: CreatePolicySchema
    loss_location: CreateLocationSchema = Field(validation_alias=AliasPath('lossLocation'))
    loss_date: datetime = Field(validation_alias=AliasPath('lossDate'))
    reporter: CreateContactSchema
    claimant: CreateContactSchema


class UpdateClaimSchema(BaseModel):
    description: str
    loss_date: datetime = Field(validation_alias=AliasPath('lossDate'))


class GetClaimSchema(BaseModel):
    id: int
    claim_number: str
    description: str
    policy: GetPolicySchema
    loss_location: GetLocationSchema
    loss_date: datetime
    reporter: GetContactSchema
    claimant: GetContactSchema
