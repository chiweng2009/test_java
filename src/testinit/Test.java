package testinit;

/**
 * Created by liuchong on 2017/4/19.
 */
public class Test {
    private static class Instance {
        public static Test t = new Test();
    }

    public static Test getInstance() {
        return Instance.t;
    }

    public static void main(String[] args) {

        Test tt = Test.getInstance();
        Test t = new Test();
        System.out.println(t == tt);
    }
}
