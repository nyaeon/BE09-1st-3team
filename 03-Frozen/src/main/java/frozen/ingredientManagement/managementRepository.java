package frozen.ingredientManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class managementRepository {
    private final Properties prop;

    public managementRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/MenagementMapper.xml"));
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
    public int disposeIngredient(Connection con) {
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        int result = 0;

        try {

            String selectSql = "SELECT * FROM exp_ingredients WHERE delDate >= ? ORDER BY delDate DESC";
            pstmt2 = con.prepareStatement(selectSql);

            LocalDate now = LocalDate.now();
            pstmt2.setDate(1, Date.valueOf(now.minusMonths(1)));
            rs = pstmt2.executeQuery();

            LocalDate targetDate = rs.getDate("delDate").toLocalDate();
            if (!targetDate.isBefore(now.minusMonths(1))) {
                pstmt2.setDate(1, Date.valueOf(now.minusMonths(1)));

                while (rs.next()) {
                    System.out.println(rs.toString());
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(pstmt2);
        }
        return result;
    }
}
