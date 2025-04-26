package frozen.member.service;


import frozen.common.domain.Recipe;
import frozen.member.repository.MemberRepository;
import frozen.common.domain.Member;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class MemberService {

    private final MemberRepository memRepository = new MemberRepository();

    // 회원가입
    public boolean signUp(Member member) {
        Connection con = getConnection();
        boolean isSuccess = false;

        try {
            isSuccess = memRepository.insertMember(con, member);
            if (isSuccess) {
                commit(con);  // 성공하면 commit
            } else {
                rollback(con);  // 실패하면 rollback
            }
        } catch (Exception e) {
            rollback(con);  // 예외 발생 시 rollback
            throw new RuntimeException(e);
        } finally {
            close(con);  // 연결 종료
        }

        return isSuccess;
    }

    // 로그인
    public boolean login(String id, String password) {

        Connection con = getConnection();
        boolean isLoggedIn = memRepository.login(con, id, password);
        close(con);  // 연결 종료
        return isLoggedIn;
    }

    // 관리자 여부 조회
    public boolean isAdmin(String id, String password) {
        Connection con = getConnection();
        boolean result = memRepository.isAdmin(con, id, password);
        close(con);  // 연결 종료
        return result;
    }

    // 회원 정보 조회
    public Member getMemberInfo(Member mem) {
        Connection con = getConnection();
        Member member = memRepository.getMemberInfo(con, mem);
        close(con);

        return member;
    }

    // 회원 정보 수정
    public boolean updateMemberInfo(Member member) {
        Connection con = getConnection();
        boolean isUpdated = memRepository.updateMember(con, member);
        if (isUpdated) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return isUpdated;
    }

    // 회원 정보 삭제
    public boolean deleteMemberInfo(String userId) {
        Connection con = getConnection();
        boolean isDeleted = memRepository.deleteMember(con, userId);
        if (isDeleted) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return isDeleted;
    }

    // 관심 레시피 확인
    public List<Recipe> showFavoriteRecipes(String userId) {

        Connection con = getConnection();
        List<Recipe> recipes = memRepository.getFavoriteRecipes(con, userId);
        close(con);
        return recipes;
    }

    // 관심 레시피 삭제
    public boolean deleteFavoriteRecipe(String userId, String recipeName) {
        Connection con = getConnection();
        boolean isDeleted = memRepository.deleteFavoriteRecipe(con, userId, recipeName);
        if (isDeleted) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return isDeleted;
    }

}
