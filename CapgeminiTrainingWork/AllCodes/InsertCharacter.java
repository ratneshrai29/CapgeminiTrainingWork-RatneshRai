import java.util.*;
public class InsertCharacter{
    public static void insertAt(StringBuilder str, int pos, char ch){
        str.insert(pos,ch);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.print("Enter position to insert: ");
        int pos = sc.nextInt();

        System.out.print("Enter character to insert: ");
        char ch = sc.next().charAt(0);

        StringBuilder str = new StringBuilder(input);
        insertAt(str,pos,ch);

        System.out.print("Final string is: "+ str);
    }
}