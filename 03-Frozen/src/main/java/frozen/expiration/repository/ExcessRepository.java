package frozen.expiration.repository;

import frozen.common.domain.Ingredients;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class ExcessRepository {

    private final Properties prop;

    public ExcessRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/ExpireMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ingredients> searchExc(Connection con, Ingredients ing) {
        List<Ingredients> resultList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = prop.getProperty("searchExpIngredients");

        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < 100; i++){
                LocalDate targetDate = ing.getExpDate().plusDays(i);
                pstmt.setDate(1, Date.valueOf(targetDate));
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Ingredients resultIng = new Ingredients();
                    resultIng.setName(rs.getString("name"));
                    resultIng.setAmount(rs.getInt("amount"));
                    resultIng.setExpDate(rs.getDate("expDate").toLocalDate());
                    resultIng.setLocation(rs.getString("location"));
                    resultList.add(resultIng);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }

        return resultList;
    }
}
