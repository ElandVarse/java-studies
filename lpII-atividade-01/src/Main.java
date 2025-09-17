public class Main {
    public static void main(String[] args) {
        // Criando um candidato
        Candidato c1 = new Candidato(10, "João Silva", 45, "Prefeito");

        // Exibindo informações
        System.out.println("Número: " + c1.getNumero());
        System.out.println("Nome: " + c1.getNome());
        System.out.println("Idade: " + c1.getIdade());
        System.out.println("Cargo: " + c1.getCargo());
        System.out.println("Votos: " + c1.getVotos());

        // Adicionando votos
        c1.adicionarVoto();
        c1.adicionarVoto();

        System.out.println("Votos após atualização: " + c1.getVotos());
    }
}
