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
@Entity
@Table(name = "build_tbl")
@ToString
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
//	private List<String> defaultItem = Arrays.asList("Default");
//	private List<String> defaultItem;
	
   @Column(name = "nullitem")
	@ElementCollection
	private List<String> nullItem;
	
   	@Column(name = "singularitem")
	@Singular(value = "singularItem")
	@ElementCollection
	private List<String> singularItem;
}
