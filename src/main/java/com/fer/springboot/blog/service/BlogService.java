package com.fer.springboot.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fer.springboot.blog.models.Post;
import com.fer.springboot.blog.repositories.Repository;

@Service
public class BlogService implements IBlog{
	
	@Autowired
	Repository service;

	@Override
	public List<Post> findAll() {
		return service.findAll();
	}

	@Override
	public Post findById(Long id) {
		return service.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return service.save(post);
	}

	@Override
	public void deleteById(Long id) {
		service.deleteById(id);
	}

}
