package org.zerock.boot_G.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.boot_G.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
	//JpaRepository<ID=저장소 엔티티명,T=저장소 도메인(속성) 타입>

}
