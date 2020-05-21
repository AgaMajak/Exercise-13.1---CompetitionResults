import logic.PlayerFileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            PlayerFileWriter.createPlayersListAndWriteToFile();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Podałeś niekompletne dane. Spróbuj ponownie");
        }

    }
}
