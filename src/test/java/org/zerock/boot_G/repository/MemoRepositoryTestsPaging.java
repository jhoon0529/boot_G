package org.zerock.boot_G.repository;




import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.zerock.boot_G.entity.Memo;


@SpringBootTest
public class MemoRepositoryTestsPaging {
//Pageable 기능 테스트
	
	@Autowired
	MemoRepository memoRepositoryIF;
	
	@Test
	public void testPageDefault() {
		Pageable pageable = PageRequest.of(0, 10); //page, size , page는 0번부터 시작.
		//전체 조회값을 pageable로 나눔 (total / pageable.size)
		Page<Memo> result = memoRepositoryIF.findAll(pageable); 
		System.out.println("result: "+ result); //결과 total=700, Page 1 of 140
		System.out.println("----------------------------------------");
		System.out.println("현재 페이지 정보 : "+result.getPageable()); // 페이지 정보 : page num, page size, sort
		System.out.println("이전 페이지 정보 : "+result.previousPageable()); //없음 Instance
		System.out.println("다음 페이지 정보 : "+result.nextPageable());
		System.out.println("Total Count : "+memoRepositoryIF.count());
		System.out.println("Total page : "+result.getTotalPages()); //700/10 =70
		System.out.println("Page Size : "+result.getSize()); //size=10
		System.out.println("현재 페이지 Num : "+result.getNumber());
		System.out.println("현재 페이지 Content : "+result.getContent()); //toList() 동일
		System.out.println("시작 페이지 여부 : "+result.isFirst());
		System.out.println("다음 페이지 여부 : "+result.hasNext());
		System.out.println("이전 페이지 여부 : "+result.hasPrevious());

	}
}
