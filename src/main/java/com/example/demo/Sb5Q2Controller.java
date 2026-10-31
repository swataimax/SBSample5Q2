package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Sb5Q2Controller {
	
	@Autowired
	Sb5Q2Repository repository;
	
	// top画面表示
	@GetMapping("/top")
	public String top(Model model) {
		return "top";
	}
	
	// 掲示板画面表示
	@GetMapping("/bbs")
	public String bbs(Model model) {
		model.addAttribute("form", new Sb5Q2Entity());
		// 投稿データ表示
		model.addAttribute("list", repository.findAllByOrderByDateDesc());
		
		List<Sb5Q2Entity> list = repository.findAllByOrderByDateDesc();
		for (Sb5Q2Entity e : list) {
//			System.out.println(e);
			System.out.println(e.getWork());
//			if (e.getWork() != null) {
			System.out.println("--");
			System.out.println(e.getWork().getClass());
			System.out.println(e.getName().getClass());
			System.out.println(e.getWork2().getClass());
			System.out.println("----");
//			}
			List<String> tmp = new ArrayList<>();
			for (String s : e.getWork()) {
				tmp.add(s);
			}
			e.setWork(tmp.toArray(new String[tmp.size()]));
//			System.out.println(e);
		}
		System.out.println();
		return "bbs";
	}
	
	// 投稿処理
	@PostMapping("/post")
	@Transactional(readOnly = false)
	public String post(
			@ModelAttribute("form") Sb5Q2Entity entity,
			Model model) {
		System.out.println(entity.getWork());
		entity.setWorkString(Arrays.toString(entity.getWork()));
		System.out.println(entity.getWorkString());
		repository.saveAndFlush(entity);
		// 投稿データ表示
		model.addAttribute("list", repository.findAllByOrderByDateDesc());
		return "bbs";
	}

}
