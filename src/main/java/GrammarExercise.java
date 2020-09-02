import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        if (hasTwoComma(firstWordList) || hasTwoComma(secondWordList) || containsInvalidSymbol(firstWordList)
                || containsInvalidSymbol(secondWordList)) {
            throw new RuntimeException();
        }

        return Stream.of(firstWordList.toUpperCase().split(","))
                .distinct()
                .filter(str -> Arrays.asList(secondWordList.toUpperCase().split(",")).contains(str))
                .map(str -> str.split(""))
                .map(chars -> String.join(" ", chars))
                .collect(Collectors.toList());
    }

    public static boolean hasTwoComma(String word) {
        return word.contains(",,");
    }

    public static boolean containsInvalidSymbol(String word) {
        boolean res = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch) || ch ==',') {
                continue;
            }
            res = true;
            break;
        }
        return res;
    }
}
