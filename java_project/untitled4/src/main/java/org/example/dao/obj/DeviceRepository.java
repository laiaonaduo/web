package org.example.dao.obj;

import org.example.entity.obj.Device;
import org.example.entity.obj.Fault;
import org.example.entity.obj.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DeviceRepository extends Neo4jRepository<Device,Long> {


    @Query("MATCH(a:Device) WHERE a.DeviceId={DeviceId} RETURN a")
    Device findByDeviceId(@Param(value = "DeviceId") String deviceId);


    @Query("MATCH (fromNode:Device)-[:FAULTCODE]->(toNode:Fault)WHERE fromNode.DeviceId = {DeviceId} RETURN toNode")
    List<Fault> findFaultByDeviceId(@Param(value = "DeviceId") String deviceId);//根据deviceId查找所有错误


    @Query("MATCH (fromNode:Device)-[r:FAULTCODE]->(toNode:Fault)WHERE fromNode.DeviceId = {DeviceId} AND r.faultId={faultId} RETURN toNode")
    Fault findOneFaultByDeviceId(@Param(value = "DeviceId") String deviceId,@Param(value = "faultId") String faultId);//根据deviceId和faultId查找


    @Query("MATCH (fromNode:Device)-[r:FIXED]->(toNode:Person)WHERE fromNode.DeviceId = {DeviceId} RETURN toNode")
    List<Person> findAllPersonByDeviceId(@Param(value = "DeviceId") String deviceId);//根据deviceId和faultId查找


    @Query("MATCH (fromNode:Device)-[r:FAULTCODE]->(toNode:Fault)" +
            "WHERE fromNode.DeviceId = {DeviceId} AND r.describe CONTAINS {key} "+
            " RETURN toNode")
    List<Fault> findDeviceParticipleByDeviceId(@Param(value = "DeviceId") String deviceId,
                                                @Param(value = "key")String key);//根据deviceId和faultId查找


    @Query(" MATCH (device:Device)-[r]-() WHERE device.deviceId={deviceId} DELETE device,r")
    void deleteByDeviceId(@Param(value = "deviceId") String deviceId);//根据deviceId删除节点


    @Query(" MATCH (device:Device) return device order by device.createTime desc skip {pageId} limit{number}")
    List<Device> findByPage(@Param(value = "pageId") int pageId,@Param(value = "number") int number);//前面是页码，后面是分页个数


}
