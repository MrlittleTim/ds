import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入字符串
        String text = scanner.nextLine().toLowerCase();
        scanner.close();

        // 分词，以空格为分隔符
        String[] words = text.split("\\s+");

        // 使用HashMap来统计词频
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        // 使用TreeMap来按词频排序
        TreeMap<Integer, List<String>> frequencyMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            int frequency = entry.getValue();
            String word = entry.getKey();

            frequencyMap.computeIfAbsent(frequency, k -> new ArrayList<>()).add(word);
        }

        // 取出前五个最高频的单词
        List<String> topWords = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : frequencyMap.entrySet()) {
            for (String word : entry.getValue()) {
                if (topWords.size() < 5) {
                    topWords.add(word);
                } else {
                    break;
                }
            }
            if (topWords.size() >= 5) {
                break;
            }
        }

        // 输出词频最高的五个单词，以空格连接
        System.out.println(String.join(" ", topWords));
    }
}




