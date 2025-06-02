package bookapplication.bookmanagementapplication.service;

import bookapplication.bookmanagementapplication.entity.Book;

public interface BookService {
    Book addBok(Book book);

    Book getBookByName(String name);

    Book updateBook(Integer id,Book book);

    Book deleteBook(Integer id);
}
