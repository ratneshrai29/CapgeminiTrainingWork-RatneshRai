import java.util.ArrayList;
import java.util.List;

class Downloader extends Thread{
    String image;
    public Downloader(String image){
        this.image = image;
    }

/*
    public void run(){
        this.download(image);
    }
*/

    public void run(){               // Also download method --> download(String image)
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Downloading "+image);
    }
}
public class ImageDownloader {
    public static void main(String[] args) throws InterruptedException {
        String[] images = {"image1", "image2", "image3"};
        List<Thread> list =  new ArrayList<Thread>();
        for(int i=0;i<images.length;i++){
            Downloader loader = new Downloader(images[i]);
            list.add(loader);
            loader.start();
//          loader.join(); //Let it finish, main will wait till loader thread finishes
        }
        for(Thread t: list){
            t.join();  //Let it finish, main will wait till loader thread finishes
        }
        System.out.println("All Images downloaded");
    }
}
