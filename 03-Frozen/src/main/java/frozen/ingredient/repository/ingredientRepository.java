package frozen.ingredient.repository;




import frozen.ingredient.Ingredient;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

import static frozen.common.JDBCTemplate.*;

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

                System.out.println(ing.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return result;
    }

    public int updateIngredient(Connection con, Ingredient modifyIng) {

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("updateIngredient");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyIng.getIngredientName());
            pstmt.setInt(2, modifyIng.getAmount());
            pstmt.setDate(3, Date.valueOf(modifyIng.getDeadLine()));
            pstmt.setString(4, modifyIng.getLocation());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public Ingredient deleteIngredient(Connection con, String ingredientName, LocalDate expDate) {
        Ingredient ing = new Ingredient();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        int result = 0;

        try {

            String sqlDelete = "SELECT name, amount FROM ingredients WHERE name = ? AND expDate = ?";

            pstmt2 = con.prepareStatement(sqlDelete);
            pstmt2.setString(1, ingredientName);
            pstmt2.setDate(2, Date.valueOf(expDate));
            rs = pstmt2.executeQuery();
            if (rs.next()) {
                ing.setIngredientName(rs.getString("name"));
                ing.setAmount(rs.getInt("amount"));;
            }
            String sql = prop.getProperty("deleteIngredient");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ingredientName);
            pstmt.setDate(2, Date.valueOf(expDate));

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
            close(pstmt2);
        }
        return ing;
    }


}
