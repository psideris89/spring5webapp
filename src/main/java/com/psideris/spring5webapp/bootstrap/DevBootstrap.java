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

		Author jim = new Author("Jim", "Hendrix");
		Book guitarBok = new Book("Pure guitar", "1234", "Emma Stone");
		jim.getBooks().add(guitarBok);
		guitarBok.getAuthors().add(jim);

		authorRepository.save(jim);
		bookRepository.save(guitarBok);

		Author kurt = new Author("Kurt", "Cobain");
		Book drumsBook = new Book("The biography", "10001", "Emma Watshon");
		kurt.getBooks().add(drumsBook);

		authorRepository.save(kurt);
		bookRepository.save(drumsBook);
	}
	

}
