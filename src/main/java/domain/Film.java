package domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmID;
    @Column(length = 50, nullable = false)
    private String title;
    private Integer relaseYear;
    @Column(name = "imdb_score", precision = 3, scale = 1)
    //precision, toplam basamak sayısını, scale ise ondalık basamak sayısını belirtir.
    private Double imdbScore;
    private Integer length;
    private LocalDateTime lastUpdate;//sisteme eklendiği tarih-prepersist
    @ManyToOne
    @JoinColumn
    private Language language;
    @ManyToMany
    @JoinTable(name = "film_actor",//3.oluşacak tablonun adı
              joinColumns = {@JoinColumn(name = "film_id")},//tablo adı
              inverseJoinColumns = {@JoinColumn(name = "actor_id")})//bağlantılı tablo
    private List<Actor> actorList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)//film gelice categorylerde onunla geldin
    @JoinTable(name = "film_category",//3.oluşacak tablonun adı
            joinColumns = {@JoinColumn(name = "film_id")},//tablo adı
            inverseJoinColumns = {@JoinColumn(name = "category_id")})//bağlantılı tablo
    private List<Category> categoryList = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.lastUpdate = LocalDateTime.now();
    }

    public Film() {
    }

    public Film(String title, Integer relaseYear, Double imdbScore, Integer length, Language language, List<Actor> actorList) {
        this.title = title;
        this.relaseYear = relaseYear;
        this.imdbScore = imdbScore;
        this.length = length;
        this.language = language;
        this.actorList = actorList;
    }

    public Long getFilmID() {
        return filmID;
    }

    // public void setFilmID(Long filmID) {
    //     this.filmID = filmID;
    // }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRelaseYear() {
        return relaseYear;
    }

    public void setRelaseYear(Integer relaseYear) {
        this.relaseYear = relaseYear;
    }

    public Double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(Double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmID=" + filmID +
                ", title='" + title + '\'' +
                ", relaseYear=" + relaseYear +
                ", imdbScore=" + imdbScore +
                ", length=" + length +
                ", lastUpdate=" + lastUpdate +
                ", language=" + language +
                ", actorList=" + actorList +
                ", categoryList=" + categoryList +
                '}';
    }
}


// Select * from film joın actor on film
