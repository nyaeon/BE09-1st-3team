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

    public void serchIngredient() {
        Connection con = getConnection();

        int result = managementRepo.disposeIngredient(con);

        if(result > 0) {
            commit(con);
            System.out.println("성공적으로 삭제 되었습니다.");
        } else {
            rollback(con);
        }
        close(con);
    }
}
