package testReturn;

/**
 * Created by liuchong on 2017/5/12.
 */
public class TestReturn {

    public static void main(String[] args) {

        System.out.println(" ++++ " + init());
        System.out.println(" ++++ " + init1());
    }

    static int init() {
        int m = 1;
        try {
            return m;
        } finally {
            m = 2;
            System.out.println(" ==== " + m);
            //return m;
        }
    }

    static Bean init1() {
        Bean b = new Bean(1, "0000");
        try {
            return b;
        } finally {
            b = new Bean(5, "$%^&*()_");
            System.out.println(" ==== " + b);
            //return b;
        }
    }

}

class Bean {
    int age;
    String name;

    public Bean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Bean bean = (Bean) o;

        if (age != bean.age) {
            return false;
        }
        return name != null ? name.equals(bean.name) : bean.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
