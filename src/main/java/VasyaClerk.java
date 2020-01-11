/**
 Task:
    The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in
    a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
    Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
    Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets
    strictly in the order people queue?
    Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that
    moment. Otherwise return NO.

 Examples:
    VasyaClerk.Tickets(new int[] {25, 25, 50}) // => YES
    VasyaClerk.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
    VasyaClerk.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give
        75 dollars of change (you can't make two bills of 25 from one of 50)
 */

public class VasyaClerk {
    public static String Tickets(int[] peopleInLine)
    {
        printInputs(peopleInLine);

        int bill100 = 0;
        int bill50 = 0;
        int bill25 = 0;
        String res = "";

        for (int value : peopleInLine) {
            if (value == 50) {
                bill50++;
                if (bill25 > 0) {
                    bill25--;
                } else {
                    res = "NO";
                    break;
                }
            } else if (value == 100) {
                bill100++;
                if (bill50 > 0 && bill25 > 0) {
                    bill50--;
                    bill25--;
                } else if (bill25 >= 3) {
                    bill25 -= 3;
                } else {
                    res = "NO";
                    break;
                }
            } else {
                bill25++;
                res = "YES";
            }
        }
        return res;
    }

    private static void printInputs(int[] peopleInLine) {
        for (int i = 0; i < peopleInLine.length; i++) {
            System.out.print(peopleInLine[i]);
            if (i < peopleInLine.length-1) {
                System.out.print(", ");
            }
        }
    }
}
