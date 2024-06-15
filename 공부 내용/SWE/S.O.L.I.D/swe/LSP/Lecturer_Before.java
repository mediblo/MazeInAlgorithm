package swe.LSP;

public class Lecturer_Before {
    public Lecturer_Before() {
        System.out.println("리스코프 교체 원칙 위반");
    }

    public String lecturer;
    public int charge = 90000;
    public void getSalary() {
        System.out.println("일반 강사");
        System.out.println("강사료 : " + charge + "원\n");
    }
}
