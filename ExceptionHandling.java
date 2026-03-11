import java.util.ArrayList;

public class ExceptionHandling {
    public static <T> T hello(T val) {
        return val;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        try{
            System.out.println(list.get(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("oh hi error occured");
        Integer x = hello(5);
        System.out.println(x);
    }
}
