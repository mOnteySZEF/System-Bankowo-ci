public class KontoLokacyjne extends KontoBankowe {
    private double oprocentowanie;
    private int okresLokaty;

    public KontoLokacyjne(double oprocentowanie, int okresLokaty) {
        super();
        this.oprocentowanie = oprocentowanie;
        this.okresLokaty = okresLokaty;
    }

    @Override
    public void wplac(double kwota) {
        if (saldo == 0) {
            super.wplac(kwota);
            historiaTransakcji.add("Wpłata na lokatę: " + kwota + " PLN");
            System.out.println("Wpłacono na lokatę: " + kwota + " PLN");
        } else {
            System.out.println("brak salda, nie mozesz!");
        }
    }

    @Override
    public boolean wyplac(double kwota) {
        if (okresLokaty <= 0) {
            double calkowityZysk = saldo * oprocentowanie / 100;
            saldo += calkowityZysk;
            historiaTransakcji.add("Wypłata z lokaty: " + saldo + " PLN , zysk: " + calkowityZysk + " PLN");
            System.out.println("Wypłacono: " + saldo + " PLN , odsetki: " + calkowityZysk + " PLN");
            saldo = 0;
            return true;
        } else {
            System.out.println("Nie można wyplacic bo okres sie nie skonczyl jeszcze");
            return false;
        }
    }

    @Override
    public void sprawdzSaldo() {
        super.sprawdzSaldo();
        System.out.println("Oprocentowanie lokaty: " + oprocentowanie + "% rocznie");
        System.out.println("Okres lokaty to " + okresLokaty + " miesięcy");
    }
}