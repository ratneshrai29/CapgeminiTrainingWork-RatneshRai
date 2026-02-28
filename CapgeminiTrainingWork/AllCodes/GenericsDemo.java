class stackgeneral<T>{
    Object [] a = new Object[10];
    int top =-1;
    public void push(T x){
        a[++top] = x;

    }
    T pop(){
        return (T) a[top--];
    }
}


public class GenericsDemo {
    public static void main(String[] args) {
        stackgeneral<Integer> s1 = new stackgeneral<>();
        s1.push(34);
        s1.push(54);
        s1.push(28);
        stackgeneral<String> s2 = new stackgeneral<>();
        s2.push("Aman");
        s2.push("Rashi");
        s2.push("Ayush");
    }
}
