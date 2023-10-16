package org.example;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import org.example.dao.obj.DeviceRepository;
import org.example.dao.obj.FaultRepository;
import org.example.dao.obj.PersonRepository;
import org.example.dao.relation.FaultCodeRepository;
import org.example.dao.relation.FaultCodedRepository;
import org.example.dao.relation.FixRepository;
import org.example.entity.obj.Device;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.example.entity.relation.FaultCode;
import org.example.entity.relation.FaultCoded;
import org.example.entity.relation.Fix;
import org.example.fuction.JieBa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootNeo4jApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private FaultCodeRepository faultCodeRepository;

    @Autowired
    private FaultCodedRepository faultCodedRepository;

    @Autowired
    private FaultRepository faultRepository;
    @Autowired
    private FixRepository fixRepository;



    @Test
    public void createPerson() {//创建人
        Person person = new Person();
        person.setPersonId("01000001");
        person.setAge(19);
        person.setGender(0);
        person.setPhone("187****4300");
        person.setName("维修人员1");
        personRepository.save(person);//保存节点

    }


    @Test
    public void findPersonByPersonId() {//查找人
        Person person=personRepository.findByPersonId("01000001");//保存节点
        System.out.println(person);
        person.setName("维修人员22");
        personRepository.save(person);


    }

    @Test
    public void createDevice() {//创建设备
        Device device = new Device();
        device.setDeviceId("01000100");
        device.setName("大型冲压机1");



        deviceRepository.save(device);//保存节点
    }


    @Test
    public void createFault() {//创建一个错误关系
        Fault fault = new Fault();

        fault.setFaultId("AAAAI");
        fault.setDescribe("突然停止");
        fault.setReason("发生急停");
        fault.setVideo("////");
        faultRepository.save(fault);//保存节点
        Device device = deviceRepository.findByDeviceId("01000100");
        FaultCode faultCode=new FaultCode();
        faultCode.setFrom(device);
        faultCode.setTo(fault);
        faultCode.setFaultId(fault.getFaultId());//
        FaultCoded faultCoded=new FaultCoded();
        faultCoded.setFrom(fault);
        faultCoded.setTo(device);
        faultCoded.setFaultId(fault.getFaultId());//
        faultCodeRepository.save(faultCode);//然后保存这个关系
        faultCodedRepository.save(faultCoded);
    }


    @Test
    public void selectFault() {//查询错误关系

        System.out.println(deviceRepository.findFaultByDeviceId("01000100"));

    }

    @Test
    public void findDeviceByDeviceId() {//查设备根据设备id

        Device device=deviceRepository.findByDeviceId("01000100");//保存节点
        System.out.println(device);
    }

    @Test
    public void findOneDeviceByDeviceId() {//查设备根据设备id

        Fault fault=deviceRepository.findOneFaultByDeviceId("01000100","AAAAI");//保存节点
        System.out.println(fault);
    }

    @Test
    public void deletePerson(){

        personRepository.deleteByPersonId("01000001");

    }




    @Test
    public void jiebaTest(){//测试分词器


        Path path = Paths.get("src/main/resources/fkck.txt");
        WordDictionary.getInstance().loadUserDict(path);

        System.out.println(JieBa.participle("北京京天威科技发展有限公司大庆车务段的装车数量高温啊啊啊啊"));



    }


}
