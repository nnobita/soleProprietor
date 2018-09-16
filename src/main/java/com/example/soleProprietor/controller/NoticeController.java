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

import com.example.soleProprietor.model.Notice;
import com.example.soleProprietor.service.NoticeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/notices"})
public class NoticeController {
    @Autowired
    private NoticeService userService;

    @PostMapping
    public Notice create(@RequestBody Notice user){
        return userService.create(user);
    }

    @GetMapping(path = {"/{id}"})
    public Notice findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping
    public Notice update(@RequestBody Notice user){
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public Notice delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<Notice> findByOwner(@RequestParam(value="ownerId", required=true) int ownerId){
        return userService.findByOwner(ownerId);
    }

}
