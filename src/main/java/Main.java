import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MethodsForTest methodsForTest = new MethodsForTest();
        System.out.println(methodsForTest.bubbleSort(Arrays.asList(3,2,5,9,1,6)));
        System.out.println(methodsForTest.binSearch(methodsForTest.bubbleSort(Arrays.asList(3,2,5,9,1,6)), 9));

        System.out.println(methodsForTest.fibonache(1000));
    }


}
