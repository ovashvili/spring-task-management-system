package ibsu.project.taskmanagementsystem.repositories;

import ibsu.project.taskmanagementsystem.entities.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
    @Query(value = "select * from tasks " +
            "where active = :active and " +
            "(:searchText is null or title like :searchText)",
            countQuery = "select count(*) from tasks " +
                    "where active = :active and " +
                    "(:searchText is null or title like :searchText)",
            nativeQuery = true)
    Slice<Task> search(@Param("searchText") String searchText, Pageable pageable);
}