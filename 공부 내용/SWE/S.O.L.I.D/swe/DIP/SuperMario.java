package swe.DIP;

public class SuperMario extends Games {
    public SuperMario()
    {
        title = returnTitle();
        version = returnVersion();
    }
    public String returnTitle()
    {
        return "Super Mario";
    }
    public String returnVersion()
    {
        return "v1.0";
    }
}