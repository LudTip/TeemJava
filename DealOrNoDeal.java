package com.company;

import java.util.*;

public class DealOrNoDeal {
    static Scanner scan = new Scanner(System.in);
    static int tempProverka = 0;
    public static int box1;
    static int boxChoice = 0;
    static String removeValue = "";
    static String[] valuesArray = new String[]{"1", "5", "10", "20", "50", "100", "200", "300", "500", "750", "1000", "2500", "5000", "7500", "10000", "12500", "15000", "25000", "50000", "75000", "100000"};
    static String[] boxArray = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
    static int average = 0;
    static int control = 0;

    public static void Game1(int index3, TreeMap<Integer, String> boxes) {
        if (tempProverka == 0) {
            Printboxes(boxArray);
            System.out.printf("Now you must open 2 boxes! -\n");

            OpenBox(index3, boxes, boxArray);
            Printboxes(boxArray);

            OpenBox(index3, boxes, boxArray);
            Printboxes(boxArray);
            average = Offer(boxes);

            System.out.println();
            System.out.println();
            System.out.println("DEAL OR NO DEAL");
            System.out.println("Type 1 for DEAL or 0 for NO DEAL");
            System.out.printf("                               ");
        } else {
            System.out.println();
            System.out.println("Type 1 for DEAL or 0 for NO DEAL");
            System.out.printf("                               ");
            tempProverka = 0;
        }
        int decision = scan.nextInt();
        scan.nextLine();

        if (decision == 1) {
            System.out.println("You have taken the DEAL.");
            System.out.printf("You have won %d dollars.", average);
            System.out.println("CONGRATULATIONS!!!");
            System.exit(0);
        } else if (decision == 0) {
            System.out.println("You have refused the offer.");
        } else {
            System.out.println("Incorect input");
            tempProverka = 1;
            Game(index3, boxes);
        }
    }

    public static void Game(int index3, TreeMap<Integer, String> boxes) {
        if (tempProverka == 0) {
            Printboxes(boxArray);

            System.out.println("You must open 3 boxes");
            System.out.println();
            OpenBox(index3, boxes, boxArray);
            Printboxes(boxArray);


            OpenBox(index3, boxes, boxArray);
            Printboxes(boxArray);


            OpenBox(index3, boxes, boxArray);
            Printboxes(boxArray);
            average = Offer(boxes);

            System.out.println();
            System.out.println();
            System.out.println("DEAL OR NO DEAL");
            System.out.println("Type 1 for DEAL or 0 for NO DEAL");
            System.out.printf("                               ");
        } else {
            System.out.println();
            System.out.println("Type 1 for DEAL or 0 for NO DEAL");
            System.out.printf("                               ");
            tempProverka = 0;
        }
        int decision = scan.nextInt();
        scan.nextLine();
        if (decision == 1) {
            System.out.println("You have taken the DEAL.");
            System.out.printf("You have won %d dollars.", average);
            System.out.println("CONGRATULATIONS!!!");
            System.exit(0);
        } else if (decision == 0) {
            System.out.println("You have refused the offer.");
            System.out.println("The game continues");
        } else {
            System.out.println("Incorrect input");
            tempProverka = 1;
            Game(index3, boxes);
        }
    }

    public static int Offer(TreeMap<Integer, String> boxes) {
        average = 0;
        for (Map.Entry<Integer, String> entry : boxes.entrySet()) {
            String value = entry.getValue();
            average += Integer.parseInt(value);
        }
        average /= boxes.size();
        System.out.println("Time to call the banker");
        System.out.printf("The banker's offer is: %d", average);
        return average;
    }

    public static void Printboxes(String[] boxarray) {

        System.out.println("___________________________________________________________________");
        System.out.println();
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[0], boxarray[1], boxarray[2],valuesArray[0],valuesArray[2],valuesArray[4]);
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[3], boxarray[4], boxarray[5],valuesArray[6],valuesArray[8],valuesArray[10]);
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[6], boxarray[7], boxarray[8],valuesArray[12],valuesArray[14],valuesArray[16]);
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[9], boxarray[10], boxarray[11],valuesArray[18],valuesArray[20],valuesArray[1]);
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[12], boxarray[13], boxarray[14],valuesArray[3],valuesArray[5],valuesArray[7]);
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[15], boxarray[16], boxarray[17],valuesArray[9],valuesArray[11],valuesArray[13]);
        System.out.printf("[%s] [%s] [%s]   [%s] [%s] [%s]%n", boxarray[18], boxarray[19], boxarray[20],valuesArray[15],valuesArray[17],valuesArray[19]);
        System.out.println();
        System.out.printf("___________________________________________________________________%n");
    }


    public static int GetBox(int index3) {
        if (control == 0) {

            System.out.printf("\n%s\n", "* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.printf("\n%s\n", "Pick a box from 1 to 21: ");
            control++;
        } else {
            System.out.println();
            System.out.printf("\n%s\n", "Choose a box to open:  ");
        }

        while (true) {
            try {

                index3 = Integer.parseInt(scan.nextLine());
                break;

            } catch (IllegalArgumentException iae) {
                index3 = 100;
                System.out.printf("\n%s\n", "Invalid input! ");
                System.out.printf("\n%s\n", "Enter box number again!");
                System.out.printf("\n%s\n", " ");
            }

        }
        index3--;

        int proverka = index3;
        while ((proverka < 0) || (proverka > 20)) {
            System.out.printf("\n%s\n", "Invalid input! ");
            System.out.printf("\n%s\n", "Enter box number again!");
            System.out.printf("\n%s\n", " ");

            while (true) {
                try {

                    index3 = Integer.parseInt(scan.nextLine());
                    break;

                } catch (IllegalFormatException IFE) {
                    index3 = 100;
                    System.out.printf("\n%s\n", "Invalid input! ");
                    System.out.printf("\n%s\n", "Enter box number again!");
                    System.out.printf("\n%s\n", " ");

                }
            }
            index3--;
            proverka = index3;
        }
        return index3;
    }

    public static void OpenBox(int index3, TreeMap<Integer, String> boxes, String[] boxarray) {
        int box1 = 0;
        try {
            box1 = GetBox(index3);
            if (boxChoice == box1) {
                System.out.printf("\n%s\n", "*");
                System.out.printf("%s", "You cannot open your box!");
                System.out.printf("\n%s\n", "*");
                OpenBox(index3, boxes, boxarray);
            }

            if (boxChoice != box1) {
                boxarray[box1] = "x";
                System.out.println();
                System.out.printf("%s %d :   %s$%n", "You opened box", box1 + 1, boxes.get(box1+1));
                removeValue = boxes.get(box1+1);
            }

            for (int i = 0; i < valuesArray.length; i++) {
                if (removeValue.equals(valuesArray[i])) {
                    valuesArray[i] = "";
                    valuesArray[i] = "XXX";
                }
            }
            boxes.remove(box1+1);
        } catch (IllegalFormatException IFE) {
            System.out.printf("%s", "Invalid input!");
            System.out.printf("%s", "Enter box number again!");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int index3 = 0;
        TreeMap<Integer, String> boxes = new TreeMap<>();
        List<Integer> boxesList = new ArrayList<>(Arrays.asList
                (1, 5, 10, 20, 50, 100, 200, 300, 500, 750, 1000, 2500, 5000, 7500, 10000, 12500, 15000, 25000, 50000, 75000, 100000));
        Random rand = new Random();

        for (int i = 0; i < boxesList.size(); i++) {
            int index = rand.nextInt(boxesList.size());
            int index2 = rand.nextInt(boxesList.size());

            int temp = boxesList.get(index2);
            boxesList.set(index2, boxesList.get(index));
            boxesList.set(index, temp);
        }

        for (int i = 0; i < boxesList.size(); i++) {
            boxes.put(i + 1, boxesList.get(i).toString());
        }

        Printboxes(boxArray);
        System.out.println();
        System.out.println("Time to choose a box!");
        int finalBoxValue = 0;

        try {
            boxChoice = GetBox(index3);
            finalBoxValue = Integer.parseInt(boxes.get(boxChoice+1));
            boxArray[boxChoice] = "Your Box";
            System.out.println();
            System.out.printf("You chose box: %d.", boxChoice + 1);
            System.out.println("This is your box.");
            System.out.println("The value inside of it will be your final prize if no Deal is made");
            System.out.println();
        } catch (IllegalArgumentException IAE) {
            System.out.println();
            System.out.println("Box already opened! ");
            System.out.println("Try Again!");
            System.out.println();
            OpenBox(index3, boxes, boxArray);

        }

        Game(index3, boxes);
        Game(index3, boxes);
        Game(index3, boxes);
        Game(index3, boxes);
        Game(index3, boxes);

        Game1(index3, boxes);
        System.out.println();
        System.out.printf("%s\n", "-The game continues!-");
        System.out.printf("\n%s\n\n", "*");

        Game1(index3, boxes);
        System.out.printf("%s\n", "Game Over");
        System.out.printf("%s\n", "That was the final offer");
        System.out.printf("%s\n", "Now let's see what is in your box!");
        System.out.printf("%s%n", "Type 1 to open!");
        System.out.printf("%s", " ");

        scan.nextInt();
        System.out.printf("%s\n", "Your box contains:");

        System.out.printf("%d\n", finalBoxValue);
        System.out.println("Press Enter to exit");
        scan.nextLine();

    }

}
