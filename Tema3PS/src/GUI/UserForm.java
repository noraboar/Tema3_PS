package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import BL.BiletManager;
import BL.Exporter;
import BL.ExporterFactory;
import BL.SpectacolManager;
import Models.Bilet;
import Models.Spectacol;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UserForm {

	public JFrame frame;
	private JLabel background;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<String> comboBox_1;
	private JComboBox<Bilet> comboBox;
	private JButton btnAdaugaBilet;
	private JButton btnLogOut;
	private JButton btnExportCsv;
	private JButton btnExportJson;
	
	private BiletManager biletManager=new BiletManager();
	private SpectacolManager spectacolManager=new SpectacolManager();
	private ExporterFactory exporterFactory = new ExporterFactory();
	
	/**
	 * Create the application.
	 */
	public UserForm() {
		initialize();
		initActions();
		addToComboBox();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBox = new JComboBox<Bilet>();
		comboBox.setBounds(85, 40, 460, 45);
		frame.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(303, 190, 230, 35);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 250, 230, 35);
		frame.getContentPane().add(textField_2);
		
		btnAdaugaBilet = new JButton("Adauga bilet");
		btnAdaugaBilet.setBounds(303, 310, 230, 40);
		frame.getContentPane().add(btnAdaugaBilet);
		
		JLabel lblTitlulSpectacolului = new JLabel("Titlul spectacolului");
		lblTitlulSpectacolului.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitlulSpectacolului.setForeground(Color.RED);
		lblTitlulSpectacolului.setBounds(116, 120, 181, 50);
		frame.getContentPane().add(lblTitlulSpectacolului);
		
		JLabel lblNumarulBiletului = new JLabel("Locul");
		lblNumarulBiletului.setForeground(Color.RED);
		lblNumarulBiletului.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumarulBiletului.setBounds(116, 180, 181, 50);
		frame.getContentPane().add(lblNumarulBiletului);
		
		JLabel lblNumarulRandului = new JLabel("Numarul randului");
		lblNumarulRandului.setForeground(Color.RED);
		lblNumarulRandului.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumarulRandului.setBounds(112, 240, 181, 50);
		frame.getContentPane().add(lblNumarulRandului);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(303, 130, 230, 35);
		frame.getContentPane().add(comboBox_1);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(402, 405, 131, 41);
		frame.getContentPane().add(btnLogOut);
		
		btnExportCsv = new JButton("Export Csv");
		btnExportCsv.setBounds(112, 405, 131, 41);
		frame.getContentPane().add(btnExportCsv);
		
		btnExportJson = new JButton("Export Json");
		btnExportJson.setBounds(258, 405, 131, 41);
		frame.getContentPane().add(btnExportJson);
		
		background = new JLabel(new ImageIcon(getClass().getResource("/GUI/background.png")));
		background.setForeground(Color.RED);
		background.setBounds(0, 0, 634, 479);
		frame.getContentPane().add(background);
	}
	
	public void initActions(){
		btnAdaugaBilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeSpectacolSelectat=(String) comboBox_1.getSelectedItem();
				Bilet bilet=new Bilet(numeSpectacolSelectat,Integer.valueOf(textField_1.getText()),
						Integer.valueOf(textField_2.getText()));
				if(biletManager.addBilet(bilet)==1){
					JOptionPane.showMessageDialog(null,"Locul este deja ocupat.\nIntroduceti alt rand/loc");
				}
				else{
					JOptionPane.showMessageDialog(null,"Biletul a fost introdus cu succes!!!");
					addToComboBox();
				}
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginForm loginForm=new LoginForm();
				loginForm.frame.setVisible(true);
			}
		});
		
		btnExportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportBilete("CSV");
			}
		});
		
		btnExportJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportBilete("JSON");
			}
		});
	}
	
	private void exportBilete(String fileType) {
		List<Bilet> listaBilete = biletManager.getBilete();
		Exporter exporter = exporterFactory.getExporter(fileType);
		exporter.exportBilete(listaBilete);
	}
	
	public void addToComboBox(){
		comboBox.removeAllItems();
		comboBox_1.removeAllItems();
		List<Bilet> listaBilete=biletManager.getBilete();
		List<Spectacol> listaSpectacole=spectacolManager.getSpectacole();
		List<String> uniqueList=new ArrayList<>();
		for(Bilet b:listaBilete){
			comboBox.addItem(b);
			
		}
		for(Spectacol sp:listaSpectacole){
			if(!uniqueList.contains(sp.getTitlul())){
				uniqueList.add(sp.getTitlul());
			}
		}
		for(String s:uniqueList){
			comboBox_1.addItem(s);
		}
	}
}
