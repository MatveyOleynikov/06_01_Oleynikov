package tests.Game;

import Model.*;
import org.junit.Assert;
import org.junit.Test;

public class testRunSpidersMoves {
    @Test
    public void north(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        game.runSpidersMoves(Direction.north());

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row - 1, col));
    }


    @Test
    public void south(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        game.runSpidersMoves(Direction.south());

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row + 1, col));
    }

    @Test
    public void west(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        game.runSpidersMoves(Direction.west());

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row, col - 1));
    }


    @Test
    public void east(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        game.runSpidersMoves(Direction.east());

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row, col + 1));
    }

    @Test
    public void waitMoveSpiderEnemy(){
        Game game = new Game();

        SmartSpider spider = game.nature().enemies().get(0);

        Zone zone = spider.zone();

        while (zone == spider.zone()){
            game.runSpidersMoves(Direction.north());
        }
    }

    @Test
    public void waitDeleteSpiderEnemy(){
        Game game = new Game();

        SmartSpider spider = game.nature().enemies().get(0);

        Zone zone = spider.zone();

        while (spider.zone() != null){
            game.runSpidersMoves(Direction.north());
        }
    }
}
