package frozen.ingredient;


import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ingredientService ingredient = new ingredientService();
        System.out.println("""
                ========== 식재료 관리 메뉴 ============
                1. 식재료 추가
                2. 식재료 조회
                3. 식재료 수정
                4. 식재료 삭제
                ========================================
                번호 입력 : """);
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        switch (select) {
            case 1: ingredient.registIngredient(inputIngredient());
            case 2: ingredient.checkIngredient();
            case 3: ;
            case 4: break;
            default:
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요 ");
        }
    }

    private static Ingredient inputIngredient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("식재료명 : ");
        String name = sc.nextLine();
        System.out.print("수량 : ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.print("유통 기한 : ");
        String deadLine = sc.nextLine();
        LocalDate date = LocalDate.parse(deadLine);
        System.out.print("보관 위치 : ");
        String location = sc.nextLine();
        Ingredient ingredient = new Ingredient(name, amount, date, location);
        return ingredient;
    }
}
