from fastapi import FastAPI
from src.routers.claim import router
from src.models.base import Base
from src.models.claim import Claim
from src.models.policy import Policy
from src.models.contact import Contact
from src.models.location import Location
from src.utils.database import DB

engine = DB.get_instance().engine
Base.metadata.create_all(engine)

app = FastAPI()

app.include_router(router.router, prefix="/claim")
