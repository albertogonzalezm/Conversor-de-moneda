package conversor;

import modelos.Moneda;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConsultaApi consultaApi = new ConsultaApi();
        Moneda moneda = consultaApi.buscaMoneda();
        Map<String, Double> conversionRates = moneda.conversion_rates();
        DecimalFormat df = new DecimalFormat("#.00");

        int opcion = 0;
        double dinero = 0;
        double total = 0;

        String line = "*".repeat(39);
        String menu = "\n" + line + "\n" +
                "Sea bienvenido/a al Conversor de Moneda\n\n" +
                "1) Dolar => Peso Argentino\n" +
                "2) Peso Argentino => Dolar\n" +
                "3) Dolar => Real Brasileño\n" +
                "4) Real Brasileño => Dolar\n" +
                "5) Dolar => Peso Colombiano\n" +
                "6) Peso Colombiano => Dolar\n" +
                "7) Salir\n\n" + line + "\n";

        String ingValor = "ingresa la cantidad que quieres convertir.";

        while (true) {
            System.out.println(menu);
            try {
                opcion = sc.nextInt();

                if (opcion < 1 || opcion > 7) {
                    System.out.println("Elige una opcion valida.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Estas convirtiendo de Dolar a peso Argentino, " + ingValor);
                        dinero = sc.nextDouble();
                        total = dinero * conversionRates.get("ARS");
                        System.out.println(dinero + " USD son " + df.format(total) + " ARS");
                        break;
                    case 2:
                        System.out.println("Estas convirtiendo de peso Argentino a Dolar, " + ingValor);
                        dinero = sc.nextDouble();
                        total = dinero / conversionRates.get("ARS");
                        System.out.println(dinero + " ARS son " + df.format(total) + " USD");
                        break;
                    case 3:
                        System.out.println("Estas convirtiendo de Dolar a peso Brasileño, " + ingValor);
                        dinero = sc.nextDouble();
                        total = dinero * conversionRates.get("BRL");
                        System.out.println(dinero + " USD son " + df.format(total) + " BRL");
                        break;
                    case 4:
                        System.out.println("Estas convirtiendo de peso Brasileño a Dolar, " + ingValor);
                        dinero = sc.nextDouble();
                        total = dinero / conversionRates.get("BRL");
                        System.out.println(dinero + " BRL son " + df.format(total) + " USD");
                        break;
                    case 5:
                        System.out.println("Estas convirtiendo de Dolar a peso Colombiano, " + ingValor);
                        dinero = sc.nextDouble();
                        total = dinero * conversionRates.get("COP");
                        System.out.println(dinero + " USD son " + df.format(total) + " COP");
                        break;
                    case 6:
                        System.out.println("Estas convirtiendo de peso Colombiano a Dolar, " + ingValor);
                        dinero = sc.nextDouble();
                        total = dinero / conversionRates.get("COP");
                        System.out.println(dinero + " COP son " + df.format(total) + " USD");
                        break;
                    case 7:
                        System.out.println("Gracias por utilizar mi conversor de moneda.\n");
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Elige una opcion valida.");
                sc.next();
            }
        }
    }
}
