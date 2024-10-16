CREATE TABLE projectDeliveryEmployee (
    projectId INT NOT NULL,
    deliveryEmployeeId INT NOT NULL,
    PRIMARY KEY(projectId, deliveryEmployeeId),
    FOREIGN KEY(projectId) REFERENCES project(projectId),
    FOREIGN KEY(deliveryEmployeeId) REFERENCES deliveryEmployee(deliveryEmployeeId)
);
