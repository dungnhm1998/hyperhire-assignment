CREATE TABLE user_profile
(
    id       NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     VARCHAR2(100)        NOT NULL,
    email    VARCHAR2(150) UNIQUE NOT NULL,
    password VARCHAR2(100)        NOT NULL
);
CREATE SEQUENCE USER_SEQ
    START WITH 1
    INCREMENT BY 1;
create table room
(
    id                NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name              VARCHAR2(100) NOT NULL,
    state             VARCHAR2(150) NOT NULL,
    country           VARCHAR2(2)   NOT NULL,
    interior_bed      NUMBER,
    interior_room     NUMBER,
    interior_bathroom NUMBER,
    point             VARCHAR2(5),
    price             VARCHAR2(20),
    currency          VARCHAR2(10),
    owner             VARCHAR2(150),
    short_desc        varchar2(4000),
    long_desc         clob,
    rule              varchar2(4000),
    category_id       varchar2(32),
    type              VARCHAR2(150),
    status            VARCHAR2(20),
    create_at         date,
    update_at         date,
    delete_at         date
);

CREATE SEQUENCE ROOM_SEQ
    START WITH 1
    INCREMENT BY 1;

create table category
(
    id        VARCHAR2(32) PRIMARY KEY,
    name      VARCHAR2(100) NOT NULL,
    status    VARCHAR2(20),
    position  number,
    create_at date,
    update_at date,
    delete_at date
);
CREATE SEQUENCE category_SEQ
    START WITH 1
    INCREMENT BY 1;

drop table mockup;
create table mockup
(
    id      VARCHAR2(32) PRIMARY KEY,
    type    VARCHAR2(10)  NOT NULL,
    room_id number        NOT NULL,
    url     VARCHAR2(500) NOT NULL
);
create table payment_method
(
    id        VARCHAR2(32) PRIMARY KEY,
    method    VARCHAR2(32),
    name      VARCHAR2(32),
    status    VARCHAR2(20),
    create_at date,
    update_at date,
    delete_at date
);
drop table reservation;
create table reservation
(
    id              NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    room_id         number,
    total_price     varchar2(20),
    total_guest     number,

    price           VARCHAR2(20),
    tax             VARCHAR2(20),
    discount        VARCHAR2(20),
    extra_fee       VARCHAR2(20),
    guest_children  number,
    guest_infants   number,
    guest_pets      number,
    guest_adult     number,

    check_in        date,
    check_out       date,

    guest_photo     VARCHAR2(200),
    guest_phone     VARCHAR2(20),
    cancel_allow_at date,

    status          VARCHAR2(20),
    create_at       date,
    update_at       date,
    pay_at          date,
    delete_at       date
);
alter table reservation add is_confirmed number;
CREATE SEQUENCE reservation_SEQ
    START WITH 1
    INCREMENT BY 1;
drop table reservation_timeline;
create table reservation_timeline
(
    id             VARCHAR2(32) PRIMARY KEY,
    reservation_id NUMBER,
    action         varchar2(2000),
    status         VARCHAR2(20),
    create_at      date
);
drop table payment;
create table payment
(
    id             VARCHAR2(32) PRIMARY KEY,
    reservation_id number,
    total_amount    VARCHAR2(20),
    transaction_id VARCHAR2(20),
    token          VARCHAR2(20),
    method         VARCHAR2(20),
    extra_fee      VARCHAR2(20),
    status         VARCHAR2(20),
    create_at      date,
    update_at      date,
    delete_at      date
);

