package org.nhanvo.shopdemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Optional;

import org.nhanvo.shopdemo.model.Book;
import org.nhanvo.shopdemo.model.BookCreateForm;
import org.nhanvo.shopdemo.model.BookEditForm;
import org.nhanvo.shopdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 
 * @author nhanvo
 * Book service implement class
 * 
 */
@Service
public class BookServiceImpl implements BookService{
	// Book repository
	private final BookRepository bookRepository;
	
	/**
	 * Constructor
	 * @param bookRepository
	 */
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	/**
	 * Override from parent
	 */
	@Override
	public Optional<Book> getBookById(long id) {
		return Optional.ofNullable(bookRepository.findOne(id));
	}

	/**
	 * Override from parent
	 */
	@Override
	public Optional<Book> getBookByAuthor(String author) {		
		return bookRepository.findOneByAuthor(author);
	}

	/**
	 * Override from parent
	 */
	@Override
	public Collection<Book> getAllBooks() {
		return bookRepository.findAll(new Sort("author"));
	}	

	/**
	 * Override from parent
	 */
	@Override
	public Book create(BookCreateForm form) {
		Book book = new Book();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		book.setTitle(form.getTitle());
		book.setAuthor(form.getAuthor());
		book.setDescription(form.getDescription());		
		try {
			book.setCreatedAt(formatter.parse(form.getCreatedat()));
			book.setUpdateAt(formatter.parse(form.getUpdateat()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return bookRepository.save(book);
	}

	/**
	 * Override from parent
	 */
	@Override
	public Book editBook(BookEditForm form, Long id) {
		Book book = bookRepository.findOne(id);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		book.setTitle(form.getTitle());
		book.setAuthor(form.getAuthor());
		book.setDescription(form.getDescription());		
		try {
			book.setCreatedAt(formatter.parse(form.getCreatedat()));
			book.setUpdateAt(formatter.parse(form.getUpdateat()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return bookRepository.save(book);
	}

	/**
	 * Override from parent
	 */
	@Override
	public Boolean deleteBook(Long id) {		
		Book book = bookRepository.findOne(id);
		if (book != null) {
			bookRepository.delete(book);
			return true;
		}
		
		return false;
	}	
}
