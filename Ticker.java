import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class GameEntity {
    private Champion champion;
    private Enemy enemy;
    private String type; // "Champion" or "Enemy"
    
    // Constructor for Champion
    public GameEntity(Champion champion) {
        this.champion = champion;
        this.type = "Champion";
    }
    
    // Constructor for Enemy
    public GameEntity(Enemy enemy) {
        this.enemy = enemy;
        this.type = "Enemy";
    }

    public String getName() {
        if (type.equals("Champion")) {
            return champion.getName();
        }
        return enemy.getName();
    }

    public int getSpeed() {
        if (type.equals("Champion")) {
            return (int) champion.getSpeed();
        }
        return (int) enemy.getSpeed();
    }

    public int getHp() {
        if (type.equals("Champion")) {
            return (int) champion.getHp();
        }
        return (int) enemy.getHp();
    }

    public String getType() {
        return type;
    }

    public void attack(GameEntity target) {
        if (type.equals("Champion")) {
            champion.doDamage(target.enemy); // Champion attacking an Enemy
        } else {
            enemy.doDamage(target.champion); // Enemy attacking a Champion
            System.out.println(enemy.voicelines());
        }
    }

    public void takeDamage(double damage) {
        if (type.equals("Champion")) {
            champion.takeDamage(damage);
        } else {
            enemy.takeDamage(damage, null);
        }
    }
}

public class Ticker {
    PriorityQueue<GameEntity> queue = new PriorityQueue<>((a, b) -> b.getSpeed() - a.getSpeed());
    PriorityQueue<GameEntity> tempQueue = new PriorityQueue<>((a, b) -> b.getSpeed() - a.getSpeed());
    List<GameEntity> champions = new ArrayList<>();
    List<GameEntity> enemies = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addEntity(GameEntity entity) {
        if (!queue.contains(entity) && !tempQueue.contains(entity)) {
            queue.add(entity);
            if (entity.getType().equals("Champion")) {
                champions.add(entity);
            } else {
                enemies.add(entity);
            }
        }
    }

    public GameEntity getNextEntityToAct() {
        if (queue.isEmpty() && !tempQueue.isEmpty()) {
            queue = tempQueue;
            tempQueue = new PriorityQueue<>((a, b) -> b.getSpeed() - a.getSpeed());
        }
        return queue.isEmpty() ? null : queue.poll();
    }

    private void championTurn(GameEntity champion) {
        System.out.println(champion.getName() + "'s turn. Choose an enemy to attack:");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.println((i + 1) + ". " + enemies.get(i).getName() + " (HP: " + enemies.get(i).getHp() + ")");
        }

        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= enemies.size()) {
            GameEntity target = enemies.get(choice - 1);
            champion.attack(target);
            if (target.getHp() <= 0) {
                System.out.println(target.getName() + " has been defeated!");
                enemies.remove(target);
            }
        } else {
            System.out.println("Invalid choice. You lose your turn.");
        }
    }

    public void combatLoop() {
        while (!champions.isEmpty() && !enemies.isEmpty()) {
            GameEntity currentEntity = getNextEntityToAct();
            
            // Ensure that the current entity is alive
            if (currentEntity == null || currentEntity.getHp() <= 0) continue;
    
            if (currentEntity.getType().equals("Champion")) {
                championTurn(currentEntity);
            } else {
                // Enemies attack the champion with the lowest health.
                GameEntity weakestChampion = champions.stream().filter(c -> c.getHp() > 0) // Filter out dead champions
                    .min((a, b) -> Integer.compare(a.getHp(), b.getHp())).orElse(null);
                if (weakestChampion != null) {
                    currentEntity.attack(weakestChampion);
                    if (weakestChampion.getHp() <= 0) {
                        System.out.println(weakestChampion.getName() + " has been defeated!");
                        champions.remove(weakestChampion);
                    }
                }
            }
            tempQueue.add(currentEntity); // After taking action, the entity goes to the temporary queue
        }
    
        if (champions.isEmpty()) {
            System.out.println("All champions have been defeated!");
        } else {
            System.out.println("All enemies have been defeated!");
        }
    }
    
}
