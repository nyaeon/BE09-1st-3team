package frozen.ingredientManagement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        managemenntService managementService = new managemenntService();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("""
                ==============================
                1. 폐기 식재료 확인
                2. 자주 소비하는 식재료 확인
                ==============================
                번호입력:""");
            int select = sc.nextInt();
            switch(select) {
                case 1: managementService.serchIngredient(); break;
                case 2: break;
                default:
                    System.out.println("숫자를 다시 입력해주세요.");;
            }
        }
    }
//
//    public int disposeIngredient(Connection con) {
//        PreparedStatement pstmt2 = null;
//        ResultSet rs = null;
//        int result = 0;
//
//        try {
//
//            LocalDate now = LocalDate.now();
//            LocalDate targetDate =  ;

//            if(!targetDate.isBefore(now.minusMonths(1))) {
//                String selectSql = "SELECT * FROM exp_ingredients WHERE date >= ? ORDER BY date DESC";
//                pstmt2 = con.prepareStatement(selectSql);
//                pstmt2.setDate(1, Date.valueOf(now.minusMonths(1)));
//                rs = pstmt2.executeQuery();
//
//                while (rs.next()) {
//                    System.out.println(rs.toString());
//                }
//            }

//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            close(rs);
//            close(pstmt2);
//        }
//        return result;
//    }
}
