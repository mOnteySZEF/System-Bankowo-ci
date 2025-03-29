import java.util.ArrayList;
import java.util.List;

public abstract class Konto {
    protected double saldo;
    protected List<String> historiaTransakcji;

    public Konto() {
        this.saldo = 0.0;
        this.historiaTransakcji = new ArrayList<>();
    }

    public abstract void wplac(double kwota); // abstract jakby sluzy do uzywania ich(implementacji) w innych klasach np z super()
    public abstract boolean wyplac(double kwota);
    public abstract void sprawdzSaldo();

    public void showHistoria() {
        System.out.println("Historia transakcji :");
        for (String transakcja : historiaTransakcji) {
            System.out.println(transakcja);
        }
    }
}