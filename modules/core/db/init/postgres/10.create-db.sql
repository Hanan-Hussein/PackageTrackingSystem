-- begin PACKAGETRACKINGSYSTEM_CUSTOMER
create table PACKAGETRACKINGSYSTEM_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    PHONE_NUMBER varchar(255),
    NATIONAL_ID varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end PACKAGETRACKINGSYSTEM_CUSTOMER
-- begin PACKAGETRACKINGSYSTEM_PACKAGE
create table PACKAGETRACKINGSYSTEM_PACKAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PACKAGE_DESCRIPTION varchar(255),
    DELIVERY_STAGE varchar(255),
    DESTINATION_TO varchar(255),
    RECIEVER_LAST_NAME varchar(255),
    SENDER_LAST_NAME varchar(255),
    CUSTOMER_ID uuid,
    COST_OF_PACKAGE varchar(255),
    TRACKING_ID varchar(255),
    RECEIVER_NAME varchar(255),
    RECEIVER_LAST_NAME varchar(255),
    RECEIVER_EMAIL varchar(255),
    SENDER_NAME varchar(255),
    SENDER_EMAIL varchar(255),
    SENDER_NATIONAL_I varchar(255),
    SENDER_PHONE_NUMBER varchar(255),
    DESTINATION varchar(255),
    --
    primary key (ID)
)^
-- end PACKAGETRACKINGSYSTEM_PACKAGE
-- begin SEC_USER
alter table SEC_USER add column PHONE_NUMBER varchar(255) ^
alter table SEC_USER add column NATIONAL_ID varchar(255) ^
alter table SEC_USER add column DTYPE varchar(31) ^
update SEC_USER set DTYPE = 'sec$User' where DTYPE is null ^
-- end SEC_USER
