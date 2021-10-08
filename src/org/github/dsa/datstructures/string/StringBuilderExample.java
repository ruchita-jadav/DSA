package org.github.dsa.datstructures.string;

public class StringBuilderExample {

    public static void main(String[] args) {
        String str = "example";
        StringBuilder sb = new StringBuilder(str);
        for ( int i = 0 ; i < sb.length() ; i++){
            sb.delete(i, i+1);
            sb.charAt(i);
            System.out.println(sb.toString());
        }
//        int start = 0 , end  = 2 ;
//
//        sb.delete(start, end);
//        System.out.println(sb.toString());
//        sb.deleteCharAt(4);
//        System.out.println(sb.toString());
//        sb.insert(2,'g');
//        System.out.println(sb.toString());
    }
}
