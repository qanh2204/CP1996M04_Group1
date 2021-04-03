create database Pathology;
use Pathology;

create table Account(
  id varchar(6) not null primary key,
  username varchar(30) not null,
  pass varchar(30) not null,
  type char(3) not null
);

create table Staff(
    staff_id int primary key,
	F_name varchar(20) not null,
	L_name varchar(20) not null,
	Doj date not null,
	Dept varchar(50) not null,
	addr varchar(60) not null,
	P_no varchar(11) not null,
	gender char(10) not null,
	Dob date not null,
	Edu_qual varchar(30) not null,
	Tech_skills varchar(30) not null,
	id varchar(6) not null,
	FOREIGN KEY (id) REFERENCES Account(id)
);

create table Patient(
    patient_id int primary key,
	F_name varchar(20) not null,
	L_name varchar(20) not null,
	Doj date not null,
	Dept varchar(50) not null,
	addr varchar(60) not null,
	P_no varchar(11) not null,
	gender char(10) not null,
	Dob date not null
);


create table Billing(
   bill_no int primary key,
   patient_id int not null,
   amount int,
   DayBuy date not null,
   CONSTRAINT fk_patientid FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
);

create table BillDetail(
	bill_no int,
	test_id int not null,
	doctor_id int not null,
	cost int not null,
	DayAdd date not null,
	primary key(bill_no,test_id,DayAdd),
	FOREIGN KEY (bill_no) REFERENCES Billing(bill_no),
	FOREIGN KEY (test_id) REFERENCES Test(test_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

create table Test(
   test_id int primary key,
   t_name varchar(35) not null,
   cost int not null
);

create table Stock(
   item_code int primary key,
   iname varchar(40) not null,
   icost int not null,
   inum int not null,
   dnum int not null
);

create table Doctor(
   doctor_id int primary key, 
   D_name varchar(40),
   address varchar(40) not null,
   P_no varchar(11) not null,
   specialization varchar(35) not null,
   id varchar(6) not null,
   FOREIGN KEY (id) REFERENCES Account(id)
);

create table Report(
   patient_id int not null,
   report varchar(100),
   test_id int not null,
   CONSTRAINT fk_ptid FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
   CONSTRAINT fk_testid FOREIGN KEY (test_id) REFERENCES Test(test_id)
); 

insert into Account values ('ADM001','anh','123','adm');
insert into Account values ('STA001','van','123','sta');
insert into Account values ('DOC001','quang','123','doc');

insert into Test values (1,'Blood Test',100000);
insert into Test values (2,'Covid',200000);

insert into Doctor values (1,'Thanh Quang','Can Tho','0918151004','Blood Test','DOC001');

insert into Patient values (1,'Tran','Quang','2021-3-31','A','Can Tho','0859083181','male','2000-10-29');
insert into Patient values (2,'Lan','Anh','2021-3-30','A','Can Tho','0859083181','female','2002-10-12');

insert into Billing values (1,1,100000,'2021-3-31');
insert into BillDetail values (1,1,1,100000,'2021-3-31');
insert into BillDetail values (1,2,1,200000,'2021-3-31');
select sum(cost) as Total from BillDetail group by bill_no having bill_no=1

select * from BillDetail
select * from Billing
