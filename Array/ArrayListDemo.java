package Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Initial array list- "+list);

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding 3 elements : " + list);
        list.add(1, 15);
        System.out.println("After adding at index 1 : " + list);

        int first = list.get(0);
        int size = list.size();
        System.out.println("First element: " + first + ", Size: " + size);

        list.set(2, 25);
        System.out.println("After set: " + list);

        list.remove(1);
        list.remove(Integer.valueOf(30));
        System.out.println("After remove: " + list);

        boolean has20 = list.contains(20);
        int index = list.indexOf(25);
        int lastIndex = list.lastIndexOf(25);
        System.out.println("Contains 20: " + has20 + ", Index of 25: " + index+" , last index is "+lastIndex);

        System.out.print("For loop: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.print("Enhanced for loop: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Iterator: ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Collections.sort(list);
        System.out.println("After sort: " + list);

        Collections.reverse(list);
        System.out.println("After reverse: " + list);

        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println("Array: " + java.util.Arrays.toString(arr));

        ArrayList<Integer> newList = new ArrayList<>(list);
        System.out.println("Copied list: " + newList);

        list.clear();
        boolean empty = list.isEmpty();
        System.out.println("After clear, isEmpty: " + empty);

        list.ensureCapacity(50);
        list.trimToSize();
        System.out.println("Capacity adjusted");
    }
}
