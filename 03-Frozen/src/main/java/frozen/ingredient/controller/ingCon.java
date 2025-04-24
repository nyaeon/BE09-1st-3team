package frozen.ingredient.controller;


import frozen.ingredient.Ingredient;
import frozen.ingredient.service.ingredientService;
import frozen.ingredientManagement.Menagement;
import frozen.ingredientManagement.managemenntService;
import java.time.LocalDate;
import java.util.Scanner;

public class ingCon {
    public static void ingredientManagement() {
        ingredientService ingredient = new ingredientService();
        managemenntService menegement = new managemenntService();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("""
                ========== 식재료 관리 메뉴 ============
                1. 식재료 추가
                2. 식재료 조회
                3. 식재료 수정
                4. 식재료 삭제
                5. 식재료 관리 메뉴 종료
                ========================================
                번호 입력 : """);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    ingredient.registIngredient(inputIngredient());
                    break;
                case 2:
                    ingredient.checkIngredient();
                    break;
                case 3:
                    ingredient.modifyIngredient(inputIngredient());
                    break;
                case 4:

                    String input = inputString();
                    Ingredient ing = ingredient.removeIngredient(input,inputDate());
                    menegement.updateDelete(inputDelete(ing.getIngredientName(),ing.getAmount()));
                    break;
                case 5:
                    System.out.println("식재료 관리 메뉴를 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
            }
        }
    }


    private static Menagement inputDelete(String delete,int amount) {
        Scanner sc = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        System.out.println("상품을 삭제하는 이유를 골라주세요(1. 섭취 완료 2. 유통기한 초과) : ");
        int reason = sc.nextInt();
        Menagement menagement = new Menagement(localDate, reason, amount, delete);
        return menagement;
    }

    private static LocalDate inputDate() {
        System.out.println("삭제하실 식재료의 유통기한을 입력해주세요. ");
        Scanner sc = new Scanner(System.in);
        String deadLine = sc.nextLine();
        LocalDate date = LocalDate.parse(deadLine);
        return date;
    }

    private static String inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제하실 식재료의 이름을 입력해주세요.");
        String input = sc.nextLine();
        return input;
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
