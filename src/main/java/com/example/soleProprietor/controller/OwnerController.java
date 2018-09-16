package com.example.soleProprietor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.soleProprietor.model.Owner;
import com.example.soleProprietor.service.OwnerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/owners"})
public class OwnerController {
    @Autowired
    private OwnerService userService;

    @PostMapping
    public Owner create(@RequestBody Owner user){
        return userService.create(user);
    }

    @GetMapping(path = {"/example"})
    public String example(){
        return "Hello world!";
    }

    @GetMapping(path = {"/{id}"})
    public Owner findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping
    public Owner update(@RequestBody Owner user){
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public Owner delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<Owner> findAll(){
        return userService.findAll();
    }
    
    @GetMapping(path = {"/registered"})
    public List<Owner> findRegistered(){
        return userService.findByStatus(1);
    }
    
    @GetMapping(path = {"/unregistered"})
    public List<Owner> findUnregistered(){
        return userService.findByStatus(0);
    }
    
}
