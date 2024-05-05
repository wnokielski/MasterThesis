from typing import Any

from fastapi import APIRouter
from starlette import status

from src.schemas.claim import CreateClaimSchema, UpdateClaimSchema
from src.services import claim_service

router = APIRouter()


@router.get("/byClaimNumber/{claim_number}")
async def get_all_claims(claim_number):
    return claim_service.get_claim_by_claim_number(claim_number)


@router.post("/", status_code=status.HTTP_201_CREATED)
async def create_claim(create_claim_schema: CreateClaimSchema):
    return claim_service.create_claim(create_claim_schema)


@router.patch("/byClaimNumber/{claim_number}", status_code=status.HTTP_200_OK)
async def update_claim(claim_number, fields: dict[str, Any]):
    claim_service.update_claim(claim_number, fields)


@router.delete("/byClaimNumber/{claim_number}", status_code=status.HTTP_204_NO_CONTENT)
async def delete_claim(claim_number):
    claim_service.delete_claim(claim_number)
