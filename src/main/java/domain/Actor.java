package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;
    @Column(name = "first_name", nullable = false, length = 50)
    private String Name;

    private Integer age;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @ManyToMany(mappedBy = "actorList", cascade = CascadeType.ALL)
//actorlist in olacağı classtan setleme işlemi yapılacak
    private List<Film> filmList = new ArrayList<>();


    public Actor() {
    }

    public Long getActorId() {
        return actorId;
    }

    // public void setActorId(Long actorId) {
    //     this.actorId = actorId;
    // }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
