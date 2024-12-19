import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/?source=submission-ac
 */
public class PL1700 {

    public static void main(String[] args) {

        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};

        System.out.println(notServedCount(students, sandwiches));

    }


    private static int notServedCount(int[] students, int[] sandwiches) {
        int notServed = 0;

        if (students == null || sandwiches == null) {
            return notServed;
        }

        if (students.length != sandwiches.length) {
            return notServed;
        }

        Queue<Integer> studentQueue = new LinkedList();
        Stack<Integer> sandwichStack = new Stack<>();
        for (int i=0; i<students.length; i++) {
            studentQueue.offer(students[i]);
            sandwichStack.push(sandwiches[sandwiches.length - 1 - i]);
        }

        while (studentQueue.size() > 0 && notServed < studentQueue.size()) {
            if(studentQueue.peek() == sandwichStack.peek()) {
                sandwichStack.pop();
                studentQueue.poll();
                notServed = 0;
            } else {
                studentQueue.offer(studentQueue.poll());
                notServed++;
            }
        }

        return studentQueue.size();
    }
}
