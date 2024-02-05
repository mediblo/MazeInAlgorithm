import java.io.*; // IO 관련 패키지
import java.awt.*; // 그래픽 처리
import java.awt.event.*; // AWT 이벤트 처리
import javax.swing.*; // 스윙 컴포넌트 처리
import java.util.ArrayList; // ArrayList 사용

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
                            Recursive_Backtracking_main();
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
        mazePanel.removeAll(); // 기존에 있던 것 초기화
        mazePanel.setLayout(new GridLayout(ROWS, COLS)); // 배치관리자 그리드 [ ROWS, COLS 수 만큼 ]

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JLabel cellLabel = new JLabel(" ");
                cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
                if (i==0 && j == 0) { // 시작점 표시
                    cellLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    cellLabel.setBackground(Color.RED);
                }
                else if ( ((ROWS%2!=0 || COLS%2!=0)&& i == ROWS-1 && j == COLS-1) || ((ROWS%2==0 && COLS%2==0) && i == ROWS-2 && j == COLS-2) ){
                    // 도착점 표시 [ 짝수는 -2 ]
                    cellLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    cellLabel.setBackground(Color.RED);
                }
                else if (maze[i][j] == 'P') {
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

    private void Recursive_Backtracking_main(){
        // 1. 무작위 한 곳 선택
        // 2. 선택된 위치에서, 상하좌우를 랜덤하게 탐색
        // 3. 탐색한 곳의 벽이 전부 막혔다면 뚫고 장소 이동
        // 4. 이동한 곳에서 이동할 수 없다면 이전 장소로 이동

        // 리스트 내용 [P/W, 이전R, 이전 C, 방문 여부]
        ArrayList<ArrayList<Object>> temp_maze = new ArrayList<>();

        // 배열 생성 및 초기화
        for(int r=0; r < ROWS; r++){
            ArrayList<Object> row_list = new ArrayList<>();

            for(int c=0; c < COLS; c++){
                char wall = 'W';
                int before_row=0;
                int before_col=0;
                boolean isVisit = false;
                
                row_list.add(new Object[]{wall, before_row, before_col, isVisit});
            }
            temp_maze.add(row_list);
        }
        
        double rand = Math.random();
        int row = (int) (rand * (ROWS-1));
        rand = Math.random();
        int col = (int) (rand * (COLS-1));
        Object[] temp_data = (Object[]) temp_maze.get(row).get(col);

        row=0;
        col=0;

        temp_data[0] = 'P';
        temp_data[1] = row;
        temp_data[2] = col;
        temp_data[3] = true; // 1번 조건 충족
        
        reback(row, col, temp_maze);

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                temp_data = (Object[]) temp_maze.get(i).get(j);
                maze[i][j] = (char) temp_data[0];
            }
        }
    }

    private void reback(int row, int col, ArrayList<ArrayList<Object>> temp_maze){
        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions);
        for(int direction : directions){
            int temp_row=row;
            int temp_col=col;
            switch(direction){
                case 0: // left
                    temp_col--;
                    break;
                case 1: // right
                    temp_col++;
                    break;
                case 2: // up
                    temp_row--;
                    break;
                case 3: // down
                    temp_row++;
                    break;
            } // 2. 상하좌우 랜덤으로 선택
            
            int count_wall=0;
            if(temp_col-1 != col && isValid(temp_col-1, temp_col, temp_maze)){ // left check
                count_wall++;
            }
            if(temp_col+1 != col && isValid(temp_col+1, temp_col, temp_maze)){ // right check
                count_wall++;
            }
            if(temp_row-1 != row && isValid(temp_row-1, temp_col, temp_maze)){ // up check
                count_wall++;
            }
            if(temp_row+1 != row && isValid(temp_row+1, temp_col, temp_maze)){ // down check
                count_wall++;
            }
            if (count_wall >= 3) { // 벽이 이전 제외 3개 이상이면 [ 폐쇄적이면 ] [ 갈 수 있는 곳 ]
                Object[] check_data = null;
                try{
                    check_data = (Object[]) temp_maze.get(temp_row).get(temp_col);
                }
                catch(IndexOutOfBoundsException e){ continue;}
                if ( (boolean) check_data[3]) { continue; }
                check_data[0] = 'P';
                check_data[1] = row;
                check_data[2] = col;
                check_data[3] = true;
                row = temp_row;
                col = temp_col;
                reback(row, col, temp_maze); // 일단 한번만 재귀
            }
        }
    }

    private boolean isValid(int row, int col, ArrayList<ArrayList<Object>> temp_maze) {
        if ((row >= 0) && (row < ROWS) && (col >= 0) && (col < COLS)){
            Object[] temp = (Object[]) temp_maze.get(row).get(col);
            return ((char)temp[0] == 'W');
        }
        return true;
    }

    public static void main(String[] args) throws IOException // IO에러 던져유~
    {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}