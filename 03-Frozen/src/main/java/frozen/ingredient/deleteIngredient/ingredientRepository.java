package frozen.ingredient.deleteIngredient;

import frozen.ingredient.checkIngredient.Ingredient;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class ingredientRepository {
    private final Properties prop;

    public ingredientRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/IngredientMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteIngredient(Connection con, String ingredientName) {

        System.out.println("[IngredientRepository]deleteMenu:  menu ===> " + ingredientName);
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("deleteIngredient");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ingredientName);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println("[IngredientRepository]insertIngredient:  result ===> " + result);
        return result;
    }

}
