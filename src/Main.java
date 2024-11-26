import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, String[]> getCurrencies() {
        Map<Integer, String[]> currencies = new HashMap<>();
        currencies.put(1, new String[]{"ARS", "Peso argentino"});
        currencies.put(2, new String[]{"BOB", "Boliviano boliviano"});
        currencies.put(3, new String[]{"BRL", "Real brasileño"});
        currencies.put(4, new String[]{"CLP", "Peso chileno"});
        currencies.put(5, new String[]{"COP", "Peso colombiano"});
        currencies.put(6, new String[]{"USD", "Dólar estadounidense"});
        return currencies;
    }

    private static String selectCurrency(String type, Map<Integer, String[]> currencies, Scanner scanner) {
        int selection;

        System.out.println("-------------------------------------------------");
        System.out.println("Seleccione la divisa de " + type + ":");
        currencies.forEach((key, value) -> System.out.println(key + ". " + value[0] + " - " + value[1]));
        while (true) {
            System.out.print("Ingrese el número correspondiente: ");
            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                if (currencies.containsKey(selection)) {
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, elija un número entre 1 y 6.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
        return currencies.get(selection)[0];
    }

    private static double getAmount(String originCurrency, Scanner scanner) {
        System.out.println("-------------------------------------------------");
        System.out.print("Ingrese la cantidad en " + originCurrency + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            System.out.print("Ingrese la cantidad en " + originCurrency + ": ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Map<Integer, String[]> currencies = getCurrencies();
        String originCurrency = selectCurrency("origen", currencies, teclado);
        String destinationCurrency = selectCurrency("destino", currencies, teclado);
        double amount = getAmount(originCurrency, teclado);
        teclado.close();

        ExchangeRateService exchanger = new ExchangeRateService();
        ExchangeRate exchange = exchanger.exchangeRate(originCurrency, destinationCurrency, amount);
        System.out.println("-------------------------------------------------");
        System.out.println(amount + " " + originCurrency + " son " + exchange.conversion_result() + " " + destinationCurrency);
    }
}
