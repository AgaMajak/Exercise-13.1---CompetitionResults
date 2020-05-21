package data;

public class Player implements Comparable<Player> {
    private final String firstName;
    private final String lastName;
    private final int result;

    public Player(String firstName, String lastName, int result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("Gracz: %s %s, wynik: %d\n", firstName, lastName, result);
    }

    @Override
    public int compareTo(Player player) {
        return Double.compare(this.result, player.result);
    }
}
