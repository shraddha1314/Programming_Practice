package inheritance;

import java.util.Scanner;

public class Array {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number of rows:");
        int allrow=sc.nextInt();

        int[][] jaggedArray=new int[allrow][];

        for(int i=0;i<allrow;i++){
            System.out.println("Enter a size of subarray["+i+"]:");
            int subarraysize=sc.nextInt();

            jaggedArray[i]=new int[subarraysize];

        }

        for(int i=0;i<allrow;i++){
            System.out.println("enter element for subarray "+i+" :");
            for(int j=0;j<jaggedArray[i].length;j++){
                jaggedArray[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<allrow;i++){
            System.out.println("");
            for(int j=0;j<jaggedArray[i].length;j++){
                System.out.print(jaggedArray[i][j]+" ");
            }
        }
    }
}


//==================================================================================================


//import java.util.Scanner;

//public class Array {
//
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        System.out.println("enter a number of rows:");
//        int allrow=sc.nextInt();
//
//        int[][] jaggedArray=new int[allrow][];
//
//        for(int i=0;i<allrow;i++){
//            System.out.println("Enter a size of subarray["+i+"]:");
//
//
//            jaggedArray[i]=new int[i+1];
//
//        }
//
//        for(int i=0;i<allrow;i++){
//            System.out.println("enter element for subarray "+i+" :");
//            for(int j=0;j<jaggedArray[i].length;j++){
//                jaggedArray[i][j]=sc.nextInt();
//            }
//        }
//        for(int i=0;i<allrow;i++){
//            System.out.println("");
//            for(int j=0;j<jaggedArray[i].length;j++){
//                System.out.print(jaggedArray[i][j]+" ");
//            }
//        }
//    }
//}
