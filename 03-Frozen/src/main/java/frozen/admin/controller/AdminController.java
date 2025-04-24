package frozen.admin.controller;

import frozen.admin.dto.AdminDTO;
import frozen.admin.service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminController {

    private AdminService as;

    public AdminController() {
        as = new AdminService();
    }


    // 레시피 등록
    public void insertRecipe(AdminDTO recipe) {
        int result = as.insertRecipe(recipe);

        if (result > 0) {
            System.out.println("🎉 레시피 등록 성공!");
        } else {
            System.out.println("❌ 레시피 등록 실패!");
        }

    }


    // 레시피 조회 (전체)
    public void selectAllRecipes() {

        List<AdminDTO> list = as.selectAllRecipes();
        System.out.println("📖 등록된 레시피 목록:");

        int count = 1;
        for (AdminDTO recipe : list) {
            System.out.println("🍽️ 레시피 " + count++ + "번");
            System.out.println(recipe);
            System.out.println();
        }
    }

    public AdminDTO getRecipeByName(String name) {
        return as.getRecipeByName(name);
    }

    public void updateRecipe(AdminDTO recipe, String oldName) {
        int result = as.updateRecipe(recipe, oldName);

        if (result > 0) {
            System.out.println("✅ 레시피가 성공적으로 수정되었습니다!");
        } else if (result == -1) {
            System.out.println("⚠️ 해당 레시피가 존재하지 않습니다.");
        } else {
            System.out.println("❌ 레시피 수정 실패!");
        }
    }

    public void deleteRecipe(String name) {
        try {
            as.deleteRecipe(name);
            System.out.println("✅ 레시피 삭제가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println("❌ 삭제 중 오류가 발생했습니다.");
        }
    }
}
