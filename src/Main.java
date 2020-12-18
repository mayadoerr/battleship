import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int shotCounter;

    public static class Setup {
        public static Boolean shipsPlaced(ArrayList<Ship> ships) {
            Boolean allPlaced = true;
            for (int i = 0; i < ships.size(); i++) {
                if (ships.get(i).getPlaced() == false) {
                    allPlaced = false;
                }
            }
            return allPlaced;
        }
    }

    public static void main(String[] args) {

        Boolean debug = false;

        shotCounter = 0;
        int ShipInt;
        Random rand = new Random();
        int x, y;
        int result = 0;
        Board myBoard;
        myBoard = new Board();

        Boolean ValidInput = false;

        ArrayList<Ship> myShips = new ArrayList<Ship>(4);

        myShips.add(new Battleship());
        myShips.add(new Carrier());
        myShips.add(new Cruiser());
        myShips.add(new Destroyer());
        myShips.add(new Submarine());

        Scanner scanner = new Scanner(System.in);

        System.out.println(myBoard);

        while (!Main.Setup.shipsPlaced(myShips)) {
            try {
                //debugging
                if (debug) {
                    myShips.get(0).setPlaced(true);
                    for (int i = 0; i < myShips.size(); i++) {
                        System.out.println(myShips.get(i).getName() + " placed = " + myShips.get(i).getPlaced());
                    }
                }
                System.out.println("Select a Ship to place:");
                for (int i = 0; i < myShips.size(); i++) {
                    if (myShips.get(i).getPlaced() == false) {
                        System.out.println("(" + i + ") " + myShips.get(i).getName() + " (Size " + myShips.get(i).getSize() + ")");
                    }
                }
                System.out.println("Enter your choice: ");
                if (scanner.hasNextInt()) {

                    //                String Ship = scanner.nextLine();
                    ShipInt = scanner.nextInt();
                    if (ShipInt < 0 || ShipInt > myShips.size()) {
                        ValidInput = false;
                        continue;
                    } else {
                        ValidInput = true;
                    }
                } else {
                    System.out.println("That wasn't a number. Please try again.");
                    ValidInput = false;
                    scanner.nextLine();
                    continue;
                }

                boolean ShipPlacement = false;
                while (ShipPlacement == false) {
                    //                    try {
                    System.out.println("\nYou have selected the " + myShips.get(ShipInt).getName() + "!");
                    System.out.println(myShips.get(ShipInt).getName() + " size = " + myShips.get(ShipInt).getSize() + "\n");

                    System.out.println("Enter a row 0-9: ");
                    String Row = scanner.nextLine();
                    Row = scanner.nextLine();
                    int RowInt = Integer.parseInt(Row);
                    //                    } catch (NumberFormatException NFE) {
                    //                        System.out.println("Your input was invalid. Please try again. EXCEPTION: " + NFE);
                    //                        continue;
                    //                    } catch (Exception e) {
                    //                        System.out.println("Something went wrong.");
                    //                        continue;
                    //                    }
                    System.out.println("Enter a column 0-9: ");
                    String Column = scanner.nextLine();
                    int ColumnInt = Integer.parseInt(Column);

                    if ((RowInt >= 0 && RowInt <= (myBoard.BOARD_SIZE - 1)) && (ColumnInt >= 0 && ColumnInt <= (myBoard.BOARD_SIZE - 1))) {
                        ValidInput = true;
                    } else {
                        ValidInput = false;
                    }
                    while (ValidInput == false) {
                        System.out.println("Invalid input Please try again");

                        System.out.println("Enter a row 0-" + (myBoard.BOARD_SIZE - 1) + ": ");
                        Row = scanner.nextLine();
                        RowInt = Integer.parseInt(Row);

                        System.out.println("Enter a column 0-" + (myBoard.BOARD_SIZE - 1) + ": ");
                        Column = scanner.nextLine();
                        ColumnInt = Integer.parseInt(Column);
                        if ((RowInt >= 0 && RowInt <= (myBoard.BOARD_SIZE - 1)) && (ColumnInt >= 0 && ColumnInt <= (myBoard.BOARD_SIZE - 1))) {
                            ValidInput = true;
                        } else {
                            ValidInput = false;
                        }
                    }

                    System.out.println("Enter H for Horizontal or V for Vertical: ");
                    String Orientation = scanner.nextLine();
                    boolean isHorizontal = false;
                    if (Orientation.equals("H") || Orientation.equals("h")) {
                        isHorizontal = true;
                        ValidInput = true;
                    } else if (Orientation.equals("V") || Orientation.equals("v")) {
                        isHorizontal = false;
                        ValidInput = true;
                    } else {
                        ValidInput = false;
                    }

                    while (ValidInput == false) {
                        System.out.print("Invalid input Please try again");
                        System.out.println("Enter H for Horizontal or V for Vertical: ");
                        Orientation = scanner.nextLine();
                        if (Orientation.equals("H") || Orientation.equals("h")) {
                            isHorizontal = true;
                            ValidInput = true;
                        } else if (Orientation.equals("V") || Orientation.equals("v")) {
                            isHorizontal = false;
                            ValidInput = true;
                        } else {
                            ValidInput = false;
                        }
                    }

                    if (myBoard.addShip(RowInt, ColumnInt, myShips.get(ShipInt).getSize(), isHorizontal)) {
                        System.out.println("Successfully Placed");
                        ShipPlacement = true;
                        myShips.get(ShipInt).setPlaced(true);
                        System.out.println(myBoard);
                    } else {
                        System.out.println("Unable to place ship");
                        ShipPlacement = false;
                        myShips.get(ShipInt).setPlaced(false);
                        System.out.println(myBoard);
                    }
                }
            }
            catch (NumberFormatException nf) {
                System.out.println("Not a valid number. Error: " + nf);
                continue;
            }
            catch (IllegalArgumentException ia) {
                System.out.println("An illegal argument was caught. Error: " + ia);
                System.out.println("Exiting.");
            }
        } // end of board while loop

        while(!myBoard.gameOver()) {
            // shooting
            x = rand.nextInt(myBoard.BOARD_SIZE);
            y = rand.nextInt(myBoard.BOARD_SIZE);
            result = myBoard.shoot(x, y);
            if(result == -1){
                System.out.println("Shot at " + x + ", "+ y + " out of Bounds");
            } else if(result == 1){
                System.out.println("Hit at: " + x + ", "+ y);
            } else if(result == 0){
                System.out.println("Miss at: " + x + ", "+ y);
            }else{
                System.out.println("Already shot at: " + x + ", "+ y);
            }
            System.out.print(myBoard);
            shotCounter += 1;
        }
//        System.out.println("GAME OVER! Computer took " + shotCounter + " shots to defeat you.");
//        if (shotCounter < 50) {
//            System.out.println("The computer did pretty good.");
//        }
//        else if (shotCounter < 75) {
//            System.out.println("The computer did ok.");
//        }else if (shotCounter < 90){
//            System.out.println("The computer did terrible.");
//        } else{
//            System.out.println("The computer should hand in its CPU and never play again.");
//        }
        SceneBuilderFX fx = new SceneBuilderFX();
        fx.start();
    }

    public void setShotCounter(int count) {
        shotCounter = count;
    }

    public int getShotCounter() {
        return shotCounter;
    }


}
