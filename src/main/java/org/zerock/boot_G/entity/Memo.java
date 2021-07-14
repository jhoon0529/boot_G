package org.zerock.boot_G.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_memo")
@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
// @Getter을 이용해서 Getter 메서드 생성 get..() 
//@Builder를 이용해서 객체 생성 builder(), build()
//@Builder을 이용하기 위해서는 @AllArgsConstructor와 @NoArgsConstructor를 항상 같이 처리 

public class Memo { //테이블
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment 방식
	private Long mno; //속성 @ID=Primary key 선언  @GeneratedValue는 자동 생성선언

	private String memoText;
	
	//Entity는 반드시 필요
	//Table 은 JPA에서 직접 테이블 생성시 필요
	//Id는 PK 설정
	//@GeneratedValue는 자동 생성 설정 (예: no 속성에 자동 발번 여부)
	//strategy = GenerationType. (IDENTITY(데이터베이스가 자동 키 생성)
	//											SEQUENCE(Sql 키 생성_@SequenceGenerator 필요)
	//											TABLE(키 전용테이블생성_@TableGenerator 필요)
}
