package frozen.member.repository;

import frozen.common.domain.Recipe;
import frozen.common.domain.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;
import static frozen.member.controller.MemberController.userId;

public class MemberRepository {

    private final Properties prop;

    public MemberRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/MemberMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 회원가입
    public boolean insertMember(Connection con, Member member) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertMember");

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getId());  // ID
            pstmt.setString(2, member.getPwd());  // Password
            pstmt.setString(3, member.getName()); // name
            pstmt.setString(4, member.getNickname());  // Nickname
            pstmt.setDate(5, Date.valueOf(member.getBirth()));  // Birthdate
            pstmt.setString(6, member.getGender());  // Gender
            pstmt.setInt(7, member.isAdmin() ? 1 : 0);  // Admin (0: 일반회원, 1: 관리자)

            int result = pstmt.executeUpdate();  // 쿼리 실행

            return result > 0;  // 성공 시 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 실패 시 false 반환
        } finally {
            close(pstmt);
        }
    }

    // 로그인
    public boolean login(Connection con, String id, String pwd) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("login");

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            rset = pstmt.executeQuery();
            return rset.next();  // 결과가 있으면 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(pstmt);
            close(rset);
        }
    }

    // 관리자 여부 조회
    public boolean isAdmin(Connection con, String id, String password) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = prop.getProperty("login");
        boolean result = false;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Member memResult = new Member();
                memResult.setAdmin(rs.getBoolean("admin"));
                if (memResult.isAdmin()) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return result;
    }

    // 회원 정보 조회
    public Member getMemberInfo(Connection con, Member mem) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("getMemberInfo");
        Member member = null;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mem.getId());  // 사용자 ID
            rset = pstmt.executeQuery();
            if (rset.next()) {
                member = new Member();
                member.setId(rset.getString("id"));
                member.setPwd(rset.getString("pwd"));
                member.setName(rset.getString("name"));
                member.setNickname(rset.getString("nickname"));
                member.setBirth(rset.getDate("birth").toLocalDate());
                member.setGender(rset.getString("gender"));
                member.setAdmin(rset.getInt("admin") == 1);  // 관리자 여부
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rset);
        }

        return member;
    }

    // 회원 정보 수정
    public boolean updateMember(Connection con, Member member) {

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("updateMemberInfo");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getPwd());      // 새 비밀번호
            pstmt.setString(2, member.getNickname()); // 새 닉네임
            pstmt.setDate(3, Date.valueOf(member.getBirth()));  // 새 생년월일
            pstmt.setString(4, member.getGender());   // 새 성별
            pstmt.setString(5, userId);      // 수정할 사용자 ID

            result = pstmt.executeUpdate();  // 쿼리 실행
            return result > 0.;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 실패 시 false 반환
        } finally {
            close(pstmt);
        }
    }

    // 회원 정보 삭제
    public boolean deleteMember (Connection con, String userId){
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteMemberInfo");

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);  // 삭제할 사용자 ID

            int result = pstmt.executeUpdate();  // 쿼리 실행

            return result > 0;  // 성공 시 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 실패 시 false 반환
        } finally {
            close(pstmt);
        }
    }

    // 관심 레시피 확인
    public List<Recipe> getFavoriteRecipes(Connection con, String userId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("getFavoriteRecipes");

        List<Recipe> recipes = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);  // 사용자 ID

            rset = pstmt.executeQuery();
            while (rset.next()) {
                Recipe recipe = new Recipe();
                recipe.setName(rset.getString("name"));
                recipe.setIngredients(rset.getString("ingredients"));
                recipe.setMethod(rset.getString("method"));
                recipe.setTime(rset.getString("time"));
                recipe.setLevel(Integer.parseInt(rset.getString("level")));

                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rset);
        }

        return recipes;
    }

    // 관심 레시피 삭제
    public boolean deleteFavoriteRecipe(Connection con, String userId, String recipeName) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteFavoriteRecipe");

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);  // 사용자 ID
            pstmt.setString(2, recipeName);  // 레시피 이름

            int result = pstmt.executeUpdate();  // 쿼리 실행

            return result > 0;  // 성공 시 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // 실패 시 false 반환
        } finally {
            close(pstmt);
        }
    }

}
