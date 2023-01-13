import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AnalyzerTest {

    @Test
    void testAnalyzerText() {
        Analyzer analyzer = new Analyzer("[^A-Za-z]");
        String text = "Our Strategic Goals \n" +
                "Strategic Goal: For Our Students... \n" +
                "Increase student engagement and student participation in learning processes. \n" +
                "Improve graduation rates and accelerate student progress to credential completion. \n" +
                "Close the gap in achievement rates for minority and underserved students. \n" +
                "Maintain high rates of career placement and improve rates of baccalaureate transition. \n" +
                "Strategic Goal: For Our Employees... \n" +
                "Build a College culture of employee satisfaction. \n" +
                "Achieve External Recognition as a Great Place to Work. \n" +
                "Ensure staffing levels are ideal and compensation levels are competitive. \n" +
                "Strategic Goal: For Our Region... \n" +
                "Increase the proportion of working adults in the region with postsecondary credentials. \n" +
                "Achieve community perception as a preferred educational destination. \n" +
                "Enhance community participation in cultural, community, and educational activities.";
        List<String> expected = Arrays.asList("and - 6", "Strategic - 4", "in - 4", "Our - 4", "of - 4", "rates - 4", "Goal - 3", "For - 3", "community - 3", "student - 3");
        List<String> result = analyzer.start(Stream.of(text), 10);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testAnalyzerString() {
        Analyzer analyzer = new Analyzer("[^A-Za-z]");
        String text = "accelerate accelerate accelerate accelerate accelerate accelerate accelerate accelerate";
        List<String> expected = List.of("accelerate - 8");
        List<String> result = analyzer.start(Stream.of(text), 10);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testAnalyzerEmpty() {
        Analyzer analyzer = new Analyzer("[^A-Za-z]");
        String text = "";
        List<String> expected = new ArrayList<>();
        List<String> result = analyzer.start(Stream.of(text), 10);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testAnalyzerDigits() {
        Analyzer analyzer = new Analyzer("[^A-Za-z]");
        String text = "1 2 3 4 5 6 7 8 9 0";
        List<String> expected = new ArrayList<>();
        List<String> result = analyzer.start(Stream.of(text), 10);
        assertThat(result).isEqualTo(expected);
    }
}
