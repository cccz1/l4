import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("test-file.md"));
        List<String> shouldBe = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), shouldBe);
    }
    
    @Test
    public void testFile2() throws IOException {
        String contents2 = Files.readString(Path.of("test-file2.md"));
        List<String> shouldBe2 = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents2), shouldBe2);
    }

    @Test
    public void testFile3() throws IOException {
        String contents3 = Files.readString(Path.of("test-file3.md"));
        List<String> shouldBe3 = List.of("https://cocacola.com");
        assertEquals(MarkdownParse.getLinks(contents3), shouldBe3);
    }

    @Test
    public void testFile4() throws IOException {
        String contents4 = Files.readString(Path.of("test-file4.md"));
        List<String> shouldBe4 = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents4), shouldBe4);
    }

    @Test
    public void testFile5() throws IOException {
        String contents5 = Files.readString(Path.of("test-file5.md"));
        List<String> shouldBe5 = List.of("page.com");
        assertEquals(MarkdownParse.getLinks(contents5), shouldBe5);
    }

    @Test
    public void testFile6() throws IOException {
        String contents6 = Files.readString(Path.of("test-file6.md"));
        List<String> shouldBe6 = List.of("page.com");
        assertEquals(MarkdownParse.getLinks(contents6), shouldBe6);
    }

    @Test
    public void testFile7() throws IOException {
        String contents7 = Files.readString(Path.of("test-file7.md"));
        List<String> shouldBe7 = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents7), shouldBe7);
    }

    @Test
    public void testFile8() throws IOException {
        String contents8 = Files.readString(Path.of("test-file8.md"));
        List<String> shouldBe8 = List.of("a link on the first line");
        assertEquals(MarkdownParse.getLinks(contents8), shouldBe8);
    }

    @Test
    public void testFile9() throws IOException{
        Path fileName = Path.of("test-file9.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("url.com");
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        assertEquals(expected,links);
    }

    @Test
    public void testFile10() throws IOException{
        Path fileName = Path.of("test-file10.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a.com");
        expected.add("a.com(())");
        expected.add("example.com");
        assertEquals(expected,links);
    }    

    @Test
    public void testFile11() throws IOException{
        Path fileName = Path.of("test-file11.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://ucsd-cse15l-w22.github.io");
        assertEquals(expected,links);
    }    
}
