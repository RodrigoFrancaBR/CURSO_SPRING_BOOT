package br.com.franca.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	private UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuarioEncontrado = repository.findByUsername(username);
		if (usuarioEncontrado != null) {
			return usuarioEncontrado;
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}

	}

}
