package com.tuespo.department.controller;

import com.tuespo.department.entity.DepartmentEntity;
import com.tuespo.department.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @PostMapping("/")
    public DepartmentEntity departmentEntity(@RequestBody DepartmentEntity departmentEntity){
        return  this.departmentRepo.save(departmentEntity);
    }

    @GetMapping("/{id}")
    public DepartmentEntity departmentById(@PathVariable("id") Long departmentId){
        return  this.departmentRepo.findById(departmentId).get();
    }

}
