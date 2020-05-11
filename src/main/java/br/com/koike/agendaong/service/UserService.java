package br.com.koike.agendaong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.koike.agendaong.entity.User;
import br.com.koike.agendaong.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

    public UserService(UserRepository uRepository) {
        this.userRepository = uRepository;
    }
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
}
