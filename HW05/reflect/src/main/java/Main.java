import myframework.RunTest;
import ru.otus.test.MyTest;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("run Test for classes: ");
        RunTest.runTest(MyTest.class);

        System.out.println("run Test for classes in package: ");
        RunTest.findPackage("ru.otus.test");
    }
}
