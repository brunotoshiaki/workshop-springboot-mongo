package br.com.toshiakibruno.workshopmongo.dto;

import java.io.Serializable;

import br.com.toshiakibruno.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
}
