package JavaTheExamples.chapter_3;

import java.io.*;

/**
 * Класс Sizecatalog содержит главный метод, и считает
 * объём каталога(файла), переданного в параметрах программы,
 * рекурсивным способом и выводит результат в Мб на консоль.
 * P.S. скрытые файлы не берёт в расчёт
 */
public class SizeCatalog {
    public static void main(String[] args) throws IOException {
        if (args.length != 1)fail("Параметр должен быть один(имя файда)");
        File file = new File(args[0]);
        if (!file.exists()) fail("Нет такого файла: " + args[0]);
        if (!file.canRead()) fail("файл защищён от чтения: " + args[0]);
        System.out.println("Общий размер каталога(файла): " + sizeCalc(file)/1024 + "Кб");
    }

    private static long sizeCalc(File file) throws IOException {
        long size = 0;
        if (file.isDirectory()) {
            String[] sub = file.list();
            for (int i = 0; i < sub.length; i++) {
                File subFile = new File(file.getPath() + "\\" + sub[i]);
                if (!subFile.isHidden()){
                    System.out.println(subFile.toString());
                    size += sizeCalc(subFile);
                }
            }
        } else {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() > 0){
                size += fileInputStream.read();
            }
        }
        return size;
    }

    private static void fail(String s) {
        throw new IllegalArgumentException(s);
    }
}
