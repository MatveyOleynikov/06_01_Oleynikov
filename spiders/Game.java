package Model;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private final Nature _nature;

    public Nature nature(){
        return _nature;
    }

    private final SpiderWeb _spiderWeb;

    public SpiderWeb spiderWeb(){
        return _spiderWeb;
    }

    public void putSpiderInRandomZone(Spider spider){
        Random random = new Random();
        Zone zone = _spiderWeb.zone(random.nextInt(_spiderWeb.height()), random.nextInt(_spiderWeb.width()));
        while (!zone.isEmpty()){
            zone = _spiderWeb.zone(random.nextInt(_spiderWeb.height()), random.nextInt(_spiderWeb.width()));
        }
        zone.putArthropod(spider);
    }

    public Game() {
        _nature = new Nature();
        _spiderWeb = _nature.spiderWeb();

        putSpiderInRandomZone(_nature.player());

        for (Spider enemy: _nature.enemies()){
            putSpiderInRandomZone(enemy);
        }
    }

    public void runSpidersMoves(Direction direct){
        _nature.player().tryMove(direct);
        if (!_nature.player().isAlive()){
            //todo: закончить игру
        }

        ArrayList<SmartSpider> enemies = _nature.enemies();
        for (int i = enemies.size() - 1; i >= 0; --i){
            enemies.get(i).tryMove(enemies.get(i).determineOptimalDirection());
            if (!enemies.get(i).isAlive()){
                _nature.deleteEnemySpider(enemies.get(i));
            }
        }
    }

    public void runInsectLife(){
        _nature.insectsGetCaughtInSpiderWeb();
        _nature.insectsEmergeFromSpiderWeb();
    }
}
