package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Blog;
import com.zensar.service.BlogService;

@RestController
@RequestMapping("/blogapp")
@CrossOrigin(origins = "*")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping(value = "/blog", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Blog createNewBlog(@RequestBody Blog blog) {
		return blogService.createNewBlog(blog);
	}
	
	@DeleteMapping(value = "/blog/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public boolean deleteBlogPostedById(@PathVariable("id") int id) {
		return blogService.deleteBlogPostedById(id);
	}
	
	@PutMapping(value = "/blog/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Blog updateBlogPostedById(@PathVariable("id") int id, @RequestBody Blog blog) {
		return blogService.updateBlog(id, blog);
	}
	
	@GetMapping(value = "/blog/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Blog getBlogPostedById(@PathVariable("id") int id) {
		return blogService.getBlogPostedById(id);
	}
	
}
