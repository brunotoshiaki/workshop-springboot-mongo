package br.com.toshiakibruno.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.toshiakibruno.workshopmongo.domain.Post;
import br.com.toshiakibruno.workshopmongo.resources.util.Util;
import br.com.toshiakibruno.workshopmongo.services.PostService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@ApiOperation(value = "Retorna o post por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findbyId(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Buscar posts contendo um dado string no título")
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findbyTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = Util.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Buscar posts contendo um dado string em qualquer lugar (no título, corpo ou comentários) e em um dado intervalo de datas")
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		text = Util.decodeParam(text);
		Date min = Util.convertDate(minDate, new Date(0L));
		Date max = Util.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

}
