package frozen.admin.repository;

import frozen.admin.dto.AdminDTO;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class AdminRepository {

    private Properties prop;

    public AdminRepository(){
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/AdminMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public int insertRecipe(Connection con, AdminDTO recipe) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("insertRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, recipe.getMenuName());
            pstmt.setString(2, recipe.getIngredients());
            pstmt.setString(3, recipe.getMethod());
            pstmt.setString(4, recipe.getTime());
            pstmt.setInt(5, recipe.getLevel());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public List<AdminDTO> selectAllRecipes(Connection con) {

        List<AdminDTO> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectRecipe");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                AdminDTO recipe = new AdminDTO();
                recipe.setMenuName(rset.getString("name"));
                recipe.setIngredients(rset.getString("ingredients"));
                recipe.setMethod(rset.getString("method"));
                recipe.setTime(rset.getString("time"));
                recipe.setLevel(rset.getInt("level"));
                list.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
    }
}
