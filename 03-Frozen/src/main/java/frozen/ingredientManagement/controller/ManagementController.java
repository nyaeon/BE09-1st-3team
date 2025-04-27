package frozen.ingredientManagement.controller;

import frozen.ingredientManagement.service.ManagementService;

import java.util.Scanner;

import static frozen.member.controller.MemberController.userId;

public class ManagementController {
    public static void ingredientManagement() {
        ManagementService managementService = new ManagementService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    ========= 식재료 소비 기록 화면 =========
                    1. 폐기 식재료 확인
                    2. 자주 소비하는 식재료 확인
                    0. 메인 화면으로 이동
                    ======================================
                    메뉴 번호를 입력해주세요 :""");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    managementService.serchIngredient(userId);
                    break;
                case 2:
                    managementService.oftenconsumIngredient(userId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
;
            }
        }
    }
}