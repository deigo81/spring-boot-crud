package com.codesnippet.springbootcrudh2.controller;

import com.codesnippet.springbootcrudh2.entity.ComEntity;
import com.codesnippet.springbootcrudh2.service.IComEnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestApiController {


    @Autowired
    IComEnityService service;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?> find(@RequestParam("id") Long id) {

        Optional<ComEntity> rest = null;
        if (id != null) {
            rest = service.findId(id);
        }
        if (rest.isPresent()) {
            return new ResponseEntity<>(rest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ComEntity comEntity) {
        ComEntity c = service.save(comEntity);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ComEntity comEntity) {
        if (comEntity != null && comEntity.getId() != null) {
            ComEntity c = service.findId(comEntity.getId()).get();
            if (c != null) {
                c.setCode(comEntity.getCode());
                c.setDescription(comEntity.getDescription());
                return new ResponseEntity<>(service.save(c), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        Optional<ComEntity> rest = null;
        if (id != null) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
