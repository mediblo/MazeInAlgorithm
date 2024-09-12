package swe.OCP;

public class OCPmain {
    public static void main(String[] args) {
        PlayCodec pc = new MP4();
        Video_Player vp = new Video_Player(pc);

        vp.start();
        
        pc = new AVI();

        vp.setCodec(pc);
        vp.start();
    }
}
