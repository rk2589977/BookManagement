package bookapplication.bookmanagementapplication.service;

import bookapplication.bookmanagementapplication.entity.Book;
import bookapplication.bookmanagementapplication.repositery.BookRepositery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    BookRepositery bookRepositery;

    public BookServiceImpl(BookRepositery bookRepositery) {
        this.bookRepositery = bookRepositery;
    }

    @Override
    public Book addBok(Book book) {
        return bookRepositery.save(book);
    }

    @Override
    public Book getBookByName(String name) {
        Book getBook= bookRepositery.findBookByTitle(name);
        log.info("getBookByName :: "+getBook);
        return getBook;
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        // find karna hona phele and then update karna hoga

        // this is the one way of doing
        //find bby id optional return karta hai isliye else throw se handle karte hai usko
        Book getBook=bookRepositery.findById(id)
                .orElseThrow( ()-> new RuntimeException("Book not found with the id: " + id));
        getBook.setId(id);
        getBook.setTitle(book.getTitle());
        getBook.setAuthor(book.getAuthor());
        getBook.setGenre(book.getGenre());

        Book updateBook= bookRepositery.save(getBook);
        return updateBook;
    }

    @Override
    public Book deleteBook(Integer id) {
        Book deleteBook=bookRepositery.findById(id).orElseThrow( ()-> new RuntimeException("Book not found with the id: " + id));
        bookRepositery.deleteById(id);
        return deleteBook;
    }


}
