package frozen.ingredient;




import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

import static frozen.common.JDBCTemplate.*;
import static frozen.common.JDBCTemplate.rollback;

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

        return result;
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
                ing.setDeadLine(LocalDate.parse(rs.getString("expDate")));
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

    public int updateMenu(Connection con, Ingredient modifyIngredient) {

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("updateIngredient");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyIngredient.getIngredientName());
            pstmt.setInt(2, modifyIngredient.getAmount());
            pstmt.setDate(3, Date.valueOf(modifyIngredient.getDeadLine()));
            pstmt.setString(4, modifyIngredient.getLocation());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

}
