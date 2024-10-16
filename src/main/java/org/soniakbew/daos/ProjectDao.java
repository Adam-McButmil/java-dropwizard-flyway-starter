package org.soniakbew.daos;

import org.soniakbew.models.Project;
import org.soniakbew.models.ProjectProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private Project projectFromResultSet(
            final ResultSet resultSet
    ) throws SQLException {
        return new Project(
                resultSet.getInt("projectId"),
                resultSet.getString("name"),
                resultSet.getInt("technologyId"),
                resultSet.getInt("techLeadId"),
                resultSet.getInt("clientId"),
                resultSet.getInt("salesEmployeeId"),
                new ProjectProperties(
                resultSet.getDate("startDate"),
                resultSet.getDate("finishDate"),
                resultSet.getFloat("commissionRate"),
                resultSet.getDouble("value")
                )
        );
    }

    public List<Project> getAllProjects() throws SQLException {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
"SELECT projectId, name, technologyId, techLeadId, clientId, "
+ "salesEmployeeId, startDate, finishDate, commissionRate, value FROM project"
            );
            while (resultSet.next()) {
                projects.add(projectFromResultSet(resultSet));
            }
            connection.close();
        }
        return projects;
    }
    public Project getProjectById(final int projectId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query =
                    "SELECT projectId, name FROM project WHERE projectId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, projectId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return projectFromResultSet(resultSet);
            }
        }
        return null;
    }

}
