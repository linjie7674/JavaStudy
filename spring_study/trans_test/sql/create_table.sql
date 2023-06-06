drop table account;
CREATE TABLE account
(
    id int AUTO_INCREMENT PRIMARY KEY, 
    name varchar(15),
    money int
);

insert account values (null, "xiaoming", 5000);
insert account values (null, "xiaohua", 5000);