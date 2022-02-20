/*----------------------------------------------------------------------
	FILE        : StringUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 20.02.2022

	Utility class for string operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import static java.lang.Character.*;

public final class StringUtil {
    private static final String ALPHABET_LOWER_TR;
    private static final String ALPHABET_LOWER_EN;
    private static final String ALPHABET_TR;
    private static final String ALPHABET_EN;

    static {
        ALPHABET_LOWER_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
        ALPHABET_LOWER_EN = "abcdefghijklmnopqrstuvwxyz";
        ALPHABET_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ" + ALPHABET_LOWER_TR;
        ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUWXVYZ" + ALPHABET_LOWER_EN;
    }

    private StringUtil()
    {
    }

    public static boolean areCharacterDistinct(String str)
    {
        var hashSet = new HashSet<Character>();
        var length = str.length();

        for (int i = 0; i < length; ++i)
            if (!hashSet.add(str.charAt(i)))
                return false;

        return true;
    }

    public static String capitalize(String s)
    {
        return s.isEmpty() ? s : toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String changeCase(String s)
    {
        var sb = new StringBuilder(s);
        var length = sb.length();

        for (var i = 0; i < length; ++i) {
            var ch = sb.charAt(i);
            sb.setCharAt(i, Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
        }

        return sb.toString();
    }

    public static int countString(String s1, String s2)
    {
        int count = 0;

        for (var index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
            ;

        return count;
    }

    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }

    public static String getLetters(String s)
    {
        var sb = new StringBuilder();

        var length = s.length();

        for (var i = 0; i < length; ++i) {
            var c = s.charAt(i);
            if (isLetter(c))
                sb.append(c);
        }

        return sb.toString();
    }

    public static String getLongestPalindrome(String text)
    {
        var result = "";

        var end = text.length();

        while (end != 0) {
            var begin = 0;

            while (begin != end) {
                String str = text.substring(begin++, end);

                if (str.length() > 1 && isPalindrome(str) && str.length() > result.length())
                    result = str;
            }

            --end;
        }

        return result;
    }

    public static String getRandomText(Random r, int n, String sourceText)
    {
        var sb = new StringBuilder();
        var length = sourceText.length();

        for (var i = 0; i < n; ++i)
            sb.append(sourceText.charAt(r.nextInt(length)));

        return sb.toString();
    }

    public static String getRandomTextTR(Random r, int n)
    {
        return getRandomText(r, n, ALPHABET_TR);
    }

    public static String getRandomTextTR(int n)
    {
        return getRandomTextTR(new Random(), n);
    }

    public static String [] getRandomTextsTR(Random r, int n, int minLength, int maxLength)
    {
        var texts = new String[n];

        for (var i = 0; i < n; ++i)
            texts[i] = getRandomTextTR(r, r.nextInt(maxLength - minLength + 1) + minLength);

        return texts;
    }

    public static String getRandomTextEN(Random r, int n)
    {
        return getRandomText(r, n, ALPHABET_EN);
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String [] getRandomTextsEN(Random r, int n, int minLength, int maxLength)
    {
        var texts = new String[n];

        for (var i = 0; i < n; ++i)
            texts[i] = getRandomTextEN(r, r.nextInt(maxLength - minLength) + minLength);

        return texts;
    }

    public static boolean isJavaIdentifier(String s)
    {
        if (s.equals("_"))
            return false; //Java 9 ve sonrası için kdeğişken kontrolü

        if (s.isBlank())
            return false;

        var ch = s.charAt(0);

        if (!Character.isJavaIdentifierStart(ch))
            return false;

        var length = s.length();

        for (var i = 1; i < length; ++i)
            if (!Character.isJavaIdentifierPart(s.charAt(i)))
                return false;

        return true;
    }

    public static boolean isPalindrome(String s)
    {
        var letters = getLetters(s);

        return reverse(letters).equals(letters);
    }

    public static boolean isPangram(String text, String alphabet)
    {
        var length = alphabet.length();

        for (var i = 0; i < length; ++i)
            if (text.indexOf(alphabet.charAt(i)) == -1)
                return false;

        return true;
    }

    public static boolean isPangramEN(String s)
    {
        return isPangram(s.toLowerCase(), ALPHABET_LOWER_EN);
    }

    public static boolean isPangramTR(String s)
    {
        return isPangram(s.toLowerCase(), ALPHABET_LOWER_TR);
    }

    public static String join(ArrayList<String> list, String sep)
    {
        return join(list, 0, sep);
    }

    public static String join(ArrayList<String>  list, char sep)
    {
        return join(list, 0, sep);
    }

    public static String join(ArrayList<String>  list, int startIndex, char sep)
    {
        return join(list, startIndex, sep + "");
    }

    public static String join(ArrayList<String>  list, int startIndex, String sep)
    {
        var sb = new StringBuilder();
        var size = list.size();

        for (var s : list) {
            if (sb.length() > 0)
                sb.append(sep);

            sb.append(s);
        }

        return sb.toString();
    }

    public static String join(String [] str, char sep)
    {
        return join(str, 0, sep);
    }

    public static String join(String [] str, int startIndex, char sep)
    {
        return join(str, startIndex, sep + "");
    }

    public static String join(String [] str, int startIndex, String sep)
    {
        var sb = new StringBuilder();
        var length = str.length;

        for (var i = startIndex; i < length; ++i) {
            if (sb.length() > 0)
                sb.append(sep);

            sb.append(str[i]);
        }

        return sb.toString();
    }

    public static String join(String [] str, String sep)
    {
       return join(str, 0, sep);
    }

    public static String padLeading(String s, int length, char ch)
    {
        return length <= s.length() ? s : (ch + "").repeat(length - s.length()) + s;
    }

    public static String padLeading(String s, int length)
    {
        return padLeading(s, length, ' ');
    }

    public static String padTrailing(String s, int length, char ch)
    {
        return length <= s.length() ? s : s + (ch + "").repeat(length - s.length());
    }

    public static String padTrailing(String s, int length)
    {
        return padTrailing(s, length, ' ');
    }

    public static String removeWhiteSpaces(String s)
    {
        var length = s.length();
        var sb = new StringBuilder();

        for (var i = 0; i < length; ++i) {
            var ch = s.charAt(i);

            if (!isWhitespace(ch))
                sb.append(ch);
        }

        return sb.toString();
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String squeeze(String s1, String s2)
    {
        var sb = new StringBuilder();
        var length = s1.length();

        for (var i = 0; i < length; ++i) {
            var ch = s1.charAt(i);
            if (!s2.contains(ch + ""))
                sb.append(ch);
        }

        return sb.toString();
    }

    public static String wrapWith(String str, char ch)
    {
        return wrapWith(str, ch, false);
    }

    public static String wrapWith(String str, char ch, boolean trim)
    {
        return wrapWith(str, ch, ch, trim);
    }

    public static String wrapWith(String str, char chBegin, char chEnd)
    {
        return wrapWith(str, chBegin, chEnd, false);
    }

    public static String wrapWith(String str, char chBegin, char chEnd, boolean trim)
    {
        return String.format("%c%s%c", chBegin, trim ? str.trim() : str, chEnd);
    }
}
