package test.ex09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
// main 스레드를 GUI 프로그램에서는 ui 스레드라고 부른다.
public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true); // while
    }

    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);
        player = new Player();
        add(player);
    }

    private void initSetting() {
        setSize(1000, 640);
        setLayout(null); // absoulte 레이아웃 (자유롭게 그림을 그릴 수 있다)
        setLocationRelativeTo(null); // JFrame 가운데 배치하기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼으로 창을 끌 때 JVM 같이 종료하기
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyCode());

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    //왼쪽방향보면 안돼. 벽에 부딪혀서도 안돼
                    if (!player.isLeft() && !player.isLeftWallCrash()) {
                        player.left();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!player.isRight() && !player.isRightWallCrash()) {
                        player.right();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP){
                    System.out.println("UP키 실행됨");
                    if (!player.isUp() && !player.isDown()){
                        player.up();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                } else if (e.getKeyCode() == KeyEvent.VK_UP){
                    player.setUp(false);
                }
               

            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
