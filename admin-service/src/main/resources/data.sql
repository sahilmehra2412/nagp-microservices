CREATE TABLE IF NOT EXISTS REQUEST(
id INT AUTO_INCREMENT PRIMARY KEY,
service_requested VARCHAR(20) NOT NULL,
requested_by VARCHAR(20) NOT NULL,
requested_on DATE NOT NULL,
completed_on DATE,
completed_by VARCHAR(20)
);