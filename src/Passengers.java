public class Passengers {
    Passenger[] information;

    public Passengers() {
        this.information = new Passenger[1000];
    }

    /** fix information
     * @param j       the related index of each user in the array of passengers
     * @param newPass : replace it in passengers' array
     */
    public void changePassword(int j, String newPass) {

        information[j].setPassword(newPass);

    }

    /** fix information
     * @param j     the related index of each user in the array of passengers
     * @param price : increase it to previous charge and set it in passengers' array
     */
    public void addCharge(int j, String price) {

        int preCharge = Integer.parseInt(information[j].getCredit());
        int newPrice = Integer.parseInt(price);
        int sum = preCharge + newPrice;

        information[j].setCredit(String.valueOf(sum));
    }
}
