package jpower.core.out;

import java.io.IOException;
import java.io.Writer;

/**
 * A delegating Writer for outputing data with dimensions
 */
public class IndentPrinter implements AutoCloseable
{

    private final Writer writer;
    private final String indentation;
    private int level = 0;

    public IndentPrinter(String indentation, Writer writer)
    {
        this.indentation = indentation;
        this.writer = writer;
    }

    public void increment()
    {
        level++;
    }

    public void decrement()
    {
        level--;
    }

    public void printIndent() throws IOException
    {
        for (int i = 0; i < level; i++)
        {
            writer.write(indentation);
        }
    }

    public void println() throws IOException
    {
        println("");
    }

    public void println(String line) throws IOException
    {
        writer.write(line + '\n');
    }

    public void print(String str) throws IOException
    {
        writer.write(str);
    }

    public void write(char character) throws IOException
    {
        writer.write(new char[]{ character });
    }

    public void write(char[] chars) throws IOException
    {
        writer.write(chars);
    }

    @Override
    public void close() throws IOException
    {
        writer.close();
    }

}
