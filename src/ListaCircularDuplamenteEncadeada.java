public class ListaCircularDuplamenteEncadeada<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void adicionar(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void remover(T data) {
        if (head == null) return;

        Node<T> current = head;
        do {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = current.prev;
                    }
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    public void imprimir() {
        if (head == null) return;

        Node<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        ListaCircularDuplamenteEncadeada<Integer> lista = new ListaCircularDuplamenteEncadeada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.imprimir(); // Saída: 1 2 3

        lista.remover(2);
        lista.imprimir(); // Saída: 1 3
    }
}
