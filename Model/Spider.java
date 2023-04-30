package Model;

import View.SpiderWebWidget;
import event.InsectActionListener;
import event.SpiderActionEvent;
import event.SpiderActionListener;

import java.util.ArrayList;
import java.util.Random;

// Паук
public class Spider extends Arthropod{
    // ------------------------------- Контроллер ------------------------------------
    private SpiderActionListener spiderController;

    public void setSpiderController(SpiderActionListener spiderController){
        this.spiderController = spiderController;
    }

    // ------------------------------- Константы -------------------------------------
    static final private int beginHealthPoints = 30;
    static final private int healthPointsForMove = 1;

    // ------------------------------- Очки здоровья ---------------------------------
    private int _healthPoints;

    public int healthPoints(){
        return _healthPoints;
    }

    private void increaseHealthPoints(int points){
        if (_healthPoints + points <= 0){
            _healthPoints = 0;
        }   else{
            _healthPoints += points;
        }
    }

    public boolean isAlive(){
        return _healthPoints > 0;
    }

    // ----------------------------- Паутина --------------------------------------

    protected final SpiderWeb _spiderWeb;

    // --------------------------- Конструктор ------------------------------------

    public Spider(SpiderWeb spiderWeb){
        _healthPoints = beginHealthPoints;
        _spiderWeb = spiderWeb;
    }

    // ----------------------------- Поедание -------------------------------------

    private void eat(Insect insect){
        int sizeInsect = insect.size();
        insect.die();
        increaseHealthPoints(sizeInsect);
    }

    // --------------------------- Перемещение ------------------------------------

    public void tryMove(Direction direct) {
        Zone newZone = _spiderWeb.zone(zone(), direct);
        if (newZone == null){
            return;
        }

        if (newZone.getArthropod() instanceof Spider){
            return;
        }

        Zone curZone = zone();

        if (newZone.getArthropod() instanceof Insect){
            eat((Insect) newZone.getArthropod());
        }

        curZone.extractArthropod();
        newZone.putArthropod(this);
        increaseHealthPoints(-healthPointsForMove);

        if (isAlive()){
            spiderController.SpiderMoved(new SpiderActionEvent(spiderController, this, curZone, newZone));
        }   else{
            spiderController.SpiderDied(new SpiderActionEvent(spiderController, this, curZone));
        }
    }

    @Override
    public String toString() {

        String msg;
        msg = "S(" + healthPoints() + ")";

        return msg;
    }
}