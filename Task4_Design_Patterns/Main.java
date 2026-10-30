import java.util.ArrayList;
import java.util.List;

// TASK 4: DESIGN PATTERNS MINI PROJECT

// 1. SINGLETON DESIGN PATTERN
// Problem solved: Ensures only one Logger object is created.
class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor prevents outside object creation.
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

// 2. FACTORY DESIGN PATTERN
// Problem solved: Creates notification objects without
// exposing their creation details.

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        }
        return null;
    }
}

// 3. OBSERVER DESIGN PATTERN
// Problem solved: Notifies multiple observers when
// the subject's information changes.

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

class NewsAgency {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void publishNews(String news) {
        System.out.println("\nNews Published: " + news);

        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

// MAIN CLASS
public class Main {
    public static void main(String[] args) {

        System.out.println("===== DESIGN PATTERNS DEMO =====");

        // Demonstrating Singleton Pattern
        System.out.println("\n1. SINGLETON PATTERN");
        Logger logger = Logger.getInstance();
        logger.log("Application started");

        // Demonstrating Factory Pattern
        System.out.println("\n2. FACTORY PATTERN");
        Notification email =
                NotificationFactory.createNotification("email");
        Notification sms =
                NotificationFactory.createNotification("sms");

        if (email != null) {
            email.send("Welcome to our application!");
        }

        if (sms != null) {
            sms.send("Your verification code is 1234");
        }

        // Demonstrating Observer Pattern
        System.out.println("\n3. OBSERVER PATTERN");
        NewsAgency agency = new NewsAgency();

        agency.addObserver(new Subscriber("Subscriber 1"));
        agency.addObserver(new Subscriber("Subscriber 2"));

        agency.publishNews("Design Patterns are useful in Java!");

        System.out.println("\n===== DEMO COMPLETED =====");
    }
}
