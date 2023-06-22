package ibsu.project.taskmanagementsystem.entities.enums;
public enum Permission {
    TASK_ADD("task:add"), TASK_READ("task:read"), TASK_EDIT("task:edit");

    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
