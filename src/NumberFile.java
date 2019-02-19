import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class NumberFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("liczby.txt");
        Scanner scan = new Scanner(file);

        ArrayList<Integer> lista = getIntegers(scan);
        CountOfNumbers(lista);
    }

    private static ArrayList<Integer> getIntegers(Scanner scan) {
        ArrayList<Integer> lista = new ArrayList<>();
        while (scan.hasNext()) {
            lista.add(scan.nextInt());
        }
        System.out.println(lista);
        return lista;
    }

    private static TreeSet<Integer> getIntegersSet(ArrayList<Integer> lista) {
        TreeSet<Integer> set = new TreeSet<>(lista);
        for (int i = 0; i < lista.size(); i++) {
            set.add(lista.get(i));
        }
        System.out.println(set);
        return set;
    }

    private static void CountOfNumbers(ArrayList<Integer> lista) {
        TreeSet<Integer> set = getIntegersSet(lista);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            int count = 0;
            for (int i = 0; i < lista.size(); i++) {
                if (next == lista.get(i)) {
                    count++;
                }
            }
            System.out.println(next+" – liczba wystąpień:" + count);
        }
    }
}