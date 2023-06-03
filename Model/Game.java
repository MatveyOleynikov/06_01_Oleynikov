package Model;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Игра
 */
public class Game {
    /**
     * Природа
     */
    private final Nature _nature;

    /**
     * Количество ходов
     */
    private int steps = 0;

    /**
     * Получить количество ходов {@link Game#steps}.
     * @return количество ходов.
     */
    public int getSteps(){
        return steps;
    }

    /**
     * Получить природу {@link Game#_nature}.
     * @return природа.
     */
    public Nature nature(){
        return _nature;
    }


    /**
     * Паутина
     */
    private final SpiderWeb _spiderWeb;

    /**
     * Получить паутину {@link Game#_spiderWeb}.
     * @return паутина.
     */
    public SpiderWeb spiderWeb(){
        return _spiderWeb;
    }

    /**
     * Положить паука в случайную зону паутины
     * @param spider паук
     */
    private void putSpiderInRandomZone(Spider spider){
        Random random = new Random();
        Zone zone;
        do{
            zone = _spiderWeb.zone(random.nextInt(_spiderWeb.height()), random.nextInt(_spiderWeb.width()));
        }   while (!zone.isEmpty());
        zone.putArthropod(spider);
    }

    /**
     * Конструктор
     */
    public Game() {
        _nature = new Nature();
        _spiderWeb = _nature.spiderWeb();

        putSpiderInRandomZone(_nature.player());

        for (Spider enemy: _nature.enemies()){
            putSpiderInRandomZone(enemy);
        }
    }

    /**
     * Запустить ходы пауков
     * @param direct направление хода паука игрока
     */
    private void runSpidersMoves(Direction direct){
        Zone newPlayerZone = _spiderWeb.zone(_nature.player().zone(), direct);

        if (newPlayerZone == null || newPlayerZone.getArthropod() instanceof Spider){
            throw new IllegalArgumentException();
        }

        _nature.player().tryMove(direct);

        do {
            ArrayList<SmartSpider> enemies = _nature.enemies();
            for (int i = enemies.size() - 1; i >= 0; --i) {
                enemies.get(i).tryMove(enemies.get(i).determineOptimalDirection());
                if (!enemies.get(i).isAlive()) {
                    _nature.deleteEnemySpider(enemies.get(i));
                }
            }
        } while (_spiderWeb.neighbouringZoneWithoutInsect(newPlayerZone) == null);

        steps++;
    }

    /**
     * Запустить жизнь насекомых
     */
    private void runInsectLife(){
        _nature.insectsGetCaughtInSpiderWeb();
        _nature.insectsEmergeFromSpiderWeb();
    }

    public void move(Direction direct){
        runSpidersMoves(direct);
        runInsectLife();
    }
}
