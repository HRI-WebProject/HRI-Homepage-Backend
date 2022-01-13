package com.hri.hri_web_backend.fixture;

import com.hri.hri_web_backend.domain.Publication;
import com.hri.hri_web_backend.global.PublicationType;

public class PublicationFixture {
	public static class Publication1{
		public static final String TOPIC = "topic ex1";
		public static final String LINK = "link ex1";
		public static final String DETAIL = "Detail ex1";
		public static final PublicationType PUBLICATIONTYPE = PublicationType.JOURNAL;

		public static final Publication publication1 = Publication.builder()
			.topic(TOPIC)
			.link(LINK)
			.detail(DETAIL)
			.publicationType(PUBLICATIONTYPE)
			.build();
	}

	public static class Publication2{
		public static final String TOPIC = "topic ex2";
		public static final String LINK = "link ex2";
		public static final String DETAIL = "Detail ex2";
		public static final PublicationType PUBLICATIONTYPE = PublicationType.BOOK;

		public static final Publication publication2 = Publication.builder()
			.topic(TOPIC)
			.link(LINK)
			.detail(DETAIL)
			.publicationType(PUBLICATIONTYPE)
			.build();
	}
}
