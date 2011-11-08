package org.witness.informa.utils;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;
import org.json.JSONObject;
import org.witness.sscphase1.ObscuraApp;

import android.util.Log;

public class SensorLogger {
	Timer mTimer;
	TimerTask mTask;
	File mLog;
	
	JSONObject mBuffer;
	
	boolean hasLog, isSensing;
	
	SensorLogger() {
		hasLog = false;
		isSensing = true;
		mTimer = new Timer();
	}

	public void sendToBuffer(JSONObject logItem) {
		// append to buffer, and...
		Log.d(ObscuraApp.TAG, logItem.toString());
		
		if(hasLog)
			sendToLog(logItem);
		
	}
	
	public void sendToLog(JSONObject logItem) {
		
	}

	public boolean startLog(File log) {
		mLog = log;
		hasLog = true;
		return hasLog;
	}

	
	public boolean stopLog() {
		hasLog = false;
		return hasLog;
	}
	
	public JSONObject jPack(String key, Object val) throws JSONException {
		JSONObject item = new JSONObject();
		item.put(key, val.toString());
		return item;
	}
}