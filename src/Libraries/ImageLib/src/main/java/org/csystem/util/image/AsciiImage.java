/*----------------------------------------------------------------------
	FILE        : AsciiImage.java
	AUTHOR      : JavaApp-Oct-2021 Group
    LAST UPDATE : 20.03.2022

	AsciiImage class for ascii image operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.image;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class AsciiImage {
    private final char [][] m_image;

    private void fillImage(Path path) throws IOException
    {
        try (var br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
            String line;
            int i = 0;

            while ((line = br.readLine()) != null) {
                int len = line.length();

                for (int k = 0; k < len; ++k)
                    m_image[i][k] = line.charAt(k);
                ++i;
            }
        }
    }

    private void floodFillRecur(int i, int k, char c, char bound)
    {
        if (m_image[i][k] == c || m_image[i][k] == bound)
            return;

        m_image[i][k] = c;

        floodFillRecur(i + 1, k, c, bound);
        floodFillRecur(i, k + 1, c, bound);
        floodFillRecur(i - 1, k, c, bound);
        floodFillRecur(i, k - 1, c, bound);
    }

    private AsciiImage(int row, int col)
    {
        m_image = new char[row][col];
    }

    public static AsciiImage of(int row, int col)
    {
        return new AsciiImage(row, col);
    }

    public int getRow()
    {
        return m_image.length;
    }

    public int getCol()
    {
        return m_image[0].length;
    }

    public char getChar(int i, int k)
    {
        return m_image[i][k];
    }

    public AsciiImage setChar(int i, int k, char c)
    {
        m_image[i][k] = c;

        return this;
    }

    public AsciiImage loadImage(String path) throws IOException
    {
        Arrays.stream(m_image).forEach(array -> Arrays.fill(array, ' '));
        fillImage(Path.of(path));

        return this;
    }

    public AsciiImage saveImage(String path) throws IOException
    {
        try (var bw = Files.newBufferedWriter(Path.of(path), StandardCharsets.US_ASCII,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write(toString());
            bw.flush();
        }

        return this;
    }

    public AsciiImage floodFill(int i, int k, char c, char bound)
    {
        floodFillRecur(i, k, c, bound);

        return this;
    }

    public AsciiImage transpose()
    {
        //TODO:

        return this;
    }

    public AsciiImage flipV()
    {
        //TODO:

        return this;
    }

    public AsciiImage flipH()
    {
        //TODO:

        return this;
    }

    //...

    @Override
    public String toString()
    {
        var sb = new StringBuilder();

        for (var chars : m_image) {
            for (char c : chars)
                sb.append(c);
            sb.append("\r\n");
        }

        return sb.toString();
    }
}
