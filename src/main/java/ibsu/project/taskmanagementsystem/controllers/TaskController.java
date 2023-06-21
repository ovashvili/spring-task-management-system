package ibsu.project.taskmanagementsystem.controllers;

import ibsu.project.taskmanagementsystem.dto.AddTask;
import ibsu.project.taskmanagementsystem.entities.Task;
import ibsu.project.taskmanagementsystem.services.TaskService;
import ibsu.project.taskmanagementsystem.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/task")
@PreAuthorize("hasRole('USER')")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    //@PreAuthorize("hasAuthority('task:read')")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    //@PreAuthorize("hasAuthority('task:read')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Task getById(@PathVariable Long id) throws Exception {
        return taskService.getTaskById(id);
    }

    //@PreAuthorize("hasAuthority('task:add')")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public Task add(@RequestBody AddTask addTask) throws Exception {
        GeneralUtil.checkRequiredProperties(addTask, Arrays.asList("title", "description", "userEmail"));
        return taskService.add(addTask);
    }

    @PreAuthorize("hasAuthority('task:edit')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public Task edit(@PathVariable Long id, @RequestBody AddTask addTask) throws Exception {
        GeneralUtil.checkRequiredProperties(addTask, Arrays.asList("title", "description", "userEmail"));
        return taskService.edit(id, addTask);
    }
}
