package test.Nature;

import Model.Nature;
import Model.SmartSpider;
import Model.Spider;
import Model.Game;
import org.junit.Assert;
import org.junit.Test;

public class testDeleteEnemySpider {
    @Test
    public void deleteSpider() {
        Game game = new Game();

        Assert.assertNotNull(game.nature().enemies().get(0));

        SmartSpider smartSpider = game.nature().enemies().get(0);

        game.nature().deleteEnemySpider(smartSpider);

        Assert.assertFalse(game.nature().enemies().contains(smartSpider));
    }
}
