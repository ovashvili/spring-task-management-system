package ibsu.project.taskmanagementsystem.controllers;

import ibsu.project.taskmanagementsystem.dto.AddUser;
import ibsu.project.taskmanagementsystem.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public User add(@RequestBody AddUser addUser) throws Exception {

        return null;
    }
}
