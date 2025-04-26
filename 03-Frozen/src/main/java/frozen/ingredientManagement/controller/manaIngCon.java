package frozen.ingredientManagement.controller;

import frozen.ingredientManagement.service.managemenntService;

import java.util.Scanner;

import static frozen.member.controller.MemberController.userId;

public class manaIngCon {
    public static void ingredientManagement() {
        managemenntService managementService = new managemenntService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    ==============================
                    1. 폐기 식재료 확인
                    2. 자주 소비하는 식재료 확인
                    ==============================
                    번호입력:""");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    managementService.serchIngredient(userId);
                    break;
                case 2:
                    managementService.oftenconsumIngredient(userId);
                    break;
                default:
                    System.out.println("숫자를 다시 입력해주세요.");
                    ;
            }
        }
    }
}