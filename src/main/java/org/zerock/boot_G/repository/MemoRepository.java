package org.zerock.boot_G.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.boot_G.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
	//JpaRepository<ID=저장소 엔티티명,T=저장소 도메인(속성) 타입>
	
	
	
	//Spring 지원 메소드
	//where mno BETWEEN 1 and 2 order by mno Asc
	//페이지 목록 없이 정해진 수만큼 보여줄 수 있다.
	List<Memo> findByMnoBetweenOrderByMnoAsc(long from, long to);
	
	//where mno BETWEEN (from) and (to)
	//order by mno desc[Sort] limt [pageable] 
	//페이지 묶음이 지정되어 설정된 PageRequest.of()에 따라 보여줄 수 있다.
	Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
	
	//select * from tbl_memo where mno< ? (10L)
	//delete from tbl_memo where mno = ? (1L~9L)
	//LessThan, LessThanEqual, IsLessThan, IsLessThanEqual
	void deleteMemoByMnoLessThan(Long aLong);

	//JPQL @Query
	
	//Return 타입이 <Object[]>인 경우, CURRENT_DATE 등 @Query 사용시
	//Return 타입이 Page<T>인 경우, Pageable @Query 사용시
	
	//토탈 조회 리스트 (m = Entity 객체)
	@Query("select m from Memo m order by m.mno desc")
	List<Memo> getListDesc();
	@Query("select m from Memo m where  m.memoText Like 'Update%' order by m.mno asc" )
	List<Memo> getListAscWhere();
	
	//JPQL @NativeQuery-List
	@Query(value = "select * from tbl_memo where mno<15", nativeQuery = true)
	List<Memo> getListNative();
	//JPQL @NativeQuery-Object
	@Query(value = "select * from tbl_memo where mno<15", nativeQuery = true)
	List<Object[]> getListNativeObj();
	
	//JPQL -바인딩처리__ :xxx방식 _? >> :mno
	@Query("select m from Memo m where m.mno < :mno")
	List<Memo> Binding1(@Param("mno") Long mno);
	
	//		  -바인딩처리__ 파라미터 순 방식 '?1', '?2'
	@Query("Select m from Memo m where m.memoText like ?2 and mno < ?1")
	List<Memo> Binding2(Long mno,  String text);
	
	//		  -바인딩처리__ :#{#자바빈} 방식 객체 불러오기
	@Modifying		//Update, Delete 시 필수.
	@Transactional	//트렌젝션 기능
	@Query("UPDATE Memo m SET m.memoText = :#{#param.memoText}"
			+ " where m.mno=:#{#param.mno}")
	int Binding3(@Param("param") Memo memo);

	// 페이징-바인딩__:#{} // Pagination을 위해 countQuery 사용
	@Query(value = "select m from Memo m where m.mno > :mno",
			countQuery = "select COUNT(m) from Memo m where m.mno >:mno")
	Page<Memo> getListQueryPage(@Param("mno") long mno, Pageable pageable);
	
	
	@Query(value = "select m.mno, m.memoText, CuRRENT_DATE from Memo m where m.mno < :mno",
			countQuery = "select  COUNT(m) from Memo m where m.mno < :mno")
	Page<Object[]> getListQueryObj(@Param("mno") long mno, Pageable pageable);
	
	
	


	
}
