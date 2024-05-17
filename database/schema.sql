CREATE SCHEMA `jsp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

USE jsp;

DROP TABLE IF EXISTS jsp_employees;

CREATE TABLE IF NOT EXISTS jsp_employees (
                                             id INT NOT NULL AUTO_INCREMENT,
                                             first_name VARCHAR(250) NOT NULL,
                                             email VARCHAR(250) NOT NULL,
                                             last_name VARCHAR(250) NOT NULL,
                                             PRIMARY KEY (id),
                                             CONSTRAINT UC_EMAIL UNIQUE (email)
);

INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Java',  'mrjava@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('C#',  'mrcsharp@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Golang',  'mrgolang@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Python',  'mrpython@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('PHP',  'mrphp@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Ruby',  'mrruby@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Kotlin',  'mrkotlin@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Swift',  'mrswift@nextjsvietnam.com', 'Mr');
INSERT INTO jsp_employees (first_name, email, last_name)
VALUES ('Dart',  'mrdart@nextjsvietnam.com', 'Mr');
