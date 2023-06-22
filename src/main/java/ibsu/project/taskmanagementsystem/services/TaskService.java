package ibsu.project.taskmanagementsystem.services;

import ibsu.project.taskmanagementsystem.dto.AddTask;
import ibsu.project.taskmanagementsystem.entities.Task;
import ibsu.project.taskmanagementsystem.entities.User;
import ibsu.project.taskmanagementsystem.repositories.TaskRepository;
import ibsu.project.taskmanagementsystem.repositories.UserRepository;
import ibsu.project.taskmanagementsystem.utils.GeneralUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TASK_NOT_FOUND"));
    }

    @Transactional
    public Task add(AddTask addTask) throws Exception {
        Task task = new Task();
        GeneralUtil.getCopyOf(addTask, task);

        User assignedUser = userRepository.findByEmail(addTask.getUserEmail())
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));

        task.setCreateDate(new Date());
        task.setActive(true);
        task.setAssignedUser(assignedUser);

        return taskRepository.save(task);
    }

    @Transactional
    public Task edit(Long id, AddTask addTask) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TASK_NOT_FOUND"));

        GeneralUtil.getCopyOf(addTask, task);

        if (!addTask.getUserEmail().equals(task.getAssignedUser().getEmail())) {
            User assignedToUser = userRepository.findByEmail(addTask.getUserEmail())
                    .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));
            task.setAssignedUser(assignedToUser);
        }

        return taskRepository.save(task);
    }
}
