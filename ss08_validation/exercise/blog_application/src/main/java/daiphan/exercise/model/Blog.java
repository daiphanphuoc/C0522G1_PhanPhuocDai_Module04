package daiphan.exercise.model;

import daiphan.exercise.dto.BlogDto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/*@NamedNativeQuery(name = "Blog.search",
        query = "select blog.title as title, category.name_category as categoryName" +
                " from blog inner join category on category.id = blog.category_id " +
                " where blog.is_delete = 0 ", resultSetMapping = "Mapping.BlogDto")
@NamedNativeQuery(name = "Blog.search.count",
        query = "select count(*)" +
                " from blog inner join category on category.id = blog.category_id " +
                " where blog.is_delete = 0 ")
@SqlResultSetMapping(name = "Mapping.BlogDto",
        classes = @ConstructorResult(targetClass = BlogDto.class,
                columns = {@ColumnResult(name = "title"), @ColumnResult(name = "categoryName")}))*/


@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfWriting;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String title, String content, String author, Date dateOfWriting, boolean isDelete) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(Date dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}