package org.zerock.boot_G.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.boot_G.entity.BuilderVO;
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
	
	@GetMapping("/build")
	public String testBuilder(Model model) {
		BuilderVO a = BuilderVO.builder()			//builder 패턴을 사용하여 선언
							.id("아이디")
							//.name(null)  기본값 셋팅
							.age(10)
							.item(Arrays.asList("AA","BB"))
							.singularItem("test1")
							.singularItem("test2")
							.singularItem(Arrays.asList("testA","testB"))
							.singularItem(Arrays.asList("testC","testD"))
							//collection<String> 형태로 넣으려면, Arrays.asList()를 활용하여야한다.
							.build();
		System.err.println(a.toString()); //@ToString 결과
		
		BuilderVO b = a.builder().id("Identify").age(35)
							.singularItem("testE").build();
		System.out.println(b.toString());	//a 객체를 일부 수정
		
		model.addAttribute("buildA", a);
		model.addAttribute("buildB", b);
		
		return "/build";
	}
}
