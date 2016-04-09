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

        if (decision == 1) {
            System.out.println("You have taken the DEAL.");
            System.out.printf("You have won %d dollars.", average);
            System.out.println("CONGRATULATIONS!!!");
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

        if (decision == 1) {
            System.out.println("You have taken the DEAL.");
            System.out.printf("You have won %d dollars.", average);
            System.out.println("CONGRATULATIONS!!!");
        } else if (decision == 0) {
            System.out.println("You have refused the offer.");
            System.out.println("The game continues");
        } else {
            System.out.println("Incorect input");
            tempProverka = 1;
            Game(index3, boxes);
        }
    }
    public static int Offer(TreeMap<Integer,String> boxes){
        average = 0;
        for(Map.Entry<Integer,String> entry : boxes.entrySet()) {
            String key = entry.getValue();
            average += Integer.parseInt(key);
        }
        average /= boxes.size();
        System.out.println("Time to call the banker");
        System.out.printf("The banker's offer is: %d",average);
        return average;
    }

    public static void Printboxes(string[] boxarray)
    {

        Console.WriteLine("___________________________________________________________________");
        Console.WriteLine();
        Console.WriteLine("{0,-10}{1,25}{2,32}","[" + boxarray[0] + "]", "[" + boxarray[20] + "]", "[" + boxarray[10] + "]");
        Console.WriteLine("{0,-10}{1,57}", "[" + boxarray[1] + "]", "[" + boxarray[11] + "]");
        Console.WriteLine("{0,-10}{1,57}", "[" + boxarray[2] + "]", "[" + boxarray[12] + "]");
        Console.WriteLine("{0,-10}{1,10}{2,10}{3,10}{4,10}{5,17}", "[" + boxarray[3] + "]", valuesArray[0], valuesArray[5], valuesArray[10], valuesArray[15], "[" + boxarray[13] + "]");
        Console.WriteLine("{0,-10}{1,10}{2,10}{3,10}{4,10}{5,17}", "[" + boxarray[4] + "]", valuesArray[1], valuesArray[6], valuesArray[11], valuesArray[16], "[" + boxarray[14] + "]");
        Console.WriteLine("{0,-10}{1,10}{2,10}{3,10}{4,10}{5,17}", "[" + boxarray[5] + "]", valuesArray[2], valuesArray[7], valuesArray[12], valuesArray[17], "[" + boxarray[15] + "]");
        Console.WriteLine("{0,-10}{1,10}{2,10}{3,10}{4,10}{5,17}", "[" + boxarray[6] + "]", valuesArray[3], valuesArray[8], valuesArray[13], valuesArray[18], "[" + boxarray[16] + "]");
        Console.WriteLine("{0,-10}{1,10}{2,10}{3,10}{4,10}{5,17}", "[" + boxarray[7] + "]", valuesArray[4], valuesArray[9], valuesArray[14], valuesArray[19], "[" + boxarray[17] + "]");
        Console.WriteLine("{0,-10}{1,57}", "[" + boxarray[8] + "]", "[" + boxarray[18] + "]");
        Console.WriteLine("{0,-10}{1,26}{2,31}", "[" + boxarray[9] + "]", valuesArray[20], "[" + boxarray[19] + "]");
        Console.WriteLine();
        Console.WriteLine("___________________________________________________________________");
    }


    public static int GetBox(int index3)
    {
        if (control == 0)
        {

            Console.WriteLine("\n{0,56}\n", "* * * * * * * * * * * * * * * * * * * * * * *");
            Console.Write("{0,46}", "Pick a box from 1 to 21: ");
            control++;
        }
        else
        {
            Console.WriteLine();
            Console.Write("{0,47}", "Choose a box to open:  ");
        }

        while (true)
        {
            try
            {

                index3 = int.Parse(Console.ReadLine());
                break;

            }
            catch (FormatException)
            {
                index3 = 100;
                Console.WriteLine("{0,42}", "Invalid input! ");
                Console.WriteLine("{0,45}", "Enter box number again!");
                Console.Write("{0,33}", " ");
            }

        }
        index3--;

        int proverka = index3;
        while ((proverka < 0) || (proverka > 20))
        {
            Console.WriteLine("{0,42}", "Invalid input! ");
            Console.WriteLine("{0,45}", "Enter box number again!");
            Console.Write("{0,33}", " ");

            while (true)
            {
                try
                {

                    index3 = int.Parse(Console.ReadLine());
                    break;

                }
                catch (FormatException)
                {
                    index3 = 100;
                    Console.WriteLine("{0,42}", "Invalid input! ");
                    Console.WriteLine("{0,45}", "Enter box number again!");
                    Console.Write("{0,33}", " ");

                }
            }
            index3--;
            proverka = index3;
        }
        return index3;
    }
    public static void OpenBox(int index3,Dictionary<int,string>boxes, string[] boxarray)
    {
        int box1 = 0;



        try
        {

            box1 = GetBox(index3);
            if (boxChoice == box1)
            {
                Console.WriteLine("\n{0,34}\n", "*");
                Console.WriteLine("{0,46}", "You cannot open your box!");
                Console.WriteLine("\n{0,34}\n", "*");
                OpenBox(index3, boxes, boxarray);
            }

            if (boxChoice != box1)
            {
                boxarray[box1] = "x";
                Console.WriteLine();
                Console.WriteLine("{0,37}{1} :   {2}$", "You opened box ", box1 + 1, boxes[box1]);
                removeValue = boxes[box1];
            }


            for (int i = 0; i < valuesArray.Length; i++)
            {

                if (removeValue == valuesArray[i])
                {
                    valuesArray[i] = "";
                    //valuesArray[i] = "[XXX]";
                }
            }

            boxes.Remove(box1);

        }

        catch (KeyNotFoundException)
        {

            Console.WriteLine("\n{0,34}\n", "*");
            Console.WriteLine("{0,43}", "Box already opened! ");
            Console.WriteLine("{0,38}", "Try Again!");
            Console.WriteLine("\n{0,34}\n", "*");
            OpenBox(index3,boxes,boxarray);

        }

        catch (FormatException)
        {

            Console.WriteLine("{0,46}", "Invalid input! ");
            Console.WriteLine("{0,49}", "Enter box number again!");

            Console.WriteLine();
        }

    }

    static void Main()
    {
        Console.WindowHeight = 56;
        Console.BufferWidth = Console.WindowWidth = 67;
        Console.BufferHeight = 100;

        int index3 = 0;



        List<int> boxesList = new List<int>
        {
            1,5,10,20,50,100,200,300,500,750,1000,2500,5000,7500,10000,12500,15000,25000,50000,75000,100000
        };
        Random random = new Random();
        for (int i = 0; i < boxesList.Count; i++)
        {
            int index = random.Next(0, boxesList.Count);
            int index2 = random.Next(0, boxesList.Count);
            int temp = boxesList[index2];
            boxesList[index2] = boxesList[index];
            boxesList[index] = temp;
        }
        Dictionary < int,string>boxes= new Dictionary<int, string>();

        for (int i = 0; i < boxesList.Count; i++)
        {
            boxes[i] = boxesList[i].ToString();
        }

        Printboxes(boxArray);

        Console.WriteLine();
        Console.WriteLine("{0,47}", "- Time to choose Your Box! -");

        int finalBoxValue = 0;

        try
        {

            boxChoice = GetBox(index3);
            finalBoxValue = int.Parse(boxes[boxChoice]);
            boxArray[boxChoice] = "Your Box";
            Console.WriteLine();
            Console.WriteLine("{0,41} {1}", "You choose box: ", boxChoice + 1);
            Console.WriteLine("\n{0,34}\n", "*");
            Console.WriteLine("{0,43}", "This is YOUR box.");
            Console.WriteLine("{0,64}", "The value inside will be your final prize if no Deal is made!");
            Console.WriteLine("\n\n{0,34}\n", "*");
            Console.WriteLine();

        }

        catch (KeyNotFoundException)
        {
        System.out.println();
        System.out.println("Box already opened! ");
        System.out.println("Try Again!");
        System.out.println();
        OpenBox(index3, boxes, boxArray);

        }

        Game(index3, boxes);
        Console.Clear();
        Game(index3, boxes);
        Console.Clear();
        Game(index3, boxes);
        Console.Clear();
        Game(index3, boxes);
        Console.Clear();
        Game(index3, boxes);
        Console.Clear();

        Game1(index3, boxes);
        System.out.println();
        System.out.printf("%50s\n", "-The game continues!-");
        System.out.printf("\n%40s\n\n", "*");
        Console.Clear();

        Game1(index3, boxes);

        System.out.println();
        System.out.printf("%37s\n", "Game Over");
        System.out.println();
        System.out.printf("%46s\n", "That was the final offer");
        System.out.println();
        System.out.printf("%51s\n", "Now let's see what is in your box!");
        System.out.printf("\n%34s\n%34s\n%34s\n\n", "*", "*", "*");

        System.out.printf("%45s%n", "Type 1 to open!");
        System.out.printf("%39s", " ");

        scan.nextInt();

        Console.Clear();
        System.out.printf("\n\n\n\n\n\n\n");
        System.out.printf("%43s\n", "Your box contains:");

        System.out.printf("\n\n\n\n");

        System.out.printf("\n%35s\n%35s\n%35s\n\n", ".");
        System.out.println();
        System.out.println();


        System.out.printf("%36d\n", finalBoxValue);

        System.out.println();
        System.out.println();
        System.out.printf("\n\n\n\n\n\n\n                                     ");
        System.out.println("Press Enter to exit");
        scan.nextLine();

        }
        }
        }
