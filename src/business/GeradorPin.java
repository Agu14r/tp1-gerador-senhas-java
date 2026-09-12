package business;

public class GeradorPin extends GeradorSenha {

    @Override
    public String gerarSenha() {

        String pin;

        do {
            pin = "";

            for (int i = 0; i < 6; i++) {
                pin += sortearCaractere(NUMEROS);
            }

        } while (todosIguais(pin) || sequencial(pin));

        return pin;
    }

    private boolean todosIguais(String pin) {

        for (int i = 1; i < pin.length(); i++) {
            if (pin.charAt(i) != pin.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    private boolean sequencial(String pin) {

        boolean crescente = true;
        boolean decrescente = true;

        for (int i = 1; i < pin.length(); i++) {

            int anterior = pin.charAt(i - 1);
            int atual = pin.charAt(i);

            if (atual != anterior + 1) {
                crescente = false;
            }

            if (atual != anterior - 1) {
                decrescente = false;
            }
        }

        return crescente || decrescente;
    }
}