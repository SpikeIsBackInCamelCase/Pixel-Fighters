public class EnemyGroup {
    public Ticker ticker;
    public EnemyGroup(String input) {
        ticker = new Ticker();
        switch (input.toLowerCase()) {
            case "wasp fight":
                Champion.spawn(7, 0, this.ticker);
                Champion.spawn(7, 0, this.ticker);
                Champion.spawn(7, 0, this.ticker);
                Champion.spawn(4, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Champion.spawn(1, 0, this.ticker);
                Enemy.spawn(7, 1, 0, this.ticker);
                Enemy.spawn(9, 1, 0, this.ticker);
                Enemy.spawn(7, 8, 0, this.ticker);
                Enemy.spawn(7, 8, 0, this.ticker);
                Enemy.spawn(7, 8, 0, this.ticker);
                Enemy.spawn(7, 8, 0, this.ticker);
                ticker.combatLoop();
                break;
            case "let's kill kozak!":
                Champion.spawn(1, 0, this.ticker);
                Champion.spawn(4, 0, this.ticker);
                Champion.spawn(8, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Champion.spawn(3, 0, this.ticker);
                Enemy.spawn(10, 1, 0, this.ticker);
                Enemy.spawn(1, 4, 0, this.ticker);
                Enemy.spawn(1, 5, 0, this.ticker);
                Enemy.spawn(1, 6, 0, this.ticker);
                ticker.combatLoop();
            case "feast for beasts":
                Champion.spawn(1, 0, this.ticker);
                Champion.spawn(1, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(3, 0, this.ticker);
                Champion.spawn(3, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Enemy.spawn(8, 1, 0, this.ticker);
                Enemy.spawn(8, 2, 0, this.ticker);
                Enemy.spawn(8, 3, 0, this.ticker);
                Enemy.spawn(8, 4, 0, this.ticker);
                Enemy.spawn(8, 5, 0, this.ticker);
                ticker.combatLoop();
                break;
            case "rose":
                Champion.spawn(4, 0, this.ticker);
                Champion.spawn(6, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(2, 0, this.ticker);
                Champion.spawn(3, 0, this.ticker);
                Enemy.spawn(10, 2, 0, this.ticker);
                Enemy.spawn(1, 2, 0, this.ticker);
                Enemy.spawn(1, 3, 0, this.ticker);
                ticker.combatLoop();
                break;
            default:
            }
    }
}