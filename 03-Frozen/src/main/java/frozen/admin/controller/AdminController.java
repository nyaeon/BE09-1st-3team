package frozen.admin.controller;

import frozen.admin.dto.AdminDTO;
import frozen.admin.service.AdminService;

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
}
