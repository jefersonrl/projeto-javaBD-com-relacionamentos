package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ClienteJdbcDAO;
import controller.JdbcUtil;
import model.Cliente;

public class Vendas extends JFrame {
	JLabel lblCliente = new JLabel("Selecione o cliente:");
	JComboBox cboCliente = new JComboBox();
	JLabel lblData = new JLabel("Data:");
	JTextField txtData = new JTextField();
	JLabel lblValorTotal = new JLabel("Valor Total");
	JTextField txtValorTotal = new JTextField();
	JLabel lblDesconto = new JLabel("Desconto");
	JTextField txtDesconto = new JTextField();
	JLabel lblValorPago = new JLabel("Valor Pago");
	JTextField txtValorPago = new JTextField();
	JButton btnCadastrarVenda = new JButton("Cadastrar Venda");

	public Vendas() {
		super("Sistema - Cadastro de Vendas");

		Container paine = this.getContentPane();
		paine.setLayout(null);

		lblCliente.setBounds(20, 20, 150, 20);
		paine.add(lblCliente);

		cboCliente.setBounds(160, 20, 150, 20);
		paine.add(cboCliente);

		cboCliente.addItem("");

		try {

			Connection connection = JdbcUtil.getConnection();
			ClienteJdbcDAO clienteJdbcDao = new ClienteJdbcDAO(connection);

			List<Cliente> cli = clienteJdbcDao.listar();

			for (int i = 0; i < cli.size(); i++) {
				cboCliente.addItem(cli.get(0).getNome());
			}
			
		lblData.setBounds(20, 50, 150, 20);
		paine.add(lblData);
		
		txtData.setBounds(160, 50, 150, 20);
		paine.add(txtData);
		
		lblValorTotal.setBounds(20, 80, 150, 20);
		paine.add(lblValorTotal);
		
		txtValorTotal.setBounds(160, 80, 150, 20);
		paine.add(txtValorTotal);
		
		lblValorPago.setBounds(20, 110, 150, 20);
		paine.add(lblValorPago);
		
		txtValorPago.setBounds(160, 110, 150, 20);
		paine.add(txtValorPago);
		
		btnCadastrarVenda.setBounds(100, 160, 150, 50);
		paine.add(btnCadastrarVenda);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 300);
	}

	public static void main(String args[]) {
		Vendas vendas = new Vendas();
	}
}
