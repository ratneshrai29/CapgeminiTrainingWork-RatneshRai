//class PictureFormatException extends Exception
//{
//
//}
//public class ExceptionDemo {
//    public static void main(String[] args) {
//        int a;
//    }
//    public static void uploadPic(){
//        try{
//            System.out.println("Upload pic");
//            if(){
//                new PictureFormatException();
//            }
//            // ..... There should be different catch block for different exception and then there should general exception block
//        }
//        catch(PictureFormatException e){
//            System.out.println("Size or format are correct");
//        }
//        catch (Exception e){
//            System.out.println();
//        }
//    }
//}

public class ExceptionDemo {
    public static void main(String[] args) {

    }
    int[] a;
    int top;

    void push(int x) {
        if (top == a.length - 1) {
            System.out.println("Overflow");
            return;
        }
    }

    int pop() throws Exception {
        if (top == -1) {
            System.out.println("Underflow");
//                return 0: // I want to inform about underflow
            Exception e = new Exception("Underflow");
            throw e;
        } else {
            return a[top--];
        }
    }
}

