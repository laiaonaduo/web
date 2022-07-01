package Dao;

import domain.Student;
import domain.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamDao {

    int insertTeam(Team team);//插入一个队伍

    Team select_team_ById(@Param("TeamId") Integer id);//查找一个队伍

    List<Team> select_team();//查找整个队伍




}
