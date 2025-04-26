package frozen.main;

import frozen.admin.controller.AdminController;
import frozen.expiration.controller.expController;
import frozen.ingredient.controller.ingCon;
import frozen.recommendation.controller.recController;

import java.sql.SQLException;
import java.util.Scanner;

import static frozen.member.controller.MemberController.memController;

public class Application {

    public static expController expCon = new expController();
    public static recController recCon = new recController();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 초기 메뉴
        String initialMenu = """
                =============== 홈 화면 ===============
                1. 회원가입
                2. 로그인
                0. 종료
                ======================================
                메뉴를 선택해주세요 : """;

        while (true) {
            System.out.print(initialMenu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: memController.signUp();
                    break;
                case 2: memController.login();
                    break;
                case 0: return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
            }

        }

        // MemberController의 main 메서드를 호출하여 프로그램 실행
        //MemberController.memberRun();
    }

    public static void mainRun(){

        Scanner sc = new Scanner(System.in);

        // 메인 메뉴 (일반 사용자 ver)
        String mainMenu = """
                ============== 메인 화면 ==============
                1. 식재료 관리
                2. 유통기한 확인
                3. 추천 레시피 확인
                4. 식재료 소비 기록
                5. 마이페이지
                0. 로그아웃
                ======================================
                메뉴를 선택해주세요 : """;

        while (true){
            System.out.print(mainMenu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: ingCon.ingredientManagement();break;
                case 2: expCon.expireRun(); break;
                case 3: recCon.recommendController(); break;
                case 4: break;
                case 5: memController.myPage(); break;
                case 0: return;
                default: break;
            }
        }
    }

    public static void mainRun2() {

        Scanner sc = new Scanner(System.in);

        // 메인 메뉴 (관리자 ver)
        String mainMenu = """
                ============== 메인 화면 ==============
                1. 식재료 관리
                2. 유통기한 확인
                3. 추천 레시피 확인
                4. 식재료 소비 기록
                5. 마이페이지
                6. 관리자 업무
                0. 로그아웃
                ======================================
                메뉴를 선택해주세요 : """;

        while (true){
            System.out.print(mainMenu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: ingCon.ingredientManagement();break;
                case 2: expCon.expireRun(); break;
                case 3: recCon.recommendController(); break;
                case 4: break;
                case 5: memController.myPage(); break;
                case 6: showAdminMenu(); break;
                case 0: return;
                default: break;
            }
        }
    }

    private static void showAdminMenu() {
        try {
            AdminController.main(new String[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ 데이터베이스 오류가 발생했습니다.");
        }
    }
}
