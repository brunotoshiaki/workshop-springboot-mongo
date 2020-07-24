package br.com.toshiakibruno.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.toshiakibruno.workshopmongo.domain.Post;
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
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Retorna o usuário por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findbyId(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

		
	@ApiOperation(value = "Insere um novo usuário")
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Retorna o usuário por id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDTO> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza o usuario")
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@ApiOperation(value = "Retorna os pots de um usuário")
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findbyPosts(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPost());
	}

}
