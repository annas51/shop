package pl.britenet.campus.object;

public class Customer {
    private final int CustomerId;
    private String Name;
    private String Last_name;
    private String Address;
    private String Phone_nr;
    private int CartId;





    public Customer(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_nr() {
        return Phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        Phone_nr = phone_nr;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

}
