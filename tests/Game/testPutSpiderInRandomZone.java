package tests.Game;

import Model.Game;
import Model.Spider;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testPutSpiderInRandomZone {
    @Test
    public void putZone(){
        Game game = new Game();

        Spider spider = new Spider(game.spiderWeb());

        game.putSpiderInRandomZone(spider);

        for (int row = 0; row < game.spiderWeb().height(); ++row){
            for (int col = 0; col < game.spiderWeb().width(); ++col){
                if (game.spiderWeb().zone(row, col).getArthropod() == spider){
                    return;
                }
            }
        }

        Assert.assertTrue(false);
    }

    @Test
    public void checkProbably(){
        Game game = new Game();

        Spider spider = new Spider(game.spiderWeb());

        ArrayList<ArrayList<Integer>> countAppear = new ArrayList<>();

        for (int row = 0; row < game.spiderWeb().height(); ++row) {
            countAppear.add(new ArrayList<>());
            for (int col = 0; col < game.spiderWeb().width(); ++col) {
                countAppear.get(row).add(0);
            }
        }

        int countTests = 1000000;

        for (int i = 0; i < countTests; ++i){
            game.putSpiderInRandomZone(spider);
            for (int row = 0; row < game.spiderWeb().height(); ++row){
                for (int col = 0; col < game.spiderWeb().width(); ++col){
                    if (game.spiderWeb().zone(row, col).getArthropod() == spider){
                        countAppear.get(row).set(col, countAppear.get(row).get(col) + 1);
                    }
                }
            }
            spider.zone().extractArthropod();
        }

        int countFreeZones = 0;

        for (int row = 0; row < game.spiderWeb().height(); ++row){
            for (int col = 0; col < game.spiderWeb().width(); ++col){
                if (game.spiderWeb().zone(row, col).getArthropod() == null){
                    ++countFreeZones;
                }
            }
        }

        for (int row = 0; row < game.spiderWeb().height(); ++row){
            for (int col = 0; col < game.spiderWeb().width(); ++col){
                if (game.spiderWeb().zone(row, col).getArthropod() == null){
                    double probablyExpect = 1.0 / countFreeZones;
                    double probablyActual = (double) countAppear.get(row).get(col) / (double) countTests;
                    Assert.assertEquals(probablyExpect, probablyActual, 0.02);
                }
            }
        }
    }
}
