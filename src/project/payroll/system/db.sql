/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mat
 * Created: Oct 1, 2017
 */

-- select * from project
-- 
-- 
-- drop table employee
-- 
-- CREATE TABLE employee (
-- id serial primary key,
-- firstname character varying(50),
-- middleinitial char(1),
-- lastname character varying(50),
-- designation character varying(50),
-- contactno character varying(50),
-- birthdate date,
-- age character varying(20),
-- address character varying(100),
-- profile bytea,
-- emp_status char(1),
-- ongoingProject varchar(50),
-- SSS_No varchar(50),
-- Pag-ibig_No varchar(50)
-- )

alter table employee (
Add column 
SSS_No varchar(50),
Pag-ibig_No varchar(50)
)
-- 
-- truncate table project 
-- 
-- CREATE TABLE project (
-- id serial primary key,
-- name character varying(50),
-- type character varying(100),
-- architect character varying(50),
-- owner character varying(50),
-- location character varying(100),
-- date_started date,
-- date_finished date
-- )
-- 
-- drop table employee_project
-- truncate table employee_project
-- 
-- CREATE TABLE employee_project (
-- id serial primary key,
-- emp_fname character varying(50),
-- emp_lname character varying(50),
-- designation character varying(50),
-- projectname character varying(50)
-- )
--     
drop table payroll
-- truncate table payroll
-- 
CREATE TABLE payroll (
id serial primary key,
emp_fname varchar(50),
emp_lname varchar(50),
des varchar(50),
rate real,
no_hours real,
no_days real,
allowance real, 
deduction_amount real,
salary real,
dateStarted date,
dateEnded date,
projectname varchar(50)
)
-- select * from payroll
-- 
-- SELECT * FROM employee_project
-- 
-- 
-- select * from employee
-- 
-- ALTER TABLE employee 
-- Add constraint fullname UNIQUE (firstname, middleinitial, lastname)
-- 
-- ALTER TABLE Project 
-- add constraint projectName UNIQUE (name)
-- 
-- String where = "datestarted >= '"+dstart+"' AND dateended <= '"+dend+"' AND projectname='"+pname+"'";

select *,
(SELECT SUM(salary) from payroll WHERE datestarted >= '2017-10-06' AND dateended <= '2017-10-12' AND projectname = 'Maria Building') AS totalSalary 
from payroll
WHERE datestarted >= '2017-10-06' AND dateended <= '2017-10-12' AND projectname = 'Maria Building'


CREATE TABLE attendance (
id serial primary key,
emp_id int REFERENECS employee(id),
attendance_date date,
time_in time(hh:mm),
time_out time(hh:mm),
total_hours float,
attendace_value float
)

select * from employee