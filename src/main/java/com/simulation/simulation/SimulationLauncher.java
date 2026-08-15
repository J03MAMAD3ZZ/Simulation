package com.simulation.simulation;

import com.simulation.config.FieldPreset;
import com.simulation.config.SimulationConfig;

import java.util.List;
import java.util.Scanner;


public class SimulationLauncher {
    private final Scanner scanner;

    public SimulationLauncher(Scanner scanner) {
        this.scanner = scanner;
    }

    public void launch() {
        welcomeMessage();
        SimulationConfig config = selectConfig();
        Simulation simulation = new Simulation(config);
        simulation.startSimulation(config);
    }

    public SimulationConfig selectConfig() {
        FieldPreset[] presets = FieldPreset.values();

        System.out.println("=== Chose the map size ===");
        for (FieldPreset f : presets) {
            System.out.println(f.ordinal() + 1 + ". " + f.name());
        }
        System.out.print("Enter the number: ");

        int choice = readChoice(presets.length);
        FieldPreset selected = presets[choice - 1];
        return SimulationConfig.fromPreset(selected);
    }


    private int readChoice(int maxOption) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= maxOption) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.printf("Enter the number from 1 to %d: ", maxOption);
        }
    }

    private void welcomeMessage() {
        System.out.println("""
                
                                                    ==WELCOME TO SIMULATION!==
                
                This is a turn-based simulation of the real world, where 🐺 predators hunt 🦌 herbivores, who feed on 🌱 grass.
                """);
    }
}
