package com.rafaelsouza.worshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsouza.worshopmongo.domain.Post;
import com.rafaelsouza.worshopmongo.resources.util.URL;
import com.rafaelsouza.worshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		List<Post> post = postService.findAll();		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);	
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping("/title")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {		
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);		
		return ResponseEntity.ok().body(list);
	}
	
	
}
