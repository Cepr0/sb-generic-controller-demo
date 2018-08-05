package io.gethub.cepr0.demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Person(String name) {
		this.name = name;
	}
}
