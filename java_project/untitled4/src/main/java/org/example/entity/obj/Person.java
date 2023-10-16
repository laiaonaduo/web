package org.example.entity.obj;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity(label="Person")
@ToString
public class Person {

    @Id
    @GeneratedValue
    private Long nodeId;

    @Property
    private String personId;//人员id
    @Property
    private String name;//姓名

    @Property
    private int age;//年龄

    @Property
    private String phone;//电话

    @Property
    private int gender;//性别




}
