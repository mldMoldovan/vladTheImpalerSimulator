
package impalingsimulator;





public class SaveData implements java.io.Serializable{
    
    public String Data_Username;
    
 
    
    public int Data_Coins;
    
    public double Data_MaxScore;
    
    public double Data_fallenTotal;
    
    public int Data_impalersHit;
    
    public int Data_coinsPicked;
    
    public int Data_skinOption;
    
    public int Data_shirtOption;
    
    public int Data_pantsOption;
    
    public int Data_userAge;
    
    public boolean Data_firstLaunch;
    
    
    
    
    public SaveData(int Data_Coins, double Data_MaxScore,double Data_fallenTotal,int Data_impalersHit,int Data_coinsPicked,int Data_skinOption, int Data_shirtOption,int Data_pantsOption,int Data_userAge,boolean Data_firstLaunch){
        //this.Data_Username = Data_Username;
        
        this.Data_Coins = Data_Coins;
        this.Data_MaxScore = Data_MaxScore;
        this.Data_fallenTotal = Data_fallenTotal;
        this.Data_impalersHit = Data_impalersHit;
        this.Data_coinsPicked = Data_coinsPicked;
        this.Data_skinOption = Data_skinOption;
        this.Data_shirtOption = Data_shirtOption;
        this.Data_pantsOption = Data_pantsOption;
        this.Data_userAge = Data_userAge;
        this.Data_firstLaunch = Data_firstLaunch;
        
        //this.Data_boolBladder = Data_boolBladder;
        //this.Data_boolTutorials = Data_boolTutorials;
      
    }
    
}

