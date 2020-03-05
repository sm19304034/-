show user


Create user hata identified by "hata" account unlock;
grant dba TO hata;

commit;


connect hata/hata

commit;

create table b_board(
 b_board_id number(5) not null,
 b_board_title varchar2(255) not null,
 user_name varchar2(255) not null,
 b_board_body varchar2(999) not null,
 b_date date,
 CONSTRAINT pk_b_board primary key(b_board_id)
);

commit;

create sequence b_board_id
	start with 1
	increment by 1
	maxvalue 10000
	minvalue 1
;

commit;


create table response(
 response_id number(7) not null,
 response_name varchar2(255) not null,
 response_comment varchar2(4000) not null,
 responseday_date date default sysdate,
 b_board_id number(5) not null,
 CONSTRAINT pk_response primary key(response_id),
 CONSTRAINT fk_response foreign key(b_board_id) references b_board(b_board_id)
);

commit;

create sequence response_id
	start with 1
	increment by 1
	maxvalue 1000000
	minvalue 1
;

commit;



show user



