package br.com.toshiakibruno.workshopmongo.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User implements Serializable {

	private static final long serialVersionUID = 1L; 
    @EqualsAndHashCode.Exclude @ToString.Exclude private String id;
	private String name;
	private String email;

}
