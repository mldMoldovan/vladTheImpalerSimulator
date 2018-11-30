
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;





public class Impalers extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    Game Game;
    private GameObject player;
    public static int[] xValues= new int[3];
    public static int[] yValues=new int[3];
    
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
    
    
    public Impalers(double x, double y,double objectHealth,int objectStatus, ID id, Handler handler){
        super(x,y,objectHealth,objectStatus,id);
        this.handler=handler;
        this.objectHealth = 100;
        for(int j=0;j<3;j++){
            xValues[j]=0;
            yValues[j]=0;
            xValuesOne[j]=0;
            xValuesTwo[j]=0;
            xValuesThree[j]=0;
            xValuesFour[j]=0;
            xValuesFive[j]=0;
            yValuesOne[j]=0;
            
            xValuesBig[j]=0;
            yValuesBig[j]=0;
            
            xValuesBig1[j]=0;
            xValuesBig2[j]=0;
            xValuesBig3[j]=0;
            xValuesBig4[j]=0;
            xValuesBig5[j]=0;
            xValuesBig6[j]=0;
            
            
        }
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId() == ID.Player)
            player = handler.object.get(i);
            
        
        }
    }
    
    public Rectangle getBounds(){
        if(this.getId()==ID.SmallImpaler){
        return new Rectangle((int)x,(int)y-55,70,70);}
        else if(this.getId()==ID.MediumImpaler){
        return new Rectangle((int)x,(int)y-55,210,70);}
        else{
        return new Rectangle((int)x,(int)y-55,300,70);}
    }
    
    
    
    public void collision(){
        for(int i=0;i < handler.object.size(); i++){
            GameObject iaraObject = handler.object.get(i);
            if(this.getId()==ID.MediumImpaler){
            if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                if(this.getX()>Game.WIDTH/2){
                    iaraObject.setX(this.getX()-90);
                }
                else if(this.getX()<=Game.WIDTH/2){
                    iaraObject.setX(this.getX()+230);
                }
                
            }
            
            
        }
            if(iaraObject.getId() == ID.Coin){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                /*if(this.getX()>Game.WIDTH/2){
                    iaraObject.setX(this.getX()-110);
                }
                else if(this.getX()<=Game.WIDTH/2){
                    iaraObject.setX(this.getX()+250);
                }*/
                iaraObject.setY(this.getY()+100);
                
            }
            
            
        }
            
            
            
        
        
        
        
        }
           if(this.getId()==ID.SmallImpaler){
               if(iaraObject.getId() == ID.Coin){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                /*if(this.getX()>Game.WIDTH/2){
                    iaraObject.setX(this.getX()-100);
                }
                else if(this.getX()<=Game.WIDTH/2){
                    iaraObject.setX(this.getX()+100);
                } */
                iaraObject.setY(this.getY()+100);
                
            }
            
            
        }
           }
           
           
           if(this.getId()==ID.BigImpaler){
               if(iaraObject.getId() == ID.Coin){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                /*if(this.getX()>Game.WIDTH/2){
                    iaraObject.setX(this.getX()-100);
                }
                else if(this.getX()<=Game.WIDTH/2){
                    iaraObject.setX(this.getX()+320);
                }*/
                iaraObject.setY(this.getY()+100);
                
            }
            
            
        }
               if(iaraObject.getId() == ID.SmallImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                handler.removeObject(iaraObject);
                
            }
            
            
        }
               
               if(iaraObject.getId() == ID.MediumImpaler){
            
            if(getBounds().intersects(iaraObject.getBounds()))
            {
                
                handler.removeObject(iaraObject);
                
            }
            
            
        }
               
               
               
           }
            
            
        }
    }
    
    
    public void tick(){
        x+=velX;
        y+=velY;
        if(this.getId()==ID.SmallImpaler){
        xValues[0]=(int)x+30;
        xValues[1]=(int)x+40;
        xValues[2]=(int)x+35;
        yValues[0]=(int)y-5;
        yValues[1]=(int)y-5;
        yValues[2]=(int)y-55;}
        
        if(this.getId()==ID.MediumImpaler){
        xValuesOne[0]=(int)x+30;
        xValuesOne[1]=(int)x+40;
        xValuesOne[2]=(int)x+35;
        yValuesOne[0]=(int)y-5;
        yValuesOne[1]=(int)y-5;
        yValuesOne[2]=(int)y-55;}
        
        if(this.getId()==ID.BigImpaler){
        xValuesBig[0]=(int)x+30;
        xValuesBig[1]=(int)x+40;
        xValuesBig[2]=(int)x+35;
        yValuesBig[0]=(int)y-5;
        yValuesBig[1]=(int)y-5;
        yValuesBig[2]=(int)y-55;}
        
        for(int i=0;i<3;i++){
            xValuesTwo[i]=xValuesOne[i]+40;
            xValuesThree[i]=xValuesOne[i]+80;
            xValuesFour[i]=xValuesOne[i]+120;
            xValuesFive[i]=xValuesOne[i]+160;
            
            xValuesBig1[i]=xValuesBig[i]+40;
            xValuesBig2[i]=xValuesBig[i]+80;
            xValuesBig3[i]=xValuesBig[i]+120;
            xValuesBig4[i]=xValuesBig[i]+160;
            xValuesBig5[i]=xValuesBig[i]+200;
            xValuesBig6[i]=xValuesBig[i]+240;
        }
        
        if(player.getVelY()>0){
            this.setVelY(player.getVelY()*(-1));
            
        }
        else{
            this.setVelY(0);
        }
        
        if(this.getId()==ID.Platform){
          if(this.getY()+40<0){  
             handler.removeObject(this); 
          }
        }
        if(this.getY()+70<0){
            if(this.getId()==ID.SmallImpaler){
            handler.addObject(new Impalers((int)Game.clamp(r.nextInt((int)Game.WIDTH),50,Game.WIDTH-100),(int)Game.HEIGHT+100,100,1,ID.SmallImpaler,handler));}
            else if(this.getId()==ID.MediumImpaler){
            handler.addObject(new Impalers((int)Game.clamp(r.nextInt((int)Game.WIDTH),10,Game.WIDTH-250),(int)Game.HEIGHT+100,100,1,ID.MediumImpaler,handler));
            }
            else if(this.getId()==ID.BigImpaler){
            handler.addObject(new Impalers((int)Game.clamp(r.nextInt((int)Game.WIDTH),20,Game.WIDTH-300),(int)Game.HEIGHT+100,100,1,ID.BigImpaler,handler));
            }
            handler.removeObject(this);
        }
        
        collision();
    }
    
    
    
    
    
    public void render(Graphics g){
        if(this.getId()==ID.SmallImpaler){
        g.setColor(Game.BrownCP);
        g.fillRoundRect((int)x,(int)y,70,20,20,20);
        g.fillRect((int)x+2,(int)y,68,5);
        g.setColor(Color.green);
        g.fillRoundRect((int)x,(int)y-5,70,5,20,20);
        
        g.setColor(Color.DARK_GRAY);
        //g.fillRect((int)x+30,(int)y-55,10,50);
        
        g.fillPolygon(xValues,yValues,3);
        }
        
        
        else if(this.getId()==ID.MediumImpaler){
        g.setColor(Game.BrownCP);
        g.fillRoundRect((int)x,(int)y,210,20,20,20);
        g.fillRect((int)x+2,(int)y,208,5);
        g.setColor(Color.green);
        g.fillRoundRect((int)x,(int)y-5,210,5,20,20);
        
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(xValuesOne,yValuesOne,3);
        g.fillPolygon(xValuesTwo,yValuesOne,3);
        g.fillPolygon(xValuesThree,yValuesOne,3);
        g.fillPolygon(xValuesFour,yValuesOne,3);
        g.fillPolygon(xValuesFive,yValuesOne,3);
        }
        
        
        else if(this.getId()==ID.BigImpaler){
        g.setColor(Game.BrownCP);
        g.fillRoundRect((int)x,(int)y,300,20,20,20);
        g.fillRect((int)x+2,(int)y,298,5);
        g.setColor(Color.green);
        g.fillRoundRect((int)x,(int)y-5,300,5,20,20);
        
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(xValuesBig,yValuesBig,3);
        g.fillPolygon(xValuesBig1,yValuesBig,3);
        g.fillPolygon(xValuesBig2,yValuesBig,3);
        g.fillPolygon(xValuesBig3,yValuesBig,3);
        g.fillPolygon(xValuesBig4,yValuesBig,3);
        g.fillPolygon(xValuesBig5,yValuesBig,3);
        g.fillPolygon(xValuesBig6,yValuesBig,3);
        
        
        }
        if(this.getId()==ID.Platform){
        g.setColor(Game.BrownCP);
        g.fillRoundRect((int)x,(int)y,310,20,20,20);
        g.fillRect((int)x+2,(int)y,308,5);
        g.setColor(Color.green);
        g.fillRoundRect((int)x,(int)y-5,310,5,20,20);   
        }
        
        
        }
    }
    


