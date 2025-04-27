package frozen.ingredientManagement.service;

import frozen.common.domain.Management;
import frozen.ingredientManagement.repository.ManagementRepository;

import java.sql.Connection;

import static frozen.common.JDBCTemplate.*;

public class ManagementService {
    ManagementRepository managementRepo = new ManagementRepository();


    public void updateDelete(Management menu) {

        Connection con = getConnection();
        int result = managementRepo.updateDeletemenu(con, menu);
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
    }

    public void serchIngredient(String id) {
        Connection con = getConnection();

        int result = managementRepo.disposeIngredient(con,id);

        if(result > 0) {
            commit(con);

        } else {
            rollback(con);
        }
        close(con);
    }

    public void oftenconsumIngredient(String id) {
        Connection con = getConnection();
        int result = managementRepo.checkOften(con,id);

        if(result > 0) {
            commit(con);

        } else {
            rollback(con);
        }
        close(con);
    }

}
