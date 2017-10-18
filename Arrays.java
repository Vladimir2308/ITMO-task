public class Arrays {
    public static void main(String[] args) {
        String str1 = "ee";
        String str2=  "ee";
        String str3=new String  ("ee");

        String str4= str1;

        System.out.println("str1 equal str2"+ str1==str2);
        System.out.println("str1 equal str2"+ str1==str3);
        str1="ooo";
    }
}
