import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private static final char SNAKE = '*';
    private static final char FOOD = '@';
    private static final char EMPTY = ' ';

    private static char[][] board = new char[HEIGHT][WIDTH];
    private static int snakeLength = 1;
    private static int[] snakeX = new int[100]; // 存储蛇身的 x 坐标
    private static int[] snakeY = new int[100]; // 存储蛇身的 y 坐标
    private static int foodX, foodY; // 食物的坐标
    private static String direction = "RIGHT"; // 初始方向

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeGame();

        while (true) {
            printBoard();
            System.out.println("输入方向（W: 上, S: 下, A: 左, D: 右，Q: 退出）:");
            char input = scanner.next().charAt(0);
            if (input == 'Q' || input == 'q') {
                break;
            }
            changeDirection(input);
            if (!moveSnake()) {
                System.out.println("游戏结束！你的得分是：" + (snakeLength - 1));
                break;
            }
        }
        scanner.close();
    }

    private static void initializeGame() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = EMPTY;
            }
        }
        snakeX[0] = HEIGHT / 2; // 蛇初始位置
        snakeY[0] = WIDTH / 2;
        board[snakeX[0]][snakeY[0]] = SNAKE;
        spawnFood();
    }

    private static void spawnFood() {
        Random random = new Random();
        do {
            foodX = random.nextInt(HEIGHT);
            foodY = random.nextInt(WIDTH);
        } while (board[foodX][foodY] != EMPTY); // 确保食物不会生成在蛇身上
        board[foodX][foodY] = FOOD;
    }

    private static void printBoard() {
        System.out.print("\033[H\033[2J"); // 清屏
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void changeDirection(char input) {
        switch (input) {
            case 'W': case 'w':
                direction = "UP";
                break;
            case 'S': case 's':
                direction = "DOWN";
                break;
            case 'A': case 'a':
                direction = "LEFT";
                break;
            case 'D': case 'd':
                direction = "RIGHT";
                break;
        }
    }

    private static boolean moveSnake() {
        int newHeadX = snakeX[0];
        int newHeadY = snakeY[0];

        switch (direction) {
            case "UP":
                newHeadX--;
                break;
            case "DOWN":
                newHeadX++;
                break;
            case "LEFT":
                newHeadY--;
                break;
            case "RIGHT":
                newHeadY++;
                break;
        }

        // 检查是否撞墙或撞到自己
        if (newHeadX < 0 || newHeadX >= HEIGHT || newHeadY < 0 || newHeadY >= WIDTH) {
            return false; // 撞墙
        }
        for (int i = 0; i < snakeLength; i++) {
            if (snakeX[i] == newHeadX && snakeY[i] == newHeadY) {
                return false; // 撞到自己
            }
        }

        // 更新蛇身坐标
        for (int i = snakeLength; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        snakeX[0] = newHeadX;
        snakeY[0] = newHeadY;

        // 检查是否吃到食物
        if (newHeadX == foodX && newHeadY == foodY) {
            snakeLength++; // 增加长度
            spawnFood(); // 重新生成食物
        }

        // 更新板子
        updateBoard();
        return true;
    }

    private static void updateBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = EMPTY;
            }
        }
        for (int i = 0; i < snakeLength; i++) {
            board[snakeX[i]][snakeY[i]] = SNAKE;
        }
        board[foodX][foodY] = FOOD;
    }
}
