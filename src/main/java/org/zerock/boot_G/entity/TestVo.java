package org.zerock.boot_G.entity;

import lombok.Data;

@Data
public class TestVo {
	private Long mbrNo;
	private String id;
	private String name;

	public TestVo(String id, String name) {
	}

}
