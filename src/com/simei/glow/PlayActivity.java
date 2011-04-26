package com.simei.glow;


import com.simei.util.Textures;
import com.stickycoding.rokon.DrawPriority;
import com.stickycoding.rokon.RokonActivity;

/**
 * ��Ϸ����Activity
 * @author KeTai
 *
 */
public class PlayActivity extends RokonActivity{
	//��Ļ��̬���� ���
	private static float GAME_WIDTH = 3.2f;
	//��Ļ��̬���� �߶�
	private static float GAME_HEIGHT = 4.8f;
	
	
	@Override
	public void onCreate() {
 		super.onCreate();
 		
 		debugMode();
		//ȫ����ʾ
		forceFullscreen();
		
		forcePortrait();
		//forceLandscape();
		//������ʾ
		//forcePortrait();
		//������Ϸ�����С
		setGameSize(GAME_WIDTH, GAME_HEIGHT);
		//���û�ͼģʽ 0 -- VBOģʽ   1 -- һ��ģʽ  openGL ��Ⱦ��ʽ֮һ priority_vbo
		setDrawPriority(DrawPriority.PRIORITY_VBO);
		//����ͼƬ��ԴĿ¼�ļ�
		setGraphicsPath("textures/");
		//����һ������
		createEngine();
	
	
	}

	@Override
	public void onLoadComplete() {
 		super.onLoadComplete();
 		
 		//����ͼƬ
		Textures.load();
		//���ó���
		setScene(new GameScene());
	}
		
	
	
	
}
