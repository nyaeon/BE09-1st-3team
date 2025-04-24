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

        as.insertRecipe(recipe);
    }


}
