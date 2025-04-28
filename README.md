# 프로젝트 기획서
---
# 개요
- 프로젝트명 : 냉장GO - 식재료 관리와 유통기한 알림 시스템
- 프로젝트 기간 : 2025-04-22 ~ 2025-04-24
---
# 팀원 구성
| 임나연 | 이나영 | 임현우 | 박창준 |
|--------|--------|--------|--------|
| ![임나연](https://avatars.githubusercontent.com/u/106491547?v=4) | ![이나영](https://avatars.githubusercontent.com/u/123456789?v=4) | ![임현우](https://avatars.githubusercontent.com/u/106491547?v=4) | ![박창준](https://avatars.githubusercontent.com/u/123456789?v=4) |
| [GitHub](https://github.com/nyaeon) | [GitHub](https://github.com/NYoungLEE) | [GitHub](https://github.com/LimHub) | [GitHub](https://github.com/changjunpark13) |
---
# 목적 및 배경
- "냉장GO" 프로젝트의 목적은 사용자가 식재료를 효율적으로 관리하고, 유통기한에 따른 소비 패턴을 분석하여 낭비를 최소화하며, 다양한 레시피를 통해 식재료를 유용하게 활용할 수 있도록 돕는 것입니다. 이 시스템은 냉장고에 보관된 식재료의 정보를 체계적으로 관리하고, 유통기한 임박 또는 유통기한이 지난 재료를 빠르게 확인하며, 사용자에게 보관된 식재료를 바탕으로 레시피를 추천하고, 소비 패턴 정보를 제공합니다. 또한, 사용자 계정 관리 기능을 통해 개인 맞춤형 서비스를 제공하여, 전반적인 식생활의 효율성을 높이는 데 기여하고자 합니다.

- 최근 식품 소비에서의 낭비 문제는 큰 사회적 이슈로 떠오르고 있습니다. 많은 사람들이 식재료를 구입한 후 보관 상태나 유통기한을 제대로 확인하지 않아 불필요하게 폐기되는 경우가 많습니다. 이를 해결하기 위해, "냉장GO" 프로젝트는 식재료를 체계적으로 관리하고, 사용자가 유통기한을 쉽게 확인할 수 있도록 도와주는 시스템을 제공합니다. 또한, 사용자에게 적합한 레시피를 추천하고, 과도한 소비나 낭비를 방지하는 알림 기능을 제공하여, 더욱 효율적이고 건강한 식생활을 지원하는 서비스입니다.
본 프로젝트는 사용자가 자신의 식재료를 관리하고, 이를 기반으로 필요한 레시피를 추천받는 방식으로, 식품의 낭비를 줄이고, 사용자에게 실용적인 도움을 제공하는 것을 목표로 합니다. 이를 통해 식품 관리의 편리함을 제공하고, 환경적으로도 긍정적인 영향을 미칠 수 있습니다.

---
# 시장 조사

### 여름철 음식 안전, 냉장고가 90%는 책임진다
여름철은 고온다습한 환경으로 인해 식중독균과 부패세균의 증식이 매우 활발한 계절입니다. 기온이 10℃ 오르면 식중독균 증식 속도는 2배 이상 빨라지고, 특히 30℃ 이상이 되는 날씨엔 식중독 발생률이 약 3배까지 증가하는 것으로 알려져 있습니다. 실제로 식품의약품안전처에 따르면, 식중독 발생 건수의 약 40%가 6~8월 여름철에 집중되어 있습니다.

기온 상승으로 인해 식재료의 부패 속도가 눈에 띄게 빨라지면서, 식품 위생과 안전에 대한 경각심이 높아지고 있습니다. 이에 따라 식재료의 보관, 관리, 신선도 유지에 대한 수요가 증가하고 있으며, 이를 *효율적으로 지원할 수 있는 서비스나 시스템의 필요성도 함께 커지고 있습니다.

![image](https://github.com/user-attachments/assets/7c2458e0-7d4c-4437-9ed5-ebde7613d782)

출처- [푸드 & 메드](http://www.foodnmed.com/news/articleView.html?idxno=20405)

### 냉장고 식재료 관리, 식비 절감의 핵심
식재료 관리의 중요성은 단순히 유통기한을 지키는 것에 그치지 않습니다. 중복 구매나 식품 폐기를 방지하려면 냉장고 속 식재료 현황을 철저히 파악하는 것이 중요합니다. 냉동실에 유통기한 지난 식품이나 냉장실에 오래된 반찬이 방치되는 일이 빈번히 발생하는데, 이는 식비뿐만 아니라 식품 쓰레기 발생, 에너지 낭비, 시간 손실 등 다양한 문제를 초래합니다.

![image](https://github.com/user-attachments/assets/e943a637-c627-4335-a2e3-a6e20056ea0e)

출처- [재테크 Lab](https://www.thescoop.co.kr/news/articleView.html?idxno=304299)

### MZ세대, 요리 붐에 빠지다… 기업들이 먼저 눈치 챘다
MZ세대의 건강과 요리에 대한 관심이 높아지면서, 식재료에 대한 관심도 급증하고 있다. 이에 따라 식음료 관련 기업들이 MZ세대의 문화와 트렌드를 반영한 다양한 팝업샵을 개최하며 그들의 관심을 사로잡고 있다.

![image](https://github.com/user-attachments/assets/463d1834-ec6a-4758-bd77-2abbed721b47)

출처- [사례뉴스](https://www.casenews.co.kr/news/articleView.html?idxno=12301)

---

# 유사 프로그램 분석
### 1. BEEP
#### 식재료 등록 페이지
![image](https://github.com/user-attachments/assets/50d6e9cf-ee82-4c6d-aecd-0d2ea9c7ce0f)

#### 유통기한 확인 페이지
![image](https://github.com/user-attachments/assets/382a32e7-c952-4238-9fcb-ec24df94fe02)


### 2. 만개의 레시피
#### 재료기반 추천 레시피 확인
![image](https://github.com/user-attachments/assets/1508e3eb-0a57-4a87-bcce-589994ccdba9)
![image](https://github.com/user-attachments/assets/27cdc172-06ed-4bf3-a546-075edf29aade)

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
  - 신규 사용자는 회원 가입을 통해 계정을 생성하고, 기존 사용자는 로그인하여 개인 정보를 관리할 수 있습니다. 또한, 사용자는 마이페이지에서 저장된 관심 있는 레시피를 확인하고, 회원 정보를 수정하거나 삭제할 수 있습니다.

- 관리자 업무 서비스:
  - 관리자는 새로운 레시피를 등록하고, 기존 레시피의 정보를 수정하거나 삭제할 수 있습니다. 이를 통해 서비스에 제공되는 레시피를 지속적으로 업데이트하고 관리할 수 있습니다.

- 식재료 관리 서비스:
  - 사용자는 새 식재료를 냉장고에 추가하거나, 기존의 식재료를 수정하고 삭제할 수 있습니다. 이 기능을 통해 식재료의 이름, 수량, 유통기한, 보관 위치 등을 확인하여 냉장고 내 식재료를 효율적으로 관리할 수 있습니다.

- 유통기한 확인 서비스:
  - 유통기한이 임박한 재료 또는 유통기한이 지난 재료를 확인하여 식재료를 관리할 수 있습니다. 이를 통해 사용자는 음식물 쓰레기를 줄이고, 제때 소비할 수 있는 재료를 확인하여 식재료의 낭비를 방지할 수 있습니다.

- 추천 레시피 확인 서비스:
  - 사용자가 냉장고에 보유한 재료를 기반으로 레시피를 추천받고 해당 레시피를 관심 레시피로 저장할 수 있습니다. 이 기능을 통해 사용자는 냉장고 속 재료를 활용한 다양한 요리법을 쉽게 찾아볼 수 있습니다.

- 식재료 소비 기록 서비스:
  - 사용자가 유통기한 초과로 폐기된 재료 또는 한 달간 자주 섭취한 재료를 확인하여 사용자의 소비 습관을 확인할 수 있습니다.
---
# ERD
- 유스케이스 다이어그램
![image](https://github.com/user-attachments/assets/84b68a3a-5705-42b9-a407-9589aad0ef7f)


- 논리 모델
![image](https://github.com/user-attachments/assets/7666a4ae-0106-464b-ba59-aa0377522fbc)


- 물리 모델
![image](https://github.com/user-attachments/assets/d1f00d56-3b2f-4515-af39-b70b3e89795b)

---
# 요구사항 정의서
📌 **기능적 요구사항**
- 식재료 관리
  - 재료 추가: 식재료 이름, 수량, 유통기한, 보관 위치(냉장/냉동/실온) 입력
  - 재료 조회: 전체 식재료 목록 확인
  - 재료 수정: 기존 재료의 정보 변경
  - 재료 삭제: 섭취 완료 또는 유통기한 초과로 인한 삭제

- 유통기한 확인
  - 임박 재료 확인: 유통기한이 금일 ~ 3일 후까지인 재료 목록
  - 기한 초과 재료 확인: 유통기한이 지난 재료 목록

- 추천 레시피 확인
  - 재료 기반 레시피 추천: 냉장고에 등록된 식재료를 기반으로 레시피를 추천
  - 관심 레시피로 등록

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
- 모든 서비스는 독립적으로 개발되며, 각각 JDBC를 통해 데이터베이스에 직접 연결하여 데이터 처리를 수행합니다.
- 시스템은 다음과 같은 마이크로서비스 개념을 참고하여 논리적으로 서비스들을 분리하여 구성됩니다.
  - 회원 관리 서비스 (Member Mangement Service) : 회원 가입, 로그인, 회원 정보 관리
  - 관리자 업무 서비스 (Admin Task Service) : 레시피 등록, 수정, 삭제
  - 식재료 관리 서비스 (Ingredient Management Service) : 식재료 등록, 조회, 수정,삭제
  - 유통기한 관리 서비스 (Expiration Confirmation Service) : 유통기한 임박 및 초과 재료 확인
  - 레시피 추천 서비스 (Recipe Recommendation Service) : 식재료 기반 레시피 추천, 레시피 저장
  - 식재료 소비 기록 서비스 (Ingredient Usage Log Service) : 식재료 소비 및 폐기 기록 확인

## 2. 서비스 구성 및 정의
### 2.1 회원 관리 서비스 (Member Management Service) - 박창준님
- 역할: 회원 가입, 로그인, 회원 정보 관리
- 책임:
  - 사용자 계정 등록 및 인증
  - 회원 정보 조회 및 수정
  - 관심 레시피 관리(조회 및 삭제)
- 구성 요소:
  - ```MemberController.java```
  - ```MemberService.java```
  - ```MemberRepository.java```
### 2.2 식재료 관리 서비스 (Ingredient Management Service) - 임현우님
- 역할: 식재료 등록, 조회, 수정, 삭제
- 책임:
  - 식재료 이름, 수량, 유통기한, 보관 위치 등록
  - 식재료 목록 조회
  - 식재료 정보 수정 및 삭제
- 구성 요소:
  - ```IngredientController.java```
  - ```IngredientService.java```
  - ```IngredientRepository.java```
### 2.3 유통기한 관리 서비스 (Expiration Confirmation Service) - 이나영님
- 역할: 유통기한 임박 및 초과 재료 확인
- 책임:
  - 유통기한 임박 재료 목록 제공 (금일~3일 후)
  - 유통기한 초과 재료 목록 제공
- 구성 요소:
  - ```ExpirationController.java```
  - ```ExpirationService.java```
  - ```ExpirationRepository.java```
### 2.4 레시피 추천 서비스 (Recipe Recommendation Service) - 이나영님
- 역할: 식재료 기반 레시피 추천
- 책임:
  - 등록된 식재료를 기반으로 레시피 추천
  - 추천 레시피를 관심 레시피로 등록
- 구성 요소:
  - ```RecommendController.java```
  - ```RecommendService.java```
  - ```RecommendRepository.java```
### 2.5 관리자 업무 서비스 (Admin Task Service) - 임나연님
- 역할: 레시피 등록, 수정, 삭제
- 책임:
  - 관리자가 새로운 레시피 등록 및 수정
  - 관리자가 레시피 삭제
  - 전체 레시피 조회
- 구성 요소:
  - ```AdminController.java```
  - ```AdminService.java```
  - ```AdminRepository.java```
### 2.6 식재료 소비 기록 서비스 (Ingredient Usage Log Service) - 임현우님
- 역할: 식재료 소비 및 폐기 기록 관리
- 책임:
  - 폐기된 재료 기록
  - 섭취 패턴 분석 (한 달간 4회 이상 섭취 재료 표시)
- 구성 요소:
  - ```ManagementController.java```
  - ```ManagementService.java```
  - ```ManagementRepository.java```
 
## 3. CRUD(Create:생성, Read:조회, Update:수정, Delete:삭제)
### 3-1. 회원 관리 서비스 (MemberService) - 박창준님
| 데이터 대상 | 작업 | 메소드명 | 설명 |
|:-----------|:----|:---------|:----|
| Member | Create | `signUp(Member member)` | 회원 가입 |
| Member | Read | `getMemberInfo(Member mem)` | 회원 정보 조회 |
| Member | Update | `updateMemberInfo(Member member)` | 회원 정보 수정 |
| Member | Delete | `deleteMemberInfo(String userId)` | 회원 탈퇴 |
| Save_Recipe | Read | `showFavoriteRecipes(String userId)` | 관심 레시피 목록 조회 |
| Save_Recipe | Delete | `deleteFavoriteRecipe(String userId, String recipeName)` | 관심 레시피 삭제 |
### 3-2. 관리자 레시피 관리 서비스 (AdminService) - 임나연님
| 데이터 대상 | 작업 | 메소드명 | 설명 |
|:-----------|:----|:---------|:----|
| Recipe | Create | `insertRecipe(Recipe recipe)` | 레시피 등록 |
| Recipe | Read | `selectAllRecipes()` | 전체 레시피 목록 조회 |
| Recipe | Read | `getRecipeByName(String name)` | 레시피 이름으로 조회 |
| Recipe | Update | `updateRecipe(Recipe recipe, String oldName)` | 레시피 수정 |
| Recipe | Delete | `deleteRecipe(String name)` | 레시피 삭제 |
### 3-3. 식재료 관리 서비스 (IngredientService) - 임현우님
| 데이터 대상 | 작업 | 메소드명 | 설명 |
|:-----------|:----|:---------|:----|
| Ingredients | Create | `registIngredient(Ingredients ingredient, String userId)` | 식재료 등록 |
| Ingredients | Read | `checkIngredient(String userId)` | 식재료 재고 확인 |
| Ingredients | Update | `modifyIngredient(Ingredients modIng)` | 식재료 정보 수정 |
| Ingredients | Delete | `removeIngredient(String name, LocalDate date, String userId)` | 식재료 삭제 |
### 3-4. 유통기한 확인 서비스 (ExpirationService) - 이나영님
| 데이터 대상 | 작업 | 메소드명 | 설명 |
|:-----------|:----|:---------|:----|
| Ingredients | Read | `searchApp(Ingredients ing, String userId)` | 유통기한 임박 재료 조회 |
| Ingredients | Read | `searchExc(Ingredients ing, String userId)` | 유통기한 초과 재료 조회 |
### 3-5. 레시피 추천 서비스 (RecommendService) - 이나영님
| 데이터 대상 | 작업 | 메소드명 | 설명 |
|:-----------|:----|:---------|:----|
| Save_Recipe | Create | `saveRecipe(String recipeName)` | 관심 레시피 저장 |
| Ingredients | Read | `searchIng(String userId)` | 등록된 식재료 조회 |
| Recipe | Read | `searchRecipe(Recipe recipe)` | 레시피 검색 |
### 3-6. 식재료 소비 기록 서비스 (ManagementService) - 임현우
| 데이터 대상 | 작업 | 메소드명 | 설명 |
|:-----------|:----|:---------|:----|
| Exp_Ingredients | Read | `serchIngredient(String id)` | 폐기된 재료 조회 |
| Exp_Ingredients | Read | `oftenconsumIngredient(String id)` | 자주 소비한 재료 조회 |
| Exp_Ingredients | Update | `updateDelete(Management menu)` | 식재료 소비/폐기 기록 업데이트 |
## 4. 서비스 연동 흐름도
- 사용자는 회원 가입 및 로그인을 통해 인증 완료
- 인증된 사용자는 식재료 추가 및 조회 기능 이용
- 시스템은 유통기한 임박 재료를 식별하여 알림 제공
- 사용자는 추천 레시피를 통해 식사 준비 가능
- 식재료 소비/폐기 활동은 소비 기록에 자동 저장
- 관리자는 레시피 관리 기능을 통해 전체 데이터 관리
---
# 화면설계서
# 1. 프로젝트 개요

- 프로젝트명 : Frozen - 식재료 관리 및 유통기한 소비 습관 알림 시스템.
- 목적 : 사용자가 등록한 식재료를 관리하고, 유통기한 임박 알림 및 레시피 추천을 통해 식재료 소비를 촉진한다. 또한 기간 내에 폐기된 음식물을 알려주어 소비 습관을 개선한다. 관리자 기능을 통해 레시피 관리가 가능하다.

# 2. 전체화면목록
![image](https://github.com/user-attachments/assets/9dfa55bb-7478-4ad2-9b70-1eff10d07787)

# 3.화면 간 이동 흐름

[회원가입] → [로그인] → [대시보드]

대시보드 → 식재료 관리 → 식재료 추가 / 수정 / 삭제 /조회

대시보드 → 유통기한 확인 → 임박/초과  재료 확인

대시보드 → 추천 레시피 확인 → 추천 레시피 조회/관심 레시피로 등록

대시보드 → 식재료 소비 기록 → 폐기/섭취 식재료 조회

대시보드 → 마이페이지 → 개인정보 수정/삭제

대시보드 → 마이페이지 → 관심레시피 확인/삭제

(관리자) 로그인 → 관리자 업무 → 레시피 등록/수정/삭제/조회

# 4.주요 기능 명세(요약)
![image](https://github.com/user-attachments/assets/932d1d5f-cee1-49bf-8ad8-3fdc38080f07)



---
# 스토리보드
### 로그인 기능

![{91F2EA15-DA17-4C41-A73C-7FC81FB951DD}](https://github.com/user-attachments/assets/ead9c26c-9fb4-4bd6-a163-a4116432a80e)

### 메인 화면

![{ABA0ABE5-4186-4A86-854F-DADA17D45345}](https://github.com/user-attachments/assets/d6288df2-cbf9-4d1c-86e2-64cd49ca4e49)

### 식재료 관리 기능

![{E48EB039-0359-4A49-AB07-7ADD78E40B72}](https://github.com/user-attachments/assets/308c14ee-e104-4666-b6f8-1eeb5e8077f9)
![{E5E26A7B-9BD9-4D2D-B47E-B741FF921DF1}](https://github.com/user-attachments/assets/b1c6657a-3bb6-498a-ab9c-d0182c5409bf)
![{82C15F86-9AFA-415A-9F27-10D93E39D280}](https://github.com/user-attachments/assets/24bf7ed1-f5e7-4a7f-a150-dc1ec99229cf)
![{D719D5DD-7218-4CA0-AD29-47AE680C633E}](https://github.com/user-attachments/assets/9365f376-9bfa-4b3c-ad7b-1fba090da677)
![{FADFFB2A-429B-4449-BD3C-005B8D28A91B}](https://github.com/user-attachments/assets/5bd36f46-f29c-4d94-9d6f-abd16a7c64a1)

### 유통기한 확인 기능

![{C8850723-DEB7-4465-BD7A-E007E4DD678A}](https://github.com/user-attachments/assets/a9749025-187f-4b8f-a0ab-72fc24833de6)
![{4B4E9A71-2651-46F4-A925-7D400E7231E8}](https://github.com/user-attachments/assets/256b58b4-ec23-4ce7-8df9-4b6496223ad0)

### 추천 레시피 확인 기능

![{0D4ABA2D-6AF9-4D44-AE30-89247E821F4A}](https://github.com/user-attachments/assets/b78af300-3a44-45f9-be3a-98d77ced2e96)
![{861AEEA9-6611-499E-975E-3AE1BC720704}](https://github.com/user-attachments/assets/6b68aa06-932d-4a6f-892f-416c64765aba)

### 식재료 소비 기록 기능

![{D14E161D-75D5-403E-ACBE-7BD035124B54}](https://github.com/user-attachments/assets/821139e4-7a51-4117-abea-67673b70cc35)
![{F45CB302-0432-4F9C-8409-00A525DA31F9}](https://github.com/user-attachments/assets/c19fee24-0ade-4ec1-b515-dd858ae0659b)


### 마이페이지 기능

![{96E71C5A-8E23-4625-8B5D-D603867373F3}](https://github.com/user-attachments/assets/cdac5170-d0b3-418a-a2ad-e9a1d6608937)
![{B75599C4-A9EB-4ADD-9FB0-4AE157314CE6}](https://github.com/user-attachments/assets/d850773a-5d0e-45b7-a144-dc995e0bc69b)
![{088F0A8A-B598-4D07-A970-ACECD2205195}](https://github.com/user-attachments/assets/0091994d-087f-49f5-8528-e470bfb29d0b)
![{5F72221C-9EAF-4A23-BC38-594F11ACCD69}](https://github.com/user-attachments/assets/2681dfab-896e-4dfb-8a4a-905c958f99db)
![{692E0618-9951-44E8-8B53-78F49CE567C8}](https://github.com/user-attachments/assets/7e6791ce-92cd-46ac-aa56-16925205422e)


### 관리자 업무 기능

![{BAF6F659-214F-4EB6-8E80-812BA5599D0B}](https://github.com/user-attachments/assets/01878f82-211a-4517-8b3e-e868797b796a)
![{1762CE3A-854E-4A7A-A750-6F78053640E3}](https://github.com/user-attachments/assets/4f9c6c4e-e384-4d91-b564-28539ac657c9)
![{376F001B-3732-452A-9467-F61A12B2BA72}](https://github.com/user-attachments/assets/05e79475-3baa-4b3d-a724-f527ea4a41f5)
![{C7BACF1C-48FD-47EC-913B-63C2BB912939}](https://github.com/user-attachments/assets/e9f26644-e21b-451f-862f-c98b5350f1c5)

---
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
---
# 회고
### 임나연
  - 이틀이라는 짧은 시간 동안 진행된 프로젝트를 무사히 마무리했다. 처음에는 과연 기획과 개발을 모두 끝낼 수 있을지 걱정이 컸지만, 촉박한 일정 속에서도 팀원들과 합을 맞추며 끝까지 완성할 수 있었다. 플레이데이터에서의 첫 프로젝트였던 만큼 긴장도 있었지만, 서로를 배려하고 존중하는 팀원들과 함께할 수 있어 큰 힘이 되었다.
각자 맡은 기능 개발에 책임감을 가지고, 부족한 부분은 서로 피드백하며 보완해나갔다. 덕분에 자연스럽게 커뮤니케이션도 원활하게 이어질 수 있었다. 처음에는 방향을 잡는 것조차 막막했지만, 함께 고민하고 협력하는 과정 속에서 많은 것을 배우고 성장할 수 있었다.
특히 직접 부딪히고 시도해보는 경험이 얼마나 중요한지 깨달을 수 있었다. 이번 프로젝트를 통해 현재 나의 개발 역량을 객관적으로 돌아볼 수 있었고, 앞으로 어떤 부분을 더 보완해야 할지 방향을 잡을 수 있었다. 이를 발판 삼아 더 성장해나가야겠다는 다짐도 하게 되었다.
비록 이번 프로젝트는 콘솔로 출력되는 간단한 CRUD 기능을 구현하는 수준이었지만, 더 많은 시간과 기회가 주어진다면 어떤 프로젝트를 완성해낼 수 있을지 기대가 된다.
무엇보다도, 이번 결과물은 모든 팀원이 열정적으로 참여하고 협력한 끝에 만들어낸 것이기에 더욱 뜻깊게 느껴진다.
모두 정말 고생 많으셨습니다! ☺️👍

### 이나영
  - 한 달 동안 배운 내용을 바탕으로 첫 번째 프로젝트를 진행하였다. 팀원들과 함께 기획부터 실제 구현, 보고서 작성까지 전 과정을 경험하면서, 비록 간단한 프로젝트였지만 짧은 시간 안에 많은 것을 느끼고 배울 수 있었다. 특히 수업 시간에 배웠던 내용을 직접 프로젝트에 적용해보면서 개념을 더욱 명확하게 이해할 수 있었다. 처음에는 JDBC를 이용해 데이터베이스에 직접 연결하고, CRUD 기능을 수행하여 콘솔창에 원하는 결과를 출력하는 데까지 꽤 많은 시간이 소요되었다. 수업 시간에 작성했던 코드를 참고하고 이해하여 응용해야 했기 때문에, 초반에는 다소 헷갈리는 부분도 있었다. 그러나 프로젝트를 진행할수록 비슷한 기능을 구현하는 데 걸리는 시간이 점점 짧아지면서, 스스로 성장하고 있다는 것을 느낄 수 있었다. 또한 학부생 시절과 달리, 패키지 구조와 계층 구조를 신경 쓰며 코드를 작성해본 덕분에 프로젝트의 파일 구성과 구조가 훨씬 명확하게 정리되었다. 강사님께서 파일 관리와 추후 병합을 고려하여 새로운 브랜치를 생성하고 merge하는 방식으로 깃 관리를 해야 한다고 강조하셨지만, 코드 구현에만 집중하다 보니 이를 제대로 하지 못한 점은 아쉬움으로 남는다. 이외에도 작은 아쉬움들이 있었지만, 팀원들과 협력하여 하나의 결과물을 완성했다는 것에 큰 뿌듯함을 느꼈다. 이번 프로젝트 경험을 바탕으로 다음 프로젝트에서는 더 나은 깃 관리, 협업, 코드 품질을 목표로 한층 성장한 모습을 보여주고 싶다. 앞으로도 꾸준히 노력하여 더 좋은 결과물을 만들어낼 수 있도록 노력할 것이다.

### 임현우
  - 첫 프로젝트로 이틀이라는 짧은 시간 동안 식재료 관리 및 유통기한 알림 시스템을 JAVA를 이용해 팀 프로젝트로 진행하며 많은 경험을 했다. 우리 팀은 다 같이 프로젝트 기획을 하며 데이터 모델링 설계에도 모두 참여했다. 그 후 JAVA를 통해 기능 구현 부분은 역할을 나누어 진행했는데, 이번 프로젝트에서 나는 식재료 CRUD 기능과 **식재료 소비 기록(섭취 완료/유통기한 폐기로 인한 삭제된 식재료 조회 기능)**을 맡았다. 처음에는 SQL 문법을 자바와 함께 사용해 데이터를 조회하고 조작하는 과정이 익숙하지 않아, 간단한 CRUD 작업에도 어려움을 많이 느꼈다. 그때마다 배운 내용을 다시 복습하며 문제를 해결하려고 노력했다. 이번 프로젝트를 통해 디버깅의 중요성을 알게 되었고, 내 코드가 어느 부분까지 제대로 작동하는지를 확인하기 위해 중간중간 출력문을 삽입해 과정을 추적했다. 그 과정에서 시간이 다소 오래 걸려, 결국 시간 안에 원하는 기능 구현을 완성하지 못한 점이 가장 아쉬웠다. 또한 첫 협업 프로젝트였기 때문에 팀원들과의 소통을 더 잘할 수 있지 않았을까 하는 아쉬움도 남는다. 프로젝트 도중 데이터 테이블을 수정해야 하는 상황이 발생했고, 이로 인해 코드 수정이 많아졌던 것도 어려운 부분 중 하나였다. 다음 프로젝트에서는 팀원들과 더욱 활발하게 소통하고, 특히 데이터 설계 부분에서 더 꼼꼼하게 대화를 나누어 테이블 수정으로 인한 대규모 코드 수정 상황을 줄여야겠다고 느꼈다. 또한, 내가 생각하는 대로 코드를 구현할 수 있도록 코딩 연습을 더 많이 해야겠다는 다짐도 하게 되었다. 첫 프로젝트여서 아쉬움이 많이 남지만, 팀원들과 함께 문제를 해결해 나가는 과정을 통해 많은 것을 배울 수 있었던 값진 경험이었다. 

### 박창준
  - 비전공자이기도 하고 git과 github를 이용해서 서로 협업부터 팀원들과 각자 맡은 기능 구현을 하는것도 처음이었기 때문에 팀프로젝트를 하는데 어려움이 있었다. 특히 코딩을 어려워해서 내가 도움이 될 수 있을까 걱정을 많이했지만 팀원분들이 너무 적극적으로 잘 도와주셔서 덕분에 마무리를 잘한거 같다. 나 혼자였으면 절대 못했을 프로젝트지만 팀원분들이 있기에 힘들었지만 열심히 할 수 있었던 원동력이 되었던거 같다. 수업시간에는 완벽하게 이해는 못했어도 들을때 만큼은 어느정도 이해를 했다고 생각했는데 직접 프로젝트를 진행해보니 배운내용을 직접 구현할 때 잘하지 못한 내 자신이 많이 아쉬웠다. 그렇지만 무엇보다도 혼자할때와 팀원분들과 협업하여 프로젝트라는 하나의 결과물을 만들어가는 과정에서 정말 많은 도움이 되었던거 같다. 막히는 부분이 있을때마다 옆에서 도움을 주셨고 서로 하나하나 과정속에서 해결해 나가는 과정은 혼자 했을때와는 차원이 다를 정도로 협업해서 무언가를 한다는게 엄청난 시너지 효과가 있는거 같다. 다음 프로젝트에는 내가 좀 더 열심히해서 팀원분들에게 더욱 도움이 될 수 있는 사람이 되고 싶다. 앞으로 이런 경험을 계속 해보고 싶고 잘하고 싶은 마음이 이번 프로젝트를 통해 많이 생겼다. 끝으로 처음 팀이 구성이 되었을때 걱정되는부분이 많아 자신감이 없었는데 오히려 팀원분들이 걱정하지말라고 내 입장에서 생각해서 말씀해주신게 너무나 큰 도움이 되어서 너무 감사했다.






