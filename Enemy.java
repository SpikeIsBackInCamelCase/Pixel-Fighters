public class Enemy {
    //FEAST FOR BEASTS NOT FINISHED YET IN FILE, DO NOT PUSH
    // HEAVY WIP
    public double enemyId, maxHp, hp, speed, range, defense, damageTaken, damageDealt, level, debuffType,
            debuffMagnitude, power, lifesteal;
    public int movement, fearmonger;//maybe move fearmonger here
    public static int numberOfScares;
    private String name, enemyType, bloaterType, message;
    private boolean isWounded = false, enraged = false, isCrippled = false;
    public Ticker ticker;
    private Champion mortalEnemy, primaryEnemy, secondaryEnemy, tertiaryEnemy;

        public Enemy(int subclass, int enemyId, double lvl) {
        level = lvl;
        switch (subclass) {
            case 1:
                switch (enemyId) {
                    case 1:
                        hp = this.stat(51, 10);
                        maxHp = this.stat(75, 10);
                        speed = 69;
                        range = 0;
                        defense = this.stat(5, 10);
                        power = this.stat(10, 10);
                        name = "Logan Shmogan";
                        break;
                    case 2:
                        hp = this.stat(80, 10);
                        maxHp = this.stat(101, 10);
                        speed = this.stat(5, 10);
                        range = 0;
                        defense = this.stat(16, 10);
                        power = this.stat(23, 10);
                        name = "Da";
                        enemyType = 68+"";
                        break;
                    case 3:
                        hp = this.stat(70, 10);
                        maxHp = this.stat(85, 10);
                        speed = this.stat(20, 10);
                        range = 0;
                        defense = this.stat(5, 10);
                        power = this.stat(60, 10);
                        name = "Wayne";
                        enemyType = 18+"";
                        break;
                    case 4:
                        hp = this.stat(65, 10);
                        maxHp = this.stat(90, 10);
                        speed = this.stat(25, 10);
                        range = 0;
                        defense = this.stat(10, 10);
                        power = this.stat(30, 10);
                        name = "God's Gift To Men";
                        break;
                    case 5:
                        hp = this.stat(60, 10);
                        maxHp = this.stat(80, 10);
                        speed = this.stat(30, 10);
                        range = 0;
                        defense = this.stat(8, 10);
                        power = this.stat(35, 10);
                        name = "God's Gift To Women";
                        break;
                    case 6:
                        hp = this.stat(75, 10);
                        maxHp = this.stat(95, 10);
                        speed = this.stat(15, 10);
                        range = 0;
                        defense = this.stat(12, 10);
                        power = this.stat(45, 10);
                        name = "PRINCE JB";
                        break;
                    
                    

                }
                break;
            case 2:
                switch (enemyId) {
                    // Empty switch for subclass 2
                }
                break;
            case 3:
                switch (enemyId) {
                    // Empty switch for subclass 3
                }
                break;
            case 4:
                switch (enemyId) {
                    // Empty switch for subclass 4
                }
                break;
            case 5:
                switch (enemyId) {
                    // Empty switch for subclass 5
                }
                break;
            case 6:
                switch (enemyId) {
                    // Empty switch for subclass 6
                }
                break;
            case 7:
                switch (enemyId) {
                    case 1:// Gluttony
                        hp = this.stat(666, 50);
                        maxHp = this.stat(666, 70);
                        speed = this.stat(78, 30);
                        if (enraged) {
                            range = this.stat(5, 2);
                        } else {
                            range = 0;
                        }
                        defense = this.stat(70, 100);
                        power = this.stat(100, 10);
                        movement = 4;
                        name = "Beelzebub";
                        enemyType = "demon monster ruler ";
                        break;
                    case 2:// Pride
                        hp = this.stat(500, 50);
                        maxHp = this.stat(500, 70);
                        speed = this.stat(60, 30);
                        if (enraged) {
                            range = this.stat(60, 666);
                        } else {
                            range = this.stat(60, 100);
                        }
                        defense = this.stat(60, 100);
                        power = this.stat(100, 10);
                        movement = 4;
                        name = "Lucifer";
                        enemyType = "spellslinger demon ";
                        break;
                    case 3:// Wrath
                        hp = this.stat(450, 50);
                        maxHp = this.stat(450, 70);
                        speed = this.stat(78, 30);
                        if (enraged) {
                            range = this.stat(5, 2);
                        } else {
                            range = 0;
                        }
                        defense = this.stat(70, 100);
                        power = this.stat(666, 10);
                        movement = 3;
                        name = "Satan";
                        enemyType = "spellcaster defender demon ";
                        bloaterType = 7 + "-ALL" + 20;
                        break;
                    case 4:// Envy
                        hp = this.stat(400, 50);
                        maxHp = this.stat(400, 70);
                        speed = this.stat(80, 30);
                        if (enraged) {
                            range = this.stat(5, 2);
                        } else {
                            range = 0;
                        }
                        defense = this.stat(80, 100);
                        power = this.stat(150, 10);
                        movement = 5;
                        name = "Leviathan";
                        enemyType = "striker demon monster ";
                        break;
                    case 5:// Lust
                        hp = this.stat(200, 50);
                        maxHp = this.stat(500, 70);
                        speed = this.stat(15, 30);
                        range = 25;
                        defense = 0;
                        power = this.stat(20, 45);
                        movement = 1;
                        name = "Asmodeus";
                        enemyType = "spellslinger spellcaster demon ";
                    case 6:// Greed
                        hp = this.stat(300, 50);
                        maxHp = this.stat(475, 70);
                        speed = 0;
                        range = 54781901;
                        defense = this.stat(70, 100);
                        power = this.stat(666, 10);
                        movement = 0;
                        name = "Mammon";
                        enemyType = "demon ";
                        break;
                    case 7:// Sloth
                        hp = this.stat(600, 68);
                        maxHp = this.stat(900, 68);
                        speed = 0;
                        range = this.stat(200, 89);
                        defense = this.stat(50, 20);
                        power = this.stat(20, 10);
                        movement = 1;
                        name = "Blephegor";
                        enemyType = "bender spellslinger defender demon ";
                    case 8:// The Fliers
                        hp = this.stat(66, 50);
                        maxHp = this.stat(200, 70);
                        speed = this.stat(100, 30);
                        if (enraged) {
                            range = this.stat(5, 2);
                        } else {
                            range = 0;
                        }
                        defense = 0;
                        power = this.stat(10, 10);
                        movement = 4;
                        name = "Beelzebub's Flying One";
                        enemyType = 78 + "demon monster ";
                    case 9:// Basic Demonic Minions
                }
                break;
            case 8:
                switch (enemyId) {// Beasts
                    case 1:// Basic Wyrm
                        hp = this.stat(200, 10);
                        maxHp = this.stat(220, 10);
                        speed = this.stat(20, 10);
                        range = 0;
                        defense = this.stat(15, 10);
                        power = this.stat(40, 10);
                        lifesteal = this.stat(10, power/10);
                        name = "Basic Wyrm";
                        fearmonger = 3;
                        break;
                    case 2://Chxrger
                        hp = this.stat(180, 10);
                        maxHp = this.stat(200, 10);
                        speed = this.stat(30, 10);
                        range = 0;
                        defense = this.stat(10, 10);
                        power = this.stat(35, 10);
                        lifesteal = power;
                        name = "Chxrger";
                        fearmonger = 2;
                        break;
                    case 3://Hack slash
                        hp = this.stat(250, 10);
                        maxHp = this.stat(270, 10);
                        speed = this.stat(15, 10);
                        range = 0;
                        defense = this.stat(20, 10);
                        power = this.stat(45, 10);
                        lifesteal = this.stat(20, power/20);
                        name = "Hack Slash";
                        fearmonger = 3;
                        break;
                    case 4://Lugger
                        hp = this.stat(220, 10);
                        maxHp = this.stat(240, 10);
                        speed = this.stat(25, 10);
                        range = 0;
                        defense = this.stat(18, 10);
                        power = this.stat(38, 10);
                        name = "Lugger";
                        fearmonger = 2;
                        break;
                    case 5://Bloodshot
                        hp = this.stat(240, 10);
                        maxHp = this.stat(260, 10);
                        speed = this.stat(18, 10);
                        range = 0;
                        movement = 4;
                        defense = this.stat(22, 10);
                        power = this.stat(42, 10);
                        name = "Bloodshot";
                        fearmonger = 5;
                        break;
                }
                break;
            case 9:
                switch (enemyId) {
                    case 1:
                        hp = this.stat(75, 50);
                        maxHp = this.stat(100, 70);
                        speed = 0;
                        range = this.stat(20, 100);
                        defense = this.stat(70, 100);
                        power = this.stat(100, 10);
                        movement = 0;
                        name = "Demonic Summoner";
                        enemyType = "spellslinger spellcaster ruler ";
                        bloaterType = 7 + "~" + 1;
                        break;
                }
                break;
            case 10:// regular bosses
                switch (enemyId) {
                    case 1:
                        hp = this.stat(300, 10);
                        maxHp = this.stat(320, 10);
                        speed = this.stat(10, 10);
                        if (enraged) {
                            range = this.stat(150, 200);
                        } else {
                            this.stat(30, 45);
                        }
                        defense = this.stat(200, 10);
                        power = this.stat(75, 10);
                        name = "Kozak, Destroyer of Worlds";
                        movement = 8;
                        // note to self, print obscene comments from time to time, make them as out of
                        // pocket as possible
                        // intelligence mechanic
                        break;
                    case 2:
                        hp = this.stat(142, 10);
                        maxHp = this.stat(187, 10);
                        speed = this.stat(90, 5);
                        range = this.stat(25, 5);
                        defense = this.stat(20, 10);
                        power = this.stat(150, 5);
                        movement = 6;
                        name = "Rose, The Swift Assassin";
                        break;// #EvslinIsTriggeredXD
                    case 3:
                        hp = this.stat(260, 10);
                        maxHp = this.stat(280, 10);
                        speed = this.stat(15, 10); // Average speed
                        range = this.stat(30, 45);
                        defense = this.stat(150, 10); // Average defense
                        power = this.stat(30, 10); // Low power since main strength is debuffs
                        movement = 1;
                        name = "Jeremy, the mad chemist";
                        break;
                }
                break;
            default:
                throw new CustomException("VALUE OUT OF RANGE(subclass)");
        }
        //lifesteal = (!(lifesteal > 0)) ? 0 : lifesteal;
        initializeFearStrikeAbility(0);
    }

    public Enemy(String id, int lvl) {
        // ifthan
    }

    public Enemy(double debuffType, double debuffMagnitude) {
        debuffType = this.debuffType;
        debuffMagnitude = this.debuffMagnitude;
    }

    public static void spawn(int enemyType, int enemyId, int lvl, Ticker ticker) {
        ticker.addEntity(new GameEntity(new Enemy(enemyType, enemyId, lvl)));
    }

    public static void spawn(String id, int lvl, Ticker ticker) {
        ticker.addEntity(new GameEntity(new Enemy(id, lvl)));
    }





    // POWERCREEP RESITOR MECHANIC
    public double stat(double baseAttribute, double levelMultiplierPercent) {
        baseAttribute *= (1 + .01 * this.level * levelMultiplierPercent);
        return baseAttribute;
    }

    public static void initializePassiveFearMechanic(){
        numberOfScares = (numberOfScares > 0) ? numberOfScares : 0;
    }

    public void initializeFearStrikeAbility(int lowestPoint){
        fearmonger = (fearmonger>=lowestPoint) ? fearmonger : lowestPoint;
    }

    public String voicelines() {
        switch (this.getName()) {
            case "Beelzebub":
                switch (NumCalc.rounded()) {
                    case 1:
                        return "Mortal, do you truly believe you can stand against the Prince of Hell?";
                    case 2:
                        return "Countless souls have tried to defy me, all have been consumed.";
                    case 3:
                        return "The air grows thick with your fear. Can you feel it?";
                    case 4:
                        return "Every fly you hear is a whisper of my dominion, echoing my laughter at your feeble attempts.";
                    case 5:
                        return "In the grand tapestry of existence, you're but a mere thread, ready to be cut.";
                    case 6:
                        return "Your world is but a feast for my minions, and you, the main course.";
                    case 7:
                        return "You might have defeated lesser demons, but I am the embodiment of despair itself!";
                    case 8:
                        return "With every passing second, your hope withers and your strength fades.";
                    case 9:
                        return "You're fighting against the inevitable. Embrace the darkness.";
                    case 10:
                        return "How does it feel, knowing that even in your greatest moment of triumph, you stand against an eternal force?";
                    default:
                        this.voicelines();
                }
            case "Kozak, Destroyer of Worlds":
                switch (NumCalc.rounded()) {
                    case 1:
                        return "I've crushed better heroes than you just for fun. You're barely a workout.";
                    case 2:
                        return "Oh, look! Another would-be savior. Haven't had one of those in, what, five minutes?";
                    case 3:
                        return "Your pitiful attempts at heroism? It's like a flea trying to tackle a mountain.";
                    case 4:
                        return "Is that the best you've got? I've seen toddlers put up a better fight.";
                    case 5:
                        return "Come closer, and I'll show you the difference between a real threat and your laughable attempts.";
                    case 6:
                        return "Your confidence is as misplaced as your sense of fashion. Who dressed you, a blind goblin?";
                    case 7:
                        return "Oh, did that hurt? Good. Let me do it again.";
                    case 8:
                        return "How many times do I have to beat you before you get the hint? Persistence isn't always a virtue.";
                    case 9:
                        return "Every time you open your mouth, I'm reminded of why I enjoy crushing 'heroes' like you.";
                    case 10:
                        return "When I'm done with you, they won't even find a memory to mourn.";
                    default:
                        return "Why are you even trying?";
                }

            default:
                return "";
        }
    }


    
    public void deathEffect(int deathType, int subclass, int identificationNumber) {
        switch (deathType) {
            case 1: // summoner
                switch (subclass) {
                    case 1:
                        // brawler
                        // normal
                        break;
                    case 2:
                        // striker
                        // fearless
                        break;
                    case 3:
                        // bender
                        // elemental
                        break;
                    case 4:
                        // spellslinger
                        // enemy support unit, will give enemies buffs
                        break;
                    case 5:
                        // spellcaster
                        // enemy support unit, will give you debuffs
                        break;
                    case 6:
                        // defender
                        // increases defense and health of enemies, as well as reducing damage
                        break;
                    case 7:
                        // demon
                        // powerful unit that can only be summoned
                        break;
                    case 8:
                        // monster
                        // powerful miniboss units
                        break;
                    case 9:
                        // ruler
                        // enemy summoner unit
                        break;
                    case 10:
                        // bloater
                        // enemy units that do something on death
                        break;
                    default:
                        // Handle unknown enemy classes
                        throw new CustomException("INVALID VALUE");
                }
                break;
            case 2:
                // champion damager
                break;
            case 3:
                // champion healer
                break;
            case 4:
                // champion buffer
                break;
            case 5:
                // champion nerfer
                break;
            case 6:
                // enemy damager
                break;
            case 7:
                // enemy healer
                break;
            case 8:
                // enemy buffer
                break;
            case 9:
                // enemy nerfer
                break;
        }
    }

    

    private double rage(Champion target){
        return (target == mortalEnemy) ? power*20 : (target == primaryEnemy) ? power*10 : (target == secondaryEnemy) ? power*5 : (target == tertiaryEnemy) ? power*2.5 : power;
    }

    public void doDamage(Champion target) {
        System.out.println(this.getName() + "'s turn");
        /*RAGE MEDCHANIC*/damageDealt = rage(target);
        target.takeDamage(damageDealt);
        lifesteal = damageDealt*(Champion.fear/Champion.courage*2);
        hp += lifesteal;
        hp = (hp>maxHp) ? maxHp : hp;
    }

    public void takeDamage(double dmg, Champion culprit) {
        mortalEnemy = ((tertiaryEnemy == secondaryEnemy) && (secondaryEnemy == primaryEnemy)) ? culprit : mortalEnemy;
        tertiaryEnemy = secondaryEnemy;
        secondaryEnemy = primaryEnemy;
        primaryEnemy = culprit;
        damageTaken = (this.dodge()) ? 0 : dmg * (dmg / (dmg + defense));
        damageTaken*= (isCrippled) ? 2 : (isWounded) ? 1.5 : 1;
        hp-=damageTaken;
        message = (this.dodge()) ? "This Attack Was Dodged!!!!" : (name + " lost " + damageTaken + " Health Points");
        System.out.println(message);
    }

    public boolean dodge() {
        boolean dodged = false;
        double dodgeChance;

        switch (this.movement) {
            case 0: // stationary
                dodged = false; // Cannot dodge
                break;
            case 1: // normal
                dodged = false; // Normal units do not have special dodge mechanics
                break;
            case 2: // running mounts, fast
                dodged = false; // Running mounts do not have special dodge mechanics
                break;
            case 3: // flying
                dodgeChance = 0.25; // Dodge 1/4 of the time
                dodged = Math.random() < dodgeChance;
                break;
            case 4: // floating
                dodgeChance = 0.50; // Dodge 1/2 of the time
                dodged = Math.random() < dodgeChance;
                break;
            case 5: // diggers
                dodged = false; // Cannot be noticed until the first attack. It implies they don't dodge but
                                // rather remain hidden.
                break;
            case 6: // teleporters
                dodged = !isWounded /* check for other debuffs here */; // Takes damage only if wounded or affected by certain
                                                                        // debuffs.
                break;
            case 7: // flying mounts
                dodgeChance = 0.25; // Same as flying
                dodged = Math.random() < dodgeChance;
                break;
            case 8: // floating mounts
                dodgeChance = 0.50; // Same as floating
                dodged = Math.random() < dodgeChance;
                break;
            case 9: // digging mounts
                dodged = false; // Mechanic is undecided
                break;
            case 10: // teleporting mounts
                dodged = false; // Mechanic is undecided
                break;
            default:
                throw new IllegalArgumentException("Invalid movement type.");
        }

        return dodged;
    }

    public void wound(Champion attacker) {
        switch (name) {
            case "Da", "Wayne":
            attacker.takeDamage((attacker.getPower()));;
            return;
        }
        if (!(isWounded)) {
            System.out.println(this.getName() + " has been wounded by " + attacker.getName());
            System.out.println(this.getName() + " lost " + (hp/4) + " health points!");
            System.out.println(this.getName() + " lost 12.5% max hp!");
            isWounded = true;
            hp -= hp/4;
            maxHp -= maxHp/8;
            switch (movement) {
                case 1:
                    speed -= speed/3;
                    movement = 0;
                    System.out.println(this.getName() + " lost " + (speed/3) + " speed!");
                    break;
                case 3:
                    speed /= 3;
                    movement = 1;
                    System.out.println(this.getName() + " lost " + (2*speed/3) + " speed!");
                    break;
                case 4:
                    speed /= 4;
                    movement = 0;
                    System.out.println(this.getName() + " lost " + (3*speed/4) + " speed!");
                    break;
                default:
                    speed /= 2;
                    movement = 1;
                    System.out.println(this.getName() + " lost " + (speed/2) + " speed!");
                    break;
            }
        } else {
            movement = 0;
            speed = 0;
            isCrippled = true;
            System.out.println(this.getName() + "IS CRIPPLED");
        }
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
    // Getters for int variables

    public int getMovement() {
        return movement;
    }

    // Getter for the private String variable
    public String getName() {
        return name;
    }

    public String getEnemyType() {
        return enemyType;
    }

    @Override
    public String toString() {
        return "Enemy [enemyId=" + enemyId + ", maxHp=" + maxHp + ", hp=" + hp + ", speed=" + speed + ", range=" + range
                + ", defense=" + defense + ", damageTaken=" + damageTaken + ", damageDealt=" + damageDealt + ", level="
                + level + ", power=" + power + ", movement=" + movement + ", name=" + name + ", enemyType=" + enemyType
                + ", isWounded=" + isWounded + ", bloaterType=" + bloaterType + ", enraged=" + enraged + "]";
    }

}

class Ghost extends Enemy {
    Ghost(double debuffType, double debuffMagnitude) {
        super(debuffType, debuffMagnitude);
        debuffType = this.debuffType;
        debuffMagnitude = this.debuffMagnitude;
    }

}
