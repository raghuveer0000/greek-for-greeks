/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
        // code here
        int cont=0;
        Node temp=head;
        while(temp!=null){
            cont++;
            temp=temp.next;
        }
        return cont;
    }
    
}