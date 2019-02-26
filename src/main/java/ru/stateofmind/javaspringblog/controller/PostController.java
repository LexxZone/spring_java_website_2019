package ru.stateofmind.javaspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}
