package frozen.ingredientManagement;

import java.sql.Connection;

import static frozen.common.JDBCTemplate.*;

public class managemenntService {
    managementRepository managementRepo = new managementRepository();
    public void updateDelete(Menagement menu) {

        Connection con = getConnection();
        int result = managementRepo.updateDeletemenu(con, menu);
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
    }

    public void disposeIngredient(Menagement menu) {
        Connection con = getConnection();

    }
}
