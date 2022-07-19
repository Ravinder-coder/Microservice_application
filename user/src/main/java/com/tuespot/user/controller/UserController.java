package com.tuespot.user.controller;

import com.tuespot.user.entity.UserEntity;
import com.tuespot.user.model.DepartmentModel;
import com.tuespot.user.model.FindDepartmentByUser;
import com.tuespot.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public UserEntity insert(@RequestBody UserEntity userEntity){
        return this.userRepo.save(userEntity);
    }

    @GetMapping("/{id}")
    public FindDepartmentByUser findDepartmentByUserId(@PathVariable("id") long id){
        FindDepartmentByUser findDepartmentByUser=new FindDepartmentByUser();
        UserEntity userEntity=this.userRepo.findById(id).get();

        DepartmentModel departmentModel=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+id,DepartmentModel.class);
        findDepartmentByUser.setUserEntity(userEntity);
        findDepartmentByUser.setDepartmentModel(departmentModel);
        return findDepartmentByUser;
    }

}
