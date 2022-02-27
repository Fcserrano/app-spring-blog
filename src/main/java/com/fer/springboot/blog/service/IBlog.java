package com.fer.springboot.blog.service;

import java.util.List;

import com.fer.springboot.blog.models.Post;


public interface IBlog{
	List<Post>findAll();
	Post findById(Long id);
	Post save(Post post);
	void deleteById(Long id);
}
