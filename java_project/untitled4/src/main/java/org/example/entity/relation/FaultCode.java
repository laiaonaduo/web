package org.example.entity.relation;


import lombok.Data;
import org.example.entity.obj.Device;
import org.example.entity.obj.Fault;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity
@Data
public class FaultCode {//错误代码类，表明设备的错误类型


    @Id
    @GeneratedValue
    private Long nodeId;


    @Property
    private String faultId;//故障id，自己编码对故障进行决定

    @StartNode
    private Device from;//开始节点

    @EndNode
    private Fault to;//结束节点



}
