// A program for testing MyStack<E> and MyQueue<E> classes
public class TestMyStackAndMyQueue {
   public static void main(String[] args) {
      // create a queue that can store 5 integer elements
      // by giving 5 as the capacity input argument of the constructor
      MyQueue<Integer> queue = new MyQueue<>(5);
      // try to enqueue numbers from 1 to 7 and print the queue contents each
      // time the number is enqueued successfully
      for (int num = 1; num <= 7; num++)
         if (queue.enqueue(num))
            System.out.println(num + " is enqueued. Queue: head -> " + queue);
         else
            System.out.println(num + " cannot be enqueued as the queue is full.");
      System.out.println(); // adding a new line

      // create a stack to store integer elements
      MyStack<Integer> stack = new MyStack<>();
      // transfer the first 3 items in the queue to the stack
      for (int i = 0; i < 3; i++) {
         int item = queue.peek(); // get the first item (head) of the queue
         // push the item to the stack and print the stack
         stack.push(item);
         System.out.println(item + " is pushed. Stack: top -> " + stack);
         // dequeue the first item (head) of the queue and print the queue
         queue.dequeue();
         System.out.println(item + " is dequeued. Queue: head -> " + queue);
      }
      System.out.println(); // adding a new line

      // transfer each item in the stack back to the queue
      while (!stack.isEmpty()) { // loop until the stack becomes empty
         // pop the top item and print the stack
         int item = stack.peek(); // get the top item of the stack
         System.out.println(stack.pop() + " is popped. Stack: top -> " + stack);
         // enqueue the item and print the queue
         queue.enqueue(item);
         System.out.println(item + " is enqueued. Queue: head -> " + queue);
      }
   }
}