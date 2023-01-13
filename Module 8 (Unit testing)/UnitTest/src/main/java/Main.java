import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static final String FILE_NAME = "text.txt";
    public static final String regEx = "[^A-Za-z]";

    public static void main(String[] args) throws Exception {
        Loader loader = new Loader();
        Analyzer analyzer = new Analyzer(regEx);

        Stream<String> streamOfFile = loader.start(FILE_NAME);
        List<String> topList = analyzer.start(streamOfFile, 10);
        printAllList(topList);

    }

    private static void printAllList(List<String> selectTop) {
        for (String s : selectTop) {
            System.out.println(s);
        }
    }


}
