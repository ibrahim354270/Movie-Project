package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    private CategoryType categoryType;

    @ManyToMany(mappedBy ="categoryList" )
    private List<Film> filmList=new ArrayList<>();


}
