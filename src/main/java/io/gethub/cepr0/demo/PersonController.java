package io.gethub.cepr0.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
	public PersonController(PersonRepo repo) {
		super(repo);
	}
}
