/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

    private JTextField txtCodigo, txtNombres, txtApellidos, txtTelefono, txtCorreo, txtDireccion, txtPostal;
    private JTextField txtBuscar;
    private JTextArea areaResultados;
    private JButton btnInsertar, btnBuscar;

    private HashTableLineal hashLineal = new HashTableLineal(50);
    private HashTableEncadenamiento hashEncadenado = new HashTableEncadenamiento(50);

    public VentanaPrincipal() {
        setTitle("Comparación de Hashing - Clientes");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // Colores y fuente
        Color azulOscuro = new Color(34, 45, 65);
        Color blanco = new Color(245, 245, 245);
        Font fuente = new Font("SansSerif", Font.PLAIN, 14);

        // Panel Principal
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(blanco);

        // Panel izquierdo: resultados
        areaResultados = new JTextArea();
        areaResultados.setFont(fuente);
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);
        scroll.setPreferredSize(new Dimension(400, 0));
        contenedor.add(scroll, BorderLayout.WEST);

        // Panel derecho: formulario y botones
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBackground(blanco);

        JPanel formulario = new JPanel(new GridLayout(8, 2, 10, 10));
        formulario.setBackground(blanco);
        formulario.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));

        txtCodigo = new JTextField(); txtCodigo.setFont(fuente);
        txtNombres = new JTextField(); txtNombres.setFont(fuente);
        txtApellidos = new JTextField(); txtApellidos.setFont(fuente);
        txtTelefono = new JTextField(); txtTelefono.setFont(fuente);
        txtCorreo = new JTextField(); txtCorreo.setFont(fuente);
        txtDireccion = new JTextField(); txtDireccion.setFont(fuente);
        txtPostal = new JTextField(); txtPostal.setFont(fuente);

        formulario.add(new JLabel("Código:")); formulario.add(txtCodigo);
        formulario.add(new JLabel("Nombres:")); formulario.add(txtNombres);
        formulario.add(new JLabel("Apellidos:")); formulario.add(txtApellidos);
        formulario.add(new JLabel("Teléfono:")); formulario.add(txtTelefono);
        formulario.add(new JLabel("Correo:")); formulario.add(txtCorreo);
        formulario.add(new JLabel("Dirección:")); formulario.add(txtDireccion);
        formulario.add(new JLabel("Código Postal:")); formulario.add(txtPostal);

        btnInsertar = new JButton("Insertar Cliente");
        btnInsertar.setBackground(azulOscuro);
        btnInsertar.setForeground(Color.WHITE);
        btnInsertar.setFont(fuente);
        btnInsertar.addActionListener(e -> insertarCliente());

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(blanco);
        panelBoton.add(btnInsertar);

        panelDerecho.add(formulario, BorderLayout.CENTER);
        panelDerecho.add(panelBoton, BorderLayout.SOUTH);

        contenedor.add(panelDerecho, BorderLayout.CENTER);

        // Panel inferior: búsqueda
        JPanel panelBuscar = new JPanel(new BorderLayout());
        panelBuscar.setBorder(BorderFactory.createTitledBorder("Buscar por Nombre Completo"));
        panelBuscar.setBackground(blanco);

        txtBuscar = new JTextField(); txtBuscar.setFont(fuente);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(fuente);
        btnBuscar.setBackground(azulOscuro);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.addActionListener(e -> buscarCliente());

        panelBuscar.add(txtBuscar, BorderLayout.CENTER);
        panelBuscar.add(btnBuscar, BorderLayout.EAST);

        contenedor.add(panelBuscar, BorderLayout.SOUTH);

        add(contenedor);
    }

    private void insertarCliente() {
        Cliente cliente = new Cliente(
            txtCodigo.getText(),
            txtNombres.getText(),
            txtApellidos.getText(),
            txtTelefono.getText(),
            txtCorreo.getText(),
            txtDireccion.getText(),
            txtPostal.getText()
        );

        long tiempo1 = System.nanoTime();
        hashLineal.insertar(cliente);
        long tiempo2 = System.nanoTime();
        long duracionLineal = tiempo2 - tiempo1;

        long tiempo3 = System.nanoTime();
        hashEncadenado.insertar(cliente);
        long tiempo4 = System.nanoTime();
        long duracionEncadenado = tiempo4 - tiempo3;

        areaResultados.append("Cliente insertado con éxito.\n");
        areaResultados.append("Tiempo Hash Lineal: " + duracionLineal + " ns\n");
        areaResultados.append("Tiempo Hash Encadenado: " + duracionEncadenado + " ns\n\n");

        limpiarCampos();
    }

    private void buscarCliente() {
        String nombreCompleto = txtBuscar.getText().trim();

        long tiempo1 = System.nanoTime();
        Cliente cliente1 = hashLineal.buscar(nombreCompleto);
        long tiempo2 = System.nanoTime();

        long tiempo3 = System.nanoTime();
        Cliente cliente2 = hashEncadenado.buscar(nombreCompleto);
        long tiempo4 = System.nanoTime();

        areaResultados.append(">> Resultados de búsqueda para: " + nombreCompleto + "\n");

        if (cliente1 != null)
            areaResultados.append("Método Lineal: " + cliente1 + " (" + (tiempo2 - tiempo1) + " ns)\n");
        else
            areaResultados.append("Método Lineal: No encontrado\n");

        if (cliente2 != null)
            areaResultados.append("Método Encadenado: " + cliente2 + " (" + (tiempo4 - tiempo3) + " ns)\n");
        else
            areaResultados.append("Método Encadenado: No encontrado\n");

        areaResultados.append("\n");
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtPostal.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
