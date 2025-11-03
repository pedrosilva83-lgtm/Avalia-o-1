import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== CONVERSOR DE TEMPERATURA ===\n");

        double celsius;
        while (true) {
            System.out.print("Digite a temperatura em graus Celsius (°C): ");
            String linha = input.nextLine().trim();
            linha = linha.replace(',', '.'); // aceita vírgula

            try {
                celsius = Double.parseDouble(linha);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido (ex.: 25, 25.5). Tente novamente.");
            }
        }

        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        double kelvin = celsius + 273.15;

        System.out.println("\n=== RESULTADOS DA CONVERSÃO ===");
        System.out.printf("Temperatura em Celsius: %.2f °C%n", celsius);
        System.out.printf("Temperatura em Fahrenheit: %.2f °F%n", fahrenheit);
        System.out.printf("Temperatura em Kelvin: %.2f K%n", kelvin);

        System.out.println("\nFórmulas utilizadas:");
        System.out.println("°F = (°C × 9/5) + 32");
        System.out.println("K = °C + 273.15");

        input.close();
    }
}
