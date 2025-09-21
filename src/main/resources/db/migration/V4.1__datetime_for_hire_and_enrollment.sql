/* i messed up, i gotta fix the dates.. */

ALTER TABLE instructor
    MODIFY hire_date DATETIME(6) NOT NULL;
ALTER TABLE student
    MODIFY enrollment_date DATETIME(6) NOT NULL;
