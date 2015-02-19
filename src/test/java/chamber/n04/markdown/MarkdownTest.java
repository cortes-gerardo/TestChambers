package chamber.n04.markdown;

import org.junit.Test;

public class MarkdownTest {
    private final Markdown markdown = new Markdown();

    @Test
    public void test()
    {
        String build = markdown.h1("Heading").h2("Sub-heading").p("Paragraphs are separated by blank line.").italic("italic")
                .bold("bold").monospace("monospace").link("link", "http://example.com").build();
        System.out.println(build);
    }

    @Test
    public void h1Test()
    {
        markdown.h1(new StringBuffer("header 1"));

        System.out.println(markdown.build());
    }
}