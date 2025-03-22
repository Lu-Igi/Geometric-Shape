package forme.geometriche;

public class Cerchio {
    private double raggio;

    // Costruttore
    public Cerchio(double raggio) {
        if (raggio <= 0) {
            throw new IllegalArgumentException("Errore: il raggio deve essere un numero positivo.");
        }
        this.raggio = raggio;
    }

    // Metodo per calcolare l'area
    public double area() {
        return Math.PI * raggio * raggio;
    }

    // Metodo per calcolare la circonferenza (perimetro)
    public double circonferenza() {
        return 2 * Math.PI * raggio;
    }

    // Metodo per calcolare il diametro
    public double diametro() {
        return 2 * raggio;
    }

    // Metodo per verificare se il cerchio è valido (raggio positivo)
    public boolean isValido() {
        return raggio > 0;
    }
}