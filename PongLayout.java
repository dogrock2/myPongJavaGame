
import java.awt.*;

class PongLayout implements LayoutManager {

    public PongLayout() {}
    public void addLayoutComponent(String name, Component comp) {}
    public void removeLayoutComponent(Component comp) {}

    public Dimension preferredLayoutSize(Container parent) {
       
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        //***these values change the main window sizes***
        // dim.width = 654 + insets.left + insets.right;
        // dim.height = 439 + insets.top + insets.bottom;
        dim.width = 745;
        dim.height = 445;
        return dim;
        
    }//preferredLayoutSize

   public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }//ends minimumLayoutSize

   public void layoutContainer(Container parent) {

        Insets insets = parent.getInsets();

        Component c;
          c = parent.getComponent(0);
        if (c.isVisible())//MainPanel position
           {c.setBounds(insets.left+10,insets.top+8,550,420);}
          c = parent.getComponent(1);
        if (c.isVisible())//lblScore position
           {c.setBounds(insets.left+575,insets.top+8,72,74);} 
           c = parent.getComponent(2);
        if (c.isVisible())//lblSpeed position
           {c.setBounds(insets.left+575,insets.top+88,72,74);} 
           c = parent.getComponent(3);
        if (c.isVisible())//lblMsg position
           {c.setBounds(insets.left+575,insets.top+168,172,74);} 
           c = parent.getComponent(4);
        if (c.isVisible())//lblScoreValue position
           {c.setBounds(insets.left+660,insets.top+9,72,74);}
           c = parent.getComponent(5);
        if (c.isVisible())//txtSpeed position
           {c.setBounds(insets.left+660,insets.top+112,25,25);}
           c = parent.getComponent(6);
        if (c.isVisible())//butPlay position
           {c.setBounds(insets.left+570,insets.top+403,65,25);}
           c = parent.getComponent(7);
        if (c.isVisible())//butReset position
           {c.setBounds(insets.left+650,insets.top+403,80,25);}
           c = parent.getComponent(8);
        if (c.isVisible())//lblSpeedRange position
           {c.setBounds(insets.left+690,insets.top+118,70,25);}
       //   c = parent.getComponent(9);
        //if (c.isVisible())//lblSpeedRange position
          // {c.setBounds(insets.left+125,insets.top+200,70,25);}
                       
    }//Ends layoutContainer
}//Ends Class testerLayout
