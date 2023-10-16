package org.example.service.obj;


import lombok.Data;
import org.example.entity.obj.Fault;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class NewFault {

    private String deviceId;//设备


    private String faultId;

    private Fault fault;//错误





}
