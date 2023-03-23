package kolos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BoundaryException, OutsideTheWorld {

        World world = new World(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        //System.out.println("Treasure: " + world.treasure.toString()); //dla testow
        Robot robot = new Robot();

        System.out.println("""
                1 - podaj wartosci x i y na jakie ma stanac robot
                2 - przesun robota na wczesniejsza pozycje
                3 - wyswietl aktualna pozycje robota
                4 - exit - zamyka program""");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(true) {

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    /*
                    Nie bardzo wiedzialem jak rozumiec "przesun o jedna pozycje", czy jest to double = 1.0, czy jakas inna wartosc,
                    dlatego zapytuje uzytkownika o nowe wspolrzedne gdzie ustawic robota. Jesli mialbym przesuwac o konkretną wartosc,
                    to po prostu tworzylbym nowe position ze wspolrzednymi wiekszymi o te wartosc od poprzednich (get.previous)
                     */

                    System.out.println("Podaj x: ");
                    double userx = Double.parseDouble(scanner.nextLine());
                    System.out.println("Podaj y: ");
                    double usery = Double.parseDouble(scanner.nextLine());
                    Possition possition = new Possition(userx, usery);
                    robot.MoveTo(possition, world);
                    System.out.println("Robot przesuniety na " + robot.getPossition().toString());
                    //jesli odleglosc sie zmniejszyla wyswietl hot, jesli nie wyswietl cold
                    if (robot.getPrevious().distance(world.treasure) > robot.getPossition().distance(world.treasure)) {
                        System.out.println("Hot!");
                    } else {
                        System.out.println("Cold...");
                    }


                    break;

                case 2:
                    robot.MoveBack();
                    System.out.println("Robot przesuniety na wczesniejsza pozycje");
                    break;

                case 3:
                    System.out.println("Aktualna pozycja robota: " + robot.getPossition().toString());
                    break;

                case 4:
                    return;
            }
        }

    }
    
}
