package frozen.ingredientManagement;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        managemenntService managementService = new managemenntService();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("""
                ==============================
                1. 폐기 식재료 확인
                2. 자주 소비하는 식재료 확인
                ==============================
                번호입력:""");
            int select = sc.nextInt();
            switch(select) {
                case 1: managementService.serchIngredient(); break;
                case 2: break;
                default:
                    System.out.println("숫자를 다시 입력해주세요.");;
            }
        }
    }
}
