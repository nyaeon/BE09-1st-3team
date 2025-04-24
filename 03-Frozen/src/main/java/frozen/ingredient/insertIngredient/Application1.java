package frozen.ingredient.insertIngredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static frozen.common.JDBCTemplate.close;
import static frozen.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into ingredients(name, amount, expDate, location) " +
                "values(?, ?, ?, ?)";
        int result = 0;  // insert, update, delete 시에는 수행된 행의 개수를 int로 반환

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "양상추");
            pstmt.setInt(2, 12000);
            pstmt.setString(3, "2024-04-25");
            pstmt.setString(4, "냉장");

            result = pstmt.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
