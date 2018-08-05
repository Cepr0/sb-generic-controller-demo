package io.gethub.cepr0.demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public User(String name) {
		this.name = name;
	}
}
