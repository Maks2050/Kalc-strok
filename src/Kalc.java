import java.io.IOException;
import java.util.Scanner;

public class Kalc {
    public static void main(String[] args) {
        try {
            Scanner stroka = new Scanner(System.in);
            System.out.println("Введите выражение, которое вам нужно посчитать так, чтобы переменные находились в кавычках");
            String s = stroka.nextLine();
            String[] vvod = s.split("\"");
            if (vvod.length > 4)
                throw new IOException();
            if (vvod.length == 4) {
                String str1 = vvod[1], str2 = vvod[3];
                char[] simv1 = str1.toCharArray(), simv2 = vvod[3].toCharArray();
                if (simv1.length > 10)
                    throw new IOException();
                if (simv2.length > 10)
                    throw new IOException();
                if (vvod[2].equals(" + ") || vvod[2].equals(" - ")) {
                    if (vvod[2].equals(" + ")) {
                        String[] per2 = vvod[2].split("\"");
                        String plus = str1 + str2;
                        System.out.println("\"" + plus + "\"");
                    }
                    if (vvod[2].equals(" - ")) {
                        str1 = str1.replace(str2, "");
                        System.out.print("\"" + str1 + "\"");
                    }
                } else {
                    System.out.println("Введите одну из следующих операций: +,-,*,/");
                }
            } else {
                System.out.println();
                String[] arif = vvod[2].split(" ");
                if (arif[1].equals("*") || arif[1].equals("/")) {
                    if (arif[1].equals("*")) {
                        int a = Integer.parseInt(arif[2]);
                        if (a >= 1 && a <= 10) {
                            String umnoj = "";
                            System.out.print("\"");
                            while (a >= 1 && a <= 10) {
                                umnoj += vvod[1];
                                --a;
                            }
                            if (umnoj.length() < 40) {
                                System.out.print(umnoj);
                            } else {
                                System.out.print(umnoj.substring(0, 40) + "...");
                            }
                            System.out.println("\"");
                        } else
                            System.out.println("умножить можно на целые числа от 1 до 10");
                    }
                    if (arif[1].equals("/")) {
                        int a = Integer.parseInt(arif[2]);
                        int b = vvod[1].length();
                        int c = b / a;
                        if (a >= 1 && a <= 10) {
                            char[] simv1 = vvod[1].toCharArray();
                            System.out.print("\"");
                            for (int i = 0; i < c; i++) {
                                System.out.print(simv1[i]);
                            }
                            System.out.print("\"");
                        } else
                            System.out.println("разделить можно на целые числа от 1 до 10");
                    }
                } else {
                    System.out.println("Введите одну из следующих операций: +,-,*,/");
                }
            }
        } catch (IOException e) {
            System.out.println("Введите не более двух переменных, каждая из которых не больше 10 символов");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите сначала строку, выделенную кавычками, затем число, либо две строки, выделенные кавычками");
        } catch (NumberFormatException e) {
            System.out.println("Умножать и делить можно только строку на число");
        }
    }
}