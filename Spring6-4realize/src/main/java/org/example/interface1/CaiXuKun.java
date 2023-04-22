package org.example.interface1;

/**
 * 定义蔡徐坤类,实现Star接口
 */
public class CaiXuKun implements Star{
    @Override
    public void changGe() {
        System.out.println("蔡徐坤在唱歌!");
    }

    @Override
    public void tiaoWu() {
        System.out.println("蔡徐坤在跳舞!");
    }

    @Override
    public void rap() {
        System.out.println("蔡徐坤在rap!");
    }

    @Override
    public void daLanQiu() {
        System.out.println("蔡徐坤在打篮球!");
    }

    @Override
    public void tiZuQiu() {
        System.out.println("蔡徐坤在踢足球!");
    }

    @Override
    public String zhiBoDaiHuo(double moeny) {
        System.out.println("蔡徐坤在直播带货,在卖辣条,一包辣条"+moeny+"钱!");
        return "蔡徐坤给粉丝免费赠送辣条了";
    }
}
