import java.util.ArrayList;
import java.util.List;

public class KontoBankowe {
    protected double saldo;
    protected List<String> historiaTransakcji;

    public KontoBankowe() {
        this.saldo = 0;
        this.historiaTransakcji = new ArrayList<>();
    }

    public void wplac(double kwota) {
        if (kwota > 0) {
            saldo += kwota;
            historiaTransakcji.add("Wpłata: " + kwota + " PLN");
            System.out.println("Wpłacono: " + kwota + " PLN");
        } else {
            System.out.println("Kwota musi być większa od 0 jak cos");
        }
    }

    public boolean wyplac(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
            historiaTransakcji.add("Wypłata: " + kwota + " PLN");
            System.out.println("Wypłacono: " + kwota + " PLN");
            return true;
        } else {
            System.out.println("brak srodkow!!!!!!");
            return false;
        }
    }

    public void sprawdzSaldo() {
        System.out.println("Aktualne saldo: " + saldo + " PLN");
    }

    public void showHistoria() {
        System.out.println("Historia transakcji:");
        for (String transakcja : historiaTransakcji) {
            System.out.println(transakcja);
        }
    }
}