package forme.geometriche;

class Triangolo {
    private double lato1, lato2, lato3;

    // Costruttore
    public Triangolo(double lato1, double lato2, double lato3) {
        if (!isTriangoloValido(lato1, lato2, lato3)) {
            throw new IllegalArgumentException("Errore: i lati inseriti non formano un triangolo valido.");
        }
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
    }

    // Metodo per verificare se i lati formano un triangolo valido
    private boolean isTriangoloValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Metodo per calcolare l'area con la formula di Erone
    public double calcolaArea() {
        double s = (lato1 + lato2 + lato3) / 2; // Semiperimetro
        return Math.sqrt(s * (s - lato1) * (s - lato2) * (s - lato3));
    }

    // Metodo per calcolare il perimetro
    public double calcolaPerimetro() {
        return lato1 + lato2 + lato3;
    }

    // Metodo per calcolare l'altezza relativa a un lato dato
    public double calcolaAltezza(double base) {
        // Verifica che il lato passato come base sia effettivamente un lato del triangolo
        if (base != lato1 && base != lato2 && base != lato3) {
            throw new IllegalArgumentException("Errore: il valore inserito non corrisponde a un lato del triangolo.");
        }

        double area = calcolaArea();
        return (2 * area) / base;
    }

    // Metodo per verificare se il triangolo è equilatero
    public boolean isEquilatero() {
        return (lato1 == lato2) && (lato2 == lato3);
    }

    // Metodo per verificare se il triangolo è isoscele
    public boolean isIsoscele() {
        return (lato1 == lato2) || (lato1 == lato3) || (lato2 == lato3);
    }

    // Metodo per verificare se il triangolo è scaleno
    public boolean isScaleno() {
        return !isEquilatero() && !isIsoscele();
    }
}