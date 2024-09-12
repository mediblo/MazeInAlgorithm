package swe.DIP;

public abstract class Games {
    
    public String title, version;

    public void Start()
    {
        System.out.println("게임명 : " + title);
        System.out.println("버전 : " + version);
        System.out.println(title + "을(를) 시작합니다.\n");
    }
}