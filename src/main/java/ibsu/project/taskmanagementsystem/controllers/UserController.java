package ibsu.project.taskmanagementsystem.controllers;

import ibsu.project.taskmanagementsystem.dto.AddUser;
import ibsu.project.taskmanagementsystem.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public User add(@RequestBody AddUser addUser) throws Exception {

        return null;
    }
    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable String user){
//        User testUser = new User();
//        testUser.setPassword("0111022");
//        testUser.setEmail("girogi@g.2");
//        testUser.setFirstName("giorgi");
//        testUser.setLastName("gurabana");
//        testUser.getUserId();
        return  new ResponseEntity<User>(HttpStatus.OK);
    }
}

