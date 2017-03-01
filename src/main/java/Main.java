import javax.swing.*;
import java.io.File;

/**
 * Created by rubenspessoa on 01/03/17.
 */
public class Main {

    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null, "Minha mensagem.");

        JFileChooser fileChooser = new JFileChooser();
        int retorno = fileChooser.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um arquivo.");
        }

    }
}
