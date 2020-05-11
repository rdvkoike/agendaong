package br.com.koike.agendaong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.koike.agendaong.entity.User;
import br.com.koike.agendaong.repository.UserRepository;
import br.com.koike.agendaong.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * nao terminado!!! terminar
 * @author koike
 *
 */

@RestController
@RequestMapping("/api/user")
@Api(value="User")
public class UserRestController {
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	
	@ApiOperation(value = "Lista de Usuários")
	@GetMapping
    public ResponseEntity<List<User>> list() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable long id ) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	
	}
	
	@ApiOperation(value = "Cria Usuários")
	@PostMapping("")
    public User save(@Valid @RequestBody User user, RedirectAttributes ra) {
        return this.userRepository.save(user);
    }
	
	 // PUT Method for Update operation
	@ApiOperation(value = "Altera Usuários")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) {
            User user= userRepository.findById(id)
            		.orElseThrow(() -> new IllegalArgumentException("ID Inválido:" + id));
            
        final User upUser = userRepository.save(userDetails);
        return ResponseEntity.ok(upUser);
    }

    // Delete
	@ApiOperation(value = "Deleta Usuários")
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(
        @PathVariable(value = "id") Long id) {
            User user= userRepository.findById(id)
            		.orElseThrow(() -> new IllegalArgumentException("ID Inválido:" + id));
            
            userRepository.delete(user);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
    }
	
}