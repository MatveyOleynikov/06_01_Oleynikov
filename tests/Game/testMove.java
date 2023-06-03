package tests.Game;

import Model.*;
import org.junit.Assert;
import org.junit.Test;

public class testMove {
    @Test
    public void north(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();
        try {
            game.move(Direction.north());
        }   catch (IllegalArgumentException exception){}

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row - 1, col));
    }


    @Test
    public void south(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        try {
            game.move(Direction.south());
        }   catch (IllegalArgumentException exception){}

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row + 1, col));
    }

    @Test
    public void west(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        try {
            game.move(Direction.west());
        }   catch (IllegalArgumentException exception){}

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row, col - 1));
    }


    @Test
    public void east(){
        Game game = new Game();

        Spider spider = game.nature().player();

        Zone zone = spider.zone();

        int row = zone.row();
        int col = zone.col();

        try {
            game.move(Direction.east());
        }   catch (IllegalArgumentException exception){}

        Assert.assertTrue(spider.zone() == game.spiderWeb().zone(row, col) || spider.zone() == game.spiderWeb().zone(row, col + 1));
    }

    @Test
    public void waitMoveSpiderEnemy(){
        Game game = new Game();

        SmartSpider spider = game.nature().enemies().get(0);

        Zone zone = spider.zone();

        while (zone == spider.zone()){
            try {
                game.move(Direction.randomDirection());
            }   catch (IllegalArgumentException exception){}
        }
    }

    @Test
    public void waitDeleteSpiderEnemy(){
        Game game = new Game();

        SmartSpider spider = game.nature().enemies().get(0);

        Zone zone = spider.zone();

        while (spider.zone() != null){
            try {
                game.move(Direction.randomDirection());
                spider.increaseHealthPoints(-spider.getPositiveChange());
            }   catch (IllegalArgumentException exception){}
        }
    }
}
