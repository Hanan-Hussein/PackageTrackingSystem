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
);