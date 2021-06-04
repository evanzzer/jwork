DROP TABLE invoice;
DROP TABLE job;
DROP TABLE jobseeker;
DROP TABLE bonus;
DROP TABLE recruiter;


CREATE TABLE jobseeker(id SERIAL PRIMARY KEY, name text NOT NULL, email text UNIQUE NOT NULL, password text NOT NULL, joinDate date DEFAULT NOW());
CREATE TAble bonus(id SERIAL PRIMARY KEY, referralCode text UNIQUE NOT NULL, extraFee bigint default 0, minTotalFee bigint default 0, active bool);
-- INVOICE
CREATE TABLE recruiter(id SERIAL PRIMARY KEY, name text NOT NULL, email text UNIQUE NOT NULL, phoneNumber text NOT NULL, province text, city text, description text);
CREATE TABLE job(
                    id SERIAL PRIMARY KEY, name text UNIQUE NOT NULL, recruiter_id int, fee bigint DEFAULT 0, category text NOT NULL,
                    CONSTRAINT fk_job_recruiter FOREIGN KEY (recruiter_id) REFERENCES recruiter(id) ON DELETE SET NULL ON UPDATE CASCADE
);
CREATE TABLE invoice(
                        id int NOT NULL, job_id int, date date DEFAULT NOW(), totalFee bigint DEFAULT 0, jobseeker_id int,
                        invoiceStatus text DEFAULT 'Ongoing', paymentType text DEFAULT 'E-Wallet Payment', bonus_id int DEFAULT NULL, adminFee bigint DEFAULT 0,
                        CONSTRAINT pk_invoice PRIMARY KEY (id, job_id),
                        CONSTRAINT fk_inv_job FOREIGN KEY (job_id) REFERENCES job(id) ON DELETE SET NULL ON UPDATE CASCADE,
                        CONSTRAINT fk_inv_jobseeker FOREIGN KEY (jobseeker_id) REFERENCES jobseeker(id) ON DELETE SET NULL ON UPDATE CASCADE,
                        CONSTRAINT fk_inv_bonus FOREIGN KEY (bonus_id) REFERENCES bonus(id) ON DELETE SET NULL ON UPDATE CASCADE
);
SELECT * FROM jobseeker;

SELECT * FROM recruiter;

SELECT * FROM bonus;

SELECT j.id, j.name, j.recruiter_id, r.name, r.email, r.phoneNumber, r.province, r.city, r.description, j.fee, j.category FROM job j INNER JOIN recruiter r ON j.recruiter_id = r.id;

WITH job AS (
    SELECT
        j.id, j.name, j.recruiter_id, r.name as r_name, r.email, r.phoneNumber, r.province, r.city, r.description, j.fee, j.category
    FROM job j
             INNER JOIN recruiter r ON j.recruiter_id = r.id
)
SELECT i.id, i.job_id, j.name, j.recruiter_id, j.r_name, j.email, j.phoneNumber, j.province, j.city, j.description, j.fee, j.category, --12
       i.date, i.jobseeker_id, s.name, s.email, s.password, s.joinDate, i.invoiceStatus, i.paymentType, --20
       i.bonus_id, b.referralCode, b.extraFee, b.minTotalFee, b.active, i.adminFee --26
FROM invoice i LEFT JOIN job j ON i.job_id = j.id LEFT JOIN jobseeker s ON i.jobseeker_id = s.id LEFT JOIN bonus b ON i.bonus_id = b.id;

SELECT * from invoice;