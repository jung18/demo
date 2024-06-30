CREATE TABLE Introduction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE Section (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    introduction_id BIGINT NOT NULL,
    sub_title VARCHAR(255) NOT NULL,
    content TEXT,
    FOREIGN KEY (introduction_id) REFERENCES Introduction(id)
);

CREATE TABLE education (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    university_name VARCHAR(255) NOT NULL,
    degree VARCHAR(255) NOT NULL,
    major VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    graduate_date DATE
);

CREATE TABLE employment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    department VARCHAR(255),
    start_date DATE NOT NULL,
    end_date DATE,
    achievement TEXT
);