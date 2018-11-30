
package impalingsimulator;



import static impalingsimulator.Game.HEIGHT;
import static impalingsimulator.Game.WIDTH;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







public class EndMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    private float alpha = 0.7f;
    
    
    public EndMenu(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
        
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(Game.gameState==STATE.EndMenu){
        if(Game.WIDTH==640){
            if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.MainMenu;
    }
            if(mouseOver(mx,my,350,(int)Game.HEIGHT-240,100,100)){
        Game.gameState = STATE.FreeFall;
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
        //System.exit(1);
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
        if(Game.fallenScore>Game.savedScore){
            Game.savedScore=Game.fallenScore;
        }
        
        Game.SaveGame();
        //Game.cinematicDone=false;
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.EndMenu){
            g.setFont(Game.MenuFont);
            
            if(Game.WIDTH==640)
            {
                
        g.drawImage(Game.tepesBackground2,0,0,Game);
                
        // RECT UP CENTER
                
          
        g.setColor(Color.green);
        g.drawString("You lost ! ",50,30);
        g.drawString("Score: " + Game.fallenScore,50,60);
        
        
        
        
        g.setColor(Color.red);
        g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,40,40);
        g.drawString("Quit",80,(int)Game.HEIGHT-55);
        
        Graphics2D endMenuG = (Graphics2D) g;
        endMenuG.setComposite(makeTransparent(alpha));
        g.setFont(Game.Cal20);
        g.setColor(Game.SkyBlue);
                g.fillOval(350,(int)Game.HEIGHT-240,100,100);
                g.setColor(Color.white);
                g.drawOval(350,(int)Game.HEIGHT-240,100,100);
                g.drawString("Try Again",360,(int)Game.HEIGHT-185);
                
        endMenuG.setComposite(makeTransparent(1));
        
        
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
