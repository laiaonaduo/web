package org.example.controller;


import org.example.entity.obj.Fault;
import org.example.service.PersonService;
import org.example.service.obj.NewFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add/person/fix/device/{personId}/{deviceId}/{faultId}")//增加人修理设备
    public void addPersonDevice(@PathVariable String personId,@PathVariable String deviceId, @PathVariable String faultId){
        personService.addPersonFix(personId,deviceId,faultId);//增加一个关系，人和设备的关系
    }


    @PostMapping("/add/device/fix/fault")//增加一个关系错误，这个错误由人来增加，增加设备和错误的关系
    public void addPersonDevice(@RequestBody NewFault newFault) {//这个方法是增加
        personService.addFault(newFault.getDeviceId(), newFault.getFaultId(), newFault.getFault());
    }


    @PostMapping("/modify/fault")//修改错误
    public Fault modifyPersonDevice(@RequestBody Fault fault) {//这个方法是修改一个错误
        return personService.modifyFault(fault);
    }


    //还缺少修改一个错误，



}
