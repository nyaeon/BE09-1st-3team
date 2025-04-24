package frozen.ingredient.insertIngredient;



import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /*  사용자 화면 시작 부분  */
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
        /* 사용자 화면 끝 부분 */

        /* Controller 시작 부분 */
        Ingredient ing = new Ingredient(name, amount, date, location);
        System.out.println("[Application] main() : menu ====> " + ing);
        ingredientService ingService = new ingredientService();
        ingService.registIngredient(ing);
        System.out.println("[Application] main() : main() End");
    }
}
