package org.zerock.boot_G.repository;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.zerock.boot_G.entity.Memo;


@SpringBootTest
public class MemoRepositoryTestsQuery {
//Query Method
	
	@Autowired
	MemoRepository memoRepositoryIF;
	
	@Disabled
	@Test
	public void testQueryMethodWithPageable() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Memo> result = memoRepositoryIF.findByMnoBetween(10L,50L, pageable);
		
		result.get().forEach(memo -> System.out.println(memo));
	}
	
	@Disabled
	@Test
	public void testQueryMethodWithPage() {
		List<Memo> result= memoRepositoryIF.findByMnoBetweenOrderByMnoAsc(25L, 30L);
		
		//배열에서 데이터 출력방법 (List는 for-each, Iterator을 사용해야 중복 반복(시간복잡도)을 줄인다.)
		//for문
//		for(Memo memo : result) {
//			System.out.println(memo);
//		}
		//Iterator _ hasNext(), next()
//		Iterator<Memo> memoList= result.iterator();	
//		while(memoList.hasNext()) {
//			System.out.println(memoList.next());
//		}
		//Lambda _ forEach()
		result.forEach(memo->System.out.println(memo));
	}
	
	@Disabled
	@Test
	@Transactional			//여러 Delete는 트렌젝션 발생. Commit
	@Commit					//Test Delete에서만 사용
	public void testQueryMethodDelete() {
		Long mno = 10L;
		memoRepositoryIF.deleteMemoByMnoLessThan(mno);
		
		List<Memo> mList = memoRepositoryIF.findByMnoBetweenOrderByMnoAsc(1L, 10L);
		mList.forEach(list->System.out.println("확인 조회 :"+list));
	}
	
	@Disabled
	@Test
	public void testJPQueryGetList() {
		List<Memo> list = memoRepositoryIF.getListDesc();
		list.forEach(memo->System.out.println(memo));
	}
	
	@Disabled
	@Test
	public void testJPQueryGetListWhere() {
		List<Memo> list = memoRepositoryIF.getListAscWhere();
		list.forEach(memo->System.out.println(memo));
	}
	//native Query
	@Disabled
	@Test
	public void testJPQueryGetListNative() {
		List<Memo> list = memoRepositoryIF.getListNative();
		list.forEach(memo->System.out.println(memo));
	}
	
	//native Query Obj 타입리턴// Arrays.toString(배열[]) 을 해야 값 출력
	@Disabled
	@Test
	public void testJPQueryGetListNativeObj() {
		List<Object[]> list = memoRepositoryIF.getListNativeObj();
		list.forEach(obj->System.out.println(Arrays.toString(obj)));
	}
	@Disabled
	@Test
	public void testJPQueryGetListBinding() {
		long mno = 15L;
		List<Memo> list = memoRepositoryIF.Binding1(mno);
		list.forEach(memo->System.out.println(memo));
	}
	@Disabled
	@Test
	public void testJPQueryGetListBinding2() {
		List<Memo> list = memoRepositoryIF.Binding2(250L,"%...5");
		list.forEach(memo->System.out.println(memo));
	}
	@Disabled
	@Test
	public void testJPQueryGetListBinding3() {
		Long mno = 15L;
		String text = "modify..."+mno ;
		//memo 객체 수정
		Memo memo = Memo.builder().mno(mno).memoText(text).build(); //트렌젝션 사용X
		System.out.println("Modify check : "+memo);
		
		//update Memo 객체 저장
		int update = memoRepositoryIF.Binding3(memo);
		System.out.println("Update check : "+(update==1 ? "True" : "False"));
	}
	
//	@Disabled
	@Test
	@Transactional	//getOn()사용
	public void testJPQueryPage() {		//Memo(mno=460, memoText=Sample...60)
		Long mno = 450L;
		Memo memo = memoRepositoryIF.getOne(mno); //트렌젝션 사용X
		System.out.println(memo);
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").ascending());
		Page<Memo> plist =  memoRepositoryIF.getListQueryPage(memo.getMno(), pageable);
		
		plist.forEach(pmemo->System.out.println(pmemo));
		System.out.println(memoRepositoryIF.findAll(pageable));
	}
	
	@Test											//속성 Value 만 출력 + JPQL함수출력
	public void testJQueryObj() {			//[489, Sample...89, 2021-07-15]
		Long mno = 490L;
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Object[]> objList =  memoRepositoryIF.getListQueryObj(mno, pageable);
		
		objList.forEach(obj->System.out.println(Arrays.toString(obj)));
//		System.out.println(memoRepositoryIF.findAll(pageable));
	}
	
	
	
}
