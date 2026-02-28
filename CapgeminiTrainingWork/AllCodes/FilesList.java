import java.io.File;
public class FilesList {
    public static void main(String[] args) {
        File files = new File("src/CopyFile.java"); // about the information of file not data
        System.out.println("exists "+ files.exists());
        System.out.println("isfile "+files.isFile());
        System.out.println("isDir"+ files.isDirectory());
        System.out.println("length "+ files.length());
        System.out.println("can read "+files.canRead());
        System.out.println(files.getAbsoluteFile());
        System.out.println(files.getParentFile());

        File dir = new File(".");
        System.out.println(dir.getName());
        System.out.println(dir.exists());
        System.out.println(dir.isDirectory());
        String [] list = dir.list();
        for(String name : list){
            System.out.println(name);
        }

        File newDir = new File("c:/galgotias");
                if(! newDir.exists())
                    try{
                        boolean cretaed = newDir.mkdir();
                        System.out.println("Dir created "+cretaed);
                    } catch (SecurityException e){
                        System.out.println("Can not create dir");
                    }
    }
}
