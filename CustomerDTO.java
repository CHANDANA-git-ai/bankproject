package bank;

/*
 * DTO (Data Transfer Object)
 * Used to transfer customer data between layers
 */
public class CustomerDTO {

    // Customer properties
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String city;
    private double balance;
    private String status;

    // Default constructor
    public CustomerDTO() {}

    // Constructor used while creating a new account
    public CustomerDTO(String name, String email, String mobile, String city, double balance) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
        this.balance = balance;
        this.status = "ACTIVE";
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getCity() { return city; }
    public double getBalance() { return balance; }
    public String getStatus() { return status; }

    // Setters (used during update)
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setCity(String city) { this.city = city; }
}
