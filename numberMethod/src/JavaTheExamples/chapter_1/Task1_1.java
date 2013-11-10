package JavaTheExamples.chapter_1;


public class Task1_1 {
    public static void main(String[] args) {
        System.out.println(fibonachi(20));
    }

    public static int fibonachi(int arg){
        if (arg == 2){
            return 1;
        }else if (arg == 1) {
            return 1;
        }else if (arg == 0){
            return 0;
        }else{
            int result = fibonachi(arg - 1) + fibonachi(arg - 2) + fibonachi(arg - 3);
            return result;
        }
    }
}
