/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public ArrayList<Integer> printList(Node head) {
        
        ArrayList<Integer> result = new ArrayList<>(); // return this list

        Node temp = head;

        while (temp != null) {
            result.add(temp.data);  
            temp = temp.next;       // move to next node
        }
        
        return result;
    }
}
