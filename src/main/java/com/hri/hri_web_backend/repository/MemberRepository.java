package com.hri.hri_web_backend.repository;

import java.util.List;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.global.DegreeEnum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	 List<Member> findAllByDegree(DegreeEnum degree);
}