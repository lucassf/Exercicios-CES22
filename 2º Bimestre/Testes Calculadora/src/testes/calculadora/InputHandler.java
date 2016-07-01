package testes.calculadora;

public class InputHandler {

    private String input;
    private boolean signed;

    public InputHandler() {
        ResetInput();
    }

    // Adiciona o caractere a no final da string que representa a entrada se esta
    // inserção for válida. Senão, a string não é modificada.
    public void setInput(char a) {
        if (a == 'u') {
            if (input.length() > 1) {
                input = input.substring(0, input.length() - 1);
            } else {
                input = "0";
            }
        } else if (a == '-') {
            signed = !signed;
        } else if (input.length() == 1 && input.charAt(0) == '0' && a != '.') {
            input = String.valueOf(a);
        } else if (VerifyInput(input + a)) {
            input += a;
        }
        if (input.equals("0") || input.equals("0.")) {
            signed = false;
        }
    }

    // Retorna a entrada filtrada, exibindo o sinal negativo caso o usuário tenha
    // solicitado a inversão de sinal.
    public String getInput() {
        return (signed ? "-" : "") + input;
    }

    // Reseta a entrada para o valor "0" e define o sinal como sendo positivo.
    public void ResetInput() {
        input = "0";
        signed = false;
    }

    // Limita a entrada para no máximo 9 caracteres e verifica se há mais de uma
    // casa decimal.
    private boolean VerifyInput(String input) {
        boolean verify = true;
        if (input.length() > 9) {
            verify = false;
        }
        try {
            double u = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            verify = false;
        }
        return verify;
    }
}
