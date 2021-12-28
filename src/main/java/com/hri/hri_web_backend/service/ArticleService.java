package com.hri.hri_web_backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	private int pageSize = 5;

	public void registerArticle(Article article){
		articleRepository.save(article);
	}

	public Page<ArticleDto> getArticlesByType(BoardType boardType, Integer pageNum){
		PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.DESC,"id"));
		Page<Article> articles = articleRepository.findAllByBoardType(boardType, pageRequest);
		return articles.map(
			article -> new ArticleDto(article.getId(), article.getTopic(), article.getAuthor(),
				article.getCreateDate()));
	}

	public Optional<Article> getArticle(Long id){
		return articleRepository.findById(id);
	}

	public void deleteArticle(BoardType boardType, long id){
		Optional<Article> article = articleRepository.findById(id);
		if(article.isPresent() && article.get().getBoardType() == boardType)
			articleRepository.deleteById(id);
		else
			throw  new NullPointerException();
	}
}
