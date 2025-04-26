package frozen.recommendation.controller;

import frozen.common.domain.Ingredients;
import frozen.common.domain.Recipe;
import frozen.recommendation.service.RecommendService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static frozen.member.controller.MemberController.userId;

public class RecommendController {

    public static String[] ingredients = new String[3];
    public static String recipeName = null;

    // 추천 레시피 확인
    public static void recommendController() {

        Recipe recipe;
        RecommendService rs = new RecommendService();
        List<Ingredients> resultList = rs.searchIng(userId);
        boolean found = false;

        // 등록된 식재료 목록 출력
        for (Ingredients i : resultList) {
            int num = (int) ChronoUnit.DAYS.between(LocalDate.now(), i.getExpDate());
            System.out.printf("재료명: %-8s\t 수량: %-3d\t 보관 위치: %-2s\t 유통 기한: %s(%2d일 후)\n",
                    i.getName(), i.getAmount(), i.getLocation(), i.getExpDate(), num);
        }
        System.out.println();

        // 최대 3개의 식재료 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("최대 3개의 재료를 입력할 수 있습니다. (입력을 마치고 싶다면 'NO'를 입력해주세요.)");

        for (int i = 0; i < 3; i++) {
            System.out.print("재료" + (i + 1) + " : ");
            String ingredient = sc.nextLine();
            if (ingredient.equalsIgnoreCase("NO")) {
                if(i == 0){
                    System.out.println("최소 1개의 재료는 입력해야 합니다.");
                    i = -1;
                    continue;
                }
                break;
            }

            for (int j = 0; j < resultList.size(); j++) {
                if(ingredient.equals(resultList.get(j).getName())){
                    ingredients[i] = ingredient;
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("입력하신 재료는 등록된 식재료 목록에 존재하지 않습니다. 다시 입력해주세요!");
                i--;
            }
        }

        // 입력한 식재료 출력
        System.out.print("선택된 재료 : ");
        for (int i = 0; i < 3; i++) {
            if (ingredients[i] != null) {
                System.out.print(ingredients[i] + " ");
            }
        }
        System.out.println();

        // 추천 레시피 출력
        recipe = new Recipe(Arrays.toString(ingredients));
        Recipe result = rs.searchRecipe(recipe);
        if (result.getName() == null) {
            System.out.println("추천할 수 있는 레시피가 없습니다.");
            return;
        } else {
            System.out.println("======================================");
            System.out.printf("%s\n\n요리 소요 시간: %s\n난이도: ", result.getMethod(), result.getTime());
            for (int i = 0; i < result.getLevel(); i++) System.out.print("⭐");
        }
        System.out.println("\n======================================");
        System.out.print("해당 레시피를 관심 레시피로 저장하시겠습니까? (Y/N) : ");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            saveRecipe(result.getName());
        }
        System.out.println("\n");

    }

    // 관심 레시피 저장
    public static void saveRecipe(String recipeName) {

        boolean result = RecommendService.saveRecipe(recipeName);

        if (result) {
            System.out.println("관심 레시피로 저장하는데 성공하였습니다.");
        } else {
            System.out.println("관심 레시피로 저장하는데 실패하였습니다.");
        }
    }
}
