package bank;

/*
 * DTO class
 * Used to transfer customer data between layers
 * Contains only variables, constructors, getters and setters
 */
public class Customer {

    // Instance variables representing table columns
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String city;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(int id, String name, String email, String mobile, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
    }

    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getCity() { return city; }

    // Setter methods
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setCity(String city) { this.city = city; }
}
