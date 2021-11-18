package com.hri.hri_web_backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.global.BoardType;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;

	@PostMapping("/board")
	public SuccessResponse registerArticle(@Valid @RequestBody Article article){
		articleService.registerArticle(article);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("게시글 등록 성공")
			.build();
	}

	@GetMapping("/board/{boardType}/{id}")
	public SuccessResponse getArticle(@PathVariable BoardType boardType, @PathVariable Long id){
		Optional<Article> article1 = articleService.getArticle(id);
		if(article1.isEmpty()){
			throw new RuntimeException();
		}
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.data(article1.get())
			.message("게시글 조회 성공")
			.build();
	}

	@GetMapping("/board/{boardType}")
	public SuccessResponse getArticle(@PathVariable BoardType boardType){
		List<Article> articles = articleService.getArticlesByType(boardType);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.data(articles)
			.message("게시판 조회 성공")
			.build();
	}
}
