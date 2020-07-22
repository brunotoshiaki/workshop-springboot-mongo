package br.com.toshiakibruno.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.toshiakibruno.workshopmongo.domain.User;
import br.com.toshiakibruno.workshopmongo.dto.UserDTO;
import br.com.toshiakibruno.workshopmongo.services.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Lista todos os usuários")
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO>listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value = "Retorna o usuário por id")
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findbyId(@PathVariable String id) {
	    User obj = service.findById(id);
	    return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	
}
