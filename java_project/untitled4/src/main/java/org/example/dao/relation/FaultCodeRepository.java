package org.example.dao.relation;


import org.example.entity.relation.FaultCode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FaultCodeRepository extends Neo4jRepository<FaultCode,Long> {


    @Query("MATCH (Device) WHERE id(deviceId) = {fromId} MATCH (Fault) WHERE id(toNode) = {toId} MATCH (fromNode)-[r]->(toNode) DELETE r")

    void deleteByNodeId(@Param(value = "fromId") String fromId, @Param(value = "toId") long toId);




}
