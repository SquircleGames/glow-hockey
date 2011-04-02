package com.simei.glow;

import com.simei.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HockeyActivity extends Activity
{

	private Button startBut = null;//��ʼ��Ϸ
	private Button setBut = null;//������Ϸ
	private Button aboutBut = null;//������Ϸ
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initWidget();//��ʼ���ؼ�
	}
	
	/**
	 * @author Addy
	 * 
	 * ��ʼ���ؼ�
	 */
	private void initWidget()
	{
		startBut = (Button)findViewById(R.id.startBut);
		setBut = (Button)findViewById(R.id.setBut);
		aboutBut = (Button)findViewById(R.id.aboutBut);
		
		startBut.setOnClickListener(new ButtonListener());
		setBut.setOnClickListener(new ButtonListener());
		aboutBut.setOnClickListener(new ButtonListener());
		
	}
	
	/**
	 * 
	 * @author Addy
	 *��ť����¼���
	 */
	private class ButtonListener implements OnClickListener
	{

		
		@Override
		public void onClick(View v)
		{
			Intent intent = null;
			if(v == startBut)//��ʼ��Ϸ
			{
				intent = new Intent(HockeyActivity.this,StartGameActivity.class);
			}
			else if(v == setBut)//������Ϸ
			{
				intent = new Intent(HockeyActivity.this,SettingGameActivity.class);
			}
			else if(v == aboutBut)//������Ϸ
			{
				intent = new Intent(HockeyActivity.this,AboutGameActivity.class);
			}
			startActivity(intent);
			overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
		}
		
	}
	
}
