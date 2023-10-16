package org.example.controller;


import org.example.entity.obj.Device;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/add/person")//添加一个维修人员
    public void addPerson(@RequestBody Person person){
        adminService.addPerson(person);//添加一个用户
    }
    @PostMapping("/add/device")//添加一个设备,这个也可以用作修改设备
    public void addDevice(@RequestBody Device device){
        adminService.addDevice(device);//添加设备
    }
    @GetMapping("/get/device/{deviceId}")//
    public Device getDevice(@PathVariable String deviceId){//查找一个设备
        return adminService.getDevice(deviceId);
    }
    @GetMapping("/get/person/{personId}")//
    public Person getPerson(@PathVariable String personId){//查找一个人
        return adminService.getPerson(personId);
    }
    @GetMapping("/get/fault/{faultId}")//
    public Fault getFault(@PathVariable String faultId){//查找一个错误
        return adminService.getFault(faultId);
    }
    @GetMapping("/get/by/page/devices")//
    public List<Device> getDeviceByPage(@RequestParam(required = false,defaultValue = "0") int pageId,
                                 @RequestParam(required = false,defaultValue = "10") int number){//查找一个错误
        return adminService.findDeviceByPage(pageId,number);
    }
    @GetMapping("/get/by/page/persons")//
    public List<Person> getPersonByPage(@RequestParam(required = false,defaultValue = "0") int pageId,
                                 @RequestParam(required = false,defaultValue = "10") int number){//查找一个错误
        return adminService.findPersonByPage(pageId,number);
    }







}
