package com.edulinks.vmeeting.user;

import com.edulinks.vmeeting.user.User;
import com.edulinks.vmeeting.user.UserRepository;
import com.edulinks.vmeeting.user.UserNotFoundException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Post请求，新增用户
    @PostMapping("/user/add")
    public @ResponseBody User addNewUser(@RequestBody User user ) {
        userRepository.save(user);

        return user;
    }

    @RequestMapping("/user")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getSingleUser(@PathVariable("id") Integer id){
        // return userRepository.findById(id);
        Optional<User> user = userRepository.findById( id );
        if( !user.isPresent() ){
            throw new UserNotFoundException("id-" + id);
        }

        return user.get();        
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);

        if( !userOptional.isPresent() ){
            return ResponseEntity.notFound().build();
        }

        user.setId(id);
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }


    @RequestMapping("/user/update")
    public String updateUser(@RequestParam Integer id, @RequestParam String name){
        User n = new User();
        n.setId(id);
        n.setName(name);

        userRepository.save(n);

        return "updated";
    }

    @RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        //如果不判断，会发生 org.springframework.dao.EmptyResultDataAccessException 异常
        if ( userRepository.existsById( Integer.parseInt(id) ) ){
            userRepository.deleteById(Integer.parseInt(id));
            return "deleted";
        }else{
            return "error";
        }
    }
    
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}