
package impalingsimulator;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;







public class PlayerMenu extends MouseAdapter{
    
    private Game Game;
    private Handler handler;
    private MainHUD hud;
    private int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,ys1,ys2,ys3,ys4,ys5,ys6,ys7,ys8,ys9,ys10;
    
    
    public PlayerMenu(Game Game,Handler handler,MainHUD hud){
        this.Game=Game;
        this.handler=handler;
        this.hud=hud;
        ResetY();
    }
    
    public void ResetY(){
        
        y1=2;
        y2=27;
        y3=52;
        y4=77;
        y5=102;
        y6=127;
        y7=152;
        y8=177;
        y9=202;
        y10=227;
        
        ys1=20;
        ys2=45;
        ys3=70;
        ys4=95;
        ys5=120;
        ys6=145;
        ys7=170;
        ys8=195;
        ys9=220;
        ys10=245;
        
    }
    
    
    public void DesetY(){
        
        y1=-98;
        y2=-73;
        y3=-48;
        y4=-23;
        y5=2;
        y6=27;
        y7=52;
        y8=77;
        y9=102;
        y10=127;
        
        ys1=-80;
        ys2=-55;
        ys3=-30;
        ys4=-5;
        ys5=20;
        ys6=45;
        ys7=70;
        ys8=95;
        ys9=120;
        ys10=145;
        
    }
    
    public void MoveUp(){
        if(y1<26){
        y1+=25;
        y2+=25;
        y3+=25;
        y4+=25;
        y5+=25;
        y6+=25;
        y7+=25;
        y8+=25;
        y9+=25;
        y10+=25;
        
        ys1+=25;
        ys2+=25;
        ys3+=25;
        ys4+=25;
        ys5+=25;
        ys6+=25;
        ys7+=25;
        ys8+=25;
        ys9+=25;
        ys10+=25;}
    }
    public void MoveDown(){
        if(y1>-100){
        y1-=25;
        y2-=25;
        y3-=25;
        y4-=25;
        y5-=25;
        y6-=25;
        y7-=25;
        y8-=25;
        y9-=25;
        y10-=25;
        
        
        ys1-=25;
        ys2-=25;
        ys3-=25;
        ys4-=25;
        ys5-=25;
        ys6-=25;
        ys7-=25;
        ys8-=25;
        ys9-=25;
        ys10-=25;}
    }
    
    public void mouseWheelMoved(MouseWheelEvent e){
        if(Game.gameState==STATE.PlayerMenu){
            if(mouseOver(e.getX(),e.getY(),420,-30,220,200)){
        if( e.getWheelRotation()>0){
            //in jos 
            if(Game.outfitInteger>0){
            if(Game.outfitInteger>=5){
            MoveUp();    
            }
            Game.outfitInteger--;}
            else if(Game.outfitInteger<=0){
            Game.outfitInteger=9;
            DesetY();
            }
        } 
        else if(e.getWheelRotation()<0){
            //in sus
            if(Game.outfitInteger<9){
            if(Game.outfitInteger>=5){
            MoveDown();   
            }   
            Game.outfitInteger++;}
            else if(Game.outfitInteger>=9){
            Game.outfitInteger=0;
            ResetY();
            }
        }
        }
        if(mouseOver(e.getX(),e.getY(),30,150,130,30)){
         if( e.getWheelRotation()>0){
            //in jos 
            if(Game.skinInteger>0){
                Game.skinInteger--;
            }
            else if(Game.skinInteger<=0){
                Game.skinInteger=4;
            }
        }
         if( e.getWheelRotation()<0){
            //in sus 
            if(Game.skinInteger<4){
                Game.skinInteger++;
            }
            else if(Game.skinInteger>=4){
                Game.skinInteger=0;
            }
        }
        }
        }
        
        
    }
    
    
    public void mouseClicked(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(Game.gameState==STATE.PlayerMenu){
        if(Game.WIDTH==640){
            //BACK BUTTON
            if(mouseOver(mx,my,(int)Game.WIDTH/2-100,(int)Game.HEIGHT-70,200,100)){
                Game.SaveGame();
        Game.gameState = STATE.MainMenu;
    }
            if(mouseOver(mx,my,260,-75,150,150)){
                if(Game.customOutfit==true){
                  Game.customOutfit=false;  
                }
                else if(Game.customOutfit==false){
                    Game.customOutfit=true;
                }
    }
            
            //SELECT NEXT SHIRT
            if(mouseOver(mx,my,(int)Game.WIDTH-250,(int)Game.HEIGHT/2+30,60,60)){
                if(Game.customOutfit==true){
             if(Game.shirtInteger<4){
                Game.shirtInteger++;}
             else if(Game.shirtInteger>=4)
             {
                 Game.shirtInteger=0;
             }}
                
            else if(Game.customOutfit==false){
                if(Game.outfitInteger<9){
                Game.outfitInteger++;}
             else if(Game.outfitInteger>=9)
             {
                 Game.outfitInteger=0;
             }
            }
    }
            
            //SELECT NEXT PANTS
            if(mouseOver(mx,my,(int)Game.WIDTH-250,(int)Game.HEIGHT/2+100,60,60)){
             if(Game.pantsInteger<4){
                Game.pantsInteger++;}
             else if(Game.pantsInteger>=4)
             {
                 Game.pantsInteger=0;
             }
    }
            //SELECT NEXT SKIN
            if(mouseOver(mx,my,(int)Game.WIDTH-250,(int)Game.HEIGHT/2-40,60,60)){
             if(Game.skinInteger<4){
                Game.skinInteger++;}
             else if(Game.skinInteger>=4)
             {
                 Game.skinInteger=0;
             }
    }
            
            
            
            //SELECT PREVIOUS SHIRT
            if(mouseOver(mx,my,180,(int)Game.HEIGHT/2+30,60,60)){
                if(Game.customOutfit==true){
             if(Game.shirtInteger>0){
                Game.shirtInteger--;}
             else if(Game.shirtInteger<=0)
             {
                 Game.shirtInteger=4;
             }}
                else if(Game.customOutfit==false){
                if(Game.outfitInteger>0){
                Game.outfitInteger--;}
             else if(Game.outfitInteger<=0)
             {
                 Game.outfitInteger=9;
             }
                }
    }
            //SELECT PREVIOUS PANTS
            if(mouseOver(mx,my,180,(int)Game.HEIGHT/2+100,60,60)){
             if(Game.pantsInteger>0){
                Game.pantsInteger--;}
             else if(Game.pantsInteger<=0)
             {
                 Game.pantsInteger=4;
             }
    }
            //SELECT PREVIOUS SKIN
            if(mouseOver(mx,my,180,(int)Game.HEIGHT/2-40,60,60)){
             if(Game.skinInteger>0){
                Game.skinInteger--;}
             else if(Game.skinInteger<=0)
             {
                 Game.skinInteger=4;
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
        if(y1==27){
            ResetY();
        }
    }
    
    public void render(Graphics g){
        if(Game.gameState==STATE.PlayerMenu){
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
                
                g.drawImage(Game.tepesBackground4,0,0,Game);
                
                g.setFont(Game.Cal25);
                
                g.setColor(Game.ArmyBlue);
                g.fillRoundRect(-30, -30, 280, 160, 50, 50);
                g.setColor(Color.white);
                g.drawRoundRect(-30, -30, 280, 160, 50, 50);
                
                g.setColor(Color.yellow);
                g.fillOval(260,-75,150,150);
                g.setColor(Color.red);
                
                
                g.setColor(Game.ArmyBlue);
                g.fillRoundRect(30,150,130,30,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(30,150,130,30,20,20);
                if(Game.skinInteger==0){
                g.drawString("Yellow Skin", 40, 170);}
                if(Game.skinInteger==1){
                g.drawString("White Skin", 40, 170);}
                if(Game.skinInteger==2){
                g.drawString("Arab Skin", 40, 170);}
                if(Game.skinInteger==3){
                g.drawString("Brown Skin", 40, 170);}
                if(Game.skinInteger==4){
                g.drawString("Black Skin", 40, 170);}
                
                
                
                g.setColor(Game.ArmyBlue);
                g.fillRoundRect(30,250,130,30,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(30,250,130,30,20,20);
                if(Game.hairInteger==0){
                g.drawString("Gray Hair", 40, 270);}
                if(Game.hairInteger==1){
                g.drawString("Black Hair", 40, 270);}
                if(Game.hairInteger==2){
                g.drawString("White Hair", 40, 270);}
                if(Game.hairInteger==3){
                g.drawString("Brown Hair", 40, 270);}
                if(Game.hairInteger==4){
                g.drawString("Blonde Hair", 40, 270);}
                
                
                g.setColor(Game.ArmyBlue);
                g.fillRoundRect(30,200,130,30,20,20);
                g.setColor(Color.white);
                g.drawRoundRect(30,200,130,30,20,20);
                if(Game.faceInteger==0){
                g.drawString("Moustache", 40, 220);}
                if(Game.faceInteger==1){
                g.drawString("Lincoln Beard", 40, 220);}
                if(Game.faceInteger==2){
                g.drawString("Islamic Beard", 40, 220);}
                if(Game.faceInteger==3){
                g.drawString("Motorbiker Beard", 40, 220);}
                if(Game.faceInteger==4){
                g.drawString("Shaggy Style", 40, 220);}
                
                
                
                g.setColor(Color.red);
                
                if(Game.customOutfit==true){
                    g.drawString("Custom",295,20);
                    g.drawString("Outfit",300,40);
                }
                else if(Game.customOutfit==false){
                    if(Game.outfitInteger==0){
                    g.drawString("Outfit One",280,20);}
                    if(Game.outfitInteger==1){
                    g.drawString("Outfit Two",280,20);}
                    if(Game.outfitInteger==2){
                    g.drawString("Outfit Three",275,20);}
                    if(Game.outfitInteger==3){
                    g.drawString("Outfit Four",280,20);}
                    if(Game.outfitInteger==4){
                    g.drawString("Outfit Five",280,20);}
                    if(Game.outfitInteger==5){
                    g.drawString("Outfit Six",280,20);}
                    if(Game.outfitInteger==6){
                    g.drawString("Outfit Seven",270,20);}
                    if(Game.outfitInteger==7){
                    g.drawString("Outfit Eight",280,20);}
                    if(Game.outfitInteger==8){
                    g.drawString("Outfit Nine",280,20);}
                    if(Game.outfitInteger==9){
                    g.drawString("Outfit Ten",280,20);}
                    
                }
                
                
                if(Game.customOutfit==false){
                g.setColor(Game.ArmyBlue);
                g.fillRoundRect(420,-30,220,200,50,50);
                g.setColor(Color.white);
                g.drawRoundRect(420,-30,220,200,50,50);
                
                g.setColor(Game.GreenColor);
                if(Game.outfitInteger==0){
                g.drawRoundRect(430, y1, 200, 20, 10, 10);}
                else if(Game.outfitInteger==1){
                g.drawRoundRect(430, y2, 200, 20, 10, 10);}
                else if(Game.outfitInteger==2){
                g.drawRoundRect(430, y3, 200, 20, 10, 10);}
                else if(Game.outfitInteger==3){
                g.drawRoundRect(430, y4, 200, 20, 10, 10);}
                else if(Game.outfitInteger==4){
                g.drawRoundRect(430, y5, 200, 20, 10, 10);}
                else if(Game.outfitInteger==5){
                g.drawRoundRect(430, y6, 200, 20, 10, 10);}
                else if(Game.outfitInteger==6){
                g.drawRoundRect(430, y7, 200, 20, 10, 10);}
                else if(Game.outfitInteger==7){
                g.drawRoundRect(430, y8, 200, 20, 10, 10);}
                else if(Game.outfitInteger==8){
                g.drawRoundRect(430, y9, 200, 20, 10, 10);}
                else if(Game.outfitInteger==9){
                g.drawRoundRect(430, y10, 200, 20, 10, 10);}
                
                
                
                g.setColor(Color.white);
                g.drawString("Outfit One", 435, ys1);
                g.drawString("Outfit Two", 435, ys2);
                g.drawString("Outfit Three", 435, ys3);
                g.drawString("Outfit Four", 435, ys4);
                g.drawString("Outfit Five", 435, ys5);
                g.drawString("Outfit Six", 435, ys6);
                if(y7<=127){
                g.drawString("Outfit Seven", 435, ys7);}
                if(y8<=127){
                g.drawString("Outfit Eight", 435, ys8);}
                if(y9<=127){
                g.drawString("Outfit Nine", 435, ys9);}
                if(y10<=127){
                g.drawString("Outfit Ten", 435, ys10);}
                
                }
                
                
                
                
                g.setColor(Color.white);
                g.drawString("Username ",10,20);
                g.drawString("Maximum Fall " + (int)Game.savedScore,10,40);
                g.drawString("Total Fall " + (int)Game.fallenTotal,10,60);
                g.drawString("Impalers Hit " + Game.impalersHit,10,80);
                g.drawString("Coins Picked " + Game.coinsPicked,10,100);
                g.drawString("User Age " + Game.userAge,10,120);
                
                
                if(Game.customOutfit==true){
                
                
                
                g.setFont(Game.LogoFont);
                g.setColor(Color.blue);
                g.fillOval(180,(int)Game.HEIGHT/2-40,60,60);
                g.setColor(Color.yellow);
                g.drawOval(180,(int)Game.HEIGHT/2-40,60,60);
                g.drawString("<",195,(int)Game.HEIGHT/2+10);
                
                
                
                g.setColor(Color.blue);
                g.fillOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2-40,60,60);
                g.setColor(Color.yellow);
                g.drawOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2-40,60,60);
                g.drawString(">",(int)Game.WIDTH-230,(int)Game.HEIGHT/2+10);
                
                
                
                
                
                g.setColor(Color.blue);
                g.fillOval(180,(int)Game.HEIGHT/2+30,60,60);
                g.setColor(Color.yellow);
                g.drawOval(180,(int)Game.HEIGHT/2+30,60,60);
                g.drawString("<",195,(int)Game.HEIGHT/2+80);
                
                
                
                g.setColor(Color.blue);
                g.fillOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2+30,60,60);
                g.setColor(Color.yellow);
                g.drawOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2+30,60,60);
                g.drawString(">",(int)Game.WIDTH-230,(int)Game.HEIGHT/2+80);
                
                
                g.setColor(Color.blue);
                g.fillOval(180,(int)Game.HEIGHT/2+100,60,60);
                g.setColor(Color.yellow);
                g.drawOval(180,(int)Game.HEIGHT/2+100,60,60);
                g.drawString("<",195,(int)Game.HEIGHT/2+150);
                
                
                
                g.setColor(Color.blue);
                g.fillOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2+100,60,60);
                g.setColor(Color.yellow);
                g.drawOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2+100,60,60);
                g.drawString(">",(int)Game.WIDTH-230,(int)Game.HEIGHT/2+150);
                
                }
                
                else if(Game.customOutfit==false){
                    g.setFont(Game.LogoFont);
                  g.setColor(Color.blue);
                g.fillOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2+30,60,60);
                g.setColor(Color.yellow);
                g.drawOval((int)Game.WIDTH-250,(int)Game.HEIGHT/2+30,60,60);
                g.drawString(">",(int)Game.WIDTH-230,(int)Game.HEIGHT/2+80);
                
                
                g.setColor(Color.blue);
                g.fillOval(180,(int)Game.HEIGHT/2+30,60,60);
                g.setColor(Color.yellow);
                g.drawOval(180,(int)Game.HEIGHT/2+30,60,60);
                g.drawString("<",195,(int)Game.HEIGHT/2+80);  
                }
                
                g.setFont(Game.MenuFont);
                g.setColor(Color.red);
                g.fillRoundRect((int)Game.WIDTH/2-100,(int)Game.HEIGHT-70,200,100,30,30);
                g.setColor(Color.yellow);
                g.drawRoundRect((int)Game.WIDTH/2-100,(int)Game.HEIGHT-70,200,100,30,30);
                g.drawString("Back",(int)Game.WIDTH/2-40,(int)Game.HEIGHT-40);
            
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
