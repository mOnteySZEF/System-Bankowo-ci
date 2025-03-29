public class KontoWalutowe extends KontoBankowe {
    private double kurs;

    public KontoWalutowe(double kurs) {
        super(); // to wowoluje konstruktor klasy bazowej
        this.kurs = kurs;
    }

    @Override
    public void wplac(double kwota) {
        double kwotaPLN = kwota * kurs;
        super.wplac(kwotaPLN);
        historiaTransakcji.add("Wpłata: " + kwota + " w walucie, " + kwotaPLN + " PLN.");
        System.out.println("Wpłacono: " + kwota + " w walucie, " + kwotaPLN + " PLN.");
    }

    @Override
    public boolean wyplac(double kwota) {
        double kwotaPLN = kwota * kurs;
        return super.wyplac(kwotaPLN);
    }

    public void przewalutuj(double kwota, String walutaDocelowa) {
        if (walutaDocelowa.equals("PLN")) { // equals porownywanie obiektow czy sa podobne
            double kwotaPLN = kwota / kurs;
            wplac(kwotaPLN);
            System.out.println("Przewalutowano: " + kwota + " waluty na " + kwotaPLN + " PLN.");
        } else {
            double kwotaWalutowa = kwota * kurs;
            wplac(kwotaWalutowa);
            System.out.println("Przewalutowano: " + kwota + " pln na " + kwotaWalutowa + " w walucie.");
        }
    }

    @Override
    public void sprawdzSaldo() {
        super.sprawdzSaldo();
        System.out.println("Kurs wymiany: " + kurs);
    }
}