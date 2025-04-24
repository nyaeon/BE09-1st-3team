package frozen.ingredient.updateIngredient;



import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 식재료명 : ");
        String name = sc.nextLine();
        System.out.print("수정할 수량 : ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 유통 기한 : ");
        String deadLine = sc.nextLine();
        LocalDate date = LocalDate.parse(deadLine);
        System.out.print("수정할 보관 위치 : ");
        String location = sc.nextLine();
        Ingredient ing = new Ingredient(name,amount,date,location);
        ingredientService ingService = new ingredientService();
        ingService.modifyIngredient(ing);

    }
}
