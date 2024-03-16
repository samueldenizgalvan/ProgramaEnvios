import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GeneradorContraseñas extends JFrame {
    private JLabel passwordLabel;
    private JButton generateButton;
    private JButton copyButton;

    public GeneradorContraseñas() {
        setTitle("Generador de Contraseñas");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        passwordLabel = new JLabel("Tu contraseña aparecerá aquí");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(passwordLabel);

        generateButton = new JButton("Generar Contraseña");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = generarContraseña(10); // Cambia la longitud según sea necesario
                passwordLabel.setText(password);
            }
        });
        panel.add(generateButton);

        copyButton = new JButton("Copiar Contraseña");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(passwordLabel.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Contraseña copiada al portapapeles");
            }
        });
        panel.add(copyButton);

        add(panel);
        setVisible(true);
    }

    private String generarContraseña(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder contraseña = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            contraseña.append(caracteres.charAt(index));
        }

        return contraseña.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GeneradorContraseñas();
            }
        });
    }
}
