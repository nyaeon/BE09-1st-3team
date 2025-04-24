package frozen.ingredientManagement;

import java.awt.*;
import java.sql.Connection;

import static frozen.common.JDBCTemplate.*;

public class managemenntService {
    managementRepository managementRepo = new managementRepository();
    public int updateDelete(Management menu) {

        Connection con = getConnection();
        int result = managementRepo.updateDeletemenu(con, menu);
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        return result;
    }
}
