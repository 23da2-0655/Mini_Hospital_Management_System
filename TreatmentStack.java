public class TreatmentStack {
    private class Node {
        TreatmentRecord record;
        Node next;

        Node(TreatmentRecord record) {
            this.record = record;
        }
    }

    private Node top;

    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("No completed treatments.");
            return;
        }

        Node current = top;
        System.out.println("\n===== Treatment History =====");

        while (current != null) {
            current.record.displayRecord();
            current = current.next;
        }
    }
}
