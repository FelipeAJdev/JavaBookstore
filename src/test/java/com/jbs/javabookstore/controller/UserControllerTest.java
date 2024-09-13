//package com.jbs.javabookstore.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.jbs.javabookstore.model.User;
//import com.jbs.javabookstore.repository.UserRepository;
//import com.jbs.javabookstore.service.UserService;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class UserControllerTest {
//
//	@Autowired
//	private TestRestTemplate testRestTemplate;
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@BeforeAll
//	void start() {
//		userRepository.deleteAll();
//
//		userService.registerUser(new User(0L, "Root", "root@root.com", "rootroot", "-"));
//	}
//
//	@Test
//	@DisplayName("Cadastrar Um Usuário")
//	public void deveCriarUmUsuario() {
//		User user = new User(0L, "Paulo Antunes", "paulo_antunes@email.com.br", "13465278", "-");
//		ResponseEntity<User> response = testRestTemplate.postForEntity("/users", user, User.class);
//
//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
//	}
//
//	@Test
//	@DisplayName("Não deve permitir duplicação do Usuário")
//	public void naoDeveDuplicarUsuario() {
//		userService.registerUser(new User(0L, "Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));
//
//		User duplicateUser = new User(0L, "Maria da Silva", "maria_silva@email.com.br", "13465278", "-");
//		ResponseEntity<User> response = testRestTemplate.postForEntity("/users", duplicateUser, User.class);
//
//		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//	}
//
//	@Test
//	@DisplayName("Atualizar um Usuário")
//	public void deveAtualizarUmUsuario() {
//		Optional<User> registeredUser = userService.registerUser(new User(0L, "Juliana Andrews", "juliana_andrews@email.com.br", "juliana123", "-"));
//
//		User userUpdate = new User(registeredUser.get().getId(), "Juliana Andrews Ramos", "juliana_ramos@email.com.br", "juliana123", "-");
//
//		HttpEntity<User> requestEntity = new HttpEntity<>(userUpdate);
//		ResponseEntity<User> response = testRestTemplate
//				.withBasicAuth("root@root.com", "rootroot")
//				.exchange("/users", HttpMethod.PUT, requestEntity, User.class);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//
//	@Test
//	@DisplayName("Listar todos os Usuários")
//	public void deveMostrarTodosUsuarios() {
//		userService.registerUser(new User(0L, "Sabrina Sanches", "sabrina_sanches@email.com.br", "sabrina123", "-"));
//		userService.registerUser(new User(0L, "Ricardo Marques", "ricardo_marques@email.com.br", "ricardo123", "-"));
//
//		ResponseEntity<String> response = testRestTemplate
//				.withBasicAuth("root@root.com", "rootroot")
//				.exchange("/users", HttpMethod.GET, null, String.class);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//}
