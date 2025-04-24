package frozen.member.model.service;

import frozen.member.model.dao.MemberRepository2;
import frozen.member.model.dto.Member;

import java.sql.Connection;
import java.time.LocalDate;

import static frozen.common.JDBCTemplate.*;

public class MemberService2 {

    private final MemberRepository2 memRepository = new MemberRepository2();

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

    public boolean login(String id, String password) {

        Connection con = getConnection();
        boolean isLoggedIn = memRepository.login(con, id, password);
        close(con);  // 연결 종료
        return isLoggedIn;
    }

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
    public boolean updateMemberInfo(String userId, String newId, String newPwd, String newNickname, LocalDate newBirth, String newGender) {
        Connection con = getConnection();
        boolean isUpdated = memRepository.updateMember(con, userId, newId, newPwd, newNickname, newBirth, newGender);
        if (isUpdated) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return isUpdated;
    }
}
