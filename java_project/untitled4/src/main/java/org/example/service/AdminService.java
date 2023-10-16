package org.example.service;


import org.example.dao.obj.DeviceRepository;
import org.example.dao.obj.FaultRepository;
import org.example.dao.obj.PersonRepository;
import org.example.entity.obj.Device;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {//管理类

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private FaultRepository faultRepository;


    public void addPerson(Person person){//增加一个维修人员
        personRepository.save(person);
    }


    public void addDevice(Device device){//增加一个设备
        deviceRepository.save(device);
    }



    public Device getDevice(String deviceId){//增加一个设备
        return deviceRepository.findByDeviceId(deviceId);
    }//查找一个人的信息

    public Person getPerson(String personId){//增加一个设备
        return personRepository.findByPersonId(personId);
    }//查找一个设备的信息


    public Fault getFault(String faultId){//增加一个设备
        return faultRepository.findByFaultId(faultId);
    }//查找一个设备的信息



    public List<Device> getAllDevice(){//查找所有设备信息,分页查找
        return (List<Device>) deviceRepository.findAll();
    }

    public List<Person> getAllPerson(){//查找所有人信息
        return (List<Person>) personRepository.findAll();
    }
    
    public void deleteDevice(String deviceId){//删除id
        deviceRepository.delete(deviceRepository.findByDeviceId(deviceId));//删除一个
        
    }



    public List<Device> findDeviceByPage(int pageId,int number){

        List<Device> deviceList=deviceRepository.findByPage(pageId, number);
        return deviceList;//根据页码查询
    }


    public List<Person> findPersonByPage(int pageId,int number){

        List<Person> personList=personRepository.findByPage(pageId, number);
        return personList;//根据页码查询
    }


}
