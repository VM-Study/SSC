import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Analyzer {
    private final String regEx;
    private final Map<String, Integer> listOfWords = new HashMap<>();

    public Analyzer(String regEx) {
        this.regEx = regEx;
    }

    public void start(Stream<String> streamOfFile, int top) {
        streamAnalysis(streamOfFile);
        printListOfTop(top);
    }

    private void printListOfTop(int top) {
        listOfWords.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .forEach(System.out::println);
    }

    private void streamAnalysis(Stream<String> streamOfFile) {
        streamOfFile.forEach(textLine ->
                Stream.of(textLine.split(" "))
                        .forEach(word -> countingWords(word.replaceAll(regEx, ""))));
    }

    private void countingWords(String word) {
        int numbers = 0;
        if (listOfWords.containsKey(word)) {
            numbers = listOfWords.get(word);
            numbers++;
        }
        listOfWords.put(word, numbers);

    }


}
