package swe.LSP;

public class LectureNight extends Lecturer_Before{
    public LectureNight() {
        lecturer = "야간 강사";
    }

    @Override
    public void getSalary() {
        System.out.println(lecturer);
        System.out.println("강사료 : " + charge * 1.5 + "원\n");
    }
}
