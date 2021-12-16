package com.hri.hri_web_backend.fixture;

import com.hri.hri_web_backend.domain.Article;
import com.hri.hri_web_backend.global.BoardType;

public class ArticleTestFixture {
        public static class Article1{
            public static final Long ID = 1L;
            public static final String TOPIC = "article11 topic activity";
            public static final String CONTENT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
            public static final String AUTHOR = "administrator";
            public static final BoardType BOARDTYPE = BoardType.ACTIVITY;

            public static final Article article = Article.builder()
                    .topic(TOPIC)
                    .content(CONTENT)
                    .author(AUTHOR)
                    .boardType(BOARDTYPE)
                    .build();
        }
}
