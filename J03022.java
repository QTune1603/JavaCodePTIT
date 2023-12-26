import java.util.Scanner;

public class J03022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc và xử lý từng dòng văn bản
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                processText(line);
            }
        }
        scanner.close();
    }

    public static void processText(String line) {
        StringBuilder sentence = new StringBuilder();
        String[] words = line.split("\\s+");
        for (String word: words) {
            sentence.append(word + " ");
        }

        // Tách câu từ xâu văn bản
        String[] sentences = sentence.toString().split("[.!?]");
        for (String s: sentences) {
            String str = s.trim();
            if (!str.isEmpty()) {

                System.out.println(formatSentence(str));
            }
        }
    }

    public static boolean isSentenceSeparator(char c) {
        return c == '.' || c == '!' || c == '?';
    }

    public static String formatSentence(String sentence) {
        // Chuyển ký tự đầu câu thành viết hoa, các ký tự còn lại thành viết thường
        return Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1).toLowerCase();
    }
}
