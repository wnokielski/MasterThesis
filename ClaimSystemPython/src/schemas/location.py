from pydantic import BaseModel, Field, AliasPath


class CreateLocationSchema(BaseModel):
    address: str
    postal_code: str = Field(validation_alias=AliasPath('postalCode'))
    city: str
    country: str


class GetLocationSchema(BaseModel):
    id: int
    address: str
    postal_code: str
    city: str
    country: str
