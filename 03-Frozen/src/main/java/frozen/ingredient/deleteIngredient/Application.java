package frozen.ingredient.deleteIngredient;

import frozen.ingredientManagement.Management;
import frozen.ingredientManagement.managemenntService;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제하실 식재료의 이름을 입력해주세요 : ");
        String delete = sc.nextLine();
        System.out.println("삭제할 식재료의 수령을 입력해주세요 : ");
        int deleteAmount = sc.nextInt();
        System.out.print("삭제 사유를 선택해주세요 : ");
        int checkDelete = sc.nextInt();
        ingredientService ingredientService = new ingredientService();
        ingredientService.removeIngredient(delete);

        Management management = new Management(LocalDate.now(),checkDelete,deleteAmount,delete);
        managemenntService managementService = new managemenntService();
        managementService.updateDelete(menagement);

    }
}
