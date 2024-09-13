//package com.jbs.javabookstore.security;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.jbs.javabookstore.model.User;
//import com.jbs.javabookstore.repository.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findByEmail(email);
//
//		if (user.isPresent())
//			return new UserDetailsImpl(user.get());
//		else
//			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário não encontrado");
//	}
//}
