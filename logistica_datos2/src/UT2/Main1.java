package UT2;

import java.io.*;
import java.util.Date;
import javax.swing.*;

public class Main1 {
    public static void main(String[] args) {
        // Interfaz gráfica para solicitar los datos de envío
        JTextField numeroSeguimientoField = new JTextField(10);
        JTextField destinoField = new JTextField(10);
        JTextField pesoField = new JTextField(10);
        JTextField fechaEnvioField = new JTextField(10);
        JTextField fechaEstimadaEntregaField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Número de Seguimiento:"));
        myPanel.add(numeroSeguimientoField);
        myPanel.add(new JLabel("Destino:"));
        myPanel.add(destinoField);
        myPanel.add(new JLabel("Peso:"));
        myPanel.add(pesoField);
        myPanel.add(new JLabel("Fecha de Envío (DD/MM/YYYY):"));
        myPanel.add(fechaEnvioField);
        myPanel.add(new JLabel("Fecha Estimada de Entrega (DD/MM/YYYY):"));
        myPanel.add(fechaEstimadaEntregaField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Introduce los datos del envío",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Obtener los datos introducidos por el usuario
                String numeroSeguimiento = numeroSeguimientoField.getText();
                String destino = destinoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                Date fechaEnvio = new Date(fechaEnvioField.getText());
                Date fechaEstimadaEntrega = new Date(fechaEstimadaEntregaField.getText());

                // Crear un objeto Envio con los datos introducidos
                Envio envio = new Envio(numeroSeguimiento, destino, peso, fechaEnvio, fechaEstimadaEntrega);

                // Guardar el objeto Envio en un archivo de objetos
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("nombreenvios.dat"));
                outputStream.writeObject(envio);
                outputStream.close();

                JOptionPane.showMessageDialog(null, "Envío guardado correctamente en nombreenvios.dat");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el envío: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
