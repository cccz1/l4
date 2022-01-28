import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("test-file.md"));
        List<String> shouldBe = List.of("https://s2omething.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), shouldBe);
    }
    
    @Test
    public void testFile2() throws IOException {
        String contents2 = Files.readString(Path.of("test-file3.md"));
        List<String> shouldBe2 = List.of("https://s2omething.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents2), shouldBe2);
    }
}
