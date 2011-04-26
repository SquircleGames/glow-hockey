package com.simei.util;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * ���ڻ�ȡ��������ϵͳ�����Ĺ�����
 * @author �����
 *
 */
public class ShareParameters {
	private static SharedPreferences spf;	
 	private static Editor editor; // �༭��
	private static String audio_parameter = "audio";
	private static String shake_parameter = "shake";
	private static String granule_parameter = "granule";
 	private static ShareParameters  shareParameters = new ShareParameters(); 
 
 	/**˽�л����췽����ʹ�õ���
 	 * 
 	 */
	private ShareParameters(){
 		
 	}
 	
	/**
	 * ��ȡShareParameters��ʵ����
	 * @param context
	 * @return
	 */
	public static ShareParameters getInstance(Context context){
 		spf = context.getSharedPreferences("GlowHockey", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
		editor = spf.edit();
 		return shareParameters;
	}
	
	
	
 
	
	/**
	 * ������Ч������ֵ
	 */
	public void setAudioParameter(boolean value){
		this.setBooleanParameter(audio_parameter, value);
	 }
	
	/**
	 * �����𶯲�����ֵ
	 * @param bool
	 */
	public void setShakeParameter(boolean value){
		this.setBooleanParameter(shake_parameter, value);
		
	}
	
	/**
	 * �������Ӳ�����ֵ
	 * @param value
	 */
	public void setGranuleParameter(boolean value){
		this.setBooleanParameter(granule_parameter, value);
	}
	
	/**
	 * ������ֲ�����ֵ
	 * @return
	 */
	public boolean getAudioParameter(){
		
		return this.getBooleanParameter(audio_parameter);
	}
	
	/**
	 * ����𶯲�����ֵ
	 * @return
	 */
	public boolean getShakeParameter(){
		
		return this.getBooleanParameter(shake_parameter);
	}
	
	/**
	 * ������Ӳ�����ֵ
	 * @return
	 */
	public boolean getGranuleParameter(){
		
		return this.getBooleanParameter(granule_parameter);
	}
	
	
	
	
	/**
	 * ������Ϸ�����в���ֵ�����Ļ�������
	 * @param parmName
	 * @param value
	 */
	public void setBooleanParameter(String parmName,boolean value){
		  editor.clear();
		  editor.putBoolean(parmName, value);
		  editor.commit();
	
		
	} 
	
	/**
	 * �����Ϸ�����в���ֵ�����Ļ�������
	 * @param parameter
	 * @return
	 */
	public boolean getBooleanParameter(String parameter){ 
		return spf.getBoolean(parameter, true);	
		
	}
	
	
	/** 
	 * �������Ҫ����Ϸ��ʼ��ʱ�����
	 * 
	 */  
	public void beforStart(){
		this.setAudioParameter(this.getAudioParameter());
		this.setShakeParameter(this.getShakeParameter());
		this.setGranuleParameter(this.getGranuleParameter()); 
		
	}
	
	
}
