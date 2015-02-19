package chamber.n04.markdown;

import common.pattern.Builder;

import java.util.List;

/**
 * Created by gcortes on 4/15/2014.
 */
public class Markdown implements Builder<String> {
    private final StringBuffer buffer = new StringBuffer();

    public Markdown h1(final String input) {
        return h1(new StringBuffer(input));
    }

    public Markdown h1(final StringBuffer input)
    {
        buffer.append(input);
        buffer.append("\n");
        for (int i = 0; i < input.length(); i++) {
            buffer.append("=");
        }
        buffer.append("\n");
        return this;
    }

    public Markdown h2(final String input) {
        return h2(new StringBuffer(input));
    }
    public Markdown h2(final StringBuffer input)
    {
        buffer.append(input);
        buffer.append("\n");
        for (int i = 0; i < input.length(); i++) {
            buffer.append("-");
        }
        buffer.append("\n");
        return this;
    }

    public Markdown p(final String input) {
        return p(new StringBuffer(input));
    }

    public Markdown p(final StringBuffer input)
    {
        buffer.append(input);
        buffer.append("\n\n");
        return this;
    }

    public Markdown italic(final String input) {
        return italic(new StringBuffer(input));
    }
    public Markdown italic(final StringBuffer input)
    {
        buffer.append("*");
        buffer.append(input);
        buffer.append("*");
        return this;
    }

    public Markdown bold(final String input) {
        return bold(new StringBuffer(input));
    }
    public Markdown bold(final StringBuffer input)
    {
        buffer.append("**");
        buffer.append(input);
        buffer.append("**");
        return this;
    }

    public Markdown monospace(final String input) {
        return monospace(new StringBuffer(input));
    }
    public Markdown monospace(final StringBuffer input)
    {
        buffer.append("'");
        buffer.append(input);
        buffer.append("'");
        return this;
    }

    public Markdown link(final String input, final String url)
    {
        return link(new StringBuffer(input), new StringBuffer(url));
    }

    public Markdown link(final StringBuffer input, final StringBuffer url)
    {
        buffer.append('[');
        buffer.append(input);
        buffer.append(']');
        buffer.append('(');
        buffer.append(url);
        buffer.append(')');
        return this;
    }

    public Markdown list(final List<?> inputs)
    {
        for (Object input : inputs) {
            buffer.append("* ");
            buffer.append(input.toString());
        }
        return this;
    }

    @Override
    public String build() {
        return buffer.toString();
    }
}
