import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int maxPerimeterTriangle(ArrayList<Integer> arr, int n) {
        // Write your code here.
        Collections.sort(arr);

        for(int i = n-1 ; i>=2 ; i--){
            int a = arr.get(i-2);
            int b = arr.get(i-1);
            int c = arr.get(i);

            if(a+b > c){
                return a+b+c;
            }
        }

        return 0;
    }
}