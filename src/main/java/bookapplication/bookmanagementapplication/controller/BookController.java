package bookapplication.bookmanagementapplication.controller;

import bookapplication.bookmanagementapplication.entity.Book;
import bookapplication.bookmanagementapplication.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book/v1")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book saveBook =bookService.addBok(book);
        return ResponseEntity.ok(saveBook);
    }

    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String bookName){
        final Book savedBook = bookService.getBookByName(bookName);
        log.info("getBookByName returned book : {}",savedBook);
        return ResponseEntity.ok(savedBook);
    }

    // to update the book we need to take the put mapping

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id ,@RequestBody Book book){
        Book bookUpdated=bookService.updateBook(id,book);
        return ResponseEntity.ok(bookUpdated);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id){
        Book bookdeleted=bookService.deleteBook(id);
        return ResponseEntity.ok(bookdeleted);
    }




}
