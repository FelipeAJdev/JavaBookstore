package com.jbs.javabookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jbs.javabookstore.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Query equivalente ao código abaixo: SELECT * FROM tb_loans WHERE status LIKE "%status%";
    public List<Loan> findAllByStatusContainingIgnoreCase(@Param("status") String status);
}
