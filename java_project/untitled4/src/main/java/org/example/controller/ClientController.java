package org.example.controller;


import org.example.service.ClientService;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class ClientController {//客户类可以做什么



    @Autowired
    ClientService clientService;


    @GetMapping ("/get/all/fault/{deviceId}")//查找设备所有关联错误
    public List<Fault> getAllFault(@PathVariable String deviceId){
        return clientService.findAllFaultByDeviceId(deviceId);//查找设备
    }


    @GetMapping ("/get/fault/{deviceId}/{faultId}")//查找设备一个关联错误
    public Fault getOneFault(@PathVariable String deviceId,@PathVariable String faultId){
        return clientService.findFaultByDeviceId(deviceId,faultId);//查找设备
    }


    @GetMapping ("/get/all/person/{deviceId}")//查找设备所有关联信息
    public List<Person> getAllPersonByDeviceId(@PathVariable String deviceId){//根据错误信息查找人
        return clientService.findPersonByDeviceId(deviceId);//查找设备
    }



    @PostMapping("/get/participle/fault/{deviceId}")//分词查询设备对应错误
    public List<Fault> getParticipleFaultByDeviceId(@PathVariable String deviceId,
                                                     @RequestParam String description){//根据错误信息查找人
        return clientService.findFaultByParticiple(deviceId,description);//查找设备
    }


    //查找所有设备





}
