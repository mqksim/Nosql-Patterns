package nosql.product.mongo;


import nosql.product.sql.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "category")
public class CategoryM {
    @Id
    private String id;

    @Field(name = "categoryName")
    private String categoryName;

    @Field(name = "description")
    private String description;

    public CategoryM() {
    }

    public CategoryM(Category c) {
        this.categoryName = c.getCategoryName();
        this.description = c.getDescription();
    }

    public CategoryM(String category_name, String description) {
        this.categoryName = category_name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
