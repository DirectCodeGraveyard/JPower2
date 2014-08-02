package jpower.core.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FileUtils
{

    /**
     * Put the contents of a file into a String
     * @param file File to retrieve contents from
     * @return String with file contents
     */
    public static String toString(File file) throws IOException
    {
        return new String(readBytes(file));
    }

    /**
     * Check if a file exists
     * @param file File
     * @return true if the file exists
     */
    public static boolean exists(File file)
    {
        return Files.exists(file.toPath());
    }

    /**
     * Create a Byte array from all Bytes read from a File
     * @param file Target File to read
     * @return Byte array with File as target
     */
    public static byte[] readBytes(File file) throws IOException
    {
        return Files.readAllBytes(file.toPath());
    }

    /**
     * Read all of the lines of text from a File
     * @param file Target File to read
     * @return List of Strings containing file's contents
     */
    public static List<String> readLines(File file) throws IOException
    {
        return Files.readAllLines(file.toPath());
    }

    /**
     * List Files inside of a Folder
     * @param file Target folder to list files from
     * @return Stream of Paths in that folder
     */
    public static Stream<Path> listFiles(File file) throws IOException
    {
        return Files.list(file.toPath());
    }

    /**
     * Write text to a File
     * @param file File to write
     * @param text Text to write
     */
    public static void write(File file, String text) throws IOException
    {
        write(file, text.getBytes());
    }

    /**
     * Write text(as a List) to a File
     * @param file File to write
     * @param lines Lines to write
     */
    public static void write(File file, List<String> lines) throws IOException
    {
        write(file, ListUtils.toString(lines));
    }

    /**
     * Write text(as a Byte array) to a File
     * @param file File to write
     * @param input Bytes to write
     */
    public static void write(File file, byte[] input) throws IOException
    {
        Files.write(file.toPath(), input);
    }

    /**
     * Create a BufferedReader for reading a File
     * @param file Target File to read
     * @return BufferedReader with File as target
     */
    public static BufferedReader newReader(File file) throws IOException
    {
        return Files.newBufferedReader(file.toPath());
    }

    /**
     * Create a BufferedWriter for writing a File
     * @param file Target File to writer
     * @return BufferedWriter with File as target
     */
    public static BufferedWriter newWriter(File file) throws IOException
    {
        return Files.newBufferedWriter(file.toPath());
    }

    /**
     * Watch a File
     * @param file File to watch
     * @param handler Handler for events
     * @param kinds WatchEvent Kinds
     */
    public static void watch(File file, Function<WatchEvent<?>, Boolean> handler, WatchEvent.Kind<?>... kinds) throws IOException
    {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path path = file.toPath();
        WatchKey key = path.register(watcher, kinds);
        exit:
        while (true)
        {
            for (WatchEvent<?> event : key.pollEvents())
            {
                if (!handler.apply(event))
                {
                    break exit;
                }
            }
            boolean valid = key.isValid();
            if (!valid)
            {
                break;
            }
        }
    }

}
