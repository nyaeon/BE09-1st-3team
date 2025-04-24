package frozen.recommendation.controller;

import frozen.common.domain.Ingredients;
import frozen.common.domain.Recipe;
import frozen.recommendation.service.RecommendService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class recController {

    public static String[] ingredients = new String[3];

    public static void recommendController() {

        Ingredients ing = new Ingredients();
        Recipe recipe;
        RecommendService rs = new RecommendService();
        List<Ingredients> resultList = rs.searchIng(ing);
        for (Ingredients i : resultList) {
            int num = (int) ChronoUnit.DAYS.between(LocalDate.now(), i.getExpDate());
            System.out.printf("재료명: %-8s\t 수량: %-3d\t 보관 위치: %-2s\t 유통 기한: %s(%2d일 후)\n",
                    i.getName(), i.getAmount(), i.getLocation(), i.getExpDate(), num);
        }
        System.out.println();

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

            Ingredients ing2 = new Ingredients(ingredient);
            if(rs.searchExist(ing2) == false){
                System.out.println("입력하신 재료는 등록된 식재료 목록에 존재하지 않습니다. 다시 입력해주세요!");
                i--;
                continue;
            }
            ingredients[i] = ingredient;
        }

        System.out.print("선택된 재료 : ");
        for (int i = 0; i < 3; i++) {
            if (ingredients[i] != null) {
                System.out.print(ingredients[i] + " ");
            }
        }
        System.out.println("\n\n");

        recipe = new Recipe(Arrays.toString(ingredients));
        Recipe result = rs.searchRecipe(recipe);
        if (result.getName() == null) {
            System.out.println("추천할 수 있는 레시피가 없습니다.");
            return;
        } else {
            System.out.printf("%s\n\n요리 소요 시간: %s\n난이도: ", result.getMethod(), result.getTime());
            for (int i = 0; i < result.getLevel(); i++) System.out.print("⭐");
        }


    }
}
