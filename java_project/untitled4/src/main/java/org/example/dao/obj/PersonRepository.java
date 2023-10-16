package org.example.dao.obj;


import org.example.entity.obj.Device;
import org.example.entity.obj.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends Neo4jRepository<Person,Long> {


    @Query("MATCH(a:Person) WHERE a.personId={personId} RETURN a")
    Person findByPersonId(@Param(value = "personId") String personId);

    @Query("MATCH (person:Person)-[r]-() WHERE person.personId={personId} DELETE person,r")
    void deleteByPersonId(@Param(value = "personId") String personId);//根据deviceId删除节点


    @Query(" MATCH (person:Person) return person order by person.createTime desc skip {pageId} limit {number}")
    List<Person> findByPage(@Param(value = "pageId") int pageId, @Param(value = "number") int number);//前面是页码，后面是分页个数


}
