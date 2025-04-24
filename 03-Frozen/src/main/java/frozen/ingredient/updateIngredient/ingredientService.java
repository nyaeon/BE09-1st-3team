package frozen.ingredient.updateIngredient;




import java.sql.Connection;
import static frozen.common.JDBCTemplate.*;

public class ingredientService {
    private final ingredientRepository ingredientRepository = new ingredientRepository();
    public void modifyIngredient(Ingredient modIng) {
        System.out.println("[MenuService]modifyMenu:  menu ===> " + modIng);

        Connection con = getConnection();
        int result = ingredientRepository.updateMenu(con, modIng);

        // 수행 결과에 따라서 Commit, Rollback 정해야한다.
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        System.out.println("[MenuService]modifyMenu:  End ===> ");
    }
}
