package frozen.ingredientManagement.repository;

import frozen.common.domain.Management;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class ManagementRepository {
    private final Properties prop;

    public ManagementRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/ManagementMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateDeletemenu(Connection con, Management management) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("insertDelete");

            pstmt = con.prepareStatement(sql);
            pstmt.setDate(1, Date.valueOf(management.getDate()));
            pstmt.setInt(2, management.getReason());
            pstmt.setInt(3, management.getAmount());
            pstmt.setString(4, management.getName());
            pstmt.setInt(5, management.getMemNo());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
    public int disposeIngredient(Connection con,String userId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Management> disposedIngredients = new ArrayList<>();
        int result = 0;

        try {

            String sql = prop.getProperty("insertDispose");

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                Management ingredient = new Management();
                ingredient.setName(rs.getString("name"));
                ingredient.setReason(rs.getInt("reason"));
                ingredient.setAmount(rs.getInt("amount"));
                ingredient.setDate(rs.getDate("delDate").toLocalDate()); // 날짜 변환

                System.out.println(ingredient.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(pstmt);
        }
        return result;
    }

    public int checkOften(Connection con, String id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;

        String sql = prop.getProperty("checkOften");
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name") + " - 최근 한 달간 " + rs.getInt("amount") + "회 섭취");
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
