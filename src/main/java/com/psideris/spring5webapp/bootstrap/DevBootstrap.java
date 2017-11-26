package com.psideris.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.psideris.spring5webapp.model.Author;
import com.psideris.spring5webapp.model.Book;
import com.psideris.spring5webapp.model.Publisher;
import com.psideris.spring5webapp.repository.AuthorRepository;
import com.psideris.spring5webapp.repository.BookRepository;
import com.psideris.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired private AuthorRepository authorRepository;
	@Autowired private BookRepository bookRepository;
	@Autowired private PublisherRepository publisherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}

	private void initData() {

		Author panos = new Author("Panos", "S");
		Publisher publisher1 = new Publisher("Mike", "attributes1");
		Book musicBook = new Book("My music", "1234", publisher1);

		panos.getBooks().add(musicBook);
		musicBook.getAuthors().add(panos);

		publisherRepository.save(publisher1);
		authorRepository.save(panos);
		bookRepository.save(musicBook);

		Author isid = new Author("Isid", "S");
		Book physicsBook = new Book("Universe", "10001", publisher1);

		isid.getBooks().add(physicsBook);
		physicsBook.getAuthors().add(isid);

		authorRepository.save(isid);
		bookRepository.save(physicsBook);
	}

}
