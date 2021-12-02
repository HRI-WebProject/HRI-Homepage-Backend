package com.hri.hri_web_backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.dto.ArticleDto;
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

	public Page<ArticleDto> getArticlesByType(BoardType boardType, Integer page){
		PageRequest pageRequest = PageRequest.of(page, 5);
		Page<Article> articles = articleRepository.findAllByBoardType(boardType, pageRequest);
		return articles.map(
			article -> new ArticleDto(article.getId(), article.getTopic(), article.getAuthor(),
				article.getCreateDate()));
	}

	public Optional<Article> getArticle(Long id){
		return articleRepository.findById(id);
	}

}
