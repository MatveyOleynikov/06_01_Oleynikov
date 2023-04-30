package test.Nature;

import Model.Insect;
import Model.Game;
import org.junit.Assert;
import org.junit.Test;

public class testInsectsEmergeFromSpiderWeb {
    @Test
    public void waitInsectEmerge(){

        Game game = new Game();

        for (int row = 0; row < game.nature().spiderWeb().height(); ++row){
            for (int col = 0; col < game.nature().spiderWeb().width(); ++col){
                Assert.assertFalse(game.nature().spiderWeb().zone(row, col).getArthropod() instanceof Insect);
            }
        }

        int save_row = -1, save_col = -1;
        while (save_row == -1){
            game.nature().insectsGetCaughtInSpiderWeb();

            for (int row = 0; row < game.nature().spiderWeb().height(); ++row){
                for (int col = 0; col < game.nature().spiderWeb().width(); ++col){
                    if (game.nature().spiderWeb().zone(row, col).getArthropod() instanceof Insect){
                        save_row = row;
                        save_col = col;
                    }
                }
            }
        }

        while (game.nature().spiderWeb().zone(save_row, save_col).getArthropod() instanceof Insect){
            game.nature().insectsEmergeFromSpiderWeb();
        }
    }
}

