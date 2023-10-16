package org.example.service;


import org.example.dao.obj.DeviceRepository;
import org.example.dao.obj.FaultRepository;
import org.example.dao.obj.PersonRepository;
import org.example.dao.relation.FaultCodeRepository;
import org.example.dao.relation.FaultCodedRepository;
import org.example.dao.relation.FixRepository;
import org.example.dao.relation.FixedRepository;
import org.example.entity.obj.Device;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.example.entity.relation.FaultCode;
import org.example.entity.relation.FaultCoded;
import org.example.entity.relation.Fix;
import org.example.entity.relation.Fixed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DeviceRepository deviceRepository;


    @Autowired
    private FixRepository fixRepository;

    @Autowired
    private FixedRepository fixedRepository;

    @Autowired
    private FaultRepository faultRepository;
    @Autowired
    private FaultCodeRepository faultCodeRepository;

    @Autowired
    private FaultCodedRepository faultCodedRepository;

    public void addPersonFix(String personId,String deviceId,String faultId) {//增加一个人维修的设备
        Device device = deviceRepository.findByDeviceId(deviceId);
        Person person=personRepository.findByPersonId(personId);
        Fix fix=new Fix();
        fix.setFrom(person);
        fix.setTo(device);
        fix.setFaultId(faultId);//可以维修哪种错误

        Fixed fixed=new Fixed();
        fixed.setFrom(device);
        fixed.setTo(person);

        fixedRepository.save(fixed);
        fixRepository.save(fix);//保存这两种关系
    }


    public void addFault(String deviceId,String faultId,Fault fault) {//增加一个设备对应的错误

        Device device = deviceRepository.findByDeviceId(deviceId);
        faultRepository.save(fault);//先插入这个错误

        FaultCode faultCode=new FaultCode();
        faultCode.setFrom(device);
        faultCode.setTo(fault);
        faultCode.setFaultId(faultId);//

        FaultCoded faultCoded=new FaultCoded();
        faultCoded.setFrom(fault);
        faultCoded.setTo(device);
        faultCoded.setFaultId(faultId);//

        faultCodeRepository.save(faultCode);//然后保存这个关系
        faultCodedRepository.save(faultCoded);

    }
    public Fault modifyFault(Fault fault){
        return faultRepository.save(fault);//修改错误
    }



}
