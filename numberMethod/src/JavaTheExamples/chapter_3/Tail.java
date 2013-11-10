package JavaTheExamples.chapter_3;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 28.10.13
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public class Tail {
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
        ArrayList<String> list = new ArrayList<String>();
        while (lineReader.ready()){
            list.add(lineReader.readLine());
        }
        for (int i = 0; i <(list.size() > 10 ? 10 : list.size()); i++) {
            System.out.println(list.get(list.size() - ((list.size() > 10 ? 10 : list.size()) - i)));
        }
        reader.close();
        lineReader.close();
    }

    private static void fail(String s) {
        throw new IllegalArgumentException(s);
    }
}
