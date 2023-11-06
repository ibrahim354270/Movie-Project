package domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "t_actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;
    @Column(name="full_name",nullable = false,length = 50)
    private String fullName;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private Gender gender;

    private LocalDateTime createDate;
    @ManyToMany(mappedBy = "actorList")//actorlist in olacağı classtan setleme işlemi yapılacak
    private List<Film> filmList=new ArrayList<>();

    @PrePersist
    public void prePersist(){
        this.createDate=LocalDateTime.now();
    }

    public Long getActorId() {
        return actorId;
    }

    // public void setActorId(Long actorId) {
    //     this.actorId = actorId;
    // }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public LocalDateTime getCreateDate() {
        return createDate;
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
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createDate=" + createDate +
                '}';
    }
}