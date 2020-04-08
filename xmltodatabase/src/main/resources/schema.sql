DROP TABLE IF EXISTS student;

CREATE TABLE student  (
    student_id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(40),
    last_name VARCHAR(40),
    email VARCHAR(100),
    age INT
);