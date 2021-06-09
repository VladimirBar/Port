package com.company;
import java.awt.*;
import java.util.Scanner;

public class Ship {

    private Deck firstDeck;
    private Deck secondDeck;
    private String name;

    public Ship(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nПридумайте название кораблю:");
        name = scanner.nextLine();
        firstDeck = new Deck(1);
        secondDeck = new Deck(2);
    }

    public String getName(){
        return this.name;
    }
    public Deck getFirstDeck(){
        return this.firstDeck;
    }
    public Deck getSecondDeck(){
        return this.secondDeck;
    }
}
