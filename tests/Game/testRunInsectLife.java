package tests.Game;

import Model.Game;
import Model.Insect;
import Model.Spider;
import org.junit.Assert;
import org.junit.Test;

public class testRunInsectLife {
    @Test
    public void waitAppearance(){
        Game game = new Game();

        while (true){
            game.runInsectLife();
            for (int row = 0; row < game.spiderWeb().height(); ++row){
                for (int col = 0; col < game.spiderWeb().width(); ++col){
                    if (game.spiderWeb().zone(row, col).getArthropod() instanceof Insect){
                        return;
                    }
                }
            }
        }
    }


    @Test
    public void waitDisappearance(){
        Game game = new Game();

        Insect insect = null;

        while (insect == null){
            game.runInsectLife();
            for (int row = 0; row < game.spiderWeb().height(); ++row){
                for (int col = 0; col < game.spiderWeb().width(); ++col){
                    if (game.spiderWeb().zone(row, col).getArthropod() instanceof Insect){
                        insect = (Insect) game.spiderWeb().zone(row, col).getArthropod();
                    }
                }
            }
        }

        while (insect.zone() != null){
            game.runInsectLife();
        }
    }
}
