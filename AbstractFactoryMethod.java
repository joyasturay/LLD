import java.util.*;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing basic burger");
    }
}

class BasicPremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premium burger preapre");
    }
}

class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic wheat burger");
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premium wheat burger");
    }
}

interface GarlicBread {
    void prepare();
}

class BasicGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Basic garlic bread");
    }
}

class PremiumGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Premium garlic bread");
    }
}

class BasicWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Basic Wheat garlic bread");
    }
}

class PremiumWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Premium wheat garlic bread");
    }
}

interface FactoryObjectCreate {
    Burger createBurger(String type);

   GarlicBread createGarlicBread(String type);
}

class SinghBurger implements FactoryObjectCreate {
    @Override
    public Burger createBurger(String type) {
        if (type.equals("Basic")) {
            return new BasicBurger();
        }
        if (type.equals("Premium")) {
            return new BasicPremiumBurger();
        }
        return null;
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if (type.equals("Basic")) {
            return new BasicGarlicBread();
        }
        if (type.equals("Premium")) {
            return new PremiumGarlicBread();
        }
        throw new IllegalArgumentException("Invalid type");
    }
}

class kingburger implements FactoryObjectCreate {
    @Override
    public Burger createBurger(String type) {
        if (type.equals("Basic")) {
            return new BasicWheatBurger();
        }
        if (type.equals("Premium")) {
            return new PremiumWheatBurger();
        }
        throw new IllegalArgumentException("Invalid type");
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if (type.equals("Basic")) {
            return new BasicWheatGarlicBread();
        }
        if (type.equals("Premium")) {
            return new PremiumWheatGarlicBread();
        }
         throw new IllegalArgumentException("Invalid type");
    }
}

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        String type = "Premium";
        FactoryObjectCreate factory = new SinghBurger();
        Burger burger = factory.createBurger(type);
        GarlicBread bread = factory.createGarlicBread(type);
        burger.prepare();
        bread.prepare();
    }
}
