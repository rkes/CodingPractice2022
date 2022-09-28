public class Test2 {

    public static void main(String[] args) {
        int []ar={};
        System.out.println('a'+'b');
    }

    static class VoteClass{

    }
    static class TempClass {

    }
    static class class2 implements Runnable{
        TempClass object1 ;
        TempClass object2 ;
        public class2(TempClass object1,TempClass object2){
            this.object1=object1;
            this.object2 = object2;

        }
        @Override
        public void run() {
            synchronized (object2){
                System.out.println("class2 outer");
                synchronized (object1){
                    System.out.println("class2 inner");
                }
            }
        }
    }
    static class class1 implements Runnable{
        TempClass object1 ;
        TempClass object2 ;
        public class1(TempClass object1,TempClass object2){
            this.object1=object1;
            this.object2 = object2;

        }
        @Override
        public void run() {
            synchronized (object1){
                System.out.println("class 1 outer");
                synchronized (object2){
                    System.out.println("class 1 inner");
                }
            }
        }
    }
}
