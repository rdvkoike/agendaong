package br.com.koike.agendaong;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.koike.agendaong.entity.User;
import br.com.koike.agendaong.repository.UserRepository;
import br.com.koike.agendaong.service.UserService;
/**
 * nao terminado!!! terminar
 * @author koike
 *
 */
@SpringBootTest
public class UserServiceTest {
	@MockBean
    private UserRepository UserRepository;
	
	@Test
	void getAllUsers(){
	    User UserSample = new User("User Sample 1","1111");
	    UserRepository.save(UserSample);
	    UserService UserService = new UserService(UserRepository);

	   // List<User> UserList = UserService.findAll(); 
	    //User lastUser = UserList.get(UserList.size()-1);

//	    assertEquals(UserSample.getLogin(), lastUser.getLogin());
	//    assertEquals(UserSample.getEmail(), lastUser.getEmail());
	  //  assertEquals(UserSample.getId(), lastUser.getId());
	}
}
