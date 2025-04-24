package frozen.admin.service;

import frozen.admin.dto.AdminDTO;
import frozen.admin.repository.AdminRepository;

import java.sql.Connection;

import static frozen.common.JDBCTemplate.getConnection;

public class AdminService {

    private final AdminRepository ar;

    public AdminService() {
        ar = new AdminRepository();
    }



    public void insertRecipe(AdminDTO recipe) {

        Connection con = getConnection();

    }

    public void selectRecipe() {
    }

    public void updateRecipe() {
    }

    public void deleteRecipe() {
    }
}
