import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class Ventana {
    private JPanel panel1;
    private JTextField txtFieldCedula;
    private JComboBox cboPeliculas;
    private JButton btnPagar;
    private JComboBox cboCantEntradas;
    private JTextArea txtAreaInfoPeliculas;
    private JTextArea txtAreaInfoCliente;
    private JTextField txtFNombre;
    private JTextArea txtAreaDisponibilidad;
    int entradasCompradasPirata = 0;
    int entradasCompradasNaruto = 0;
    int entradasCompradasAntman = 0;
    Queue<Integer> cedulas = new LinkedList<>();



    public Ventana() {

        for(int i=1; i<=5; i++){
            cboCantEntradas.addItem(i);
        }


        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try {
                    String nombre = txtFNombre.getText();
                    int cedulaActual = Integer.parseInt(txtFieldCedula.getText());
                    String peliculaElegida = cboPeliculas.getSelectedItem().toString();
                    int cantidad = (int) cboCantEntradas.getSelectedItem();


                    if (nombre.isEmpty()){
                        JOptionPane.showMessageDialog(null, "No ha ingreso un nombre");
                        return;
                    }

                    String cedulaString = String.valueOf(cedulaActual);
                    if (cedulaString.length() != 10) {
                        JOptionPane.showMessageDialog(null, "La cedula no contiene los 10 digitos");
                        return;
                    }

                    if (cedulas.contains(cedulaActual)) {
                        JOptionPane.showMessageDialog(null, "Esa cedula ya ha sido ingresada");
                        return;
                    }
                    cedulas.add(cedulaActual);

                    switch (peliculaElegida) {
                        case "Piratas":
                            if (entradasCompradasPirata + cantidad > 17) {
                                JOptionPane.showMessageDialog(null, "No hay capacidad disponible para Piratas");
                                return;
                            }
                            entradasCompradasPirata += cantidad;
                            break;

                        case "Naruto":
                            if (entradasCompradasNaruto + cantidad > 17) {
                                JOptionPane.showMessageDialog(null, "No hay capacidad disponible para Naruto");
                                return;
                            }
                            entradasCompradasNaruto += cantidad;
                            break;

                        case "Antman":
                            if (entradasCompradasAntman + cantidad > 17) {
                                JOptionPane.showMessageDialog(null, "No hay capacidad disponible para Antman");
                                return;
                            }
                            entradasCompradasAntman += cantidad;
                            break;
                    }

                    Cliente cliente = new Cliente(cedulaActual, nombre, cantidad);

                    int recaudadoTotal = (entradasCompradasAntman + entradasCompradasNaruto + entradasCompradasPirata) * 5;

                    txtAreaInfoCliente.setText("");
                    txtAreaInfoCliente.append("Información Cliente:\n" +
                            " Nombre: " + cliente.getNombre() +
                            "\n Cedula: " + cliente.getCedula() +
                            "\n Entradas compradas: " + cliente.getCantidadentradas());


                    txtAreaInfoPeliculas.setText("");
                    txtAreaInfoPeliculas.append("Recaudado por Pelicula:\n" +
                            " -Piratas: $" + entradasCompradasPirata * 5 +
                            "\n -Naturo : $" + entradasCompradasNaruto * 5 +
                            "\n -Antman  : $" + entradasCompradasAntman * 5 +
                            "\n  Recaudado total: $" + recaudadoTotal);



                    txtAreaDisponibilidad.setText("");
                    txtAreaDisponibilidad.append("Asientos disponibles: \n" +
                            "Piratas = " + (17 - entradasCompradasPirata) +
                            "\n Naruto = " + (17-entradasCompradasNaruto) +
                            "\n Atman = " + (17-entradasCompradasAntman));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cédula no valida");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
