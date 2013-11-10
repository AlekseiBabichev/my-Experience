package JavaTheExamples.chapter_3;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 29.10.13
 * Time: 1:08
 * To change this template use File | Settings | File Templates.
 */
public class ParsingFile {
    public static void main(String[] args) throws IOException {
        if (args.length != 1)fail("Параметр должен быть один(имя файда)");
        File file = new File(args[0]);
        if (!file.exists()) fail("Нет такого файла: " + args[0]);
        if (!file.canRead()) fail("файл защищён от чтения: " + args[0]);
        FileReader reader = null;
        LineNumberReader lineReader = null;
        try {
            reader = new FileReader(file);
            lineReader = new LineNumberReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> lines = new ArrayList<String>();
        while (lineReader.ready()){
            lines.add(lineReader.readLine());
        }
        int[] counts = parsingFile(lines);
        System.out.println("Количество символов: " + counts[0]);
        System.out.println("Количество слов: " + counts[1]);
        System.out.println("Количество строк: " + counts[2]);
        reader.close();
        lineReader.close();
    }

    private static int[] parsingFile(ArrayList<String> lines) {
        int[] counts = new int[3];
        for (int i = 0; i < lines.size(); i++) {

            char[] charsInLine = lines.get(i).trim().toCharArray();
            counts[0] += charsInLine.length;
            for (int j = 0; j < charsInLine.length; j++) {
                if(Character.isSpaceChar(charsInLine[j])) counts[1] ++;
            }
            counts[1]++;
        }
        counts[2] = lines.size();
        return counts;
    }

    private static void fail(String s) {
        throw new IllegalArgumentException(s);
    }
}
