package bookapplication.bookmanagementapplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    private String genre;
}
