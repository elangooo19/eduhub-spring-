package com.eduhub.eduhub_backend.Controller;


import com.eduhub.eduhub_backend.Component.User;
import com.eduhub.eduhub_backend.Exception.SourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<User>userList=new ArrayList<>();

    public UserController()
    {
        userList.add(new User("1","Rathish","Rathish@123"));
        userList.add(new User("2","Elangovan","Elango@123"));
        userList.add(new User("3","Manikandan","Mani@123"));
        userList.add(new User("4","Stephen","Stephen@123"));
        userList.add(new User("5","Alex","Alx@123"));
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers()
    {
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User>getUser(@PathVariable("id") String id)
    {
        return userList.stream().filter(User->User.getUserId().equalsIgnoreCase(id))
                .findFirst().map(ResponseEntity::ok)
                .orElseThrow(()->new SourceNotFound("User","UserId",id));
    }

    @GetMapping("searchUsers")
    public ResponseEntity<User>getUserQuery(@RequestParam String id)
    {
        return userList.stream().filter(User->User.getUserId().equalsIgnoreCase(id))
                .findFirst().map(ResponseEntity::ok)
                .orElseThrow(()->new SourceNotFound("User","UserId",id));
    }


    @PostMapping("users/add")
    public ResponseEntity<User>addUser(@RequestBody User user)
    {
        userList.add(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("user/update/{id}")
    public ResponseEntity<User>updateUser(@PathVariable("id") String id,@RequestBody User user)
    {
        User user1=userList.stream().filter(user2 -> user2.getUserId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(()->new SourceNotFound("User","UserId",id));
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        return ResponseEntity.ok(user1);
    }

    @DeleteMapping("users/delete/{id}")
    public ResponseEntity<User>deleteUser(@PathVariable("id") String id)
    {
        User user=userList.stream().filter(user1 -> user1.getUserId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(()->new SourceNotFound("User","UserId",id));
        userList.remove(user);
        return ResponseEntity.ok(user);
    }



}
