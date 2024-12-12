import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Painter extends JFrame {
	
	private JRadioButton[] radioButton = new JRadioButton[4];
	private String[] radioStr = {"Line","Rect","Round Rect","Fill Rect"};
	private JPanel PanelAll;
	private JPanel RBPanel;
	private JPanel ButtonPanel;
	private JButton ColorButton;
	private JButton SaveButton;
	private JButton LoadButton;
	private GridLayout[] gridLayout = new GridLayout[2];
	
	Color color = Color.LIGHT_GRAY;
	DrawJPanel drawJPanel;
	
	int xValue[] = new int[2];
	int yValue[] = new int[2];
	int drawMode = -1;
	int iO_bject = 0;
	
	Shape[] Objects = new Shape[10000];
	
	public Painter(){
		super("Painter");
		
		RBPanel = new JPanel();
		PanelAll = new JPanel();
		ButtonPanel=new JPanel();
		drawJPanel = new DrawJPanel();
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		gridLayout[0] = new GridLayout(2, 2);
		gridLayout[1] = new GridLayout(1, 3);
		ColorButton = new JButton("Color Chooser");
		SaveButton  = new JButton("Save");
		LoadButton  = new JButton("Load");
		
		ButtonListener buttonListener = new ButtonListener();
		MouseHandler mouseHandler = new MouseHandler();
		BorderLayout borderlayout = new BorderLayout();
		RBListener radioListener = new RBListener();
		for(int count=0; count < radioStr.length; count++){
			radioButton[count] = new JRadioButton(radioStr[count],false);
			RBPanel.add(radioButton[count]);
			buttonGroup.add(radioButton[count]);
			radioButton[count].addItemListener(radioListener);
			}/* End of for-loop */	
		
		drawJPanel.setBackground(Color.WHITE);
		RBPanel.setLayout(gridLayout[0]);
		ButtonPanel.setLayout(gridLayout[1]);
		setLayout(borderlayout);
		
		ButtonPanel.add(ColorButton);
		ButtonPanel.add(SaveButton);
		ButtonPanel.add(LoadButton);
		add(RBPanel,borderlayout.NORTH);
		add(ButtonPanel,borderlayout.SOUTH);
		add(drawJPanel,borderlayout.CENTER);
		drawJPanel.addMouseListener(mouseHandler);
		ColorButton.addActionListener(buttonListener);
	}
	
	private class RBListener implements ItemListener{
		public void itemStateChanged(ItemEvent event){
			if(event.getSource()==radioButton[0])
				drawMode=0;
			else if(event.getSource()==radioButton[1])
				drawMode=1;
			else if(event.getSource()==radioButton[2])
				drawMode=2;
			else if(event.getSource()==radioButton[3])
				drawMode=3;
		}// End of itemStateChanged
	}// End of RadioButtonListener
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Color c=JColorChooser.showDialog(Painter.this, "Color Chooser",color);
			if(c != null)color = c;
		}// End of actionPerformed
	}// End of ButtonListener
	
	private class MouseHandler implements MouseListener{
		public void mousePressed(MouseEvent event){
			xValue[0]=event.getX();yValue[0]=event.getY();
		}//End of mousePressed
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub				
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub				
		}
		public void mouseReleased(MouseEvent event) {
			xValue[1]=event.getX();	yValue[1]=event.getY();	
			Objects[iO_bject]=new Shape(drawMode,color,xValue,yValue);
			iO_bject=iO_bject+1;	
			
			drawJPanel.repaint();					
			}//End of mouseReleased
	}//End of MouseHandler
	
	private class DrawJPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);

			for(int i=0; i < iO_bject; i++){
			Objects[i].Paint(g);
			}// End of for-loop
		}/* End of class DrawJPanel */
	}/* End of JPanel class */
	
	public class Shape {
		
		int type;
		int[] X = new int[2]; // left-top point
		int[] Y = new int[2]; // right-bottom point
		
		Color color;
		
		public Shape(int type,Color color,int[] pt1,int[] pt2){
			this.type  = type;
			this.color = color;
			X[0]=pt1[0];X[1]=pt1[1];	
			Y[0]=pt2[0];Y[1]=pt2[1];				
		}//End of Shape Constuructor
		
		public void Paint(Graphics g){
            int width  = 0;
            int height = 0;
            int x = 0;
            int y = 0;
            if(X[1] > X[0]) {
            	width = X[1] - X[0];
            }else {
            	width = X[0] - X[1];
            }
            if(Y[1] > Y[0]) {
            	height = Y[1] - Y[0];
            }else {
            	height = Y[0] - Y[1];
            }
            if(X[1] > X[0]) {
            	x = X[0];
            }else {
            	x = X[1];
            }
            if(Y[1] > Y[0]) {
            	y = Y[0];
            }else {
            	y = Y[1];
            }
            g.setColor(color);
            if(this.type== 0){
                g.setColor(color);
                g.drawLine(X[0],Y[0],X[1],Y[1]);
            }else if (this.type == 1){
                g.setColor(color);
                g.drawRect(x,y,width,height);
            }else if(this.type == 2){
                g.setColor(color);
                g.drawRoundRect(x,y,Math.abs(width),Math.abs(height),100,100);
            }else if (this.type == 3){
                g.setColor(color);
                g.fillRect(x,y,width,height);
            }
        }//End of Paint
	}
	
	public static void main(String args[]) {
		Painter painter = new Painter();
		painter.setSize(640, 480);
		painter.setVisible(true);
	}
}
