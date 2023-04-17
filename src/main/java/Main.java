public class Main {
    public static void main(String[] args) {
        OrderedList<Integer> orderedList = new OrderedList<>(true);

        System.out.println(orderedList.compare(null, null));

        orderedList.add(1);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(3);
        orderedList.add(7);
        orderedList.add(1);
        orderedList.add(1);
        orderedList.add(4);
        orderedList.add(8);
    }
}