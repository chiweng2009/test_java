/**
 * Created by liuchong on 2017/4/25.
 */
public class TestHashCode {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            String swno = new String("EInvoice000000000001");
            System.out.println(swno.hashCode());
        }
    }
}
