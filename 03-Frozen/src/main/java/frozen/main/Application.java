package frozen.main;

import frozen.admin.controller.AdminController;
import frozen.expiration.controller.ExpirationController;
import frozen.ingredient.controller.IngredientController;
import frozen.ingredientManagement.controller.ManagementController;
import frozen.recommendation.controller.RecommendController;
import frozen.member.controller.MemberController;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {

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
                case 1: MemberController.signUp();
                    break;
                case 2: MemberController.login();
                    break;
                case 0: return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
            }

        }
    }

    public static void mainRun(){

        Scanner sc = new Scanner(System.in);

        // 메인 화면 (일반 사용자 ver)
        String mainMenu = """
                ============== 메인 화면 ==============
                1. 식재료 관리
                2. 유통기한 확인
                3. 추천 레시피 확인
                4. 식재료 소비 기록
                5. 마이페이지
                0. 로그아웃
                ======================================
                메뉴 번호를 입력해주세요 :""";

        while (true){
            System.out.print(mainMenu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: IngredientController.ingredient();break;
                case 2: ExpirationController.expireRun(); break;
                case 3: RecommendController.recommendController(); break;
                case 4: ManagementController.ingredientManagement(); break;
                case 5: MemberController.myPage(); break;
                case 0: return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
            }
        }
    }

    public static void mainRun2() {

        Scanner sc = new Scanner(System.in);

        // 메인 화면 (관리자 ver)
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
                메뉴 번호를 입력해주세요 :""";

        while (true){
            System.out.print(mainMenu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: IngredientController.ingredient();break;
                case 2: ExpirationController.expireRun(); break;
                case 3: RecommendController.recommendController(); break;
                case 4: ManagementController.ingredientManagement(); break;
                case 5: MemberController.myPage(); break;
                case 6:
                    try {
                        AdminController.adminController();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("❌ 데이터베이스 오류가 발생했습니다.");
                    }
                    break;
                case 0: return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
            }
        }
    }

}
