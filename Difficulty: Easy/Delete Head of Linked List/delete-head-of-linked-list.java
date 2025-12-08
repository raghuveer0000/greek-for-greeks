/*
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = next;
    }
}
*/

class Solution {
    public Node deleteHead(Node head) {

        
        if (head == null) {
            return null;
        }

        return head.next;
    }
}
