import java.util.List;
import java.util.Arrays;
import static java.lang.Thread.sleep;

public class Streams_1 {
 
    public static void main(String args[])throws Exception{
        List<Integer> numbers = Arrays
				.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        numbers.parallelStream()
                .map(e -> transform(e))
                .forEach(System.out::print);
    }
    public static int transform(int number) {

        System.out.print("t: "+number+ "--"+ Thread.currentThread());
        try {
            sleep(1000);
        }catch (InterruptedException i){
            i.printStackTrace();
        }
        return number * 1;
    }
}
