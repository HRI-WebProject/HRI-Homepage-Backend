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

	@PutMapping("/board/{boardType}/{id}")
	public SuccessResponse updateArticle(@PathVariable BoardType boardType, @PathVariable Long id, UpdateArticleRequestDto dto) {
		articleService.updateArticle(boardType, id, dto);
		return SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("게시판 수정 성공")
			.build();
	}
      
	@DeleteMapping("/board/{boardType}/{id}")
	public SuccessResponse deleteArticle(@PathVariable BoardType boardType, @PathVariable Long id) {
		articleService.deleteArticle(boardType, id);
		return SuccessResponse.builder()
				.status(StatusEnum.OK)
				.message("게시글 삭제 성공")
				.build();
	}
}
