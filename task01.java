import java.util.LinkedList;

public class task01 {
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        
        return reversedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> originalList = new LinkedList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(4);
        
        LinkedList<Integer> reversedList = reverseLinkedList(originalList);
        
        System.out.println("Original List: " + originalList);
        System.out.println("Reversed List: " + reversedList);
    }
}
