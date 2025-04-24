package frozen.admin.repository;

import frozen.admin.dto.AdminDTO;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
