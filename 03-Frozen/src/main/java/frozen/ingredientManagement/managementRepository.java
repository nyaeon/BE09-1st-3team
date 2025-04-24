package frozen.ingredientManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class managementRepository {
    private final Properties prop;

    public managementRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/IngredientMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateDeletemenu(Connection con, Menagement management) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("insertDelete");

            pstmt = con.prepareStatement(sql);
            pstmt.setDate(1, Date.valueOf(management.getDate()));
            pstmt.setInt(2, management.getReason());
            pstmt.setInt(3, management.getAmount());
            pstmt.setString(4, management.getName());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

}
