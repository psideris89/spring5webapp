package com.psideris.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.psideris.spring5webapp.model.Author;
import com.psideris.spring5webapp.model.Book;
import com.psideris.spring5webapp.repository.AuthorRepository;
import com.psideris.spring5webapp.repository.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}

	private void initData() {

		Author panos = new Author("Panos", "S");
		Book musicBook = new Book("My music", "1234", "Jimmy H");
		panos.getBooks().add(musicBook);
		musicBook.getAuthors().add(panos);

		authorRepository.save(panos);
		bookRepository.save(musicBook);

		Author isid = new Author("Isid", "S");
		Book physicsBook = new Book("Universe", "10001", "Albert E");
		isid.getBooks().add(physicsBook);
		physicsBook.getAuthors().add(isid);

		authorRepository.save(isid);
		bookRepository.save(physicsBook);
	}
	

}
