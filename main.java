import Model.*;
import View.SpiderWebWidget;
import View.WidgetFactory;
import View.ZoneWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Класс начального запуска игры
 */
public class main {
    /**
     * функция запуска игры
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GamePanel::new);
    }

    /**
     * Панель игры
     */
    static class GamePanel extends JFrame {
        /**
         * игра
         */
        private Game game;

        /**
         * Конструктор
         */
        public GamePanel(){
            setVisible(true);
            startGame();
            setResizable(false);

            JMenuBar menuBar = new JMenuBar();
            menuBar.add(createGameMenu());
            setJMenuBar(menuBar);

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            addKeyListener( new KeyController() );
        }

        /**
         * Создать меню игры
         * @return меню
         */
        private JMenu createGameMenu() {
            JMenu gameMenu = new JMenu("Игра");
            JMenuItem newGameMenuItem = new JMenuItem(new NewGameAction());
            JMenuItem exitMenuItem = new JMenuItem(new ExitAction());
            gameMenu.add(newGameMenuItem);
            gameMenu.add(exitMenuItem);
            return gameMenu;
        }

        private class NewGameAction extends AbstractAction {
            public NewGameAction() {
                putValue(NAME, "Новая");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(GamePanel.this,
                        "Начать новую игру?", "Новая игра",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) startGame();
            }
        }

        private static class ExitAction extends AbstractAction {
            public ExitAction() {
                putValue(NAME, "Выход");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }

        /**
         * Начало игры
         */
        private void startGame() {
            WidgetFactory widgetFactory = new WidgetFactory();
            game = new Game();


            JPanel content = (JPanel) this.getContentPane();
            content.removeAll();
            content.add(new SpiderWebWidget(game.nature(), game.spiderWeb(), widgetFactory));

            pack();
        }

        private class KeyController implements KeyListener {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();

                Direction direct;

                if(code == KeyEvent.VK_UP) {         // перемещаемся вверх
                    direct = Direction.north();
                }
                else if(code == KeyEvent.VK_DOWN) {  // перемещаемся вниз
                    direct = Direction.south();
                }
                else if(code == KeyEvent.VK_LEFT) {  // перемещаемся влево
                    direct = Direction.west();
                }
                else if(code == KeyEvent.VK_RIGHT) { // перемещаемся вправо
                    direct = Direction.east();
                }
                else{
                    return;
                }

                game.runInsectLife();
                game.runSpidersMoves(direct);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }
    }
}