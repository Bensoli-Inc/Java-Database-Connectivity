installing both mysql server and mysql workbench

creating a database connection in mysql workbench

creating first database >> abc

using the database >> use abc;

creating first table with 2 columns >> create table student (admissionNo int, studentName varchar(20));

displaying the table >> desc student;

inserting values in the columns >> insert into student values (1001, "Ben");
 
insert into student values (1002, "alex");

displaying the contents of the table >> select * from student;

DIFFERENT SQL LANGUAGES

DDL >> data definition language eg create, truncate, drop

dml >> data manipulation language eg insert, delete

dql >> data query language eg select * from

TCL >> transaction control language eg in ecommerce website 
has commit and rollback statements