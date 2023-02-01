package Lab10_Observer;

public class Main {

    public static void main(String[] args) {
        // Create investors
        User s = new User("Ahmet");
        User b = new User("Ayse");
        User a = new User("İdil");
        User d = new User("Sarp");
        User f = new User("Erdem");

        // Create a controller and attach users
        AbstractController controller = new Controller("BOSCH", 29);
//        s.setController(controller);
//        b.setController(controller);
        controller.Attach(s);
        controller.Attach(b);
        controller.Attach(a);
        controller.Attach(d);
        controller.Attach(f);

        s.setController(controller);
        s.setController_temperature(24);
        s.setController_temperature(26);
        s.setController_temperature(25);
        s.setController_temperature(28);

        b.setController_temperature(23);
        b.setController_temperature(25);
        b.setController_temperature(27);
        b.setController_temperature(29);

        a.setController_temperature(22);
        a.setController_temperature(24);
        a.setController_temperature(25);
        a.setController_temperature(22);

        d.setController_temperature(23);
        d.setController_temperature(26);
        d.setController_temperature(23);
        d.setController_temperature(27);

        f.setController_temperature(24);
        f.setController_temperature(26);
        f.setController_temperature(25);
        f.setController_temperature(28);



        // Change temperature, which notifies users
//        controller.setTemperature(28);
//        controller.setTemperature(27);
//        controller.setTemperature(29);
//        controller.setTemperature(26);


        System.out.println("Removing Ayse from Notification list");
        controller.Detach(b);
//        controller.setTemperature(28);
//        controller.setTemperature(26);
//        controller.setTemperature(25);
//        controller.setTemperature(24);
        controller = null; // Candidate for Garbage Collection  // DANGER !!!!!!!
        // We have a dangling reference in our Observer. Remember our
        // "implementation issues" discussion in the lecture.
        //s.UserUpdate(20);
        System.out.println(s.getController()); // Reference has a value.

    }
}
