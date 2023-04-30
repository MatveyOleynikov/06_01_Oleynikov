package Model;

import View.SpiderWebWidget;
import event.InsectActionEvent;
import event.InsectActionListener;
import event.SpiderActionListener;

import java.util.ArrayList;

// Природа

public class Nature{
    // ---------------------- Контроллеры -----------------------

    private InsectActionListener insectController;

    public void setInsectController(InsectActionListener insectController) {
        this.insectController = insectController;
    }

    public void setSpiderController(SpiderActionListener spiderController) {
        player.setSpiderController(spiderController);
        for (Spider spider: enemies()){
            spider.setSpiderController(spiderController);
        }
    }

    // ------------------------------- Константы -------------------------------------
    private final int SIZE_OF_SPIDER_WEB = 5;
    private final int NUMBER_OF_SPIDERS = 4;

    // -------------------- Паутина --------------------
    private SpiderWeb _spiderWeb;

    public SpiderWeb spiderWeb(){
        return _spiderWeb;
    }

    // ---------------------- Паук-Игрок ---------------------------

    private final Spider player;

    public Spider player() {
        return player;
    }

    // ---------------------- Пауки-Враги ---------------------------

    private ArrayList<SmartSpider> enemies = new ArrayList();

    public ArrayList<SmartSpider> enemies() {
        return enemies;
    }

    public void deleteEnemySpider(SmartSpider spider) {
        enemies.remove(spider);
        spider.zone().extractArthropod();
    }

    // -------------------- Насекомые ------------------

    public void insectsGetCaughtInSpiderWeb(){
        for (int row = 0; row < _spiderWeb.height(); ++row){
            for (int col = 0; col < _spiderWeb.width(); ++col){
                if (_spiderWeb.zone(row, col).isEmpty()){
                    Zone zn = _spiderWeb.zone(row, col);
                    Insect.probableAppearanceInZone(zn);

                    if (!zn.isEmpty()){
                        InsectActionEvent event = new InsectActionEvent(insectController, (Insect) zn.getArthropod(), zn);
                        insectController.insectAppearance(event);
                    }
                }
            }
        }
    }

    public void insectsEmergeFromSpiderWeb(){
        for (int row = 0; row < _spiderWeb.height(); ++row){
            for (int col = 0; col < _spiderWeb.width(); ++col){
                if (_spiderWeb.zone(row, col).getArthropod() instanceof Insect){
                    Zone zn = _spiderWeb.zone(row, col);
                    Insect insect = (Insect) zn.getArthropod();
                    Insect.probableDisappearance(insect);

                    if (zn.isEmpty()){
                        InsectActionEvent event = new InsectActionEvent(insectController, insect, zn);
                        insectController.insectDisappearance(event);
                    }
                }
            }
        }
    }

    // ---------------------------- Порождение ---------------------

    public Nature() {
        _spiderWeb = new SpiderWeb(SIZE_OF_SPIDER_WEB, SIZE_OF_SPIDER_WEB);

        player = new Spider(_spiderWeb);

        for (int i = 0; i < NUMBER_OF_SPIDERS; ++i){
            enemies.add(new SmartSpider(_spiderWeb));
        }
    }
}