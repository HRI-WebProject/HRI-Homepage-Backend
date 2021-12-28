package com.hri.hri_web_backend.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.hri.hri_web_backend.dto.UpdateArticleRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.dto.GetArticleRequestDto;
import com.hri.hri_web_backend.global.BoardType;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;

	@PostConstruct //배포시삭제
	public void makeArticle(){
		Article article1 = ArticleFixture.Article1.article;
		articleService.registerArticle(article1);
		Article article2 = ArticleFixture.Article2.article;
		articleService.registerArticle(article2);
		Article article3 = ArticleFixture.Article3.article;
		articleService.registerArticle(article3);
		Article article4 = ArticleFixture.Article4.article;
		articleService.registerArticle(article4);
		Article article5 = ArticleFixture.Article5.article;
		articleService.registerArticle(article5);
		Article article6 = ArticleFixture.Article6.article;
		articleService.registerArticle(article6);
		Article article7 = ArticleFixture.Article7.article;
		articleService.registerArticle(article7);
		Article article8 = ArticleFixture.Article8.article;
		articleService.registerArticle(article8);
		Article article9 = ArticleFixture.Article9.article;
		articleService.registerArticle(article9);
		Article article10 = ArticleFixture.Article10.article;
		articleService.registerArticle(article10);
		Article article11 = ArticleFixture.Article11.article;
		articleService.registerArticle(article11);
		Article article12 = ArticleFixture.Article12.article;
		articleService.registerArticle(article12);
		Article article13 = ArticleFixture.Article13.article;
		articleService.registerArticle(article13);
		Article article14 = ArticleFixture.Article14.article;
		articleService.registerArticle(article14);
	}

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

	@GetMapping("/board/{boardType}/page/{page}")
	public SuccessResponse getArticlesByType(@PathVariable BoardType boardType, @PathVariable Integer page){
		Page<GetArticleRequestDto> articlesByType = articleService.getArticlesByType(boardType, page);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.data(articlesByType)
			.message("게시판 조회 성공")
			.build();
	}

	@PutMapping("/board/{id}")
	public SuccessResponse updateArticle(@PathVariable Long id, UpdateArticleRequestDto dto){
		articleService.updateArticle(id, dto);
		return SuccessResponse.builder()
				.status(StatusEnum.OK)
				.message("게시판 수정 성공")
      
	@DeleteMapping("/board/{boardType}/{id}")
	public SuccessResponse deleteArticle(@PathVariable BoardType boardType, @PathVariable Long id) {
		articleService.deleteArticle(boardType, id);
		return SuccessResponse.builder()
				.status(StatusEnum.OK)
				.message("게시글 삭제 성공")
				.build();
	}
}
