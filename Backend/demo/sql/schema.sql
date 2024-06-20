CREATE TABLE Introduction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE Section (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    introduction_id BIGINT NOT NULL,
    sub_title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    FOREIGN KEY (introduction_id) REFERENCES Introduction(id)
);