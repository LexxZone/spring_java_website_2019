package ru.stateofmind.javaspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.stateofmind.javaspringblog.service.impl.MemPostService;

@Controller
public class PostController {

	private final MemPostService memPostService;

	public PostController(MemPostService memPostService) {
		this.memPostService = memPostService;
	}

	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("posts", memPostService.search());
		return "hello";
	}
}
