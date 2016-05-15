package GUI;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;






import BL.SpectacolManager;
import BL.UserManager;
import Models.Spectacol;
import Models.User;

public class AdminForm {

	public JFrame frame;
	private JLabel background;
	private JButton btnSpectacolNou;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox<Spectacol> comboBox;
	private JButton btnStergeSpectacol;
	private JButton btnEditareSpectacol;
	private SpectacolManager spectacolManager=new SpectacolManager();
	private UserManager userManager=new UserManager();

	/**
	 * Create the application.
	 */
	public AdminForm() {
		initialize();
		initActions();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Angajat Nou");
		btnNewButton.setBounds(133, 113, 131, 41);
		frame.getContentPane().add(btnNewButton);
		
		btnSpectacolNou = new JButton("Spectacol Nou");
		btnSpectacolNou.setBounds(356, 113, 131, 41);
		frame.getContentPane().add(btnSpectacolNou);
		
		comboBox = new JComboBox<Spectacol>();
		comboBox.setBounds(78, 286, 453, 41);
		addToCombobox();
		frame.getContentPane().add(comboBox);
		
		btnStergeSpectacol = new JButton("Sterge Spectacol");
		btnStergeSpectacol.setBounds(133, 196, 131, 41);
		frame.getContentPane().add(btnStergeSpectacol);
		
		btnEditareSpectacol = new JButton("Editare Spectacol");
		btnEditareSpectacol.setBounds(356, 196, 131, 41);
		frame.getContentPane().add(btnEditareSpectacol);
		
		btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setBounds(473, 405, 131, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		background = new JLabel(new ImageIcon(getClass().getResource("/GUI/background.png")));
		background.setBounds(0, 0, 634, 479);
		frame.getContentPane().add(background);
	}
	
	public void initActions(){
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField nume = new JTextField();
				JTextField username = new JTextField();
				JPasswordField password = new JPasswordField();
				
				Object[] message = {
					    "Nume:", nume,
					    "Username:", username,
					    "Password:", password,
					  };
					int option = JOptionPane.showConfirmDialog(null, message, "Date", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
					User user=new User();
					user.setNume(nume.getText());
					user.setUsername(username.getText());
					user.setPassword(String.valueOf(password.getPassword()));
					userManager.createUser(user);
					}
			}
		});
		
		btnSpectacolNou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField titlul = new JTextField();
				JTextField regia = new JTextField();
				JTextField distributia = new JTextField();
				JTextField data = new JTextField();
				JTextField numarbilete = new JTextField();
				
				Object[] message = {
					    "Titlul:", titlul,
					    "Regia:", regia,
					    "Distributia:", distributia,
					    "Data", data,
					    "Numar Bilete", numarbilete
					  };
					int option = JOptionPane.showConfirmDialog(null, message, "Date", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
					Spectacol spec = new Spectacol();
					spec.setTitlul(titlul.getText());
					spec.setRegia(regia.getText());
					spec.setDistributia(distributia.getText());
					spec.setNumarBilete(Integer.valueOf(numarbilete.getText()));
					spec.setDataPremierei(dateTransform(data.getText()));
					spectacolManager.addSpectacol(spec);
					addToCombobox();
					}
			}
		});
		
		btnStergeSpectacol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spectacol spectacolSelectat = (Spectacol) comboBox
						.getSelectedItem();
				spectacolManager.deleteSpectacol(spectacolSelectat);
				addToCombobox();
			}
		});
		
		btnEditareSpectacol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField titlul = new JTextField();
				titlul.setEditable(false);
				JTextField regia = new JTextField();
				JTextField distributia = new JTextField();
				JTextField data = new JTextField();
				JTextField numarbilete = new JTextField();
				Spectacol spectacolSelectat = (Spectacol) comboBox
						.getSelectedItem();
				titlul.setText(spectacolSelectat.getTitlul());
				System.out.println(spectacolSelectat.getTitlul());
				regia.setText(spectacolSelectat.getRegia());
				distributia.setText(spectacolSelectat.getDistributia());
				data.setText(spectacolSelectat.getDataPremierei().toString());
				numarbilete.setText(String.valueOf(spectacolSelectat.getNumarBilete()));
				
				Object[] message = { "Titlul:", titlul, "Regia:", regia,
						"Distributia:", distributia, "Data", data,
						"Numar Bilete", numarbilete };
				int option = JOptionPane.showConfirmDialog(null, message,
						"Date", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					Spectacol spec = new Spectacol();
					spec.setTitlul(titlul.getText());
					spec.setRegia(regia.getText());
					spec.setDistributia(distributia.getText());
					spec.setNumarBilete(Integer.valueOf(numarbilete.getText()));
					spec.setDataPremierei(dateTransform(data.getText()));
					spectacolManager.updateSpectacol(spectacolSelectat, spec);;
					addToCombobox();
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginForm loginForm=new LoginForm();
				loginForm.frame.setVisible(true);
			}
		});
	}
	
	public void addToCombobox(){
		comboBox.removeAllItems();
		List<Spectacol> listaSpectacole=spectacolManager.getSpectacole();
		for(Spectacol sp:listaSpectacole){
			comboBox.addItem(sp);
		}
	}
	
	public java.sql.Date dateTransform(String data){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed;
        java.sql.Date sql=null;
		try {
			parsed = format.parse(data);
			sql = new java.sql.Date(parsed.getTime());
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Data introdusa incorect");
		}
		return sql;
	}
}
