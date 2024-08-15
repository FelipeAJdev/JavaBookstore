package com.jbs.javabookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jbs.javabookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	// SELECT * FROM tb_books WHERE title LIKE "%title%";
	public List<Book> findAllByTitleContainingIgnoreCase(@Param("title") String title);
}
