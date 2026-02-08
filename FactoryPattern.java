interface logistics {
    public void send();
}

class Air implements logistics {
    @Override
    public void send() {
        System.out.println("Sending by air");
    }
}

class Train implements logistics {
    @Override
    public void send() {
        System.out.println("Sending by train");
    }
}

class LogisticsFactory {
    public static logistics getLogistics(String mode) {
        if (mode == "air") {
            return new Air();
        }
        return new Train();
    }
}
class LogisticsService{
    public static void send(String mode) {
        logistics logi = LogisticsFactory.getLogistics(mode);
        logi.send();
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        LogisticsService.send("air");
    }
}
