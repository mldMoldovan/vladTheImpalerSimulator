
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







public class CheatMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    
    
    public CheatMenu(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
    }
    
    
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(Game.gameState==STATE.CheatMenu){
        if(Game.WIDTH==640){
            
            //CHEAT 001 - PLAYER XYS
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,10,200,50)){
                if(Game.cheatsMatrix[0]==true){
                    Game.cheatsMatrix[0]=false;
                }
                else if(Game.cheatsMatrix[0]==false){
                    Game.cheatsMatrix[0]=true;
                }
        
    }
            //CHEAT 002 - SHOW FPS
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,70,200,50)){
        if(Game.cheatsMatrix[1]==true){
                    Game.cheatsMatrix[1]=false;
                }
                else if(Game.cheatsMatrix[1]==false){
                    Game.cheatsMatrix[1]=true;
                }
    }
            //CHEAT 003 - NO COLLISION
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,130,200,50)){
        if(Game.cheatsMatrix[2]==true){
                    Game.cheatsMatrix[2]=false;
                }
                else if(Game.cheatsMatrix[2]==false){
                    Game.cheatsMatrix[2]=true;
                }
    }
            
            //CHEAT 004 - STOP FALL
            if(mouseOver(mx,my,(int)Game.WIDTH/2-310,190,200,50)){
        if(Game.cheatsMatrix[3]==true){
                    Game.cheatsMatrix[3]=false;
                }
                else if(Game.cheatsMatrix[3]==false){
                    Game.cheatsMatrix[3]=true;
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
        if(Game.gameState==STATE.CheatMenu){
            g.setFont(Game.MenuFont);
            
            if(Game.WIDTH==640)
            {
        //RECT UP LEFT 
        if(Game.cheatsMatrix[0]==true){
        g.setColor(Game.GreenColor);}
        if(Game.cheatsMatrix[0]==false){
        g.setColor(Color.red);}
        g.fillRoundRect((int)Game.WIDTH/2-310,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,10,200,50,40,40);
        g.drawString("Show Player XYS",(int)Game.WIDTH/2-290,40);
        
        //RECT MEDIUM LEFT
        if(Game.cheatsMatrix[1]==true){
        g.setColor(Game.GreenColor);}
        if(Game.cheatsMatrix[1]==false){
        g.setColor(Color.red);}
        g.fillRoundRect((int)Game.WIDTH/2-310,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,70,200,50,40,40);
        g.drawString("Show FPS",(int)Game.WIDTH/2-290,100);
        
        //RECT DOWN LEFT
        if(Game.cheatsMatrix[2]==true){
        g.setColor(Game.GreenColor);}
        if(Game.cheatsMatrix[2]==false){
        g.setColor(Color.red);}
        g.fillRoundRect((int)Game.WIDTH/2-310,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,130,200,50,40,40);
        g.drawString("No Collisions",(int)Game.WIDTH/2-290,160);
        
        //RECT HELL LEFT
        if(Game.cheatsMatrix[3]==true){
        g.setColor(Game.GreenColor);}
        if(Game.cheatsMatrix[3]==false){
        g.setColor(Color.red);}
        g.fillRoundRect((int)Game.WIDTH/2-310,190,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,190,200,50,40,40);
        g.drawString("Stop Fall",(int)Game.WIDTH/2-290,220);
        
        //RECT HELL DOWN LEFT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-310,250,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,250,200,50,40,40);
        g.drawString("Cheat 005",(int)Game.WIDTH/2-290,280);
        
        
        
        
        
        // RECT UP CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,10,200,50,40,40);
        g.drawString("Cheat 006",(int)Game.WIDTH/2-80,40);
        
        //RECT MEDIUM CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,70,200,50,40,40);
        g.drawString("Cheat 007",(int)Game.WIDTH/2-80,100);
        
        
        
        //RECT DOWN CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,130,200,50,40,40);
        g.drawString("Cheat 008",(int)Game.WIDTH/2-80,160);
        
        
        //RECT HELL CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,190,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,190,200,50,40,40);
        g.drawString("Cheat 009",(int)Game.WIDTH/2-80,220);
        
        //RECT HELL DOWN CENTER
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2-100,250,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,250,200,50,40,40);
        g.drawString("Cheat 010",(int)Game.WIDTH/2-80,280);
        
        
        
        
        
        // RECT UP RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,10,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,10,200,50,40,40);
        g.drawString("Cheat 011",(int)Game.WIDTH/2+130,40);
        
        //RECT MEDIUM RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,70,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,70,200,50,40,40);
        g.drawString("Cheat 012",(int)Game.WIDTH/2+130,100);
        
        
        
        //RECT DOWN RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,130,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,130,200,50,40,40);
        g.drawString("Cheat 013",(int)Game.WIDTH/2+130,160);
        
        
        //RECT HELL RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,190,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,190,200,50,40,40);
        g.drawString("Cheat 014",(int)Game.WIDTH/2+130,220);
        
        //RECT HELL DOWN RIGHT
        g.setColor(Color.blue);
        g.fillRoundRect((int)Game.WIDTH/2+110,250,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,250,200,50,40,40);
        g.drawString("Cheat 015",(int)Game.WIDTH/2+130,280);
        
        
        
        
        //RECT BACK DOWN LEFT
        g.setColor(Color.red);
        g.fillRoundRect((int)Game.WIDTH/2-310,310,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-310,310,200,50,40,40);
        g.drawString("Back",(int)Game.WIDTH/2-250,340);
        
        //RECT NEXT DOWN RIGHT
        g.setColor(Color.green);
        g.fillRoundRect((int)Game.WIDTH/2+110,310,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2+110,310,200,50,40,40);
        g.drawString("Next Page",(int)Game.WIDTH/2+140,340);
        
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
