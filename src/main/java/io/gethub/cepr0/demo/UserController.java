package io.gethub.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User> {
	public UserController(JpaRepository<User, Long> repo) {
		super(repo);
	}
}
