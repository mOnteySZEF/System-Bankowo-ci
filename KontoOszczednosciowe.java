public class KontoOszczednosciowe extends KontoBankowe {
    private double oprocentowanie;

    public KontoOszczednosciowe(double oprocentowanie) {
        super();
        this.oprocentowanie = oprocentowanie;
    }

    public void naliczOdsetki() {
        double odsetki = saldo * oprocentowanie / 100;
        saldo += odsetki;
        historiaTransakcji.add("Naliczono odsetki: " + odsetki + " PLN");
        System.out.println("Naliczono odsetki: " + odsetki + " PLN. twoje saldo: " + saldo + " PLN");
    }

    @Override
    public void sprawdzSaldo() {
        super.sprawdzSaldo();
        System.out.println("Oprocentowanie: " + oprocentowanie + "% rocznie");
    }
}