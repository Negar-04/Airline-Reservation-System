public class Main {
    /**
     * <h2><span style="font-style:italic; color:#7B68EE">Airline reservation</h2>
     * <h3><span style="font-family:bradly hand; color:">E-mail : </span>
     * <span style="font-family:bradly hand; color:BDEBFF">negarsadegh1383@gmail.com</span>
     * @author <span style="font-family:bradly hand; color:#08A04B">Negar Sadeghian</span>
     * @since <span style="font-family:bradly hand ; color:#FFA400" >2023-04-21</span>
     */
    public static void main(String[] args) {
        Database database = new Database();
        Menu menu = new Menu();
        menu.startMenu(database);
    }
}