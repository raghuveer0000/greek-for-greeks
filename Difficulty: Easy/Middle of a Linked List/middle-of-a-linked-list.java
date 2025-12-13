/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    int getMiddle(Node head) {
        // code here
        Node i=head;
        Node j=head;
        while(j!=null && j.next!=null){
            i=i.next;
            j=j.next.next;
        }
        return i.data;
    }
}