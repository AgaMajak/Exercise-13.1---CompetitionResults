package logic;

import data.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayerFileWriter {
    private static final String STOP = "stop";

    private static void writePlayerListToFile(List<Player> players, File file) {
        FileCreator.createFile(file);
        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            for (Player player : players) {
                writer.write(player.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + file);
        }
    }


    public static void createPlayersListAndWriteToFile() {
        List<Player> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < 1) {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            String line = scan.nextLine();
            if (line.equalsIgnoreCase(STOP)) {
                System.out.println("Dane posortowano i zapisano do pliku stats.csv.");
                i++;
                break;
            }
            String[] elements = line.split(" ");
            String firstName = elements[0];
            String lastName = elements[1];
            String result = elements[2];
            int parseResult = Integer.parseInt(result);
            players.add(new Player(firstName, lastName, parseResult));
        }
        Collections.sort(players);
        String fileName = "stats.csv";
        File file = new File(fileName);

        writePlayerListToFile(players, file);
    }


}
