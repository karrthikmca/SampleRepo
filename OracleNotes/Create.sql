create table ar_flight
(
AR_FLIGHT_ID number primary key,
FLIGHTNAME varchar2(50),
AR_ROUTE_ID number ,

CONSTRAINT fk_routeid
    FOREIGN KEY (AR_ROUTE_ID)
    REFERENCES AR_ROUTE(AR_ROUTE_ID)
)


create table ar_route
(
AR_ROUTE_ID number primary key,
source1 varchar2(50),
destination varchar2(50) 
)

create table ar_classtype
(
ar_classtype_ID number primary key,
classtypename varchar2(50)

)

create table ar_seating
(
ar_seating_ID number primary key,
AR_FLIGHT_ID number,
ar_classtype_ID number ,
capacity number ,
fare number ,

CONSTRAINT fk_flightid
    FOREIGN KEY (AR_FLIGHT_ID)
    REFERENCES AR_FLIGHT(AR_FLIGHT_ID),
    
CONSTRAINT fk_classtype
    FOREIGN KEY (ar_classtype_ID)
    REFERENCES ar_classtype(ar_classtype_ID)
)


select * from ar_user
