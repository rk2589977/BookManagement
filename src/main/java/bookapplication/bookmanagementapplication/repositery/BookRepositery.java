package bookapplication.bookmanagementapplication.repositery;

import bookapplication.bookmanagementapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositery extends JpaRepository<Book, Integer> {


    public Book findBookByTitle(String title);

}
