INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('PHD', 'one2003@hanmail.net', 'Young-won Cho', false, '조영원', '컴퓨터비전');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('PHD', 'sik2230@dongguk.edu', 'Yong-sik Choi', false, '최용식', '모바일로봇, 지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('MASTER', 'lweimo@foxmail.com', 'Ae-Ryeong Im', false, '림애령', '컴퓨터비전');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('MASTER', 'cymothoa@dgu.ac.kr', 'Seung-yoon Yang', false, '양승윤', '지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('MASTER', 'kangtaepoong@naver.com', 'Hyun-wook Kang', false, '강현욱', '지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('MASTER', 'skwndbth159@dongguk.edu', 'Woo-jin Jang', false, '장우진', '모바일로봇');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('MASTER', 'ktw3388@dgu.ac.kr', 'Tae-won Kang', false, '강태원', '컴퓨터비전, 모바일로봇');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('BACHELOR', 'tldms201@dgu.ac.kr', 'Si-eun Lee', false, '이시은', '지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('BACHELOR', 'sooa9918@dgu.ac.kr', 'Soo-a Jang', false, '장수아', '지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('BACHELOR', 'didphtmd@gmail.com', 'Bo-seung Yang', false, '양보승', '지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('BACHELOR', 'lynnp1004@naver.com', 'Lynn Park', false, '박린', '지능시스템');
INSERT INTO member (degree, email, eng_name, graduate, name, research_area) VALUES ('BACHELOR', 'pkw3136@naver.com', 'Kye-won Park', false, '박계원', '지능시스템');

INSERT INTO professor (name, eng_name, email, bold_detail, detail) VALUES ('정진우', 'Jin-Woo Jung', 'jwjung@dongguk.edu', '동국대학교 컴퓨터공학과/인공지능학과 교수, 컴퓨터공학과 학과장', '국제저명학술지(IJFIS) 편집위원장\n한국지능시스템학회 이사, 한국공학교육회 이사, 한국공학교육인증원 CAC 부위원장\n한국과학기술원(KAIST) 전기및전자공학과 공학사/공학석사\n한국과학기술원(KAIST) 전자전산학과 공학박사\n일본 동경대학교 방문연구원, 미국 Purdue University 방문교수\n국제 저명(SCI급)학술지 게재 50여 편, 학술대회 논문 발표 200여 편, 특허 등록 20여 건, 기술이전 10여 건');

INSERT INTO publication (topic, inventor, filling_no, filling_date, granted_no, granted_date, progress, link, detail, publication_type) VALUES ('이동 로봇들의 결합을 위한 도킹 시스템 및 방법','김용태, 문용필, 정진우', '10-2008-0126596', '2008-12-12', '10-0915801', '2009-08-31', '기술이전', 'ex_link', 'ex_detail', 'JOURNAL');
INSERT INTO publication (topic, inventor, filling_no, filling_date, granted_no, granted_date, progress, link, detail, publication_type) VALUES ('공간 메커니즘을 이용한 이동로봇과 이를 이용한 이동로봇 협동 제어 시스템 및 방법','정진우', '10-2009-0096704', '2009-10-12', '10-1000879', '2009-12-07', '기술이전', 'ex_link2', 'ex_detail2', 'JOURNAL');
INSERT INTO publication (topic, inventor, filling_no, filling_date, granted_no, granted_date, progress, link, detail, publication_type) VALUES ('ex_topic3','정진우', '10-2008-012', '2008-12-15', '10-0915833', '2009-08-11', '기술이전', 'ex_link3', 'ex_detail3', 'JOURNAL');

INSERT INTO project (on_going, detail1, detail2, detail3, detail4, detail5, eng_detail1, eng_detail2, eng_detail3, eng_detail4, eng_detail5, eng_sub_topic, eng_topic, photo, sub_topic, topic) VALUES (true, 'ex_detail1', 'ex_detail2', 'ex_detail3', 'ex_detail4', 'ex_detail5', 'ex_eng_detail1', 'ex_eng_detail2', 'ex_eng_detail3', 'ex_eng_detail4', 'ex_eng_detail5', 'ex_eng_subTopic', 'ex_eng_topic', 'ex_photo_path', 'ex_sub_topic', 'ex_topic');

INSERT INTO research_area (detail, eng_detail, eng_name, name, photo) VALUES ('ex_detail', 'ex_eng_detail', 'ex_eng_name', 'ex_name', 'ex_photo_path');

INSERT INTO research_equipment (eng_name, name, photo) VALUES ('ex_eng_name', 'ex_name', 'ex_photo');

INSERT INTO article (author, board_type, content, create_date, topic) VALUES ('Jin-Woo Jung', 'NOTICE', 'ex_content', '2020-01-28 22:13:11', 'ex_sub_topic');
