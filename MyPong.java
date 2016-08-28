import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class MyPong extends JFrame implements ActionListener,MouseMotionListener,MouseListener {
    
    Font font1  = new Font("Arial", Font.BOLD, 18);
    Font font2  = new Font("Arial", Font.BOLD + Font.ITALIC, 13);
    Font font3  = new Font("Arial", Font.BOLD + Font.ITALIC, 10);
     
    JLabel lblScore = new JLabel("Score:");
	static JLabel lblScoreValue = new JLabel("0");
	JLabel lblSpeed = new JLabel("Speed:");	
	JLabel lblSpeedRange = new JLabel("1 -10");
	static JLabel lblMsg   = new JLabel("Play pong?");
	
	JTextField txtSpeed = new JTextField("1");
	
	JButton butPlay = new JButton("Play");
	JButton butStop = new JButton("Reset");
	
	JPanel pMain = new JPanel();
		
	MyPaint myPaint = new MyPaint();
	
	boolean mouseState = false; //true when pressed
	
	static int barMin = 0;
	static int barMid = 0;
	static int barMax = 0;
	int speedSet = 0;
	static int scoreKeeper = 0;
	
	Container c = getContentPane();
	
  public static void main(String[] args){
          SwingUtilities.invokeLater(new Runnable(){
			public void run(){					
				 MyPong myPong = new MyPong();				 
	                    myPong.setTitle("My Pong Game");			 		                
		                myPong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				        myPong.pack();
	                    myPong.setVisible(true);
	                    myPong.setResizable(false);
	                    myPong.setLocation(330,200);//sets location
					}});
               }//ends main 
MyPong(){

	PongLayout customLayout = new PongLayout();
	c.setLayout(customLayout);
		
	lblScore.setFont(font1);
	lblScoreValue.setFont(font1);
	lblSpeed.setFont(font1);
	lblMsg.setFont(font2);
	lblSpeedRange.setFont(font3);
	
	pMain.setBackground(Color.BLUE);
	myPaint.setBackground(Color.BLUE);
	pMain.setLayout(new BorderLayout());
    			
    c.add(pMain);    
	c.add(lblScore);	
	c.add(lblSpeed);
	c.add(lblMsg);
	c.add(lblScoreValue);
	c.add(txtSpeed);
	c.add(butPlay);
	c.add(butStop);
	c.add(lblSpeedRange);
	
	pMain.add(myPaint, BorderLayout.CENTER);
	
	myPaint.addMouseMotionListener(this);
    myPaint.addMouseListener(this);
    butPlay.addActionListener(this);
    butStop.addActionListener(this);
	getBarCoord();
}//ends constructor

public void getBarCoord(){
	
	barMin = myPaint.rectMoveX;	
	barMax = myPaint.rectMoveX + 121;
	barMid = barMax / 2;
		
	}//ends get Bar
public void getSpeed(){
	
	int getSpeedIn = 0;
    try { getSpeedIn = Integer.parseInt(txtSpeed.getText());
		 if((getSpeedIn > 0)&&( getSpeedIn < 11))
		  myPaint.toRun(getSpeedIn);
		 else  
		   setErrMsg("Speed must be 1-10.");
		    }
    catch (NumberFormatException ex){  
	          setErrMsg("Speed must be 1-10."); }
    
    
      }	//ends getSpeed
public void actionPerformed(ActionEvent e){
	
	String actionCommand = e.getActionCommand();

	if("Play".equals(actionCommand)){	
		   setErrMsg("Enjoy");       
	       getSpeed();	       
	        }
	if("Reset".equals(actionCommand)){       
		   reset();}
	}//ends actionPerf

public void reset(){
 
  myPaint.rectMoveX = 225;  
  myPaint.ovalMoveX = 530;
  myPaint.ovalMoveY = 400;
  myPaint.stopThread = false;
  myPaint.doPlusX  = false;
  myPaint.doMinusX = false;
  myPaint.doPlusY  = false;
  myPaint.doMinusY = false;
  setErrMsg("Play again?");
  lblScoreValue.setText("0");	
	}//ends reset
	
public void mouseReleased(MouseEvent e) {mouseState = false;}
public void mouseDragged(MouseEvent e)  {
	
	getBarCoord();
	
	int x = e.getX()-60;
    int y = e.getY();//up&down - not using
    
    if(x > 429)
     x = 429;
    else if(x < 1)
     x = 1;
     
    myPaint.rectMoveX = x;
    
	//System.out.println("Mouse x = "+x);
	}//ends dragged
	
public void mouseEntered(MouseEvent e)  {}
public void mouseExited(MouseEvent e)   {}
public void mouseMoved(MouseEvent e)    {}
public void mouseClicked(MouseEvent e)  {}
public void mousePressed(MouseEvent e)  {mouseState = true;}
public static void setErrMsg(String msg){
	lblMsg.setText(msg);
}//ends err
public static void setScoreValue(int val){
       scoreKeeper = scoreKeeper + val;
       lblScoreValue.setText(Integer.toString(scoreKeeper)); 

 }//ends getScoreValue

}//ends class MyPong
