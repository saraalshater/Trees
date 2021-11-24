public class Queue<T> {

    private QNode<T> front;
    private QNode<T> back;

    public void enqueue(T data) {
        if (isEmpty()) {
            QNode<T> node = new QNode<>(data);
            front = node;
            back = node;
        } else {
            QNode<T> node = new QNode<>(data);
            back.setNext(node);
            back = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            T data = front.getData();
            front = front.getNext();
            return data;
        }
    }

    public T peek() {
        return front.getData();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public QNode<T> getFront() {
        return front;
    }

    public void setFront(QNode<T> front) {
        this.front = front;
    }

    public QNode<T> getBack() {
        return back;
    }

    public void setBack(QNode<T> back) {
        this.back = back;
    }
}
