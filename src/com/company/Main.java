// This is the main class of the project
package  com.company;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int n =2;
//        towerOfHanoi(n,"S","H","D");
//        reverseString("Hello");
//        System.out.println(removeDuplicates("aaabbbccc"));
//        findOccurrence("Hello",'l');
//        int[] arr = {1,2,3,4,5,6,7,8,9};
//        System.out.println(isSorted(arr,0));
//        moveToEnd(arr,0,5);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }
//        printKeyPadCombinations("23","");
//
//        printPermutations("zaman","");
//        System.out.println(countPath(3,3));
//        System.out.println(callGuest(5));
        int m= 3;
        ArrayList<Integer> arr = new ArrayList<>();
        findSubset(m,arr);
    }




// Recursive function to solve Tower of Hanoi puzzle
    public static void towerOfHanoi(
            int n,String scr,String helper,String dest
    ){
        if(n==1){
            System.out.println("Move disk 1 from "+scr+" to "+dest);
            return;
        }
        towerOfHanoi(n-1,scr,dest,helper);
        System.out.println("Move disk "+n+" from "+scr+" to "+dest);
        towerOfHanoi(n-1,helper,scr,dest);
    }

    // print a string in reverse
    public static void reverseString(String str){
        if(str.isEmpty()){
            return;
        }
        reverseString(str.substring(1));
        System.out.print(str.charAt(0));
    }

    // find the 1st and last occurrence of an element in string
    public static void findOccurrence(String str,char ch){
        int first = str.indexOf(ch);
        int last = str.lastIndexOf(ch);
        System.out.println("First occurrence of "+ch+" is at index "+first);
        System.out.println("Last occurrence of "+ch+" is at index "+last);
    }


    // check if an array is sorted(strictly increasing)
    public static boolean isSorted(int[] arr,int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>=arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    // move all x to the end of the array
    public static void moveToEnd(int[] arr,int i,int x){
        if(i==arr.length){
            return;
        }
        if(arr[i]==x){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]!=x){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }
        moveToEnd(arr,i+1,x);
    }

    // remove duplicate characters from a string

    public static String removeDuplicates(String str){
        if(str.isEmpty() || str.length()==1){
            return str;
        }
        if(str.charAt(0)==str.charAt(1)){
            return removeDuplicates(str.substring(1));
        }
        return str.charAt(0)+removeDuplicates(str.substring(1));
    }


    ///
    public static String[] keyPad = {".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void printKeyPadCombinations(String str,String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String code = keyPad[ch-'0'];
        String rest = str.substring(1);
        for(int i=0;i<code.length();i++){
            printKeyPadCombinations(rest,ans+code.charAt(i));
        }
    }

    // print all permutations of a string

    public static void printPermutations(String str,String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String rest = str.substring(0,i)+str.substring(i+1);
            printPermutations(rest,ans+ch);
        }
    }

    // count total path maze to move from (0,0) to (n,m)

    public static int countPath(int n,int m){
        if(n==1 || m==1){
            return 1;
        }
        return countPath(n-1,m)+countPath(n,m-1);
    }


    public static  int callGuest(int n){
        if(n<=1){
            return 1;
        }
        return n+callGuest(n-1);

    }


   public static void findSubset(int m,ArrayList<Integer> arr){
        if(m==0){
            printSubset(arr);
            return;
        }
        findSubset(m-1,arr);
        arr.add(m);
        findSubset(m-1,arr);
        arr.removeLast();
   }

   public static void printSubset(ArrayList<Integer> arr){
       for(Integer integer : arr) {
           System.out.print(integer + " ");
       }
         System.out.println();
   }





}