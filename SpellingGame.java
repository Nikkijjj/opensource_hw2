import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpellingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提供单词和对应的提示
        Map<String, String> wordHints = new HashMap<>();
        wordHints.put("apple", "一种水果，通常是红色或绿色的。");
        wordHints.put("banana", "一种黄色的水果，长形。");
        wordHints.put("cat", "一种常见的宠物，通常喜欢抓老鼠。");
        wordHints.put("dog", "一种忠诚的动物，常被当作宠物。");
        wordHints.put("elephant", "一种大型的动物，长着象鼻。");

        int score = 0;

        System.out.println("欢迎来到单词拼写游戏！");

        for (Map.Entry<String, String> entry : wordHints.entrySet()) {
            String word = entry.getKey();
            String hint = entry.getValue();

            System.out.println("提示：" + hint);
            System.out.print("请输入你认为的单词：");
            String playerInput = scanner.nextLine();

            if (playerInput.equalsIgnoreCase(word)) {
                System.out.println("正确！得分 +1");
                score++;
            } else {
                System.out.println("错误！正确的拼写是：" + word);
            }
        }

        System.out.println("游戏结束！你的总得分是：" + score + "/" + wordHints.size());
        scanner.close();
    }
}
