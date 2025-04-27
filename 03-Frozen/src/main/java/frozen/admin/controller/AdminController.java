package frozen.admin.controller;

import frozen.admin.service.AdminService;
import frozen.common.domain.Recipe;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminController {

    private final AdminService as = new AdminService();

    public static void adminController() throws SQLException {

        AdminController ac = new AdminController();
        Scanner sc = new Scanner(System.in);

        String menu = """
            =========== 관리자 업무 화면 ===========
            1. 레시피 등록
            2. 레시피 조회
            3. 레시피 수정
            4. 레시피 삭제
            0. 메인 화면으로 이동
            ======================================
            메뉴 번호를 입력해주세요 :""";

        while (true) {
            System.out.print(menu);
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> {
                    Recipe recipe = ac.getRecipeFromUser(sc);
                    ac.insertRecipe(recipe);
                }
                case 2 -> ac.selectAllRecipes();
                case 3 -> ac.updateRecipeFlow(sc);
                case 4 -> ac.deleteRecipeFlow(sc);
                case 0 -> {
                    return;
                }
                default -> System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
            }
        }
    }

    // 레시피 등록
    public void insertRecipe(Recipe recipe) {
        int result = as.insertRecipe(recipe);

        if (result > 0) {
            System.out.println("🎉 레시피 등록 성공!");
        } else {
            System.out.println("❌ 레시피 등록 실패!");
        }
    }

    // 레시피 이름 목록 조회 후 상세 조회
    public void selectAllRecipes() {
        List<Recipe> list = as.selectAllRecipes();

        if (list.isEmpty()) {
            System.out.println("❌ 등록된 레시피가 없습니다.");
            return;
        }

        System.out.println("📖 등록된 레시피 이름 목록:");
        for (Recipe recipe : list) {
            System.out.println("- " + recipe.getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\n🔍 상세 조회할 레시피 이름을 입력하세요: ");
        String name = sc.nextLine();

        Recipe selectedRecipe = as.getRecipeByName(name);

        if (selectedRecipe == null) {
            System.out.println("❌ 해당 이름의 레시피가 존재하지 않습니다.");
        } else {
            System.out.println("\n🍽️ 선택한 레시피 상세 정보:");
            System.out.println(selectedRecipe);
        }
    }

    // 레시피 수정
    public void updateRecipeFlow(Scanner sc) throws SQLException {
        System.out.print("🧻 수정할 레시피의 이름을 입력하세요: ");
        String oldName = sc.nextLine();
        Recipe recipe = as.getRecipeByName(oldName);

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
            case 1 -> {
                System.out.print("🔺 새 레시피 이름을 입력하세요: ");
                recipe.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.print("🔺 새 재료를 입력하세요: ");
                recipe.setIngredients(sc.nextLine());
            }
            case 3 -> {
                System.out.print("🔺 새 조리 방법을 입력하세요: ");
                recipe.setMethod(sc.nextLine());
            }
            case 4 -> {
                System.out.print("🔺 새 조리 시간을 입력하세요 (분): ");
                recipe.setTime(sc.nextLine());
            }
            case 5 -> {
                System.out.print("🔺 새 난이도를 입력하세요 (1~5): ");
                recipe.setLevel(sc.nextInt());
                sc.nextLine();
            }
            default -> {
                System.out.println("❌ 잘못된 선택입니다. 다시 시도해주세요.");
                return;
            }
        }

        int result = as.updateRecipe(recipe, oldName);
        if (result > 0) {
            System.out.println("✅ 레시피가 성공적으로 수정되었습니다!");
        } else if (result == -1) {
            System.out.println("⚠️ 해당 레시피가 존재하지 않습니다.");
        } else {
            System.out.println("❌ 레시피 수정 실패!");
        }
    }

    // 레시피 삭제
    public void deleteRecipeFlow(Scanner sc) {
        System.out.print("➖ 삭제할 레시피의 이름을 입력하세요: ");
        String name = sc.nextLine();
        try {
            as.deleteRecipe(name);
            System.out.println("✅ 레시피 삭제가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println("❌ 삭제 중 오류가 발생했습니다.");
        }
    }

    // 레시피 입력 받기
    private Recipe getRecipeFromUser(Scanner sc) {
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

        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        recipe.setMethod(method);
        recipe.setTime(time);
        recipe.setLevel(level);

        return recipe;
    }
}
