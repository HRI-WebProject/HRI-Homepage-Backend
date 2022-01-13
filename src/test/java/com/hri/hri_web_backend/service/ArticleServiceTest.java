package com.hri.hri_web_backend.service;

import java.util.Optional;

import com.hri.hri_web_backend.fixture.ArticleTestFixture;
import com.hri.hri_web_backend.repository.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.hri.hri_web_backend.controller.ArticleFixture;
import com.hri.hri_web_backend.domain.Article;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest
@Transactional
class ArticleServiceTest {
	@Autowired
	ArticleService articleService;

	@Mock
	ArticleRepository articleRepository;

	@Test
	void 게시글등록_및_조회() {
		//given
		Article article = ArticleFixture.Article1.article;
		articleService.registerArticle(article);
		//when
		Optional<Article> article1 = articleService.getArticle(article.getId());
		//then
		Assertions.assertThat(article1.get().getBoardType().toString()).isEqualTo("ACTIVITY");
	}

	@Test
	public void 게시글_모음_조회() throws Exception {
	    //given
		Article article1 = ArticleFixture.Article1.article;
		articleService.registerArticle(article1);
		Article article2 = ArticleFixture.Article2.article;
		articleService.registerArticle(article2);
		Article article3 = ArticleFixture.Article3.article;
		articleService.registerArticle(article3);
		Article article4 = ArticleFixture.Article4.article;
		articleService.registerArticle(article4);
	    //when
		// List<Article> articles = articleService.getArticlesByType(BoardType.ACTIVITY, 1);
		// //then
		// Assertions.assertThat(articles.size()).isEqualTo(2);
		// Assertions.assertThat(articles.get(1).getTopic()).isEqualTo("article topic2 activity");
		// System.out.println("articles.get(1).getCreateDate() = " + articles.get(1).getCreateDate());
	}

	@DisplayName("게시판 게시글을 삭제한다")
	@Test
	public void deleteArticle() throws Exception{
		//when
		articleService.deleteArticle(ArticleTestFixture.Article1.ID);

		//then
		then(articleRepository).should(times(1)).deleteById(any());
	}
}