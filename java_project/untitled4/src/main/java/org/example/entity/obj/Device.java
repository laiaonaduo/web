package org.example.entity.obj;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@Data
@NodeEntity
public class Device {//设备类

    @Id
    @GeneratedValue
    private Long nodeId;//节点id


    @Property
    private String DeviceId;//设备的id，用来索引设备，和企业设备id对接


    @Property
    private String name;//设备名字





}
