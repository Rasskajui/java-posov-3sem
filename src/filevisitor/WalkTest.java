package filevisitor;

import java.io.IOException;
import java.nio.file.*;

public class WalkTest {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\Users\\Надежда\\Desktop");
        Files.walkFileTree(start, new FileVisitorInt());
    }
}
