package com.psideris.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.psideris.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
