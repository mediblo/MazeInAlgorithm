import java.io.*; // IO 관련 패키지
import java.util.concurrent.Flow;
import java.awt.*; // 그래픽 처리
import java.awt.event.*; // AWT 이벤트 처리
import javax.swing.*; // 스윙 컴포넌트 처리
import javax.swing.event.*; // 스윙 이벤트

class MazePanel extends JPanel {
    private char[][] maze;

    public MazePanel(char[][] maze){
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 35; // 각 셀의 크기

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'W') {
                    // 벽을 나타내는 경우
                    g.setColor(Color.BLACK);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (maze[i][j] == 'P') {
                    // 경로를 나타내는 경우
                    g.setColor(Color.WHITE);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
                // 추가적인 경우에 따라 다른 그림을 그릴 수 있음
            }
        }
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Maze In Algorithm");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // 크기

        char[][] sampleMaze = { // 테스트 배열
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'W', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'P', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'P', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'P', 'P', 'P', 'W', 'P', 'P', 'P', 'W', 'P', 'W', 'P', 'W', 'P', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };

        MazePanel mazePanel = new MazePanel(sampleMaze);

        GridLayout gridLayout = new GridLayout(1,4);
        JPanel panel = new JPanel();
        
        panel.setLayout(gridLayout);

        String[] setlect_Algorithm = {"Kruskal's", "Recursive Backtracking", "Prim's", "Binary Tree"};
        JComboBox<String> algoCombo =  new JComboBox<>(setlect_Algorithm);

        // 이벤트 리스너 등록
        algoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 알고리즘 처리 코드
            }
        });

        panel.add(algoCombo);
        panel.add(new JButton("Reset"));
        panel.add(new JButton("Step"));
        panel.add(new JButton("Run"));

        add(mazePanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true); // 출력여부
    }

    public static void main(String[] args) throws IOException // IO에러 던져유~
    {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}