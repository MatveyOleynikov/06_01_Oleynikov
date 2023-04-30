package test.Nature;

import Model.Insect;
import Model.Game;
import org.junit.Assert;
import org.junit.Test;

public class testInsectsGetCaughtInSpiderWeb {
    @Test
    public void waitInsectGetCaught(){
        Game game = new Game();

        for (int row = 0; row < game.nature().spiderWeb().height(); ++row){
            for (int col = 0; col < game.nature().spiderWeb().width(); ++col){
                Assert.assertFalse(game.nature().spiderWeb().zone(row, col).getArthropod() instanceof Insect);
            }
        }

        boolean allNull = true;
        while (allNull){
            game.nature().insectsGetCaughtInSpiderWeb();

            for (int row = 0; row < game.nature().spiderWeb().height(); ++row){
                for (int col = 0; col < game.nature().spiderWeb().width(); ++col){
                    allNull = allNull && game.nature().spiderWeb().zone(row, col).getArthropod() instanceof Insect;
                }
            }
        }
    }
}
