package org.example.service;


import org.example.dao.obj.DeviceRepository;
import org.example.dao.obj.FaultRepository;
import org.example.dao.obj.PersonRepository;
import org.example.dao.relation.FaultCodeRepository;
import org.example.dao.relation.FixRepository;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.example.fuction.JieBa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClientService {//客户类可以进行各种查找工作


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DeviceRepository deviceRepository;


    @Autowired
    private FixRepository fixRepository;



    @Autowired
    private FaultRepository faultRepository;
    @Autowired
    private FaultCodeRepository faultCodeRepository;



    public List<Fault> findAllFaultByDeviceId(String deviceId){//查找对应的人

        return deviceRepository.findFaultByDeviceId(deviceId);//返回值
    }


    public Fault findFaultByDeviceId(String deviceId,String faultId){//查找对应的一个错误

        return deviceRepository.findOneFaultByDeviceId(deviceId,faultId);
    }


    public List<Person> findPersonByDeviceId(String deviceId){//找到负责维护这个设备的所有人

        return deviceRepository.findAllPersonByDeviceId(deviceId);
    }



    public List<Fault> findFaultByParticiple(String deviceId,String description){//找到负责维护这个设备的所有人

        List<String> descriptions= JieBa.participle(description);//描述
        List<Fault> faultList1=new ArrayList<>();

        List<Fault> faultList2=new ArrayList<>();

        for (String value : descriptions) {
            String s = (String) value;
            faultList2=deviceRepository.findDeviceParticipleByDeviceId(deviceId,s);//分词查询
            faultList1=Stream.concat(faultList1.stream(), faultList2.stream())
                    .distinct()
                    .collect(Collectors.toList());//合并然后查询
        }
        return faultList1;

    }




}
