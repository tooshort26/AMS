package com.example.attendancemonitoring.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Message implements Serializable{
	private static final String TAG = "Message";
	public static final int TEXT_MESSAGE = 1;
	public static final int IMAGE_MESSAGE = 2;
	public static final int VIDEO_MESSAGE = 3;
	public static final int AUDIO_MESSAGE = 4;
	public static final int FILE_MESSAGE = 5;
	public static final int DRAWING_MESSAGE = 6;

	private int mType;
	private String mText;
	private String chatName;
	private byte[] byteArray;
	private InetAddress senderAddress;
	private String fileName;
	private long fileSize;
	private String filePath;
	private boolean isMine;

	//// MARK: 16/06/2018 stores a record of all users this message been to
	private ArrayList<String> user_record;

	//Getters and Setters
	public int getmType() { return mType; }
	//	public void setmType(int mType) { this.mType = mType; }
	public String getmText() { return mText; }
	//	public void setmText(String mText) { this.mText = mText; }
	public String getChatName() { return chatName; }
	public InetAddress getSenderAddress() { return senderAddress; }
	public void setSenderAddress(InetAddress senderAddress) { this.senderAddress = senderAddress; }

	public void setMine(boolean isMine) { this.isMine = isMine; }
	public ArrayList<String> getUser_record() {
		return user_record;
	}
	public void setUser_record(String user_name) {
		this.user_record.add(user_name);
	}

	public Message(int type, String text, InetAddress sender, String name){
		mType = type;
		mText = text;
		senderAddress = sender;
		chatName = name;
		user_record = new ArrayList<>();
	}

	public Bitmap byteArrayToBitmap(byte[] b){
		Log.v(TAG, "Convert byte array to image (bitmap)");
		return BitmapFactory.decodeByteArray(b, 0, b.length);
	}

	public void saveByteArrayToFile(Context context){
		Log.v(TAG, "Save byte array to file");
	}

}
