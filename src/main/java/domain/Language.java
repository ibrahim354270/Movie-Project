package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer languageId;
    @Enumerated(EnumType.STRING)
    @Column(name = "language_name")
    private LanguageName name;
    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //language fieldı oludğu classdan set edilecek,bu tablo silinice değerleri null olunaca,
    // bu tablodan bir data çağırılınca ona bağlı olanlardan gelebilsin
    private List<Film> filmList = new ArrayList<>();

    public Integer getLanguageId() {
        return languageId;
    }

    //   public void setLanguageId(Integer languageId) {
    //       this.languageId = languageId;
    //   }

    public LanguageName getName() {
        return name;
    }

    public void setName(LanguageName name) {
        this.name = name;
    }

    public Language(LanguageName name) {
        this.name = name;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name=" + name +
                '}';
    }
}
