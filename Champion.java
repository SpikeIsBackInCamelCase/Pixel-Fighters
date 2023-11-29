public class Champion {
    //THIS IS A TEST
    public double maxHp, hp, speed, range, defense, damageTaken, damageDealt, zeal, wrath, level, power, movement;
    public static int fear, courage;
    public int classType, spellID;
    private String name;
    private boolean dodged, specialCase;
    //Support character select constructor
    Champion(int zeal, int wrath, int classType){
    }

    
    // Character select constructor
    Champion(int party, int lvl) {
        classType = party;
        level = lvl;
        this.assignStats(level);
        initializeFear(1);
        initializeCourage(1);
        this.initializeMovement(1);
    }

    public static void spawn(int party, int lvl, Ticker ticker) {
        ticker.addEntity(new GameEntity(new Champion(party, lvl)));
    }

    //POWERCREEP RESISTOR MECHANIC
    public double stat(double baseAttribute, double levelMultiplierPercent){
        baseAttribute *= (1 + .01*this.level*levelMultiplierPercent);
        return baseAttribute;
    }
    public void assignStats(double level) {
        switch (this.classType) {
            case 1: // Crusader
                hp = this.stat(140, 10);
                maxHp = this.stat(145, 10);
                speed = this.stat(40, 10);
                range = 0;
                defense = this.stat(5, 10);
                power = this.stat(30, 10);
                name = "Crusader";
                break;
            case 2: // Scutarius
                hp = this.stat(90, 10);
                maxHp = this.stat(95, 10);
                speed = this.stat(10, 10);
                range = 0;
                defense = this.stat(20, 10);
                power = this.stat(15, 10);
                name = "Scutarius";
                break;
            case 3: // Dimachaerus
                hp = this.stat(100, 10);
                maxHp = this.stat(101, 10);
                speed = this.stat(25, 10);
                range = 0;
                defense = this.stat(1, 10);
                power = this.stat(25, 10);
                name = "Dimachaerus";
                break;
            case 4: // Crossbow Marksman
                hp = this.stat(52, 10);
                maxHp = this.stat(75, 10);
                speed = this.stat(15, 10);
                range = this.stat(20, 10);
                defense = this.stat(3, 10);
                power = this.stat(50, 10);
                name = "Crossbow Marksman";
                break;
            case 5: // Mongol
                hp = this.stat(60, 10);
                maxHp = this.stat(90, 10);
                speed = this.stat(60, 10);
                range = this.stat(7, 10);
                defense = this.stat(0.5, 10);
                power = this.stat(25, 10);
                name = "Mongol";
                break;
            case 6: // Samurai
                hp = this.stat(76, 10);
                maxHp = this.stat(110, 10);
                speed = this.stat(16, 10);
                range = 0;
                defense = this.stat(2, 10);
                power = this.stat(25, 10);
                name = "Samurai";
                break;
            case 7://musketeer
                hp = this.stat(100, 30);
                maxHp = this.stat(100, 45);
                speed = this.stat(12, 20);
                range = this.stat(10, 35);
                defense = this.stat(5, 10);
                power = this.stat(70, 10);
                name = "Musketeer";
                break;
            default:
                this.assignStats(level);
                break;
        }
    }

    public void initializeMovement(int lowestPoint){
        movement = (movement>=lowestPoint) ? movement : lowestPoint;
    }

    public void initializeFear(int lowestPoint){
        fear = (fear>=lowestPoint) ? fear : lowestPoint;
    }

    public void initializeCourage(int lowestPoint){
        courage = (courage>=lowestPoint) ? courage : lowestPoint;
    }
    
    public static void beAfraid(int fearmonger){
        fear = fearmonger;
    }

    public void heal(double healing) {
        this.hp += healing;
        if(this.hp>maxHp){
            this.hp = maxHp;
        }
    }

    

    public void classDmgBuff(Enemy target){
        switch (classType) {
            case 1: // Crusader
                damageDealt = power + (maxHp-hp);
            case 2: // Scutarius
                if(Math.random()<.1){target.wound(this);}
                damageDealt = hp*(power/40)+(defense/10);
                this.defense+=10;
            case 3: // Dimachaerus
                damageDealt = power * 2;
                break;
            case 4: // Crossbow Marksman
                damageDealt = (range/10)*(power/defense);
                range+=5;
            case 6: // Samurai
                if(Math.random()<.05){target.wound(this);}
                movement +=.5;
                damageDealt = (((double)(movement))/2 * power) + power/2;
                break;
            case 7: //musketeer
                if (NumCalc.bin()==1){
                    if (NumCalc.bin()==1){
                        target.wound(this);
                        specialCase = true;
                    } else {
                        damageDealt = power;
                    }
                } else {
                    damageDealt = power*NumCalc.rounded();
                }
            default:
                damageDealt = power;
        }
    }


    public void levelDmgBuff(){
        switch (classType) {
        default:
            damageDealt *= (1 + level/10);
        }
    }

    public void doDamage(Enemy target) {
        this.classDmgBuff(target);
        this.levelDmgBuff();
        if (!specialCase){
            target.takeDamage(damageDealt, this);
            specialCase = false;
        }
        this.heal(damageDealt/(defense+damageDealt));
    }

    public void dodge(double dmg){
        if (classType == 5 ) { // Dodge mechanic for Mongol
            int dodgeDef = (int) defense * (NumCalc.rounded() / 2);
            switch (dodgeDef) {
                case 0:
                    damageTaken = dmg / defense;
                    break;
                default:
                    if ((hp - (dmg / dodgeDef) - 2) > 0) {
                        damageTaken = (dmg / dodgeDef) - 2;
                    } else {
                        System.out.println("This Attack was dodged!");
                        dodged = true;
                    }
                    break; // Add break here
            }
        } else {
            damageTaken = (dmg*(dmg/(dmg+defense)))/((fear*fear)/(courage*(movement/2)));
        }
        hp -= (dodged) ? 0 : damageTaken;
        movement += (dodged) ? 1 : .5;
    }

    public void takeDamage(double dmg) {
        movement += 1;
        this.dodge(dmg);
        System.out.println("Your champion lost " + damageTaken + " Health Points");
    }

    public String rangeReturner() {
        if (range != 0) {
            return "\nRANGE: " + range;
        } else {
            return "THIS IS A MELEE FIGHTER";
        }
    }

    public static void increaseFear(int amountToIncreaseFearBy){
        fear = (fear>=0) ? fear+amountToIncreaseFearBy : amountToIncreaseFearBy;
    }

    // Getters for double variables
    public double getMaxHp() {
        return maxHp;
    }

    public double getHp() {
        return hp;
    }

    public double getSpeed() {
        return speed;
    }

    public double getRange() {
        return range;
    }

    public double getDefense() {
        return defense;
    }

    public double getDamageTaken() {
        return damageTaken;
    }

    public double getDamageDealt() {
        return damageDealt;
    }

    public double getPower() {
        return power;
    }

    public double getMovement() {
        return movement;
    }

    // Getters for int variables

    public int getClassType() {
        return classType;
    }



    public void data() {
        System.out.println("HP: " + hp + "/" + maxHp + " SPEED: " + speed + " ATK: " + power + "\nDFNS: " + defense + rangeReturner());
    }
    @Override
    public String toString() {
        return "Champion [maxHp=" + maxHp + ", hp=" + hp + ", speed=" + speed + ", range=" + range + ", defense="
                + defense + ", damageTaken=" + damageTaken + ", damageDealt=" + damageDealt + ", zeal=" + zeal
                + ", wrath=" + wrath + ", power=" + power + ", movement=" + movement + ", classType=" + classType + "]";
    }
  
    
    // Getter for the private String variable
    public String getName() {
        return name;
    }

}

class Spellbinder extends Champion {
    Spellbinder(int wisdom_level, int power_level, int party) {
        super(wisdom_level, power_level, party);  // Call the constructor of the parent class Champion.
        zeal = wisdom_level;
        wrath = power_level;
        classType = party;
        /*
         * 1: Stronghold
         * 2: necromancer
         * 3: Power
         * 4: Metatron
         * 5: 
         */
    }
    public void fallback(){
                            System.out.println("enter a valid digit");
                    this.castSpell();
    }
    public void castSpell(){
        switch (classType) {
            case 1: //Stronghold
            if (zeal>=3){
                switch (spellID) {
                    case 0:
                    //skip turn
                    break;
                    case 1:
                    //earthquake
                    break;
                    case 2:
                    //weed rush\
                    break;
                    default:
                    this.fallback();
                    break;
                }
                break;
            }else {
                switch (spellID) {
                    case 0:
                    //skip turn
                    break;
                    case 1:
                    //earthquake
                    break;
                    default:
                    this.fallback();
                    break;
                }
            break;
            }
            case 2: //necromancer
            case 3: //power
            case 4: //metatron
        
        
        }
    }


    public double getZeal() {
        return zeal;
    }

    public double getWrath() {
        return wrath;
    }

    public int getSpellID() {
        return spellID;
    }



}