package exam;

public class Demo {
    private static volatile Demo instance ;

    private Demo() {}

    public static Demo getInstance() {
        if (instance == null) {
            synchronized (Demo.class) {
                if (instance ==null ) {
                    instance = new Demo();
                }
            }
        }
        return instance;
    }


}
