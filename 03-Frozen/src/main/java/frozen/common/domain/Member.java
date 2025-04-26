package frozen.common.domain;

import java.time.LocalDate;

public class Member {
    private String id;
    private String pwd;
    private String name;
    private String nickname;
    private LocalDate birth;
    private String gender;
    private boolean isAdmin;

    public Member() {
    }

    public Member(String id) {
        this.id = id;
    }

    public Member(String id, String pwd, String nickname, LocalDate birth, String gender) {
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
    }

    public Member(String id, String pwd, String name, String nickname, LocalDate birth, String gender, boolean isAdmin) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.isAdmin = isAdmin;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
