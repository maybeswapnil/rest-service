DROP DATABASE IF EXISTS springormdemos;
CREATE DATABASE springormdemos; 
USE springormdemos;

DROP TABLE IF EXISTS employee;


CREATE TABLE IF NOT EXISTS employee (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  salary double DEFAULT NULL,
  role varchar(20) DEFAULT NULL,
  insert_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

INSERT INTO employee (id, name, role, insert_time, salary) VALUES
	(1001, 'MSD', 'Sr.Analyst', '2016-01-28', 100000),
	(1002, 'James', 'Sr.Analyst', '2016-01-28', 0),
	(1003, 'Rocky', 'Sr.Analyst', '2016-01-28', 12000);
commit;