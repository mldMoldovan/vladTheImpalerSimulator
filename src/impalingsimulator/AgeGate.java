
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;







public class AgeGate extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    
    
    public AgeGate(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
    }
    
    public void mouseWheelMoved(MouseWheelEvent e){
        if(Game.gameState==STATE.AgeGate){
        if( e.getWheelRotation()>0){
            //in jos 
            if(Game.userAge>0){
            Game.userAge--;}
        } 
        else if(e.getWheelRotation()<0){
            //in sus
            if(Game.userAge<100){
            Game.userAge++;}
        }}
        
    }
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(Game.gameState==STATE.AgeGate){
        
        if(Game.WIDTH==640){
            if(mouseOver(mx,my,(int)Game.WIDTH/2-100,(int)Game.HEIGHT/2-100,200,200)){
        if(Game.userAge>0 && Game.userAge<100){
            Game.gameState=STATE.MainMenu;
        }
    }
    
        }
        if(Game.WIDTH==960){
        //MAIN MENU
        
           //SLAV STORY
        if(mouseOver(mx,my,(int)Game.WIDTH/2-150,20,300,100)){
        Game.gameState = STATE.FreeFall;
    }
           //QUIT
        if(mouseOver(mx,my,(int)Game.WIDTH/2-150,500,300,100)){
        System.exit(1);
    }
        
        
        
        }
        }
        
    }
    
    
    
    private boolean mouseOver(int mx, int my,int x,int y,int width, int height) {
        if(mx > x && mx < (x + width))
        {
            if(my > y && my < (y + height)){
                return true;
            }else return false;
            
        }else return false;
        
    }
    
    
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.AgeGate){
            g.setFont(Game.MenuFont);
            
        /*    if(Game.WIDTH==640)
            {
                
        // RECT UP CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,10,200,50,40,40);
        g.drawString("Impale Now",(int)Game.WIDTH/2-80,40);
        
        
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,70,200,50,40,40);
        g.drawString("Options",(int)Game.WIDTH/2-80,100);
        
        
        g.setColor(Color.red);
        g.fillRoundRect((int)Game.WIDTH/2-100,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,130,200,50,40,40);
        g.drawString("Quit",(int)Game.WIDTH/2-80,160);
        
        
            }*/
            if(Game.WIDTH==640){
                g.setColor(Game.SkyBlue);
                g.fillOval((int)Game.WIDTH/2-100,(int)Game.HEIGHT/2-100,200,200);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/2-100,(int)Game.HEIGHT/2-100,200,200);
                g.setFont(Game.ScoreFont);
                if(Game.userAge<10){
                g.drawString(""+Game.userAge,(int)Game.WIDTH/2-10,(int)Game.HEIGHT/2+10);}
                else if(Game.userAge>9){
                g.drawString(""+Game.userAge,(int)Game.WIDTH/2-15,(int)Game.HEIGHT/2+10);}
                 
                g.setColor(Color.white);
                g.drawString("Enter your age:",(int)Game.WIDTH/2-100,100);
                
                
                g.drawString("Scroll to change Age",(int)Game.WIDTH/2-120,(int)Game.HEIGHT-100);
                g.drawString("Press The Bubble To Proceed",(int)Game.WIDTH/2-170,(int)Game.HEIGHT-70);
            
            }
            
            if(Game.WIDTH==960)
            {
        g.setColor(Color.white);
        g.drawString("Slav Story",(int)Game.WIDTH/2-80,80);
        g.drawRoundRect((int)Game.WIDTH/2-150,20,300,100,20,20);
        
        
        g.drawRoundRect((int)Game.WIDTH/2-150,140,300,100,20,20);
        
        
        
        g.drawRoundRect((int)Game.WIDTH/2-150,260,300,100,20,20);
        
        
        g.drawString("Settings",(int)Game.WIDTH/2-60,440);
        g.drawRoundRect((int)Game.WIDTH/2-150,380,300,100,20,20);
        
        
        g.drawString("Quit",(int)Game.WIDTH/2-40,560);
        g.drawRoundRect((int)Game.WIDTH/2-150,500,300,100,20,20);
            }
        }
        
    }
    
    
    
}
