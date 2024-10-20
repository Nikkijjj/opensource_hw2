import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"石头", "剪子", "布"};
        int playerScore = 0;
        int computerScore = 0;
        int rounds = 5; // 总共玩5轮

        System.out.println("欢迎来到石头剪子布游戏！");
        System.out.println("在每轮中，你可以选择：0 - 石头，1 - 剪子，2 - 布。");

        // 游戏主循环
        for (int i = 0; i < rounds; i++) {
            System.out.print("请输入你的选择（0-2）：");
            int playerChoice = scanner.nextInt();

            // 计算机随机选择
            int computerChoice = random.nextInt(3);

            System.out.println("你选择了：" + options[playerChoice]);
            System.out.println("计算机选择了：" + options[computerChoice]);

            // 判定胜负
            if (playerChoice == computerChoice) {
                System.out.println("平局！");
            } else if ((playerChoice == 0 && computerChoice == 1) ||
                    (playerChoice == 1 && computerChoice == 2) ||
                    (playerChoice == 2 && computerChoice == 0)) {
                System.out.println("你赢了！");
                playerScore++;
            } else {
                System.out.println("你输了！");
                computerScore++;
            }

            System.out.println("当前比分：你 " + playerScore + " - " + computerScore + " 计算机");
            System.out.println();
        }

        // 总结结果
        System.out.println("游戏结束！");
        System.out.println("最终比分：你 " + playerScore + " - " + computerScore + " 计算机");
        if (playerScore > computerScore) {
            System.out.println("你赢得了比赛！");
        } else if (playerScore < computerScore) {
            System.out.println("你输了比赛。");
        } else {
            System.out.println("比赛平局。");
        }

        // 关闭扫描器
        scanner.close();
    }
}
