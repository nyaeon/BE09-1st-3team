package frozen.expiration.controller;

import frozen.common.domain.Ingredients;
import frozen.expiration.service.ExpirationService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import static frozen.member.controller.MemberController.userId;

public class ExpirationController {

    public static void expireRun() {

        Ingredients ing = new Ingredients(LocalDate.now());
        Scanner sc = new Scanner(System.in);

        String menu = """
                ========== 유통기한 확인 화면 ===========
                1. 유통기한 임박 재료 조회
                2. 유통기한 초과 재료 조회
                0. 메인 화면으로 이동
                ======================================
                메뉴 번호를 입력해주세요 :""";

        while (true){
            System.out.print(menu);
            int choice = sc.nextInt();
            switch (choice){
                case 1: { // 유통기한 임박 식재료 조회
                    List<Ingredients> approachResult = ExpirationService.searchApp(ing, userId);
                    if (approachResult.isEmpty()) {
                        System.out.println("유통기한 임박 재료가 없습니다.");
                    } else {
                        for (Ingredients item : approachResult) {
                            int num = (int) ChronoUnit.DAYS.between(LocalDate.now(), item.getExpDate());
                            System.out.printf("재료명: %-8s\t 수량: %-3d\t 보관 위치: %-2s\t 유통 기한: %s(%2d일 후)\n",
                                    item.getName(), item.getAmount(), item.getLocation(),
                                    item.getExpDate().toString(), num);
                        }
                    }
                    break;
                }
                case 2: { // 유통기한 지난 식재료 조회
                    List<Ingredients> excessResult = ExpirationService.searchExc(ing, userId);
                    if (excessResult.isEmpty()) {
                        System.out.println("등록된 식재료 중 유통기한이 지난 항목은 없습니다.");
                    } else {
                        for (Ingredients item : excessResult) {
                            int num = (int) ChronoUnit.DAYS.between(item.getExpDate(), LocalDate.now());
                            System.out.printf("재료명: %-8s\t 수량: %-3d\t 보관 위치: %-2s\t 유통 기한: %s(%2d일 전)\n",
                                    item.getName(), item.getAmount(), item.getLocation(), item.getExpDate().toString(), num);
                        }
                    }
                    break;
                }
                case 0:
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요. ");
                    break;
            }
        }
    }
}
