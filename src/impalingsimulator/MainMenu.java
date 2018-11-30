
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







public class MainMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    private float alpha = 0.7f;
    
    private String Play_String;
    private String Quit_String;
    private String Options_String;
    private String Player_String;
    private String About_String;
    
    
    public MainMenu(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
        StringSet();
    }
    
    public void StringSet(){
        if(Game.langState==LANGUAGE.English){
            Play_String="Play";
        }
        if(Game.langState==LANGUAGE.French){
            
        }
        if(Game.langState==LANGUAGE.Spanish){
            
        }
        if(Game.langState==LANGUAGE.Brazilian){
            
        }
        if(Game.langState==LANGUAGE.Italian){
            
        }
        if(Game.langState==LANGUAGE.German){
            
        }
        if(Game.langState==LANGUAGE.Danish){
            
        }
        if(Game.langState==LANGUAGE.Finnish){
            
        }
        if(Game.langState==LANGUAGE.Swedish){
            
        }
        if(Game.langState==LANGUAGE.Norsk){
            
        }
        if(Game.langState==LANGUAGE.Romanian){
           Play_String="Joaca"; 
        }
        if(Game.langState==LANGUAGE.Hungarian){
            
        }
        
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(Game.gameState==STATE.MainMenu){
        
        if(Game.WIDTH==640){
            if(mouseOver(mx,my,(int)Game.WIDTH/2-100,(int)Game.HEIGHT/2-350,200,200)){
        Game.gameState = STATE.FreeFall;
    }
            if(mouseOver(mx,my,50,(int)Game.HEIGHT/3*2,100,100)){
        Game.gameState = STATE.OptionsMenu;
    }
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2,100,100)){
        System.exit(1);
    }
            
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,20,100,100)){
        Game.gameState = STATE.PlayerMenu;
    }
            
            if(mouseOver(mx,my,50,20,100,100)){
             Game.gameState=STATE.AboutMenu;
    }
        }
        if(Game.WIDTH==960){
        //MAIN MENU
        
           //PULA MEA
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
        StringSet();
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.MainMenu){
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
                
                
                Graphics2D mainMenuG = (Graphics2D) g;
                mainMenuG.setComposite(makeTransparent(alpha));
                
                g.setColor(Color.white);
                g.fillOval((int)Game.WIDTH/2-100,(int)Game.HEIGHT/2-350,200,200);
                g.setColor(Color.black);
                g.drawOval((int)Game.WIDTH/2-100,(int)Game.HEIGHT/2-350,200,200);
                g.setFont(Game.ScoreFont);
                g.drawString(Play_String,(int)Game.WIDTH/2-30,(int)Game.HEIGHT/2-200);
            
                
                g.setColor(Color.red);
                g.fillOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2,100,100);
                g.drawString("Quit",(int)Game.WIDTH/3*2+70,(int)Game.HEIGHT/3*2+60);
            
                
                g.setColor(Game.PurpleColor);
                g.fillOval(50,(int)Game.HEIGHT/3*2,100,100);
                g.setColor(Color.white);
                g.drawOval(50,(int)Game.HEIGHT/3*2,100,100);
                g.drawString("Options",52,(int)Game.HEIGHT/3*2+60);
                
                
                g.setColor(Color.GRAY);
                g.fillOval(50,20,100,100);
                g.setColor(Color.white);
                g.drawOval(50,20,100,100);
                g.drawString("About",60,80);
                
                
                g.setColor(Game.GreenColor);
                g.fillOval((int)Game.WIDTH/3*2+50,20,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,20,100,100);
                g.drawString("Player",(int)Game.WIDTH/3*2+60,80);
                
                mainMenuG.setComposite(makeTransparent(1));
            
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
