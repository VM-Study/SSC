import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Analyzer {
    private final String regEx;
    private final Map<String, Integer> listOfWords = new HashMap<>();

    public Analyzer(String regEx) {
        this.regEx = regEx;
    }

    public List<String> start(Stream<String> streamOfFile, int top) {
        streamAnalysis(streamOfFile);
        return selectTop(top);
    }

    protected List<String> selectTop(int top) {
        return listOfWords.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    private void streamAnalysis(Stream<String> streamOfFile) {
        streamOfFile.forEach(textLine ->
                Stream.of(textLine.split(" "))
                        .forEach(word -> countingWords(word.replaceAll(regEx, ""))));
    }

    private void countingWords(String word) {
        if (!word.isEmpty()) {
            int numbers = 1;
            if (listOfWords.containsKey(word)) {
                numbers = listOfWords.get(word);
                numbers++;
            }
            listOfWords.put(word, numbers);
        }
    }
}
