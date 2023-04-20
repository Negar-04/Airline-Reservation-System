public class Passengers {
    Passenger[] information;
    public Passengers() {
        this.information =  new Passenger[1000];
    }

    public void changePassword(int j, String newPass){

        information[j].setPassword(newPass);

    }
    public void addCharge(int j , String price){
        int preCharge = Integer.parseInt(information[j].getCredit());
        int newPrice = Integer.parseInt(price);
        int sum = preCharge + newPrice;
        information[j].setCredit(String.valueOf(sum));
    }
}
