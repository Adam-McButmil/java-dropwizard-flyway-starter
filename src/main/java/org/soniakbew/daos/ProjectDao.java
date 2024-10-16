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

    public int createProject(
            final Project project, final ProjectProperties projectProperties)
            throws SQLException {
        Connection conn = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO Project (projectId, name, technologyId,"
                        + " techLeadId, clientId, salesEmployeeId,"
                        + " startDate, finishDate, commissionRate,"
                        + "value VALUES (?,?,?);";

        PreparedStatement pst = conn.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);
        final int techIdIndex = 3;
        final int techLeadIdIndex = 4;
        final int clientIdIndex = 5;
        final int salesEmpIndex = 6;
        final int startDateIndex = 7;
        final int finishDateIndex = 8;
        final int commissionRateIndex = 9;
        final int valueIndex = 10;
        pst.setInt(1, project.getProjectId());
        pst.setString(2, project.getName());
        pst.setInt(techIdIndex, project.getTechnologyId());
        pst.setInt(techLeadIdIndex, project.getTechLeadId());
        pst.setInt(clientIdIndex, project.getClientId());
        pst.setInt(salesEmpIndex, project.getSalesEmployeeId());
        pst.setDate(startDateIndex, projectProperties.getStartDate());
        pst.setDate(finishDateIndex, projectProperties.getFinishDate());
        pst.setFloat(
                commissionRateIndex, projectProperties.getCommissionRate());
        pst.setDouble(valueIndex, projectProperties.getValue());

        pst.executeUpdate();

        ResultSet res = pst.getGeneratedKeys();
        if (res.next()) {
            return res.getInt(1);
        }

        return -1;
    }

}
