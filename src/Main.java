import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int hrac = 2;
        boolean konec = false;
        int[][] plocha = new int[9][9];
        String[] znaky = {" ", "O", "X"};
        String[] hraci = {"nikdo", "hráč s kolečky", "hráč s křížky"};


        while (!konec) {

            System.out.print("  ");
            for (int i = 0; i < plocha[0].length; i++) {
                System.out.print((i + 1));
            }
            System.out.println();

            for (int j = 0; j < plocha[1].length; j++) {
                System.out.print(j + 1 + " ");
                for (int i = 0; i < plocha[0].length; i++) {
                    int znak = plocha[i][j];
                    System.out.print(znaky[znak]);
                }
                System.out.println();
            }


            int symboluVyhra = 5;

            int zaplneno = 0;
            int symboluRadek = 0;
            int symboluSloupec = 0;

            for (int j = 0; j < plocha[1].length; j++) {
                for (int i = 0; i < plocha[0].length; i++) {

                    if (plocha[i][j] > 0) {
                        zaplneno++;
                    }

                    if (zaplneno == (plocha[0].length * plocha[1].length)) {
                        System.out.println("Remíza.");
                        konec = true;
                    }

                    if (plocha[i][j] == hrac) {
                        symboluRadek++;
                    } else {
                        symboluRadek = 0;
                    }

                    if (plocha[j][i] == hrac) {
                        symboluSloupec++;
                    } else {
                        symboluSloupec = 0;
                    }
                    if (symboluRadek == symboluVyhra || symboluSloupec == symboluVyhra) {
                        System.out.println("Vyhrál " + hraci[hrac]);
                        konec = true;
                    }

                }
            }
            int symboluDiagonalaLeva = 0;
            int symboluDiagonalaPrava = 0;

            for (int j = 0; j < (plocha.length == 0 ? 0 : plocha[0].length) * 2; j++)
            {
                for (int i = 0; i < plocha.length; i++) {
                    int dy = (plocha.length == 0 ? 0 : plocha[0].length) - 1 - j + i;
                    if (dy >= 0 && dy < (plocha.length == 0 ? 0 : plocha[0].length) && (plocha[plocha.length - 1 - i][dy] == hrac))
                    {
                        symboluDiagonalaLeva++;
                    } else {
                        symboluDiagonalaLeva = 0;
                    }

                    if (dy >= 0 && dy < (plocha.length == 0 ? 0 : plocha[0].length) && (plocha[i][dy] == hrac))
                    {
                        symboluDiagonalaPrava++;
                    } else {
                        symboluDiagonalaPrava = 0;
                    }

                    if (symboluDiagonalaLeva == symboluVyhra || symboluDiagonalaPrava == symboluVyhra) {
                        System.out.println("Vyhrál " + hraci[hrac]);
                        konec = true;
                    }
                }
            }
            if (!konec) {
                if (hrac == 1) {
                    hrac = 2;
                } else {
                    hrac = 1;
                }
                System.out.println("Na řadě je " + hraci[hrac]);
                boolean volno = false;
                int x = 1;
                int y = 1;

                while (!volno) {

                    Scanner sc = new Scanner(System.in);
                    boolean jeSpravne = false;

                    while (!jeSpravne) {
                        try {
                            System.out.print("Zadej pozici X kam chceš táhnout: ");
                            x = Integer.parseInt(sc.nextLine());
                            jeSpravne = true;
                        } catch (Exception e) {
                            System.out.println("Zadaná hodnota není číslo nebo celé číslo, zadejte prosím celé číslo.");
                        }
                    }

                    jeSpravne = false;
                    while (!jeSpravne) {
                        try {
                            System.out.print("Zadej pozici Y kam chceš táhnout: ");
                            y = Integer.parseInt(sc.nextLine());
                            jeSpravne = true;
                        } catch (Exception e) {
                            System.out.println("Zadaná hodnota není číslo nebo celé číslo, zadejte prosím celé číslo.");
                        }
                    }


                    if (x >= 1 && y >= 1 && x <= 9 && y <= 9 && plocha[x - 1][y - 1] == 0) {
                        volno = true;
                    } else {
                        System.out.println("Neplatná pozice, zadej ji prosím znovu.");
                    }

                }
                plocha[x - 1][y - 1] = hrac;
            }

        }
    }
}