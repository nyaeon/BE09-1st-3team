package frozen.ingredient.deleteIngredient;


import java.sql.Connection;
import static frozen.common.JDBCTemplate.*;

public class ingredientService {
    private final ingredientRepository ingredientRepository = new ingredientRepository();

    public void removeIngredient(String name) {
        Connection con = getConnection();
        int result = ingredientRepository.deleteIngredient(con, name);

        if(result > 0) {
            commit(con);
            System.out.println("성공적으로 삭제 되었습니다.");
        } else {
            rollback(con);
        }

        close(con);
    }
}
