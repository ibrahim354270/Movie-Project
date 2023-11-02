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
    private LanguageName name;
    @OneToMany(mappedBy = "language",cascade = CascadeType.ALL,fetch = FetchType.EAGER)//language fieldı oludğu classdan set edilecek,bu tablo silinice değerleri null olunaca,bu tablodan bir data çağırılınca ona bağlı olanlardan gelebilsin
    private List<Film> filmList=new ArrayList<>();

}
