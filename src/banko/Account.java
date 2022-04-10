package banko;

public class Account {

    private String firstName, middleInitial, lastName;
    private int money, pinCode;

    public Account(){

    }
    public Account(String firstName, String middleInitial, String lastName){

        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMoney() {
        return money;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int withdraw(int amount){
        int w = this.money - amount;
        setMoney(w);
        return getMoney();
    }
    public int deposit(int amount){
        int d = this.money + amount;
        setMoney(d);
        return getMoney();
    }

    public String toString(){
        return "Account name is " +getFirstName() +" "+ getMiddleInitial() + " " + getLastName() + "\n" + "The Acount Balance is " + this.money;
    }


}
