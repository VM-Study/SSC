import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Loader {

    public Stream<String> start(String fileName) throws Exception {
        Path file = checkFile(fileName);
        return loadToStream(file);
    }

    private static Stream<String> loadToStream(Path file) throws IOException {
        return Files.lines(file);
    }

    public Path checkFile(String fileName) throws Exception {
        Path file = Path.of(fileName);
        if (Files.exists(file)) {
            return file;
        } else {
            throw new Exception("File '"+fileName+"' can't load.");
        }
    }
}
