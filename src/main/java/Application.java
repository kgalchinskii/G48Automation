import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger LOG = LogManager.getLogger("App");

    public static void main(String[] args) {

        A aEmpty = new A();
        B bEmpty = new B();
        A aFull = new A("aFull", 2);
        B bFull = new B("bFull", 2);
        aFull.printName();
        bFull.printName();
        aFull.move();
        LOG.info("Список ArrayList<>: " + aFull.testList);
        bFull.sortList(aFull.testList);
        aFull.splitList(null);
        bFull.splitList(aFull.testList);

    }

}
