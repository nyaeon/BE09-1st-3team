# 프로젝트 기획서
---
# 개요
- 프로젝트명 : 냉장GO - 식재료 관리와 유통기한 알림 시스템
- 프로젝트 기간 : 2025-04-22 ~ 2025-04-24
---
# 팀원 구성
| 임나연 | 이나영 | 임현우 | 박창준 |
|--------|--------|--------|--------|
| ![임나영](https://avatars.githubusercontent.com/u/106491547?v=4) | ![이나영](https://avatars.githubusercontent.com/u/123456789?v=4) | ![임현우](https://avatars.githubusercontent.com/u/106491547?v=4) | ![박창준](https://avatars.githubusercontent.com/u/123456789?v=4) |
| [GitHub](https://github.com/nyaeon) | [GitHub](https://github.com/NYoungLEE) | [GitHub](https://github.com/LimHub) | [GitHub](https://github.com/changjunpark13) |
---
# 목적 및 배경
- "냉장GO" 프로젝트의 목적은 사용자가 식재료를 효율적으로 관리하고, 유통기한에 따른 소비 패턴을 분석하여 낭비를 최소화하며, 다양한 레시피를 통해 식재료를 유용하게 활용할 수 있도록 돕는 것입니다. 이 시스템은 냉장고에 보관된 식재료의 정보를 체계적으로 관리하고, 유통기한 임박 또는 유통기한이 지난 재료를 빠르게 확인하며, 사용자가 선호하는 레시피를 추천하고, 소비 패턴에 맞는 알림을 제공합니다. 또한, 사용자 계정 관리 기능을 통해 개인 맞춤형 서비스를 제공하여, 전반적인 식생활의 효율성을 높이는 데 기여하고자 합니다.

- 최근 식품 소비에서의 낭비 문제는 큰 사회적 이슈로 떠오르고 있습니다. 많은 사람들이 식재료를 구입한 후 보관 상태나 유통기한을 제대로 확인하지 않아 불필요하게 폐기되는 경우가 많습니다. 이를 해결하기 위해, "냉장GO" 프로젝트는 식재료를 체계적으로 관리하고, 사용자가 유통기한을 쉽게 확인할 수 있도록 도와주는 시스템을 제공합니다. 또한, 사용자에게 적합한 레시피를 추천하고, 과도한 소비나 낭비를 방지하는 알림 기능을 제공하여, 더욱 효율적이고 건강한 식생활을 지원하는 서비스입니다.
본 프로젝트는 사용자가 자신의 식재료를 관리하고, 이를 기반으로 필요한 레시피를 추천받는 방식으로, 식품의 낭비를 줄이고, 사용자에게 실용적인 도움을 제공하는 것을 목표로 합니다. 이를 통해 식품 관리의 편리함을 제공하고, 환경적으로도 긍정적인 영향을 미칠 수 있습니다.
---
# 유사 프로그램 분석
1. BEEP
### 식재료 등록 페이지
<img src="![image](https://github.com/user-attachments/assets/6c3f9f41-b4dc-4c6c-93da-54e8ab3572e1)" width="200" height="400"/>
<br>
### 유통기한 확인 페이지
<br>
<img src="https://github.com/user-attachments/assets/a042fd3d-fde0-4666-b88c-e325d2e91853  width="200" height="400"/>

2. 만개의 레시피
재료기반 추천 레시피 확인
<img src="https://github.com/user-attachments/assets/37778944-087b-4d33-9b14-c16e3e2c0d5a  width="200" height="400"/>
<img src="https://github.com/user-attachments/assets/2e75fc10-bf1d-4ff1-9ba9-a4f9a28e72f9  width="200" height="400"/>



---
# 개발 환경
- 프로그래밍 언어 : Java(Java SE 8 이상)
- 데이터베이스 : MySQL Database
- 개발 도구 : IntelliJ IDEA(JAVA 개발 환경 및 IDE)
- 데이터베이스 관리 및 쿼리 도구 : DA5, MySQL SQL Developer
- 형상 관리 툴 : Git, GitHub
---
# 주요 기능

📌 Java 개발:

- 애플리케이션 구조 설계:

  - 요구사항 분석을 바탕으로 애플리케이션의 전반적인 구조를 설계하고, 각 기능을 담당하는 패키지와 클래스를 구성했습니다.

- JDBC를 이용한 데이터베이스 연동:

  - Java Database Connectivity (JDBC)를 사용하여 MySQL Database와 연결하고, SQL 쿼리를 통해 데이터를 CRUD (Create, Read, Update, Delete) 작업을 수행하는 기능을 구현했습니다.

- 콘솔 기반 사용자 인터페이스 (UI) 구현:

  - 사용자와의 상호 작용을 위한 기본적인 메뉴 및 입력/출력 기능을 콘솔 환경에서 구현했습니다.

- 서비스 계층 구현:

  - 비즈니스 로직을 처리하는 서비스 클래스를 구현하여, 데이터 접근 계층과 UI 계층을 분리하고, 각 기능의 역할을 명확히 했습니다.

- 예외 처리:

  - 프로그램 실행 중 발생할 수 있는 예외 상황을 처리하기 위한 예외 처리 코드를 작성하여 안정성을 확보했습니다.
  
- 데이터베이스 (MySQL Database) 활용:

  - 데이터베이스 스키마 설계:

    - 회원관리, 관리자 업무, 식재료 관리, 유통기한 확인, 추천 레시피 확인, 식재료 소비 기록 등을 저장하기 위한 데이터베이스 테이블을 설계했습니다.

- SQL 쿼리 작성:

  - 데이터베이스에서 데이터를 조회, 삽입, 수정, 삭제하기 위한 다양한 SQL 쿼리를 작성하고 실행했습니다.
- 데이터 관리:
  - MySQL SQL Developer 등의 도구를 활용하여 데이터베이스의 테이블 구조를 확인하고, 데이터를 관리했습니다.

📌 구현 서비스:

본 프로젝트에서는 다음과 같은 주요 서비스를 구현했습니다.

- 회원 관리 서비스:
  - 신규 사용자는 회원 가입을 통해 계정을 생성하고, 기존 사용자는 로그인하여 개인 정보를 관리할 수 있습니다. 또한, 사용자는 관심 있는 레시피를 저장하고, 마이페이지에서 회원 정보를 수정하거나 삭제할 수 있습니다.

- 관리자 업무 서비스:
  - 관리자는 새로운 레시피를 등록하고, 기존 레시피의 정보를 수정하거나 삭제할 수 있습니다. 이를 통해 서비스에 제공되는 레시피를 지속적으로 업데이트하고 관리할 수 있습니다.

- 식재료 관리 서비스:
  - 사용자는 새 식재료를 냉장고에 추가하거나, 기존의 식재료를 수정하고 삭제할 수 있습니다. 이 기능을 통해 식재료의 이름, 수량, 유통기한, 보관 위치 등을 관리하며, 냉장고 내 식재료를 효율적으로 정리할 수 있습니다.

- 유통기한 확인 서비스:
  - 유통기한이 임박한 재료를 확인하고, 유통기한이 지난 재료를 관리할 수 있습니다. 이를 통해 사용자는 음식물 쓰레기를 줄이고, 제때 소비할 수 있는 재료를 확인하여 식재료의 낭비를 방지할 수 있습니다.

- 추천 레시피 확인 서비스:
  - 사용자가 냉장고에 보유한 재료를 기반으로 레시피를 추천하거나, 관리자가 새 레시피를 추가하여 제공할 수 있습니다. 이 기능을 통해 사용자는 냉장고 속 재료를 활용한 다양한 요리법을 쉽게 찾아볼 수 있습니다.

- 식재료 소비 기록 서비스:
  - 사용자가 유통기한 초과로 폐기된 재료를 확인하거나, 한 달 간 섭취된 재료의 소비 패턴을 조회할 수 있습니다. 이를 통해 재료의 소비 패턴을 분석하고, 낭비를 줄이기 위한 알림을 받을 수 있습니다.
---
# ERD
- 유스케이스 다이어그램
![image](https://github.com/user-attachments/assets/8658dde5-97e5-4f53-aa3f-f39e008b3f0c)

- 논리 모델
![ERD1](https://github.com/user-attachments/assets/a50adeb5-9609-4517-a48e-9c1dbbed3435)

- 물리 모델
![ERD2](https://github.com/user-attachments/assets/ac03b371-dbda-4a37-9c18-6ce2574f25f8)
---
# 요구사항 정의서
📌 **기능적 요구사항**
- 식재료 관리
  - 재료 추가: 식재료 이름, 수량, 유통기한, 보관 위치(냉장/냉동/실온) 입력
  - 재료 조회: 전체 식재료 목록 확인 (정렬 가능: 이름, 수량, 유통기한 임박 순, 보관 위치)
  - 재료 수정: 기존 재료의 정보 변경
  - 재료 삭제: 섭취 완료 또는 유통기한 초과로 인한 삭제

- 유통기한 확인
  - 임박 재료 확인: 유통기한이 오늘 ~ 3일 후까지인 재료 목록
  - 기한 초과 재료 확인: 유통기한이 지난 재료 목록

- 추천 레시피 확인
  - 재료 기반 레시피 추천: 냉장고에 등록된 식재료를 기반으로 레시피를 추천

- 식재료 소비 기록
  - 폐기 기록: 최근 한 달간 유통기한 초과로 폐기된 재료 확인
  - 섭취 패턴 분석: 한 달간 4회 이상 섭취된 재료 목록 표시

- 회원 관리
  - 회원 가입: 사용자 계정 등록
  - 로그인: 사용자 인증
  - 마이페이지
    - 회원 정보 조회 및 수정
    - 관심 레시피 확인 및 삭제
    - 회원 탈퇴

- 관리자 기능
  - 레시피 관리: 레시피 등록, 조회, 수정, 삭제

📌 **비기능적 요구사항**
- 사용자 데이터 보호
  - 회원 정보 및 관심 레시피 등 개인정보는 안전하게 저장되어야 하며 외부에 노출되지 않도록 보안 조치를 취해야 한다.

- 권한 기반 접근 제어
  - 관리자 전용 기능(예: 레시피 등록, 수정, 삭제)은 관리자 계정으로만 접근할 수 있어야 한다.

- 데이터 정합성 유지
  - 모든 입력 데이터는 유효성 검사를 거쳐야 하며, 잘못된 데이터는 저장되지 않아야 한다.
  - 예: 유통기한은 과거일 수 없음, 수량은 음수가 될 수 없음 등

- 시스템 응답 속도
  - 사용자가 요청한 기능(재료 조회, 레시피 추천, 회원 정보 수정 등)은 평균적으로 3초 이내에 응답해야 한다.

- 사용자 편의성 (Usability)
  - 인터페이스는 직관적이고 사용자가 별도의 도움 없이 각 기능을 쉽게 사용할 수 있어야 한다.

- 데이터 무결성 보장
  - 재료나 레시피 삭제 시, 연관된 정보가 일관되게 처리되어야 한다.
  - 예: 삭제된 재료가 사용된 레시피에서 자동 제거 혹은 처리 필요

- 시스템 종료 및 초기화
  - 시스템 종료 시, 특정 임시 데이터(예: 세션 정보)는 자동 초기화되어야 하며, 영구 데이터는 손상되지 않아야 한다.
---
# MSA설계서
## 1. 시스템 개요
- "냉장GO" 식재료 관리와 유통기한 알림 시스템은 마이크로서비스 아키텍처(MSA)를 기반으로 사용자 계정 관리, 식재료 관리, 레시피 추천, 유통기한 관리, 식재료 소비 기록 등을 분산 처리하는 시스템입니다.
- 모든 서비스는 독립적으로 개발 및 배포 가능하며, RESTful API를 통해 통신합니다.
- 시스템은 다음과 같은 마이크로서비스로 구성됩니다.
  - 회원 관리 서비스 (Member Mangement Service) : 회원 가입, 로그인, 회원 정보 관리
  - 식재료 관리 서비스 (Ingredient Management Service) : 식재료 등록, 조회, 수정 삭제
  - 유통기한 관리 서비스 (Expiration Confirmation Service) : 유통기한 임박 및 초과 재료 확인
  - 레시피 추천 서비스 (Recipe Recommendation Service) : 식재료 기반 레시피 추천
  - 관리자 업무 서비스 (Admin Task Service) : 레시피 등록, 수정, 삭제
  - 식재료 소비 기록 서비스 (Ingredient Usage Log Service) : 식재료 소비 및 폐기 기록 확인

## 2. 서비스 구성 및 정의
### 2.1 회원 관리 서비스 (Member Management Service)
- 역할: 회원 가입, 로그인, 회원 정보 관리
- 책임:
  - 사용자 계정 등록 및 인증
  - 회원 정보 조회 및 수정
  - 관심 레시피 관리
- 구성 요소:
  - ```MemberController.java```
  - ```MemberService.java```
  - ```MemberRepository.java```
### 2.2 식재료 관리 서비스 (Ingredient Management Service)
- 역할: 식재료 등록, 조회, 수정, 삭제
- 책임:
  - 식재료 이름, 수량, 유통기한, 보관 위치 등록
  - 식재료 목록 조회 (정렬 기능 포함)
  - 식재료 정보 수정 및 삭제
- 구성 요소:
  - ```ingCon.java```
  - ```ingredientService.java```
  - ```ingredientRepository.java```
### 2.3 유통기한 관리 서비스 (Expiration Confirmation Service)
- 역할: 유통기한 임박 및 초과 재료 확인
- 책임:
  - 유통기한 임박 재료 목록 제공 (오늘~3일 후)
  - 유통기한 초과 재료 목록 제공
- 구성 요소:
  - ```ExpirationController.java```
  - ```ApproachService.java```
  - ```ExcessService.java```
  - ```ApproachRepository.java```
  - ```ExcessRepository.java```
### 2.4 레시피 추천 서비스 (Recipe Recommendation Service)
- 역할: 식재료 기반 레시피 추천
- 책임:
  - 등록된 식재료를 기반으로 레시피 추천
  - 추천된 레시피 목록 제공
- 구성 요소:
  - ```RecommendController.java```
  - ```RecommendService.java```
  - ```RecommendRepository.java```
### 2.5 관리자 업무 서비스 (Admin Task Service)
- 역할: 레시피 등록, 수정, 삭제
- 책임:
  - 관리자가 새로운 레시피 등록 및 수정
  - 관리자가 레시피 삭제
  - 전체 레시피 조회
- 구성 요소:
  - ```AdminController.java```
  - ```AdminService.java```
  - ```AdminRepository.java```
### 2.6 식재료 소비 기록 서비스 (Ingredient Usage Log Service)
- 역할: 식재료 소비 및 폐기 기록 관리
- 책임:
  - 폐기된 재료 기록
  - 섭취 패턴 분석 (한 달간 4회 이상 섭취 재료 표시)
- 구성 요소:
  - ```managementService.java```
  - ```managementRepository.java```
  - ```Management.java```
 
## 3. API
### 회원 관리
- POST ```/member/signup``` - 회원 가입
- POST ```/member/login``` - 로그인
- GET ```/member/mypage``` - 회원 정보 조회
- PUT ```/member/update``` - 회원 정보 수정
- DELETE ```/member/delete``` - 회원 탈퇴
### 식재료 관리
- POST ```/ingredient/add``` - 식재료 추가
- GET ```/ingredient/list``` - 식재료 목록 조회
- PUT ```/ingredient/update``` - 식재료 수정
- DELETE ```/ingredient/delete``` - 식재료 삭제
### 유통기한 관리
- GET ```/expiration/near``` - 임박 식재료 조회
- GET ```/expiration/expired``` - 유통기한 초과 식재료 조회
### 레시피 추천
- GET ```/recommend/recipes``` - 추천 레시피 조회
### 관리자 기능
- POST ```/admin/recipe/add``` - 레시피 등록
- PUT ```/admin/recipe/update``` - 레시피 수정
- DELETE ```/admin/recipe/delete``` - 레시피 삭제
- GET ```/admin/recipe/list``` - 전체 레시피 목록 조회
### 소비 기록 관리
- GET ```/usage/history``` - 소비 기록 조회
- GET ```/usage/pattern``` - 섭취 패턴 분석

## 4. 서비스 연동 흐름도
- 사용자는 회원 가입 및 로그인을 통해 인증 완료
- 인증된 사용자는 식재료 추가 및 조회 기능 이용
- 시스템은 유통기한 임박 재료를 식별하여 알림 제공
- 사용자는 추천 레시피를 통해 식사 준비 가능
- 식재료 소비/폐기 활동은 소비 기록에 자동 저장
- 관리자는 레시피 관리 기능을 통해 전체 데이터 관리
---
# 화면설계서

# 스토리보드
### 로그인 기능

![image](https://github.com/user-attachments/assets/629d03f6-2b07-4b73-8388-75078593e8d0)
![image](https://github.com/user-attachments/assets/17025f7a-1104-4612-a747-55140a9454e3)

### 마이페이지 기능
![image](https://github.com/user-attachments/assets/68193d04-3cd3-44dc-8453-d4f62e218e9e)


### 식재료 관리 기능

![image](https://github.com/user-attachments/assets/c24514e2-c390-451f-af28-392b318127c8)
![image](https://github.com/user-attachments/assets/7fc606e8-ef97-40cd-9f17-f47e3c9a8394)
![image](https://github.com/user-attachments/assets/dbdaa230-aea9-4a11-9c16-f9d43a990fe8)
![image](https://github.com/user-attachments/assets/1fc5cc44-90f1-435a-adc2-244a327e5282)
![image](https://github.com/user-attachments/assets/ee46b84d-bac5-4b33-aff0-004b487e5ff6)

### 관리자 업무 기능

![image](https://github.com/user-attachments/assets/f27f3868-34b5-480c-be43-de5cc3386cf7)
![image](https://github.com/user-attachments/assets/4e015b19-a9ae-489c-aa64-f6869520c9f4)
![image](https://github.com/user-attachments/assets/49917974-ebd0-4833-8317-dec6649f16cd)
![image](https://github.com/user-attachments/assets/deaa6782-3e5a-4fc5-bd4d-660134109e9d)
![image](https://github.com/user-attachments/assets/09b7353a-21e0-4447-bc98-edff73d4c0ad)

### 유통기한 확인 기능
![image](https://github.com/user-attachments/assets/0c73134b-4584-4d1a-8aba-2a6debdc1a6d)
![image](https://github.com/user-attachments/assets/bd5b9daf-5dc1-488a-bcfd-267c5edc7750)
![image](https://github.com/user-attachments/assets/c4eb1fd4-1771-4bc9-8388-581118e69935)






# 기술스택
- **프로그래밍 언어** : 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- **DB(데이터베이스)** :
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
- **버전 관리** : 
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
- **개발 도구** :
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

# 회고
- 임나연
  - 회고 작성 칸
- 이나영
  - 회고 작성 칸
- 임현우
  - 회고 작성 칸 
- 박창준
  - 비전공자이기도 하고 git과 github를 이용해서 서로 협업부터 팀원들과 각자 맡은 기능 구현을 하는것도 처음이었기 때문에 팀프로젝트를 하는데 어려움이 있었다. 특히 코딩을 어려워해서 내가 도움이 될 수 있을까 걱정을 많이했지만 팀원분들이 너무 적극적으로 잘 도와주셔서 덕분에 마무리를 잘한거 같다. 나 혼자였으면 절대 못했을 프로젝트지만 팀원분들이 있기에 힘들었지만 열심히 할 수 있었던 원동력이 되었던거 같다. 수업시간에는 완벽하게 이해는 못했어도 들을때 만큼은 어느정도 이해를 했다고 생각했는데 직접 프로젝트를 진행해보니 배운내용을 직접 구현할 때 잘하지 못한 내 자신이 많이 아쉬웠다. 그렇지만 무엇보다도 혼자할때와 팀원분들과 협업하여 프로젝트라는 하나의 결과물을 만들어가는 과정에서 정말 많은 도움이 되었던거 같다. 막히는 부분이 있을때마다 옆에서 도움을 주셨고 서로 하나하나 과정속에서 해결해 나가는 과정은 혼자 했을때와는 차원이 다를 정도로 협업해서 무언가를 한다는게 엄청난 시너지 효과가 있는거 같다. 다음 프로젝트에는 내가 좀 더 열심히해서 팀원분들에게 더욱 도움이 될 수 있는 사람이 되고 싶다. 앞으로 이런 경험을 계속 해보고 싶고 잘하고 싶은 마음이 이번 프로젝트를 통해 많이 생겼다. 끝으로 처음 팀이 구성이 되었을때 걱정되는부분이 많아 자신감이 없었는데 오히려 팀원분들이 걱정하지말라고 내 입장에서 생각해서 말씀해주신게 너무나 큰 도움이 되어서 너무 감사했다.






