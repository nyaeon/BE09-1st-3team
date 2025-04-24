
package frozen.ingredient.service;



import frozen.ingredient.Ingredient;
import frozen.ingredient.repository.ingredientRepository;

import java.sql.Connection;
import java.time.LocalDate;

import static frozen.common.JDBCTemplate.*;

public class ingredientService {
    private final ingredientRepository ingredientRepository = new ingredientRepository();

    public void registIngredient(Ingredient ingredient) {

        Connection con = getConnection();
        int result = ingredientRepository.insertIngredient(con, ingredient);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void checkIngredient() {

        Connection con = getConnection();
        int result = ingredientRepository.checkIngredient(con);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void modifyIngredient(Ingredient modIng) {
        Connection con = getConnection();
        int result = ingredientRepository.updateIngredient(con, modIng);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public Ingredient removeIngredient(String name, LocalDate date) {
        Connection con = getConnection();
        Ingredient ing = ingredientRepository.deleteIngredient(con, name, date);
        int result = ing.getAmount();
        if(result > 0) {
            commit(con);
            System.out.println("성공적으로 삭제 되었습니다.");
        } else {
            rollback(con);
        }
        close(con);
        return ing;
    }

}
