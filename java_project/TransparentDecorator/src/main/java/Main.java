import changes.Bird;
import changes.Fish;
import king.TheMonkeyKing;
import monkey.Monkey;

public class Main {
    public static void main(String[] args) {

        TheMonkeyKing sage = new Monkey();
        // 第一种写法
        // 第二种写法
        TheMonkeyKing fish = new Fish(new Bird(sage));

        TheMonkeyKing bird = new Bird(new Bird(new Fish(sage)));
        //fish.move();

        System.out.println();
        bird.move();

    }
}