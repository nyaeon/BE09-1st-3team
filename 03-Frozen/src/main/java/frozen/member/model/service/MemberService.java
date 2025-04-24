package frozen.member.model.service;

import frozen.member.model.dto.Member;
import frozen.member.model.dao.MemberRepository;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입 처리
    public boolean signUp(Member member) {
        Connection con = getConnection();
        boolean isSuccess = false;

        try {
            isSuccess = memberRepository.insertMember(con, member);
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

    // 로그인 처리
    public boolean login(String id, String pwd) {
        Connection con = getConnection();
        boolean isLoggedIn = memberRepository.login(con, id, pwd);
        close(con);  // 연결 종료
        return isLoggedIn;
    }

    // 회원 정보 조회
    public Member getMemberInfo(String id) {
        Connection con = getConnection();
        Member member = memberRepository.getMemberInfo(con, id);
        close(con);

        // 로그 추가
        if (member == null) {
            System.out.println("회원 정보를 찾을 수 없습니다. 아이디: " + id);
        }

        return member;
    }


    // 회원 정보 수정
    public boolean updateMemberInfo(String userId, String newId, String newPwd, String newNickname, LocalDate newBirth, String newGender) {
        Connection con = getConnection();
        boolean isUpdated = memberRepository.updateMember(con, userId, newId, newPwd, newNickname, newBirth, newGender);
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
        boolean isDeleted = memberRepository.deleteMember(con, userId);
        if (isDeleted) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return isDeleted;
    }

    // 관심 레시피 확인
    public List<String> showFavoriteRecipes(String userId) {
        Connection con = getConnection();
        List<String> recipes = memberRepository.getFavoriteRecipes(con, userId);
        close(con);
        return recipes;
    }

    // 관심 레시피 삭제
    public boolean deleteFavoriteRecipe(String userId, String recipeName) {
        Connection con = getConnection();
        boolean isDeleted = memberRepository.deleteFavoriteRecipe(con, userId, recipeName);
        if (isDeleted) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return isDeleted;
    }
}
