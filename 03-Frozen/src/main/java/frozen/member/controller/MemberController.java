package frozen.member.controller;

import frozen.member.model.dto.Member;
import frozen.member.model.dao.MemberRepository;
import frozen.member.model.service.MemberService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MemberController {

    private static String userId = null;

    public static void memberRun() {
        MemberService memberService = new MemberService(new MemberRepository());
        Scanner sc = new Scanner(System.in);

        boolean isLoggedIn = false;  // 로그인 상태 추적
        String userId = null;  // 로그인된 사용자 ID

        // 로그인 후 메뉴
        String loggedInMenu = """
                ============== 마이페이지 ==============
                1. 회원 정보 조회
                2. 회원 정보 수정
                3. 회원 정보 삭제
                4. 관심 레시피 확인
                5. 관심 레시피 삭제
                0. 로그아웃
                ==================================
                메뉴를 선택해주세요 : """;

        // main 메서드의 로그인 후 마이페이지로 이동하는 부분
        while (true) {
            if (!isLoggedIn) {
                //System.out.println(initialMenu);
                int input = sc.nextInt();
                sc.nextLine(); // 버퍼 제거

                switch (input) {
                    case 1: // 회원가입
                        //signUp(memberService, sc);
                        break;
                    case 2: // 로그인
                        isLoggedIn = login(memberService, sc);
                        if (isLoggedIn) {
                            // 로그인 성공 후 마이페이지로 이동
                            System.out.println("마이페이지로 이동합니다.");
                        }
                        break;
                    case 0: // 종료
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 메뉴를 선택하셨습니다.");
                }
            } else {
                // 로그인 후 마이페이지 메뉴
                System.out.println(loggedInMenu);
                int input = sc.nextInt();
                sc.nextLine(); // 버퍼 제거

                switch (input) {
                    case 1: // 회원 정보 조회
                        viewMemberInfo(memberService, sc, userId);
                        break;
                    case 2: // 회원 정보 수정
                        editMemberInfo(memberService, sc, userId);
                        break;
                    case 3: // 회원 정보 삭제
                        deleteMemberInfo(memberService, sc, userId);
                        break;
                    case 4: // 관심 레시피 확인
                        viewFavoriteRecipes(memberService, sc, userId);
                        break;
                    case 5: // 관심 레시피 삭제
                        deleteFavoriteRecipe(memberService, sc, userId);
                        break;
                    case 0: // 로그아웃
                        isLoggedIn = false;  // 로그아웃 후 초기 화면으로 돌아가기
                        userId = null;  // 로그인된 사용자 ID 초기화
                        System.out.println("로그아웃 되었습니다.");
                        break;
                    default:
                        System.out.println("잘못된 메뉴를 선택하셨습니다.");
                }
            }
        }
    }

//    비회원은 아이디, 비밀번호, 이름, 닉네임, 생년월일,성별을 입력하여 회원가입을 할 수 있다.

    /*
1) ‘회원가입’에 해당되는 메뉴 번호를 입력한다.
2) 아이디와 비밀번호를 입력한다.
3) 이름, 생년월일 성별을 입력한다.
4) 닉네임을 입력한다.
5) ‘관리자로 등록하시겠습니까?’ 문구가 출력된다.
5-1) ‘Y’로 입력할 시, 관리자 고유 번호를 입력한다.
5-2) ‘N로 입력할 시, 일반 회원으로 지정된다.
6) 회원가입이 완료된다.
     */

    // 회원가입
/*    public static void signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.println("회원가입을 시작합니다.");
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String pwd = sc.nextLine();
        System.out.println("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("생년월일 (YYYY-MM-DD): ");
        String birthStr = sc.nextLine();
        LocalDate birth = LocalDate.parse(birthStr);
        System.out.print("성별 (M/F): ");
        String gender = sc.nextLine();
        System.out.print("닉네임을 입력하세요: ");
        String nickname = sc.nextLine();
        System.out.print("관리자로 등록하시겠습니까? (Y/N): ");
        boolean isAdmin = sc.nextLine().equalsIgnoreCase("Y");

        Member member = new Member(id, pwd, name, nickname, birth, gender, isAdmin);
        MemberService memberService = new MemberService();
        boolean isSignedUp = memberService.signUp(member);
        if (isSignedUp) {
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("회원가입 실패!");
        }
    }*/

// 회원은 서버에 저장되어 있는 정보를 가지고 로그인을 한다.
/*
1) ‘로그인’에 해당되는 메뉴 번호를 입력한다.
2) ‘아이디’를 입력한다.
3) ‘비밀번호’를 입력한다.
4) 로그인에 성공한다.
*/

// 회원은 메뉴에서 로그아웃 번호를 입력하여 로그아웃 할 수 있다.
/*
1) ‘로그아웃’에 해당되는 메뉴 번호를 입력한다.
2) 로그아웃 성공 후, 처음 화면으로 돌아간다.
*/


    // 로그인
    private static boolean login(MemberService memberService, Scanner sc) {
        System.out.println("로그인 하세요.");
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        boolean isLoggedIn = memberService.login(id, password);

        if (isLoggedIn) {
            // 로그인 성공 시 userId 설정
            System.out.println("마이페이지로 이동합니다.");
            userId = id; // userId 값을 설정하여 마이페이지에서 사용
            return true;
        } else {
            // 로그인 실패 시
            System.out.println("로그인 실패!");
            return false;
        }
    }

    // 회원은 마이페이지에서 회원정보를 조회할 수 있다.
/*
1) ‘마이페이지’에 해당되는 메뉴 번호를 입력한다.
2) 사용자의 정보가 마이페이지에 출력된다.
*/
    // 회원 정보 조회
    private static void viewMemberInfo(MemberService memberService, Scanner sc, String userId) {
        // 서비스에서 사용자 정보 가져오기
        Member member = memberService.getMemberInfo(userId);

        if (member != null) {
            // 사용자 정보 출력
            System.out.println("회원 정보 조회:");
            System.out.println("아이디: " + member.getId());
            System.out.println("이름: " + member.getName());
            System.out.println("닉네임: " + member.getNickname());
            System.out.println("생년월일: " + member.getBirth());
            System.out.println("성별: " + member.getGender());
            System.out.println("관리자 여부: " + (member.isAdmin() ? "예" : "아니오"));
        } else {
            // 회원이 존재하지 않는 경우
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
    }

// 회원은 마이페이지에서 회원정보를 수정할 수 있다.
/*
1) ‘마이페이지’에서 ‘회원 정보 수정’에 해당되는 번호를 입력한다.
2) 회원 정보 수정을 하시겠습니까?라는 문구가 출력된다.
2-1) ‘Y’을 입력하면 회원 정보 수정할 수 있다.
2-1-1) ‘아이디, 비밀번호, 이름, 닉네임, 생년월일, 성별’에 해당되는 번호를 입력하여 개인 정보를 수정할 수 있다.
2-2) ‘N’를 입력하면 마이페이지로 돌아간다.
*/

    // 회원 정보 수정
    private static void editMemberInfo(MemberService memberService, Scanner sc, String userId) {
        System.out.println("회원 정보를 수정합니다.");

        System.out.print("새 아이디: ");
        String newId = sc.nextLine();
        System.out.print("새 비밀번호: ");
        String newPwd = sc.nextLine();
        System.out.print("새 닉네임: ");
        String newNickname = sc.nextLine();
        System.out.print("새 생년월일 (YYYY-MM-DD): ");
        LocalDate newBirth = LocalDate.parse(sc.nextLine());
        System.out.print("새 성별 (M/F): ");
        String newGender = sc.nextLine();

        boolean result = memberService.updateMemberInfo(userId, newId, newPwd, newNickname, newBirth, newGender);
        if (result) {
            System.out.println("회원 정보 수정 성공!");
        } else {
            System.out.println("회원 정보 수정 실패!");
        }
    }

// 회원은 마이페이지에서 회원정보를 삭제할 수 있다.
/*
1) 마이페이지에서 ‘회원 정보 삭제’에 해당하는 번호를 입력한다.
2) 회원 정보 삭제를 하시겠습니까?
2-1) ‘Y’를 입력하면 회원 정보 삭제가 된다.
2-2) ‘N’을 입력하면 마이페이지로 돌아간다.
*/

    // 회원 정보 삭제
    private static void deleteMemberInfo(MemberService memberService, Scanner sc, String userId) {
        System.out.println("회원 정보를 삭제합니다.");
        System.out.print("정말로 회원 정보를 삭제하시겠습니까? (Y/N): ");
        String confirmation = sc.nextLine();

        boolean result = false;
        if (confirmation.equalsIgnoreCase("Y")) {
            result = memberService.deleteMemberInfo(userId);
        }

        if (result) {
            System.out.println("회원 정보 삭제 완료!");
        } else {
            System.out.println("회원 정보 삭제 실패!");
        }
    }

// 회원은 마이페이지에서 관심 레시피를 확인할 수 있다.
/*
1) 마이페이지에서 ‘관심 레시피 확인’에 해당하는 번호를 입력한다.
2) 관심 레시피로 저장된 레시피 이름 목록이 출력된다.
3) 사용자는 확인하고 싶은 레시피 이름에 해당되는 번호를 입력한다.
4) 레시피가 출력된다.
*/

    // 관심 레시피 확인
    private static void viewFavoriteRecipes(MemberService memberService, Scanner sc, String userId) {
        // 'recipe_name' 대신 'name' 필드를 사용
        List<String> recipes = memberService.showFavoriteRecipes(userId);

        if (recipes.isEmpty()) {
            System.out.println("저장된 관심 레시피가 없습니다.");
        } else {
            System.out.println("저장된 관심 레시피 목록:");
            for (String recipe : recipes) {
                System.out.println("- " + recipe);  // 레시피 이름 출력
            }
        }
    }


// 회원은 마이페이지에서 관심 레시피를 삭제할 수 있다.
/*
1) 마이페이지에서 ‘관심 레시피 삭제’에 해당하는 번호를 입력한다.
2) 관심 레시피로 저장된 레시피 이름 목록이 출력된다.
3) 사용자는 삭제하고 싶은 레시피 이름에 해당되는 번호를 입력한다.
4) 삭제하고 남은 관심 레시피의 목록을 출력한다.
*/

    // 관심 레시피 삭제

    private static void deleteFavoriteRecipe(MemberService memberService, Scanner sc, String userId) {
        System.out.print("삭제할 레시피 이름을 입력하세요: ");
        String recipeName = sc.nextLine();

        boolean result = memberService.deleteFavoriteRecipe(userId, recipeName);
        if (result) {
            System.out.println("관심 레시피 삭제 성공!");
        } else {
            System.out.println("삭제 실패! 해당 레시피가 존재하지 않습니다.");
        }
    }
}
