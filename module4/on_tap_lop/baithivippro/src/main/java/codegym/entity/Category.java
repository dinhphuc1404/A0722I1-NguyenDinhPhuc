package codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    //cascade=CascadeType.ALL” và về cơ bản nó có nghĩa là bất kỳ thay đổi nào xảy ra..cũng phải xếp tầng..theo
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(Long categoryId, String categoryName, Set<Blog> blogs) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
