package pack;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JFrameApp extends JFrame {

	private JPanel contentPane;
	private JTextField txtDomacin;
	private JTextField txtGost;
	private JTextField txtDomacinGol;
	private JTextField txtGostGol;
	private JTextField txtZuti;
	private JTextField txtCrveni;
	private JTextField txtBrojKaznenih;
	private JTextField txtImeSudije;
	private JTextField txtImeSud;
	private JTextField txtDomacin1;
	private JTextField txtGost1;
	private JTextField txtInfo;
	
	public static File f = new File("fajlovi/Utakmice.txt");
	
	private static ArrayList<Utakmica> listaU = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameApp frame = new JFrameApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		PopunjavanjeListe();
	}
	
	public static void PopunjavanjeListe() {
		try {
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String dom = sc.nextLine();
			String gos = sc.nextLine();
			int domG = Integer.parseInt(sc.nextLine());
			int gosG = Integer.parseInt(sc.nextLine());
			int brZ = Integer.parseInt(sc.nextLine());
			int brC = Integer.parseInt(sc.nextLine());
			int brK = Integer.parseInt(sc.nextLine());
			String sud = sc.nextLine();
			String razmak = sc.nextLine();
			
			Utakmica u = new Utakmica(dom, gos, domG, gosG, brZ, brC, brK, sud);
			listaU.add(u);
		}
		sc.close();
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public JFrameApp() {
		setResizable(false);
		setTitle("PRIJAVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 400, 410, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panelPrijava = new JPanel();
		panelPrijava.setBounds(0, 0, 410, 180);
		contentPane.add(panelPrijava);
		panelPrijava.setLayout(null);
		
		final JPanel panelSudija = new JPanel();
		panelSudija.setBounds(0, 0, 658, 370);
		contentPane.add(panelSudija);
		panelSudija.setLayout(null);
		panelSudija.hide();
		
		final JPanel panelSekretar = new JPanel();
		panelSekretar.setBounds(0, 0, 640, 310);
		contentPane.add(panelSekretar);
		panelSekretar.setLayout(null);
		panelSekretar.hide();
		
		final JPanel panelEdit = new JPanel();
		panelEdit.setBounds(0, 0, 400, 280);
		contentPane.add(panelEdit);
		panelEdit.setLayout(null);
		panelEdit.hide();
		
		
		//Panel prijava
		
		
		JButton btnSudija = new JButton("SUDIJA");
		btnSudija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(700, 400, 658, 370);
				setTitle("SUDIJA");
				panelPrijava.hide();
				panelSudija.show();
			}
		});
		btnSudija.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnSudija.setBounds(20, 80, 170, 40);
		panelPrijava.add(btnSudija);
		
		JLabel lblTitle = new JLabel("Prijavi se kao:");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle.setBounds(130, 30, 160, 25);
		panelPrijava.add(lblTitle);
		
		JButton btnSekretar = new JButton("SEKRETAR");
		btnSekretar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(700, 400,640, 310);
				setTitle("SEKRETAR");
				panelPrijava.hide();
				panelSekretar.show();
			}
		});
		btnSekretar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnSekretar.setBounds(200, 80, 170, 40);
		panelPrijava.add(btnSekretar);
		
		//Panel Sudija
		
		JLabel lblDomacaEkipa = new JLabel("Domaća ekipa:");
		lblDomacaEkipa.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDomacaEkipa.setBounds(29, 40, 100, 14);
		panelSudija.add(lblDomacaEkipa);
		
		JLabel lblGostujucaEkipa = new JLabel("Gostujuća ekipa:");
		lblGostujucaEkipa.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGostujucaEkipa.setBounds(29, 65, 120, 14);
		panelSudija.add(lblGostujucaEkipa);
		
		JLabel lblGoloviDomacina = new JLabel("Golovi domaćina:");
		lblGoloviDomacina.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGoloviDomacina.setBounds(29, 90, 100, 14);
		panelSudija.add(lblGoloviDomacina);
		
		JLabel lblGoloviGosta = new JLabel("Golovi gosta:");
		lblGoloviGosta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGoloviGosta.setBounds(29, 115, 100, 14);
		panelSudija.add(lblGoloviGosta);
		
		JLabel lblBrojZutih = new JLabel("Broj žutih kartona:");
		lblBrojZutih.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBrojZutih.setBounds(29, 140, 130, 14);
		panelSudija.add(lblBrojZutih);
		
		JLabel lblBrojCrvenih = new JLabel("Broj crvenih kartona:");
		lblBrojCrvenih.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBrojCrvenih.setBounds(29, 165, 130, 14);
		panelSudija.add(lblBrojCrvenih);
		
		final JCheckBox chckbxKazneni = new JCheckBox("Kazneni udarci");
		chckbxKazneni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxKazneni.isSelected())
					txtBrojKaznenih.setEditable(true);
				else
					txtBrojKaznenih.setEditable(false);
			}
		});
		chckbxKazneni.setFont(new Font("Times New Roman", Font.BOLD, 13));
		chckbxKazneni.setBounds(29, 186, 120, 23);
		panelSudija.add(chckbxKazneni);
		
		JLabel lblBrojKaznenih = new JLabel("Broj kaznenih udaraca:");
		lblBrojKaznenih.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBrojKaznenih.setBounds(29, 217, 130, 14);
		panelSudija.add(lblBrojKaznenih);
		
		JLabel lblImeSudije = new JLabel("Unesite vaše ime i prezime:");
		lblImeSudije.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblImeSudije.setBounds(29, 247, 150, 14);
		panelSudija.add(lblImeSudije);
		
		txtDomacin = new JTextField();
		txtDomacin.setBounds(155, 37, 127, 20);
		panelSudija.add(txtDomacin);
		txtDomacin.setColumns(10);
		
		txtGost = new JTextField();
		txtGost.setColumns(10);
		txtGost.setBounds(155, 62, 127, 20);
		panelSudija.add(txtGost);
		
		txtDomacinGol = new JTextField();
		txtDomacinGol.setColumns(10);
		txtDomacinGol.setBounds(155, 87, 41, 20);
		panelSudija.add(txtDomacinGol);
		
		txtGostGol = new JTextField();
		txtGostGol.setColumns(10);
		txtGostGol.setBounds(155, 112, 41, 20);
		panelSudija.add(txtGostGol);
		
		txtZuti = new JTextField();
		txtZuti.setColumns(10);
		txtZuti.setBounds(155, 137, 41, 20);
		panelSudija.add(txtZuti);
		
		txtCrveni = new JTextField();
		txtCrveni.setColumns(10);
		txtCrveni.setBounds(155, 162, 41, 20);
		panelSudija.add(txtCrveni);
		
		txtBrojKaznenih = new JTextField();
		txtBrojKaznenih.setEditable(false);
		txtBrojKaznenih.setColumns(10);
		txtBrojKaznenih.setBounds(155, 214, 41, 20);
		panelSudija.add(txtBrojKaznenih);
		
		txtImeSudije = new JTextField();
		txtImeSudije.setBounds(185, 241, 127, 20);
		panelSudija.add(txtImeSudije);
		txtImeSudije.setColumns(10);
		
		JScrollPane scrpaneStatistika = new JScrollPane();
		scrpaneStatistika.setBounds(320, 38, 300, 200);
		panelSudija.add(scrpaneStatistika);
		
		final JTextArea textAreaStatistika = new JTextArea();
		textAreaStatistika.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textAreaStatistika.setEditable(false);
		scrpaneStatistika.setViewportView(textAreaStatistika);
		
		JButton btnPocetna = new JButton("POCETNA");
		btnPocetna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(700, 400, 410, 180);
				setTitle("PRIJAVA");
				panelSudija.hide();
				panelPrijava.show();
				txtDomacin.setText("");
				txtGost.setText("");
				txtDomacinGol.setText("");
				txtGostGol.setText("");
				txtZuti.setText("");
				txtCrveni.setText("");
				txtBrojKaznenih.setText("");
				txtImeSudije.setText("");
				textAreaStatistika.setText("");
			}
		});
		btnPocetna.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnPocetna.setBounds(10, 5, 90, 25);
		panelSudija.add(btnPocetna);
		
		JButton btnDodaj = new JButton("DODAJ");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dom = txtDomacin.getText().trim();
					String gos = txtGost.getText().trim();
					int golD = Integer.parseInt(txtDomacinGol.getText().trim());
					int golG = Integer.parseInt(txtGostGol.getText().trim());
					int brZut = Integer.parseInt(txtZuti.getText().trim());
					int brCrv = Integer.parseInt(txtCrveni.getText().trim());
					int brKaz = 0;
					if(txtBrojKaznenih.isEditable())
					{
						brKaz = Integer.parseInt(txtBrojKaznenih.getText().trim());
					}
					String sud = txtImeSudije.getText().trim();
					if(dom.equals("") || gos.equals("") || sud.equals("")) {
						throw new Exception();
					}
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(new FileWriter(f, true));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Neuspešno otvaranje fajla 'fajlovi/SklopljeniRacunar.txt'!");
					}
					listaU.add(new Utakmica(dom,gos,golD,golG,brZut,brCrv,brKaz,sud));
					pw.println(dom);
					pw.println(gos);
					pw.println(golD);
					pw.println(golG);
					pw.println(brZut);
					pw.println(brCrv);
					pw.println(brKaz);
					pw.println(sud);
					pw.println("");
					pw.close();
					txtDomacin.setText("");
					txtGost.setText("");
					txtDomacinGol.setText("");
					txtGostGol.setText("");
					txtZuti.setText("");
					txtCrveni.setText("");
					txtBrojKaznenih.setText("");
					txtImeSudije.setText("");
					JOptionPane.showMessageDialog(null, "Uspešno ste uneli podatke o utakmici: " + dom +" protiv "+ gos);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Neispravan unos podataka o utakmici!");
				}
			}
		});
		btnDodaj.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDodaj.setBounds(30, 278, 105, 42);
		panelSudija.add(btnDodaj);
		
		JButton btnPregledUtakmica = new JButton("PREGLED UTAKMICA");
		btnPregledUtakmica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaStatistika.setText("");
					String dom = txtDomacin.getText().toLowerCase();
					String gos = txtGost.getText().toLowerCase();
					int br=0;
					for(Utakmica u : listaU) {
						if(u.getDomEkipa().toLowerCase().equals(dom) && u.getGostEkipa().toLowerCase().equals(gos)) {
							textAreaStatistika.append(u.toString());
							txtDomacin.setText("");
							txtGost.setText("");
							break;
						}
						br++;
					}
					if(br>=listaU.size()) {
						JOptionPane.showMessageDialog(null, "Da biste videli podatke o utakmici unesiti imena domaće i gostujuće ekipe.");

					}
					} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Da biste videli podatke o utakmici unesiti imena domaće i gostujuće ekipe.");
				}
			}
		});
		btnPregledUtakmica.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPregledUtakmica.setBounds(140, 278,  180, 42);
		panelSudija.add(btnPregledUtakmica);
		
		
		
		JButton btnStatistika = new JButton("STATISTIKA");
		btnStatistika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				textAreaStatistika.setText("");
				String imeSud = txtImeSudije.getText().toLowerCase();
				String[] imePodeljeno = new String[2];
				imePodeljeno = imeSud.split(" ");
				Sudija s = new Sudija(imePodeljeno[0], imePodeljeno[1]);
				int[] zut = new int[10];
				int[] crv = new int[10];
				int[] kaz = new int[10];
				int br = 0,br1=0;
				for(Utakmica u : listaU) {
					if(u.getImeSudije().toLowerCase().equals(imeSud) && br1<listaU.size()) {
						textAreaStatistika.append(u.toString());
						zut[br] = u.getBrZuti();
						crv[br] = u.getBrCrveni();
						kaz[br] = u.getBrKazneni();
						br++;
					}
					br1++;
				}
				if(br1>=listaU.size() && br<=0)
				{
					JOptionPane.showMessageDialog(null, "Željeni sudija nije u bazi podataka!");
				}else{
				textAreaStatistika.append("Prosečan broj žutih kartona po utakmici: "+s.AvgZuti(zut, br) + "\n");
				textAreaStatistika.append("Prosečan broj crvenih kartona po utakmici: "+s.AvgCrv(crv, br) + "\n");
				textAreaStatistika.append("Prosečan broj kaznenih udaraca po utakmici: "+s.AvgKaz(kaz, br) + "\n");
				}
				txtImeSudije.setText("");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Proverite ime sudije!");
				}
			}
		});
		btnStatistika.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStatistika.setBounds(500, 248, 120, 42);
		panelSudija.add(btnStatistika);
		
		
		//Panel Sekretar
		
		JLabel lblImeSud = new JLabel("Ime i prezime sudije:");
		lblImeSud.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblImeSud.setBounds(10, 40, 120, 14);
		panelSekretar.add(lblImeSud);
		
		JLabel lblDomacaEkipa1 = new JLabel("Domaća ekipa:");
		lblDomacaEkipa1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDomacaEkipa1.setBounds(10, 147, 100, 14);
		panelSekretar.add(lblDomacaEkipa1);
		
		JLabel lblGostujucaEkipa1 = new JLabel("Gostujuća ekipa:");
		lblGostujucaEkipa1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGostujucaEkipa1.setBounds(10, 172, 120, 14);
		panelSekretar.add(lblGostujucaEkipa1);
		
		JScrollPane scrpaneSudije = new JScrollPane();
		scrpaneSudije.setBounds(300, 26, 300, 225);
		panelSekretar.add(scrpaneSudije);
		
		final JTextArea textAreaSudije = new JTextArea();
		textAreaSudije.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textAreaSudije.setEditable(false);
		scrpaneSudije.setViewportView(textAreaSudije);
		
		txtImeSud = new JTextField();
		txtImeSud.setColumns(10);
		txtImeSud.setBounds(130, 38, 130, 20);
		panelSekretar.add(txtImeSud);
		
		txtDomacin1 = new JTextField();
		txtDomacin1.setBounds(110, 145, 127, 20);
		panelSekretar.add(txtDomacin1);
		txtDomacin1.setColumns(10);
		
		txtGost1 = new JTextField();
		txtGost1.setColumns(10);
		txtGost1.setBounds(110, 170, 127, 20);
		panelSekretar.add(txtGost1);
		
		JButton btnPregledSudije = new JButton("PREGLED SUDIJE");
		btnPregledSudije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaSudije.setText("");
					String imeSud = txtImeSud.getText().toLowerCase();
					String[] imePodeljeno = new String[2];
					imePodeljeno = imeSud.split(" ");
					Sudija s = new Sudija(imePodeljeno[0], imePodeljeno[1]);
					int[] zut = new int[10];
					int[] crv = new int[10];
					int[] kaz = new int[10];
					int br = 0,br1=0;
					for(Utakmica u : listaU) {
						if(u.getImeSudije().toLowerCase().equals(imeSud) && br1<listaU.size()) {
							textAreaSudije.append(u.toString());
							zut[br] = u.getBrZuti();
							crv[br] = u.getBrCrveni();
							kaz[br] = u.getBrKazneni();
							br++;
						}
						br1++;
					}
					if(br1>=listaU.size() && br<=0)
					{
						JOptionPane.showMessageDialog(null, "Željeni sudija nije u bazi podataka!");
					}else{
						textAreaSudije.append("Prosečan broj žutih kartona po utakmici: "+s.AvgZuti(zut, br) + "\n");
						textAreaSudije.append("Prosečan broj crvenih kartona po utakmici: "+s.AvgCrv(crv, br) + "\n");
						textAreaSudije.append("Prosečan broj kaznenih udaraca po utakmici: "+s.AvgKaz(kaz, br) + "\n");
					}
					txtImeSud.setText("");
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Proverite ime sudije!");
					}
			}
		});
		btnPregledSudije.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnPregledSudije.setBounds(10, 70, 150, 45);
		panelSekretar.add(btnPregledSudije);
		
		JButton btnPocetna1 = new JButton("POCETNA");
		btnPocetna1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(700, 400, 410, 180);
				setTitle("PRIJAVA");
				panelSekretar.hide();
				panelPrijava.show();
			}
		});
		btnPocetna1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnPocetna1.setBounds(10, 5, 90, 25);
		panelSekretar.add(btnPocetna1);
		
		JButton btnPregledUtakmice1 = new JButton("PREGLED UTAKMICE");
		btnPregledUtakmice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaSudije.setText("");
					String dom = txtDomacin1.getText().toLowerCase();
					String gos = txtGost1.getText().toLowerCase();
					int br=0;
					for(Utakmica u : listaU) {
						if(u.getDomEkipa().toLowerCase().equals(dom) && u.getGostEkipa().toLowerCase().equals(gos)) {
							textAreaSudije.append(u.toString());
							txtDomacin1.setText("");
							txtGost1.setText("");
							break;
						}
						br++;
					}
					if(br>=listaU.size()) {
						JOptionPane.showMessageDialog(null, "Da biste videli podatke o utakmici unesiti imena domaće i gostujuće ekipe.");

					}
					} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Da biste videli podatke o utakmici unesiti imena domaće i gostujuće ekipe.");
				}
			
			}
		});
		btnPregledUtakmice1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnPregledUtakmice1.setBounds(10, 202, 150, 45);
		panelSekretar.add(btnPregledUtakmice1);
		
		JButton btnIspravi = new JButton("EDITUJ");
		btnIspravi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(700, 400, 400, 280);
				setTitle("EDITOR");
				panelSekretar.hide();
				panelEdit.show();
			}
		});
		btnIspravi.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnIspravi.setBounds(169, 202, 100, 45);
		panelSekretar.add(btnIspravi);
		
		//Panel Edit
		
		JLabel lblIzaberiUtakmicu = new JLabel("Izaberite utakmicu:");
		lblIzaberiUtakmicu.setBounds(40, 35, 130, 14);
		lblIzaberiUtakmicu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panelEdit.add(lblIzaberiUtakmicu);
		
		JLabel lblIzaberiPromenu = new JLabel("Izaberite podatak za promenu:");
		lblIzaberiPromenu.setBounds(15, 78, 180, 14);
		lblIzaberiPromenu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panelEdit.add(lblIzaberiPromenu);
		
		final Choice chIzborU = new Choice();
		chIzborU.setBounds(170, 31, 180, 20);
		chIzborU.setFont(new Font("Times New Roman", Font.BOLD, 14));
		for(int i = 0; i < listaU.size(); i++) {
			chIzborU.add(listaU.get(i).getDomEkipa() +"-"+ listaU.get(i).getGostEkipa());
		}
		panelEdit.add(chIzborU);
		
		final Choice chIzborP = new Choice();
		chIzborP.setBounds(195, 74, 160, 20);
		chIzborP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		chIzborP.add("Golovi domaćina");
		chIzborP.add("Golovi gosta");
		chIzborP.add("Broj žutih kartona");
		chIzborP.add("Broj crvenih kartona");
		chIzborP.add("Broj kaznenih udaraca");
		chIzborP.add("Ime sudije");
		panelEdit.add(chIzborP);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(140, 135, 100, 20);
		txtInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panelEdit.add(txtInfo);
		txtInfo.setColumns(10);
		
		JLabel lblInfo = new JLabel("Unesite podatak:");
		lblInfo.setBounds(135, 115, 120, 14);
		lblInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panelEdit.add(lblInfo);
		
		JButton btnIzmeni = new JButton("IZMENI");
		btnIzmeni.setBounds(135, 160, 110, 35);
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utakmica pom = null;
				try {
					String imeU = chIzborU.getSelectedItem().toString().toLowerCase();
					String[] imeUPod = new String[2];
					imeUPod = imeU.split("-");
					for(Utakmica u : listaU) {
						if(u.getDomEkipa().toLowerCase().equals(imeUPod[0]) && u.getGostEkipa().toLowerCase().equals(imeUPod[1])) {
							pom = u;
						}
					}
					switch(chIzborP.getSelectedItem().toString().toLowerCase()) {
					case "golovi domaćina":
						pom.setDomGol(Integer.parseInt(txtInfo.getText()));
						break;
					case "golovi gosta":
						pom.setGostGol(Integer.parseInt(txtInfo.getText()));
						break;
					case "broj žutih kartona":
						pom.setBrZuti(Integer.parseInt(txtInfo.getText()));
						break;
					case "broj crvenih kartona":
						pom.setBrCrveni(Integer.parseInt(txtInfo.getText()));
						break;
					case "broj kaznenih udaraca":
						pom.setBrKazneni(Integer.parseInt(txtInfo.getText()));
						break;
					case "ime sudije":
						pom.setImeSudije(txtInfo.getText());
						break;
					default:
						JOptionPane.showMessageDialog(null, "Greška u switchu!");
					}
					for(Utakmica u : listaU) {
						if(u.getDomEkipa().toLowerCase().equals(imeUPod[1]) && u.getGostEkipa().toLowerCase().equals(imeUPod[2])) {
							u = pom;
						}
					}
					
					if(f.delete()) {
					}else {
						JOptionPane.showMessageDialog(null, "Neuspešno brisanje fajla 'fajlovi/Utakmice.txt'!");
					}
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(new FileWriter(f, true));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Neuspešno otvaranje fajla 'fajlovi/Utakmice.txt'!");
					}
					for(Utakmica u : listaU)
					{
						pw.println(u.getDomEkipa());
						pw.println(u.getGostEkipa());
						pw.println(u.getDomGol());
						pw.println(u.getGostGol());
						pw.println(u.getBrZuti());
						pw.println(u.getBrCrveni());
						pw.println(u.getBrKazneni());
						pw.println(u.getImeSudije());
						pw.println("");
					}
					pw.close();
					txtInfo.setText("");
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Neuspešno editovanje datoteke!");
				}
			}
		});
		btnIzmeni.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panelEdit.add(btnIzmeni);
		
		JButton btnNazad = new JButton("NAZAD");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(700, 400, 640, 310);
				setTitle("SEKRETAR");
				panelEdit.hide();
				panelSekretar.show();
			}
		});
		btnNazad.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnNazad.setBounds(145, 200, 90, 25);
		panelEdit.add(btnNazad);
		
	}
	
}
