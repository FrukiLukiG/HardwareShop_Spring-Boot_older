CREATE TABLE IF NOT EXISTS hardware(
    h_id identity,
    h_code varchar(10) not null unique,
    h_name varchar(255) not null,
    h_price double not null,
    h_type varchar(100) not null,
    h_num_available integer not null
);

CREATE TABLE IF NOT EXISTS review(
    r_id identity,
    h_id integer not null,
    r_title varchar(100) not null,
    r_text varchar(510) not null,
    r_grade varchar(10) not null,
    FOREIGN KEY (h_id) REFERENCES hardware(h_id)
);