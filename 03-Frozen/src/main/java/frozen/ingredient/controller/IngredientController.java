package frozen.ingredient.controller;

import frozen.common.domain.Ingredients;
import frozen.ingredient.service.IngredientService;
import frozen.common.domain.Management;
import frozen.ingredientManagement.service.ManagementService;
import java.time.LocalDate;
import java.util.Scanner;

import static frozen.member.controller.MemberController.userId;

public class IngredientController {
    public static void ingredient() {
        IngredientService ingredient = new IngredientService();
        ManagementService management = new ManagementService();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("""
                ========== 식재료 관리 화면 ============
                1. 식재료 추가
                2. 식재료 조회
                3. 식재료 수정
                4. 식재료 삭제
                0. 메인 화면으로 이동
                ======================================
                메뉴 번호를 입력해주세요 :""");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    ingredient.registIngredient(inputIngredient(),userId);
                    break;
                case 2:
                    ingredient.checkIngredient(userId);
                    break;
                case 3:
                    ingredient.modifyIngredient(inputIngredient());
                    break;
                case 4:
                    String input =inputString();
                    Ingredients ing = ingredient.removeIngredient(input,inputDate(),userId);
                    if(ing != null){
                        management.updateDelete(inputDelete(input,ing.getAmount(),ing.getMemNo()));
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
            }
        }
    }


    private static Management inputDelete(String delete, int amount, int memNo) {
        Scanner sc = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        System.out.print("상품을 삭제하는 이유를 골라주세요(1. 섭취 완료 2. 유통기한 초과) : ");
        int reason = sc.nextInt();
        return new Management(localDate, reason, amount, delete, memNo);
    }

    private static LocalDate inputDate() {
        System.out.print("삭제하실 식재료의 유통기한을 입력해주세요. ");
        Scanner sc = new Scanner(System.in);
        String deadLine = sc.nextLine();
        return LocalDate.parse(deadLine);
    }

    private static String inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제하실 식재료의 이름을 입력해주세요.");
        return sc.nextLine();
    }

    private static Ingredients inputIngredient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("식재료명 : ");
        String name = sc.nextLine();
        System.out.print("수량 : ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.print("유통 기한 : ");
        String deadLine = sc.nextLine();
        LocalDate date = LocalDate.parse(deadLine);
        System.out.print("보관 위치(냉장/냉동/실온) : ");
        String location = sc.nextLine();
        return new Ingredients(name, amount, date, location);
    }
}
