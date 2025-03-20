package forme.geometriche;

import java.util.Scanner;

public class GestisciInterfacciaUtente {
    private Scanner scanner;

    public GestisciInterfacciaUtente() {
        this.scanner = new Scanner(System.in);
    }

    // Metodo per ottenere un numero intero
    public int getNumeroIntero(String titolo) {
        System.out.print(titolo);
        return scanner.nextInt();
    }

    // Metodo per ottenere un numero decimale
    public double getNumeroDouble(String titolo) {
        System.out.print(titolo);
        return scanner.nextDouble();
    }

    // Metodo principale che permette all'utente di scegliere e ripetere fino a quando lo desidera
    public void avvia() {
        boolean continua = true;

        while (continua) {
            System.out.println("\nScegli una figura geometrica:");
            System.out.println("1. Rettangolo");
            System.out.println("2. Triangolo");
            System.out.println("3. Esci");

            int scelta = getNumeroIntero("Inserisci la tua scelta: ");

            switch (scelta) {
                case 1:
                    gestisciRettangolo();
                    break;
                case 2:
                    gestisciTriangolo();
                    break;
                case 3:
                    System.out.println("Grazie per aver usato il programma. Arrivederci!");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida! Riprova.");
            }
        }
    }

    private void gestisciRettangolo() {
        double base = getNumeroDouble("Inserisci la base del rettangolo: ");
        double altezza = getNumeroDouble("Inserisci l'altezza del rettangolo: ");

        Rettangolo rettangolo = new Rettangolo(base, altezza);
        System.out.println("Area: " + rettangolo.area());
        System.out.println("Perimetro: " + rettangolo.perimetro());
        System.out.println("È un quadrato? " + rettangolo.isQuadrato());
    }

    private void gestisciTriangolo() {
        double lato1 = getNumeroDouble("Inserisci il primo lato del triangolo: ");
        double lato2 = getNumeroDouble("Inserisci il secondo lato del triangolo: ");
        double lato3 = getNumeroDouble("Inserisci il terzo lato del triangolo: ");

        try {
            Triangolo triangolo = new Triangolo(lato1, lato2, lato3);
            System.out.println("Area: " + triangolo.calcolaArea());
            System.out.println("Perimetro: " + triangolo.calcolaPerimetro());
            System.out.println("È equilatero? " + triangolo.isEquilatero());
            System.out.println("È isoscele? " + triangolo.isIsoscele());
            System.out.println("È scaleno? " + triangolo.isScaleno());

            // Calcolo dell'altezza
            if (triangolo.isEquilatero() || triangolo.isIsoscele()) {
                // Se il triangolo è equilatero o isoscele, calcola l'altezza rispetto a un lato valido
                System.out.println("Altezza relativa alla base " + lato1 + ": " + triangolo.calcolaAltezza(lato1));
            } else {
                // Se il triangolo è scaleno, chiedi all'utente di inserire la base corretta
                double base = getNumeroDouble("Inserisci la base su cui calcolare l'altezza (deve essere uno dei lati del triangolo): ");
                System.out.println("Altezza relativa alla base " + base + ": " + triangolo.calcolaAltezza(base));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
