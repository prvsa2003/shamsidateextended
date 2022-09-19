package tamrin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("****************welcome**************");
        loop:
        while (true) {
            System.out.println("1.add one day\n2.Add day or subtract day\n3.compare two date\n4.Exit");
            int c = inp.nextInt();
            switch (c) {
                case 1:
                    byte day,
                     month;
                    short year;
                    System.out.print("Enter Day:");
                    day = inp.nextByte();
                    System.out.print("Enter Month:");
                    month = inp.nextByte();
                    System.out.print("Enter Year:");
                    year = inp.nextShort();
                    ShamsiDateExtended sd = new ShamsiDateExtended(day, month, year);
                    sd.incDay();
                    System.out.println(sd);
                    break;

                case 2:
                    System.out.print("Enter n : ");
                    short x = inp.nextShort();
                    System.out.print("Enter Day:");
                    day = inp.nextByte();
                    System.out.print("Enter Month:");
                    month = inp.nextByte();
                    System.out.print("Enter Year:");
                    year = inp.nextShort();
                    sd = new ShamsiDateExtended(day, month, year);
                    sd.addDays(x);
                    System.out.println(sd);
                    break;
                case 3:
                    System.out.print("Enter Day1:");
                    day = inp.nextByte();
                    System.out.print("Enter Month1:");
                    month = inp.nextByte();
                    System.out.print("Enter Year1:");
                    year = inp.nextShort();
                    sd = new ShamsiDateExtended(day, month, year);
                    System.out.print("Enter Day2:");
                 byte day2 = inp.nextByte();
                    System.out.print("Enter Month2:");
                   byte month2 = inp.nextByte();
                    System.out.print("Enter Year2:");
                   short year2 = inp.nextShort();
                    ShamsiDateExtended shms = new ShamsiDateExtended(day2, month2, year2);
                    System.out.println(sd.compare(shms));
                    break;
                case 4:
                    break loop;
            }
        }

    }
}
