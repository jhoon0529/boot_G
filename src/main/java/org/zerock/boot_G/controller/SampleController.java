package org.zerock.boot_G.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		TestVo newVo = new TestVo(); //@NoArgsConstructor 
		TestVo vo1 = newVo.toBuilder().no(100L).id("아이언맨").name("마크2").build();
		TestVo vo2 = TestVo.builder().no(101L).id("스파이더맨").build();
		TestVo vo3 = newVo.toBuilder().id("토르").build();
		  System.out.println(newVo);
		  System.out.println(vo1);
		  System.out.println(vo2);
		  System.out.println(vo3);
		 
		model.addAttribute("newVo",newVo);
		model.addAttribute("vo1",vo1);
		model.addAttribute("vo2",vo2);
		model.addAttribute("vo3",vo3);

		System.err.println("Thymeleaf 실행");
		return "thymeleaf/thymeleafTest";
		//thymeleaf 경로로 실행- 페이지 실행. (경로설정 application.properties)
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
							.singularItem("test1")			//singularItem 내용 추가
							.singularItem("test2")
							.singularItem(Arrays.asList("testA","testB"))
							.singularItem(Arrays.asList("testC","testD"))
							//collection<String> 형태로 넣으려면, Arrays.asList()를 활용하여야한다.
							.build();
		System.err.println(a.toString()); //@ToString 결과
		
		BuilderVO b = a.toBuilder().id("아메리카노").age(35).build();
		System.out.println(a.toString());	//a 객체 내용에서 수정된 내용만 새로 저장
		System.out.println(b.toString());	//a 객체 내용에서 수정된 내용만 새로 저장
		
		model.addAttribute("buildA", a);
		model.addAttribute("buildB", b);
		
		return "/build";
	}
}
