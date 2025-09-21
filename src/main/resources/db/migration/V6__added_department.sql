create table if not exists department(
                                         id                  BIGINT                  not null AUTO_INCREMENT primary key,
                                         name                varchar(255),
    budget              DECIMAL(12,2),
    start_date          date,
    department_head_id  BIGINT                  null,
    constraint fk_department_head
    foreign key (department_head_id)
    references instructor(id)
    on delete set null
    ) ENGINE=InnoDB;