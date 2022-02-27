package com.fer.springboot.blog.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fer.springboot.blog.models.Post;
import com.fer.springboot.blog.service.IBlog;

@Controller
public class PostController {
	@Autowired
	IBlog service;
	
	@GetMapping("/posts")
	public String getPosts(Model model, HttpServletRequest req) {
		model.addAttribute("dispositivo", req.getHeader("User-Agent"));
		model.addAttribute("titulo", "Spring Blog");
		model.addAttribute("posts", service.findAll());
		return "posts";
	}
	
	@GetMapping("/posts/{id}")
	public String postDetails(@PathVariable Long id, Model model ) {
		  model.addAttribute("post", service.findById(id));
		  model.addAttribute("titulo", "Spring Blog");
		return "postDetails";
	}
	
	@GetMapping("/newpost")
	public String getPostForm(Model model) {
		Post post = new Post();
		model.addAttribute("titulo", "Formulario - Nuevo post");
		model.addAttribute("post", post);
		return "postForm";
	}
	
	@PostMapping("/newpost")
	public String savePost(@Valid Post post, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario - Nuevo post");
			return "postForm";
		}
		post.setFecha(LocalDate.now());
		service.save(post);
		return "redirect:/posts";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/posts";
	}
	
	@GetMapping("/idError")
	public String idError(Model model) {
		model.addAttribute("titulo", "Id inexistente");
		return "idError";
	}
}
