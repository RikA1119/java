import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GUI_GCD_LCM_RP extends JFrame{
	
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JTextField  text1 = new JTextField(10);
	private JTextField  text2 = new JTextField(10);
	private JTextField  text3 = new JTextField(10);
	private JRadioButton radiobutton1 = new JRadioButton();
	private JRadioButton radiobutton2 = new JRadioButton();
	private JRadioButton radiobutton3 = new JRadioButton();
	private JButton button = new JButton();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	int mode;
	
	int GCD(int a,int b) {
        if(a%b==0)
            return b;
        else
            return GCD(b,a%b);
    }
    
    int LCM(int a,int b){
    	int gcd = GCD( a , b );
    	int lcm = ( a * b ) / gcd;
		return lcm;
    }
    
    public class ButtonHandler implements ActionListener{ // ButtonHandler 
        public void actionPerformed(ActionEvent event) {
        	int c = Integer.valueOf(text1.getText());
        	int d = Integer.valueOf(text2.getText());
        		if ( mode == 1 ) {
        			int gcd = GCD( c , d );
    				String gcdStr = String.valueOf(gcd);
    				text3.setText(gcdStr);
        		}
        		else if( mode == 2) {
    				int lcm = LCM( c , d );
    				String lcmStr = String.valueOf(lcm);
    				text3.setText(lcmStr);
        		}
        		else if( mode == 3 ) {
    				if (GCD( c , d  ) ==1 ) text3.setText("yes");
					else text3.setText("no");
        		}
        		else {
        			text3.setText("Error");
        		}
                
        	}
        }

    public class RadioButtonHandler implements ItemListener{ // RadioButtonHandler 
        public void itemStateChanged(ItemEvent event) {
        	if(event.getSource() == radiobutton1){
    			mode = 1;
    		}else if(event.getSource() == radiobutton2){
    			mode = 2;
    		}else if(event.getSource() == radiobutton3){
    			mode = 3;
    		}
        }
    }
     

	
	public GUI_GCD_LCM_RP(){
			super("Label Frame Window");

			GridLayout gridLayout1 = new GridLayout(3, 1);
			panel1.setLayout(new GridLayout(1,4));
			panel2.setLayout(new GridLayout(1,3));
			panel3.setLayout(new GridLayout(1,3));
			setLayout(gridLayout1);
			
			ButtonGroup Group = new ButtonGroup();
			
			label1.setText("Number1");
			label2.setText("Number2");
			label3.setText("結果");
		    radiobutton1.setText("最大公因數");
		    radiobutton2.setText("最小公倍數");
		    radiobutton3.setText("互質");
			button.setText("開始計算");
			
	        Group.add(radiobutton1);
	        Group.add(radiobutton2);
	        Group.add(radiobutton3);
	        
	        add(panel1);
	        add(panel2);
	        add(panel3);
	        
	        panel1.add(label1);
	        label1.setPreferredSize(new Dimension(100, 30));
	        panel1.add(text1);
	        panel1.add(label2);
	        panel1.add(text2);
	        panel2.add(radiobutton1);
	        panel2.add(radiobutton2);
	        panel2.add(radiobutton3);
	        panel3.add(button);
	        panel3.add(label3);
	        panel3.add(text3);

			
            ButtonHandler buttonHandler = new ButtonHandler();
            RadioButtonHandler radiobuttonHandler = new RadioButtonHandler();
            button.addActionListener(buttonHandler);
            radiobutton1.addItemListener(radiobuttonHandler);
            radiobutton2.addItemListener(radiobuttonHandler);
            radiobutton3.addItemListener(radiobuttonHandler);
		}
	

	public static void main(String args[]) {
		GUI_GCD_LCM_RP labelFrame = new GUI_GCD_LCM_RP();
		labelFrame.setSize(640, 480);
		labelFrame.setVisible(true);
	}

}
