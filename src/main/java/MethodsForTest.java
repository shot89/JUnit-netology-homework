import java.math.BigInteger;
import java.util.List;

public class MethodsForTest {

    public <T extends Comparable<T>> boolean binSearch(List<T> sortedList, T searchElement) {
        int leftBorder = 0;
        int rightBorder = sortedList.size() - 1;
        while (rightBorder >= leftBorder) {
            int middle = (leftBorder + rightBorder) / 2;
            if (sortedList.get(middle).compareTo(searchElement) > 0) {
                rightBorder = middle - 1;
            } else if (sortedList.get(middle).compareTo(searchElement) < 0) {
                leftBorder = middle + 1;
            } else if (sortedList.get(middle).compareTo(searchElement) == 0) {
                return true;
            }
        }
        return false;
    }

    public <T extends Comparable<T>> List<T> bubbleSort(List<T> list) {
        T t;
        for (int a = 0; a < list.size(); a++) {
            for (int b = 0; b < list.size() - 1; b++) {
                if (list.get(b).compareTo(list.get(b + 1)) > 0) {
                    t = list.get(b);
                    list.set(b, list.get(b + 1));
                    list.set(b + 1, t);
                }
            }
        }
        return list;
    }

    public int wordsInTextCounter(String text, String word) {
        int counter = 0;
        String[] textArr = text.split(" ");
        for (String s : textArr) {
            if (s.toLowerCase().equals(word.toLowerCase()))
                counter++;
        }
        return counter;
    }

    public double currencyExchange(double amount, double exchangeCoef) {
        return amount * exchangeCoef;
    }

    public BigInteger fibonache(int number) {
        BigInteger n0 = BigInteger.valueOf(1);
        BigInteger n1 = BigInteger.valueOf(1);
        BigInteger n2 = BigInteger.valueOf(0);
        for (int i = 3; i <= number; i++) {
            n2 = n0.add(n1);
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }

}
