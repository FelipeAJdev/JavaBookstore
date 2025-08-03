# 📚 Spring Bookstore Management - Sistema de Livraria

## 🎯 Objetivo de Aprendizado
Projeto desenvolvido para estudar **Spring Boot** e **gerenciamento de recursos**, implementando um sistema completo de livraria com CRUD de livros, empréstimos, autenticação JWT e documentação Swagger.

## 🛠️ Tecnologias Utilizadas
- **Framework:** Spring Boot, Spring Security, Spring Data JPA
- **Linguagem:** Java 11+
- **Banco de Dados:** MySQL (dev), PostgreSQL (prod)
- **Autenticação:** JWT (JSON Web Tokens)
- **Documentação:** Swagger/OpenAPI
- **Testes:** JUnit 5
- **ORM:** Hibernate/JPA
- **Conceitos estudados:**
  - Spring Boot REST APIs
  - JPA repositories e queries customizadas
  - Spring Security com JWT
  - Swagger documentation
  - Testes unitários
  - Deploy em cloud

## 🚀 Demonstração
```java
// Repository com query customizada
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // SELECT * FROM tb_books WHERE title LIKE "%title%";
    List<Book> findAllByTitleContainingIgnoreCase(@Param("title") String title);
}

// Controller REST
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
    
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookRepository.findAllByTitleContainingIgnoreCase(title));
    }
    
    @PostMapping
    public ResponseEntity<Book> post(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(bookRepository.save(book));
    }
}
```

## 💡 Principais Aprendizados

### 📖 Gerenciamento de Recursos
- **CRUD Completo:** Livros, usuários e empréstimos
- **Relacionamentos:** @OneToMany, @ManyToOne entre entidades
- **Validações:** Bean Validation com @Valid
- **Queries Customizadas:** Métodos derivados do JPA

### 🔐 Segurança e Autenticação
- **Spring Security:** Configuração de segurança
- **JWT:** Tokens para autenticação stateless
- **Autorização:** Controle de acesso por roles
- **CORS:** Configuração para frontend

### 📊 Persistência de Dados
- **JPA/Hibernate:** Mapeamento objeto-relacional
- **Repository Pattern:** Abstração de acesso a dados
- **Transactions:** Gerenciamento de transações
- **Database Migration:** Controle de schema

## 🧠 Conceitos Técnicos Estudados

### 1. **Entidades JPA**
```java
@Entity
@Table(name = "tb_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 2, max = 100)
    private String title;
    
    @NotBlank(message = "O autor é obrigatório")
    private String author;
    
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    
    @Column(name = "available")
    private Boolean available = true;
    
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<Loan> loans = new ArrayList<>();
}
```

### 2. **Repository com Queries Customizadas**
```java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Query method derivado
    List<Book> findAllByTitleContainingIgnoreCase(@Param("title") String title);
    
    // Query customizada com @Query
    @Query("SELECT b FROM Book b WHERE b.available = true")
    List<Book> findAvailableBooks();
    
    // Query nativa
    @Query(value = "SELECT * FROM tb_books WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Book> findBooksByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
}
```

### 3. **Sistema de Empréstimos**
```java
@Entity
@Table(name = "tb_loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("loans")
    private Book book;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("loans")
    private User user;
    
    @Column(name = "loan_date")
    private LocalDate loanDate;
    
    @Column(name = "return_date")
    private LocalDate returnDate;
    
    @Column(name = "returned")
    private Boolean returned = false;
}
```

## 📁 Estrutura do Projeto
```
spring-bookstore-management/
├── src/main/java/
│   └── com/jbs/javabookstore/
│       ├── controller/          # Controllers REST
│       ├── model/              # Entidades JPA
│       ├── repository/         # Repositórios de dados
│       ├── service/            # Serviços de negócio
│       ├── security/           # Configurações de segurança
│       └── JavaBookstoreApplication.java
├── src/main/resources/
│   ├── application.properties  # Configurações
│   └── data.sql               # Dados iniciais
├── src/test/java/             # Testes unitários
└── target/                    # Build artifacts
```

## 🔧 Como Executar

### Pré-requisitos
- Java 11+
- Maven 3.6+
- MySQL (desenvolvimento)

### Passos
```bash
# Clone o repositório
git clone <repo-url>
cd spring-bookstore-management

# Configure o banco no application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_bookstore
spring.datasource.username=root
spring.datasource.password=root

# Execute a aplicação
mvn spring-boot:run

# Acesse a documentação Swagger
http://localhost:8080/swagger-ui.html
```

## 📊 Funcionalidades Implementadas
- ✅ **CRUD de Livros** com busca por título
- ✅ **Sistema de Empréstimos** com controle de devolução
- ✅ **Gerenciamento de Usuários** com autenticação
- ✅ **Autenticação JWT** para segurança
- ✅ **Documentação Swagger** completa
- ✅ **Validações** de dados de entrada
- ✅ **Testes unitários** com JUnit

## 🚧 Desafios Enfrentados
1. **Relacionamentos JPA:** Mapeamento correto entre entidades
2. **Spring Security:** Configuração de JWT e CORS
3. **Queries Customizadas:** Implementação de buscas específicas
4. **Validações:** Bean Validation e tratamento de erros
5. **Testes:** Setup de ambiente de teste
6. **Deploy:** Configuração para produção

## 📚 Recursos Utilizados
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Reference](https://spring.io/projects/spring-data-jpa)
- [Spring Security Guide](https://spring.io/projects/spring-security)
- [Swagger/OpenAPI](https://swagger.io/docs/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

## 📈 Próximos Passos
- [ ] Implementar sistema de reservas
- [ ] Adicionar notificações por email
- [ ] Criar relatórios de empréstimos
- [ ] Implementar multas por atraso
- [ ] Adicionar categorias de livros
- [ ] Melhorar cobertura de testes

## 🔗 Projetos Relacionados
- [Spring Blog Platform](../spring-blog-platform/) - Outro projeto Spring Boot
- [Spring E-commerce](../spring-ecommerce-tt/) - E-commerce com Spring
- [Java Generation Notes](../java-generation-notes/) - Base de estudos Java

---

**Desenvolvido por:** Felipe Macedo  
**Contato:** contato.dev.macedo@gmail.com  
**GitHub:** [FelipeMacedo](https://github.com/felipemacedo1)  
**LinkedIn:** [felipemacedo1](https://linkedin.com/in/felipemacedo1)

> 💡 **Reflexão:** Este projeto aprofundou meus conhecimentos em Spring Boot e gerenciamento de recursos. A implementação de um sistema de empréstimos consolidou conceitos de relacionamentos JPA e regras de negócio complexas.