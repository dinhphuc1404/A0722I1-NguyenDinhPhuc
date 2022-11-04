package ss10_danh_sach.BaiTap.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(20);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(19);
        myLinkedList.addLast(5);
        myLinkedList.add(2,2);
        System.out.println(myLinkedList.get(0)+" ");
        System.out.println(myLinkedList.get(1)+" ");
        System.out.println(myLinkedList.get(2)+" ");
        System.out.println(myLinkedList.get(3)+" ");
    }
}
