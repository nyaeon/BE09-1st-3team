package frozen.member.controller;

import frozen.main.Application;
import frozen.member.model.dto.Member;
import frozen.member.model.service.MemberService;
import frozen.member.model.service.MemberService2;

import java.time.LocalDate;
import java.util.Scanner;

import static frozen.common.JDBCTemplate.close;

public class MemberController2 {

    public static String adminKey = "1234";
    private static String userId = null;
    public static MemberController2 memController = new MemberController2();
    private static MemberService2 memService = new MemberService2();
    private static Application app = new Application();

    // 회원가입
    public static void signUp() {

        Scanner sc = new Scanner(System.in);

        System.out.println("회원가입을 시작합니다.");
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String pwd = sc.nextLine();
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("생년월일 (YYYY-MM-DD): ");
        String birthStr = sc.nextLine();
        LocalDate birth = LocalDate.parse(birthStr);
        System.out.print("성별 (M/F): ");
        String gender = sc.nextLine();
        System.out.print("닉네임을 입력하세요: ");
        String nickname = sc.nextLine();
        System.out.print("관리자로 등록하시겠습니까? (Y/N): ");
        boolean isAdmin = sc.nextLine().equalsIgnoreCase("Y");
        if(isAdmin) {
            System.out.print("관리자 키를 입력해주세요: ");
            if (!adminKey.equals(sc.nextLine())) {
                System.out.println("관리자 키가 올바르지 않습니다. 회원가입을 다시 진행해주세요.");
                 memController.signUp();
            }
            System.out.println("관리자로 승인되셨습니다.");
        }

        Member member = new Member(id, pwd, name, nickname, birth, gender, isAdmin);
        boolean isSignedUp = memService.signUp(member);
        if (isSignedUp) {
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("회원가입 실패!");
        }

    }

    // 로그인
    public static void login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("로그인 하세요.");
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        boolean isLoggedIn = memService.login(id, password);

        if (isLoggedIn) {
            // 로그인 성공 시 userId 설정
            System.out.println("메인 페이지로 이동합니다.");
            boolean result = memService.isAdmin(id, password);
            userId = id; // userId 값을 설정하여 마이페이지에서 사용
            if (result) {
                app.mainRun2();
            } else {
                app.mainRun();
            }
        } else {
            // 로그인 실패 시
            System.out.println("로그인 실패!");
        }
    }

    // 마이페이지
    public static void myPage() {
        System.out.println("============== 마이페이지 ==============");
        memController.viewMemberInfo();
        System.out.println();

        String loggedInMenu = """
                1. 회원 정보 수정
                2. 회원 정보 삭제
                3. 관심 레시피 확인
                4. 관심 레시피 삭제
                0. 메인 화면으로 이동
                ======================================
                메뉴를 선택해주세요 : """;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(loggedInMenu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: //memController.editMemberInfo();
                    break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 0: return;
            }
        }
    }

    // 회원 정보 조회
    public static void viewMemberInfo() {

        Scanner sc = new Scanner(System.in);

        // 서비스에서 사용자 정보 가져오기
        Member mem = new Member(userId);
        Member resultMem = memService.getMemberInfo(mem);

        if (resultMem != null) {
            // 사용자 정보 출력
            System.out.println("[" + (resultMem.isAdmin() ? "관리자" : "사용자") + " 정보]");
            System.out.println("아이디: " + resultMem.getId());
            System.out.println("이름: " + resultMem.getName());
            System.out.println("닉네임: " + resultMem.getNickname());
            System.out.println("생년월일: " + resultMem.getBirth());
        } else {
            // 회원이 존재하지 않는 경우
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
    }

    // 회원 정보 수정
    /*private static void editMemberInfo() {

        Scanner sc = new Scanner(System.in);

        System.out.println("회원 정보를 수정합니다.");
        System.out.print("아이디: ");
        String newId = sc.nextLine();
        System.out.print("비밀번호: ");
        String newPwd = sc.nextLine();
        System.out.print("닉네임: ");
        String newNickname = sc.nextLine();
        System.out.print("생년월일 (YYYY-MM-DD): ");
        LocalDate newBirth = LocalDate.parse(sc.nextLine());
        System.out.print("성별 (M/F): ");
        String newGender = sc.nextLine();

        boolean result = memService.updateMemberInfo(userId, newId, newPwd, newNickname, newBirth, newGender);
        if (result) {
            System.out.println("회원 정보 수정 성공!");
        } else {
            System.out.println("회원 정보 수정 실패!");
        }
    }*/

}
