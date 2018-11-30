
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







public class HelpMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    private float alpha = 0.7f;
    
    
    public HelpMenu(Game Game,Handler handler,MainHUD hud){
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
        if(Game.gameState==STATE.HelpMenu){
        if(Game.WIDTH==640){
            if(mouseOver(mx,my,(int)Game.WIDTH/2-100,(int)Game.HEIGHT-100,200,200)){
        Game.gameState = STATE.Tutorial;
    }
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2,100,100)){
        Game.gameState = STATE.GameHelp;
    }
            
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,20,100,100)){
        Game.gameState = STATE.DonationHelp;
    }
            if(mouseOver(mx,my,50,20,100,100)){
        Game.gameState = STATE.CustomerSupport;
    }
            
            if(mouseOver(mx,my,50,(int)Game.HEIGHT/3*2,100,100)){
             Game.gameState=STATE.OptionsMenu;
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
        
        else if(Game.gameState==STATE.CustomerSupport){
            if(Game.WIDTH==640){
              if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
                  Game.gameState=STATE.HelpMenu;
    }  
            }
        }
        
        else if(Game.gameState==STATE.DonationHelp){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
                  Game.gameState=STATE.HelpMenu;
    }
            }
        }
        
        else if(Game.gameState==STATE.GameHelp){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
                  Game.gameState=STATE.HelpMenu;
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
        if(Game.gameState==STATE.HelpMenu){
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
                
                g.drawImage(Game.tepesBackground3,0,0,Game);
                
                
                Graphics2D helpMenuG = (Graphics2D) g;
                helpMenuG .setComposite(makeTransparent(alpha));
                
                
                
                g.setColor(Color.yellow);
                g.fillOval((int)Game.WIDTH/2-100,(int)Game.HEIGHT-100,200,200);
                g.setColor(Color.DARK_GRAY);
                g.drawOval((int)Game.WIDTH/2-100,(int)Game.HEIGHT-100,200,200);
                g.setFont(Game.ScoreFont);
                g.drawString("Tutorial",(int)Game.WIDTH/2-50,(int)Game.HEIGHT-50);
            
                
                g.setColor(Game.GreenColor);
                g.fillOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2,100,100);
                g.drawString("Game",(int)Game.WIDTH/3*2+65,(int)Game.HEIGHT/3*2+50);
                g.drawString("Help",(int)Game.WIDTH/3*2+70,(int)Game.HEIGHT/3*2+80);
                
                
                
                g.setColor(Color.red);
                g.fillOval(50,(int)Game.HEIGHT/3*2,100,100);
                g.setColor(Color.white);
                g.drawOval(50,(int)Game.HEIGHT/3*2,100,100);
                g.drawString("Back",67,(int)Game.HEIGHT/3*2+60);
                
                g.setFont(Game.Roman20);
                g.setColor(Color.blue);
                g.fillOval(50,20,100,100);
                g.setColor(Color.white);
                g.drawOval(50,20,100,100);
                g.drawString("Customer",56,70);
                g.drawString("Support",63,90);
                
                
                
                
                g.setColor(Game.SkyBlue);
                g.fillOval((int)Game.WIDTH/3*2+50,20,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,20,100,100);
                g.drawString("Donation",(int)Game.WIDTH/3*2+60,70);
                 g.setFont(Game.MenuFont);
                g.drawString("Help",(int)Game.WIDTH/3*2+70,100);
            
                
                helpMenuG .setComposite(makeTransparent(1));
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
        
        else if(Game.gameState==STATE.CustomerSupport){
            if(Game.WIDTH==640){
                g.drawImage(Game.tepesImage,-10,20,Game);
                g.setFont(Game.Cal30);
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
                g.setColor(Game.GreenColor);
                g.fillOval(260,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-190,150,150);
                g.drawString("Report",295,(int)Game.HEIGHT-115);
                g.drawString("A Bug",300,(int)Game.HEIGHT-90);
                
                
                g.setColor(Game.GreenColor);
                g.fillOval(430,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-190,150,150);
                g.drawString("Contact Us",440,(int)Game.HEIGHT-105);
                
                
                g.setColor(Game.GreenColor);
                g.fillRoundRect(260,(int)Game.HEIGHT-360,320,150,90,90);
                g.setColor(Color.white);
                g.drawRoundRect(260,(int)Game.HEIGHT-360,320,150,90,90);
                g.drawString("Join our Website!",310,(int)Game.HEIGHT-275);
                
            }
            
        }
        
        else if(Game.gameState==STATE.GameHelp){
            if(Game.WIDTH==640){
                g.drawImage(Game.tepesImage,-10,20,Game);
                g.setFont(Game.Cal30);
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(260,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-190,150,150);
                g.drawString("Questions",270,(int)Game.HEIGHT-105);
                
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(430,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-190,150,150);
                g.drawString("Story",470,(int)Game.HEIGHT-105);
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(260,(int)Game.HEIGHT-360,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-360,150,150);
                g.drawString("Customize",270,(int)Game.HEIGHT-275);
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(430,(int)Game.HEIGHT-360,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-360,150,150);
                g.drawString("Market",460,(int)Game.HEIGHT-275);
            }
            
        }
        
        else if(Game.gameState==STATE.DonationHelp){
            if(Game.WIDTH==640){
                g.drawImage(Game.tepesImage,-10,20,Game);
                g.setFont(Game.Cal30);
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(260,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-190,150,150);
                g.drawString("Questions",270,(int)Game.HEIGHT-105);
                
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(430,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-190,150,150);
                g.drawString("Details",460,(int)Game.HEIGHT-105);
                
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(340,(int)Game.HEIGHT-360,150,150);
                g.setColor(Color.white);
                g.drawOval(340,(int)Game.HEIGHT-360,150,150);
                g.drawString("How Does",355,(int)Game.HEIGHT-280);
                g.drawString("It Work?",365,(int)Game.HEIGHT-255);
            }
            
        }
        
    }
    
    
    
}
