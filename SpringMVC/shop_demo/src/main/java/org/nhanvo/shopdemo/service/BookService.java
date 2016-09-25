package org.nhanvo.shopdemo.service;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.shopdemo.model.Book;
import org.nhanvo.shopdemo.model.BookCreateForm;
import org.nhanvo.shopdemo.model.BookEditForm;

/**
 * 
 * @author nhanvo
 * Book service interface
 */
public interface BookService {
	/**
	 * Get book by Id
	 * @param id Input id
	 * @return Return book object found
	 */
	Optional<Book> getBookById(long id);
	
	/**
	 * Get book by author
	 * @param author Author name
	 * @return Return book object found
	 */
	Optional<Book> getBookByAuthor(String author);
	
	/**
	 * Get all books
	 * @return List books object found
	 */
	Collection<Book> getAllBooks();
	
	/**
	 * Create new book
	 * @param form Book create form
	 * @return Book created
	 */
	Book create(BookCreateForm form);
	
	/**
	 * Edit information of book
	 * @param form Book Edit form
	 * @param id Id of book edited
	 * @return Book edited
	 */
	Book editBook(BookEditForm form, Long id);
	
	/**
	 * Delete book
	 * @param id Id of book need delete
	 * @return Book deleted
	 */
	Boolean deleteBook(Long id);
}
