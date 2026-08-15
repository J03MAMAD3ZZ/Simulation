package com.simulation;


import com.simulation.simulation.SimulationLauncher;
import java.util.Scanner;


public class Main {
    SimulationLauncher launcher = new SimulationLauncher(new Scanner(System.in));

    void main() {
        launcher.launch();
    }
}
