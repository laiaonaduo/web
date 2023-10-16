package org.example.entity.obj;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity
public class Fault {

    @Id
    @GeneratedValue
    private Long nodeId;


    @Property
    private String faultId;//发生故障原因，字符串描述符号
    @Property
    private String reason;//发生故障原因，字符串描述符号
    @Property
    private String video;//维修视频地址

    @Property
    private String describe;//故障描述,方便用户搜索



}
