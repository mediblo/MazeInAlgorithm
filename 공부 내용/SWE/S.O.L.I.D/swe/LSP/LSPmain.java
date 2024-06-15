package swe.LSP;

public class LSPmain {
    public static void main(String[] args) {
        LectureAtGS lec01 = new LectureAtGS();
        lec01.getSalary();

        LectureNight lec02 = new LectureNight();
        lec02.getSalary();

        LectureWithWork lec03 = new LectureWithWork();
        lec03.getSalary();

        Lecturer_Before lec04 = new Lecturer_Before();
        lec04.getSalary();
    }
}
