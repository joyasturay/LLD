import java.util.*;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic burger prep");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premium burger prep");
    }
}

class BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equals("Basic")) {
            return new BasicBurger();
        }
        if (type.equals("Premium")) {
            return new PremiumBurger();
        }
        return null;
        }
    }
public class FactoryDesign {
    public static void main(String[] args) {
        String type = "Premium";
        BurgerFactory bgFactory = new BurgerFactory();
        Burger burger = bgFactory.createBurger(type);
        burger.prepare();
    }
}
