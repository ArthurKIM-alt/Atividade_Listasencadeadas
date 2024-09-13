public class ListaCircularSimplesmenteEncadeada<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void adicionar(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void remover(T data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            if (head.next == head) {
                head = null;
            } else {
                Node<T> current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            return;
        }

        Node<T> current = head;
        while (current.next != head && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
        }
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
        ListaCircularSimplesmenteEncadeada<Integer> lista = new ListaCircularSimplesmenteEncadeada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.imprimir(); // Saída: 1 2 3

        lista.remover(2);
        lista.imprimir(); // Saída: 1 3
    }
}
