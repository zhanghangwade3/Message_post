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
	/* 声明变量一个Button与两个EditText */
	private Button mButton1;
	private EditText mEditText1;
	private EditText mEditText2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/* 透过findViewById建构子来建构EditText1,EditText2与Button对象 */
		mEditText1 = (EditText) findViewById(R.id.myEditText1);
		mEditText2 = (EditText) findViewById(R.id.myEditText2);
		mButton1 = (Button) findViewById(R.id.myButton1);
		/* 将默认文字加载EditText中 */
		mEditText1.setText("请输入电话号码");
		mEditText2.setText("请输入短信内容!!");
		/* 设定onClickListener 让使用者点选EditText时做出反应 */
		mEditText1.setOnClickListener(new EditText.OnClickListener() {
			public void onClick(View v) {
				/* 点选EditText时清空内文 */
				mEditText1.setText("");
			}
		});
		/* 设定onClickListener 让使用者点选EditText时做出反应 */
		mEditText2.setOnClickListener(new EditText.OnClickListener() {
			public void onClick(View v) {
				/* 点选EditText时清空内文 */
				mEditText2.setText("");
			}
		});
		/* 设定onClickListener 让使用者点选Button时做出反应 */
		mButton1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				/* 由EditText1取得简讯收件人电话 */
				String strDestAddress = mEditText1.getText().toString();
				/* 由EditText2取得简讯文字内容 */
				String strMessage = mEditText2.getText().toString();
				/* 建构一取得default instance的 SmsManager对象 */
				SmsManager smsManager = SmsManager.getDefault();
				// TODO Auto-generated method stub
				/* 检查收件人电话格式与简讯字数是否超过70字符 */
				// if(isPhoneNumberValid(strDestAddress)==true &&
				// iswithin70(strMessage)==true)
				try {
					/*
					 * 两个条件都检查通过的情况下,发送简讯 *
					 * 先建构一PendingIntent对象并使用getBroadcast()方法进行Broadcast *
					 * 将PendingIntent,电话,简讯文字等参数传入sendTextMessage()方法发送简讯
					 */
					PendingIntent mPI = PendingIntent.getBroadcast(
							SendMessageActivity.this, 0, new Intent(), 0);
					smsManager.sendTextMessage(strDestAddress, null,
							strMessage, mPI, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Toast.makeText(SendMessageActivity.this, "送出成功!!",
						Toast.LENGTH_SHORT).show();
				mEditText1.setText("");
				mEditText2.setText("");
			}
		});
	}
}