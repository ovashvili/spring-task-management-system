package ibsu.project.taskmanagementsystem.entities.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ibsu.project.taskmanagementsystem.entities.enums.Permission.TASK_ADD;
import static ibsu.project.taskmanagementsystem.entities.enums.Permission.TASK_READ;

public enum Role {
    ADMIN(Set.of(TASK_ADD, TASK_READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(i -> new SimpleGrantedAuthority(i.getPermission()))
                .collect(Collectors.toList());

        //authorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        authorities.add(new SimpleGrantedAuthority(name()));
        return authorities;
    }
}
