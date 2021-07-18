package org.zerock.boot_G.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Data
@Builder(toBuilder = true) //기존 객체데이터 남기고 수정
@Entity
@Table(name = "build_tbl")
@ToString
@Getter
@AllArgsConstructor			//매개변수 무시 생성가능
@NoArgsConstructor			//매개변수 없이 생성가능
public class BuilderVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@NonNull
	private String id;
	
	@Builder.Default
	private String name="test";
	
	private int age;
	
   @Column(name = "item")
   @ElementCollection  
	private List<String> item;
	
//	 속성값 초기화 입력  @Column(columnDefinition = "varchar(255) default 'John Snow'")
	@Builder.Default
	@Column(name = "defaultitem")
	@ElementCollection  
	private List<String> defaultItem=new ArrayList<String>();
	
   @Column(name = "nullitem")
	@ElementCollection
	private List<String> nullItem;	//초기화 선언 없을시 null
	
   	@Column(name = "singularitem")
	@Singular(value = "singularItem")	//입력시 수정이 아닌 +추가
	@ElementCollection
	private List<String> singularItem;
}
