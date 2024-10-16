package org.soniakbew.models;
import java.sql.Date;

public class ProjectProperties {
    private Date startDate;
    private Date finishDate;
    private float commissionRate;
    private double value;

    public ProjectProperties(
            final Date startDate,
            final Date finishDate,
            final float commissionRate,
            final double value
    ) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.commissionRate = commissionRate;
        this.value = value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(final Date finishDate) {
        this.finishDate = finishDate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }
}
