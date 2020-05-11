package br.com.koike.agendaong.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.koike.agendaong.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 @Query(value = "SELECT i FROM User i WHERE flagAtivo = 1")
	 List<User> findAllButActive();

	 List<User> findAllByEmail(String email);
	 
	 Optional<User> findByUsername(String username);
	 
	 
}
