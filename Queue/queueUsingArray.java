class myQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int count;

    // Constructor
    public myQueue(int n) {
        arr = new int[n];
        size = n;
        front = 0;
        rear = 0;
        count = 0; 
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void enqueue(int x) {
        if (isFull()) return;
        arr[rear] = x;
        rear = (rear + 1) % size;
        count++;
    }

    public void dequeue() {
        if (isEmpty()) return;
        front = (front + 1) % size;
        count--;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        int idx = (rear - 1 + size) % size; 
        return arr[idx];
    }
}
