import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<KontoBankowe> konta;
    private Scanner sc;

    public Main() {
        sc = new Scanner(System.in);
        konta = new ArrayList<>();
    }

    public void start() {
        while (true) {
            System.out.println("Wybierz typ konta:");
            System.out.println("1. Konto bankowe");
            System.out.println("2. Konto walutowe");
            System.out.println("3. Konto oszczednosciowe");
            System.out.println("4. Konto lokacyjne");
            System.out.println("5. Istniejące konta");
            System.out.println("6. Wyjdz");

            int wybor = sc.nextInt();
            KontoBankowe noweKonto = null;

            switch (wybor) {
                case 1:
                    noweKonto = new KontoBankowe();
                    break;
                case 2:
                    System.out.print("Podaj kurs waluty: ");
                    double kurs = sc.nextDouble();
                    noweKonto = new KontoWalutowe(kurs);
                    break;
                case 3:
                    System.out.print("Podaj oprocentowanie konta oszczednosciowego: ");
                    double oprocentowanieOszczednosciowe = sc.nextDouble();
                    noweKonto = new KontoOszczednosciowe(oprocentowanieOszczednosciowe);
                    break;
                case 4:
                    System.out.print("Podaj oprocentowanie: ");
                    double oprocentowanieLokaty = sc.nextDouble();
                    System.out.print("Podaj okres lokaty w miesiacach: ");
                    int okresLokaty = sc.nextInt();
                    noweKonto = new KontoLokacyjne(oprocentowanieLokaty, okresLokaty);
                    break;
                case 5:
                    if (konta.isEmpty()) { // jesli puste
                        System.out.println("Nie posiadasz kont, zaloz je najpierw");
                    } else {
                        System.out.println("Istniejace konta:");
                        for (int i = 0; i < konta.size(); i++) { // size to liczba elementow przechowywanych
                            System.out.println("Konto " + (i + 1) + ": " + konta.get(i).getClass().getSimpleName());
                        }
                    }
                    continue; 
                case 6:
                    System.out.println("zegnam yo...");
                    sc.close();
                    return; 
                default:
                    System.out.println("zle wybrales");
                    continue; 
            }

            konta.add(noweKonto);
            System.out.println("Wow masz nowe konto !");

            while (true) {
                System.out.println("Wybierz konto do zarzadzania:");
                for (int i = 0; i < konta.size(); i++) {
                    System.out.println((i + 1) + ". konto " + konta.get(i).getClass().getSimpleName()); // get pobiera element, getClass obiekt klasy, getSimpleName nazwe klasy bez pakietow
                }
                System.out.print("Wybierz numer konta lub 0 aby wrocic: ");
                int index = sc.nextInt() - 1;

                if (index == -1) {
                    break;
                }

                KontoBankowe konto = konta.get(index); // pobiera konta yo
                while (true) {
                    System.out.println("\n------ MENU ------");
                    System.out.println("1. Wplac pieniadze");
                    System.out.println("2. Wyplac pieniadze");
                    System.out.println("3. Sprawdz saldo");
                    System.out.println("4. Przewalutowanie");
                    System.out.println("5. Historia transakcji");
                    System.out.println("6. Wroc do wyboru konta");
                    System.out.print("Wybierz opcje: ");
                    String wyborKonta = sc.next().trim();

                    switch (wyborKonta) {
                        case "1":
                            System.out.print("Podaj kwote do wplaty: ");
                            double kwotaDoWplaty = sc.nextDouble();
                            konto.wplac(kwotaDoWplaty);
                            break;
                        case "2":
                            System.out.print("Podaj kwote do wyplaty: ");
                            double kwotaDoWyplaty = sc.nextDouble();
                            konto.wyplac(kwotaDoWyplaty);
                            break;
                        case "3":
                            konto.sprawdzSaldo();
                            break;
                        case "4":
                            KontoWalutowe kontoWalutowe = (KontoWalutowe) konto;
                            System.out.print("Wybierz przewalutowanie (PLN->EUR, PLN->USD): ");
                            String opcja = sc.next().trim(); // trim usuwa spacje itp biale znaki
                            System.out.print("Podaj kwote do przewalutowania: ");
                            double kwota = sc.nextDouble();
                            kontoWalutowe.przewalutuj(kwota, opcja);
                            break;
                        case "5":
                            konto.showHistoria();
                            break;
                        case "6":
                            break; 
                        default:
                            System.out.println("zle wybrales");
                    }
                }
            }
        }
    }
    // starcik
    public static void main(String[] args) {
        Main bank = new Main();
        bank.start();
    }
}