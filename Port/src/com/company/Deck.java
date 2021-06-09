package com.company;

import java.util.Scanner;

public class Deck {

    private boolean isEmpty;
    private boolean isBigContainer = false;
    private int countOfContainer = 0;
    private int choose;

    public Deck(int numbOfDeck){
        String numb = (numbOfDeck==1) ? "первую" : "вторую";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заполнить " + numb + " палубу?" +
                            "\n\t1. Да" +
                            "\n\t2. Нет");
        choose = scanner.nextInt();
        if(choose == 1){
            isEmpty = false;
            System.out.println("Какой контеинер загрузить?"+
                                "\n\t1. Один большой"+
                                "\n\t2. Один маленький"+
                                "\n\t3. Два маленьких");
            choose = scanner.nextInt();
            if(choose == 1){
                isBigContainer = true;
                countOfContainer = 1;
            }else if(choose == 2){
                isBigContainer = false;
                countOfContainer = 1;
            }else if(choose == 3){
                isBigContainer = false;
                countOfContainer = 2;
            }
        }else {
            isEmpty = true;
        }
    }

    public boolean getIsEmpty(){
        return isEmpty;
    }
    public boolean getIsBigContainer(){
        return isBigContainer;
    }
    public int getCountOfContainer(){
        return countOfContainer;
    }
}
