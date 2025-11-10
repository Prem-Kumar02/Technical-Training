class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        // if full
        if ((rear + 1) % size == front) return false;
        
        // if empty
        if (front == -1) {
            front = 0;
            rear = 0;
            arr[rear] = value;
            return true;
        }

        // normal case
        rear = (rear + 1) % size;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (front == -1) return false; // empty queue
        
        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return true;
    }
    
    public int Front() {
        if (front == -1) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if (rear == -1) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
