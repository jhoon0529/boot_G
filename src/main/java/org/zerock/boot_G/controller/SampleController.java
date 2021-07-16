package org.zerock.boot_G.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.boot_G.entity.TestVo;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/test")
@Log4j2
public class SampleController {
	

	@GetMapping("/p01")
	public String p01() {
		log.info("Test.....");
		
		return "thymeleaf/p01";  //서비스 실행 후 보여주는 views
	}
	
	@GetMapping("/thymeleafTest")
	public String thymeleafTest(Model model) {
		log.info("Test...........................");
		TestVo testModel = new TestVo("ThymeLeaf", "테스트") ;
		model.addAttribute("testModel", testModel);
		System.err.println("Thymeleaf 실행");

		return "thymeleaf/thymeleafTest"; //경로설정 application.properties
	}
	
	@GetMapping("/home")
	public String testJsp() {
		System.err.println("JSP 실행");
		
		return "home"; //경로설정 application.properties
		
	}
}
