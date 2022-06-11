package com.example.finalproject.Controllers;
import com.example.finalproject.DTO.API;
import com.example.finalproject.DTO.RequirementsDTO;
import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.MyUsers;
import com.example.finalproject.Services.MyUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class MyUsersController{
    private final MyUsersService myUsersService;
    Logger logger= LoggerFactory.getLogger(MyUsersController.class);
    @GetMapping
    public ResponseEntity<?> getUsers(){
        logger.info("Request to get Users");
        return ResponseEntity.status(200).body(myUsersService.getUsers());
    }
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid MyUsers user){
        logger.info("Request to add User");
        myUsersService.addUser(user);
        return ResponseEntity.status(200).body(new API("Added new User",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid MyUsers users, @PathVariable Integer id) throws InvalidIdException {
        logger.info("Request to update User");
        myUsersService.updateUser(users,id);
        return ResponseEntity.status(200).body(new API("Updated User",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        logger.info("Request to delete User");
        myUsersService.deleteUser(id);
        return ResponseEntity.status(200).body(new API("Deleted User",200));
    }

    @PostMapping("/needs")
    public ResponseEntity<?> addNeed(@RequestBody @Valid RequirementsDTO requirementsDTO) throws InvalidIdException {
        logger.info("Request to add Needs");
        myUsersService.addNeeds(requirementsDTO);

        return ResponseEntity.status(200).body(new API("Added new Needs",200));
    }
}