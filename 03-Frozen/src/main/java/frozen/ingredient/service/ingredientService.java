
package frozen.ingredient.service;



import frozen.ingredient.Ingredient;
import frozen.ingredient.repository.ingredientRepository;

import java.sql.Connection;
import java.time.LocalDate;

import static frozen.common.JDBCTemplate.*;

public class ingredientService {
    private final ingredientRepository ingredientRepository = new ingredientRepository();

    public void registIngredient(Ingredient ingredient,String userId) {

        Connection con = getConnection();
        int result = ingredientRepository.insertIngredient(con, ingredient,userId);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void checkIngredient(String userId) {

        Connection con = getConnection();
        int result = ingredientRepository.checkIngredient(con, userId);

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

    public Ingredient removeIngredient(String name, LocalDate date,String userId) {
        Connection con = getConnection();
        Ingredient ing = ingredientRepository.deleteIngredient(con, name, date,userId);
        if(ing == null){
            rollback(con);
            close(con);
            return null;
        }
        int result = ing.getAmount();
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return ing;
    }

}
