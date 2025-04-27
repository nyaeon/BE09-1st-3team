package frozen.ingredient.repository;

import frozen.common.domain.Ingredients;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

import static frozen.common.JDBCTemplate.*;

public class IngredientRepository {
    private final Properties prop;

    public IngredientRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/IngredientMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertIngredient(Connection con, Ingredients ingred,String id) {

        PreparedStatement pstmt = null;
        int result = 0;

        try {

            String sql = prop.getProperty("insertIngredient");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ingred.getName());
            pstmt.setInt(2, ingred.getAmount());
            pstmt.setDate(3, Date.valueOf(ingred.getExpDate()));
            pstmt.setString(4, ingred.getLocation());
            pstmt.setString(5, id);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int checkIngredient(Connection con,String id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Ingredients ing = null;
        int result = 0;
        try {
            String sql = prop.getProperty("checkIngredient");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ing = new Ingredients();
                ing.setName(rs.getString("name"));
                ing.setAmount(rs.getInt("amount"));
                ing.setExpDate(LocalDate.parse(rs.getString("expDate")));
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

    public int updateIngredient(Connection con, Ingredients modifyIng) {

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("updateIngredient");

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, modifyIng.getAmount());
            pstmt.setDate(2, Date.valueOf(modifyIng.getExpDate()));
            pstmt.setString(3, modifyIng.getLocation());
            pstmt.setString(4, modifyIng.getName());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public Ingredients deleteIngredient(Connection con, String ingredientName, LocalDate expDate,String userId) {
        Ingredients ing = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        int result = 0;

        try {

            String sqlDelete = "SELECT name, amount, memNo FROM ingredients WHERE name = ? AND expDate = ? AND (SELECT memNo FROM members WHERE Id = ?)";

            pstmt2 = con.prepareStatement(sqlDelete);
            pstmt2.setString(1, ingredientName);
            pstmt2.setDate(2, Date.valueOf(expDate));
            pstmt2.setString(3,userId);
            rs = pstmt2.executeQuery();
            if (rs.next()) {
                ing = new Ingredients();
                ing.setName(rs.getString("name"));
                ing.setAmount(rs.getInt("amount"));
                ing.setMemNo(rs.getInt("memNo"));
            }
            String sql = prop.getProperty("deleteIngredient");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ingredientName);
            pstmt.setDate(2, Date.valueOf(expDate));
            pstmt.setString(3, userId);


            result = pstmt.executeUpdate();
            if(result == 0){
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB 오류",e);
        } finally {
            close(rs);
            close(pstmt);
            close(pstmt2);
        }
        return ing;
    }


}
