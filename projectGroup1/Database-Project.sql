create database Pathology;
use Pathology;

create table Staff(
    staff_id int primary key,
	F_name varchar(20) not null,
	L_name varchar(20) not null,
	Doj datetime not null,
	Dept varchar(50) not null,
	addr varchar(60) not null,
	P_no int not null,
	gender char(4) not null,
	Dob datetime not null,
	Edu_qual varchar(30) not null,
	Tech_skills varchar(30) not null
);

create table Patient(
    patient_id int primary key,
	F_name varchar(20) not null,
	L_name varchar(20) not null,
	Doj datetime not null,
	Dept varchar(50) not null,
	addr varchar(60) not null,
	P_no int not null,
	gender char(4) not null,
	Dob datetime not null,
	test varchar(20) not null,
	bill int not null
);

create table Billing(
   bill_no int primary key,
   patient_id int not null,
   amount int not null,
   CONSTRAINT fk_patientid FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
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

create table Docter(
   docter_id int primary key, 
   D_name varchar(40),
   address varchar(40) not null,
   P_no int not null,
   specialization varchar(35) not null
);

create table Report(
   patient_id int not null,
   report varchar(100),
   test_id int not null,
   CONSTRAINT fk_ptid FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
   CONSTRAINT fk_testid FOREIGN KEY (test_id) REFERENCES Test(test_id)
);

create table Bill_detail(
  bill_no int not null,
  test_id int  not null,
  docter_id int not null,
  primary key( bill_no, test_id, docter_id)
);

create table Account(
  id int not null primary key,
  username varchar(30) not null,
  pass varchar(30) not null,
  type char(3) not null
);