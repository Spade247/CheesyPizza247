//Yonas Sisay 
/* Cheesy Pizza System is a software that helps assists pizza stores record orders in a timely manner with the order being put 
	by the user themselves. This program will also store records in a text file for store personnel to access only */

//Import all relevent classes and packages
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import java.awt.Image;


 class Cheesy_Pizza_System_247 
{
	public static void main(String[] args)throws IOException
	{
		
		//Setup Current Date
		Date date=new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week=cal.get(Calendar.DAY_OF_WEEK);
		int am_pm=cal.get(Calendar.AM_PM);
		int hour=cal.get(Calendar.HOUR);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		final String DATEOFENTRY;
		
		//Store the current date in a variable 
		DATEOFENTRY=day+"/"+month+"/"+year+" "+hour+":"+minute+":"+second;

		//Create Decimal format
		final DecimalFormat FMT=new DecimalFormat("#.00");

		//CREATE FRAME 1
		final JFrame FRAME=new JFrame("Cheesy Pizza System 247");
		FRAME.setLocationRelativeTo(null);

		//CREATE YOUR ORDER TEXT FIELD
		final JTextArea YOURORDERTXTFIELD=new JTextArea(20,60);
		YOURORDERTXTFIELD.setText("\t\t\t  YOUR ORDER\n************************************************************");
		
		//CREATE A JTEXTAREA TO STORE THE TOTAL AMOUNT OF THE PIZZAS 
		final JTextArea TOTALAMOUNTTXTFIELD=new JTextArea(26,50);
		TOTALAMOUNTTXTFIELD.setVisible(false);
		
		//CREATE A JTEXTAREA TO STORE THE TOTAL AMOUNT OF THE ORDER
		final JTextArea TOTALAMOUNTTXTFIELD2=new JTextArea(26,50);
		TOTALAMOUNTTXTFIELD2.setVisible(false);
		TOTALAMOUNTTXTFIELD2.append(""+0.0);

		//CREATE NEXT BUTTON
		final JButton BTNNEXT=new JButton("NEXT");
		BTNNEXT.setEnabled(false);
		//CREATE DONE BUTTON
		final JButton BTNDONE=new JButton("DONE");
		BTNDONE.setEnabled(false);

		//CREATE WELCOME LABEL FOR FRAME 1
		JLabel lblWelcome=new JLabel("Welcome To Cheesy Pizza 24/7");
		//set the font and size of the welcome label 
		lblWelcome.setFont(new Font("Times New Roman",Font.BOLD,45));
		//create a JPanel to for the topcenter of FRAME 1
		JPanel topCenterPanel=new JPanel();
		topCenterPanel.add(lblWelcome,BorderLayout.CENTER);
		FRAME.add(topCenterPanel,BorderLayout.NORTH);

		//CREATE PIZZAS LIST
		//create a list of all the pizzas 
		final String[] NAMEOFPIZZAS={"Aussie","Peri Peri Chicken","Hawaiian","Mexican","Margherita","Vegeterian","Lamb Suva(Halal)"};
		//create a panel to store all relevent pizzas
		JPanel pizzaListPanel=new JPanel();
		//create a vertical box to arrange all the pizzas in vertical list 
		Box verticalPizzaList = Box.createVerticalBox();
		pizzaListPanel.add(verticalPizzaList);

		//create a titled border for the combobox named Pizza
		final TitledBorder PIZZALISTTITLE=new TitledBorder("PIZZA");
		//set the titled border as the border for the pizza list combo box
		pizzaListPanel.setBorder(PIZZALISTTITLE);
		//position the title of the title for the combo box at the center
		PIZZALISTTITLE.setTitleJustification(TitledBorder.CENTER);
		
		//Display all the labels of the pizzas within the vertical pizza list box 
		for (int i=0;i<NAMEOFPIZZAS.length ;i++ )
		{	
			JLabel lblnameOfPizzas=new JLabel(NAMEOFPIZZAS[i]);
			//set the font and size of the labels 
			lblnameOfPizzas.setFont(new Font("Times New Roman", Font.BOLD, 17));
			verticalPizzaList.add(lblnameOfPizzas);

		}
		//create a vertical pizza list radiobuttons box to arrange radiobuttons in a vertical list 
		Box verticalPizzaListRadioButtons = Box.createVerticalBox();
		pizzaListPanel.add(verticalPizzaListRadioButtons);

		//CREATE RADIO BUTTONS FOR PIZZA LIST 
		//Store each radio Button within the vertical pizza list radiobuttons box 
		final JRadioButton RBAUSSIE=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBAUSSIE);
		final JRadioButton RBPERIPERICHICKEN=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBPERIPERICHICKEN);
		final JRadioButton RBHAWAIIAN=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBHAWAIIAN);
		final JRadioButton RBMEXICAN=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBMEXICAN);
		final JRadioButton RBMARGHERITA=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBMARGHERITA);
		final JRadioButton RBVEGETARIAN=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBVEGETARIAN);
		final JRadioButton RBLAMBSUVA=new JRadioButton();
		verticalPizzaListRadioButtons.add(RBLAMBSUVA);

		//CREATE BUTTONGROUP FOR PIZZA NAMES
		//add all pizza radiobuttons to buttongroup for pizza names
		final ButtonGroup BTNGRPPIZZALIST=new ButtonGroup();
		BTNGRPPIZZALIST.add(RBAUSSIE);
		BTNGRPPIZZALIST.add(RBPERIPERICHICKEN);
		BTNGRPPIZZALIST.add(RBHAWAIIAN);
		BTNGRPPIZZALIST.add(RBMEXICAN);
		BTNGRPPIZZALIST.add(RBMARGHERITA);
		BTNGRPPIZZALIST.add(RBVEGETARIAN);
		BTNGRPPIZZALIST.add(RBLAMBSUVA);
		
		//CREATE NORTHCENTERPANEL FOR FRAME 1
		JPanel northCenterPanel=new JPanel();
		//Create a titled border for Additional toppings 
		final TitledBorder NORTHCENTERPANELTITLE = new TitledBorder("Additional Toppings");
		NORTHCENTERPANELTITLE.setTitleJustification(TitledBorder.CENTER);
		northCenterPanel.setBorder(NORTHCENTERPANELTITLE);
		
		//CREATE TOPPINGS 
		//Create a box layout to store radio buttons vertically within the northcenter panel for FRAME 1
		Box verticalPizzaToppingsList = Box.createVerticalBox();
		//add the radio button box layout to the pizza size panel
		northCenterPanel.add(verticalPizzaToppingsList);
		//store all the pizza toppings within a string array
		String[] pizzaToppings={" ","Cheese","Olives","Chicken","Ham","Mushroom","Lamb","Prawns","Onions"};
		
		for (int i=0;i<pizzaToppings.length ;i++ )
		{	JLabel lblPT=new JLabel(pizzaToppings[i]);
			//set the size and font of pizza topings
			lblPT.setFont(new Font("Times New Roman", Font.BOLD, 17));
			verticalPizzaToppingsList.add(lblPT);
		}
		//CREATE NORTHWEST PANEL FOR FRAME 1
		JPanel f1NorthWestPanel=new JPanel();
		f1NorthWestPanel.add(pizzaListPanel,BorderLayout.NORTH);

		//CREATE NONE TOPPINGS
		//Create a box layout to store none radio buttons vertically within the northcenter panel for FRAME 1
		Box verticalNoneRadioButtons = Box.createVerticalBox();
		//add the none radio button box layout to the pizza size panel
		northCenterPanel.add(verticalNoneRadioButtons);
		JLabel lblNoneTitle=new JLabel("NONE");
		lblNoneTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		verticalNoneRadioButtons.add(lblNoneTitle);
		//create none cheese radio button
		final JRadioButton RBNONECHEESE=new JRadioButton();
		//add none cheese radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONECHEESE);
		//create none Olives radio button
		final JRadioButton RBNONEOLIVES=new JRadioButton();
		//add none  Olives radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONEOLIVES);
		//create none chichen radio button
		final JRadioButton RBNONECHICKEN=new JRadioButton();
		//add none chickhen radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONECHICKEN);
		//create none ham radio button
		final JRadioButton RBNONEHAM=new JRadioButton();
		//add none ham radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONEHAM);
		//create none mushroom radio button
		final JRadioButton RBNONEMUSHROOM=new JRadioButton();
		//add none mushroom radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONEMUSHROOM);
		//create none lamb radio button
		final JRadioButton RBNONELAMB=new JRadioButton();
		//add none lamb radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONELAMB);
		//create none prawns radio button
		final JRadioButton RBNONEPRAWNS=new JRadioButton();
		//add none prawns radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONEPRAWNS);
		//create none onions radio button
		final JRadioButton RBNONEONIONS=new JRadioButton();
		//add none onions radio button to box none layout 
		verticalNoneRadioButtons.add(RBNONEONIONS);

		//SET ALL NONE TOPPINGS TO BE DEFAULT SETTING 
		RBNONECHEESE.setSelected(true);
		RBNONEOLIVES.setSelected(true);
		RBNONECHICKEN.setSelected(true);
		RBNONEHAM.setSelected(true);
		RBNONEMUSHROOM.setSelected(true);
		RBNONELAMB.setSelected(true);
		RBNONEPRAWNS.setSelected(true);
		RBNONEONIONS.setSelected(true);
		
		//CREATE HALF TOPPINGS
		//Create a box layout to store	half radio buttons vertically within the northcenter panel for FRAME 1
		Box verticalHalfRadioButtons = Box.createVerticalBox();
		//add the half radio button box layout to the pizza size panel
		northCenterPanel.add(verticalHalfRadioButtons);
		JLabel lblHalfTitle=new JLabel(" HALF");
		lblHalfTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		verticalHalfRadioButtons.add(lblHalfTitle);
			//create half cheese radio button
		final JRadioButton RBHALFCHEESE=new JRadioButton();
		//add half cheese radio button to box half layout 
		verticalHalfRadioButtons.add(RBHALFCHEESE);
		//create half Olives radio button
		final JRadioButton RBHALFOLVIES=new JRadioButton();
		//add half  Olives radio button to box half layout 
		verticalHalfRadioButtons.add(RBHALFOLVIES);
		//create half chichen radio button
		final JRadioButton RBHALFCHICKEN=new JRadioButton();
		//add half chickhen radio button to box half layout 
		verticalHalfRadioButtons.add(RBHALFCHICKEN);
		//create half ham radio button
		final JRadioButton rbHalfHam=new JRadioButton();
		//add half ham radio button to box half layout 
		verticalHalfRadioButtons.add(rbHalfHam);
		//create half mushroom radio button
		final JRadioButton rbHalfMushroom=new JRadioButton();
		//add half mushroom radio button to box half layout 
		verticalHalfRadioButtons.add(rbHalfMushroom);
		//create half lamb radio button
		final JRadioButton rbHalfLamb=new JRadioButton();
		//add half lamb radio button to box half layout 
		verticalHalfRadioButtons.add(rbHalfLamb);
		//create half prawns radio button
		final JRadioButton rbHalfPrawns=new JRadioButton();
		//add half prawns radio button to box half layout 
		verticalHalfRadioButtons.add(rbHalfPrawns);
		//create half onions radio button
		final JRadioButton rbHalfOnions=new JRadioButton();
		//add half onions radio button to box half layout 
		verticalHalfRadioButtons.add(rbHalfOnions);

		//CREATE DOUBLE TOPPINGS
		//Create a box layout to store double radio buttons vertically within the northcenter panel for FRAME 1
		Box verticalDoubleRadioButtons = Box.createVerticalBox();
		//add the double radio button box layout to the pizza size panel
		northCenterPanel.add(verticalDoubleRadioButtons);
		JLabel lblDoubleTitle=new JLabel(" DOUBLE");
		lblDoubleTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		verticalDoubleRadioButtons.add(lblDoubleTitle);
			//create double cheese radio button
		final JRadioButton rbDoubleCheese=new JRadioButton();
		//add double cheese radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleCheese);
		//create double Olives radio button
		final JRadioButton rbDoubleOlives=new JRadioButton();
		//add double  Olives radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleOlives);
		//create double chichen radio button
		final JRadioButton rbDoubleChicken=new JRadioButton();
		//add double chickhen radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleChicken);
		//create double ham radio button
		final JRadioButton rbDoubleHam=new JRadioButton();
		//add double ham radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleHam);
		//create double mushroom radio button
		final JRadioButton rbDoubleMushroom=new JRadioButton();
		//add double mushroom radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleMushroom);
		//create double lamb radio button
		final JRadioButton rbDoubleLamb=new JRadioButton();
		//add double lamb radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleLamb);
		//create double prawns radio button
		final JRadioButton rbDoublePrawns=new JRadioButton();
		//add double prawns radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoublePrawns);
		//create double onions radio button
		final JRadioButton rbDoubleOnions=new JRadioButton();
		//add double onions radio button to box double layout 
		verticalDoubleRadioButtons.add(rbDoubleOnions);

		//CREATE BUTTON GROUP FOR EACH PIZZA
		//create button group for cheese topping 
		final ButtonGroup btnGrpCheeseTopping=new ButtonGroup();
		btnGrpCheeseTopping.add(RBNONECHEESE);
		btnGrpCheeseTopping.add(RBHALFCHEESE);
		btnGrpCheeseTopping.add(rbDoubleCheese);
		//create button group for olives topping 
		final ButtonGroup btnGrpOlivesTopping=new ButtonGroup();
		btnGrpOlivesTopping.add(RBNONEOLIVES);
		btnGrpOlivesTopping.add(RBHALFOLVIES);
		btnGrpOlivesTopping.add(rbDoubleOlives);
		//create button group for chicken topping 
		final ButtonGroup btnGrpChickenTopping=new ButtonGroup();
		btnGrpChickenTopping.add(RBNONECHICKEN);
		btnGrpChickenTopping.add(RBHALFCHICKEN);
		btnGrpChickenTopping.add(rbDoubleChicken);
		//create button group for ham topping 
		final ButtonGroup btnGrpHamTopping=new ButtonGroup();
		btnGrpHamTopping.add(RBNONEHAM);
		btnGrpHamTopping.add(rbHalfHam);
		btnGrpHamTopping.add(rbDoubleHam);
		//create button group for mushroom topping 
		final ButtonGroup btnGrpMushroomTopping=new ButtonGroup();
		btnGrpMushroomTopping.add(RBNONEMUSHROOM);
		btnGrpMushroomTopping.add(rbHalfMushroom);
		btnGrpMushroomTopping.add(rbDoubleMushroom);
		//create button group for lamb topping 
		final ButtonGroup btnGrpLambTopping=new ButtonGroup();
		btnGrpLambTopping.add(RBNONELAMB);
		btnGrpLambTopping.add(rbHalfLamb);
		btnGrpLambTopping.add(rbDoubleLamb);
		//create button group for prawns topping 
		final ButtonGroup btnGrpPrawnsTopping=new ButtonGroup();
		btnGrpPrawnsTopping.add(RBNONEPRAWNS);
		btnGrpPrawnsTopping.add(rbHalfPrawns);
		btnGrpPrawnsTopping.add(rbDoublePrawns);
		//create button group for onions topping 
		final ButtonGroup btnGrpOnionsTopping=new ButtonGroup();
		btnGrpOnionsTopping.add(RBNONEONIONS);
		btnGrpOnionsTopping.add(rbHalfOnions);
		btnGrpOnionsTopping.add(rbDoubleOnions);
		
		//CREATE PIZZA SIZE SECTION 
		//create new panel for order type within northpanel
		final JPanel pizzaSizePanel=new JPanel();
		//Position where the panel should be placed
		FRAME.add(pizzaSizePanel);
		//create a title for the border of the panel
		final TitledBorder pizzaSizeTitle=new TitledBorder("Pizza Size");
		//set the position of where the title of the panel should be 
		pizzaSizeTitle.setTitleJustification(TitledBorder.CENTER);
		//set the panel title around the border of the panel
		pizzaSizePanel.setBorder(pizzaSizeTitle);

		//Create a box layout to store radio buttons vertically
		Box verticalRadioButtonBox = Box.createVerticalBox();
		//add the radio button box layout to the pizza size panel
		pizzaSizePanel.add(verticalRadioButtonBox);

		//Create a box layout to store the labels of the radiobuttons
		Box verticalRadioButtonLabelBox = Box.createVerticalBox();
		//add the radio button label box layout to the pizza size panel
		pizzaSizePanel.add(verticalRadioButtonLabelBox);

		//create a radiobutton for medium size pizza
		final JRadioButton rbMediumPizza=new JRadioButton();
		//add the radiobutton medium size to the vertical radiobutton box
		verticalRadioButtonBox.add(rbMediumPizza);
		//create a label for the medium pizza radio button
		JLabel lblMediumPizza=new JLabel("Medium Pizza($3.00)");
		//add the medium pizza label to the vertical radio button label box
		verticalRadioButtonLabelBox.add(lblMediumPizza);

		//create a radiobutton for large size pizza
		final JRadioButton rbLargePizza=new JRadioButton();
		//add the radiobutton large size to the vertical radiobutton box
		verticalRadioButtonBox.add(rbLargePizza);
		//create a label for the large pizza radio button
		JLabel lblLargePizza=new JLabel("Large Pizza ($5.00)");
		//add the large pizza label to the vertical radio button label box
		verticalRadioButtonLabelBox.add(lblLargePizza);

		//create a radiobutton for family size pizza
		final JRadioButton rbFamilyPizza=new JRadioButton();
		//add the radiobutton family size to the vertical radiobutton box
		verticalRadioButtonBox.add(rbFamilyPizza);
		//create a label for the family pizza radio button
		JLabel lblFamilyPizza=new JLabel("Family Pizza ($7.00)");
		//add the family pizza label to the vertical radio button label box
		verticalRadioButtonLabelBox.add(lblFamilyPizza);
		
		//create a button group for pizza size 
		final ButtonGroup btnGrpPizzaSize=new ButtonGroup();
		btnGrpPizzaSize.add(rbMediumPizza);
		btnGrpPizzaSize.add(rbLargePizza);
		btnGrpPizzaSize.add(rbFamilyPizza);

		//CREATE NORTHEAST PANEL FOR FRAME 1
		JPanel f1NorthEastPanel=new JPanel(new GridLayout(2,1,2,10));
		

		//CREATE ADD PIZZA TO CART BUTTON 
		final JButton btnAddPizzaToCart=new JButton("Add Pizza To My Order");
		//add an action listener for the button add pizza to cart 
		btnAddPizzaToCart.addActionListener(new ActionListener() 
			{
            public void actionPerformed(ActionEvent ae) 
				{		
						//if everything has been entered except the pizza and pizza size display the following 
					if (!(RBAUSSIE.isSelected()||RBPERIPERICHICKEN.isSelected()||RBHAWAIIAN.isSelected()||RBMEXICAN.isSelected()||RBMARGHERITA.isSelected()||RBVEGETARIAN.isSelected()||RBLAMBSUVA.isSelected())&&!(rbMediumPizza.isSelected()||rbLargePizza.isSelected()||rbFamilyPizza.isSelected()))
						{
							JOptionPane.showMessageDialog(null,"Please Select A Pizza and Size to Proceed");
						}
						//if everything has been entered except the pizza size display the following
					if ((RBAUSSIE.isSelected()||RBPERIPERICHICKEN.isSelected()||RBHAWAIIAN.isSelected()||RBMEXICAN.isSelected()||RBMARGHERITA.isSelected()||RBVEGETARIAN.isSelected()||RBLAMBSUVA.isSelected())&&!(rbMediumPizza.isSelected()||rbLargePizza.isSelected()||rbFamilyPizza.isSelected()))
						{
							JOptionPane.showMessageDialog(null,"Please Select A Pizza Size to Proceed");
						}
						//if everything has been entered except the pizza display the following
					if (!(RBAUSSIE.isSelected()||RBPERIPERICHICKEN.isSelected()||RBHAWAIIAN.isSelected()||RBMEXICAN.isSelected()||RBMARGHERITA.isSelected()||RBVEGETARIAN.isSelected()||RBLAMBSUVA.isSelected())&&(rbMediumPizza.isSelected()||rbLargePizza.isSelected()||rbFamilyPizza.isSelected()))
						{
							JOptionPane.showMessageDialog(null,"Please Select A Pizza to Proceed");
						}
						//if everything has been entered display the following
					if ((RBAUSSIE.isSelected()||RBPERIPERICHICKEN.isSelected()||RBHAWAIIAN.isSelected()||RBMEXICAN.isSelected()||RBMARGHERITA.isSelected()||RBVEGETARIAN.isSelected()||RBLAMBSUVA.isSelected())&&(rbMediumPizza.isSelected()||rbLargePizza.isSelected()||rbFamilyPizza.isSelected()))
						{		
								//Declare relevent strings to be manipulated 
								 String selectedPizzaSize="unknown";
								 String selectedPizzaAdditionalToppings="";
								 //Declare a variable to store the selected pizza size price 
								 double selectedPizzaSizePrice=0.0;
								 //set the price for the bases of the pizzas
								 double mediumPizzaPrice=3.0;
								 double largePizzaPrice=5.0;
								 double familyPizzaPrice=7.0;
								 //declare a varibale to store the price of the selected pizza
								 double selectedPizzaPrice=0.0;
								 //declare a variable to store the total amount of all pizzas
								 double selectedPizzasTotalAmount=0.0;
								 

								 //IF ADDITIONAL NONE TOPPINGS ARE SELECTED
								 //store the following string if the following is true 
								 if ((RBNONECHEESE.isSelected())&&(RBNONEOLIVES.isSelected())&&(RBNONECHICKEN.isSelected())&&(RBNONEMUSHROOM.isSelected())&&(RBNONELAMB.isSelected())&&(RBNONEPRAWNS.isSelected())&&(RBNONEONIONS.isSelected()))
								 {
									selectedPizzaAdditionalToppings=" NONE\n\t\t\t     ";
									
								 }

								 //IF ADDTIONAL HALF TOPPINGS ARE SELECTED
								 //store there relevent pices and name into the selectedPizzaAdditionalToppings as a string 
								 //store the equivalent amount of the cost for the additional topping aswell as the previous amount that remained within the selectedPizzaPrice to hold the total
								 if (RBHALFCHEESE.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF CHEESE, $0.50\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.5;
								 }
								 if (RBHALFOLVIES.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF OLIVES, $0.35\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.35;
								 }
								 if (RBHALFCHICKEN.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF CHICKEN, $0.55\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.55;
								 }
								 if (rbHalfHam.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF HAM, $0.45\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.45;
								 }
								 if (rbHalfMushroom.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF MUSHROOM, $0.20\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.2;
								 }
								 if (rbHalfLamb.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF LAMB, $0.50\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.5;
								 }
								 if (rbHalfPrawns.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF PRAWNS, $0.30\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.3;
								 }
								  if (rbHalfOnions.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" HLF ONIONS, $0.25\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.25;
								 }
								 //IF ADDTIONAL DOUBLE TOPPINGS ARE SELECTED
								 //store their relevent prices and name into the selectedPizzaAdditionalToppings as a string 
								 //store the equivalent amount of the cost for the additional topping aswell as the previous amount that remained within the selectedPizzaPrice to hold the total
								 if (rbDoubleCheese.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL CHEESE, $1.00\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+1.0;
								 }
								 if (rbDoubleOlives.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL OLIVES, $0.70\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.7;
								 }
								 if (rbDoubleChicken.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL CHICKEN, $1.10\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+1.1;
								 }
								 if (rbDoubleHam.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL HAM, $0.90\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.9;
								 }
								 if (rbDoubleMushroom.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL MUSHROOM, $0.40\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.4;
								 }
								 if (rbDoubleLamb.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL LAMB, $1.00\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+1.0;
								 }
								 if (rbDoublePrawns.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL PRAWNS, $0.60\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.6;
								 }
								  if (rbDoubleOnions.isSelected())
								 {
									
									selectedPizzaAdditionalToppings=selectedPizzaAdditionalToppings+" DBL ONIONS, $0.50\n\t\t\t     ";
									selectedPizzaPrice=selectedPizzaPrice+0.5;
								 }

								 //IF PIZZA SIZES ARE SELECTED
								 //set the selectedPizzaSize as the string for whichever radiobutton was selected 
								 //set the selectedPizzaPrice to add the price of the pizzasize selected 
								 //set the selectedPizzaSizePrice to its corresponding value for each size
								if (rbMediumPizza.isSelected())
								{
									selectedPizzaSize="MED";
									selectedPizzaPrice=selectedPizzaPrice+mediumPizzaPrice;
									selectedPizzaSizePrice=3.00;
								}
								if (rbLargePizza.isSelected())
								{
									selectedPizzaSize="LRG";
									selectedPizzaPrice=selectedPizzaPrice+largePizzaPrice;
									selectedPizzaSizePrice=5.00;
								}
								if (rbFamilyPizza.isSelected())
								{
									selectedPizzaSize="FAM";
									selectedPizzaPrice=selectedPizzaPrice+familyPizzaPrice;
									selectedPizzaSizePrice=7.00;
								}
								//IF PIZZA IS SELECTED
								//write into the YOURORDERTXTFIELD the word pizza 
								YOURORDERTXTFIELD.append("\nPizza: ");
								
								//IF PIZZA IS SELECTED
								//set selectedPizzaPrize to be the current amount within the selectedPizzaPrice and the amount of the pizza that was selected
								//write into yourTxtField all the relevent information about the current pizza chosen 
								//set the selectedPizzasTotalAmount to equal what the current amount within it and also add the selectedPizzaPrice 
								//write into the TOTALAMOUNTTXTFIELD the value within selectedPizzasTotalAmount
								if (RBAUSSIE.isSelected())
								{	
									selectedPizzaPrice=selectedPizzaPrice+9.50;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[0]+" $"+FMT.format(selectedPizzaSizePrice+9.50)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								if (RBPERIPERICHICKEN.isSelected())
								{	
									selectedPizzaPrice=selectedPizzaPrice+11.5;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[1]+" $"+FMT.format(selectedPizzaSizePrice+11.50)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								if (RBHAWAIIAN.isSelected())
								{
									selectedPizzaPrice=selectedPizzaPrice+8.5;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[2]+" $"+FMT.format(selectedPizzaSizePrice+8.50)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								if (RBMEXICAN.isSelected())
								{
									selectedPizzaPrice=selectedPizzaPrice+9.0;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[3]+" $"+FMT.format(selectedPizzaSizePrice+9.0)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								if (RBMARGHERITA.isSelected())
								{
									selectedPizzaPrice=selectedPizzaPrice+8.0;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[4]+" $"+FMT.format(selectedPizzaSizePrice+8.0)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								if (RBVEGETARIAN.isSelected())
								{
									selectedPizzaPrice=selectedPizzaPrice+10.0;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[5]+" $"+FMT.format(selectedPizzaSizePrice+10.0)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								if (RBLAMBSUVA.isSelected())
								{
									selectedPizzaPrice=selectedPizzaPrice+11.5;
									YOURORDERTXTFIELD.append(selectedPizzaSize+" "+NAMEOFPIZZAS[6]+" $"+FMT.format(selectedPizzaSizePrice+11.50)+"\n\tAdditional Toppings: "+selectedPizzaAdditionalToppings+"\n\tPizza Amount: $"+FMT.format(selectedPizzaPrice)
															+"\n");
									selectedPizzasTotalAmount=selectedPizzasTotalAmount+selectedPizzaPrice;
									TOTALAMOUNTTXTFIELD.append(""+selectedPizzasTotalAmount);
								}
								//Convert the string within totalAMountTxtField to double and store in a double variable called total amount 
								double totalAmount=stringToDoubleConverter(TOTALAMOUNTTXTFIELD);
								//set the totalAMountOfOrder to equal the totalAmount 
								double totalAmountOfOrder=totalAmount;
								System.out.println(totalAmountOfOrder);
								//Write into the TOTALAMOUNTTXTFIELD2 the totalAmountOfOrder
								TOTALAMOUNTTXTFIELD2.append("+"+totalAmountOfOrder);
								System.out.println("TOTALAMOUNTTXTFIELD2: "+TOTALAMOUNTTXTFIELD2.getText());
								
								//After the manipulation has completed reset everything to what it was in the beginning 
								BTNNEXT.setEnabled(true);
								BTNGRPPIZZALIST.clearSelection();
								btnGrpPizzaSize.clearSelection();
								RBNONECHEESE.setSelected(true);
								RBNONEOLIVES.setSelected(true);
								RBNONECHICKEN.setSelected(true);
								RBNONEHAM.setSelected(true);
								RBNONEMUSHROOM.setSelected(true);
								RBNONELAMB.setSelected(true);
								RBNONEPRAWNS.setSelected(true);
								RBNONEONIONS.setSelected(true);
								TOTALAMOUNTTXTFIELD.setText("");
						}
							}
			});
		//Add the btnAddPizzaToCart button to northeast panel of FRAME 1
		f1NorthEastPanel.add(btnAddPizzaToCart);

		//CREATE RESET BUTTON FOR FRAME 1
		final JButton btnResetOrder=new JButton("Reset");
		//add btnResetOrder to northEastPanel of FRAME 1
		f1NorthEastPanel.add(btnResetOrder);
		//Add an action listenr to btn reset Order 
		btnResetOrder.addActionListener(new ActionListener() 
			{
            public void actionPerformed(ActionEvent ae) 
				{
					//When this button is pressed it will delete all inforamtion enterted by the user and reset the homepage into its default settings
					BTNNEXT.setEnabled(false);
					BTNDONE.setEnabled(false);
					BTNGRPPIZZALIST.clearSelection();
					btnGrpPizzaSize.clearSelection();
					TOTALAMOUNTTXTFIELD2.setText(""+0.0);
					YOURORDERTXTFIELD.setText("\t\t\t  YOUR ORDER\n************************************************************");
					RBNONECHEESE.setSelected(true);
					RBNONEOLIVES.setSelected(true);
					RBNONECHICKEN.setSelected(true);
					RBNONEHAM.setSelected(true);
					RBNONEMUSHROOM.setSelected(true);
					RBNONELAMB.setSelected(true);
					RBNONEPRAWNS.setSelected(true);
					RBNONEONIONS.setSelected(true);
				}
			});
		

	
		//CREATE FRAME 2
		final JFrame FRAME2=new JFrame("Cheesy Pizza System 247");
		//Set the location of the FRAME2 on the screen
		FRAME2.setLocationRelativeTo(null);
		//create add details button
		final JButton btnAddDetails=new JButton("ADD DETAILS");
		btnAddDetails.setVisible(false);
		final JButton btnAddDetails2=new JButton("ADD DETAILS");
		btnAddDetails2.setVisible(false);

		//CREATE RECEIPT TEXT FIELD
		final JTextArea receiptTxtField=new JTextArea(26,60);
		
		

		//CREATE ORDER TYPE 
		final String orderTypeDelivery="Delivery";
		final String orderTypeInStore="In Store";



		//CREATE NORTHPANEL
		//create new panel for the north part of the FRAME2
		final JPanel northPanel=new JPanel(new FlowLayout());
		//positon where the panel should be placed
		FRAME2.add(northPanel);
		//create a title for the  border of the panel
		final TitledBorder northPanelTitle = new TitledBorder("Details");
		//set the position of where the title of the panel should be
		northPanelTitle.setTitleJustification(TitledBorder.CENTER);
		//set the panel title around the border of the panel
		northPanel.setBorder(northPanelTitle);
		
		//CREATE SOUTHPANEL
		//create new panel for the south part of the FRAME2
		final JPanel southPanel=new JPanel(new FlowLayout());
		//position where the panel should be placed
		FRAME2.add(southPanel,BorderLayout.SOUTH);
		//create a title for the border of the panel
		final TitledBorder southPanelTitle = new TitledBorder("Receipt");
		//set the panel title around the border of the panel 
		southPanel.setBorder(southPanelTitle);
		
		//CREATE NORTHWESTPANEL 
		//create new panel for the north west part of the FRAME2 
		final JPanel northWestPanel=new JPanel(new FlowLayout());
		//postion where the panel should be placed
		northPanel.add(northWestPanel,BorderLayout.WEST);

		//CREATE NORTHEASTPANEL
		//create new panel for the north east part of the FRAME2 
		final JPanel northEastPanel=new JPanel(new GridLayout());
		//postion where the panel should be placed
		northPanel.add(northEastPanel,BorderLayout.EAST);


		//CREATE ORDER TYPE SECTION 
		//create new panel for order type within northpanel
		final JPanel orderTypePanel=new JPanel(new GridLayout(2,1,2,2));
		//Position where the panel should be placed
		northWestPanel.add(orderTypePanel,BorderLayout.WEST);
		//create a title for the border of the panel
		final TitledBorder orderTypeTitle=new TitledBorder("Order Type");
		//set the position of where the title of the panel should be 
		orderTypeTitle.setTitleJustification(TitledBorder.CENTER);
		//set the panel ttle around the border of the panel
		orderTypePanel.setBorder(orderTypeTitle);

		//Create instore radio button
		final JRadioButton rbInStore=new JRadioButton();
		//add instore radio button to panel
		orderTypePanel.add(rbInStore);
		//create label for instore radio button 
		final JLabel inStoreLabel=new JLabel("In Store");
		orderTypePanel.add(inStoreLabel);

		//Create delivery radio button
		final JRadioButton rbDelivery=new JRadioButton();
		//add delivery radio button to panel
		orderTypePanel.add(rbDelivery);
		//create label for delivery radio button 
		final JLabel deliveryLabel=new JLabel("Delivery");
		orderTypePanel.add(deliveryLabel);
		
		//create a button group so that only one button is selected at a time
		final ButtonGroup btnGrpOrderType = new ButtonGroup();
		btnGrpOrderType.add(rbInStore);
		btnGrpOrderType.add(rbDelivery);

		//CREATE NAME SECTION
		//Create Label for name 
		final JLabel lblName=new JLabel("*Name:");
		//set font for name label
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//Set color of text for name label
		lblName.setForeground(Color.red);
		//add label to panel
		northPanel.add(lblName);
		//create text field for name of customer 
		final JTextField nameOfCustomerField=new JTextField(10);
		//add name of customer text field to panel
		northPanel.add(nameOfCustomerField,BorderLayout.WEST);
		//add a key Listener to nameOfCustomer Field so that it doesnt accept Numbers
		nameOfCustomerField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					e.consume();
				}
			}
		});
		
		//CREATE PHONE NUMBER SECTION 
		//Create Label for phone number
		final JLabel lblPhone=new JLabel("*Phone:");
		//set font for phone label
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//Set color of text for phone label
		lblPhone.setForeground(Color.red);
		//add label to panel
		northPanel.add(lblPhone);
		//create text field for phone number of customer
		final JTextField numberOfCustomerField=new JTextField(8);
		//add number of customer text field to panel
		northPanel.add(numberOfCustomerField,BorderLayout.WEST);
		//add a key listener so it doeesnt accept Characters 
		numberOfCustomerField.addKeyListener(new KeyAdapter()
		{ 
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if (!(Character.isDigit(c)))
				{
					e.consume();
				}
			}
		});

		//CREATE DELIVERY OPTIONS BORDER WITHIN NORTHPANEL
		//create new panel for delivery options
		final JPanel deliveryOption= new JPanel(new FlowLayout());
		//position where the panel should be placed
		northPanel.add(deliveryOption,BorderLayout.CENTER);
		//create a title for the border of the panel
		final TitledBorder deliveryOptionTitle=new TitledBorder("Delivery Option");
		//change the font of the title 
		deliveryOptionTitle.setTitleFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		//set the panel title around the border of the panel
		deliveryOption.setBorder(deliveryOptionTitle);

		//create street number label
		final JLabel stNumberLabel=new JLabel("St Number:");
		//set font for street number label
		stNumberLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//add label to panel
		deliveryOption.add(stNumberLabel);
		//create text field for street number
		final JTextField stNumberField=new JTextField(10);
		//add street number text field to panel
		deliveryOption.add(stNumberField);

		//create street name label
		final JLabel stNameLabel=new JLabel("St Name:");
		//set font for street name label
		stNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//add label to panel
		deliveryOption.add(stNameLabel);
		//create text field for street name
		final JTextField stNameField=new JTextField(20);
		//add street name text field to panel
		deliveryOption.add(stNameField);
		//add a key listener so it doesnt accept Numbers
		stNameField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					e.consume();
				}
			}
		});

		//create suburb label
		final JLabel suburbLabel=new JLabel("Suburb");
		//set font for suburb label
		suburbLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//add label to panel
		deliveryOption.add(suburbLabel);
		//create text field for suburb
		final JTextField suburbField=new JTextField(30);
		//add suburb text field to panel
		deliveryOption.add(suburbField);
		//add a key listener so it doesnt accept Numbers
		suburbField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if ((Character.isDigit(c)))
				{
					e.consume();
				}
			}
		});

		//create postcode label
		JLabel postCodeLabel=new JLabel("Post Code:");
		//set font for postcode label
        postCodeLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//add label to panel
		deliveryOption.add(postCodeLabel);
		//create text field for postcode
		final JTextField postCodeField=new JTextField(3);
		//add postcode text field to panel
		deliveryOption.add(postCodeField);
		//add a key listener so it doesnt accept Characters
		postCodeField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if (!(Character.isDigit(c)))
				{
					e.consume();
				}
			}
		});

		//Add an actionlistenr for the radioButton Instore 
		rbInStore.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				//Enable the btnAddDetails2 so that its manipulation for an instore order can occur 
				btnAddDetails2.setVisible(true);
				//disable the btnAddDetails so that its manipulation for a delevery order can not occur 
				btnAddDetails.setVisible(false);

				//If the radio button Instore is selected display the following 
				if (rbInStore.isSelected())
				{
					stNumberField.setEditable(false);
					stNumberField.setBackground(Color.DARK_GRAY);
					stNameField.setEditable(false);
					stNameField.setBackground(Color.DARK_GRAY);
					suburbField.setEditable(false);
					suburbField.setBackground(Color.DARK_GRAY);
					postCodeField.setEditable(false);
					postCodeField.setBackground(Color.DARK_GRAY);
				}
			}
		});
		
		//Add an actionlistenr for the radioButton Delivery 
		rbDelivery.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//enable the btnAddDetails so that its manipulation for a delevery order can occur 
				btnAddDetails.setVisible(true);
				//Disable the btnAddDetails2 so that its manipulation for an instore order cannot occur
				btnAddDetails2.setVisible(false);

				//If the radio button Delivery is selected display the following 
				if(rbDelivery.isSelected())
				{
					stNumberField.setEditable(true);
					stNumberField.setBackground(Color.WHITE);
					stNameField.setEditable(true);
					stNameField.setBackground(Color.WHITE);
					suburbField.setEditable(true);
					suburbField.setBackground(Color.WHITE);
					postCodeField.setEditable(true);
					postCodeField.setBackground(Color.WHITE);
				}
			}
		});

		//CREATE ADD DETAILS BUTTON 
		//set the font for add details button 
		btnAddDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAddDetails2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//add button to northeast panel
		northEastPanel.add(btnAddDetails,BorderLayout.SOUTH);
		northEastPanel.add(btnAddDetails2,BorderLayout.SOUTH);
		//add northeast panel to northpanel
		northPanel.add(northEastPanel);
		//add an action listener for add details button 
		btnAddDetails.addActionListener(new ActionListener() 
			{
            public void actionPerformed(ActionEvent ae) 
				{ 
					//if everything is entered except the name and number of the customer display the follwoing 
					if ( (rbDelivery.isSelected()) && ( nameOfCustomerField.getText().equals("") && numberOfCustomerField.getText().equals(""))&& !(stNumberField.getText().equals("")&& stNameField.getText().equals("")&& suburbField.getText().equals("")&&postCodeField.getText().equals("")))					
					{
					JOptionPane.showMessageDialog(null,"Please Enter Your Name And Number To Proceed");
					}
					//if everything is entered except the name of the customer display the follwoing
					if ( (rbDelivery.isSelected()) && ( nameOfCustomerField.getText().equals("") && !(numberOfCustomerField.getText().equals("")))&&!(stNumberField.getText().equals("")&& stNameField.getText().equals("")&& suburbField.getText().equals("")&&postCodeField.getText().equals("")))					
					{
					JOptionPane.showMessageDialog(null,"Please Enter Your Name To Proceed");
					}
					//if everything is entered except the number of the customer display the follwoing
					if ( (rbDelivery.isSelected()) && ( !(nameOfCustomerField.getText().equals("")) && numberOfCustomerField.getText().equals(""))&&!(stNumberField.getText().equals("")&& stNameField.getText().equals("")&& suburbField.getText().equals("")&&postCodeField.getText().equals("")))										
					{
					JOptionPane.showMessageDialog(null,"Please Enter Your Number To Proceed");
					}
					//if everything has not been entered display the following 
					if ( (rbDelivery.isSelected()) && ( nameOfCustomerField.getText().equals("") && numberOfCustomerField.getText().equals(""))&&(stNumberField.getText().equals("")|| stNameField.getText().equals("")|| suburbField.getText().equals("")||postCodeField.getText().equals("")))
					{
					JOptionPane.showMessageDialog(null,"Please Ensure That Your Name, Number and Address Details Have Been Entered To Proceed");
					}
					//if everything is entered except the delviery detials of the  customer display the follwoing
					if ( (rbDelivery.isSelected()) && !( nameOfCustomerField.getText().equals("")&& numberOfCustomerField.getText().equals(""))&&(stNumberField.getText().equals("")|| stNameField.getText().equals("")|| suburbField.getText().equals("")||postCodeField.getText().equals("")))
					{
					JOptionPane.showMessageDialog(null,"Please Ensure That Your St Number,St Name,Suburb and PostCode Have Been Added To Proceed.");
					}
				
					//if everything is entered display the follwoing
					if ( (rbDelivery.isSelected()) && !((nameOfCustomerField.getText().equals(""))&&(numberOfCustomerField.getText().equals("")))&&!((stNumberField.getText().equals(""))&&(stNameField.getText().equals(""))&&(suburbField.getText().equals(""))&&(postCodeField.getText().equals(""))))
					{	
						//set the done button to be enabled
						BTNDONE.setEnabled(true);
						//declare variables to hold the string entered by the user
						final String nameOfCustomer=nameOfCustomerField.getText();
						final String numberOfCustomer=numberOfCustomerField.getText();
						final String stNumber=stNumberField.getText();
						final String StName=stNameField.getText();
						final String suburb=suburbField.getText();
						final String postCodeString=postCodeField.getText();
						final int postCode=Integer.parseInt(postCodeString);
						//Declare a variable named adress which will hold all relevent details about the users address 
						final String address=stNumber+" "+StName+", "+suburb+", "+postCode+ " VIC";
						
						//Declare a variable to hold the amount due by the customer
						double amountDue=0.0;
						//declare a variable to store the string entered into TOTALAMOUNTTXTFIELD2
						String string = TOTALAMOUNTTXTFIELD2.getText();
						//split the string from the variable string into parts and store them as elements in an array 
						String[] parts = string.split("[+]");
						//Declare an array to store the split parts 
						Double[] splitParts=new Double[parts.length];
								//use a for loop to store the spilt parts in the of the array parts as the elements in split parts 
								//as the for loop increments add the spilt parts into the amount due variable and add it 
								for (int i=0;i<parts.length ;i++ )
								{
								splitParts[i]=Double.parseDouble(parts[i]);
								amountDue=splitParts[i]+amountDue;
								}
						//Declare a variable to hold the delivery fee
						double deliveryFee=3.00;
						//declare a variable to hold the GST amount of the order
						final double GST=0.1*amountDue;
						//declare a variable that calculates the total amount due including the GST
						double totalAmountDue=amountDue+GST+deliveryFee;

						//Write all relevent information into receiptTxtField
						receiptTxtField.setText(
						"\t\t\t  RECEIPT\n\t\t       CHEESY PIZZA 247   "+DATEOFENTRY+
						"\n************************************************************"
						+"\n\tName: "+nameOfCustomer+"\tPhone: "+numberOfCustomer+
						"\n\n\tOrder Type: "+orderTypeDelivery+"\tEstimated Time: 45-60 mins"+
						"\n\n\t\t\t  ADDRESS:\n    \t"+address+
						"\n************************************************************"+
						"\n"+YOURORDERTXTFIELD.getText()+
						"\n************************************************************"+
						"\nAMOUNT DUE: $"+FMT.format(amountDue)+"\tDelivery Fee:$3.00"+
						"\nGST(10%): $"+FMT.format(GST)+
						"\nTOTAL AMOUNT:$"+FMT.format(totalAmountDue));
						
						//Display a popup that informs the user that the details have been added to the receipt
						JOptionPane.showMessageDialog(
						btnAddDetails, "Details Added");
					};
					 
				}
			});
		//add an actionlistener for btnAddDetails2
		btnAddDetails2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent ae) 
				{
					//if instore radiobutton has been seleceted but the name and phone number of the customer hasnt been entered display the following 
				if ( (rbInStore.isSelected()) && (nameOfCustomerField.getText().equals("")) && (numberOfCustomerField.getText().equals("")))
					{
					JOptionPane.showMessageDialog(null,"Please Enter Your Name And Number To Proceed");
					}
					//if instore radiobutton has been seleceted  and phone number but  the name of the customer hasnt been entered display the following
				if ( (rbInStore.isSelected()) && (nameOfCustomerField.getText().equals("")) && !(numberOfCustomerField.getText().equals("")))
					{
					JOptionPane.showMessageDialog(null,"Please Enter Your Name To Proceed");
					}
					//if instore radiobutton has been seleceted  and the name but the phone number of the customer hasnt been entered display the following
				if ( (rbInStore.isSelected()) && !(nameOfCustomerField.getText().equals("")) && (numberOfCustomerField.getText().equals("")))
					{
					JOptionPane.showMessageDialog(null,"Please Enter Your Number To Proceed");
					}
				
					//if everything has been entered display the follwoing 
					if ( (rbInStore.isSelected()) && !(nameOfCustomerField.getText().equals("")) && !(numberOfCustomerField.getText().equals("")))
					{
					//set the done button to be enabled
					BTNDONE.setEnabled(true);
					//declare variables to hold the string entered by the user
					final String nameOfCustomer=nameOfCustomerField.getText();
					final String numberOfCustomer=numberOfCustomerField.getText();
					//Declare a variable named adress which will hold all relevent details about the users address 
					String address="\t\t\tNot Available";
					//Declare a variable to hold the amount due by the customer
					double amountDue=0.0;
					//declare a variable to store the string entered into TOTALAMOUNTTXTFIELD2
					String string = TOTALAMOUNTTXTFIELD2.getText();
					//split the string from the variable string into parts and store them as elements in an array 
					String[] parts = string.split("[+]");
					//Declare an array to store the split parts 
					Double[] splitParts=new Double[parts.length];
							//use a for loop to store the spilt parts in the of the array parts as the elements in split parts 
							//as the for loop increments add the spilt parts into the amount due variable and add it 
							for (int i=0;i<parts.length ;i++ )
							{
							splitParts[i]=Double.parseDouble(parts[i]);
							amountDue=splitParts[i]+amountDue;
							}

					//declare a variable to hold the GST amount of the order
					final double GST=0.1*amountDue;
					//declare a variable that calculates the total amount due including the GST
					double totalAmountDue=amountDue+GST;
					
					//Write all relevent information into receiptTxtField
					receiptTxtField.setText(
					"\t\t\t  RECEIPT\n\t\t       CHEESY PIZZA 247   "+DATEOFENTRY+
					"\n************************************************************"
					+"\n\tName: "+nameOfCustomer+"\tPhone: "+numberOfCustomer+
					"\n\n\tOrder Type: "+orderTypeInStore+"\tEstimated Time: 15-30 mins"+
					"\n\n\t\t\t  ADDRESS:\n"+address+
					"\n************************************************************"+
					"\n"+YOURORDERTXTFIELD.getText()+
					"\n************************************************************"+
					"\nAMOUNT DUE: $"+FMT.format(amountDue)+
					"\nGST(10%): $"+FMT.format(GST)+
					"\nTOTAL AMOUNT:$"+FMT.format(totalAmountDue));
					
					//Display a popup that informs the user that the details have been added to the receipt
					JOptionPane.showMessageDialog(
                    btnAddDetails2, "Details Added");
					};
					
					
				}
		});

		//CREATE CANCEL BUTTON
		//create cancel button
		final JButton btnCancel=new JButton("CANCEL");
		//add button to southpanel
		southPanel.add(btnCancel,BorderLayout.WEST);
		//import icon from your computer
		ImageIcon cancelIcon=new ImageIcon("red X.png");
		//get icon and store it as an image
		Image cancelImg=cancelIcon.getImage();
		//set instances for icon
		Image newCancelImg=cancelImg.getScaledInstance(30, 30,Image.SCALE_SMOOTH);
		//store image in a icon 
		ImageIcon newCancelIcon=new ImageIcon(newCancelImg); 
		//set icon for cancel  button 
		btnCancel.setIcon(newCancelIcon);
		//add action listener to cancel button 
		btnCancel.addActionListener(new ActionListener()
			{	
			public void actionPerformed(ActionEvent event) 
				{
					//set the next button to not be enabled
					BTNNEXT.setEnabled(false);
					//Sotre and Display relevent images and icons 
					ImageIcon warningSignIcon = new ImageIcon("warning sign.png");
					Image finalWarningSignIcon = warningSignIcon.getImage();
					Image cancelWarningSignIcon = finalWarningSignIcon.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
					ImageIcon newCancelIcon = new ImageIcon(cancelWarningSignIcon);
					
					//create a label 
					JLabel label=new JLabel("Are you sure you want to cancel your order... ");
					//set the font and size of the label
					label.setFont(new Font("Times New Roman",Font.BOLD,16));
					//store the Popup in an int called dialog 
					int dialog= JOptionPane.showConfirmDialog(null, label, "Cancel Order", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,newCancelIcon);
					//if okay is selected within the popup 
					//Delete and Reset everything to its default settings 
					if (dialog==JOptionPane.OK_OPTION)
					{
						FRAME2.dispose();
						FRAME.setVisible(true);
						YOURORDERTXTFIELD.setText("\t\t\t  YOUR ORDER\n************************************************************");
						receiptTxtField.setText("");
						nameOfCustomerField.setText("");
						numberOfCustomerField.setText("");
						stNumberField.setText("");
						stNameField.setText("");
						suburbField.setText("");
						postCodeField.setText("");
						btnGrpOrderType.clearSelection();
						BTNGRPPIZZALIST.clearSelection();
						btnGrpPizzaSize.clearSelection();
						TOTALAMOUNTTXTFIELD2.setText(""+0.0);
						RBNONECHEESE.setSelected(true);
						RBNONEOLIVES.setSelected(true);
						RBNONECHICKEN.setSelected(true);
						RBNONEHAM.setSelected(true);
						RBNONEMUSHROOM.setSelected(true);
						RBNONELAMB.setSelected(true);
						RBNONEPRAWNS.setSelected(true);
						RBNONEONIONS.setSelected(true);

					}
				}
			}
		);
		 

		//CREATE RECEIPT 
		//set the background of the receipt text area to light grey 
		receiptTxtField.setBackground(Color.WHITE);
		//set the font of the text field 
		receiptTxtField.setFont(new Font("Courier New", Font.BOLD, 14));
		//set the text area to not editable so the user cant edit it 
		receiptTxtField.setEditable(false);
		//add a scroll bar to the text area
		final JScrollPane scrollPane=new JScrollPane(receiptTxtField);
		//set the boundaries of the scroll bar 
		scrollPane.setBounds(10,60,780,500);
		//set the vertical scrollbar to always appear
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//set the horizontal scrollbar to always appear
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//add the scroll bar consisted within the text area to the south panel
		southPanel.add(scrollPane);

		//CREATE DONE BUTTON
		//create done button
		//add button to southpanel 
		southPanel.add(BTNDONE,BorderLayout.EAST);
		//import icon from your computer 
		ImageIcon doneIcon = new ImageIcon("green tick.png");
		//get icon and store it as an image 
		Image doneImg = doneIcon.getImage();
		//set instances for icon
		Image newDoneImg = doneImg.getScaledInstance(30, 30,Image.SCALE_SMOOTH);
		//store image in a icon 
		ImageIcon newDoneIcon = new ImageIcon(newDoneImg);
		//set icon for done button
		BTNDONE.setIcon(newDoneIcon);
		//add action listener to done button 
		BTNDONE.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae) 
				{
					//import icon from your computer
					ImageIcon thankYouIcon = new ImageIcon("cheesypizza.jpg");
					//get icon and store it as an image
					Image finalThankYouIcon = thankYouIcon.getImage();
					//set instances for icon 
					Image doneThankYouIcon = finalThankYouIcon.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
					//store image in a icon
					ImageIcon newDoneIcon = new ImageIcon(doneThankYouIcon);
					//display message box eith desired new icon
					JOptionPane.showMessageDialog(null,"Thank You For Using Cheesy Pizza 24/7", "Thank You", JOptionPane.INFORMATION_MESSAGE, newDoneIcon); 
					
					//Declare a file 
					File receiptsFile = new File("RECEIPTS.txt");
					//try and find the existence of that file if it doesnt exsit create it 
					try
					{
					
					if(!receiptsFile.exists()) 
					{
					receiptsFile.createNewFile();
					} 
					//create a file reader
					FileReader reader=new FileReader(receiptsFile);
					Scanner fileScanner=new Scanner(reader);
					//create a printwriter
					PrintWriter writeInToFile=new PrintWriter(new FileWriter(receiptsFile,true));
					//input stream
					Scanner scan=new Scanner(System.in);
					//writeinto the file what has been written into the receiptTxtField
					writeInToFile.println(receiptTxtField.getText());
					//close the writer
					writeInToFile.close();
					}
					//Catch an IOEXception 
					catch (IOException ioe)
					{
						System.err.println("The desired file " + receiptsFile
							+ " has problems being read from");
					}
						//Store all relevent information into the file and delete and reset everything to default settings 
						FRAME2.dispose();
						FRAME.setVisible(true);
						YOURORDERTXTFIELD.setText("\t\t\t  YOUR ORDER\n************************************************************");
						receiptTxtField.setText("");
						nameOfCustomerField.setText("");
						numberOfCustomerField.setText("");
						stNumberField.setText("");
						stNameField.setText("");
						suburbField.setText("");
						postCodeField.setText("");
						btnGrpOrderType.clearSelection();
						BTNGRPPIZZALIST.clearSelection();
						btnGrpPizzaSize.clearSelection();
						TOTALAMOUNTTXTFIELD2.setText(""+0.0);
						RBNONECHEESE.setSelected(true);
						RBNONEOLIVES.setSelected(true);
						RBNONECHICKEN.setSelected(true);
						RBNONEHAM.setSelected(true);
						RBNONEMUSHROOM.setSelected(true);
						RBNONELAMB.setSelected(true);
						RBNONEPRAWNS.setSelected(true);
						RBNONEONIONS.setSelected(true);
						BTNNEXT.setEnabled(false);
						BTNDONE.setEnabled(false);
				
				}
			}
			);

		

		//CREATE NORTPANEL FOR FRAME 1
		final JPanel f1NorthPanel=new JPanel(new FlowLayout());
		//create a title for the  border of the panel
		final TitledBorder f1NorthPanelTitle = new TitledBorder("Order");
		//set the position of where the title of the panel should be
		f1NorthPanelTitle.setTitleJustification(TitledBorder.CENTER);
		//set the panel title around the border of the panel
		f1NorthPanel.setBorder(f1NorthPanelTitle);
		FRAME.add(f1NorthPanel);
		//f1NorthPanel.add(cmbPizzaList);
		f1NorthPanel.add(f1NorthWestPanel,BorderLayout.WEST);
		f1NorthPanel.add(northCenterPanel,BorderLayout.CENTER);
		f1NorthPanel.add(pizzaSizePanel,BorderLayout.EAST);
		//f1NorthPanel.add(northEastPanel,BorderLayout.EAST);
		f1NorthPanel.add(f1NorthEastPanel,BorderLayout.EAST);

		

		//CREATE SOUTHPANEL FOR FRAME 1
		final JPanel f1SouthPanel= new JPanel(new FlowLayout());
		final TitledBorder f1SouthPanelTitle = new TitledBorder("Your Order:");
		//set the position of where the title of the panel should be
		f1NorthPanelTitle.setTitleJustification(TitledBorder.CENTER);
		//set the panel title around the border of the panel
		f1SouthPanel.setBorder(f1SouthPanelTitle);
		FRAME.add(f1SouthPanel,BorderLayout.SOUTH);

		//CREATE YOUR ORDER
		//create a south center panel
		JPanel f1SouthCenterPanel=new JPanel();
		f1SouthPanel.add(f1SouthCenterPanel,BorderLayout.CENTER);
		//set the background of the yourOrder text area to light grey 
		YOURORDERTXTFIELD.setBackground(Color.WHITE);
		//set the font of the text field 
		YOURORDERTXTFIELD.setFont(new Font("Courier New", Font.BOLD, 14));
		//set the text area to not editable so the user cant edit it 
		YOURORDERTXTFIELD.setEditable(true);
		//add a scroll bar to the text area
		final JScrollPane scrollPane1=new JScrollPane(YOURORDERTXTFIELD);
		//set the boundaries of the scroll bar 
		scrollPane.setBounds(10,60,780,500);
		//set the vertical scrollbar to always appear
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//set the horizontal scrollbar to always appear
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//add the scroll bar consisted within the text area to the south panel
		f1SouthPanel.add(scrollPane1);

		//CREATE SOUTH EASTPANEL FRO FRAME 1
		JPanel f1SouthEastPanel=new JPanel();
		f1SouthPanel.add(f1SouthEastPanel,BorderLayout.EAST);

		//CREATE NEXT BUTTON
		//add BTNNEXT to southeast panel of FRAME 1
		f1SouthEastPanel.add(BTNNEXT,BorderLayout.EAST);
		//store and display relevent images and icons 
		ImageIcon nextIcon=new ImageIcon("green arrow.png");
		Image nextImg=nextIcon.getImage();
		Image newNextImg=nextImg.getScaledInstance(30,30,Image.SCALE_SMOOTH);
		ImageIcon newNextIcon=new ImageIcon(newNextImg);
		//set the icon for btn next
		BTNNEXT.setIcon(newNextIcon);
		//add an actionlistener for BTNNEXT
		BTNNEXT.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	//Close FRAME 1  and open FRAME 2 
				FRAME.dispose();
				FRAME2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				FRAME2.pack();
				FRAME2.setLocationRelativeTo(null);
				FRAME2.setResizable(true);
				FRAME2.setVisible(true);
				FRAME2.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				
				
			}
		});
		
		//set the settings for FRAME 1
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.pack();
		FRAME.setLocationRelativeTo(null);
		FRAME.setVisible(true);

	}
	//Create a method that converts string into double 
	public static double stringToDoubleConverter(JTextArea string)
	{
		String text=string.getText();
		Double decimal=Double.parseDouble(text);
		return decimal;
	}
	
}
	