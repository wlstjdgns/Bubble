package test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {
    //JFrame은 Java에서 GUI구현하는 컴포넌트(창만들고 창크기와 위치설정하고 컨텐츠추가 등)
    //컴포넌트란 GUI를 구성하는 요소(텍스트,이미지,버튼,체크박스 등등)
    private JLabel backgroundMap;
    //JLabel은 레이블클래스(텍스트나 이미지표시-서식,크기,색상 설정가능)
    private Player player;

    public BubbleFrame() {
        initObject(); //게임에 사용될 객체 초기화(JLabel객체와 Player객체)
        initSetting(); //게임 창의 설정 초기화(창 크기, 레이아웃, 위치)
        initListener(); //키보드 입력 수신할 리스너(키입력시 리스너는 player객체의 대응메서드 호출)
        //init란 초기화하다 라는 뜻
        setVisible(true); 
    }

    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        //배경맵에 더해질 JLabel 객체를 생성하고 JFrame의 기본컨테이너인 contentPane에 
        //배경맵 JLabel 객체를 추가하는 코드이다.
        setContentPane(backgroundMap);
        //contentPane은 JFrame 객체의 콘텐츠가 표시되는 영역
        //콘텐츠란 JFrame객체에 표시되는 모든 것(텍스트,이미지,버튼,체크박스 등등)
        //컴포넌트(GUI구성요소 ex)JLabel) 콘텐츠(컴포넌트가 표시하는것 ex)헬로월드(JLabel이 표시하는것))

        player = new Player();
        add(player);
    }

    private void initSetting() {

        setSize(1000, 640);
        setLayout(null); //레이아웃 관리자 설정null->내가 임의로 배치할수있음
        setLocationRelativeTo(null);//JFrame을 화면 중앙에 배치한다.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            //KeyAdapter를 개체로 받아 키보드 이벤트들을 처리하는것
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.right();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.left();
                } else if (e.getKeyCode() == 38) {
                    player.high();

                } else {
                    player.down();

                }

            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
