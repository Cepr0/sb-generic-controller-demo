package io.gethub.cepr0.demo;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T> {

	protected final JpaRepository<T, Long> repo;

	public AbstractController(JpaRepository<T, Long> repo) {
		this.repo = repo;
	}

	@GetMapping
	public List<T> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public T create(@RequestBody T entity) {
		return repo.save(entity);
	}

	@PatchMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody T source) {
		return repo.findById(id)
				.map(target -> { BeanUtils.copyProperties(source, target, "id"); return target; })
				.map(repo::save)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		return repo.findById(id)
				.map(entity -> { repo.delete(entity); return entity; })
				.map(t -> ResponseEntity.noContent().build())
				.orElse(ResponseEntity.notFound().build());
	}
}
