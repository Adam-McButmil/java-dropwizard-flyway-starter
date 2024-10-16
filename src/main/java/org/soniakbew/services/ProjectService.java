package org.soniakbew.services;

import org.soniakbew.daos.ProjectDao;
import org.soniakbew.exceptions.Entity;
import org.soniakbew.exceptions.FailedToCreateException;
import org.soniakbew.exceptions.InvalidException;
import org.soniakbew.models.Project;
import org.soniakbew.models.ProjectProperties;

import java.sql.SQLException;

public class ProjectService {
    private final ProjectDao projectDao;
    public ProjectService(final ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
    public int createProject(final Project project,
                             final ProjectProperties projectProperties)
            throws SQLException, FailedToCreateException, InvalidException {

        int id = projectDao.createProject(project, projectProperties);

        if (id == -1) {
            throw new FailedToCreateException(Entity.PROJECT);
        }

        return id;
    }
}
