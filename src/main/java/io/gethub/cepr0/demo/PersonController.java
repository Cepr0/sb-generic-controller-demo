package io.gethub.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController extends AbstractController<Person> {
	public PersonController(JpaRepository<Person, Long> repo) {
		super(repo);
	}
}
