package com.simei.util;

import com.stickycoding.rokon.Texture;
import com.stickycoding.rokon.TextureAtlas;

/**
 * ͼƬ�����࣬���е�ͼƬ��Ҫ���ⱻ��ӵ���Ϸ��
 * @author KeTai
 *
 */
public class Textures
{
	public static TextureAtlas atlas;
	public static Texture background,cpuBat,ball,playerBat;
	
	/**
	 * ��ͼƬ���ص�������
	 */
	public static void load(){
		atlas = new TextureAtlas();
		atlas.insert(background = new Texture("original_table_bg@2x.png"));
		atlas.insert(ball = new Texture("original_ball_blue.png"));
		atlas.insert(playerBat = new Texture("original_paddle_green.png"));
		atlas.insert(cpuBat = new Texture("original_paddle_blue.png"));
 
		atlas.complete();
	}
}
