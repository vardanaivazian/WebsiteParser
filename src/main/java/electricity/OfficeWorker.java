package electricity;

import core.EmailManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 7:05 PM
 */
public class OfficeWorker implements Observer {

    private String firstName;
    private String lastName;
    private String email;
    private List<String> streets;

    public OfficeWorker() {
        this.streets = new ArrayList<>();
    }

    public OfficeWorker(String firstName, String lastName, String email, List<String> streets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streets = streets;
    }

    public OfficeWorker(String firstName, String lastName, String email, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streets = new ArrayList<>();
        this.streets.add(street);
    }


    public List<String> getStreets() {
        return this.streets;
    }

    public void update(String street, String time) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("send email: street: " + street + ", time: " + time);
        System.out.println(this.toString());
        System.out.println("-------------------------------------------------------------------------");

        EmailManager emailManager = new EmailManager();

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        Date tomorrow = c.getTime();

        emailManager.sendEmail(this.email, "Power cuts at " + tomorrow, "Electricity will turn off on the st. " + street + ", at " + time);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getStreet() {
        return streets;
    }

    public void setStreet(List<String> streets) {
        this.streets = streets;
    }

    @Override
    public String toString() {
        return "OfficeWorker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", streets=" + streets +
                '}';
    }
}
