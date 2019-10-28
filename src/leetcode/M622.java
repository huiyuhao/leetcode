package leetcode;

class MyCircularQueue {

//	private int[] queue;
//	private int front;
//	private int end;
//	private int size;
//
//	/** Initialize your data structure here. Set the size of the queue to be k. */
//	public MyCircularQueue(int k) {
//		queue = new int[k];
//		front = -1;
//		end = -1;
//		size = k;
//	}
//
//	/**
//	 * Insert an element into the circular queue. Return true if the operation is
//	 * successful.
//	 */
//	public boolean enQueue(int value) {
//		if (isFull())
//			return false;
//		else if (front == -1 && end == -1) {
//			front = 0;
//			end = 0;
//		} else if (end == size - 1)
//			end = 0;
//		else
//			end++;
//		queue[end] = value;
//		return true;
//	}
//
//	/**
//	 * Delete an element from the circular queue. Return true if the operation is
//	 * successful.
//	 */
//	public boolean deQueue() {
//		if (isEmpty())
//			return false;
//		else if (front == end) {
//			front = -1;
//			end = -1;
//		} else if (front == size - 1)
//			front = 0;
//		else
//			front++;
//		return true;
//	}
//
//	/** Get the front item from the queue. */
//	public int Front() {
//		if (this.isEmpty())
//			return -1;
//		else
//			return queue[front];
//	}
//
//	/** Get the last item from the queue. */
//	public int Rear() {
//		if (this.isEmpty())
//			return -1;
//		else
//			return queue[end];
//	}
//
//	/** Checks whether the circular queue is empty or not. */
//	public boolean isEmpty() {
//		if (front == -1 && end == -1)
//			return true;
//		else
//			return false;
//	}
//
//	/** Checks whether the circular queue is full or not. */
//	public boolean isFull() {
//		if (front == 0 && end == size - 1 || front == end + 1)
//			return true;
//		else
//			return false;
//	}
	
	
    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
	
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
