import java.util.ArrayList;
import java.util.List;

public class StringTask{
    // Question 1
    public static void pos(String str, String word){
        str = str.toLowerCase();
        int index = str.indexOf(word);
        while(index != -1){
            System.out.println("Found at index : "+index);
            index = str.indexOf(word,index+word.length());
        }
    }

    public static void main(String[] args) {
        String str1 = "this is line. Line contains few words. Line is in java";
        pos(str1,"line");

        //Question 3
        String str = "This is java lang";
        String [] words = str.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        System.out.println(sb.toString().trim());

        // Question 2
        String[] inputs = {
                "12-4-1978",
                "21.4.2001",
                "5-6-99",
                "04-11-01"
        };

        for (String input : inputs) {
            System.out.println(formatDate(input));
        }
    }

    public static String formatDate(String input) {

        input = input.replace('.', '-');

        String[] parts = input.split("-");

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        if (day.length() == 1)
            day = "0" + day;

        if (month.length() == 1)
            month = "0" + month;


        if (year.length() == 2) {
            year = "19" + year;   // assume 1900s
        }

        return day + month + year;
    }
}
