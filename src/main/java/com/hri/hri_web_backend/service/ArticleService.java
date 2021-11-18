package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.global.BoardType;
import com.hri.hri_web_backend.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
	private final ArticleRepository articleRepository;

	public void registerArticle(Article article){
		articleRepository.save(article);
	}

	public List<Article> getArticlesByType(BoardType boardType){
		return articleRepository.findAllByBoardType(boardType);
	}

	public Optional<Article> getArticle(Long id){
		return articleRepository.findById(id);
	}

}
