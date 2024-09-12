package swe.LSP;

public class LectureWithWork extends Lecturer_Before{
    
    public LectureWithWork() {
        lecturer = "직업을 가진 강사";
    }

    @Override
    public void getSalary() {
        System.out.println(lecturer);
        System.out.println("강사료 : " + charge * 1 / 2 + "원\n");
    }
}
