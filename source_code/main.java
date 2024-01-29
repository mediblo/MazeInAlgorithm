import java.io.*; // IO 관련 패키지
import java.awt.*; // 그래픽 처리
import java.awt.event.*; // AWT 이벤트 처리
import javax.swing.*; // 스윙 컴포넌트 처리

class MyFrame extends JFrame {
    private char[][] maze;
    private int ROWS;
    private int COLS;
    private int temp_select;
    private JPanel mazePanel;

    public MyFrame() {
        setTitle("Maze In Algorithm");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700); // 크기
        setupUI();
        setVisible(true); // 출력여부
    }

    private void setupUI(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        mazePanel = new JPanel();
        panel.add(mazePanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JLabel rowsLabel = new JLabel("ROWS:");
        JTextField rowsField = new JTextField(5);
        JLabel colsLabel = new JLabel("Columns:");
        JTextField colsField = new JTextField(5);
        JButton generateButton = new JButton("Generate Maze");

        String[] setlect_Algorithm = {"Kruskal's", "Recursive Backtracking", "Prim's", "Binary Tree", "DFS"};
        JComboBox<String> algoCombo =  new JComboBox<>(setlect_Algorithm);
        
        controlPanel.add(algoCombo);
        controlPanel.add(rowsLabel);
        controlPanel.add(rowsField);
        controlPanel.add(colsLabel);
        controlPanel.add(colsField);
        controlPanel.add(generateButton);

        algoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp_select = algoCombo.getSelectedIndex();
            }
        });

        // 이벤트 리스너 등록
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ROWS = Integer.parseInt(rowsField.getText());
                    COLS = Integer.parseInt(colsField.getText());

                    initializeMaze();
                    switch(temp_select){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            generateMaze_DFS(0, 0);
                            break;
                    }
                    updateMazePanel();
                } catch (NumberFormatException ex)
                { // 아무것도 입력을 안 했을 때
                    JOptionPane.showMessageDialog(MyFrame.this, "Please enter valid numbers for rows and columns.");
                }
            }
        });

        add(mazePanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        panel.add(controlPanel, BorderLayout.NORTH);
    }

    // 기본 미로 초기화
    private void initializeMaze() {
        maze = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                maze[i][j] = 'W';
            }
        }
    }
    
    // 미로 제작
    private void generateMaze_DFS(int row, int col) { // DFS
        maze[row][col] = 'P';

        int[] directions = {1, 2, 3, 4};
        shuffleArray(directions);

        for (int direction : directions) { // == for direction in direcitons
            int nowRow = row;
            int nowCol = col;

            switch (direction) {
                case 1: // left
                    nowCol-=2;
                    break;
                case 2: // right
                    nowCol+=2;
                    break;
                case 3: // down
                    nowRow+=2;
                    break;
                case 4: // up
                    nowRow-=2;
                    break;
            }

            if (isValid(nowRow, nowCol)) {
                maze[(row + nowRow) / 2][(col + nowCol) / 2] = 'P';
                generateMaze_DFS(nowRow, nowCol);
            }
        }
    }

    // 순서 섞기
    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // 벽 또는 외벽인가?
    private boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROWS) && (col >= 0) && (col < COLS) && (maze[row][col] == 'W');
    }

    // 그림 그리기 타임
    private void updateMazePanel() {
        mazePanel.removeAll();
        mazePanel.setLayout(new GridLayout(ROWS, COLS));

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JLabel cellLabel = new JLabel(" ");
                cellLabel.setHorizontalAlignment(SwingConstants.CENTER);

                if (maze[i][j] == 'P') {
                    cellLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    cellLabel.setBackground(Color.WHITE);
                } else if (maze[i][j] == 'W') {
                    cellLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    cellLabel.setBackground(Color.BLACK);
                }

                cellLabel.setOpaque(true);
                mazePanel.add(cellLabel);
            }
        }
        mazePanel.revalidate();
        mazePanel.repaint();
    }

    public static void main(String[] args) throws IOException // IO에러 던져유~
    {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}