import java.awt.*; // importa os elementos da interface gráfica
import java.awt.event.*;    // layout, botão, painel etc
import javax.swing.*; // clique nos botões


public class Calculadora {
    public static void main(String[] args) {

        // Criando a Janela e a Tela
        JFrame frame = new JFrame("Calculadora Braba");
        JTextField tela = new JTextField();
        final boolean[] resultShown = { false };

        tela.setFont(new Font("Arial", Font.BOLD, 24));

        tela.setEditable(false); // impede o usuário de digitar
        tela.setHorizontalAlignment(JTextField.RIGHT); // texto alinhado à direita
        

        // Criando os botões
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Montando o painel com os botões
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 4, 5, 5));

        // Criando os botões dinamicamente
        for (String texto : botoes) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 20)); // Font size
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Pega o botão clicado
                    String clickedButton = e.getActionCommand();
                    // Se for o botão C (limpa a tela):
                    if (clickedButton.equals("C")) {
                        tela.setText("");
                    // Se for o '=' (calcula)
                    } else if (clickedButton.equals("=")) {
                        try {
                            String expression = tela.getText();
                            tela.setText("Olha aí a expressão >> " + expression);
                            // Chama a função pra calcular a expressão
                            double result = interpreter(expression);
                            tela.setText(String.valueOf(result));
                            resultShown[0] = true;
                        } catch (Exception ex) {
                            tela.setText("Erro === " + ex);
                        }
                    } else {
                        if (resultShown[0]) {
                            tela.setText(""); // limpa se um result acabou de ser exibido
                            resultShown[0] = false;
                        }
                        tela.setText(tela.getText() + clickedButton);
                    }
                }
            });
            painel.add(btn);
        }

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(tela, BorderLayout.NORTH);
        frame.add(painel, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Avalia uma expressão matemática simples (somente + - * /)
    public static double interpreter(String expr) {
        // `pos` é a **posição atual** na string.
        // `ch` é o **caractere atual** (convertido pra número inteiro).

        try {
            return new Object() {
                int pos = -1, ch;
    
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
    
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
    
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Caracter inesperado: " + (char)ch);
                    return x;
                }
    
                // Expressão -> Termo [+|-] Termo
                double parseExpression() {
                    double x = parseTerm();
                    while (true) {
                        if      (eat('+')) x += parseTerm(); // adição
                        else if (eat('-')) x -= parseTerm(); // subtração
                        else return x;
                    }
                }
    
                // Termo -> Fator [*|/] Fator
                double parseTerm() {
                    double x = parseFactor();
                    while (true) {
                        if (eat('*')) x *= parseFactor(); // multiplicação
                        else if (eat('/')) x /= parseFactor(); // divisão
                        else return x;
                    }
                }
    
                // Fator -> número ou expressão entre parênteses
                double parseFactor() {
                    if (eat('+')) return parseFactor(); // unário +
                    if (eat('-')) return -parseFactor(); // unário -
    
                    double x;
                    int startPos = this.pos;
    
                    if (eat('(')) { // parênteses
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // número
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(expr.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Número inesperado: " + (char)ch);
                    }
    
                    return x;
                }
            }.parse();
        } catch (Exception e) {
            return Double.NaN;
        }
    }
    
    
}
