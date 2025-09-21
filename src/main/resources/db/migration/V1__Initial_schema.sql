create table student(
    id                      BIGINT                      not null AUTO_INCREMENT primary key,
    first_name              varchar(100),
    last_name               varchar(100),
    email                   varchar(255),
    enrollment_date         date
) ENGINE=InnoDB;

create table course(
    id                      BIGINT                      AUTO_INCREMENT primary key,
    title                   varchar(200),
    credits                 int
) ENGINE=InnoDB;

create table enrollment(
    id                      BIGINT                      not null AUTO_INCREMENT primary key,
    student_id              BIGINT                      not null,
    course_id               BIGINT                      not null,
    grade                   int,
    constraint fk_enrollment_student foreign key (student_id) references student(id) on delete cascade,
    constraint fk_enrollment_course foreign key (course_id) references course(id) on delete cascade
) ENGINE=InnoDB;