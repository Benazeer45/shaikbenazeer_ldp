package Java_Assignments.Assignment10;

import java.util.Scanner;

public class SList<T> {
    private static class Link<T> {
        T element;
        Link<T> next;

        Link(T element) {
            this.element = element;
            this.next = null;
        }
    }

    private Link<T> head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public SListIterator<T> iterator() {
        return new SListIterator<>(this);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link<T> current = head;
        while (current != null) {
            sb.append(current.element).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static class SListIterator<T> {
        private Link<T> current;
        private Link<T> previous;
        private Link<T> lastAccessed;
        private SList<T> list;

        public SListIterator(SList<T> list) {
            this.list = list;
            this.current = list.head;
            this.previous = null;
            this.lastAccessed = null;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No next element.");
            }
            lastAccessed = current;
            T element = current.element;
            previous = current;
            current = current.next;
            return element;
        }

        public void insert(T element) {
            Link<T> newLink = new Link<>(element);
            if (list.head == null) {
                list.head = newLink;
            } else {
                newLink.next = list.head;
                list.head = newLink;
            }
            current = newLink;
            list.size++;
        }

        public void remove() {
            if (list.head == null) {
                throw new IllegalStateException("List is empty.");
            }
            if (list.head.next == null) {
                list.head = null;
            } else {
                Link<T> current = list.head;
                Link<T> previous = null;
                while (current.next != null) {
                    previous = current;
                    current = current.next;
                }
                if (previous != null) {
                    previous.next = null;
                }
            }
            list.size--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SList<Integer> list = new SList<>();
        SListIterator<Integer> iterator = list.iterator();

        System.out.println("Performing default operations:");
        iterator.insert(10);
        iterator.insert(20);
        iterator.insert(30);

        System.out.println("Initial List: " + list);

        while (true) {
            System.out.println("\nChoose an operation: ");
            System.out.println("1. Insert element");
            System.out.println("2. Remove last element");
            System.out.println("3. Display list");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    iterator.insert(element);
                    System.out.println("Element inserted. Updated list: " + list);
                    break;

                case 2:
                    try {
                        iterator.remove();
                        System.out.println("Last element removed. Updated list: " + list);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Current List: " + list);
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
