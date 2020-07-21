package br.com.toshiakibruno.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.toshiakibruno.workshopmongo.domain.User;
import br.com.toshiakibruno.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List <User>findAll(){
		return repo.findAll();
	}
}
