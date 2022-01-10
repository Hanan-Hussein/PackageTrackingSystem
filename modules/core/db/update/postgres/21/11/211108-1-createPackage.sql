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
    COST_OF_PACKAGE varchar(255),
    TRACKING_ID varchar(255),
    RECEIVER_NAME varchar(255),
    SENDER_NAME varchar(255),
    RECEIVER_ID varchar(255),
    SENDER_ID varchar(255),
    DESTINATION varchar(255),
    --
    primary key (ID)
);