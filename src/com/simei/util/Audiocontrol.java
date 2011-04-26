package com.simei.util;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

/**
 * ������Ч�Ĺ�����
 * @author �����
 *
 */
public class Audiocontrol {
	
 	private MediaPlayer mp ;		//���ֲ���������
	private AssetFileDescriptor afd;	//��ȡassets�ļ������ļ��Ķ���
	private ShareParameters parameterUtil;
	private Context context;

	
	//�����Ǹ�����Ϊ�����ļ�
	private static String menu_select = "menu_select.mp3";
	private static String menu_canel = "menu_cancel.mp3";
	private static String pause = "pause.mp3";
	private static String my_puck_hit = "puck_hit1.mp3";
	private static String pic_puck_hit = "puck_hit2.mp3";
	private static String winner = "loser.mp3";
	private static String loser = "loser.mp3";
	private static String goal = "goal.mp3";
	private static String placing_puck = "placing_puck.mp3";
	private static String hit_paddle = "hit_paddle1.mp3";
 
	
	
	
	/**
	 * �ڹ��췽�����洿�������ģ���ʵ�������ֲ�����
	 * @param context
	 */
	public Audiocontrol(Context context){
		this.context = context;
		mp = new MediaPlayer();
		parameterUtil =  ShareParameters.getInstance(context);
	
	}
	
	/**
	 * ��ȡϵͳ�Ƿ�����trueΪ�������ݶ�ϵͳ���������sharePreferences��
	 * @return
	 */
	public boolean getParameter(){
		
		return parameterUtil.getAudioParameter();
	}
	 
	
	
	/**
	 * ȷ�ϡ�ȡ�����ݶ���������ʱΪ��ͣ�����֣���һ������ʱΪ�˵���ť����������ͣ��ȷ�ϻ���ȡ��,tureΪȷ�ϣ�falseΪȡ����
	 * @param bool
	 * @throws Exception
	 */
	public void selectOrCanelAudio(boolean... bool) throws Exception{
		
		if(bool.length<=0){
			this.play(pause); 
		}else if(bool[0]){
			this.play(menu_select);
		}else{
			 this.play(menu_canel);
 		}   
	}
	
	/**
	 * �򱻻�����õ����ַ��������Բ����λ�һ��booleanֵ���������ǽ��ʱ�������Σ�trueΪ�Լ�������falseΪ���Ի�����
	 * @param bools
	 * @throws Exception
	 */
	public void hitPuck(boolean... bools) throws Exception{
		if(bools.length<=0){
			 this.play(hit_paddle);
		}if(bools[0]){
			 this.play(my_puck_hit); 
		}else{
			 this.play(pic_puck_hit);		
		}
		
	} 
	
	/**
	 * Ӯ��������֣�trueΪӮ��falseΪ����
	 * @param bool
	 * @throws Exception
	 */
	public void winOrLose(boolean bool) throws Exception{
		if(bool){
			this.play(winner);
		}else{
			this.play(loser);
		}
		
	}
	
	/**
	 * ��������ǰ�������ڳ���ʱ�����֣�tureΪ���򣬷�����Ϊfalse
	 * @param bool
	 */
	public void goalOrPlacing_puck(boolean bool) throws Exception{
		if(bool){
			this.play(goal);
		}else{
			this.play(placing_puck);
		} 
	}
	 
	 
	/**
	 * �������֣��Ǹ������ŷ�����Ҫ���õ��������
	 * @param filename
	 * @throws Exception
	 */
	public void play(String filename)throws Exception{ 
		
		if(this.getParameter()){ 	//���ϵͳ�Ĳ���Ϊ����Ǻܣ���������
			afd = this.context.getAssets().openFd(filename);
		 	mp.reset();
			mp.setDataSource(afd.getFileDescriptor());
			mp.prepare();
			mp.start();	
		}
		
	}	 
	
	
}
