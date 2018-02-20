package com.uptech.SendMessage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends Activity {
	/* ��������һ��Button������EditText */
	private Button mButton1;
	private EditText mEditText1;
	private EditText mEditText2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/* ͸��findViewById������������EditText1,EditText2��Button���� */
		mEditText1 = (EditText) findViewById(R.id.myEditText1);
		mEditText2 = (EditText) findViewById(R.id.myEditText2);
		mButton1 = (Button) findViewById(R.id.myButton1);
		/* ��Ĭ�����ּ���EditText�� */
		mEditText1.setText("������绰����");
		mEditText2.setText("�������������!!");
		/* �趨onClickListener ��ʹ���ߵ�ѡEditTextʱ������Ӧ */
		mEditText1.setOnClickListener(new EditText.OnClickListener() {
			public void onClick(View v) {
				/* ��ѡEditTextʱ������� */
				mEditText1.setText("");
			}
		});
		/* �趨onClickListener ��ʹ���ߵ�ѡEditTextʱ������Ӧ */
		mEditText2.setOnClickListener(new EditText.OnClickListener() {
			public void onClick(View v) {
				/* ��ѡEditTextʱ������� */
				mEditText2.setText("");
			}
		});
		/* �趨onClickListener ��ʹ���ߵ�ѡButtonʱ������Ӧ */
		mButton1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				/* ��EditText1ȡ�ü�Ѷ�ռ��˵绰 */
				String strDestAddress = mEditText1.getText().toString();
				/* ��EditText2ȡ�ü�Ѷ�������� */
				String strMessage = mEditText2.getText().toString();
				/* ����һȡ��default instance�� SmsManager���� */
				SmsManager smsManager = SmsManager.getDefault();
				// TODO Auto-generated method stub
				/* ����ռ��˵绰��ʽ���Ѷ�����Ƿ񳬹�70�ַ� */
				// if(isPhoneNumberValid(strDestAddress)==true &&
				// iswithin70(strMessage)==true)
				try {
					/*
					 * �������������ͨ���������,���ͼ�Ѷ *
					 * �Ƚ���һPendingIntent����ʹ��getBroadcast()��������Broadcast *
					 * ��PendingIntent,�绰,��Ѷ���ֵȲ�������sendTextMessage()�������ͼ�Ѷ
					 */
					PendingIntent mPI = PendingIntent.getBroadcast(
							SendMessageActivity.this, 0, new Intent(), 0);
					smsManager.sendTextMessage(strDestAddress, null,
							strMessage, mPI, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Toast.makeText(SendMessageActivity.this, "�ͳ��ɹ�!!",
						Toast.LENGTH_SHORT).show();
				mEditText1.setText("");
				mEditText2.setText("");
			}
		});
	}
}