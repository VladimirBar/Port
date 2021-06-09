package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Port {

    private static final int MAX_COUNT_OF_SHIPS = 10;
    private static int countOfWaterInPort=0;
    private static int countOfShips = 0;
    private static int countOfShipsInPort = 0;
    private static ArrayList<Ship> listOfShips = new ArrayList<>();
    private static ArrayList<Ship> listOfShipsInPort = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Port(){
        Menu();
    }

    public void Menu(){
        boolean isCorrect=false;
        System.out.println("\n Меню:" +
                        "\n\t1. Посмотреть сколько воды в порту"+
                        "\n\t2. Посмотреть список кораблей в порту"+
                        "\n\t3. Удалить корабль из порта (вода остаётся в порту)"+
                        "\n\t4. Создать корабль -> наполнить контейнерами с водой"+
                        "\n\t5. Посмотреть список кораблей, ожидающих прибытя в порт"+
                        "\n\t6. Загрузить корабль в порт"+
                        "\n\t7. Выйти из программы");
        int choose = scanner.nextInt();
        while(!isCorrect){
            if(choose > 0 && choose < 8){
                isCorrect = true;
            }
            else{
                System.out.println("Некорректный ввод, попробуйте еще раз\n");
                choose = scanner.nextInt();
            }
        }
        Choose(choose);
    }

    public void Choose(int choose){
        if(choose==1){
            printCountOfWaterInPort();
        }else if(choose==2){
            showListOfShipInPort();
        }else if(choose==3){
            removeShipFromPort();
        }else if(choose==4){
            createNewShip();
        }else if(choose==5){
            showListOfShip();
        }else if(choose==6){
            uploadShipInPort();
        }else if(choose==7){
            System.exit(0);
        }
    }

    public void printCountOfWaterInPort(){
        System.out.println("\nКоличество воды в порту: " + countOfWaterInPort + " литров");
        Menu();
    }

    public void showListOfShipInPort(){
        if(countOfShipsInPort==0){
            System.out.println("\nСписок пустой");
            Menu();
        }else{
            System.out.println("\n Список кораблей в порту:");
            for(int i = 1; i <= countOfShipsInPort; i++){
                System.out.println("\t Корабль №" + i + ": " + listOfShipsInPort.get(i-1).getName());
            }
            Menu();
        }
    }

    public void showListOfShip(){
        if(countOfShips==0){
            System.out.println("\nСписок пустой");
            Menu();
        }else{
            System.out.println("\n Список кораблей:");
            for(int i = 1; i <= countOfShips; i++){
                System.out.println("\t Корабль №" + i + ": " + listOfShips.get(i-1).getName());
            }
            Menu();
        }
    }

    public void uploadShipInPort(){
        if(countOfShipsInPort<MAX_COUNT_OF_SHIPS){
            boolean isCorrect = false;
            System.out.println("\nКакой корабль хотите загрузить в порт?");
            for(int i = 1; i <= countOfShips; i++){
                System.out.println("\t Корабль №" + i + ": " + listOfShips.get(i-1).getName());
            }
            int choose;
            choose = scanner.nextInt() - 1;
            while (!isCorrect){
                if(choose >= 0 && choose < countOfShips){
                    isCorrect = true;
                }else{
                    System.out.println("Ввод некорректный, попробуйте ещё раз");
                    choose = scanner.nextInt() - 1;
                }
            }
            listOfShipsInPort.add(listOfShips.get(choose));
            listOfShips.remove(choose);
            countOfShips--;
            countOfShipsInPort++;
            uploadWaterFromShip();
        }else{
            System.out.println("\nПорт загружен, удалите корабль");
        }
        Menu();
    }

    public void uploadWaterFromShip(){
        if(!listOfShipsInPort.get(countOfShipsInPort-1).getFirstDeck().getIsEmpty()){
            if(listOfShipsInPort.get(countOfShipsInPort-1).getFirstDeck().getIsBigContainer()) {
                countOfWaterInPort += 1000;
            }
            if(!listOfShipsInPort.get(countOfShipsInPort-1).getFirstDeck().getIsBigContainer()){
                countOfWaterInPort+= 450 * listOfShipsInPort.get(countOfShipsInPort-1).getFirstDeck().getCountOfContainer();
            }
        }
        if(!listOfShipsInPort.get(countOfShipsInPort-1).getSecondDeck().getIsEmpty()){
            if(listOfShipsInPort.get(countOfShipsInPort-1).getSecondDeck().getIsBigContainer()){
                countOfWaterInPort+=1000;
            }
            if(!listOfShipsInPort.get(countOfShipsInPort-1).getSecondDeck().getIsBigContainer()){
                countOfWaterInPort+= 450 * listOfShipsInPort.get(countOfShipsInPort-1).getSecondDeck().getCountOfContainer();
            }
        }
    }

    public void removeShipFromPort(){
        if(countOfShipsInPort==0){
            System.out.println("\nКораблей в порту нету");
        }else{
            boolean isCorrect = false;
            System.out.println("\nКакой корабль хотите удалить?");
            for(int i = 1; i <= countOfShipsInPort; i=i+1){
                System.out.println("\t Корабль №" + i + ": " + listOfShipsInPort.get(i-1).getName());
            }
            int choose;
            choose = scanner.nextInt() - 1;
            while (!isCorrect){
                if(choose >= 0 && choose < countOfShipsInPort){
                    isCorrect = true;
                }else{
                    System.out.println("Ввод некорректный, попробуйте ещё раз");
                    choose = scanner.nextInt() - 1;
                }
            }
            countOfShipsInPort--;
            listOfShipsInPort.remove(choose);
        }

        Menu();
    }

    public void createNewShip(){
        Ship ship = new Ship();
        listOfShips.add(ship);
        countOfShips++;
        Menu();
    }
}
