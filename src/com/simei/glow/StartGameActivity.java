package com.simei.glow;


import com.simei.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartGameActivity extends Activity
{
	
	private Button easyBut = null;//��
	private Button hardBut = null;//�е�
	private Button mediumBut = null;//����
	private Button insaneBut = null;//����
	private Button backBut = null;//����

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startgame);
		initWidget();
	}
	/**
	 * ��ʼ���ؼ�
	 */
	private void initWidget()
	{
		easyBut = (Button)findViewById(R.id.easyBut);
		hardBut = (Button)findViewById(R.id.hardBut);
		mediumBut = (Button)findViewById(R.id.mediumBut);
		insaneBut = (Button)findViewById(R.id.insaneBut);
		backBut = (Button)findViewById(R.id.gobackBut);
		
		easyBut.setOnClickListener(new ButtonListener());
		hardBut.setOnClickListener(new ButtonListener());
		mediumBut.setOnClickListener(new ButtonListener());
		insaneBut.setOnClickListener(new ButtonListener());
		backBut.setOnClickListener(new ButtonListener());
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
			if(v == easyBut)//��
			{
			}
			else if(v == hardBut)//�е�
			{
			}
			else if(v == mediumBut)//����
			{
			}
			else if(v == insaneBut)//����
			{
			}
			else if(v == backBut)//�˳�
			{
				StartGameActivity.this.finish();
			}
		}
		
	}
	
	
}
