package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.hri.hri_web_backend.dto.UpdateArticleRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.dto.GetArticleRequestDto;
import com.hri.hri_web_backend.global.BoardType;
import com.hri.hri_web_backend.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
	private final ArticleRepository articleRepository;
	private int pageSize = 5;

	public void registerArticle(Article article){
		articleRepository.save(article);
	}

	public List<GetArticleRequestDto> getArticles(){
		List<Article> articles = articleRepository.findAll();
		return articles.stream().map(
			article -> new GetArticleRequestDto(article.getId(), article.getTopic(), article.getAuthor(),
				article.getCreateDate())).collect(Collectors.toList());
	}

	public List<GetArticleRequestDto> getArticlesByType(BoardType boardType){
		List<Article> articles = articleRepository.findAllByBoardType(boardType);
		return articles.stream().map(
			article -> new GetArticleRequestDto(article.getId(), article.getTopic(), article.getAuthor(),
				article.getCreateDate())).collect(Collectors.toList());
	}

	public Page<GetArticleRequestDto> getArticlesByTypeWithPage(BoardType boardType, Integer pageNum){
		PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.DESC,"id"));
		Page<Article> articles = articleRepository.findAllByBoardType(boardType, pageRequest);
		return articles.map(
			article -> new GetArticleRequestDto(article.getId(), article.getTopic(), article.getAuthor(),
				article.getCreateDate()));
	}

	public Optional<Article> getArticle(Long id){
		return articleRepository.findById(id);
	}

	public void updateArticle(BoardType boardType, long id, UpdateArticleRequestDto dto){
		Optional<Article> article = articleRepository.findById(id);
		if(article.isEmpty() || article.get().getBoardType() != boardType)
			throw new NullPointerException();

		article.ifPresent(selectArticle->{
			selectArticle.setTopic(dto.getTopic());
			selectArticle.setAuthor(dto.getAuthor());
			selectArticle.setContent(dto.getContent());
		});
  	}
  
	public void deleteArticle(BoardType boardType, long id){
		Optional<Article> article = articleRepository.findById(id);
		if(article.isPresent() && article.get().getBoardType() == boardType)
			articleRepository.deleteById(id);
		else
			throw  new NullPointerException();
    
	}
}
