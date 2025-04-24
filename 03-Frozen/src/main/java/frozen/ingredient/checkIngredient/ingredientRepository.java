package frozen.ingredient.checkIngredient;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public int checkIngredient(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Ingredient ing = null;
        int result = 0;
        try {
            String sql = prop.getProperty("checkIngredient");
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ing = new Ingredient();
                ing.setIngredientName(rs.getString("name"));
                ing.setAmount(rs.getInt("amount"));
                ing.setDeadLine(rs.getString("expDate"));
                ing.setLocation(rs.getString("location"));

                System.out.println("=== Ingredient 정보 ===");
                System.out.println("이름: " + ing.getIngredientName());
                System.out.println("수량: " + ing.getAmount());
                System.out.println("유통기한: " + ing.getDeadLine());
                System.out.println("보관 위치: " + ing.getLocation());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return result;
    }

}


