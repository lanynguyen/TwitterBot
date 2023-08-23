package org.cis1200;

import org.junit.jupiter.api.Test;
import java.io.StringReader;
import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.*;

/** Tests for FileLineIterator */
public class FileLineIteratorTest {

    /*
     * Here's a test to help you out, but you still need to write your own.
     */

    @Test
    public void testHasNextAndNext() {

        // Note we don't need to create a new file here in order to test out our
        // FileLineIterator if we do not want to. We can just create a
        // StringReader to make testing easy!
        String words = "0, The end should come here.\n"
                + "1, This comes from data with no duplicate words!";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals("0, The end should come here.", li.next());
        assertTrue(li.hasNext());
        assertEquals("1, This comes from data with no duplicate words!", li.next());
        assertFalse(li.hasNext());
    }

    /* **** ****** **** WRITE YOUR TESTS BELOW THIS LINE **** ****** **** */
    @Test
    public void testHasNextAndNextOneSentence() {
        String words = "0, The end should come here.";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals("0, The end should come here.", li.next());
        assertFalse(li.hasNext());
    }
    @Test
    public void testEmptyFile() {
        FileLineIterator li = new FileLineIterator("files/empty.csv");
        assertFalse(li.hasNext());
    }

    @Test
    public void tesNullReader() {
        String words = "0, The end should come here.";
        StringReader sr = new StringReader(words);
        BufferedReader br = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new FileLineIterator(br);
        });
    }

    @Test
    public void tesNullFilePath() {
        String filePath = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new FileLineIterator(filePath);
        });
    }

    @Test
    public void testNullFilePathFileToReader() {
        String filePath = null;
        assertThrows(IllegalArgumentException.class, () -> {
            FileLineIterator.fileToReader(filePath);
        });
    }

    @Test
    public void testNonexistentFileFileToReader() {
        String filePath = "nonexistent_file.csv";
        assertThrows(IllegalArgumentException.class, () -> {
            FileLineIterator.fileToReader(filePath);
        });
    }
}
