public class Passengers {
    Passenger[] information;
    public Passengers() {
        this.information =  new Passenger[1000];
    }

    public void changePassword(int j, String newPass){
        information[j].setPassword(newPass);
    }
    public void addCharge(int k , String price){
        int preCharge = Integer.parseInt(information[k].getCredit());
        int newPrice = Integer.parseInt(price);
        int sum = preCharge + newPrice;
        information[k].setCredit(String.valueOf(sum));
    }
}
