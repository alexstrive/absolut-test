import com.alexstrive.Product;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testMain() {
        var p1 = new Product("тесто");
        var p2 = new Product("Мука");
        var p3 = new Product("Яйца");
        var p4 = new Product("Вода");
        var p5 = new Product("Пшеница");
        var p6 = new Product("Пшеница композит");
        var p7 = new Product("Пшеница композит 2");

        assert !p1.addProduct(p1);
        assert !p1.addProduct(null);

        assert p1.addProduct(p2); // p1 -> p2
        assert p1.addProduct(p3); // p1 -> p2 + p3
        assert p1.addProduct(p4); // p1 -> p2 + p3 + p4
        assert !p2.addProduct(p1);
        assert p2.addProduct(p5); // p2 -> p5
        assert !p5.addProduct(p1);

        // result
        // p1 -> (p2 -> p5) + p3 + p4
        assert p5.addProduct(p6);
        assert p6.addProduct(p7);
        assert !p7.addProduct(p1);
    }
}
