package swe.ISP;

public class Haksa implements Employee, Student, Propessor {
    public Haksa() {}

    @Override
    public void setClassesSetting() { // 직원.수강신청기간설정
        System.out.println("직원의 수강신청기간설정");
    }

    @Override
    public void setGradeSetting() { // 직원.성적조회기간설정
        System.out.println("직원의 성적조회기간설정");
    }

    @Override
    public void registrationGrade() { // 교수.성적등록
        System.out.println("교수의 성적등록");
    }

    @Override
    public void searchName() { // 교수.출석부조회
        System.out.println("교수의 출석부조회");
    }

    @Override
    public void searchGrade() { // 학생. 성적조회
        System.out.println("학생의 수강신청");
    }

    @Override
    public void requestClasses() { // 학생.수강신청
        System.out.println("학생의 수강신청");
    }
}
