package swe.DIP;

public class LOL extends Games {
    public LOL()
    {
        title = returnTitle();
        version = returnVersion();
    }
    public String returnTitle()
    {
        return "League of Legends";
    }
    public String returnVersion()
    {
        return "v.2020";
    }
}
