package com.hri.hri_web_backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.global.BoardType;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Page<Article> findAllByBoardType(BoardType boardType, Pageable pageable);
	List<Article> findAllByBoardType(BoardType boardType);

}