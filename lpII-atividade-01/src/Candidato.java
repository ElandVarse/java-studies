import java.util.Scanner;

public class Candidato {
    private int numero;
    private String nome;
    private int idade;
    private String cargo;
    private int votos;

    // construtor com validação de cargo e idade mínima
    public Candidato(int numero, String nome, int idade, String cargo) {
        if (cargo == null) {
            throw new IllegalArgumentException("Cargo inválido: null");
        }

        switch (cargo) {
            case "Presidente":
            case "Senador":
                if (idade < 35) {
                    throw new IllegalArgumentException("Idade mínima para " + cargo + " é 35 anos.");
                }
                break;
            case "Governador":
                if (idade < 30) {
                    throw new IllegalArgumentException("Idade mínima para Governador é 30 anos.");
                }
                break;
            case "Prefeito":
            case "Deputado":
                if (idade < 21) {
                    throw new IllegalArgumentException("Idade mínima para " + cargo + " é 21 anos.");
                }
                break;
            case "Vereador":
                if (idade < 18) {
                    throw new IllegalArgumentException("Idade mínima para Vereador é 18 anos.");
                }
                break;
            default:
                throw new IllegalArgumentException(
                    "Cargo inválido: " + cargo + ". Use exatamente: Presidente, Governador, Prefeito, Deputado, Senador ou Vereador."
                );
        }

        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.votos = 0;
    }

    // getters
    public int getNumero() { return numero; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getCargo() { return cargo; }
    public int getVotos() { return votos; }

    // método para adicionar votos
    public void adicionarVoto() { this.votos++; }

    // main para ler dados do usuário
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite o número do candidato: ");
            int numero = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            System.out.print("Digite o nome do candidato: ");
            String nome = sc.nextLine();

            System.out.print("Digite a idade do candidato: ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o cargo (Presidente, Governador, Prefeito, Deputado, Senador, Vereador): ");
            String cargo = sc.nextLine();

            // criação do candidato com validação
            Candidato c = new Candidato(numero, nome, idade, cargo);

            // exibe os dados
            System.out.println("\n--- Dados do Candidato ---");
            System.out.println("Número: " + c.getNumero());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("Cargo: " + c.getCargo());
            System.out.println("Votos: " + c.getVotos());

            // adiciona votos de teste
            c.adicionarVoto();
            c.adicionarVoto();
            System.out.println("Votos após simulação: " + c.getVotos());

        } catch (IllegalArgumentException e) {
            System.err.println("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
