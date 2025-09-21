create table if not exists instructor(
                                         id                      BIGINT                      not null AUTO_INCREMENT primary key,
                                         first_name              varchar(255),
    last_name               varchar(255),
    email                   varchar(255),
    hire_date               date
    ) ENGINE=InnoDB;

ALTER TABLE course
    ADD COLUMN instructor_id BIGINT NULL,
    ADD CONSTRAINT FK_course_instructor
    FOREIGN KEY (instructor_id) REFERENCES instructor(id)
    ON DELETE SET NULL;