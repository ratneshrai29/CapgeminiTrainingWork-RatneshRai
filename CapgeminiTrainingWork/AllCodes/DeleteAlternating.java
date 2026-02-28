import java.util.*;
public class DeleteAlternating{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        String result = "";
        for(int i =0;i<str.length();i++){
            if(i%2 == 0){
                result += str.charAt(i);
            }
        }
        System.out.println("New String: "+result);
    }
}
