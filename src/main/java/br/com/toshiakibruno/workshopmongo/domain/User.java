package br.com.toshiakibruno.workshopmongo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L; 

	@Id
	@EqualsAndHashCode.Exclude @ToString.Exclude private String id;
	private String name;
	private String email;

}
