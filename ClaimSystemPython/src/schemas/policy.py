from datetime import datetime
from pydantic import BaseModel, Field, AliasPath

from src.schemas.contact import CreateContactSchema, GetContactSchema


class CreatePolicySchema(BaseModel):
    policy_number: str = Field(validation_alias=AliasPath('policyNumber'))
    policyholder: CreateContactSchema = Field(validation_alias=AliasPath('policyHolder'))
    insured: CreateContactSchema
    effective_date: datetime = Field(validation_alias=AliasPath('effectiveDate'))


class GetPolicySchema(BaseModel):
    id: int
    policy_number: str
    policyholder: GetContactSchema
    insured: GetContactSchema
    effective_date: datetime

