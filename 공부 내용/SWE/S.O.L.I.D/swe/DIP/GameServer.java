package swe.DIP;

public class GameServer {
    public Games games;
    public void Game_Play(Games games)
    {
        games.Start();
    }
}