package com.dasgher.backend.login.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dasgher.backend.login.model.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {

    @PostMapping(value="/authenticate", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User authenticate(@RequestBody LoginInformation entity) {
        System.out.println(entity);
        return new User("101", entity.username(), entity.password(), "Francisco", "Silva", "fake_jwt_token");
    }

    @PostMapping(value="/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody User userInfo) {
        System.out.println(userInfo.toString());
    }

    @GetMapping(value="", produces = "application/json")
    public @ResponseBody List<UserInformation> getUsers() {
        var user1 = new UserInformation("1", "sabaril","Sabará", "Pastoril");
        var user2 = new UserInformation("2", "chico","Chico", "Silva");
        return Arrays.asList(user1, user2);
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public @ResponseBody UserInformation getUserById(@PathVariable int id) {
        var user1 = new UserInformation("1", "sabaril","Sabará", "Pastoril");
        var user2 = new UserInformation("2", "chico","Chico", "Silva");
        var array = Arrays.asList(user1, user2);

        for(UserInformation user : array){
            if(user.id().equals(id+"")) return user;
        }

        return null;
    }

    @PutMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable String id, @RequestBody User entity) {
        System.out.println(entity);
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id, @RequestBody User entity) {
        System.out.println(entity);
    }

}
