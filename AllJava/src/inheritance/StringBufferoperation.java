package inheritance;

public class StringBufferoperation {

    public static void main(String args[]){
        StringBuffer sb=new StringBuffer("Hello");
        sb.replace(1,3,"java");
        System.out.println(sb);
        sb.append("Shraddha");
        System.out.println(sb);

        //stringbuffer capacity increased by (current size*2)+2

        sb.insert(1,"jack");
        System.out.println(sb);

        int a=10;
        a=9;
        System.out.println(a);

    }
}
