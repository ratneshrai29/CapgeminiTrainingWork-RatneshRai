// Two method to create thread in java
// One extend the Thread class
// Second implements the Runnable interface


//class Base{}
//class Derived extends Base{}
//Base b = new Base();
//Derived d = new Derived();
//Base = Derived;  Correct
//Derived = Base;  Incorrect
class ChildThread extends Thread{
    public ChildThread(ThreadGroup group){
        super(group,"dummy");
    }
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Child : "+thread);
        for(int i=1;i<=100;i++){
            System.out.println("Child : "+i);
        }
    }
}
class ChildThread2 implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Child2 : "+thread);
        for(int i=1;i<=100;i++){
            System.out.println("Child2 : "+i);
        }
    }
}
public class ThreadingBasic {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Main : "+thread);
        ThreadGroup group = new ThreadGroup("DB Thread");
        ChildThread t = new ChildThread(group);
        t.setName("ChildThread");
        t.setPriority(1);
        t.start();  // Will execute run in thread and return at the same time
        ChildThread2 obj = new ChildThread2();
        Thread t2 = new Thread(group, obj);
        t2.setName("ChildThread2");
        t2.setPriority(10);
        t2.start();
//        for(int i =1; i<5;i++){
//            ChildThread t3 =  new ChildThread();
//            t3.start();
//        }
        for(int i=1;i<=100;i++){
            System.out.println("Main: "+i);
        }


        Runnable obj1 = () ->{
            for(int i =0;i<=100;i++){
                System.out.println("Runnable : "+i);
            }
        };
        new Thread(obj1).start();
    }
}
