package swe.OCP;

public class Video_Player {
    private PlayCodec pc;
    public Video_Player(PlayCodec pc) {
        this.pc = pc;
    }

    public void setCodec(PlayCodec pc){
        this.pc = pc;
        System.out.println("코덱 변경");
    }

    public void start(){
        System.out.println("플레이어 재생");
        pc.play();
    }
}
