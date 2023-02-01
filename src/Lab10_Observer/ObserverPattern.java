package Lab10_Observer;

import java.util.ArrayList;

//'Subject' ==> Controller
abstract class AbstractController {
    protected String name;          // Internal Subject state
    protected double temperature;      // Internal Subject state
    protected ArrayList<User> users = new ArrayList<User>();

    public AbstractController(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    //Register the Observers
    public void Attach(User user) {
        users.add(user);
    }

    //Unregister from the list of Observers.
    public void Detach(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(user.getName())) {
                users.remove(i);
                return;
            }
        }
    }

    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        for (User user : users) {
            user.Update(this);
        }
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return 0;
    }

    abstract public void setTemperature(double value);


}

//'ConcreteSubject' ==> IBM

class Controller extends AbstractController {
    // Constructor
    public Controller(String name, double temperature) {
        super(name, temperature);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double value) {
        // Whenever a change happens to temperature, notify observers.
        temperature = value;
        //Notify();
    }
}

//'Observer'  ==> Abstract Observer.

interface Observer {
    void Update(AbstractController controller);
}

class Counter {
    public static int getUpdateCounter() {
        return updateCounter;
    }

    private static int updateCounter;

    void increaseCounter() {
        updateCounter++;
    }
}
//'ConcreteObserver' ==> Investor

class User implements Observer {
    private AbstractController _controller;
    private String user_name;
    private String controller_name;     // Internal Observer state
    private double controller_temperature;    // Internal Observer state
    private Counter counter;

    // Constructor
    public User(String name) {
        user_name = name;
        counter = new Counter();
    }

    public void Update(AbstractController controller) {
        _controller = controller;                 // Reference to Subject
        controller_temperature = controller.getTemperature();
        controller_name = controller.getName();
        counter.increaseCounter();
        System.out.println("Notified " + user_name + " of " + controller_name +
                "'s " + "change to " + controller_temperature + " (Update is called "
                + Counter.getUpdateCounter() + " times)");
    }

    public AbstractController getController() {
        return _controller;
    }

    public void setController(AbstractController controller) {
        _controller = controller;
    }

    public String getName() {
        return user_name;
    }

    private static int setTempCounter = 0;
    public void setController_temperature(double controller_temperature) {
        _controller.setTemperature(controller_temperature);
        System.out.println("User " + user_name + " is changing temperature to " + controller_temperature);
        setTempCounter++;
        if (setTempCounter == 4) {
            _controller.Notify();
            setTempCounter = 0;
        }
    }
}

