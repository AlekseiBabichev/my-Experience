package JavaTheExamples.chapter_3;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ListCatalog {
    public static void main(String[] args) throws IOException {
        if (args.length < 1 || args.length > 2)fail("В параметры нужно передавать имя каталога(файла) или с использованием" +
                " опции -s для сортировки по размеру, либо с опцией -d, с сортировкой от самых новых к самым старым");
        File file;
        if (args.length == 1){
            file = new File(args[0]);
        } else{
            file = new File(args[1]);
            if (!(args[0].equals("-s") || args[0].equals("-d")))fail("нет такой опции: " + args[0] +
                    "\n-s\t сортировка по размеру\n -d\t сортировка по дате создания");
        }
        if (!file.exists()) fail("Нет такого каталога(файла): " + file.getName());
        if (!file.canRead()) fail("каталог(файл) защищён от чтения: " + file.getName());
        createAndPrintInfo(file);
    }

    private static void createAndPrintInfo(File file) {

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
