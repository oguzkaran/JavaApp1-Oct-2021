package org.csystem.util.image;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class AsciiImage {
    private char [][] m_image;

    private void fillBitmap(String path)
    {
        try (var br = Files.newBufferedReader(Path.of(path), StandardCharsets.US_ASCII)) {
            String line;
            int i = 0;

            while ((line = br.readLine()) != null) {
                int len = line.length();
                if (line.charAt(len - 1) == '\r')
                    line = line.substring(0, len - 1);

                for (int k = 0; k < len; ++k)
                    m_image[i][k] = line.charAt(k);
                ++i;
            }
        }
        catch (Throwable ex) {
            System.err.printf("Exception occurred int loadImage:%s%n", ex.getMessage());
        }
    }

    private void floodFill(char [][] image, int i, int k, char c, char bound)
    {
        if (image[i][k] == c || image[i][k] == bound)
            return;

        image[i][k] = c;
        floodFill(image, i + 1, k, c, bound);
        floodFill(image, i, k + 1, c, bound);
        floodFill(image, i - 1, k, c, bound);
        floodFill(image, i, k - 1, c, bound);
    }

    public AsciiImage(int row, int col)
    {
        m_image = new char[row][col];
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

    public void setChar(int i, int k, char c)
    {
        m_image[i][k] = c;
    }

    public void loadImage(String path)
    {
        for (var array : m_image)
            Arrays.fill(array, ' ');

        fillBitmap(path);
    }

    public void saveImage(String path)
    {
        try (var bw = Files.newBufferedWriter(Path.of(path), StandardCharsets.US_ASCII, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write(this.toString());
            bw.flush();
        }
        catch (Throwable ex) {
            System.err.printf("Exception occurred in saveImage:%s%n", ex.getMessage());
        }
    }

    public void floodFill(int i, int k, char c, char bound)
    {
        floodFill(m_image, i, k, c, bound);
    }

    public void flipV()
    {
        //TODO:
    }

    public void transpose()
    {
        int row = m_image.length;
        int col = m_image[0].length;

        var image = new char[col][row];

        for (int i = 0; i < row; ++i)
            for (int k = 0; k < col; ++k)
                image[k][i] = m_image[i][k];

        m_image = image;
    }

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
