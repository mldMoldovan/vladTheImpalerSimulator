
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;







public class AboutMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    private boolean wheelUsed=false;
    private int x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18;
    private int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13,y14,y15,y16,y17,y18;
    
    
    public AboutMenu(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
        x1=(int)Game.WIDTH/2-150;
        x2=(int)Game.WIDTH/2-80;
        x3=(int)Game.WIDTH/2-130;
        x4=(int)Game.WIDTH/2-100;
        x5=(int)Game.WIDTH/2-70;
        x6=(int)Game.WIDTH/2-110;
        x7=(int)Game.WIDTH/2-140;
        x8=(int)Game.WIDTH/2-125;
        x9=(int)Game.WIDTH/2-150;
        x10=(int)Game.WIDTH/2-100;
        x11=(int)Game.WIDTH/2-130;
        x12=(int)Game.WIDTH/2-170;
        x13=(int)Game.WIDTH/2-120;
        x14=(int)Game.WIDTH/2-170;
        x15=(int)Game.WIDTH/2-140;
        x16=(int)Game.WIDTH/2-125;
        x17=(int)Game.WIDTH/2-160;
        x18=(int)Game.WIDTH/2-100;
        y1=(int)Game.HEIGHT/4;
        y2=(int)Game.HEIGHT/4+40;
        y3=(int)Game.HEIGHT/4+70;
        y4=(int)Game.HEIGHT/4+100;
        y5=(int)Game.HEIGHT/4+150;
        y6=(int)Game.HEIGHT/4+180;
        y7=(int)Game.HEIGHT/4+230;
        y8=(int)Game.HEIGHT/4+260;
        
        y9=(int)Game.HEIGHT/4+300;
        y10=(int)Game.HEIGHT/4+330;
        
        y11=(int)Game.HEIGHT/4+370;
        y12=(int)Game.HEIGHT/4+400;
        
        y13=(int)Game.HEIGHT/4+440;
        y14=(int)Game.HEIGHT/4+470;
        
        y15=(int)Game.HEIGHT/4+510;
        y16=(int)Game.HEIGHT/4+540;
        
        y17=(int)Game.HEIGHT/4+580;
        y18=(int)Game.HEIGHT/4+610;
             
                
    }
    
    public void positionReset(){
       x1=(int)Game.WIDTH/2-150;
        x2=(int)Game.WIDTH/2-80;
        x3=(int)Game.WIDTH/2-130;
        x4=(int)Game.WIDTH/2-100;
        x5=(int)Game.WIDTH/2-70;
        x6=(int)Game.WIDTH/2-110;
        x7=(int)Game.WIDTH/2-140;
        x8=(int)Game.WIDTH/2-125;
        x9=(int)Game.WIDTH/2-150;
        x10=(int)Game.WIDTH/2-100;
        x11=(int)Game.WIDTH/2-130;
        x12=(int)Game.WIDTH/2-170;
        x13=(int)Game.WIDTH/2-120;
        x14=(int)Game.WIDTH/2-170;
        x15=(int)Game.WIDTH/2-140;
        x16=(int)Game.WIDTH/2-125;
        x17=(int)Game.WIDTH/2-160;
        x18=(int)Game.WIDTH/2-100;
        y1=(int)Game.HEIGHT/4;
        y2=(int)Game.HEIGHT/4+40;
        y3=(int)Game.HEIGHT/4+70;
        y4=(int)Game.HEIGHT/4+100;
        y5=(int)Game.HEIGHT/4+150;
        y6=(int)Game.HEIGHT/4+180;
        y7=(int)Game.HEIGHT/4+230;
        y8=(int)Game.HEIGHT/4+260;
        
        y9=(int)Game.HEIGHT/4+300;
        y10=(int)Game.HEIGHT/4+330;
        
        y11=(int)Game.HEIGHT/4+370;
        y12=(int)Game.HEIGHT/4+400;
        
        y13=(int)Game.HEIGHT/4+440;
        y14=(int)Game.HEIGHT/4+470;
        
        y15=(int)Game.HEIGHT/4+510;
        y16=(int)Game.HEIGHT/4+540;
        
        y17=(int)Game.HEIGHT/4+580;
        y18=(int)Game.HEIGHT/4+610;
    }
    
    
    public void mouseWheelMoved(MouseWheelEvent e){
        if(Game.gameState==STATE.AboutMenu){
        if(e.getWheelRotation()!=0){
            wheelUsed=true;
            if( e.getWheelRotation()>0){
            //in jos 
            y1+=3;
            y2+=3;
            y3+=3;
            y4+=3;
            y5+=3;
            y6+=3;
            y7+=3;
            y8+=3;
            y9+=3;
            y10+=3;
            y11+=3;
            y12+=3;
            y13+=3;
            y14+=3;
            y15+=3;
            y16+=3;
            y17+=3;
            y18+=3;
            
        } 
        else if(e.getWheelRotation()<0){
            //in sus
        y1-=3;
        y2-=3;
        y3-=3;
        y4-=3;
        y5-=3;
        y6-=3;
        y7-=3;
        y8-=3;
        y9-=3;
        y10-=3;
        y11-=3;
        y12-=3;
        y13-=3;
        y14-=3;
        y15-=3;
        y16-=3;
        y17-=3;
        y18-=3;
        }
        }
        else if(e.getWheelRotation()==0){
            wheelUsed=false;
        }
        
        }
    }
    
    
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(Game.WIDTH==640 && Game.gameState==STATE.AboutMenu){
            if(mouseOver(mx,my,(int)Game.WIDTH/2-100,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.MainMenu;
        positionReset();
        wheelUsed=false;
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
    
    
    
    private boolean mouseOver(int mx, int my,int x,int y,int width, int height) {
        if(mx > x && mx < (x + width))
        {
            if(my > y && my < (y + height)){
                return true;
            }else return false;
            
        }else return false;
        
    }
    
    
    
    public void tick(){
        if(wheelUsed==false){
        y1--;
        y2--;
        y3--;
        y4--;
        y5--;
        y6--;
        y7--;
        y8--;
        y9--;
        y10--;
        y11--;
        y12--;
        y13--;
        y14--;
        y15--;
        y16--;
        y17--;
        y18--;
        
        
        
        }
        if(y1<=-600){
            positionReset();
            wheelUsed=false;
        }
        
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.AboutMenu){
            g.setFont(Game.MenuFont);
            
            if(Game.WIDTH==640)
            {
                
        // RECT UP CENTER
        
        g.setColor(Color.white);
        g.drawString("2017 MLD Corporation",x1,y1);
        g.drawString("Codename",x2,y2);
        g.drawString("Impaling Simulator",x3,y3);
        g.drawString("Version 0.1.6",x4,y4);
        
        g.drawString("Producer",x5,y5);
        g.drawString("Mihai Moldovan",x6,y6);
        
        g.drawString("Android Development",x7,y7);
        g.drawString("Erwin Robert Hajdo",x8,y8);
        
        g.drawString("Additional Development",x9,y9);
        g.drawString("Mihai Mustatea",x10,y10);
        
        g.drawString("QA Project Manager",x11,y11);
        g.drawString("Alexandru Adrian Dragan",x12,y12);
        
        g.drawString("Sound Engineer",x13,y13);
        g.drawString("Andrei Adrian Sagaidac",x14,y14);
        
        g.drawString("Graphical Engineer",x15,y15);
        g.drawString("Andrei Iosif Viola",x16,y16);
        
        g.drawString("Additional Development",x17,y17);
        g.drawString("Aurelian Fagu",x18,y18);
        
        
        
        //LAST Y VARIABLE DETECTION
        //g.drawString("y"+y1,20,(int)Game.HEIGHT-50);
        
        
        g.setColor(Color.red);
        g.fillRoundRect((int)Game.WIDTH/2-100,(int)Game.HEIGHT-90,200,50,40,40);
        g.setColor(Color.white);
        g.drawRoundRect((int)Game.WIDTH/2-100,(int)Game.HEIGHT-90,200,50,40,40);
        g.drawString("Back",(int)Game.WIDTH/2-40,(int)Game.HEIGHT-50);
        
        
        
        
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
