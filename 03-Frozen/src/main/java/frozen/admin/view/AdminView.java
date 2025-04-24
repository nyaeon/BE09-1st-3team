package frozen.admin.view;

import frozen.admin.controller.AdminController;
import frozen.admin.dto.AdminDTO;
import frozen.admin.service.AdminService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView {

    public static void main(String[] args) throws SQLException {

        AdminController ac = new AdminController();

        Scanner sc = new Scanner(System.in);

        String menu = """
            === 관리자 업무 페이지 ===
            1. 레시피 등록
            2. 레시피 조회
            3. 레시피 수정
            4. 레시피 삭제
            9. 로그아웃
            
            """;

        while(true) {
            System.out.println(menu);

            System.out.print("메뉴 선택: ");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    AdminDTO recipe = getRecipeFromUser(sc);
                    ac.insertRecipe(recipe); break;
                case 2:
                    viewAllRecipes(ac); break;
                case 3:
                    updateRecipe(ac, sc); break;
                case 4:
                    deleteRecipe(ac, sc); break;
                case 9: return;
                default:
                    System.out.println("❗ 잘못된 메뉴 번호입니다. 다시 선택해 주세요.");

            }
        }


    }


    // 사용자의 레시피 입력을 받는 메소드
    private static AdminDTO getRecipeFromUser(Scanner sc) {

        System.out.print("🔺 메뉴 이름: ");
        String name = sc.nextLine();

        System.out.print("🔺 레시피 재료: ");
        String ingredients = sc.nextLine();

        System.out.print("🔺 조리 방법: ");
        String method = sc.nextLine();

        System.out.print("🔺 조리 시간(분): ");
        String time = sc.nextLine();

        System.out.print("🔺 난이도(1~5): ");
        int level = sc.nextInt();
        sc.nextLine();

        AdminDTO recipe = new AdminDTO();
        recipe.setMenuName(name);
        recipe.setIngredients(ingredients);
        recipe.setMethod(method);
        recipe.setTime(time);
        recipe.setLevel(level);

        return recipe;
    }

    // 등록된 모든 레시피를 조회
    private static void viewAllRecipes(AdminController ac) {
        ac.selectAllRecipes();
    }


    // 레시피 수정 기능
    private static void updateRecipe(AdminController ac, Scanner sc) throws SQLException {

        System.out.print("🧻 수정할 레시피의 이름을 입력하세요: ");
        String oldName = sc.nextLine();
        AdminDTO recipe = ac.getRecipeByName(oldName);

        if (recipe == null) {
            System.out.println("❌ 해당 레시피가 존재하지 않습니다.");
            return;
        }

        System.out.println("🧻 수정할 항목을 선택하세요.");
        System.out.println("1. 레시피 이름");
        System.out.println("2. 재료");
        System.out.println("3. 조리 방법");
        System.out.println("4. 조리 시간");
        System.out.println("5. 난이도");
        System.out.print("선택 >> ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("🔺 새 레시피 이름을 입력하세요: ");
                recipe.setMenuName(sc.nextLine());
                break;
            case 2:
                System.out.print("🔺 새 재료를 입력하세요: ");
                recipe.setIngredients(sc.nextLine());
                break;
            case 3:
                System.out.print("🔺 새 조리 방법을 입력하세요: ");
                recipe.setMethod(sc.nextLine());
                break;
            case 4:
                System.out.print("🔺 새 조리 시간을 입력하세요 (분): ");
                recipe.setTime(sc.nextLine());
                break;
            case 5:
                System.out.print("🔺 새 난이도를 입력하세요 (1~5): ");
                recipe.setLevel(sc.nextInt());
                break;
            default:
                System.out.println("❌ 잘못된 선택입니다. 다시 시도해주세요.");
                return;
        }

        ac.updateRecipe(recipe, oldName);
        System.out.println(recipe);
    }

    // 레시피 삭제 기능
    private static void deleteRecipe(AdminController ac, Scanner sc) {

        System.out.print("➖ 삭제할 레시피의 이름을 입력하세요: ");
        String name = sc.nextLine();
        ac.deleteRecipe(name);
    }

}
