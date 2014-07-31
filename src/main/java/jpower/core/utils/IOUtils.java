package jpower.core.utils;

import java.io.*;

public class IOUtils
{

    public static String getResourceAsString(Class clazz, String file)
    {
        InputStream stream = clazz.getResourceAsStream(file);
        if (stream == null)
        {
            return null;
        }
        return readStringFromStream(stream);
    }

    public static String readStringFromStream(InputStream stream)
    {
        BufferedReader reader = createBufferedReader(stream);
        StringWriter writer = new StringWriter();
        int b;
        try
        {
            while ((b = reader.read()) != -1)
            {
                writer.write(b);
            }
            stream.close();
        }
        catch (IOException e)
        {
            return null;
        }
        return writer.toString();
    }

    public static byte[] getBytes(InputStream stream) throws IOException
    {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte b;
        while ((b = (byte) stream.read()) != -1)
        {
            buffer.write(b);
        }
        return buffer.toByteArray();
    }

    public static BufferedReader createBufferedReader(InputStream stream)
    {
        return createBufferedReader(createReader(stream));
    }

    public static BufferedReader createBufferedReader(Reader reader)
    {
        return new BufferedReader(reader);
    }

    public static Reader createReader(InputStream stream)
    {
        return new InputStreamReader(stream);
    }

    public static PrintStream createPrintStream(OutputStream stream)
    {
        return new PrintStream(stream);
    }

}
