
package impalingsimulator;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;







public class OptionsMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    private float alpha = 0.7f;
    
    
    public OptionsMenu(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
    }
    
    public void mouseWheelMoved(MouseWheelEvent e){
        if(Game.gameState==STATE.SoundMenu){
            if(mouseOver(e.getX(),e.getY(),10,10,200,50)){
        if( e.getWheelRotation()>0){
            //in jos 
            if(Game.volumeLevel>0){
            Game.volumeLevel--;}
        } 
        else if(e.getWheelRotation()<0){
            //in sus
            if(Game.volumeLevel<100){
            Game.volumeLevel++;}
        }
        }
        }
        
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(Game.gameState==STATE.OptionsMenu){
        if(Game.WIDTH==640){
            
            if(mouseOver(mx,my,50,(int)Game.HEIGHT/3*2-150,100,100)){
        Game.gameState = STATE.MainMenu;
    }
            
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2-150,100,100)){
        Game.gameState = STATE.SoundMenu;
    }
            if(mouseOver(mx,my,50,20,100,100)){
        Game.gameState=STATE.GraphicsMenu;
    }
            
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,20,100,100)){
             Game.gameState=STATE.OtherMenu;
    }
            
            if(mouseOver(mx,my,(int)Game.WIDTH/3*2+50,(int)Game.HEIGHT-150,100,100)){
             Game.gameState=STATE.LanguageMenu;
    }
            if(mouseOver(mx,my,350,(int)Game.HEIGHT-240,100,100)){
             Game.gameState=STATE.HelpMenu;
    }
        }
        if(Game.WIDTH==960){
        //MAIN MENU
        
           //SLAV STORY
        if(mouseOver(mx,my,(int)Game.WIDTH/2-150,20,300,100)){
        //Game.gameState = STATE.FreeFall;
    }
           //QUIT
        if(mouseOver(mx,my,(int)Game.WIDTH/2-150,500,300,100)){
        System.exit(1);
    }
        
        
        
        }
        }
        
        
        else if(Game.gameState==STATE.SoundMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.OptionsMenu;
    }
                if(mouseOver(mx,my,10,70,200,50)){
        if(Game.masterAudio==true){
            Game.masterAudio=false;
        }
        else if(Game.masterAudio==false){
            Game.masterAudio=true;
        }
    }
                
                if(mouseOver(mx,my,10,130,200,50)){
        if(Game.masterSFX==true){
            Game.masterSFX=false;
        }
        else if(Game.masterSFX==false){
            Game.masterSFX=true;
        }
    }
                
                if(mouseOver(mx,my,10,190,200,50)){
        if(Game.masterMusic==true){
            Game.masterMusic=false;
        }
        else if(Game.masterMusic==false){
            Game.masterMusic=true;
        }
    }
                
                
            }
            
            
            
        }
        
        else if(Game.gameState==STATE.GraphicsMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.OptionsMenu;
    }
                if(mouseOver(mx,my,260,(int)Game.HEIGHT-190,150,150)){
        Game.gameState = STATE.LightMenu;
    }
                if(mouseOver(mx,my,260,(int)Game.HEIGHT-360,320,150)){
        Game.gameState = STATE.ResolutionMenu;
    }
                if(mouseOver(mx,my,430,(int)Game.HEIGHT-190,150,150)){
        Game.gameState = STATE.QualityMenu;
    }
                
                
            }
            
            
            
        }
        else if(Game.gameState==STATE.OtherMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.OptionsMenu;
    }
                
                
                if(mouseOver(mx,my,260,(int)Game.HEIGHT-360,150,150)){
                   Game.ResetProfile();
    }
                
                if(mouseOver(mx,my,430,(int)Game.HEIGHT-360,150,150)){
                   Game.ResetScore();
    }
                if(mouseOver(mx,my,430,(int)Game.HEIGHT-190,150,150)){
                   if(Game.cinematicEnabled==true){
                       Game.cinematicEnabled=false;
                   }
                   else if(Game.cinematicEnabled==false){
                       Game.cinematicEnabled=true;
                   }
    }
                
                
            }
            
            
            
        }
        
        else if(Game.gameState==STATE.ResolutionMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.GraphicsMenu;
    }
                
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-460,150,150)){
        Game.selectedResolution = 640;//
    }
                if(mouseOver(mx,my,180,(int)Game.HEIGHT-460,150,150)){
        Game.selectedResolution = 960;//
    }
                if(mouseOver(mx,my,100,(int)Game.HEIGHT-290,150,150)){
        Game.selectedResolution = 1280;
    }
                if(mouseOver(mx,my,370,(int)Game.HEIGHT-460,150,150)){
        Game.selectedResolution = 1366;//
    }
                if(mouseOver(mx,my,290,(int)Game.HEIGHT-290,150,150)){
        Game.selectedResolution = 1680;//
    }
                if(mouseOver(mx,my,460,(int)Game.HEIGHT-290,150,150)){
        Game.selectedResolution = 1920;//
    }
                
                
            }
            
            
            
        }
        
        else if(Game.gameState==STATE.LightMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.GraphicsMenu;
    }
                
                if(mouseOver(mx,my,260,(int)Game.HEIGHT-290,150,150)){
                   Game.lightSettings=2;
    }
                
                if(mouseOver(mx,my,430,(int)Game.HEIGHT-290,150,150)){
        Game.lightSettings=1;
    }
                
                if(mouseOver(mx,my,340,(int)Game.HEIGHT-460,150,150)){
        Game.lightSettings=3;
    }
                
                
            }
            
            
            
        }
        
        else if(Game.gameState==STATE.LanguageMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.OptionsMenu;
    }
                if(mouseOver(mx,my,(int)Game.WIDTH/2-150,(int)Game.HEIGHT/2+60,30,30)){
        if(Game.langInt>1){
            Game.langInt--;
        }
        else if(Game.langInt<=1){
            Game.langInt=19;
        }
    }
                if(mouseOver(mx,my,(int)Game.WIDTH/2+120,(int)Game.HEIGHT/2+60,30,30)){
        if(Game.langInt<19){
            Game.langInt++;
        }
        else if(Game.langInt>=19){
            Game.langInt=1;
        }
    }
                
                
            }
            
            
            
        }
        
        else if(Game.gameState==STATE.QualityMenu){
            if(Game.WIDTH==640){
                if(mouseOver(mx,my,10,(int)Game.HEIGHT-90,200,50)){
        Game.gameState = STATE.GraphicsMenu;
    }
                if(mouseOver(mx,my,260,(int)Game.HEIGHT-290,150,150)){
                   Game.graphicSettings=2;
    }
                
                if(mouseOver(mx,my,430,(int)Game.HEIGHT-290,150,150)){
        Game.graphicSettings=1;
    }
                
                if(mouseOver(mx,my,340,(int)Game.HEIGHT-460,150,150)){
        Game.graphicSettings=3;
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
        if(Game.langInt==1){
            Game.langState=LANGUAGE.English;
        }
        else if(Game.langInt==2){
            Game.langState=LANGUAGE.French;
        }
        else if(Game.langInt==3){
            Game.langState=LANGUAGE.Spanish;
        }
        else if(Game.langInt==4){
            Game.langState=LANGUAGE.Brazilian;
        }
        else if(Game.langInt==5){
            Game.langState=LANGUAGE.Italian;
        }
        else if(Game.langInt==6){
            Game.langState=LANGUAGE.German;
        }
        else if(Game.langInt==7){
            Game.langState=LANGUAGE.Danish;
        }
        else if(Game.langInt==8){
            Game.langState=LANGUAGE.Finnish;
        }
        else if(Game.langInt==9){
            Game.langState=LANGUAGE.Swedish;
        }
        else if(Game.langInt==10){
            Game.langState=LANGUAGE.Norsk;
        }
        else if(Game.langInt==11){
            Game.langState=LANGUAGE.Romanian;
        }
        else if(Game.langInt==12){
            Game.langState=LANGUAGE.Hungarian;
        }
        else if(Game.langInt==13){
            Game.langState=LANGUAGE.Polish;
        }
        else if(Game.langInt==14){
            Game.langState=LANGUAGE.Russian;
        }
        else if(Game.langInt==15){
            Game.langState=LANGUAGE.Chinese;
        }
        else if(Game.langInt==16){
            Game.langState=LANGUAGE.Japanese;
        }
        else if(Game.langInt==17){
            Game.langState=LANGUAGE.Vietnamese;
        }
        else if(Game.langInt==18){
            Game.langState=LANGUAGE.Korean;
        }
        else if(Game.langInt==19){
            Game.langState=LANGUAGE.Arabic;
        }
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.OptionsMenu){
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
                g.drawImage(Game.tepesBackground2,0,0,Game);
                
                
                Graphics2D opMenuG = (Graphics2D) g;
                opMenuG.setComposite(makeTransparent(alpha));
                
                
                g.setColor(Game.GreenColor);
                g.fillOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2-150,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT/3*2-150,100,100);
                g.drawString("Sound",(int)Game.WIDTH/3*2+55,(int)Game.HEIGHT/3*2-90);
                
                
                g.setFont(Game.Roman20);
                g.setColor(Game.BloodColor);
                g.fillOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT-150,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,(int)Game.HEIGHT-150,100,100);
                g.drawString("Language",(int)Game.WIDTH/3*2+55,(int)Game.HEIGHT-90);
                
                
                
                g.setFont(Game.MenuFont);
                g.setColor(Game.SkyBlue);
                g.fillOval(350,(int)Game.HEIGHT-240,100,100);
                g.setColor(Color.white);
                g.drawOval(350,(int)Game.HEIGHT-240,100,100);
                g.drawString("Help",365,(int)Game.HEIGHT-180);
                
                
                
                
                g.setFont(Game.Roman20);
                g.setColor(Color.blue);
                g.fillOval(50,20,100,100);
                g.setColor(Color.white);
                g.drawOval(50,20,100,100);
                g.drawString("Graphics",57,80);
                
                
                
                g.setFont(Game.MenuFont);
                g.setColor(Game.RoyalBlue);
                g.fillOval((int)Game.WIDTH/3*2+50,20,100,100);
                g.setColor(Color.white);
                g.drawOval((int)Game.WIDTH/3*2+50,20,100,100);
                g.drawString("Other",(int)Game.WIDTH/3*2+60,80);
            
                
                
                g.setFont(Game.MenuFont);
                g.setColor(Color.red);
                g.fillOval(50,(int)Game.HEIGHT/3*2-150,100,100);
                g.setColor(Color.white);
                g.drawOval(50,(int)Game.HEIGHT/3*2-150,100,100);
                g.drawString("Back",67,(int)Game.HEIGHT/3*2-90);
                
                opMenuG.setComposite(makeTransparent(1));
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
        
        else if(Game.gameState==STATE.SoundMenu){
            if(Game.WIDTH==640){
                
                g.drawImage(Game.soundImage,0,0,Game);
                
                g.setFont(Game.Cal30);
                g.setColor(Color.blue);
                g.fillRoundRect(10,10,200,50,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(10,10,200,50,20,20);
                g.drawString("Volume: "+Game.volumeLevel,15,40);
                
                if(Game.masterAudio==false){
                    g.setColor(Color.red);
                }
                else if(Game.masterAudio==true){
                    g.setColor(Game.GreenColor);
                }
                g.fillRoundRect(10,70,200,50,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(10,70,200,50,20,20);
                g.drawString("Master Volume",15,100);
                
                
                if(Game.masterSFX==false){
                    g.setColor(Color.red);
                }
                else if(Game.masterSFX==true){
                    g.setColor(Game.GreenColor);
                }
                g.fillRoundRect(10,130,200,50,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(10,130,200,50,20,20);
                g.drawString("Master SFX",15,160);
                
                
                if(Game.masterMusic==false){
                    g.setColor(Color.red);
                }
                else if(Game.masterMusic==true){
                    g.setColor(Game.GreenColor);
                }
                g.fillRoundRect(10,190,200,50,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(10,190,200,50,20,20);
                g.drawString("Master Music",15,220);
                
                
                
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
            }
        }
        
        else if(Game.gameState==STATE.LanguageMenu){
            if(Game.WIDTH==640){
                g.drawImage(Game.tepesBackground,0,0,Game);
                
                Graphics2D langMenuG = (Graphics2D) g;
                langMenuG.setComposite(makeTransparent(alpha));
                g.setFont(Game.Cal30);
                g.setColor(Game.RoyalBlue);
                g.fillRoundRect((int)Game.WIDTH/2-100,(int)Game.HEIGHT/2+50,200,50,20,20);
                g.setColor(Color.white);
                g.drawRoundRect((int)Game.WIDTH/2-100,(int)Game.HEIGHT/2+50,200,50,20,20);
                if(Game.langInt==3){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-55,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==4){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-60,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==5){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-45,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==6){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-55,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==9){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-55,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==10){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-45,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==11){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-65,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==12){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-65,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==13){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-45,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==14){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-55,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==15){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-55,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==16){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-60,(int)Game.HEIGHT/2+85);   
                }
                else if(Game.langInt==17){
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-75,(int)Game.HEIGHT/2+85);   
                }
                else{
                g.drawString(" "+Game.langState,(int)Game.WIDTH/2-50,(int)Game.HEIGHT/2+85);
                }
                g.setColor(Game.GreenColor);
                g.fillOval((int)Game.WIDTH/2-150,(int)Game.HEIGHT/2+60,30,30);
                g.setColor(Color.yellow);
                g.drawOval((int)Game.WIDTH/2-150,(int)Game.HEIGHT/2+60,30,30);
                g.drawString("<",(int)Game.WIDTH/2-140, (int)Game.HEIGHT/2+85);
                
                
                g.setColor(Game.GreenColor);
                g.fillOval((int)Game.WIDTH/2+120,(int)Game.HEIGHT/2+60,30,30);
                g.setColor(Color.yellow);
                g.drawOval((int)Game.WIDTH/2+120,(int)Game.HEIGHT/2+60,30,30);
                g.drawString(">",(int)Game.WIDTH/2+130, (int)Game.HEIGHT/2+85);
                
                
                
                langMenuG.setComposite(makeTransparent(1));
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
                
                
            }
        }
        
        else if(Game.gameState==STATE.GraphicsMenu){
            if(Game.WIDTH==640){
                g.setFont(Game.Cal30);
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
                g.setColor(Game.PurpleColor);
                g.fillOval(260,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-190,150,150);
                g.drawString("Lightning",280,(int)Game.HEIGHT-105);
                
                
                g.setColor(Game.PurpleColor);
                g.fillOval(430,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-190,150,150);
                g.drawString("Quality",460,(int)Game.HEIGHT-105);
                
                
                g.setColor(Game.PurpleColor);
                g.fillRoundRect(260,(int)Game.HEIGHT-360,320,150,90,90);
                g.setColor(Color.white);
                g.drawRoundRect(260,(int)Game.HEIGHT-360,320,150,90,90);
                g.drawString("Resolution",340,(int)Game.HEIGHT-275);
                
                
                
                g.drawImage(Game.tepesImage,-10,20,Game);
            
                
            }
        }
        
        else if(Game.gameState==STATE.OtherMenu){
            if(Game.WIDTH==640){
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
                g.drawString("Skip",305,(int)Game.HEIGHT-115);
                g.drawString("Tutorial",280,(int)Game.HEIGHT-90);
                
                if(Game.cinematicEnabled==true){
                g.setColor(Game.GreenColor);}
                else if(Game.cinematicEnabled==false){
                g.setColor(Game.BloodColor);}
                g.fillOval(430,(int)Game.HEIGHT-190,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-190,150,150);
                g.drawString("Skip",475,(int)Game.HEIGHT-115);
                g.drawString("Animation",440,(int)Game.HEIGHT-90);
                
                g.setColor(Game.ArmyBlue);
                g.fillOval(260,(int)Game.HEIGHT-360,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-360,150,150);
                g.drawString("Reset",300,(int)Game.HEIGHT-285);
                g.drawString("Profile",295,(int)Game.HEIGHT-260);
                
                
                if(Game.savedScore>0){
                g.setColor(Game.ArmyBlue);}
                else if(Game.savedScore<=0){
                g.setColor(Color.DARK_GRAY);    
                }
                g.fillOval(430,(int)Game.HEIGHT-360,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-360,150,150);
                g.drawString("Reset Score",435,(int)Game.HEIGHT-275);
                
                
                g.drawImage(Game.tepesImage2,-45,20,Game);
                
            }
        }
        
        
        else if(Game.gameState==STATE.ResolutionMenu){
            if(Game.WIDTH==640){
                
                g.drawImage(Game.soundImage,0,0,Game);
                
                Graphics2D resMenuG = (Graphics2D) g;
                resMenuG.setComposite(makeTransparent(alpha));
                
                g.setFont(Game.Cal30);
                
                
                if(Game.selectedResolution==1680){
                g.setColor(Game.GreenColor);}
                else if(Game.selectedResolution!=1680){
                g.setColor(Color.gray);}
                g.fillOval(290,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(290,(int)Game.HEIGHT-290,150,150);
                g.drawString("1680",330,(int)Game.HEIGHT-205);
                
                
                if(Game.selectedResolution==1920){
                g.setColor(Game.GreenColor);}
                else if(Game.selectedResolution!=1920){
                g.setColor(Color.gray);}
                g.fillOval(460,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(460,(int)Game.HEIGHT-290,150,150);
                g.drawString("1920",505,(int)Game.HEIGHT-205);
                
                
                if(Game.selectedResolution==1366){
                g.setColor(Game.GreenColor);}
                else if(Game.selectedResolution!=1366){
                g.setColor(Color.gray);}
                g.fillOval(370,(int)Game.HEIGHT-460,150,150);
                g.setColor(Color.white);
                g.drawOval(370,(int)Game.HEIGHT-460,150,150);
                g.drawString("1366",415,(int)Game.HEIGHT-375);
                
                
                if(Game.selectedResolution==960){
                g.setColor(Game.GreenColor);}
                else if(Game.selectedResolution!=960){
                g.setColor(Color.gray);}
                g.fillOval(180,(int)Game.HEIGHT-460,150,150);
                g.setColor(Color.white);
                g.drawOval(180,(int)Game.HEIGHT-460,150,150);
                g.drawString("960",230,(int)Game.HEIGHT-375);
                
                
                if(Game.selectedResolution==640){
                g.setColor(Game.GreenColor);}
                else if(Game.selectedResolution!=640){
                g.setColor(Color.gray);}
                g.fillOval(10,(int)Game.HEIGHT-460,150,150);
                g.setColor(Color.white);
                g.drawOval(10,(int)Game.HEIGHT-460,150,150);
                g.drawString("640",60,(int)Game.HEIGHT-375);
                
                
                if(Game.selectedResolution==1280){
                g.setColor(Game.GreenColor);}
                else if(Game.selectedResolution!=1280){
                g.setColor(Color.gray);}
                g.fillOval(100,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(100,(int)Game.HEIGHT-290,150,150);
                g.drawString("1280",145,(int)Game.HEIGHT-205);
                
                resMenuG.setComposite(makeTransparent(1));
                
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
            }
        }
        
        else if(Game.gameState==STATE.LightMenu){
            if(Game.WIDTH==640){
                g.setFont(Game.Cal30);
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
                if(Game.lightSettings==2){
                g.setColor(Game.GreenColor);}
                if(Game.lightSettings!=2){
                g.setColor(Color.gray);}
                g.fillOval(260,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-290,150,150);
                g.drawString("Medium",280,(int)Game.HEIGHT-215);
                g.drawString("Detail",295,(int)Game.HEIGHT-190);
                
                
                if(Game.lightSettings==1){
                g.setColor(Game.GreenColor);}
                if(Game.lightSettings!=1){
                g.setColor(Color.gray);}
                g.fillOval(430,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-290,150,150);
                g.drawString("Low",475,(int)Game.HEIGHT-220);
                g.drawString("Detail",465,(int)Game.HEIGHT-195);
                
                
                if(Game.lightSettings==3){
                g.setColor(Game.GreenColor);}
                if(Game.lightSettings!=3){
                g.setColor(Color.gray);}
                g.fillOval(340,(int)Game.HEIGHT-460,150,150);
                g.setColor(Color.white);
                g.drawOval(340,(int)Game.HEIGHT-460,150,150);
                g.drawString("High",385,(int)Game.HEIGHT-380);
                g.drawString("Detail",375,(int)Game.HEIGHT-355);
                
                
                g.drawImage(Game.tepesImage2,-45,20,Game);
                
            }
        }
        
        else if(Game.gameState==STATE.QualityMenu){
            if(Game.WIDTH==640){
                g.setFont(Game.Cal30);
                g.setColor(Color.red);
                g.fillRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(10,(int)Game.HEIGHT-90,200,50,50,50);
                g.drawString("Back",70,(int)Game.HEIGHT-55);
                
                
                
                if(Game.graphicSettings==2){
                g.setColor(Game.GreenColor);}
                else if(Game.graphicSettings!=2){
                g.setColor(Color.gray);}
                g.fillOval(260,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(260,(int)Game.HEIGHT-290,150,150);
                g.drawString("Medium",280,(int)Game.HEIGHT-215);
                g.drawString("Detail",295,(int)Game.HEIGHT-190);
                
                
                if(Game.graphicSettings==1){
                g.setColor(Game.GreenColor);}
                else if(Game.graphicSettings!=1){
                g.setColor(Color.gray);}
                g.fillOval(430,(int)Game.HEIGHT-290,150,150);
                g.setColor(Color.white);
                g.drawOval(430,(int)Game.HEIGHT-290,150,150);
                g.drawString("Low",475,(int)Game.HEIGHT-220);
                g.drawString("Detail",465,(int)Game.HEIGHT-195);
                
                if(Game.graphicSettings==3){
                g.setColor(Game.GreenColor);}
                else if(Game.graphicSettings!=3){
                g.setColor(Color.gray);}
                g.fillOval(340,(int)Game.HEIGHT-460,150,150);
                g.setColor(Color.white);
                g.drawOval(340,(int)Game.HEIGHT-460,150,150);
                g.drawString("High",385,(int)Game.HEIGHT-380);
                g.drawString("Detail",375,(int)Game.HEIGHT-355);
                
                
                g.drawImage(Game.tepesImage2,-45,20,Game);
                
            }
        }
        
    }
    
    
    
}
