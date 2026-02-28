class Printer{
    // Synchronized
    public void print(String msg) throws InterruptedException{
        System.out.print("[");
        Thread.sleep(1000);
        System.out.print(msg);
        System.out.print("]");
    }
}
class Writer extends Thread{
    final Printer printer;
    String msg;

    public Writer(Printer printer, String msg){
        super();
        this.printer = printer;
        this.msg = msg;
    }
    @Override
    public void run() {
        try{
            synchronized (printer) {
                printer.print(msg);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class SynchDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Writer w1 = new Writer(printer,"Java");
        Writer w2 = new Writer(printer,"Threads");
        w1.start();
        w2.start();
    }
}
