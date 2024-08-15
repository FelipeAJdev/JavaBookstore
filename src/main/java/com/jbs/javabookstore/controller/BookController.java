package com.jbs.javabookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jbs.javabookstore.model.Book;
import com.jbs.javabookstore.repository.BookRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public ResponseEntity<List<Book>> getAll() {
		return ResponseEntity.ok(bookRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getById(@PathVariable Long id) {
		return bookRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<List<Book>> getByTitle(@PathVariable String title) {
		return ResponseEntity.ok(bookRepository.findAllByTitleContainingIgnoreCase(title));
	}

	@PostMapping
	public ResponseEntity<Book> post(@Valid @RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(bookRepository.save(book));
	}

	@PutMapping
	public ResponseEntity<Book> put(@Valid @RequestBody Book book) {
		return bookRepository.findById(book.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(bookRepository.save(book)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Book> book = bookRepository.findById(id);

		if (book.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		bookRepository.deleteById(id);
	}
}
