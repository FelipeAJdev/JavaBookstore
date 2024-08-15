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

import com.jbs.javabookstore.model.Loan;
import com.jbs.javabookstore.repository.LoanRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loans")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping
    public ResponseEntity<List<Loan>> getAll() {
        return ResponseEntity.ok(loanRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getById(@PathVariable Long id) {
        return loanRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Loan>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(loanRepository.findAllByStatusContainingIgnoreCase(status));
    }

    @PostMapping
    public ResponseEntity<Loan> post(@Valid @RequestBody Loan loan) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(loanRepository.save(loan));
    }

    @PutMapping
    public ResponseEntity<Loan> put(@Valid @RequestBody Loan loan) {
        return loanRepository.findById(loan.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(loanRepository.save(loan)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Loan> loan = loanRepository.findById(id);

        if (loan.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        loanRepository.deleteById(id);
    }
}
