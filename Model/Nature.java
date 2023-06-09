package Model;

import View.SpiderWebWidget;
import event.InsectActionEvent;
import event.InsectActionListener;
import event.SpiderActionListener;

import java.util.ArrayList;

/**
 * Природа
 */
public class Nature{
    /**
     * контроллер насекомого
     */
    private InsectActionListener insectController;

    /**
     * Установить контроллер насекомого {@link Nature#insectController}
     * @param insectController контроллер насекомого.
     */
    public void setInsectController(InsectActionListener insectController) {
        this.insectController = insectController;
    }

    /**
     * Установить контроллер пауков
     * @param spiderController контроллер паука
     */
    public void setSpiderController(SpiderActionListener spiderController) {
        player.setSpiderController(spiderController);
        for (Spider spider: enemies()){
            spider.setSpiderController(spiderController);
        }
    }

    /**
     * размер паутины
     */
    private final int SIZE_OF_SPIDER_WEB = 5;

    /**
     * количество пауков соперников
     */
    private final int NUMBER_OF_SPIDERS = 4;

    /**
     * паутина
     */
    private SpiderWeb _spiderWeb;

    /**
     * Получить паутину {@link Nature#_spiderWeb}.
     * @return паутина.
     */
    public SpiderWeb spiderWeb(){
        return _spiderWeb;
    }

    /**
     * паук-игрок
     */
    private final Spider player;

    /**
     * Получить паука игрока {@link Nature#player}.
     * @return паук игрока.
     */
    public Spider player() {
        return player;
    }

    /**
     * пауки-соперники
     */
    private ArrayList<SmartSpider> enemies = new ArrayList();

    /**
     * Получить пауков соперников {@link Nature#enemies}.
     * @return пауки соперники.
     */
    public ArrayList<SmartSpider> enemies() {
        return enemies;
    }

    /**
     * Удалить паука соперника
     * @param spider паук соперника
     */
    public void deleteEnemySpider(SmartSpider spider) {
        enemies.remove(spider);
        spider.zone().extractArthropod();
    }

    /**
     * Появления насекомых в паутине
     */
    public void insectsGetCaughtInSpiderWeb(){
        for (int row = 0; row < _spiderWeb.height(); ++row){
            for (int col = 0; col < _spiderWeb.width(); ++col){
                if (_spiderWeb.zone(row, col).isEmpty()){
                    Zone zn = _spiderWeb.zone(row, col);
                    Wasp.probableAppearanceInZone(zn, insectController);
                    Grasshopper.probableAppearanceInZone(zn, spiderWeb(), insectController);
                    Fly.probableAppearanceInZone(zn, insectController);
                    Mosquito.probableAppearanceInZone(zn, spiderWeb(), insectController);
                }
            }
        }
    }

    /**
     * Исчезновения насекомых в паутине
     */
    public void insectsEmergeFromSpiderWeb(){
        for (int row = 0; row < _spiderWeb.height(); ++row){
            for (int col = 0; col < _spiderWeb.width(); ++col){
                Arthropod arthropod = _spiderWeb.zone(row, col).getArthropod();
                if (arthropod instanceof Mosquito){
                    ((Mosquito) arthropod).probableDisappearance(spiderWeb());
                }   else if (arthropod instanceof Insect){
                    Zone zn = _spiderWeb.zone(row, col);
                    Insect insect = (Insect) zn.getArthropod();
                    insect.probableDisappearance();
                }
            }
        }
    }


    /**
     * Конструктор
     */
    public Nature() {
        _spiderWeb = new SpiderWeb(SIZE_OF_SPIDER_WEB, SIZE_OF_SPIDER_WEB);

        player = new Spider(_spiderWeb);

        for (int i = 0; i < NUMBER_OF_SPIDERS; ++i){
            enemies.add(new SmartSpider(_spiderWeb));
        }
    }
}