package swe.LSP;

public class LectureAtGS extends Lecturer_Before {
    public LectureAtGS() {
        lecturer = "대학원 강사";
    }

    @Override
    public void getSalary() {
        System.out.println(lecturer);
        System.out.println("강사료 : " + charge * 2 + "원\n");
    }
}
