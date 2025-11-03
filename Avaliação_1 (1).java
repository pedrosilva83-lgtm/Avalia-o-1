import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] notas = new double[8];
        double[] mediasBimestrais = new double[4];
        double[] mediasSemestrais = new double[2];
        double mediaFinal;

        System.out.println("=== SISTEMA ESCOLAR ===");
        System.out.println("Digite as 8 notas do aluno (2 notas por bimestre). Use vírgula ou ponto para decimais.\n");

        // Entrada das notas com validação e suporte a vírgula
        for (int i = 0; i < 8; i++) {
            while (true) {
                System.out.print("Digite a nota " + (i + 1) + " (0 - 10): ");
                String linha = input.nextLine().trim();

                // substituir vírgula por ponto para evitar InputMismatch
                linha = linha.replace(',', '.');

                try {
                    double valor = Double.parseDouble(linha);

                    if (valor < 0 || valor > 10) {
                        System.out.println("Valor inválido. A nota deve estar entre 0 e 10. Tente novamente.");
                        continue;
                    }

                    notas[i] = valor;
                    break; // nota válida, sai do loop
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número (ex.: 7.5 ou 7,5). Tente novamente.");
                }
            }
        }

        // Cálculo das médias bimestrais (2 notas por bimestre)
        for (int i = 0; i < 4; i++) {
            mediasBimestrais[i] = (notas[i * 2] + notas[i * 2 + 1]) / 2.0;
        }

        // Cálculo das médias semestrais (2 bimestres por semestre)
        mediasSemestrais[0] = (mediasBimestrais[0] + mediasBimestrais[1]) / 2.0;
        mediasSemestrais[1] = (mediasBimestrais[2] + mediasBimestrais[3]) / 2.0;

        // Cálculo da média final (média dos dois semestres)
        mediaFinal = (mediasSemestrais[0] + mediasSemestrais[1]) / 2.0;

        // Exibição dos resultados
        System.out.println("\n=== RESULTADOS ===");
        for (int i = 0; i < 4; i++) {
            System.out.printf("Média do %dº Bimestre: %.2f%n", (i + 1), mediasBimestrais[i]);
        }

        System.out.printf("%nMédia do 1º Semestre: %.2f%n", mediasSemestrais[0]);
        System.out.printf("Média do 2º Semestre: %.2f%n", mediasSemestrais[1]);
        System.out.printf("%nMÉDIA FINAL DO ANO: %.2f%n", mediaFinal);

        // Situação final do aluno
        if (mediaFinal >= 7.0) {
            System.out.println("\nAluno APROVADO!");
        } else if (mediaFinal >= 5.0) {
            System.out.println("\nAluno em RECUPERAÇÃO!");
        } else {
            System.out.println("\nAluno REPROVADO!");
        }

        input.close();
    }
}
