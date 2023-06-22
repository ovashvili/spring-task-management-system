package ibsu.project.taskmanagementsystem.dto;

import java.util.Date;

public class AddTask {
    private String title;
    private String description;
    private String additionalDescription;
    private String userEmail;
    private Date createDate;
    private Boolean active;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String assignedUser) {
        this.userEmail = assignedUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
