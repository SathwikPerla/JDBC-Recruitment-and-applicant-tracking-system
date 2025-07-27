-- Insert a sample user
INSERT INTO user (user_id, name, email, gender, phoneNo, dateOfBirth, password)
VALUES (2001, 'Test User', 'testuser@example.com', 'MALE', '9876543210', '2000-01-01', 'test123');

-- Insert a sample candidate linked to the user
INSERT INTO candidate (user_id, candidate_id, resume_link_path, experience, education, skill)
VALUES (2001, 3001, 'resume.pdf', 2, 'B.Tech', 'Java, SQL');

-- Insert a sample job (IMPORTANT: this also needs valid company_dept_id and posted_by)
-- If you don’t have valid values yet, let’s create dummy ones:
INSERT INTO department (dept_id, name) VALUES (1, 'Engineering');

INSERT INTO company (company_id, name) VALUES (1, 'Test Company');

INSERT INTO company_department (company_dept_id, dept_id, company_id) 
VALUES (1, 1, 1);

INSERT INTO recruitor (user_id, recruitor_id, company_id)
VALUES (2001, 101, 1);

INSERT INTO job (job_id, title, company_dept_id, description, total_applications, posted_by, status)
VALUES (1002, 'Java Developer', 1, 'Java backend role', 0, 101, 'open');

-- Insert an application in 'interview' stage
INSERT INTO applications (application_id, job_id, candidate_id, current_stage_id)
VALUES (4001, 1002, 3001, 3);
