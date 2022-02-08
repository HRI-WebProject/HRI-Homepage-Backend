# HRI-Homepage-Backend
> 동국대학교 인간-로봇 상호작용 연구실(HRILAB) 웹페이지 서버
</br>

## 🤖 프로젝트 개요
동국대학교 인간-로봇 상호작용 연구실 웹페이지 서버를 설계하고 구축합니다.
### 목표
- 객체지향을 따라 설계하며 테스트 코드를 작성합니다.
- 유지보수성을 고려하여 개발합니다
- NAS(Network Attached Storage)클라우드에 서버를 구축하여 배포합니다.

</br>

## 👨‍💻 서버 파트 팀원
<img src="https://user-images.githubusercontent.com/31584255/152821782-7ca8d7e8-c035-4298-acf5-25bf0508468c.png" width="150"> | <img src="https://user-images.githubusercontent.com/31584255/152821471-d859a94e-92fd-4ff1-bf45-e917380ee4bb.png" width="150"> 
 :---------:|:----------:
이시은 |박계원 
[sileeee](https://github.com/sileeee) | [Kyewon-Park](https://github.com/Kyewon-Park) 

</br>

## 💎 Tech Stack
```
Java11
Springboot
Gradle
Spring Security
Jpa
MySQL
```
</br>

## 🔑 Architecture
- **전체 구성도**

<img width="506" alt="architecture" src="https://user-images.githubusercontent.com/31584255/152929227-2fbf7552-1d76-4863-8cc8-c7ce62d86370.png" width="6000">


- **DB 구조**
<img width="506" alt="DB구성" src="https://user-images.githubusercontent.com/31584255/151808212-37655e04-652c-45b9-86a0-19a7c5517f7f.png">

</br>

## 📘 프로젝트 화면 구성
(이미지 첨부 예정)
</br>

## 📑 Documentation
👉 [API 바로 가기](https://github.com/HRI-WebProject/HRI-Homepage-Backend/wiki/3.1.-API-Design#%EA%B0%9C%EC%9A%94)</br>
👉 [Usecase 바로 가기](https://github.com/HRI-WebProject/HRI-Homepage-Backend/wiki/3.-Usecase)

</br>

## 🧩 Rule & Convention
👉 [Rule & Convention 바로 가기](https://github.com/HRI-WebProject/HRI-Homepage-Backend/wiki/4.-Rule-&-Convention#1-git-commit-message-convention)
</br>

👉 **브랜치 관리 전략** </br>
Git Flow를 사용하여 브랜치를 관리합니다.
모든 브랜치는 Pull Request에 리뷰를 진행한 후 merge를 진행합니다.</br>
<img width="563" alt="git flow" src="https://user-images.githubusercontent.com/31584255/152932423-bcbaee5a-bd21-4b98-82e3-8bc7946c9f61.png" width="800">
- Master : 배포시 사용합니다.
- Develop : 완전히 개발이 끝난 부분에 대해서만 Merge를 진행합니다.
- Feature : 기능 개발을 진행할 때 사용합니다.
- Release : 배포를 준비할 때 사용합니다.
- Hot-Fix : 배포를 진행한 후 발생한 버그를 수정해야 할 때 사용합니다.

