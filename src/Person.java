/**
 * Created by WesleyLewis on 9/12/16.
 */
public class Person implements Comparable{
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String ipAddress;

    public Person(){

    }

    public Person(String country, String lastName, String firstName, String email, String ipAddress, String id) {
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ipAddress = ipAddress;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return String.format("%s, %s From %s \n", lastName, firstName, country );
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return lastName.compareTo(p.lastName);
     }
}

