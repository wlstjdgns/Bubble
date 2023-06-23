package test.ex10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter @ Setter
public class Bubble extends JLabel{
    //의존성 컴포지션(player 변수가 Player클래스에 대한 의존성을 의미)
    //Bubble클래스는 Player클래스의 기능을 사용하기위해 클래스의 인스턴스를 보유해야함)
    //아래를 안하면 Player에 직접의존하며 Player변경사항에 종속됨
    //객체 결합도가 낮아지고 확장성이 높아짐
    //player가 음악재생 bubble가 음악재생시 버블표시일때 직접의존
    //인터페이스에 의존하게 만들면 버블을 다른곳에서 사용하기도 쉬워짐 
    //의존성 컴포지션
    private Player player;

    //위치상태
    private int x;
    private int y;

    //움직임 상태
    private boolean left;
    private boolean right;
    private boolean up;

    //적군을 맞춘 상태
    private int state; //0(물방울), 1(적을 가둔 물방울)

    private ImageIcon bubble;//물방울
    private ImageIcon bubbled;//적가둔물방울
    private ImageIcon bomb;//물방울터짐

    public Bubble(Player player){
        this.player = player;
        initObject();
        initSetting();
    }

    private void initObject(){
        bubble = new ImageIcon("image/bubble.png");
        bubbled = new ImageIcon("image/bubbled.png");
        bomb = new ImageIcon("image/bomb.png");
    }
    private void initSetting() {
		left = false;
		right = false;
		up = false;
		
		x = player.getX();
		y = player.getY();
		
		setIcon(bubble);
		setSize(50, 50);
		
		state = 0;
	}


}
