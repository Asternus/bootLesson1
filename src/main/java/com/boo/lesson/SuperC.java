package com.boo.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class SuperC {

    @Autowired
    private CatService catService;

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Cat> save(@RequestBody Cat cat) {
        catService.saveCat(cat);
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

}
