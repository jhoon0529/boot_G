package org.zerock.boot_G.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/hello")
	public int[] hello() {
		System.out.println(">>GetMapping 완료");
		int arr[] = new int[10];
		for(int i=0; i<arr.length;i++){
			arr[i] = i+2;
		}
			
		return arr;
	}
}
