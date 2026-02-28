//public class LL {
//
//    Node head;
//    class Node{
//        int data;
//        Node next;
//
//        Node(int data){
//            this.data = data;
//        }
//    }
//    public void insert(int data){
//        Node newnode = new Node(data);
//        if(head == null){
//            head = newnode;
//            return;
//        }
//        newnode.next = head;
//        head = newnode;
//    }
//
//    public void printlist(){
//        if(head == null){
//            System.out.println("List is empty");
//        }
//        Node currNode = head;
//        while(currNode != null){
//            System.out.print(currNode.data + " -> ");
//            currNode = currNode.next;
//        }
//        System.out.println("Null");
//    }
//
//    public void reverse(){
//        if(head == null || head.next == null){
//            return;
//        }
//        Node prevNode = head;
//        Node currNode = head.next;
//        while(currNode != null){
//            Node nextNode = currNode.next;
//            currNode.next = prevNode;
//
//            //update
//            prevNode = currNode;
//            currNode = nextNode;
//        }
//        head.next = null;
//        head = prevNode;
//    }
//
//    public Node reverse1(Node head){
//        if(head == null || head.next == null){
//            return head;
//        }
//        Node newnode = reverse1(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return newnode;
//    }
//    public static void main(String[] args) {
//        LL list = new LL();
//        list.insert(5);
//        list.insert(4);
//        list.insert(3);
//        list.insert(2);
//        list.insert(1);
//        list.printlist();
//        list.head = list.reverse1(list.head);
//        list.printlist();
//
//    }
//}

import java.util.Scanner;

public class LL {
    private int size;
    Node head;

    LL() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add last
    public void addLast(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newnode;
    }

    // Insert at index
    public void insert(String data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        Node newnode = new Node(data);
        newnode.next = curr.next;
        curr.next = newnode;
    }

    // Print list
    public void printlist() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("Null");
    }

    // Delete first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    // Delete last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    // Delete at index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        size--;
        Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }

    // Find value
    public void find(String data) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data.equals(data)) {
                System.out.println("Found at index " + index);
                return;
            }
            curr = curr.next;
            index++;
        }
        System.out.println("Value not found");
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Reverse (Iterative)
    public void reverseIterate() {
        if (head == null || head.next == null) return;

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // ================= MENU =================

    public static void main(String[] args) {
        LL list = new LL();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Linked List Menu");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert at Index");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Index");
            System.out.println("7. Find Value");
            System.out.println("8. Print List");
            System.out.println("9. Get Size");
            System.out.println("10. Reverse List");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    list.addFirst(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter value: ");
                    list.addLast(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Enter value: ");
                    String val = sc.nextLine();
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();
                    list.insert(val, idx);
                }
                case 4 -> list.deleteFirst();
                case 5 -> list.deleteLast();
                case 6 -> {
                    System.out.print("Enter index: ");
                    list.delete(sc.nextInt());
                }
                case 7 -> {
                    System.out.print("Enter value to find: ");
                    list.find(sc.nextLine());
                }
                case 8 -> list.printlist();
                case 9 -> System.out.println("Size: " + list.getSize());
                case 10 -> list.reverseIterate();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
