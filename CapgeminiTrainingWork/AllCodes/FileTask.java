import java.util.*;
import java.io.*;
public class FileTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dirname = sc.nextLine();
        File dir = new File(dirname);
        if(dir.exists()){
            System.out.println("All Java file");
            String [] content = dir.list();
            HashMap<String, Long> map = new HashMap<>();
            for(String name : content){
                if( name.endsWith(".java")){
                    File javafile = new File(dir,name);
                    long size = javafile.length();
                    map.put(name,size);
                }
            }
            List<Map.Entry<String, Long>> list = new ArrayList<>(map.entrySet());

            // Sort in descending order by size
            list.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));

            // Print sorted result
            for (Map.Entry<String, Long> entry : list) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " bytes");
            }

        } else {
            System.out.println("Directory does not exist.");
        }
        sc.close();
        }
    }
