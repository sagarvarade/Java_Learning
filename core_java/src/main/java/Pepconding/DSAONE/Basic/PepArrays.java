package Pepconding.DSAONE.Basic;

import java.util.Scanner;

public class PepArrays {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // ArrayOne();
        // SpanOfArrays();  // Diff of array min/max values
        // searchInArray();
        // barOfArray();
         //  sumOfTwoArrays(new int[]{9,9,9},new int[]{1});
           subtractOfTwoArrays(new int[]{1,0,0,0},new int[]{1});
    }

    private static void subtractOfTwoArrays(int[] arya, int[] aryb) {
        int[] diff=new int[arya.length>aryb.length?arya.length:aryb.length];
        int carry=0;
        int i=arya.length-1;
        int j=aryb.length-1;
        int k=diff.length-1;

        while(k>=0){
            int d=0;
            int a1v=i>=0 ?arya[i]:0;
            if(arya[j]+carry>=a1v){
                d=aryb[j]+carry-a1v;
                carry=0;
            }else{
                d=aryb[j]+carry+10-a1v;
                carry=-1;
            }
            diff[k]=d;
            i--;
            j--;
            k--;
        }
        for(int val:diff){
            System.out.print(val);
        }
    }

    private static void sumOfTwoArrays(int[] arya, int[] aryb) {
        int[] sum=new int[arya.length>aryb.length?arya.length:aryb.length];
        int carry=0;
        int i=arya.length-1;
        int j=aryb.length-1;
        int k=sum.length-1;
        while(k>=0){
            int d=carry;
            if(i>=0){
                d+=arya[i];
            }
            if(j>=0){
                d+=aryb[j];
            }
            carry=d/10;
            d=d%10;
            sum[k]=d;
            i--;
            j--;
            k--;
        }
        if(carry!=0){
            System.out.print(carry);
        }
        for(int val:sum){
            System.out.print(val);
        }
    }

    private static void barOfArray() {
        try(Scanner sc=new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] aryInt = new int[n];
            for(int i=0;i<n;i++){
                aryInt[i]=sc.nextInt();
            }
            int max=aryInt[0];
            for(int k:aryInt){
                if(k>=max) max=k;
            }
            for(int i=max;i>=1;i--){
             for(int k=0;k<n;k++){
                 if(aryInt[k]>=i){
                     System.out.print("*\t");
                 }else{
                     System.out.print("\t");
                 }
             }
                System.out.println();
            }
        }
    }

    private static void searchInArray() {
        try(Scanner sc=new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] aryInt = new int[n];
            for(int i=0;i<n;i++){
                aryInt[i]=sc.nextInt();
            }
            int search=sc.nextInt();
            for(int i=0;i<n;i++){
                if(aryInt[i]==search) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    private static void SpanOfArrays() {
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            int [] aryInt=new int[n];
            for(int i=0;i<n;i++){
                aryInt[i]=sc.nextInt();
            }
            int min=aryInt[0];
            int max=aryInt[0];
            for(int k:aryInt){
                if(k<=min) min=k;
                if(k>=max) max=k;
            }
            System.out.println(max-min);
        }

    }

    private static void ArrayOne() {
        int [] aryInt=new int[3];
        aryInt[0]=10;
        aryInt[1]=20;
        aryInt[2]=30;
        for(int i=0;i<aryInt.length;i++){
            System.out.println(aryInt[i]);
            aryInt[i]=aryInt[i]+100;
        }
        swap(aryInt,1,2);
        for(int i:aryInt){
            System.out.println(i);
        }
    }

    public static void swap(int[] ary, int j, int k){
        int temp=ary[j];
        ary[j]=ary[k];
        ary[k]=temp;
    }


}
