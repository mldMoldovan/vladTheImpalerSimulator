
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;





public class BloodDrop extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private GameObject player;
    public static int[] xValues= new int[3];
    public static int[] yValues=new int[3];
    
    private float alpha = 0.3f;
    
    public static int[] xValuesOne= new int[3];
    public static int[] yValuesOne=new int[3];
    public static int[] xValuesTwo= new int[3];
    public static int[] xValuesThree= new int[3];
    public static int[] xValuesFour= new int[3];
    public static int[] xValuesFive= new int[3];
    
    public static int[] xValuesBig = new int[3];
    public static int[] yValuesBig = new int[3];
    public static int[] xValuesBig1 = new int[3];
    public static int[] xValuesBig2 = new int[3];
    public static int[] xValuesBig3 = new int[3];
    public static int[] xValuesBig4 = new int[3];
    public static int[] xValuesBig5 = new int[3];
    public static int[] xValuesBig6 = new int[3];
    
    
    public BloodDrop(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
        super(x,y,objectHealth,objectStatus,id);
        this.handler=handler;
        this.objectHealth = 100;
        
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId() == ID.Player)
            player = handler.object.get(i);
            
        
        }
    }
    
    public Rectangle getBounds(){
        
        return new Rectangle((int)x,(int)y,8,15);
        
    }
    
    
    
    
    
    
    public void tick(){
        x+=velX;
        y+=velY;
        
        if(player.getVelY()>0){
            this.setVelY(player.getVelY()*(-1));
            
        }
        else{
            this.setVelY(0);
        }
        
        
        if(this.getY()+15<0){
            
           // handler.addObject(new BloodDrop((int)Game.clamp(r.nextInt((int)Game.WIDTH),20,Game.WIDTH-300),(int)Game.HEIGHT+100,100,1,ID.BloodDrop,handler));
            
            handler.removeObject(this);
        }
        
        
    }
    
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    
    public void render(Graphics g){
        if(this.getId()==ID.BloodDrop){
        Graphics2D bloodG = (Graphics2D) g;
        bloodG.setComposite(makeTransparent(alpha));
        
        g.setColor(Color.red);
        g.fillOval((int)x,(int)y,8,15);
        
        bloodG.setComposite(makeTransparent(1));
        }
        
        }
    }
    


