package org.example.Simplefactory;

// interface (package-private)
interface Notification {
    void send();
}

// class 1
class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Email Notification");
    }
}

// class 2
class SmsNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sms Notification");
    }
}

// factory class
class NotificationFactory {
    public static Notification create(String type) {
        if (type.equalsIgnoreCase("Email")) {
            return new EmailNotification();
        }
        if (type.equalsIgnoreCase("Sms")) {
            return new SmsNotification();
        }
        throw new IllegalArgumentException("Invalid type");
    }
}

// ONLY public class
public class SimpleFactory {
    public static void main(String[] args) {
        Notification n = NotificationFactory.create("Email");
        n.send();
    }
}
