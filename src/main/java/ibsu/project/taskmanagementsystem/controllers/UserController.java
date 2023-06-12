package ibsu.project.taskmanagementsystem.controllers;

import ibsu.project.taskmanagementsystem.dto.AddUser;
import ibsu.project.taskmanagementsystem.entities.User;
import ibsu.project.taskmanagementsystem.repositories.UserRepository;
import ibsu.project.taskmanagementsystem.services.UserService;
import ibsu.project.taskmanagementsystem.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
//    public User add(@RequestBody AddUser addUser) throws Exception {
//
//        return null;
//    }
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<User> getAll() {
        return userService.getAllUser();
    }
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET, produces = {"application/json"})
    public User getUser(@PathVariable Long userId) throws Exception {
//        User testUser = new User();
//        testUser.setPassword("0111022");
//        testUser.setEmail("girogi@g.2");
//        testUser.setFirstName("giorgi");
//        testUser.setLastName("gurabana");
//        testUser.getUserId();
        return userService.getUserById(userId);
    }
}

