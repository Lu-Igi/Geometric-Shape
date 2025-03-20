package forme.geometriche;

public class Rettangolo {
    private double base, altezza;

    // Costruttore
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    // Metodi per area e perimetro
    public double perimetro() {
        return (base + altezza) * 2;
    }

    public double area() {
        return base * altezza;
    }

    // Verifica se è un quadrato
    public boolean isQuadrato() {
        return base == altezza;
    }

    // Ruota il rettangolo
    public void ruotaSx() {
        double temporanea = base;
        base = altezza;
        altezza = temporanea;
    }

    public void ruotaDx() {
        ruotaSx();
    }
}
