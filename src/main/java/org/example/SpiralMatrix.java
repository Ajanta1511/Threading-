package org.example;

import java.util.Arrays;

public class SpiralMatrix {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            next=null;
        }
    }
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
    public int[][] spiralMatrix(ListNode head, int m, int n){
        int[][] matrix = new int[m][n];
        for(int[] row:matrix){
            Arrays.fill(row,-1);
        }
        int top=0, bottom = m-1, left =0, right = n-1;
        ListNode current = head;
        while(current!= null && top<bottom && left<right){
            for (int i = left; i <= right && current != null; i++) {
                matrix[top][i] = current.val;
                current = current.next;
            }
            top++;
            for(int i=top; i<=bottom && current!=null; i++){
                matrix[i][right]=current.val;
                current=current.next;
            }
            right--;
            for(int i=right; i>=left && current!=null; i--){
                matrix[bottom][i]=current.val;
                current=current.next;
            }
            bottom--;
            for(int i=bottom; i<=top && current!=null; i--){
                matrix[left][i]=current.val;
                current=current.next;
            }
            left++;
        }
        return matrix;
    }
    // --- Main method for testing ---
    public static void main(String[] args) {
        SpiralMatrix converter = new SpiralMatrix();

        // Example: create linked list 1 -> 2 -> 3 -> ... -> 17
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 17; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        int m = 4, n = 5; // 4 rows, 5 columns (total 20 cells, but only 17 nodes in list)
        int[][] result = converter.spiralMatrix(head, m, n);

        System.out.println("Spiral Matrix:");
        converter.printMatrix(result);
    }
}
