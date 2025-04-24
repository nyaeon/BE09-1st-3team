package frozen.ingredient.insertIngredient;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

    public int insertIngredient(Connection con, Ingredient ingred) {

        System.out.println("[MenuRepository]insertMenu:  menu ===> " + ingred);
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("insertIngredient");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ingred.getIngredientName());
            pstmt.setInt(2, ingred.getAmount());
            pstmt.setDate(3, Date.valueOf(ingred.getDeadLine()));
            pstmt.setString(4, ingred.getLocation());

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
