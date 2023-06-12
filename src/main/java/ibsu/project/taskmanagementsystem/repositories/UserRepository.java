package ibsu.project.taskmanagementsystem.repositories;

import ibsu.project.taskmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
