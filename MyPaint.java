import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPaint extends JPanel implements Runnable{

  Color myColor  = Color.white;
  int rectMoveX = 225;
  
  int ovalMoveX = 530;
  int ovalMoveY = 400;
  
  static int speed; 
  static int y = 0;
  static int count = 0;
  static int speedInput[] = {0, 18, 16, 14, 12, 10, 8, 7, 5, 3, 1};
  static int scoreOutput[] = {0, 10, 15, 20, 25, 30, 35, 40, 45, 50, 100};
  
  boolean stopThread = false;
  boolean doPlusX  = false;
  boolean doMinusX = false;
  boolean doPlusY  = false;
  boolean doMinusY = false;
  
  int cnt = 0;
  
  
  Thread painter;
  
public void draw(Color c, String s){repaint();}// end draw

public void paintComponent(Graphics g){

	   super.paintComponent(g);

       g.setColor(myColor);
       g.fillOval(ovalMoveX,ovalMoveY,20,20);
       g.fillRect(rectMoveX,399,120,20);
              repaint();
	                                   }//end paint
@Override
public void run(){
	
	while(true){//do a break to end this loop
		        try{		
				  Thread.sleep(speed);						  
				  threadMover();		          		          		          	           		          		         		          
		          cnt++;
		         if(stopThread == true)
		            break;	          
        		   }//ends try
		          catch(InterruptedException ex){}	
		
	    }//ends while
	
}//ends run

synchronized void threadMover(){
	
//////////////// Y position //////////////////////////////////////

//System.out.println("ovalMoveY = "+ovalMoveY);
	 
	     if (doPlusY == false)	
			ovalMoveY = ovalMoveY - 5;
		 if (doPlusY == true)	
			ovalMoveY = ovalMoveY + 5;
		
	    	if(ovalMoveY == 0)
			   doPlusY = true; 
			else if((ovalMoveY == 380)&&((ovalMoveX >= MyPong.barMin)&&(ovalMoveX <= MyPong.barMax))){	
			   setValueScore();
			   doPlusY = false;}
		
		
			   
/////////////////////////////////////////////////////////////////		
////////////////// X Position ///////////////////////////////////

//System.out.println("ovalMoveX = "+ovalMoveX);

		 if (doPlusX == false)	
			ovalMoveX = ovalMoveX - 5;
		 if (doPlusX == true)	
			ovalMoveX = ovalMoveX + 5;	
		 
		    if(ovalMoveX == 0)
		       doPlusX = true;
		    else if(ovalMoveX == 530)	
			   doPlusX = false;	
			   
			   
			   
			    if(ovalMoveY > 425){
			      MyPong.setErrMsg("Sorry you LOST");
		    	   stopThread = true;}
/////////////////////////////////////////////////////////////////			
			
		    repaint();
		}//ends mover
		
public void toRun(int speedIn){  
	    speed = speedInput[speedIn];      
        painter = new Thread(this);//create new thread
        painter.start();        
                    }//ends to run
public static void setValueScore(){
	  
	   if(count == 15){
	      count = 0; 
	     MyPong.setErrMsg("Reached next Level");
	      speed = speedInput[y+1];
	    if(speed == speedInput[10])  
	      speed = speedInput[10];
	       }//ends first if
	  
	 for(int x = 0; x < speedInput.length; x++)
	    if(speed == speedInput[x]){
			y = x;
	       MyPong.setScoreValue(scoreOutput[x]);
	        }//ends if
           
           count++;
    	   
}//ends set score
}// end MyJPanel clas
