package domain;

public class Student {


    private String name;
    private String username;
    private String password;
    private Integer is_teamleader;
    private Integer team_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIs_teamleader() {
        return is_teamleader;
    }

    public void setIs_teamleader(Integer is_teamleader) {
        this.is_teamleader = is_teamleader;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", userword='" + username + '\'' +
                ", password='" + password + '\'' +
                ", is_teamleader=" + is_teamleader +
                ", team_id=" + team_id +
                '}';
    }
}
