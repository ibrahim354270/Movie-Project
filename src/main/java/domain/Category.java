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


    public Integer getCategoryId() {
        return categoryId;
    }

 //   public void setCategoryId(Integer categoryId) {
 //       this.categoryId = categoryId;
 //   }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryType=" + categoryType +
                '}';
    }
}
