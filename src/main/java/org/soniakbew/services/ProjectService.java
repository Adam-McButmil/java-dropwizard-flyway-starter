package org.soniakbew.services;

import org.soniakbew.daos.ClientDao;
import org.soniakbew.daos.ProjectDao;
import org.soniakbew.exceptions.Entity;
import org.soniakbew.exceptions.FailedToCreateException;
import org.soniakbew.exceptions.InvalidException;
import org.soniakbew.models.Project;

import java.sql.SQLException;

public class ProjectService {
    private final ProjectDao projectDao;
    public ProjectService(final ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
    public int createProject(final Project project)
            throws SQLException, FailedToCreateException, InvalidException {

        int id = projectDao.createProject(project);

        if (id == -1) {
            throw new FailedToCreateException(Entity.PROJECT);
        }

        return id;
    }
}
