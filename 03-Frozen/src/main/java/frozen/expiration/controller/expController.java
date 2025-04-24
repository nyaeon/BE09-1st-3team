package frozen.expiration.controller;

import frozen.common.domain.Ingredients;
import frozen.expiration.service.ApproachService;
import frozen.expiration.service.ExcessService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import static frozen.main.Application.expCon;

public class expController {

    public static void expireRun() {

        ApproachService appService = new ApproachService();
        ExcessService excService = new ExcessService();

        LocalDate date = LocalDate.now();
        Ingredients ing = new Ingredients(date);

        Scanner sc = new Scanner(System.in);

        String menu = """
                [유통기한 확인 페이지]
                
                1. 유통기한 임박 재료 조회
                2. 유통기한 초과 재료 조회
                3. 메인 페이지로 이동
                원하는 메뉴 번호를 입력해주세요 :""";

        while (true){
            System.out.print(menu);
            menu = sc.nextLine();
            switch (menu){
                case "1": {
                    List<Ingredients> approachResult = appService.searchApp(ing);
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
                    System.out.println();
                    expCon.expireRun();
                    break;
                }
                case "2": {
                    List<Ingredients> excessResult = excService.searchExc(ing);
                    if (excessResult.isEmpty()) {
                        System.out.println("등록된 식재료 중 유통기한이 지난 항목은 없습니다.");
                    } else {
                        for (Ingredients item : excessResult) {
                            int num = (int) ChronoUnit.DAYS.between(LocalDate.now(), item.getExpDate());
                            System.out.printf("재료명: %-8s\t 수량: %-3d\t 보관 위치: %-2s\t 유통 기한: %s(%2d일 후)\n",
                                    item.getName(), item.getAmount(), item.getLocation(), item.getExpDate().toString(), num);
                        }
                    }
                    System.out.println();
                    expCon.expireRun();
                    break;
                }
                case "3":
                    return;
                default:
                    System.out.println("번호를 잘못 선택하셨습니다. 다시 입력해주세요.");
            }
        }
    }
}
