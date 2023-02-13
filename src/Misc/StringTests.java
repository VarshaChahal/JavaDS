package Misc;

public class StringTests {
    
    public static void main(String args[]){
        String str = new String("heythere");
        System.out.println(Integer.valueOf(str.valueOf("e")) instanceof Integer );
        char[] arr = str.toCharArray();
        ;
        for(char c:arr){
            System.out.println(c);
        }

        str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
      //  Character[] charArr = str.toCharArray();
    }
}
