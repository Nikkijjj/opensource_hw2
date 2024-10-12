import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // 生成 1 到 100 之间的随机数
        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to Guess The Number Game!");
        System.out.println("我已经选好了一个 1 到 100 之间的数字。你能猜到它是什么吗？");

        // 游戏主循环
        while (!hasGuessedCorrectly) {
            System.out.print("请输入你的猜测：");
            int playerGuess = scanner.nextInt();
            numberOfTries++;

            if (playerGuess < numberToGuess) {
                System.out.println("太低了！再试一次。");
            } else if (playerGuess > numberToGuess) {
                System.out.println("太高了！再试一次。");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("恭喜你！你猜对了数字 " + numberToGuess + "，总共尝试了 " + numberOfTries + " 次。");
            }
        }

        scanner.close();
    }
}
