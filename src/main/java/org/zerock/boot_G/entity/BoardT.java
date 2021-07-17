package org.zerock.boot_G.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "Tlf")
@Table(name = "Tlf_tbl")
@ToString							//객체 주소가 아닌 변수값들을 불러올 수 있다.
@Builder(toBuilder = true)	//@빌더는 생성자를 대신하며, to빌더는 다른값의 새로운 생성자를 추가 생성한다.
public class BoardT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	
	private String first;
	private String last;
	@Column(nullable = false)
	private LocalDateTime regTime;
	
}
