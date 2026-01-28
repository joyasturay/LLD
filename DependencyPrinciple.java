abstract class NotificationService {
    abstract public void register();
}

class Gmail extends NotificationService {
    @Override
    public void register() {
        System.out.println("sending mail .....");
    }
}
class whatsApp extends NotificationService {
    @Override
    public void register() {
        System.out.println("sending text .....");
    }
}
class userRegistration {
    NotificationService service;

    public userRegistration(NotificationService service) {
        this.service = service;
    }

    public void sendMessage() {
        service.register();
    }
}
public class DependencyPrinciple {
    public static void main(String[] args) {
        NotificationService service = new whatsApp();
        userRegistration registration = new userRegistration(service);
        registration.sendMessage();
    }
}
