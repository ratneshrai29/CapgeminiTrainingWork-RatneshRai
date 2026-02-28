import java.util.ArrayList;
import java.util.List;


@FunctionalInterface
interface Calc{
    int add(int a, int b);              // public by default only one abstarct method
    // Default method
    // static method
}

interface Calci{
    int sum(int a, int b);
}

class MyCalc implements Calc{
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}

interface Consumer{
    public void accept(Object ob);
}
public class Lambdademo {
    public static void main(String[] args) {
//        Calc c1 = new Calc();          // Error
          Calc c1 = new MyCalc();
          int sum = c1.add(6,5);
        System.out.println(sum);
              class Mycalc2 implements Calc{    // Inner class
                  // Static inner class - do not have access to outer object
                  // Non-static inner class - have access to outer object
                  @Override
                  public int add(int a, int b) {
                      return a+b;
                  }
              }

             // System will create a class Lamdademo$1 Anonymous class
              Calc c2 = new Calc(){
                  @Override
                  public int add(int a, int b) {
                      return a+b;
                  }
              };
              int sum2 = c2.add(5,51);
        System.out.println(sum2);


          Calc c3 = new Mycalc2();
          int sum3 = c3.add(4,5);
        System.out.println(sum3);

            Calc c4 =(int a, int b) -> {return a+b;};
            Calc c5 = (a,b) -> {return a+b;};
            Calc c6 =(a,b) -> a + b ;


            List<Employees> list = new ArrayList<>();
            list.add(new Employees(29,"Ratnesh"));
            list.add(new Employees(101,"Aman"));
            list.add(new Employees(229,"Ayush"));
            list.add(new Employees(679,"Sanya"));
            list.add(new Employees(909,"Rashi"));
//        Comparator<Employee> comp= new Comparator<Employee>(){
//            @Override
//            public int compare(Employee o1, Employee o2) {
////                if(o1.empid > o2.empid) return  1;
////                if(o1.empid < o2.empid) return  -1;
////                return 0;
//
//                return o1.empid - o2.empid;
//            }
//        };



//        list.sort(comp);
//        list.sort(new Comparator<Employee>() {}); // using Anonymous class
//        list.sort((e1,e2) -> e1.empid-e2.empid);
        list.sort((e1,e2)->e1.name.compareTo(e2.name));
        System.out.println(list);

//          List<Integer> list = new ArrayList<>();  // Better
//          ArrayList<Integer> list2 = new ArrayList<>();



        // METHOD REFERENCES
        Calci calci = (a,b) -> a+b;
        Calc calc = (a,b) -> a+b;

        calc = calci::sum;
        Consumer consumer = System.out::println;
        consumer.accept("Hello all this is consumer");



    }
}
