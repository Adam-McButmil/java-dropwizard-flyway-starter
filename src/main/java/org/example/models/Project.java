package org.example.models;

public class Project {
    private int projectId;
    private String name;
    private int technologyId;
    private int techLeadId;
    private int clientId;
    private int salesEmployeeId;
    private ProjectProperties projProps;
    public Project(
            final int projectId,
            final String name,
            final int technologyId,
            final int techLeadId,
            final int clientId,
            final int salesEmployeeId,
            final ProjectProperties projProps
    ) {
        this.projectId = projectId;
        this.name = name;
        this.technologyId = technologyId;
        this.techLeadId = techLeadId;
        this.clientId = clientId;
        this.salesEmployeeId = salesEmployeeId;
        this.projProps = projProps;
    }
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(final int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(final int technologyId) {
        this.technologyId = technologyId;
    }

    public ProjectProperties getProjProps() {
        return projProps;
    }

    public void setProjProps(final ProjectProperties projProps) {
        this.projProps = projProps;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(final int techLeadId) {
        this.techLeadId = techLeadId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(final int clientId) {
        this.clientId = clientId;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(final int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }
}
