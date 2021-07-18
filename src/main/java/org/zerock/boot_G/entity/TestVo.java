package org.zerock.boot_G.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true) // 기존정보 + 변경정보, toBuild()사용가능
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestVo {
	private Long no;
	private String id;
	private String name;

}
