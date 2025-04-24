package frozen.admin.view;

import frozen.admin.dto.AdminDTO;
import frozen.admin.service.AdminService;

import java.util.Scanner;

public class AdminView {

    public static void main(String[] args) {

        AdminService as = new AdminService();

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
            switch (input) {
                case 1:
                    AdminDTO recipe = getRecipeFromUser();
                    as.insertRecipe(recipe); break;
                case 2: as.selectRecipe();
                case 3: as.updateRecipe();
                case 4: as.deleteRecipe();
                case 9: return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");

            }
        }


    }

    private static AdminDTO getRecipeFromUser() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 이름: ");
        String name = sc.nextLine();

        System.out.print("레시피 재료: ");
        String ingredients = sc.nextLine();

        System.out.print("조리 방법: ");
        String method = sc.nextLine();

        System.out.print("조리 시간(분): ");
        String time = sc.nextLine();

        System.out.print("난이도(1~5): ");
        int level = sc.nextInt();

        AdminDTO recipe = new AdminDTO();
        recipe.setMenuName(name);
        recipe.setIngredients(ingredients);
        recipe.setMethod(method);
        recipe.setTime(time);
        recipe.setLevel(level);

        return recipe;

    }

}

