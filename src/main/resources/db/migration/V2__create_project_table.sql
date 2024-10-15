CREATE TABLE project (
    projectId INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `value` DECIMAL(11, 2) NOT NULL,
    technologyId INT NOT NULL,
    techLeadId INT NOT NULL,
    clientId INT NOT NULL,
    salesEmployeeId INT NOT NULL,
    startDate DateTime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    finishDate DateTime,
    commissionRate DECIMAL(3,2) NOT NULL,
    CHECK (commissionRate<=1),
    PRIMARY KEY(projectId)
);