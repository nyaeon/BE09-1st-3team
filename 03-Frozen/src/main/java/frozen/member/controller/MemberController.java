package frozen.member.controller;


import frozen.common.domain.Recipe;
import frozen.main.Application;
import frozen.common.domain.Member;
import frozen.member.service.MemberService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MemberController {

    public static String adminKey = "1234";
    public static String userId = null;
    public static MemberController memController = new MemberController();
    private static MemberService memService = new MemberService();
    private static Application app = new Application();

    // 회원가입
    public static void signUp() {

        Scanner sc = new Scanner(System.in);

        System.out.println("회원가입을 시작합니다.");
        String id = null;
        while(true){
            System.out.print("아이디를 입력하세요: ");
            id = sc.nextLine();
            if(!checkSignUp(id)) break;
            else System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
        }
        System.out.print("비밀번호를 입력하세요: ");
        String pwd = sc.nextLine();
        System.out.print("이름을 입력하세요: ");
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
        if(isAdmin) {
            System.out.print("관리자 키를 입력해주세요: ");
            if (!adminKey.equals(sc.nextLine())) {
                System.out.println("관리자 키가 올바르지 않습니다. 회원가입을 다시 진행해주세요.");
                memController.signUp();
            }
            System.out.println("관리자로 승인되었습니다.");
        }

        Member member = new Member(id, pwd, name, nickname, birth, gender, isAdmin);
        boolean isSignedUp = memService.signUp(member);
        if (isSignedUp) {
            System.out.println("정상적으로 회원가입이 되었습니다.");
        } else {
            System.out.println("회원가입 하는데 실패하였습니다. 다시 해주세요!");
        }

    }

    public static boolean checkSignUp(String id) {

        boolean result = false;
        Member mem = new Member(id);
        Member resultMem = memService.getMemberInfo(mem);
        if (resultMem != null) {
            result = true;
        }
        return result;
    }

    // 로그인
    public static void login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("로그인이 진행됩니다.");
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        boolean isLoggedIn = memService.login(id, password);

        if (isLoggedIn) {
            // 로그인 성공 시 userId 설정
            System.out.println("정상적으로 로그인 되었습니다. 메인 화면으로 이동합니다.");
            boolean result = memService.isAdmin(id, password);
            userId = id; // userId 값을 설정하여 마이페이지에서 사용
            if (result) {
                app.mainRun2();
            } else {
                app.mainRun();
            }
        } else {
            // 로그인 실패 시
            System.out.println("로그인 하는데 실패하였습니다. 다시 해주세요!");
        }
    }

    // 마이페이지
    public static void myPage() {
        String loggedInMenu1 = "============== 마이페이지 ==============";
        String loggedInMenu2 = """
                1. 회원 정보 수정
                2. 회원 정보 삭제
                3. 관심 레시피 확인
                4. 관심 레시피 삭제
                0. 메인 화면으로 이동
                ======================================
                메뉴 번호를 입력해주세요 :""";

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(loggedInMenu1);
            memController.viewMemberInfo();
            System.out.println();
            System.out.print(loggedInMenu2);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: memController.editMemberInfo(); break;
                case 2: memController.deleteMemberInfo(); break;
                case 3: memController.viewFavoriteRecipes(); break;
                case 4: memController.deleteFavoriteRecipe(); break;
                case 0: return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    // 회원 정보 조회
    public static void viewMemberInfo() {

        Scanner sc = new Scanner(System.in);

        // 서비스에서 사용자 정보 가져오기
        Member mem = new Member(userId);
        Member resultMem = memService.getMemberInfo(mem);

        if (resultMem != null) {
            // 사용자 정보 출력
            System.out.println("[" + (resultMem.isAdmin() ? "관리자" : "사용자") + " 정보]");
            System.out.println("아이디: " + resultMem.getId());
            System.out.println("이름: " + resultMem.getName());
            System.out.println("닉네임: " + resultMem.getNickname());
            System.out.println("생년월일: " + resultMem.getBirth());
            System.out.println("성별: " + resultMem.getGender());
        } else {
            // 회원이 존재하지 않는 경우
            System.out.println("회원 정보를 조회하는데 실패하였습니다.");
        }
    }

    // 회원 정보 수정
    private static void editMemberInfo() {

        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 회원님의 정보를 입력해주세요.");
        System.out.print("비밀번호: ");
        String newPwd = sc.nextLine();
        System.out.print("닉네임: ");
        String newNickname = sc.nextLine();
        System.out.print("생년월일 (YYYY-MM-DD): ");
        LocalDate newBirth = LocalDate.parse(sc.nextLine());
        System.out.print("성별 (M/F): ");
        String newGender = sc.nextLine();

        Member updateMem = new Member(userId, newPwd, newNickname, newBirth, newGender);
        boolean result = memService.updateMemberInfo(updateMem);
        if (result) {
            System.out.println("회원 정보를 수정하는데 성공하였습니다.");
        } else {
            System.out.println("회원 정보를 수정하는데 실패하였습니다. 다시 시도해 주세요!");
        }
    }

    // 회원 정보 삭제
    private static void deleteMemberInfo() {

        Scanner sc = new Scanner(System.in);
        System.out.print("정말로 회원 정보를 삭제하시겠습니까? (Y/N): ");
        String confirmation = sc.nextLine();

        boolean result = false;
        if (confirmation.equalsIgnoreCase("Y")) {
            result = memService.deleteMemberInfo(userId);
        }

        if (result) {
            System.out.println("회원 정보를 삭제하는데 성공하였습니다. 프로그램을 종료합니다.");
            System.exit(0);
        } else {
            System.out.println("회원 정보를 삭제하는데 실패하였습니다. 다시 시도해 주세요!");
        }
    }

    // 관심 레시피 확인
    private static void viewFavoriteRecipes() {

        Scanner sc = new Scanner(System.in);
        List<Recipe> recipes = memService.showFavoriteRecipes(userId);

        if (recipes.isEmpty()) {
            System.out.println("저장된 관심 레시피가 없습니다.");
        } else {
            System.out.println("[저장된 관심 레시피 목록]");
            for (Recipe recipe : recipes) {
                System.out.println("- " + recipe.getName());
            }
            System.out.println();
            System.out.print("확인하고 싶은 레시피의 이름을 입력해주세요 : ");
            String recipeName = sc.nextLine();

            for (Recipe recipe : recipes) {
                if(recipe.getName().equals(recipeName)) {
                    System.out.println("======================================");
                    System.out.printf("%s\n\n요리 소요 시간: %s\n난이도: ", recipe.getMethod(), recipe.getTime());
                    for (int i = 0; i < recipe.getLevel(); i++) System.out.print("⭐");
                    System.out.println("\n======================================");
                }
            }
        }
    }

    // 관심 레시피 삭제
    private static void deleteFavoriteRecipe() {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 레시피 이름을 입력하세요: ");
        String recipeName = sc.nextLine();

        boolean result = memService.deleteFavoriteRecipe(userId, recipeName);
        if (result) {
            System.out.println("해당 레시피를 삭제하는데 성공하였습니다.");
        } else {
            System.out.println("해당 레시피가 존재하지 않습니다.");
        }
    }
}
