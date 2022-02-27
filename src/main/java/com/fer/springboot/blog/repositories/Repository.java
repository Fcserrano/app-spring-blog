package com.fer.springboot.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fer.springboot.blog.models.Post;

public interface Repository extends JpaRepository<Post, Long>{

}
