package swe.DIP;

public class DIPMain {
    public static void main(String[] args) {
        GameServer gameserver = new GameServer();
        gameserver.Game_Play(new SuperMario());
        gameserver.Game_Play(new Tetris());
        gameserver.Game_Play(new LOL());
        gameserver.Game_Play(new Racing());
    }
}