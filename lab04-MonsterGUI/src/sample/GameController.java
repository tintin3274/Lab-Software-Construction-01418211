package sample;

public class GameController {
    private Monster m1, m2;
    private int turn; // -1 , 1
    private int round;

    public GameController(Monster m1, Monster m2){
        this.m1 = m1;
        this.m2 = m2;
        this.turn = 1;
        this.round = 1;
    }

    public void attackState(){
        if(turn == 1){
            m2.attacked(m1.getAtk());
            if(m2.getCoolDown()){
                if(m2.getCoolDownCount() == 0){
                    m2.reCoolDown();
                    round++;
                }
                else if(m2.getCoolDownCount() == 1){
                    m2.reCoolDown();
                    changeTurn();
                }
            }
            else{
                changeTurn();
            }
        }

        else if(turn == -1){
            m1.attacked(m2.getAtk());
            if(m1.getCoolDown()){
                if(m1.getCoolDownCount() == 0){
                    m1.reCoolDown();
                    round++;
                }
                else if(m1.getCoolDownCount() == 1){
                    m1.reCoolDown();
                    changeTurn();
                    round++;
                }
            }
            else{
                changeTurn();
                round++;
            }
        }
    }

    public void healState(int healingPoint) {
        if (turn == 1) {
            m1.recovery(healingPoint);
            if (m2.getCoolDown()) {
                if (m2.getCoolDownCount() == 0) {
                    m1.reCoolDown();
                    m2.reCoolDown();
                    m1.reCoolDown();
                    m2.reCoolDown();
                    round++;
                    changeTurn();
                } else if (m2.getCoolDownCount() == 1) {
                    m2.reCoolDown();
                    changeTurn();
                }
            }
            else{
                changeTurn();
            }
        }
        else if (turn == -1) {
            m2.recovery(healingPoint);
            if (m1.getCoolDown()) {
                if (m1.getCoolDownCount() == 0) {
                    round++;
                    m1.reCoolDown();
                    m2.reCoolDown();
                    round++;
                    m1.reCoolDown();
                    m2.reCoolDown();
                    changeTurn();
                } else if (m1.getCoolDownCount() == 1) {
                    m1.reCoolDown();
                    changeTurn();
                    round++;
                }
            }
            else{
                changeTurn();
                round++;
            }
        }
    }


    public boolean isWin(){
        if (m1.isDead() || m2.isDead()){
            return true;
        }
        return false;
    }
    public Monster getWinMonster(){
        if (m1.getCurrentHp() >= m2.getCurrentHp()){
            return m1;
        }
        return m2;
    }
    private void changeTurn(){
        this.turn *= -1;
    }

    public int getTurn() {
        if (turn == 1){
            return 1;
        }
        return 2;
    }

    public int getRound() {
        return round;
    }
}
