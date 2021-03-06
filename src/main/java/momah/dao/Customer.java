package momah.dao;

import momah.Utils.CustomerHelperValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer implements IEntity {
    @Id
    @GeneratedValue
    private  long customerId;
    private String email;
    private String firstName;
    private String lastname;
    private int age;

    public Customer(){
        init();
    };

    public Customer(String email, String firstName, String lastname, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public void init() {
        setEmail("");
        setFirstName("");
        setLastname("");
        setAge(CustomerHelperValidator.AGE_DEFAULT);
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (age != customer.age) return false;
        if (!email.equals(customer.email)) return false;
        if (!firstName.equals(customer.firstName)) return false;
        return lastname.equals(customer.lastname);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("customerId=").append(customerId);
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


}
