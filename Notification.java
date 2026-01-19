interface NotificationChannel {
    public void send();
}
class Log{
   public static void ok(){
        System.out.println("all ok");
        System.out.println("[Log]: Notification sent at " + java.time.LocalDateTime.now());
    }
}

class Email implements NotificationChannel {
   private  String message;
    private String recipient;

    public Email(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    @Override
    public void send() {
        System.out.println("Connecting to SMTP server ....");
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}

class Sms implements NotificationChannel {
    private String message;
    private String recipient;

    public Sms(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    public void send() {
        System.out.println("Connecting to Telecom gateway...");
        System.out.println("📱 Sending SMS to " + recipient + ": " + message);
    }
}

class WhatsApp implements NotificationChannel {
    private String message;
    private String recipient;

    public WhatsApp(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    public void send() {
         System.out.println("Connecting to WhatsApp gateway...");
        System.out.println("📱 Sending message to " + recipient + ": " + message);
    }
}

class NotificationFactory {
    public static NotificationChannel createNotification(String type, String message, String recipient) {
         if(type.equalsIgnoreCase("email")){
             return  new Email(message,recipient);
        }
        else {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
class Notification{
    public void sendNotification(String type,String message,String recipient){
        NotificationChannel channel = NotificationFactory.createNotification(type, message, recipient);
        channel.send();
        Log.ok();
    }
    public static void main(String args[]){
        Notification notification=new Notification();
        notification.sendNotification("email","hello joy","joy");
    }
}