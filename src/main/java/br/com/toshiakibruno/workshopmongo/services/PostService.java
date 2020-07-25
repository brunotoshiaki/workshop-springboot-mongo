package br.com.toshiakibruno.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.toshiakibruno.workshopmongo.domain.Post;
import br.com.toshiakibruno.workshopmongo.repository.PostRepository;
import br.com.toshiakibruno.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text);
	}

	/**
	 * Buscar posts contendo um dado string em qualquer lugar (no título, corpo ou
	 * comentários) e em um dado intervalo de datas"
	 * 
	 * @param text    Texto
	 * @param minDate Data minima
	 * @param maxDate Data maxima
	 * @return
	 */

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		// pega ate as 24h do dia seguinte
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

		return repo.fullSearch(text, minDate, maxDate);
	}

}
