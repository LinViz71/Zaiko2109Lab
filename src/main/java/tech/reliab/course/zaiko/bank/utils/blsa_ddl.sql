CREATE TABLE bank_offices
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR,
    address            VARCHAR,
    total_money        DOUBLE PRECISION,
    rent_cost          DOUBLE PRECISION,
    is_working         BOOLEAN,
    can_place_atm      BOOLEAN,
    can_issue_credit   BOOLEAN,
    can_dispense_money BOOLEAN,
    can_accept_money   BOOLEAN,
    bank_id            BIGINT,
    FOREIGN KEY (bank_id) REFERENCES banks (id)
);


CREATE TABLE banks
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR,
    rating        INTEGER,
    total_money   DOUBLE PRECISION,
    interest_rate DOUBLE PRECISION
);

CREATE TABLE employees
(
    id               BIGSERIAL PRIMARY KEY,
    full_name        VARCHAR,
    date_of_birth    DATE,
    position         VARCHAR,
    salary           DOUBLE PRECISION,
    is_remote        BOOLEAN,
    can_issue_credit BOOLEAN,
    bank_office_id   BIGINT,
    FOREIGN KEY (bank_office_id) REFERENCES bank_offices (id)
);

CREATE TABLE bank_atms
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR,
    address             VARCHAR,
    status              VARCHAR,
    total_money         DOUBLE PRECISION,
    maintenance_cost    DOUBLE PRECISION,
    can_dispense_money  BOOLEAN,
    can_accept_money    BOOLEAN,
    bank_office_id      BIGINT,
    serving_employee_id BIGINT,
    FOREIGN KEY (bank_office_id) REFERENCES bank_offices (id),
    FOREIGN KEY (serving_employee_id) REFERENCES employees (id)
);

CREATE TABLE users
(
    id             BIGSERIAL PRIMARY KEY,
    full_name      VARCHAR,
    date_of_birth  DATE,
    place_of_work  VARCHAR,
    monthly_income DOUBLE PRECISION,
    credit_rating  INTEGER
);

CREATE TABLE user_bank
(
    user_id BIGINT,
    bank_id BIGINT,
    PRIMARY KEY (user_id, bank_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (bank_id) REFERENCES banks (id)
);

CREATE TABLE payment_accounts
(
    id      BIGSERIAL PRIMARY KEY,
    balance DOUBLE PRECISION,
    user_id BIGINT,
    bank_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (bank_id) REFERENCES banks (id)
);

CREATE TABLE credit_accounts
(
    id                      BIGSERIAL PRIMARY KEY,
    start_date              DATE,
    end_date                DATE,
    months_of_credit_amount INTEGER,
    credit_sum              DOUBLE PRECISION,
    monthly_payment         DOUBLE PRECISION,
    interest_rate           DOUBLE PRECISION,
    user_id                 BIGINT,
    bank_id                 BIGINT,
    provided_employee_id    BIGINT,
    payment_account_id      BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (bank_id) REFERENCES banks (id),
    FOREIGN KEY (provided_employee_id) REFERENCES employees (id),
    FOREIGN KEY (payment_account_id) REFERENCES payment_accounts (id)
);