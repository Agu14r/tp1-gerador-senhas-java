package business;

public class GeradorSenhaForte extends GeradorSenha {

    private int tamanho;

    public GeradorSenhaForte(int tamanho) {

        if (tamanho < 12) {
            throw new IllegalArgumentException(
                    "A senha forte deve possuir no mínimo 12 caracteres."
            );
        }

        this.tamanho = tamanho;
    }

    @Override
    public String gerarSenha() {

        String senha = "";

        // Garante pelo menos um caractere de cada tipo
        senha += sortearCaractere(MAIUSCULAS);
        senha += sortearCaractere(MINUSCULAS);
        senha += sortearCaractere(NUMEROS);
        senha += sortearCaractere(ESPECIAIS);

        // Conjunto com todos os caracteres possíveis
        String todosCaracteres =
                MAIUSCULAS + MINUSCULAS + NUMEROS + ESPECIAIS;

        // Completa a senha até atingir o tamanho configurado
        while (senha.length() < tamanho) {
            senha += sortearCaractere(todosCaracteres);
        }

        // Embaralha para evitar que os primeiros caracteres
        // sempre apareçam na mesma ordem
        return embaralhar(senha);
    }
}