package Model;

import View.SpiderWebWidget;
import event.InsectActionListener;
import event.SpiderActionEvent;
import event.SpiderActionListener;

import java.util.ArrayList;
import java.util.Random;

/**
 * Паук
 */
public class Spider extends Arthropod{
    /**
     * контроллер паука
     */
    private SpiderActionListener spiderController;

    /**
     * Установить контроллер паука {@link Spider#spiderController}
     * @param spiderController контроллер паука
     */
    public void setSpiderController(SpiderActionListener spiderController){
        this.spiderController = spiderController;
    }

    /**
     * начальное здоровье паука
     */
    static final private int beginHealthPoints = 30;

    /**
     * количество очков здоровья, необходимое для совершения хода
     */
    static final private int healthPointsForMove = 1;

    /**
     * очки здоровья
     */
    private int _healthPoints;

    /**
     * Получить очки здоровья {@link Spider#_healthPoints}.
     * @return очки здоровья.
     */
    public int healthPoints(){
        return _healthPoints;
    }

    /**
     * Увеличить количество очков здоровья паука
     * @param points количество очков здоровья, на которое надо увеличить
     */
    public void increaseHealthPoints(int points){
        if (_healthPoints + points <= 0){
            _healthPoints = 0;
        }   else{
            _healthPoints += points;
        }
    }

    /**
     * Живой ли паук
     * @return состояние паука
     */
    public boolean isAlive(){
        return _healthPoints > 0;
    }

    /**
     * паутина
     */
    protected final SpiderWeb _spiderWeb;

    /**
     * Конструктор
     * @param spiderWeb паутина
     */
    public Spider(SpiderWeb spiderWeb){
        _healthPoints = beginHealthPoints;
        _spiderWeb = spiderWeb;
    }

    /**
     * Поедание насекомого
     * @param insect насекомое
     */
    private void eat(Insect insect){
        int sizeInsect = insect.size();
        insect.die();
        increaseHealthPoints(sizeInsect);
    }

    /**
     * Попытка перемещение по направлению
     * @param direct направление
     */
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
            if (newZone.getArthropod() instanceof Wasp){
                ((Wasp) newZone.getArthropod()).probableBite(this);

                if (!isAlive()){
                    return;
                }
            }
            if (newZone.getArthropod() instanceof Grasshopper){
                ((Grasshopper) newZone.getArthropod()).probableJumpNeighboringZoneWithoutArthropod();
            }

            if (newZone.getArthropod() instanceof Insect) {
                eat((Insect) newZone.getArthropod());
            }
        }

        curZone.extractArthropod();
        newZone.putArthropod(this);
        increaseHealthPoints(-healthPointsForMove);

        if (isAlive()){
            if (spiderController != null) {
                spiderController.SpiderMoved(new SpiderActionEvent(spiderController, this, curZone, newZone));
            }
        }   else{
            if (spiderController != null) {
                spiderController.SpiderDied(new SpiderActionEvent(spiderController, this, curZone));
            }
        }
    }

    /**
     * Преобразование к строке
     * @return строка
     */
    @Override
    public String toString() {

        String msg;
        msg = "S(" + healthPoints() + ")";

        return msg;
    }
}