package com.simei.util;

import android.app.Application;
import android.content.Context;
 /**
 * ϵͳ�����࣬��Ϸ�������еĲ��������������ȡ
 * @author KeTai
 *
 */
public class AppParameters extends Application {
	private boolean audio_parameter;		//��������
	private boolean shake_parameter;		//�𶯲���
	private boolean granule_parameter ;	//���Ӳ���
	
	private boolean flag = true;   //��������Ƿ����Ҫ���ļ������ȡ����
	private static Context context;
	private static ShareParameters shareParameters; 
	private static AppParameters appParameters = new AppParameters();
	 
	/**
	 * ˽�л����캯����ʹ�õ���
	 */
	private AppParameters(){
		
	}
	
	/**
	 * ��ȡ
	 * @param context
	 * @return
	 */
	public static AppParameters getInstance(Context context){
		   shareParameters =ShareParameters.getInstance(context);  
		return appParameters;
	}
	
	
	/**
	 * �ڳ����ʼ����ʱ�򣬽�ϵͳ���еĲ������ļ��ж�ȡ�������������
	 */
	protected void init(){
		if(!flag){	//���flagΪfalse����ô�����ļ��г�ʼ������ 
		
 			setAudio_parameter(shareParameters.getAudioParameter());
			setShake_parameter(shareParameters.getShakeParameter());
			setGranule_parameter(shareParameters.getGranuleParameter());
			setFlag(false);
		}
		 
	}

	@Override
	public void onCreate() {
 		super.onCreate();
		shareParameters =ShareParameters.getInstance(context); 
 		init();
	}

	
	public boolean isAudio_parameter() {
		return audio_parameter;
	}

	public boolean isShake_parameter() {
		return shake_parameter;
	}

	public boolean isGranule_parameter() {
		return granule_parameter;
	}

	public boolean isFlag() {
		return flag;
	}

	
	public void setAudio_parameter(boolean audio_parameter) {
		this.audio_parameter = audio_parameter;
		shareParameters.setAudioParameter(audio_parameter);
	}

	public void setShake_parameter(boolean shake_parameter) {
		this.shake_parameter = shake_parameter;
		shareParameters.setShakeParameter(shake_parameter); 
	}

	public void setGranule_parameter(boolean granule_parameter) {
		this.granule_parameter = granule_parameter;
		shareParameters.setGranuleParameter(granule_parameter);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
 
	  
}
