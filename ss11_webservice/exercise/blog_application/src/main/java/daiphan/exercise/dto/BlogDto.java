package daiphan.exercise.dto;

public class BlogDto {

    private String title;
    private String categoryName;

    public BlogDto() {
    }

    public BlogDto( String title, String categoryName) {
        this.title = title;
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
