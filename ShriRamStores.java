import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.File;
import javax.swing.table.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShriRamStores extends JFrame implements ActionListener  
{
	//Classes
	
	Items newItem  = new Items();
	ItemList itemL = new ItemList();
	Staff newStaff = new Staff();
	StaffList staffL = new StaffList();
	ReStock newReStock = new ReStock();
	ReStockList reStockL = new ReStockList();
	Banking newBanking = new Banking();
	BankingList bankingL = new BankingList();
	Sales newSale = new Sales();
	SalesList salesL = new SalesList();

	//Panels	
	
	JPanel loginPanel = new JPanel(null);
	JPanel homePanel = new JPanel(null); 
	JPanel itemsPanel = new JPanel(null);
	JPanel reStockListPanel = new JPanel(null);
	JPanel salesPanel = new JPanel(null);
	JPanel reportPanel = new JPanel(null);
	JPanel bankingPanel = new JPanel(null);
	JPanel staffPanel = new JPanel(null);
	JPanel settingsPanel = new JPanel(null);
	JPanel reportViewPanel = new JPanel(null);
	JPanel forgottonPasswordPanel = new JPanel(null);

	//Logo
	
	JLabel jlbLogo = new JLabel();
	
	//Login Components
	
 	JLabel jlbUsernameLogin = new JLabel();
	JLabel jlbPasswordLogin  = new JLabel();
	JTextField jtfUsernameLogin = new JTextField();
	JPasswordField jpfPasswordLogin = new JPasswordField();
	JButton jbtSubmitLogin = new JButton();
	JLabel jlbTitleLogin = new JLabel();
	JButton jbtForgottonPasswordLogin = new JButton();
	JButton jbtHomeLogin = new JButton();
	
	//Home Components
	
 	JButton jbtSales = new JButton();
	JButton jbtSettings = new JButton();
	JButton jbtItems = new JButton();
	JButton jbtReport = new JButton();
	JButton jbtReStockList = new JButton();
	JButton jbtBanking = new JButton();
	JButton jbtStaff = new JButton();
	JButton jbtLogOut = new JButton();
	JLabel jlbWelcome = new JLabel();
	JLabel jlbProfilePicture = new JLabel();
	JLabel jlbUser = new JLabel();
	
	//Items Components
	
	JLabel jlbSeachItems = new JLabel();
	JTextField jtfSearchItems = new JTextField();
	JButton jbtAddItem = new JButton();
	JButton jbtSaveItems = new JButton();
	JButton jbtPrintItems = new JButton();
	JButton jbtHomeItems = new JButton();	
	JButton jbtRemoveItems = new JButton();	
	String itemsTextFile = "Items.txt";	
	JTable itemsTable;
	String[] itemsTableHeaders = {"Item Code","Name","Quantity","ReStock Quantity","Original Price","Sale Price","Profit"};
	DefaultTableModel itemsTableModel = new DefaultTableModel(itemsTableHeaders,0);
	int theRowToRemove = -1;
	
	//ReStock Components
	
	JButton jbtPrintReStockList = new JButton();
	JButton jbtHomeReStockList = new JButton();
	String reStockTextFile = "ReStock.txt";
	String[] reStockTableHeaders = {"Item Code","Name","Quantity","ReStock Quantity","Original Price"};
	JTable reStockTable;
	DefaultTableModel reStockTableModel = new DefaultTableModel(reStockTableHeaders,0);	
	
	//Sales Components
	
	JLabel jlbItemCodeSales = new JLabel();
	JLabel jlbItemNameSales = new JLabel();
	JLabel jlbQuantitySales = new JLabel();
	JLabel jlbItemPriceSales = new JLabel();
	JTextField jtfItemCodeSales = new JTextField();
	JTextField jtfItemNameSales = new JTextField();
	JTextField jtfQuantitySales = new JTextField();
	JTextField jtfItemPriceSales = new JTextField();
	JButton jbtAddSales = new JButton();
	JButton jbtPaySales = new JButton();
	JButton jbtCancelSales = new JButton();
	JButton jbtHomeSales = new JButton();
	JTable salesSearchTable;
	String[] salesSearchHeaders = {"Item Code","Name"};
	DefaultTableModel salesSearchTableModel = new DefaultTableModel(salesSearchHeaders,0);
	JTable salesOrderTable;
	String[] salesOrderHeaders = {"Item Code","Name","Quantity","Price","SubTotal"};
	DefaultTableModel salesOrderTableModel = new DefaultTableModel(salesOrderHeaders,0);
	JLabel jlbTotalPriceSales = new JLabel();
	JTextField jtfTotalPriceSales = new JTextField();		
	Object tempItem;
	Object[][] orderTableData;
	Double totalMoney;
	
	//Report Components
	
	JButton jbtHomeReport = new JButton();
	JButton jbtViewStockReport = new JButton();
	JButton jbtPrintStockReport = new JButton();
	JButton jbtViewReStockListReport = new JButton();
	JButton jbtPrintReStockListReport = new JButton();
	JButton jbtViewBankingReport = new JButton();
	JButton jbtPrintBankingReport = new JButton();
	JButton jbtViewSalesReport = new JButton();
	JButton jbtPrintSalesReport = new JButton();
	
	//Banking Components
	
	JLabel jlbDateBanking = new JLabel();
	JTextField jtfDateBanking = new JTextField();
	JLabel jlbTotalNetBanking = new JLabel();
	JTextField jtfTotalNetBanking = new JTextField();
	JLabel jlbFloatBanking = new JLabel();
	JTextField jtfFloatBanking = new JTextField();
	JLabel jlbMiscBanking = new JLabel();
	JTextField jtfMiscBanking = new JTextField();
	JLabel jlbCashBanking = new JLabel();
	JTextField jtfCashBanking = new JTextField();
	JLabel jlbCreditCardBanking = new JLabel();
	JTextField jtfCreditCardBanking = new JTextField();
	JLabel jlbTotalBanking = new JLabel();
	JTextField jtfTotalBanking = new JTextField();
	JLabel jlbProfitBanking = new JLabel();
	JTextField jtfProfitBanking = new JTextField();
	JButton jbtPrintBanking = new JButton();
	JButton jbtSaveBanking = new JButton();
	JButton jbtHomeBanking = new JButton();
	JButton jbtBackReportViewBanking = new JButton();

	
	//Staff Components
	
	JLabel jlbPasswordManagmentStaff = new JLabel();
	JLabel jlbCurrentPasswordStaff = new JLabel();
	JPasswordField jpfCurrentPasswordStaff = new JPasswordField();
	JLabel jlbNewPasswordStaff = new JLabel();
	JLabel jlbReTypePasswordStaff = new JLabel();
	JButton jbtChangePasswordStaff = new JButton();
	JLabel jlbAddUserStaff = new JLabel();
	JButton jbtNewUserProfilePictureStaff = new JButton();
	JLabel jlbNewUserUsernameStaff = new JLabel();
	JTextField jtfNewUserUsernameStaff = new JTextField();
	JButton jbtAddUserStaff = new JButton();
	JTextField jtfUsernameStaff = new JTextField(); 
	JLabel jlbNewUserPasswordStaff = new JLabel();
	JLabel jlbNewUserVerifyPasswordStaff = new JLabel();
	JPasswordField jpfNewPasswordStaff = new JPasswordField();
	JPasswordField jpfReTypePasswordStaff = new JPasswordField();
	JPasswordField jpfNewUserPasswordStaff = new JPasswordField();
	JPasswordField jpfNewUserVerifyPasswordStaff = new JPasswordField();
	JLabel jlbUsernameStaff = new JLabel();
	JLabel jlbNewUserSecurityQuestionStaff = new JLabel();
	JLabel jlbNewUserSecurityQuestionAnswerStaff = new JLabel();
	JTextField jtfNewUserAnswerStaff = new JTextField();
	JButton jbtHomeStaff = new JButton();
	String[] securityQuestion = new String[]{"What is your nickname?", "What is your mother's maiden name?", "What is the name of your first school?" , "In what city were you born?", "What is your favorite color?"}; 
	JComboBox<String> cmbSecurityQuestion = new JComboBox<String>(securityQuestion);
	JFileChooser jfcProfilePictureChooser = new JFileChooser();
	String theFilename;
	
	//Settings Components
	
	JLabel jlbMessagesSettings = new JLabel();
	JRadioButton jrbtnMessagesOnSettings = new JRadioButton();
	JRadioButton jrbtnMessagesOffSettings = new JRadioButton();
	JButton jbtSaveMessages = new JButton();
	JButton jbtHomeSettings = new JButton();
	boolean showMessages = false;
	
	//ReportView Components
	
	JButton jbtHomeReportView = new JButton();
	JButton jbtBackReportView = new JButton();
	String[] salesDateTableHeaders = {"SaleID","Date/Time","Item Code","Item Name","Quantity","Subtotal","Total"};
	JTable salesDateTable;
	DefaultTableModel salesDateTableModel = new DefaultTableModel(salesDateTableHeaders,0);
	
	//Forgotton Password Components
	
	JLabel jlbUsernameForgottonPassword = new JLabel();
	JTextField jtfUsernameForgottonPassword = new JTextField();
	JButton jbtSubmitUsernameForgottonPassword = new JButton();
	JLabel jlbSecurityQuestionForgottonPassword = new JLabel();
	JTextField jtfSecurityQuestionForgottonPassword = new JTextField();
	JLabel jlbAnswerForgottonPassword = new JLabel();
	JTextField jtfAnswerForgottonPassword = new JTextField();
	JButton jbtSubmitAnswerForgottonPassword = new JButton();
	JLabel jlbPasswordForgottonPassword = new JLabel();
	JTextField jtfPasswordForgottonPassword = new JTextField();
	JButton jbtLoginForgottonPassword = new JButton();
	
	
public void loadLoginPanel()
{
	//Login Panel characteristics 
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.setTitle("Login Page");
	this.setSize(500,400);
	this.setVisible(true);
	this.setResizable(true);
	
	loginPanel.setBackground( new Color(211,4,6) );
	loginPanel.setSize(500,400);
	loginPanel.setLocation(0,0);
	createLoginPanel();
	this.add(loginPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);	
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	loginPanel.setVisible(true);	
	
	loginPanel.repaint();
}

public void startButtons()
{
	//All buttons characteristics within a single method which is called once to prevent action listener repetition occuring within system	
	//Login Buttons
	
	jbtHomeLogin.setLocation(775,400);
	jbtHomeLogin.setSize(100,50);
	jbtHomeLogin.addActionListener(this);
	jbtHomeLogin.setText("Home");
	
	jbtForgottonPasswordLogin.setLocation(275,294);
	jbtForgottonPasswordLogin.setSize(150,50);
	jbtForgottonPasswordLogin.addActionListener(this);
	jbtForgottonPasswordLogin.setText("Forgotton Password");
	
	jbtSubmitLogin.setLocation(148,227);
	jbtSubmitLogin.setSize(100,50);
	jbtSubmitLogin.addActionListener(this);
	jbtSubmitLogin.setText("Submit ");
	
	//Home Panel Buttons
	
	jbtSales.setLocation(155,135);
	jbtSales.setSize(100,50);
	jbtSales.addActionListener(this);
	jbtSales.setText("Sales");
	
	jbtSettings.setLocation(155,235);
	jbtSettings.setSize(100,50);
	jbtSettings.addActionListener(this);
	jbtSettings.setText("Settings");
	
	jbtItems.setLocation(155,335);
	jbtItems.setSize(100,50);
	jbtItems.addActionListener(this);
	jbtItems.setText("Items");	
	
	jbtReport.setLocation(410,135);
	jbtReport.setSize(100,50);
	jbtReport.addActionListener(this);
	jbtReport.setText("Report");
	
	jbtReStockList.setLocation(400,335);
	jbtReStockList.setSize(120,50);
	jbtReStockList.addActionListener(this);
	jbtReStockList.setText("Re-Stock List");
	
	jbtBanking.setLocation(665,135);
	jbtBanking.setSize(100,50);
	jbtBanking.addActionListener(this);
	jbtBanking.setText("Banking");
	
	jbtStaff.setLocation(665,235);
	jbtStaff.setSize(100,50);
	jbtStaff.addActionListener(this);
	jbtStaff.setText("Staff");
	
	jbtLogOut.setLocation(665,335);
	jbtLogOut.setSize(100,50);
	jbtLogOut.addActionListener(this);
	jbtLogOut.setText("Log Out");
	
	//Items Panel Buttons
		
	jbtAddItem.setLocation(875,130);
	jbtAddItem.setSize(120,50);
	jbtAddItem.addActionListener(this);
	jbtAddItem.setText("Add New Item");
	itemsPanel.add(jbtAddItem);

	jbtSaveItems.setLocation(875,330);
	jbtSaveItems.setSize(120,50);
	jbtSaveItems.addActionListener(this);
	jbtSaveItems.setText("Save");
	itemsPanel.add(jbtSaveItems);

	jbtPrintItems.setLocation(875,430);
	jbtPrintItems.setSize(120,50);
	jbtPrintItems.addActionListener(this);
	jbtPrintItems.setText("Print");
	itemsPanel.add(jbtPrintItems);
	
	jbtRemoveItems.setLocation(875,230);
	jbtRemoveItems.setSize(120,50);
	jbtRemoveItems.addActionListener(this);
	jbtRemoveItems.setText("Remove Item");
	itemsPanel.add(jbtRemoveItems);		
	
	jbtHomeItems.setLocation(1000,500);
	jbtHomeItems.setSize(100,50);
	jbtHomeItems.addActionListener(this);
	jbtHomeItems.setText("Home");
	itemsPanel.add(jbtHomeItems);
	
	//Sales buttons
	
	jbtAddSales.setLocation(120,350);
	jbtAddSales.setSize(100,50);
	jbtAddSales.addActionListener(this);
	jbtAddSales.setText("Add");
	salesPanel.add(jbtAddSales);

	jbtPaySales.setLocation(120,425);
	jbtPaySales.setSize(100,50);
	jbtPaySales.addActionListener(this);
	jbtPaySales.setText("Pay");
	salesPanel.add(jbtPaySales);

	jbtCancelSales.setLocation(120,500);
	jbtCancelSales.setSize(100,50);
	jbtCancelSales.addActionListener(this);
	jbtCancelSales.setText("Cancel");
	salesPanel.add(jbtCancelSales);

	jbtHomeSales.setLocation(1050,550);
	jbtHomeSales.setSize(100,50);
	jbtHomeSales.addActionListener(this);
	jbtHomeSales.setText("Home");
	salesPanel.add(jbtHomeSales);
	
	//ReStock List Buttons
	
	jbtPrintReStockList.setLocation(410,400);
	jbtPrintReStockList.setSize(100,50);
	jbtPrintReStockList.addActionListener(this);
	jbtPrintReStockList.setText("Print");
	reStockListPanel.add(jbtPrintReStockList);
	
	jbtHomeReStockList.setLocation(750,400);
	jbtHomeReStockList.setSize(100,50);
	jbtHomeReStockList.addActionListener(this);
	jbtHomeReStockList.setText("Home");
	reStockListPanel.add(jbtHomeReStockList);
	
	//Report Buttons
	
	jbtHomeReport.setLocation(790,400);
	jbtHomeReport.setSize(100,50);
	jbtHomeReport.addActionListener(this);
	jbtHomeReport.setText("Home");
	reportPanel.add(jbtHomeReport);

	jbtViewStockReport.setLocation(100,150);
	jbtViewStockReport.setSize(120,50);
	jbtViewStockReport.addActionListener(this);
	jbtViewStockReport.setText("View Stock");
	reportPanel.add(jbtViewStockReport);

	jbtPrintStockReport.setLocation(100,250);
	jbtPrintStockReport.setSize(120,50);
	jbtPrintStockReport.addActionListener(this);
	jbtPrintStockReport.setText("Print Stock");
	reportPanel.add(jbtPrintStockReport);

	jbtViewReStockListReport.setLocation(300,150);
	jbtViewReStockListReport.setSize(120,50);
	jbtViewReStockListReport.addActionListener(this);
	jbtViewReStockListReport.setText("View ReStock");
	reportPanel.add(jbtViewReStockListReport);

	jbtPrintReStockListReport.setLocation(300,250);
	jbtPrintReStockListReport.setSize(120,50);
	jbtPrintReStockListReport.addActionListener(this);
	jbtPrintReStockListReport.setText("Print ReStock");
	reportPanel.add(jbtPrintReStockListReport);

	jbtViewBankingReport.setLocation(500,150);
	jbtViewBankingReport.setSize(120,50);
	jbtViewBankingReport.addActionListener(this);
	jbtViewBankingReport.setText("View Banking");
	reportPanel.add(jbtViewBankingReport);

	jbtPrintBankingReport.setLocation(500,250);
	jbtPrintBankingReport.setSize(120,50);
	jbtPrintBankingReport.addActionListener(this);
	jbtPrintBankingReport.setText("Print Banking");
	reportPanel.add(jbtPrintBankingReport);

	jbtViewSalesReport.setLocation(700,150);
	jbtViewSalesReport.setSize(120,50);
	jbtViewSalesReport.addActionListener(this);
	jbtViewSalesReport.setText("View Sales");
	reportPanel.add(jbtViewSalesReport);

	jbtPrintSalesReport.setLocation(700,250);
	jbtPrintSalesReport.setSize(120,50);
	jbtPrintSalesReport.addActionListener(this);
	jbtPrintSalesReport.setText("Print Sales");
	reportPanel.add(jbtPrintSalesReport);
	
	//Banking Buttons
	
	jbtPrintBanking.setLocation(50,400);
	jbtPrintBanking.setSize(100,50);
	jbtPrintBanking.addActionListener(this);
	jbtPrintBanking.setText("Print");
	bankingPanel.add(jbtPrintBanking);

	jbtSaveBanking.setLocation(350,400);
	jbtSaveBanking.setSize(100,50);
	jbtSaveBanking.addActionListener(this);
	jbtSaveBanking.setText("Save");
	bankingPanel.add(jbtSaveBanking);

	jbtHomeBanking.setLocation(650,400);
	jbtHomeBanking.setSize(100,50);
	jbtHomeBanking.addActionListener(this);
	jbtHomeBanking.setText("Home");
	bankingPanel.add(jbtHomeBanking);
	
	jbtBackReportViewBanking.setLocation(50,400);
	jbtBackReportViewBanking.setSize(100,50);
	jbtBackReportViewBanking.addActionListener(this);
	jbtBackReportViewBanking.setText("Back");
	bankingPanel.add(jbtBackReportViewBanking);
	
	//Staff Buttons
	
	jbtHomeStaff.setLocation(750,600);
	jbtHomeStaff.setSize(100,50);
	jbtHomeStaff.addActionListener(this);
	jbtHomeStaff.setText("Home");
	staffPanel.add(jbtHomeStaff);
	
	jbtChangePasswordStaff.setLocation(125,400);
	jbtChangePasswordStaff.setSize(150,48);
	jbtChangePasswordStaff.addActionListener(this);
	jbtChangePasswordStaff.setText("Change Password");
	staffPanel.add(jbtChangePasswordStaff);
	
	jbtNewUserProfilePictureStaff.setLocation(500,100);
	jbtNewUserProfilePictureStaff.setSize(175,50);
	jbtNewUserProfilePictureStaff.addActionListener(this);
	jbtNewUserProfilePictureStaff.setText("Set Profile Picture");
	staffPanel.add(jbtNewUserProfilePictureStaff);
	
	jbtAddUserStaff.setLocation(500,550);
	jbtAddUserStaff.setSize(150,50);
	jbtAddUserStaff.addActionListener(this);
	jbtAddUserStaff.setText("Add User");
	staffPanel.add(jbtAddUserStaff);
	
	//Settings buttons
	
	jbtHomeSettings.setLocation(418,243);
	jbtHomeSettings.setSize(100,50);
	jbtHomeSettings.addActionListener(this);
	jbtHomeSettings.setText("Home");
	settingsPanel.add(jbtHomeSettings);
	
	jbtSaveMessages.setLocation(200,200);
	jbtSaveMessages.setSize(100,50);
	jbtSaveMessages.addActionListener(this);
	jbtSaveMessages.setText("Save");
	settingsPanel.add(jbtSaveMessages);
	
	
	//Report View buttons
	
	jbtHomeReportView.setLocation(670,500);
	jbtHomeReportView.setSize(100,50);
	jbtHomeReportView.addActionListener(this);
	jbtHomeReportView.setText("Home");
	reportViewPanel.add(jbtHomeReportView);

	jbtBackReportView.setLocation(30,500);
	jbtBackReportView.setSize(100,50);
	jbtBackReportView.addActionListener(this);
	jbtBackReportView.setText("Back");
	reportViewPanel.add(jbtBackReportView);
	
	//Forgotton Password buttons
	
	jbtSubmitUsernameForgottonPassword.setLocation(180,130);
	jbtSubmitUsernameForgottonPassword.setSize(150,50);
	jbtSubmitUsernameForgottonPassword.addActionListener(this);
	jbtSubmitUsernameForgottonPassword.setText("Submit Username");
	forgottonPasswordPanel.add(jbtSubmitUsernameForgottonPassword);	
	
	jbtSubmitAnswerForgottonPassword.setLocation(180,340);
	jbtSubmitAnswerForgottonPassword.setSize(150,50);
	jbtSubmitAnswerForgottonPassword.addActionListener(this);
	jbtSubmitAnswerForgottonPassword.setText("Submit Answer");
	forgottonPasswordPanel.add(jbtSubmitAnswerForgottonPassword);
	
	jbtLoginForgottonPassword.setLocation(490,500);
	jbtLoginForgottonPassword.setSize(100,50);
	jbtLoginForgottonPassword.addActionListener(this);
	jbtLoginForgottonPassword.setText("Login");
	forgottonPasswordPanel.add(jbtLoginForgottonPassword);
	
}

public void createLoginPanel()
{
	//Login Components characteristics
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	loginPanel.add(jlbLogo);
	
	jlbUsernameLogin.setLocation(100,120);
	jlbUsernameLogin.setSize(70,25);
	jlbUsernameLogin.setOpaque(true);
	jlbUsernameLogin.setText("Username:");
	jlbUsernameLogin.setBackground( new Color(211,4,6) );
	loginPanel.add(jlbUsernameLogin);

	jlbPasswordLogin.setLocation(100,170);
	jlbPasswordLogin.setSize(70,25);
	jlbPasswordLogin.setOpaque(true);
	jlbPasswordLogin.setText("Password:");
	jlbPasswordLogin.setBackground( new Color(211,4,6) );
	loginPanel.add(jlbPasswordLogin );

	jtfUsernameLogin.setLocation(190,120);
	jtfUsernameLogin.setSize(100,25);
	jtfUsernameLogin.setText("");
	jtfUsernameLogin.setColumns(10);
	loginPanel.add(jtfUsernameLogin);

	jpfPasswordLogin.setLocation(190,170);
	jpfPasswordLogin.setSize(100,25);
	jpfPasswordLogin.setText("");
	jpfPasswordLogin.setColumns(10);
	loginPanel.add(jpfPasswordLogin);

	jlbTitleLogin.setLocation(150,36);
	jlbTitleLogin.setSize(100,32);
	jlbTitleLogin.setOpaque(true);
	jlbTitleLogin.setText("Shri Ram Stores");
	jlbTitleLogin.setBackground( new Color(211,4,6) );
	loginPanel.add(jlbTitleLogin);

	loginPanel.add(jbtSubmitLogin);
	loginPanel.add(jbtForgottonPasswordLogin);

}

public void createHomePanel()
{
	//Home Components characteristics
	
	homePanel.add(jbtSales);
	homePanel.add(jbtSettings);
	homePanel.add(jbtItems);
	homePanel.add(jbtReport);
	homePanel.add(jbtReStockList);
	homePanel.add(jbtBanking);
	homePanel.add(jbtStaff);
	homePanel.add(jbtLogOut);

	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	homePanel.add(jlbLogo);
	
	jlbWelcome.setLocation(430,45);
	jlbWelcome.setSize(100,50);
	jlbWelcome.setOpaque(true);
	jlbWelcome.setText("Welcome");
	jlbWelcome.setBackground( new Color(211,4,6) );
	homePanel.add(jlbWelcome);
	
	jlbUser.setLocation(530,45);
	jlbUser.setSize(100,50);
	jlbUser.setOpaque(true);
	jlbUser.setText(staffL.currentUser);
	jlbUser.setBackground( new Color(211,4,6) );
	homePanel.add(jlbUser);
	
	jlbProfilePicture.setIcon(staffL.smallLogo);
	jlbProfilePicture.setLocation(300,15);
	jlbProfilePicture.setSize(100,100);
	homePanel.add(jlbProfilePicture);

}

public void loadHomePanel()
{
	//Home Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Home");
	this.setSize(920,500);
	this.setVisible(true);
	this.setResizable(true);
	
	homePanel.setBackground( new Color(211,4,6) );
	homePanel.setSize(920,500);
	homePanel.setLocation(0,0);	
	createHomePanel();
	this.add(homePanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	homePanel.setVisible(true);
	
	if(showMessages==true)	//Tutorial message for Home screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Home Screen \n > Use the buttons to navigate to each area of the system \n > To exit the system click the logout button and then close the system");
	} 

}

public void createItemsPanel()
{
	//Home Components characteristics
	itemsPanel.add(jbtHomeItems);
	itemsPanel.add(jbtAddItem);
	itemsPanel.add(jbtSaveItems);
	itemsPanel.add(jbtPrintItems);	
	itemsPanel.add(jbtRemoveItems);	
	itemsPanel.add(jbtHomeItems);	
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	itemsPanel.add(jlbLogo);
	
	jlbSeachItems.setLocation(780,30);
	jlbSeachItems.setSize(80,50);
	jlbSeachItems.setText("Search:");
	jlbSeachItems.setOpaque(true);
	jlbSeachItems.setBackground( new Color(211,4,6) );
	itemsPanel.add(jlbSeachItems);
	
	jtfSearchItems.setLocation(875,30);
	jtfSearchItems.setSize(200,50);
	jtfSearchItems.setText("");
	jtfSearchItems.setColumns(10);
	itemsPanel.add(jtfSearchItems);
	
}

public void loadItemsPanel()
{	
	//Items Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	this.setTitle("Shri Ram Stores - Items");
	this.setSize(1150,600);
	this.setVisible(true);
	this.setResizable(true);
	
	itemsPanel.setBackground( new Color(211,4,6) );
	itemsPanel.setSize(1150,600);
	itemsPanel.setLocation(0,0);	
	createItemsPanel();
	this.add(itemsPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	itemsPanel.setVisible(true);
	
	createItemsTable();	//Create items table within panel
	
	if(showMessages==true)	//Tutorial on Items screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Items screen \n > To add a new item, click the Add New Item button, this will bring up a blank row in the table \n add each details of the new item and click save \n > To remove an item select the item to be removed from the table and press Remove Item and then save \n > To print the Items/Stock table, press the Print button and follow the dialogue box instructions to print ");
	}
	
}

public void createReStockListPanel()
{
	//ReStockList Components characteristics
	
	reStockListPanel.add(jbtHomeReStockList);	
	reStockListPanel.add(jbtPrintReStockList);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	reStockListPanel.add(jlbLogo);
}

public void loadReStockListPanel()
{
	//ReStockList Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	this.setTitle("ReStock List ");
	this.setSize(920,500);
	this.setVisible(true);
	this.setResizable(true);
	
	reStockListPanel.setBackground( new Color(211,4,6) );
	reStockListPanel.setSize(920,500);
	reStockListPanel.setLocation(0,0);	
	createReStockListPanel();
	this.add(reStockListPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	reStockListPanel.setVisible(true);
	
	createReStockTable();	//Create reStockTable upon loading panel
	
	if(showMessages==true)	//Tutorial message of reStock Screen
	{
		JOptionPane.showMessageDialog(null,"> This is the ReStock List \n > This displays all items with their current quantity less than the re-stock quantity \n > To print the ReStock list, press the Print button and follow the dialogue box instructions to print ");
	}
	
}

public void createSalesPanel()
{
	//Sales Components characteristics
	
	salesPanel.add(jbtHomeSales);
	salesPanel.add(jbtAddSales);
	salesPanel.add(jbtPaySales);
	salesPanel.add(jbtCancelSales);

	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	salesPanel.add(jlbLogo);
	
	jlbItemCodeSales.setLocation(50,50);
	jlbItemCodeSales.setSize(100,50);
	jlbItemCodeSales.setOpaque(true);
	jlbItemCodeSales.setText("Item Code:");
	jlbItemCodeSales.setBackground( new Color(211,4,6) );
	salesPanel.add(jlbItemCodeSales);

	jlbItemNameSales.setLocation(50,125);
	jlbItemNameSales.setSize(100,50);
	jlbItemNameSales.setOpaque(true);
	jlbItemNameSales.setText("Name:");
	jlbItemNameSales.setBackground( new Color(211,4,6) );
	salesPanel.add(jlbItemNameSales);

	jlbQuantitySales.setLocation(50,200);
	jlbQuantitySales.setSize(100,50);
	jlbQuantitySales.setOpaque(true);
	jlbQuantitySales.setText("Quantity:");
	jlbQuantitySales.setBackground( new Color(211,4,6) );
	salesPanel.add(jlbQuantitySales);

	jlbItemPriceSales.setLocation(50,275);
	jlbItemPriceSales.setSize(100,50);
	jlbItemPriceSales.setOpaque(true);
	jlbItemPriceSales.setText("Price:");
	jlbItemPriceSales.setBackground( new Color(211,4,6) );
	salesPanel.add(jlbItemPriceSales);

	jtfItemCodeSales.setLocation(150,50);
	jtfItemCodeSales.setSize(150,50);
	jtfItemCodeSales.setText("");
	jtfItemCodeSales.setColumns(10);
	salesPanel.add(jtfItemCodeSales);

	jtfItemNameSales.setLocation(150,125);
	jtfItemNameSales.setSize(150,50);
	jtfItemNameSales.setText("");
	jtfItemNameSales.setColumns(10);
	salesPanel.add(jtfItemNameSales);

	jtfQuantitySales.setLocation(150,200);
	jtfQuantitySales.setSize(100,50);
	jtfQuantitySales.setText("1");
	jtfQuantitySales.setColumns(10);
	salesPanel.add(jtfQuantitySales);

	jtfItemPriceSales.setLocation(150,275);
	jtfItemPriceSales.setSize(150,50);
	jtfItemPriceSales.setText("");
	jtfItemPriceSales.setColumns(10);
	salesPanel.add(jtfItemPriceSales);

	jlbTotalPriceSales.setLocation(750,550);
	jlbTotalPriceSales.setSize(100,50);
	jlbTotalPriceSales.setOpaque(true);
	jlbTotalPriceSales.setText("Total Price:");
	jlbTotalPriceSales.setBackground( new Color(211,4,6) );
	salesPanel.add(jlbTotalPriceSales);

	jtfTotalPriceSales.setLocation(850,550);
	jtfTotalPriceSales.setSize(150,50);
	jtfTotalPriceSales.setText("");
	jtfTotalPriceSales.setColumns(10);
	salesPanel.add(jtfTotalPriceSales);
		
}

public void loadSalesPanel()
{
	//Sales Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.setTitle("Sales");
	this.setSize(1200,650);
	this.setForeground( new Color(-16777216) );
	this.setBackground( new Color(-986896) );
	this.setVisible(true);
	this.setResizable(true);
	
	salesPanel.setBackground( new Color(211,4,6) );
	salesPanel.setSize(1200,650);
	salesPanel.setLocation(0,0);
	createSalesPanel();
	this.add(salesPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	salesPanel.setVisible(true);
	
	createSalesSearchTable();	//Create Sales Search table upon sales panel loading
	createSalesOrderTable();	//Create Sales Order table upon sales panel loading
	
	if(showMessages==true)	//Tutorial message on Sales screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Sales/POS Screen \n > To make a sale, intially enter the barcode using the Item Code field or search for an item using the Item Name field \n When the item appears in the table, click the item and set the quantity relevant to the sale and then click Add to add this item to the order \n The item will now appear in the Order table \n Add all items for the customers order and click Pay once the order is complete \n > To cancel the current order, click the Cancel button and this will refresh the screen");
	}

}

public void createReportPanel()
{
	//Report Components characteristics
	
	reportPanel.add(jbtHomeReport);
	reportPanel.add(jbtViewStockReport);
	reportPanel.add(jbtPrintStockReport);
	reportPanel.add(jbtViewReStockListReport);
	reportPanel.add(jbtPrintReStockListReport);
	reportPanel.add(jbtViewBankingReport);
	reportPanel.add(jbtPrintBankingReport);
	reportPanel.add(jbtViewSalesReport);
	reportPanel.add(jbtPrintSalesReport);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	reportPanel.add(jlbLogo);
	
}

public void loadReportPanel()
{
	//Report Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.setTitle("Report");
	this.setSize(920,500);
	this.setVisible(true);
	this.setResizable(true);
	
	reportPanel.setBackground( new Color(211,4,6) );
	reportPanel.setSize(1000,605);
	reportPanel.setLocation(0,0);
	createReportPanel();
	this.add(reportPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	settingsPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	reportPanel.setVisible(true);
	
	if(showMessages==true)	//Tutorial message of report screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Report Screen \n > To view Stock, click the View Stock button and you will be redirected to the Items screen \n > To print the Stock, click the Print Stock button and follow the instructions on the dialogue box \n > To view the ReStock list, click the View ReStock button and you will be redirected to the ReStock List screen \n > To print the ReStock List, click the Print ReStock button and follow the instructions on the dialogue box \n > To view a banking report, click the View Banking button and enter a date to view the report, after entering a date a screen of all details from the date will be brought up \n > To print the Banking report, press the Print button and follow the dialogue box instructions to print \n >  To view a Sales report, click the View Sales button and enter a date to view the report, after entering a date a screen of all sales from the date will be brought up \n > To print the Sales report, press the Print button and follow the dialogue box instructions to print");
	}
		
}

public void createBankingPanel()
{
	//Banking Components characteristics
	
	bankingPanel.add(jbtPrintBanking);
	bankingPanel.add(jbtSaveBanking);
	bankingPanel.add(jbtHomeBanking);

	jbtSaveBanking.setVisible(true);
	jbtPrintBanking.setVisible(true);
	jbtBackReportViewBanking.setVisible(false);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	bankingPanel.add(jlbLogo);
	
	jlbDateBanking.setLocation(50,50);
	jlbDateBanking.setSize(100,50);
	jlbDateBanking.setOpaque(true);
	jlbDateBanking.setText("Date:");
	jlbDateBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbDateBanking);
	
	DateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");	//New date format of dd/mm/yyyy
	Date date = new Date();									//Date of type date setup
    System.out.println(dmy.format(date));					//Output current date in sdf format

	jtfDateBanking.setLocation(150,50);
	jtfDateBanking.setSize(150,50);
	jtfDateBanking.setText(dmy.format(date));				//Preset banking date to current date
	jtfDateBanking.setColumns(10);
	bankingPanel.add(jtfDateBanking);

	jlbTotalNetBanking.setLocation(50,130);
	jlbTotalNetBanking.setSize(100,50);
	jlbTotalNetBanking.setOpaque(true);
	jlbTotalNetBanking.setText("Total Net:");
	jlbTotalNetBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbTotalNetBanking);

	jtfTotalNetBanking.setLocation(150,130);
	jtfTotalNetBanking.setSize(150,50);
	jtfTotalNetBanking.setText("");
	jtfTotalNetBanking.setColumns(10);
	bankingPanel.add(jtfTotalNetBanking);

	jlbFloatBanking.setLocation(50,210);
	jlbFloatBanking.setSize(100,50);
	jlbFloatBanking.setOpaque(true);
	jlbFloatBanking.setText("Float: ");
	jlbFloatBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbFloatBanking);

	jtfFloatBanking.setLocation(150,210);
	jtfFloatBanking.setSize(150,50);
	jtfFloatBanking.setText("");
	jtfFloatBanking.setColumns(10);
	bankingPanel.add(jtfFloatBanking);

	jlbMiscBanking.setLocation(50,290);
	jlbMiscBanking.setSize(100,50);
	jlbMiscBanking.setOpaque(true);
	jlbMiscBanking.setText("Misc:");
	jlbMiscBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbMiscBanking);

	jtfMiscBanking.setLocation(150,290);
	jtfMiscBanking.setSize(150,50);
	jtfMiscBanking.setText("");
	jtfMiscBanking.setColumns(10);
	bankingPanel.add(jtfMiscBanking);

	jlbCashBanking.setLocation(450,50);
	jlbCashBanking.setSize(100,50);
	jlbCashBanking.setOpaque(true);
	jlbCashBanking.setText("Cash:");
	jlbCashBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbCashBanking);

	jtfCashBanking.setLocation(550,50);
	jtfCashBanking.setSize(150,50);
	jtfCashBanking.setText("");
	jtfCashBanking.setColumns(10);
	bankingPanel.add(jtfCashBanking);

	jlbCreditCardBanking.setLocation(450,130);
	jlbCreditCardBanking.setSize(100,50);
	jlbCreditCardBanking.setOpaque(true);
	jlbCreditCardBanking.setText("Credit Card:");
	jlbCreditCardBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbCreditCardBanking);

	jtfCreditCardBanking.setLocation(550,130);
	jtfCreditCardBanking.setSize(150,50);
	jtfCreditCardBanking.setText("");
	jtfCreditCardBanking.setColumns(10);
	bankingPanel.add(jtfCreditCardBanking);

	jlbTotalBanking.setLocation(450,210);
	jlbTotalBanking.setSize(100,50);
	jlbTotalBanking.setOpaque(true);
	jlbTotalBanking.setText("Total:");
	jlbTotalBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbTotalBanking);

	jtfTotalBanking.setLocation(550,210);
	jtfTotalBanking.setSize(150,50);
	jtfTotalBanking.setText("");
	jtfTotalBanking.setColumns(10);
	bankingPanel.add(jtfTotalBanking);

	jlbProfitBanking.setLocation(450,290);
	jlbProfitBanking.setSize(100,50);
	jlbProfitBanking.setOpaque(true);
	jlbProfitBanking.setText("Profit:");
	jlbProfitBanking.setBackground( new Color(211,4,6) );
	bankingPanel.add(jlbProfitBanking);

	jtfProfitBanking.setLocation(550,290);
	jtfProfitBanking.setSize(150,50);
	jtfProfitBanking.setText("");
	jtfProfitBanking.setColumns(10);
	bankingPanel.add(jtfProfitBanking);
	
}

public void loadBankingPanel()
{
	//Banking Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.setTitle("Banking ");
	this.setSize(800,500);
	this.setForeground( new Color(-16777216) );
	this.setBackground( new Color(-986896) );
	this.setVisible(true);
	this.setResizable(true);
	
	bankingPanel.setBackground( new Color(211,4,6) );
	bankingPanel.setSize(800,500);
	bankingPanel.setLocation(0,0);
	createBankingPanel();
	this.add(bankingPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	staffPanel.setVisible(false);
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	bankingPanel.setVisible(true);
	
	if(showMessages==true)	//Tutorial message of banking screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Banking Screen \n > To save a banking report, enter all the relevant details and click Save, this will be saved successfully \n > To print the Banking details, click the Print button and follow the instructions on the dialogue box");
	}
}

public void createStaffPanel()
{
	//Staff Components characteristics
	
	staffPanel.add(jbtChangePasswordStaff);
	staffPanel.add(jbtNewUserProfilePictureStaff);
	staffPanel.add(jbtAddUserStaff);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	staffPanel.add(jlbLogo);
	
	jlbPasswordManagmentStaff.setLocation(100,25);
	jlbPasswordManagmentStaff.setSize(175,50);
	jlbPasswordManagmentStaff.setOpaque(true);
	jlbPasswordManagmentStaff.setText("Password Managment");
	jlbPasswordManagmentStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbPasswordManagmentStaff);

	jlbCurrentPasswordStaff.setLocation(50,175);
	jlbCurrentPasswordStaff.setSize(125,50);
	jlbCurrentPasswordStaff.setOpaque(true);
	jlbCurrentPasswordStaff.setText("Current Password:");
	jlbCurrentPasswordStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbCurrentPasswordStaff);

	jpfCurrentPasswordStaff.setLocation(175,175);
	jpfCurrentPasswordStaff.setSize(150,50);
	jpfCurrentPasswordStaff.setText("");
	jpfCurrentPasswordStaff.setColumns(10);
	staffPanel.add(jpfCurrentPasswordStaff);

	jlbNewPasswordStaff.setLocation(50,250);
	jlbNewPasswordStaff.setSize(125,50);
	jlbNewPasswordStaff.setOpaque(true);
	jlbNewPasswordStaff.setText("New Password:");
	jlbNewPasswordStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbNewPasswordStaff);

	jlbReTypePasswordStaff.setLocation(50,325);
	jlbReTypePasswordStaff.setSize(125,50);
	jlbReTypePasswordStaff.setOpaque(true);
	jlbReTypePasswordStaff.setText("Retype Password:");
	jlbReTypePasswordStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbReTypePasswordStaff);

	jlbAddUserStaff.setLocation(550,25);
	jlbAddUserStaff.setSize(75,50);
	jlbAddUserStaff.setOpaque(true);
	jlbAddUserStaff.setText("Add User");
	jlbAddUserStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbAddUserStaff);

	jlbNewUserUsernameStaff.setLocation(450,175);
	jlbNewUserUsernameStaff.setSize(125,50);
	jlbNewUserUsernameStaff.setOpaque(true);
	jlbNewUserUsernameStaff.setText("Username:");
	jlbNewUserUsernameStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbNewUserUsernameStaff);

	jtfNewUserUsernameStaff.setLocation(575,175);
	jtfNewUserUsernameStaff.setSize(150,50);
	jtfNewUserUsernameStaff.setText("");
	jtfNewUserUsernameStaff.setColumns(10);
	staffPanel.add(jtfNewUserUsernameStaff);

	jtfUsernameStaff.setLocation(175,100);
	jtfUsernameStaff.setSize(150,50);
	jtfUsernameStaff.setText("");
	jtfUsernameStaff.setColumns(10);
	staffPanel.add(jtfUsernameStaff);

	jlbNewUserPasswordStaff.setLocation(450,250);
	jlbNewUserPasswordStaff.setSize(125,50);
	jlbNewUserPasswordStaff.setOpaque(true);
	jlbNewUserPasswordStaff.setText("Password:");
	jlbNewUserPasswordStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbNewUserPasswordStaff);

	jlbNewUserVerifyPasswordStaff.setLocation(450,325);
	jlbNewUserVerifyPasswordStaff.setSize(125,50);
	jlbNewUserVerifyPasswordStaff.setOpaque(true);
	jlbNewUserVerifyPasswordStaff.setText("Verify Password:");
	jlbNewUserVerifyPasswordStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbNewUserVerifyPasswordStaff);

	jpfNewPasswordStaff.setLocation(175,250);
	jpfNewPasswordStaff.setSize(150,50);
	jpfNewPasswordStaff.setText("");
	jpfNewPasswordStaff.setColumns(10);
	jpfNewPasswordStaff.setEchoChar('*');
	staffPanel.add(jpfNewPasswordStaff);

	jpfReTypePasswordStaff.setLocation(175,325);
	jpfReTypePasswordStaff.setSize(150,50);
	jpfReTypePasswordStaff.setText("");
	jpfReTypePasswordStaff.setColumns(10);
	jpfReTypePasswordStaff.setEchoChar('*');
	staffPanel.add(jpfReTypePasswordStaff);

	jpfNewUserPasswordStaff.setLocation(575,250);
	jpfNewUserPasswordStaff.setSize(150,50);
	jpfNewUserPasswordStaff.setText("");
	jpfNewUserPasswordStaff.setColumns(10);
	jpfNewUserPasswordStaff.setEchoChar('*');
	staffPanel.add(jpfNewUserPasswordStaff);

	jpfNewUserVerifyPasswordStaff.setLocation(575,325);
	jpfNewUserVerifyPasswordStaff.setSize(150,50);
	jpfNewUserVerifyPasswordStaff.setText("");
	jpfNewUserVerifyPasswordStaff.setColumns(10);
	jpfNewUserVerifyPasswordStaff.setEchoChar('*');
	staffPanel.add(jpfNewUserVerifyPasswordStaff);

	jlbUsernameStaff.setLocation(50,100);
	jlbUsernameStaff.setSize(125,50);
	jlbUsernameStaff.setOpaque(true);
	jlbUsernameStaff.setText("Username:");
	jlbUsernameStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbUsernameStaff);

	jlbNewUserSecurityQuestionStaff.setLocation(450,400);
	jlbNewUserSecurityQuestionStaff.setSize(125,50);
	jlbNewUserSecurityQuestionStaff.setOpaque(true);
	jlbNewUserSecurityQuestionStaff.setText("Security Question:");
	jlbNewUserSecurityQuestionStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbNewUserSecurityQuestionStaff);

	jlbNewUserSecurityQuestionAnswerStaff.setLocation(450,475);
	jlbNewUserSecurityQuestionAnswerStaff.setSize(125,50);
	jlbNewUserSecurityQuestionAnswerStaff.setOpaque(true);
	jlbNewUserSecurityQuestionAnswerStaff.setText("Answer:");
	jlbNewUserSecurityQuestionAnswerStaff.setBackground( new Color(211,4,6) );
	staffPanel.add(jlbNewUserSecurityQuestionAnswerStaff);

	jtfNewUserAnswerStaff.setLocation(575,475);
	jtfNewUserAnswerStaff.setSize(150,50);
	jtfNewUserAnswerStaff.setText("");
	jtfNewUserAnswerStaff.setColumns(10);
	staffPanel.add(jtfNewUserAnswerStaff);
	
	cmbSecurityQuestion.setSize(250,50);
	cmbSecurityQuestion.setLocation(575,400);
	staffPanel.add(cmbSecurityQuestion);
		
}

public void loadStaffPanel()
{
	//Staff Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	this.setTitle("Staff");
	this.setSize(900,700);
	this.setForeground( new Color(-16777216) );
	this.setBackground( new Color(-986896) );
	this.setVisible(true);
	this.setResizable(true);
	
	staffPanel.setBackground( new Color(211,4,6) );
	staffPanel.setSize(900,700);
	staffPanel.setLocation(0,0);
	createStaffPanel();
	this.add(staffPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	staffPanel.setVisible(true);
	
	if(showMessages==true)	//Tutorial message of staff screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Staff Screen \n > To update a password, enter the username of the user who wishes to update their password, then enter the current password \n Then enter the new password and re-eneter this for verification and click Change Password to update your password \n > To add a new user, initally add a profile picture using the Set Profile Picture button, navigate and select the profile picture for the new user \n Enter the new user's username, password and then verify this password, select a security question and then the answer (case-sensetive) \n Click the Add User to add the new user to the system");
	}
}

public void createSettingsPanel()
{
	//Settings Components characteristics
	
	settingsPanel.add(jbtHomeSettings);
	settingsPanel.add(jbtSaveMessages);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	settingsPanel.add(jlbLogo);
	
	jlbMessagesSettings.setLocation(50,100);
	jlbMessagesSettings.setSize(100,50);
	jlbMessagesSettings.setOpaque(true);
	jlbMessagesSettings.setText("Messages:");
	jlbMessagesSettings.setBackground( new Color(211,4,6) );
	settingsPanel.add(jlbMessagesSettings);

	jrbtnMessagesOnSettings.setLocation(175,100);
	jrbtnMessagesOnSettings.setSize(100,50);
	jrbtnMessagesOnSettings.setText("On");
	jrbtnMessagesOnSettings.setSelected(false);
	jrbtnMessagesOnSettings.setBackground(new Color(211,4,6));
	settingsPanel.add(jrbtnMessagesOnSettings);

	jrbtnMessagesOffSettings.setLocation(300,100);
	jrbtnMessagesOffSettings.setSize(100,50);
	jrbtnMessagesOffSettings.setText("Off");
	jrbtnMessagesOffSettings.setSelected(false);
	jrbtnMessagesOffSettings.setBackground(new Color(211,4,6));
	settingsPanel.add(jrbtnMessagesOffSettings);
	
	jrbtnMessagesOnSettings.addMouseListener(new MouseAdapter()	//Add mouse listsner to On radio button to deselect the Off radio button
	{
		public void mouseClicked(MouseEvent me)
		{
			if(jrbtnMessagesOnSettings.isSelected())
			{
				jrbtnMessagesOffSettings.setSelected(false);
			}
		}
	});
	
	jrbtnMessagesOffSettings.addMouseListener(new MouseAdapter()	//Add mouse listener to Off radio button to deselect the On radio button
	{
		public void mouseClicked(MouseEvent me)
		{
			if(jrbtnMessagesOffSettings.isSelected())
			{
				jrbtnMessagesOnSettings.setSelected(false);
			}
		}
	});
}

public void loadSettingsPanel()
{
	//Settings Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	this.setTitle("Settings");
	this.setSize(546,342);
	this.setVisible(true);
	this.setResizable(true);
	
	settingsPanel.setBackground( new Color(211,4,6) );
	settingsPanel.setSize(546,342);
	settingsPanel.setLocation(0,0);
	createSettingsPanel();
	this.add(settingsPanel);
	
	//Set other panel to invisible, so only the correct panel is used/seen by the user
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);	
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	settingsPanel.setVisible(true);	
	
	if(showMessages==true)	//Tutorial message of settings screen
	{
		JOptionPane.showMessageDialog(null,"> This is the Settings Screen \n > To continue seeing instruction messages click On and the Save button, otherwise click Off and the Save button");
	}
	
}

public void createReportViewPanel()
{
	reportViewPanel.add(jbtBackReportView);
	reportViewPanel.add(jbtHomeReportView);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	reportViewPanel.add(jlbLogo);
}

public void loadReportViewPanel()
{
	//ReportView Panel characteristics
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	this.setTitle("Shri Ram Stores - Report");
	this.setSize(800,600);
	this.setVisible(true);
	this.setResizable(true);
	
	reportViewPanel.setBackground( new Color(211,4,6) );
	reportViewPanel.setSize(800,600);
	reportViewPanel.setLocation(0,0);	
	createReportViewPanel();
	this.add(reportViewPanel);

	//Set other panel to invisible, so only the correct panel is used/seen by the user	
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);	
	settingsPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(false);
	reportViewPanel.setVisible(true);
}

public void createForgottonPasswordPanel()
{
	forgottonPasswordPanel.add(jbtLoginForgottonPassword);
	forgottonPasswordPanel.add(jbtSubmitUsernameForgottonPassword);
	forgottonPasswordPanel.add(jbtSubmitAnswerForgottonPassword);
	
	jlbLogo.setIcon( new ImageIcon("Logo.jpg") );	//Logo filename
	jlbLogo.setSize(197,30); 	//Logo pixel size
	jlbLogo.setLocation(0,0); 	//Location on panel
	forgottonPasswordPanel.add(jlbLogo);
	
	jlbUsernameForgottonPassword.setLocation(50,60);
	jlbUsernameForgottonPassword.setSize(100,50);
	jlbUsernameForgottonPassword.setOpaque(true);
	jlbUsernameForgottonPassword.setText("Username:");
	jlbUsernameForgottonPassword.setBackground( new Color(211,4,6) );
	forgottonPasswordPanel.add(jlbUsernameForgottonPassword);

	jtfUsernameForgottonPassword.setLocation(180,60);
	jtfUsernameForgottonPassword.setSize(200,50);
	jtfUsernameForgottonPassword.setText("");
	jtfUsernameForgottonPassword.setColumns(10);
	forgottonPasswordPanel.add(jtfUsernameForgottonPassword);

	jlbSecurityQuestionForgottonPassword.setLocation(50,200);
	jlbSecurityQuestionForgottonPassword.setSize(105,50);
	jlbSecurityQuestionForgottonPassword.setOpaque(true);
	jlbSecurityQuestionForgottonPassword.setText("Security Question:");
	jlbSecurityQuestionForgottonPassword.setBackground( new Color(211,4,6) );
	forgottonPasswordPanel.add(jlbSecurityQuestionForgottonPassword);

	jtfSecurityQuestionForgottonPassword.setLocation(180,200);
	jtfSecurityQuestionForgottonPassword.setSize(200,50);
	jtfSecurityQuestionForgottonPassword.setText("");
	jtfSecurityQuestionForgottonPassword.setColumns(10);
	jtfSecurityQuestionForgottonPassword.setEditable(false);
	forgottonPasswordPanel.add(jtfSecurityQuestionForgottonPassword);

	jlbAnswerForgottonPassword.setLocation(50,270);
	jlbAnswerForgottonPassword.setSize(105,50);
	jlbAnswerForgottonPassword.setOpaque(true);
	jlbAnswerForgottonPassword.setText("Answer:");
	jlbAnswerForgottonPassword.setBackground( new Color(211,4,6) );
	forgottonPasswordPanel.add(jlbAnswerForgottonPassword);

	jtfAnswerForgottonPassword.setLocation(180,270);
	jtfAnswerForgottonPassword.setSize(200,50);
	jtfAnswerForgottonPassword.setText("");
	jtfAnswerForgottonPassword.setColumns(10);
	forgottonPasswordPanel.add(jtfAnswerForgottonPassword);

	jlbPasswordForgottonPassword.setLocation(50,410);
	jlbPasswordForgottonPassword.setSize(100,50);
	jlbPasswordForgottonPassword.setOpaque(true);
	jlbPasswordForgottonPassword.setText("Password:");
	jlbPasswordForgottonPassword.setBackground( new Color(211,4,6) );
	forgottonPasswordPanel.add(jlbPasswordForgottonPassword);

	jtfPasswordForgottonPassword.setLocation(180,410);
	jtfPasswordForgottonPassword.setSize(200,50);
	jtfPasswordForgottonPassword.setText("");
	jtfPasswordForgottonPassword.setColumns(10);
	forgottonPasswordPanel.add(jtfPasswordForgottonPassword);
	System.out.println("Load Forgotton Password Panel");

}

public void loadForgottonPasswordPanel()
{
	//Forgotton Password Panel characteristics	
	
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	this.setTitle("Shri Ram Stores - Forgotton Password");
	this.setSize(615,592);
	this.setVisible(true);
	this.setResizable(true);
	
	forgottonPasswordPanel.setBackground( new Color(211,4,6) );
	forgottonPasswordPanel.setSize(615,592);
	forgottonPasswordPanel.setLocation(0,0);	
	createForgottonPasswordPanel();
	this.add(forgottonPasswordPanel);

	//Set other panel to invisible, so only the correct panel is used/seen by the user		
	loginPanel.setVisible(false);
	homePanel.setVisible(false);
	itemsPanel.setVisible(false);
	reStockListPanel.setVisible(false);
	salesPanel.setVisible(false);
	reportPanel.setVisible(false);
	bankingPanel.setVisible(false);
	staffPanel.setVisible(false);	
	settingsPanel.setVisible(false);
	reportViewPanel.setVisible(false);
	forgottonPasswordPanel.setVisible(true);
	
	//Tutorial message on Forgotton Password Screen
	JOptionPane.showMessageDialog(null,"> To retrieve your forgotton password, initally enter your Username and click the Submit Username button \n > This will then bring up your security question,  answer this using the Answer field and click Submit Answer, if the answer is correct, your password will be brought up");
	
}

public void createItemsTable()
{
	//Make Items Table
	itemsTable = new JTable();	
	
	itemsTableModel.setColumnIdentifiers(itemsTableHeaders); //Headers of items table set to itemsTableHeaders[] 
	itemsTable.setModel(itemsTableModel);
	
	TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(itemsTable.getModel());	//Setup new sorter for items table
	itemsTable.setRowSorter(sorter2);	//Sort itemsTable using sorter2
	ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);	//Array list of 25 keys (alphabetical)
	sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));	//Sort by descending following key for ArrayList for ItemCode upon load
	sorter2.setSortKeys(sortKeys);
	
	//Items Table characteristics
	JScrollPane itemsTableScroll = new JScrollPane(itemsTable);	
	itemsTableScroll.getViewport().setBackground(new Color(211,4,6));
	itemsTableScroll.setSize(700,500); 
	itemsTableScroll.setLocation(20,40); 
	itemsPanel.add(itemsTableScroll);	
	
	itemsTableModel.setRowCount(0);
	
	
	//Key Listener to filter Items Table when searching for items
	jtfSearchItems.addKeyListener(new KeyAdapter()
    {
        public void keyPressed(KeyEvent ke)
        {
            try
			{
				Robot r = new Robot();	//Robot set up to press Enter automatically upon keyPressed, to automatically filter/update items table
				r.keyPress(KeyEvent.VK_ENTER);
			}
			catch(Exception e)
			{	
				System.out.println("User is editing something in TextField" + e);
			}
			
			if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
            {
               	final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(itemsTableModel); //Sorter for itemsTableModel
				itemsTable.setRowSorter(sorter);
				
				String text = jtfSearchItems.getText();
				if (text.length() == 0) //If text field is empty, do not filter table
				{
				  sorter.setRowFilter(null);
				} 
				else 
				{
				  sorter.setRowFilter(RowFilter.regexFilter(text)); //Else filter using text within text field
				}
            }
        }
    });
	
	itemsTable.addMouseListener(new MouseAdapter()	//Add mouse listsner to items table
	{
		public void mouseClicked(MouseEvent me)
		{
			int theRow = itemsTable.rowAtPoint(me.getPoint());	//Get row index of clicked cell within table	
			int theColumn = itemsTable.columnAtPoint(me.getPoint());	//Get column index of clicked cell within table
			int modelRow = itemsTable.convertRowIndexToModel(theRow); //Update indexes of filtered table
			
			tempItem = itemsTable.getModel().getValueAt(modelRow,theColumn);	//Set object to data within selected cell
			
			System.out.println(tempItem);

			theRowToRemove = itemsTable.rowAtPoint(me.getPoint());	//Get int of selected row to then be used to remove this
			
		}
	});
	
	loadItemsTable(); //Add details to the items table upon load
}

public void loadItemsTable()
{
	//Read Items Text File and Fill Table
	outputFileToTable(itemsTextFile, itemsTableModel);
}

public void createReStockTable()
{
	//Create ReStock Table
	reStockTable = new JTable();

	reStockTableModel.setColumnIdentifiers(reStockTableHeaders);	//ReStockTable headers based off itemsTableHeaders[]
	reStockTable.setModel(reStockTableModel);

	TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(reStockTableModel);	//Setup new sorter for restock table
	reStockTable.setRowSorter(sorter);	//Sort itemsTable using sorter2
	ArrayList<RowSorter.SortKey> sortKeys2 = new ArrayList<>(25);	//Array list of 25 keys (alphabetical)
	sortKeys2.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));	//Sort by ascending following key for ArrayList for ItemCode upon load
	sorter.setSortKeys(sortKeys2);
	
	//reStockTable characteristics
	JScrollPane reStockTableScroll = new JScrollPane(reStockTable);
	reStockTableScroll.getViewport().setBackground(new Color(211,4,6));
	reStockTableScroll.setSize(870,350); 
	reStockTableScroll.setLocation(20,40); 
	reStockListPanel.add(reStockTableScroll);	

	reStockTableModel.setRowCount(0);
	
	loadReStockTable();	//Add details to the restock table upon load

}

public void loadReStockTable()
{
	//Read ReStock Text File and Fill Table
	outputFileToTable(reStockTextFile, reStockTableModel);
}

public void createSalesSearchTable()
{
	//Create Sales Table (Search)
	salesSearchTable = new JTable();	
	
	salesSearchTableModel.setColumnIdentifiers(salesSearchHeaders); //salesSearchTable headers based off salesSearchHeaders[]
	salesSearchTable.setModel(salesSearchTableModel);

	//salesSearchTable characteristics
	JScrollPane salesSearchTableScroll = new JScrollPane(salesSearchTable);
	salesSearchTableScroll.getViewport().setBackground(new Color(211,4,6));
	salesSearchTableScroll.setSize(200,500); 
	salesSearchTableScroll.setLocation(350,25); 
	salesPanel.add(salesSearchTableScroll);	

	salesSearchTableModel.setRowCount(0);
	
	//Key Listener to filter Sales Search Table when searching for items
	jtfItemCodeSales.addKeyListener(new KeyAdapter()
    {
        public void keyPressed(KeyEvent ke)
        {
            if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
            {
                try
				{
					Robot r = new Robot();			//automatically press Enter upon a key being pressed/released, to update the JTable
					r.keyPress(KeyEvent.VK_ENTER);
				}
				catch(Exception e)
				{	
					System.out.println("User is editing something in TextField" + e);
				}
				
				final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(salesSearchTableModel); //Sorter for salesSearchTableModel
				salesSearchTable.setRowSorter(sorter);
				
				String text = jtfItemCodeSales.getText();
				if (text.length() == 0) //If text field is empty, do not filter table
				{
				  sorter.setRowFilter(null);
				} 
				else //Else filter using text within text field
				{
				  sorter.setRowFilter(RowFilter.regexFilter(text));
				}
		    }
        }
    });
	
	//Key Listener to filter Sales Search Table when searching for items
	jtfItemNameSales.addKeyListener(new KeyAdapter()
    {
        public void keyPressed(KeyEvent ke)
        {
            if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
            {
                try
				{
					Robot r = new Robot();	//Robot set up to press enter automatically upon keyPressed, to automatically filter/update items table
					r.keyPress(KeyEvent.VK_ENTER);
				}
				catch(Exception e)
				{	
					System.out.println("User is editing something in TextField" + e);
				}
				//System.out.println("User is editing something in TextField");
				final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(salesSearchTableModel); //Sorter for salesSearchTableModel
				salesSearchTable.setRowSorter(sorter);
				
				String text = jtfItemNameSales.getText();
				if (text.length() == 0) //If text field is empty, do not filter table
				{
				  sorter.setRowFilter(null);
				} 
				else //Else filter using text within text field
				{
				  sorter.setRowFilter(RowFilter.regexFilter(text));
				}
            }
        }
    });
	
	//Store value clicked within cell of SalesSearchTable using Mouse Listener
	salesSearchTable.addMouseListener(new MouseAdapter()
	{
		public void mouseClicked(MouseEvent me)
		{
			int theRow = salesSearchTable.rowAtPoint(me.getPoint());	//Get row index of clicked cell within table	
			int theColumn = salesSearchTable.columnAtPoint(me.getPoint());	//Get column index of clicked cell within table
			int modelRow = salesSearchTable.convertRowIndexToModel(theRow); //Update indexes of filtered table
			
			tempItem = salesSearchTable.getModel().getValueAt(modelRow,theColumn);	//Set object to data within selected cell
			
			System.out.println(tempItem);
			
			String searchValue = (String.valueOf(tempItem));//Run read method from itemList, read items.txt and search for tempItem
			itemL.readFromFile(itemsTextFile, searchValue);
			
			//fill textfields with details of item selected, read from items.txt and split using array.
			String[] splitArray = (itemL.line).split(",");	//When item is found in text file, setup [] containing data of line, split by ","
			jtfItemCodeSales.setText(splitArray[0]);	//Set the text of the item name, to the item name from the line (array position)
			jtfItemNameSales.setText(splitArray[1]);	//Set the text of the item code, to the item code from the line (array position)
			jtfItemPriceSales.setText(splitArray[5]);	//Set the text of the item price, to the item price from the line (array position)
		}
	});
	
	loadSalesSearchTable();
	
}
	
public void loadSalesSearchTable()
{
	//Read Items Text File and Fill Table
	outputFileToTable(itemsTextFile, salesSearchTableModel);
}

public void createSalesOrderTable()
{
	//Create Sales Table (Order)
	salesOrderTable = new JTable();	
	
	salesOrderTableModel.setColumnIdentifiers(salesOrderHeaders); //salesOrderTableModel headers based off salesOrderHeaders[]
	salesOrderTable.setModel(salesOrderTableModel);

	//salesOrderTable characteristics
	JScrollPane salesOrderTableScroll = new JScrollPane(salesOrderTable);
	salesOrderTableScroll.getViewport().setBackground(new Color(211,4,6));
	salesOrderTableScroll.setSize(550,500); 
	salesOrderTableScroll.setLocation(600,25); 
	salesPanel.add(salesOrderTableScroll);	

	salesOrderTableModel.setRowCount(0);

	totalMoney = 0.0;	//Set total money to null upon empty sales order table
	
}


//This method will run whenever an item is attempted to be added to the current sale
//When a user attempts to add an item to the current order, the item must have valid details else it will not pass validation, causing an error message to appear
//When an item is selected from the Sales Search table, the items details are temporarily stored as the itemL.line
//Each item detail is stored, and the subtotal is calculated using the quantity set multiplied by the sale price of the item selected
//When this is calculated, a row is added to the sales order table containing details of the item code, item name, quantity within sale,
	//single sale price and the subtotal for the item
//Round each monetary value to a maximum of 2 decimal places


public void addItemToSalesOrderTable()
{
	
	//Adding item to Sales Order Table, Fill textfields with details of item selected, read from items.txt and split using array.
	if(itemL.line == null)	//There must be an item selected from the Sales Search table
	{
		JOptionPane.showMessageDialog(null,"Unable to add Item \n No item has been selected");	//Error message for no item selected
	}
	try
	{	
		String[] splitArray = (itemL.line).split(",");	//Split the line of the selected item
		if((jtfItemCodeSales.getText().isEmpty()==false) && ((Integer.parseInt(jtfQuantitySales.getText()))<=100) && (jtfItemNameSales.getText().isEmpty()==false)
			&& (jtfItemPriceSales.getText().isEmpty()==false))	//Validation for sale details, presence checks, and quantity must be less than 100
		{
			int itempQuantity = (Integer.parseInt(jtfQuantitySales.getText()));					//Sale quantity less than or equal 100
			Double tempPrice = Double.parseDouble(splitArray[5]);								//The tempPrice of the item (sale price of item)
			Double tempSubtotal = (Math.round((itempQuantity * tempPrice)*100.00)/100.00);		//Calculate subtotal of the item using quantity selected and sale price and rounding answer to max 2 decimal places
			salesOrderTableModel.addRow(new Object[]{splitArray[0],splitArray[1],itempQuantity, tempPrice, tempSubtotal});	//Add all item details to the current sale table
			totalMoney = totalMoney + tempSubtotal;												//Calculate total amount of order
			jtfTotalPriceSales.setText(""+(Math.round((totalMoney)*100.00)/100.00));			//Add the total price of the order and add this to the text field to display total of current order
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Unable to add Item \n Details are invalid");	//Show error message if details for item are incorrect
		}
		
	}
	catch(Exception exc)
	{
		JOptionPane.showMessageDialog(null,"Unable to add Item \n Details are invalid");
	}
	
}

//This method will be run when an order is being processed
//A boolean value has been set to ensure that validation is passed before processing an order
//Initally an ID is generated for a sale using a method to find the saleID and add one to this, to ensure there is a unique ID for each sale
//The current date and time of the sale is also stored with the sale
//A loop is made through each cell in the sales order table, aswell as storing the total price of the order, and is then written to the text file and is added as an individual sale
//The sales screen is reset after each sale

public void payForOrder()	
{
	try
	{	
		boolean processOrderValidation = true;				//Only process order is boolean is true (validation)
		
		int generatedID = salesL.createSalesID();				//Create new sales ID, set int of generatedID to value of method to createSalesID
		newSale.saleID = generatedID;
		System.out.println("generatedID is " + generatedID);
		
		DateFormat dmy = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	//New date format of dd/mm/yyyy hh/mm/ss
		Date date = new Date();											//Date of type date setup
		System.out.println(dmy.format(date));							//Output current date in sdf format
		newSale.saleDateTime = dmy.format(date);						//Set saleDateTime to current date and time

		if(jtfTotalPriceSales.getText()!=null)
		{
			newSale.saleTotalPrice = (Math.round((Double.parseDouble(jtfTotalPriceSales.getText())*100.0)/100.0));		//Total of order is set to text field value, holding value of total price of order
		}
		else
		{
			processOrderValidation = true;	//
		}
		int rowCount = salesOrderTable.getRowCount();					//Get rowCount of orderTable
		int columnCount = salesOrderTable.getColumnCount();				//Get columnCount of orderTable
		orderTableData = new Object[rowCount][columnCount];				//Get orderTableData
		
		if(rowCount == 0)
		{ 
			JOptionPane.showMessageDialog(null,"Unable to complete order \n No items have been added");
			processOrderValidation = false;		//If no items have been added, do not process order
		}
		
		if(processOrderValidation==true)		//Only process order if boolean is true
		{	
			for (int row = 0; row < rowCount; row++)						//Loop through rows
			{
				for (int column = 0; column < columnCount; column++)		//Loop through columns
				{
					orderTableData[row][column] = salesOrderTable.getValueAt(row,column);	//Get data within each cell of salesOrderTable
								
						if(column == 0)
						{
							newSale.saleItemCode = orderTableData[row][column].toString();	//Column 0 is the item code, set itemCode to the itemCode within Sales class
						}
						
						if(column == 1)
						{
							newSale.saleItemName = orderTableData[row][column].toString();	//Column 1 is the item code, set itemName to itemName wihtin the Sales class
						}
						
						if(column == 2)
						{
							newSale.saleQuantity = Integer.parseInt(orderTableData[row][column].toString()); 	//Column 2 is the item code, set itemQuantity to quantity in Sales class
						}
						
						if(column == 4)	
						{
							newSale.saleSubTotal = Double.parseDouble(orderTableData[row][column].toString());	//Column 4 is the subtotal, set saleSubTotal to data
							salesL.addSales(newSale);	//Column 4 is the complete item sale, create sale when all details have been saved
							salesL.writeToFile();		//Write sale details to file
							updateItemQuantity(newSale.saleItemCode, newSale.saleQuantity);	//Update the items quantity, passing parameters of item code and quantity in sales
							itemL.wipeItemsFile();			//To update items file, initally wipe ...
							salesL.updateItemsFileSale();		//Update items file with details from tempItemsFile
						}
				}
			}
		}
		
		loadSalesPanel();			//Reset sales panel after each sale
		createSalesOrderTable();
		createSalesSearchTable();
		totalMoney = 0.0;		//Reset total price after each sale is performed
	}
	catch(Exception exc)
	{
		JOptionPane.showMessageDialog(null,"Sale has been cancelled, details are invalid");
	}
	
}

//This method is performed after each sale and the quantity of the item being sold is deducted from the current quantity of the item
//This will search through the Items text file till the item is found and write this line to a temporary file
//The item quantity is updated for this item, before being written to the items temp file
//The other items in the Items text file are added to the temporay file
//The items file is then wiped and the updated using the temporaryItemsFile

public void updateItemQuantity(String itemID, int saleQuantity)		
{
	//Update items quantity in items.txt
	
		try
		{
			File salesIDFile = new File("Sales.txt");									
			BufferedReader br = new BufferedReader(new FileReader(salesIDFile));			//Setup readers of Sales.txt 
			BufferedWriter bw = new BufferedWriter(new FileWriter("tempItemsFile.txt"));	//Setup writer for tempItemsFile.txt
			BufferedReader br2 = new BufferedReader(new FileReader(itemsTextFile));			//Setup reader of items.txt
			String tempLine = br2.readLine();												//Set tempLine to line read from Items.txt
			
			while(tempLine != null)		//While tempLine is not empty
			{
				if(tempLine.contains(itemID))	//If tempLine contains the ID
				{
					String[] tempArray = tempLine.split(",");		//Split line by ,
					int currentQuantity = Integer.parseInt(tempArray[2]);	//set currentQuantity to the quantity of the item
					System.out.println("currentQuantity is "+ currentQuantity);
					int newQuantity = currentQuantity - saleQuantity;		//Calculate the new quantity of the item
					System.out.println("newQuantity is "+ newQuantity);	
					
					if(currentQuantity<=10)	//If the currentQuantity is the less that the quantity being sold, output message for stock needed.
					{
						JOptionPane.showMessageDialog(null,"The quantity of " + tempArray[1] + " is now" + currentQuantity);
					}
					
					tempArray[2] = newQuantity + "";
					String updatedLine = (tempArray[0] + "," + tempArray[1] + "," + tempArray[2] + "," + tempArray[3] + "," + tempArray[4] + "," + tempArray[5] + "," + tempArray[6]);
					bw.write(updatedLine);	//Write the updatedLine to the temporary file
				}
				else
				{
					bw.write(tempLine);		//Write the line to the temporary file					
				}
				bw.newLine();	//New line between each item
				
				tempLine = br2.readLine();	//Set tempLine to next line in items.txt
				
			}
			
			bw.close();		//Close all writers and readers
			br2.close();			
			br.close();
			
		}
		catch(Exception exc)
		{
			System.out.println("ERROR getting salesID " + exc);
		}
		

}

public void createSalesReportTable()
{
	
	//Create ReStock Table
	salesDateTable = new JTable();	
	
	salesDateTableModel.setColumnIdentifiers(salesDateTableHeaders);	//ReStockTable headers based off itemsTableHeaders[]
	salesDateTable.setModel(salesDateTableModel);
		
	//reStockTable characteristics
	JScrollPane salesDateTableScroll = new JScrollPane(salesDateTable);
	salesDateTableScroll.getViewport().setBackground(new Color(211,4,6));
	salesDateTableScroll.setSize(735,450); 
	salesDateTableScroll.setLocation(20,40); 
	reportViewPanel.add(salesDateTableScroll);	

	salesDateTableModel.setRowCount(0);
	
	salesDateTable.setAutoCreateColumnsFromModel( false );
	
	salesDateTable.getColumnModel().getColumn(0).setMinWidth(25);	//Adjust column widths to be able to view all data
	salesDateTable.getColumnModel().getColumn(1).setMinWidth(100);
	salesDateTable.getColumnModel().getColumn(2).setMinWidth(75);
	salesDateTable.getColumnModel().getColumn(3).setMinWidth(75);
	salesDateTable.getColumnModel().getColumn(4).setMinWidth(75);
	salesDateTable.getColumnModel().getColumn(5).setMinWidth(75);
	salesDateTable.getColumnModel().getColumn(6).setMinWidth(75);

}

public void loadBankingReport()
{
	String tempArray[] = (bankingL.line.split(","));	//Once line has been found split line into array holding each banking detail
	jtfDateBanking.setText(tempArray[0]);				//Set text of each banking detail to relevant tempArray position
	jtfTotalNetBanking.setText(tempArray[1]);
	jtfFloatBanking.setText(tempArray[2]);
	jtfCashBanking.setText(tempArray[3]);
	jtfCreditCardBanking.setText(tempArray[4]);
	jtfMiscBanking.setText(tempArray[5]);
	jtfTotalBanking.setText(tempArray[6]);
	jtfProfitBanking.setText(tempArray[7]);	
	
	jbtSaveBanking.setVisible(false);			//As this screen is based on the Banking screen, the Save and Print button are removed as they are not required.
	jbtPrintBanking.setVisible(false);
	jbtBackReportViewBanking.setVisible(true);	//Add a back button to this screen
	
}

//To update a staff password
//The user must intially enter their username which is matched within the Staff text file, otherwise an error message is produced
//The current password must be equal to the decrypted text from the second position on the current line
//Also the two new passwords entered must be matched, to be correctly verfied
//The password is then updated by udpating the line and adding this to a temporary staff file
//All other users are also then added back to the temporary file
//The original staff file is wiped and updated using the contents of the temporary staff file

public void updateStaffPassword()
{
	staffL.readFromFile("Staff.txt" , jtfUsernameStaff.getText());		//Run read method using Staff.txt and entered username
	if(staffL.updateUserFound == true)									//If username is found
	{
		String[] tempArray = (staffL.tempLine.split(","));				//Split string into array by ,
		if(jpfCurrentPasswordStaff.getText().equals(staffL.decryptString(tempArray[1])))		//If the entered password matches the password in the line
		{
			if(((jpfNewPasswordStaff.getText()).equals(jpfReTypePasswordStaff.getText()))&&((jpfNewPasswordStaff.getText().length()>=8)))	//If the password has been successfully verified
			{
				System.out.println("Update password");
				String newPassword = staffL.encryptString(jpfNewPasswordStaff.getText());		//Get the text of the new password and encrypt this
				try
				{
					File staffFile = new File("Staff.txt");									
					BufferedReader br = new BufferedReader(new FileReader(staffFile));			//Setup reader of Sales.txt 
					BufferedWriter bw = new BufferedWriter(new FileWriter("tempStaffFile.txt"));	//Setup writer for tempStaffFile.txt
					String tempLine = br.readLine();												//Set tempLine to line read from Items.txt
					
					while(tempLine != null)		//While tempLine is not empty
					{
						if(tempLine.contains(tempArray[0]))	//If tempLine contains the ID
						{
							String updatedLine = (tempArray[0] + "," + newPassword + "," + tempArray[2] + "," + tempArray[3] + "," + tempArray[4]);	//Update the line using the new password
							bw.write(updatedLine);	//Write the updatedLine to the temporary file
						}
						else
						{
							bw.write(tempLine);		//Write the line to the temporary file					
						}
						bw.newLine();	//New line between each item
						
						tempLine = br.readLine();	//Set tempLine to next line in items.txt
					}
					
					bw.close();			
					br.close();
										
					staffL.wipeStaffFile();		//Wipe the current Staff.txt file
					staffL.updateStaffPasswordFile();	//Write the contents of the temporary file to Staff.txt
					
					JOptionPane.showMessageDialog(null,"Password updated successfully");
				
				}
				catch(Exception exc)
				{
					System.out.println("ERROR  " + exc);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Password(s) are invalid");	//Validation for password details being incorrect
			}			
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Details are incorrect");	//Validation for password details being incorrect
		}
	}
	if(staffL.updateUserFound == false)	//Validation for username not found
	{
		JOptionPane.showMessageDialog(null,"Username not found");
	}
	
}

//This method will run during the Forgotton Password function
//The username of a user will be searched using method in the StaffList class
//If the entered username is found, then the security question from the same line is added onto the screen
//Otherwise an error message is produced

public void findUsernameForgottonPassword()
{
	staffL.readFromFile("Staff.txt" , jtfUsernameForgottonPassword.getText());	//Run read method using Staff.txt and entered username
	if(staffL.updateUserFound == true)		//If username is found
	{
		String tempArray[] = (staffL.tempLine.split(","));		//Split string into array by ,
		System.out.println(staffL.tempLine);			
		jtfSecurityQuestionForgottonPassword.setText(tempArray[2]);		//Set the securityQuestion field to the relevant array position
	}
	if(staffL.updateUserFound == false)
	{
		JOptionPane.showMessageDialog(null,"Username not found");	//Validation for forgotton password where username not found
	}
}

//This method will run during the Forgotton Password function
//The answer of the security question will be searched, on the same line, to ensure this is correct
//If the entered answer is correct, then the password will be decrypted and added onto the password field
//Otherwise an error message is produced

public void findPasswordForgottonPassword()
{
	String tempArray[] = (staffL.tempLine.split(","));			//Split line into array ,
	if(jtfAnswerForgottonPassword.getText().equals(tempArray[3]))	//If the entered answer matches the answer in the line
	{
		jtfPasswordForgottonPassword.setText(staffL.decryptString(tempArray[1]));		//Show the password on the screen
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Answer is incorrect");	//Validation for forgotton password where username is incorrect
	}
}

//This method is called upon multiple times throughtout the system
//Details stored in text files are searched and outputted to tablemodels which are passed in as parameters
//This will be used when outputting details from a text file to a table to allow it to be presented more clearly.

public void outputFileToTable(String fileName, DefaultTableModel tempTableModel)	
{
	//To output a file to table, input name and table model, Use text file to fill Table
	try
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));	//Setup Reader for inputted filename
		String line = br.readLine();	//Setup temporary variable holding data from line read
		while(line != null) //Loop of while the data is not empty
        {
			String[] details = new String[1000];	//Setup array to hold items
			details[0] = line;	//Set first line to first item in array
			tempTableModel.addRow(line.split(","));	//Add new row to table, split by line of ","
			System.out.println(line);
			line = br.readLine();	//Set line to next line in file
				
			if(line=="")	//When line is empty, break while loop, file has been fully read
			{
				break;
			}
        }
        
		br.close();
     
	}
    catch(IOException exc)
	{
        System.out.println("not" + exc);
		exc.printStackTrace();
    }

}

//This method is called upon multiple times to output table data to a text file
//The method will loop through an object (table) cells and capture the data in each before writing this data to the text file added


public void writeToDisk(Object[][] aData, String aDatafile)
{
	//Output table to text file, loop through each cell and get data and store as an object
    try
    {
        FileOutputStream fout =  new FileOutputStream(aDatafile, false);		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));		//Output table details to file parameter

        for (int row = 0; row < aData.length; row++) //for all rows within specified table
        {

			for (int column = 0; column < aData[row].length; column++) //for all columns within specified table
			{

				if(aData[row][column] == null)
				{
				  bw.append("null");
				  bw.append(',');	// The comma separated value
				}
				else
				{
					bw.append(aData[row][column].toString());		//Convert cell[][] in table to single string
					bw.append(',');
				}

			}//end column loop (inner loop)

			bw.newLine();

        }//end row loop (outer loop)

			bw.close();

    }
    catch (Exception e)
    {
        e.getStackTrace();
    }

}

public void actionPerformed(ActionEvent e)
{
	
	//Login Actions
	
	if(e.getSource()==jbtHomeLogin)
	{
		System.out.println("Home button has been pressed");
	}
	
	//Method to allow logging into the system
	//The username is and password is searched for using a method within the staffList class to find the user
	//The profile picture of the user is also resized to ensure it fits onto the home screen upon logging in.
	//The home panel is loaded if the login credentials are correct, otherwise an error message is produced.
	
	if(e.getSource()==jbtSubmitLogin)
	{
		System.out.println("Submit button has been pressed ");
		String username = jtfUsernameLogin.getText();	//String username is inputted data from text field
		String password = (jpfPasswordLogin.getText());	//String password is inputted data from text field
		staffL.readFromFileLogin(username, password);	//Run readFromFile method from staffList using uername and password parameters
		staffL.reSizeProfilePicture();	//Run re-size profile picture method
		if(staffL.userFound == true)	//If the userfound boolean value from staffList
		{
			System.out.println("Found");
			loadHomePanel();	//Load the Home screen if the user's login credentials are correct
		}
		if(staffL.userFound == false)	//If the user's details are not correct...
		{
			JOptionPane.showMessageDialog(null,"Incorrect Login Credentials");	//Output message that details are incorrect
			jtfUsernameLogin.setText("");
			jpfPasswordLogin.setText("");
		}
		
	}
	
	if(e.getSource()==jbtForgottonPasswordLogin)
	{
		System.out.println("Forgotton Password button has been pressed ");
		loadForgottonPasswordPanel();		//Load the Forgotton Password Screen
	}
	
	//Home Actions
	
	if(e.getSource()==jbtSales)
	{
		 System.out.println("Sales button has been pressed ");
		 loadSalesPanel();		//Load the Sales Screen		 
	}
	
	if(e.getSource()==jbtSettings)
	{
		 System.out.println("Settings button has been pressed ");
		 loadSettingsPanel();	//Load the Settings screen
	}
	
	if(e.getSource()==jbtItems)
	{
		System.out.println("Items button has been pressed ");
		loadItemsPanel();		//Load the Items screen
	}
	
	if(e.getSource()==jbtReport)
	{
		 System.out.println("Report button has been pressed ");
		 loadReportPanel();		//Load the Report screen
	}
	
	if(e.getSource()==jbtReStockList)
	{
		System.out.println("ReStock List button has been pressed ");
		loadReStockListPanel();		//Load Restock list screen
		reStockL.writeToFile();		//Calculate and create ReStock.txt with items to be restocked
	}
	
	if(e.getSource()==jbtBanking)
	{
		 System.out.println("Banking button has been pressed ");
		 loadBankingPanel();		//Load Banking Screen
	}
	
	if(e.getSource()==jbtStaff)
	{
		 System.out.println("Staff button has been pressed ");
		 loadStaffPanel();			//Load Staff screen
	}
	
	if(e.getSource()==jbtLogOut)
	{
		 System.out.println("Log Out button has been pressed ");
		 loadLoginPanel();			//Load login screen
	}
	
	//Items Actions
	
	if(e.getSource()==jbtAddItem)
	{
		itemsTableModel.addRow(new Object[]{null});	//Add new blank row into itemsTable to enter item details
	}
	
	//Upon the Items screen, when saving any changes, the table is unfiltered to ensure that all details appear on screen before saving the table to ensure all details are captured
	//Also a loop is made through each cell, containing individual validation before saving the data
	//This data is stored to an object and written to a text file
	//If validation is broken an error message is produced
	
	if(e.getSource()==jbtSaveItems)
	{
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(itemsTableModel); //Sorter for itemsTable
		itemsTable.setRowSorter(sorter);
		jtfSearchItems.setText(null);		//set search field to null when the save button is clicked, hence whole table is shown and written/updated to file
		sorter.setRowFilter(null);
		
		boolean saveItemValidation = true;			//Validation initally true	
		int rowCount = itemsTable.getRowCount();	//Get row count of items table
        int columnCount = itemsTable.getColumnCount();	//Get column count of items table
        Object[][] curTableData = new Object[rowCount][columnCount];	//Set 2D array of table data to Object of table size
        for ( int row = 0; row < rowCount; row++)	//For all rows
        {
			for (int column = 0; column < columnCount; column++)	//For all columns
            {
				curTableData[row][column] = itemsTable.getModel().getValueAt(row,column);	//Get data from each cell
				if(curTableData[row][column] == null)	//Details in item table cannot be empty
				{
					saveItemValidation=false;
				}
				if(column == 2)	//Item quantity must be less than 1000 and an integer
				{
					try
					{
						int i = (Integer.parseInt(curTableData[row][column].toString()));
						if(i>1000)	
						{
							saveItemValidation = false;
						}
					}
					catch(Exception exc)	//Quantity must be an integer
					{
						saveItemValidation = false;
						JOptionPane.showMessageDialog(null,"Item Quantity must be an integer");
					}
				}
				if(column == 3)	//Item reStock Quantity must be less than 1000 and an integer
				{
					try
					{
						int i = (Integer.parseInt(curTableData[row][column].toString()));
						if(i>1000)
						{
							saveItemValidation = false;
						}
					}
					catch(Exception exc)	//Restock quantity must be int
					{
						saveItemValidation = false;
						JOptionPane.showMessageDialog(null,"Item ReStock Quantity must be an integer");
					}
				}
				if(column == 4)	//Original price cannot be less than £0
				{
					try
					{
						double d = (Double.parseDouble(curTableData[row][column].toString()));
						if(d<0.00)
						{
							saveItemValidation = false;
						}
					}
					catch(Exception exc)	//Original price must be a double
					{
						saveItemValidation = false;
						JOptionPane.showMessageDialog(null,"Item Original Price must be a double (0.00)");
					}
				}
				if(column == 5)	//Sale price must be above £0
				{
					try
					{
						double d = (Double.parseDouble(curTableData[row][column].toString()));
						if(d<=0.00)
						{
							saveItemValidation = false;
						}
					}
					catch(Exception exc)	//Sale price must be a double
					{
						saveItemValidation = false;
						JOptionPane.showMessageDialog(null,"Item Sale Price must be a double (0.00)");
					}	
				}
				if(column == 6)	//Sale price must be above £0
				{
					try
					{
						double d = (Double.parseDouble(curTableData[row][column].toString()));
					}
					catch(Exception exc)	//Profit price must be a double
					{
						saveItemValidation = false;
						JOptionPane.showMessageDialog(null,"Item Profit Price must be a double (0.00)");
					}	
				}
				System.out.println("curTableData["+row+"]["+column+"] = "+curTableData[row][column]);
            }
        }

        if(saveItemValidation==true)	//Only  save item details if validation is passed
		{
			writeToDisk(curTableData,"Items.txt");	//Save items table
			JOptionPane.showMessageDialog(null,"Items table saved successfully");
		}
		if(saveItemValidation==false)	//Otherwise output error message
		{
			JOptionPane.showMessageDialog(null,"Invalid items details");
		}
		 
	}
	
	if(e.getSource()==jbtPrintItems)
	{
		PrintUtilities.printComponent(itemsTable);	//Print items table
	}
	
	
	if(e.getSource()==jbtRemoveItems)
	{
		System.out.println("the row is " + theRowToRemove);
		
		if(theRowToRemove > -1)
		{
			itemsTableModel.removeRow(theRowToRemove);	//Remove row from table
			theRowToRemove = -1;						//Ensure a row has been selected before removing any rows
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Please select a row to remove");	//Error message
		}
	}
	
	if(e.getSource()==jbtHomeItems)
	{
		loadHomePanel();
	}
	
	//ReStock List Actions
	
	if(e.getSource()==jbtPrintReStockList)
	{
		PrintUtilities.printComponent(reStockTable);		//Print reStock Table
	}
	
	if(e.getSource()==jbtHomeReStockList)
	{
		System.out.println("Home button has been pressed");
		loadHomePanel();		
	}
	
	//Sales Actions
	
	if(e.getSource()==jbtAddSales)
	{
		System.out.println("button has been pressed " + tempItem);
		addItemToSalesOrderTable();		//Run the addItemToSalesOrderTable method to add an item to a current order by customer.
	}
	
	
	if(e.getSource()==jbtPaySales)
	{
		payForOrder();		//Upon clicking Pay, process the current order using the payForOrder method
	}
	
	if(e.getSource()==jbtCancelSales)
	{
		loadSalesPanel();
	}
	
	if(e.getSource()==jbtHomeSales)
	{
		System.out.println("Home button has been pressed");
		loadHomePanel();		
	}
	
	//Report Actions
	
	if(e.getSource()==jbtHomeReport)
	{
		
		loadHomePanel();
	}
	
	if(e.getSource()==jbtViewStockReport)
	{
		loadItemsPanel();
	}
	
	if(e.getSource()==jbtPrintStockReport)
	{
		PrintUtilities.printComponent(itemsTable);		//Print items table
	}
	
	if(e.getSource()==jbtViewReStockListReport)
	{
		loadReStockListPanel();
	}
	
	if(e.getSource()==jbtPrintReStockListReport)
	{
		PrintUtilities.printComponent(reStockTable);	//Print reStock Table
	}
	
	if(e.getSource()==jbtViewBankingReport)
	{
		String date = JOptionPane.showInputDialog("Enter Date (DD/MM/YYYY)");	//Input dialogue box to enter date
		if(date.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Please enter a valid date");
		}
		else
		{
			bankingL.readFromFile("Banking.txt", date);		//Search for date in Banking.txt
			if (bankingL.dateFound == false)	//Validation to enter only dates found in Banking.txt
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid date");
			}
			if (bankingL.dateFound == true)
			{
				loadBankingPanel();		//If date found loading Banking panel 
				loadBankingReport();	//With banking details from the relevant date
			}
		}
	}
	
	if(e.getSource()==jbtPrintBankingReport)
	{
		String date = JOptionPane.showInputDialog("Enter Date (DD/MM/YYYY)");	//Input dialogue box to enter date
		if(date.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Please enter a valid date");
		}
		else
		{
			bankingL.readFromFile("Banking.txt", date);		//Search for date in Banking.txt
			if (bankingL.dateFound == false)	//Validation to enter only dates found in Banking.txt
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid date");
			}
			if (bankingL.dateFound == true)
			{
				loadBankingPanel();		//If date found loading Banking panel 
				loadBankingReport();	//With banking details from the relevant date
				PrintUtilities.printComponent(bankingPanel);	//Print banking panel with banking details
			}
		}
	}
	
	if(e.getSource()==jbtViewSalesReport)
	{
		createSalesReportTable();	//Create the sales report table (store sales)
		String date = JOptionPane.showInputDialog("Enter Date (DD/MM/YYYY)");	//Input dialogue box to enter date
		if(date.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Please enter a valid date");
		}
		else
		{
			salesL.readFromFile("Sales.txt", date, salesDateTableModel);			//Search for sales in Sales.txt
			if (salesL.saleFound == false)	//Validation to enter only sales found in Sales.txt
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid date");
			}
			else
			{
				loadReportViewPanel();	//Load the panel and output all sales on date
			}
		}
		
	}
	
	if(e.getSource()==jbtPrintSalesReport)
	{
		createSalesReportTable();	//Create the sales report table (store sales)
		String date = JOptionPane.showInputDialog("Enter Date (DD/MM/YYYY)");	//Input dialogue box to enter date
		if(date.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Please enter a valid date");
		}
		else
		{
			salesL.readFromFile("Sales.txt", date, salesDateTableModel);			//Search for sales in Sales.txt
			if (salesL.saleFound == false)	//Validation to enter only sales found in Sales.txt
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid date");
			}
			else
			{
				loadReportViewPanel();	//Load the panel and output all sales on date
				PrintUtilities.printComponent(salesDateTable);	//Print the salesDateTable of all sales from the date
			}
		}
		
	}
	
	//Banking Buttons
	
	if(e.getSource()==jbtPrintBanking)
	{
		PrintUtilities.printComponent(bankingPanel);	//Print the banking screen
	}
	
	//When the user attempts to save banking details, validation must be passed
	//The date entered must conform to a date format and all other details must be of double as they are all monetary values
	//If validation is not passed an error message is produced
	//Otherwise they are added to Banking class where they are grouped and then written to file using the BankingList class.
	
	if(e.getSource()==jbtSaveBanking)
	{
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");	//New format for date being entered
		formatter.setLenient(false);

		try
		{	
			Date date= formatter.parse(jtfDateBanking.getText());	//Ensure date is validated against the format of a date dd/mm/yyyy
			
			//Validation for banking screen, details must be double (data type) and greater or equal than 0 otherwise error message is produced
			if((jtfDateBanking.getText().isEmpty()==false) && (Double.parseDouble(jtfTotalNetBanking.getText()) >=0) && (Double.parseDouble(jtfFloatBanking.getText()) >=0)
				&& (Double.parseDouble(jtfFloatBanking.getText()) >=0) && (Double.parseDouble(jtfMiscBanking.getText()) >=0)
				&& (Double.parseDouble(jtfCashBanking.getText()) >=0) && (Double.parseDouble(jtfCreditCardBanking.getText()) >=0)
				&& (Double.parseDouble(jtfTotalBanking.getText()) >=0) && (Double.parseDouble(jtfProfitBanking.getText()) >=0))
			{
				newBanking.bankingDate = jtfDateBanking.getText();			//Set date to data in Date field
				newBanking.bankingTotalNet = jtfTotalNetBanking.getText();	//Set Total Net to data in Total Net field
				newBanking.bankingFloat = jtfFloatBanking.getText();		//Set float to data in float field
				newBanking.bankingMisc = jtfMiscBanking.getText();			//Set misc to data in misc field
				newBanking.bankingCash = jtfCashBanking.getText();			//Set cash to data in cash field
				newBanking.bankingCreditCard = jtfCreditCardBanking.getText();	//Set credit card to data in  credit card field
				newBanking.bankingTotalMoney = jtfTotalBanking.getText();		//Set total money to data in total money field
				newBanking.bankingProfit = jtfProfitBanking.getText();		//Set profit to data in profit field
				newBanking.toString();	//To string method for all banking details into single string

				bankingL.addBanking(newBanking);	//Add new banking details to array in BankingList.java
				bankingL.writeToFile();				//Write the new banking details 
				JOptionPane.showMessageDialog(null,"Details Saved Successfully");	//Message to show details saved successfully
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Details are invalid");	//Error message
			}
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null,"Details are invalid");	//Error message
		}
		
	}
	
	if(e.getSource()==jbtBackReportViewBanking)
	{
		loadReportPanel();
	}
	
	if(e.getSource()==jbtHomeBanking)
	{
		loadHomePanel();
	}
	
	
	//Staff Buttons
	
	if(e.getSource()==jbtChangePasswordStaff)
	{
		updateStaffPassword();
	}
	
	//When the user selects a profile picture for themselves, a new file chooser appears
	//When a file is selected, the complete directory of the file is stored to ensure it can be sourced easily
	
	if(e.getSource()==jbtNewUserProfilePictureStaff)
	{
		int returnVal = jfcProfilePictureChooser.showOpenDialog(this);		//File selection dialog box
		jfcProfilePictureChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);	//Get full directory of file for profile picture
		theFilename = jfcProfilePictureChooser.getSelectedFile().getAbsolutePath();	//Get directory of file chosen set to Filename
		System.out.println("" + theFilename);
	}
	
	//When adding a new user, intially a presence check is implemented and the password entered must be verified and be atleast 8 characters long
	//The security question from the combo box is also stored
	//All details are stored using a text file including username, the password which is encrypted before storing, securtity question and asnwer and profile picture location
	//Staff details are captured and grouped using the Staff class and these details are then written to file using StaffList class
	
	if(e.getSource()==jbtAddUserStaff)
	{
		Object tempSecurityQuestion = cmbSecurityQuestion.getSelectedItem();	//Store selected security question
		
		if((jtfNewUserUsernameStaff.getText().isEmpty()==false) && ((jpfNewUserPasswordStaff.getText().length()>=8)) 
			&& ((jpfNewUserPasswordStaff.getText()).equals(jpfNewUserVerifyPasswordStaff.getText())) 
			&& (jtfNewUserAnswerStaff.getText().isEmpty()==false))				
			//Password must be 8 characters long, verify passwords using both new password and re-entered password, data must be entered into all fields (cannot be null), profile picture selection
		{
			newStaff.username = jtfNewUserUsernameStaff.getText();	//New username of staff in Staff.javastaffL.encryptString(jpfNewUserPasswordStaff.getText());	
			newStaff.password = staffL.encryptString(jpfNewUserPasswordStaff.getText());	//New password of staff in Staff.java after encryption		
			newStaff.securityQuestion = tempSecurityQuestion.toString();	//Selected security question of staff in Staff.java
			newStaff.securityQuestionAnswer = jtfNewUserAnswerStaff.getText();	//Answer to question of staff in staff.java
			newStaff.profilePicture = theFilename;	//Profile picture directory
			newStaff.toString();	//All new staff details to single string (combined)

			staffL.addStaff(newStaff);	//Add new staff member to array
			staffL.writeToFile();		//Write array to file to add new staff user
			JOptionPane.showMessageDialog(null,"User Added Successfully");	//Message to show details saved successfully
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"New user details are invalid, please check the information");	//Validation error message for invalid staff details
			System.out.println("Invalid new user");
		}

	}
	
	if(e.getSource()==jbtHomeStaff)
	{
		loadHomePanel();
	}
	
	//Settings Buttons
	
	if(e.getSource()==jbtHomeSettings)
	{
		loadHomePanel();
	}
	
	if(e.getSource()==jbtSaveMessages)
	{
		if(jrbtnMessagesOnSettings.isSelected()==true)
		{
			showMessages = true;	//If show messages is set to on, show instructions on each page
			JOptionPane.showMessageDialog(null,"Changes have been saved");
		}
		
		if(jrbtnMessagesOffSettings.isSelected()==true)
		{
			showMessages = false;	//If show messages is set to off, do not show instructions on each page
			JOptionPane.showMessageDialog(null,"Changes have been saved");
		}
		
	}
	
	//Report View Panel
	
	if(e.getSource()==jbtHomeReportView)
	{
		loadHomePanel();
	}
	
	if(e.getSource()==jbtBackReportView)
	{
		loadReportPanel();
	}
	
	//Forgotton Password Panel
	
	if(e.getSource()==jbtSubmitUsernameForgottonPassword)
	{
		findUsernameForgottonPassword();		//Run method to search for the username entered and output the security question
	}
	
	if(e.getSource()==jbtSubmitAnswerForgottonPassword)
	{
		findPasswordForgottonPassword();		//Run method to search for answer entered and output the password of the user
	}
	
	if(e.getSource()==jbtLoginForgottonPassword)
	{
		loadLoginPanel();
	}
	
} 

public static void main(String[] args) // this calls the method to run the GUI
{ 
	ShriRamStores srs = new ShriRamStores();
	srs.loadLoginPanel();
	srs.startButtons();
}
  
}