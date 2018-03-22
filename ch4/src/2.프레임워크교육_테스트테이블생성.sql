/*==============================================================*/
/* Table: TEST                                                  */
/*==============================================================*/
create table TEST 
(
   PK                   INT                  not null,
   COL1                 VARCHAR2(100),
   COL2                 NUMBER(10),
   ENTERDATE            DATE,
   constraint PK_TEST primary key (PK)
);

comment on table TEST is
'테스트 테이블';

comment on column TEST.PK is
'고유키';

comment on column TEST.COL1 is
'문자컬럼';

comment on column TEST.COL2 is
'숫자컬럼';

comment on column TEST.ENTERDATE is
'등록일시';


insert into test(pk, col1, col2, enterdate) values (1, '홍길동1', 11, sysdate);
insert into test(pk, col1, col2, enterdate) values (2, '홍길동2', 12, sysdate);
insert into test(pk, col1, col2, enterdate) values (3, '홍길동3', 13, sysdate);
insert into test(pk, col1, col2, enterdate) values (4, '홍길동4', 14, sysdate);
insert into test(pk, col1, col2, enterdate) values (5, '홍길동5', 15, sysdate);
insert into test(pk, col1, col2, enterdate) values (6, '홍길동6', 16, sysdate);
insert into test(pk, col1, col2, enterdate) values (7, '홍길동7', 17, sysdate);
insert into test(pk, col1, col2, enterdate) values (8, '홍길동8', 18, sysdate);
insert into test(pk, col1, col2, enterdate) values (9, '홍길동9', 19, sysdate);
insert into test(pk, col1, col2, enterdate) values (10, '홍길동10', 20, sysdate);

/*==============================================================*/
/* Table: TEST2                                                  */
/*==============================================================*/
create table TEST2 
(
   PK                   INT                  not null,
   COL1                 VARCHAR2(100),
   COL2                 NUMBER(10),
   ENTERDATE            DATE,
   constraint PK_TEST2 primary key (PK)
);

comment on table TEST2 is
'테스트 테이블';

comment on column TEST2.PK is
'고유키';

comment on column TEST2.COL1 is
'문자컬럼';

comment on column TEST2.COL2 is
'숫자컬럼';

comment on column TEST2.ENTERDATE is
'등록일시';


insert into test2(pk, col1, col2, enterdate) values (1, '홍길동1', 11, sysdate);
insert into test2(pk, col1, col2, enterdate) values (2, '홍길동2', 12, sysdate);
insert into test2(pk, col1, col2, enterdate) values (3, '홍길동3', 13, sysdate);
insert into test2(pk, col1, col2, enterdate) values (4, '홍길동4', 14, sysdate);
insert into test2(pk, col1, col2, enterdate) values (5, '홍길동5', 15, sysdate);
insert into test2(pk, col1, col2, enterdate) values (6, '홍길동6', 16, sysdate);
insert into test2(pk, col1, col2, enterdate) values (7, '홍길동7', 17, sysdate);
insert into test2(pk, col1, col2, enterdate) values (8, '홍길동8', 18, sysdate);
insert into test2(pk, col1, col2, enterdate) values (9, '홍길동9', 19, sysdate);
insert into test2(pk, col1, col2, enterdate) values (10, '홍길동10', 20, sysdate);