package org.zerock.boot_G.repository;

import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.zerock.boot_G.entity.Memo;


//@RunWith(SpringRunner.class)			//JUnit4 방식
//@ExtendWith(SpringExtension.class)//JUnit4 방식
@SpringBootTest
public class MemoRepositoryTestsCRUD {
//CRUD 기능 테스트
	
	@Autowired
	MemoRepository memoRepositoryIF;
	
	//@org.junit.Test  //JUnit4 방식
	@Test //org.junit.jupiter.api.Test  //JUnit5 형식
	public void testClass() {
		System.out.println("JpaRepository IF 자동생성 ProxyName === "+memoRepositoryIF.getClass().getName()); //@toString 사용
	}
	//==============================JPA CRUD
	@Test
	@Disabled
	public void testInsertDummies() {
//		람다식 - 상속 class에 method가 1개일 때 new class객체() { @override T Method(param)}
//		IntStream.rangeClosed(1, 100).forEach(new IntConsumer() {
//			
//			@Override
//			public void accept(int i) {
//				Memo memo = Memo.builder().memoText("Sample..."+i).build();
//				memoRepositoryIF.save(memo);
//			}});
		//람다식
		IntStream.rangeClosed(1, 100).forEach(i-> {
				Long mno = (long)i;
//				Memo memo = Memo.builder().mno(mno).memoText("Sampdate..."+i).build();
				Memo memo = Memo.builder().memoText("Sampdate..."+i).build(); //자동발번
				memoRepositoryIF.save(memo);
			});
	}
	
	@Disabled
	@Test
	public void testSelectFindById() {
		Long mno = 100L;
		
		Optional<Memo> result = memoRepositoryIF.findById(mno);
		
		System.out.println("======================");
		if(result.isPresent()) {
			Memo memo = result.get(); //Jpa 저장소에서 mno를 찾아서 불러온다.
			System.out.println("Opt Type : "+result);
			System.out.println("Class TYpe : "+memo);
			
		}
	}
	
	@Disabled
	@Transactional //getOn()은 @Transactional 을 같이 써야한다.
	@Test
	public void testSelectGetOn() {
		Long mno = 100L;
		
		Memo memo = memoRepositoryIF.getOne(mno); //Jpa 저장소에서 mno를 찾아서 불러온다.
		System.out.println("======================");
		System.out.println(memo);
	}
	@Disabled
	@Test
	public void testDeleteById() {
		Long mno = 702L;
		memoRepositoryIF.deleteById(mno);
		System.out.println("Delect Complete : "+mno);
	}
	@Disabled
	@Transactional
	@Test
	public void testDelete() {
		Memo memo = memoRepositoryIF.getOne(700L);
		memoRepositoryIF.delete(memo);
		System.out.println(memo);
	}
	
	@Test
	@Disabled
	public void testUpdate() {
		Long mno = 2L;
		Memo memo = Memo.builder().mno(mno).memoText("Update..."+mno).build();
		memoRepositoryIF.save(memo);
		System.out.println(memo);
	}
}
