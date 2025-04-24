package frozen.admin.controller;

import frozen.admin.dto.AdminDTO;
import frozen.admin.service.AdminService;

import java.util.List;
import java.util.Scanner;

public class AdminController {

    private AdminService as;

    public AdminController() {
        as = new AdminService();
    }


    /***
     * 레시피 등록 처리
     * @param recipe 레시피 정보
     */
    public void insertRecipe(AdminDTO recipe) {
        int result = as.insertRecipe(recipe);

        if (result > 0) {
            System.out.println("🎉 레시피 등록 성공!");
        } else {
            System.out.println("❌ 레시피 등록 실패!");
        }

    }


    public void selectAllRecipes() {

        List<AdminDTO> list = as.selectAllRecipes();
        System.out.println("📖 등록된 레시피 목록:");

        int count = 1;
        for (AdminDTO recipe : list) {
            System.out.println("🍽️ 메뉴 " + count++ + "번");
            System.out.println(recipe);
            System.out.println();
        }
    }



}
