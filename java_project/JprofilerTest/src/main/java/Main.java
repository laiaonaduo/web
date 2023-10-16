import test.TestBean;
import test.TestMain;

public class Main {
    public static void main(String[] args) {



        while(true) {
            int i=0;
            while(i<=1000) {
                i++;
                TestBean b = new TestBean();
                TestMain.list.add(b);

            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }






    }
}