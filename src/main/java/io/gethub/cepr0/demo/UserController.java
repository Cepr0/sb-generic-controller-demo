package io.gethub.cepr0.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User> {
	public UserController(UserRepo repo) {
		super(repo);
	}
}
