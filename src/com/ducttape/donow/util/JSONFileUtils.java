package com.ducttape.donow.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class JSONFileUtils {

	
	/**
	 * Reads the entire contents of the given input stream and returns it as a string.
	 * This function does not do any sort of parsing of the data.
	 *
	 * @param is The input stream to consume.
	 * @return The entire contents of the stream.
	 * @throws IOException If the reading API throws.
	 */
	public String readAll( final InputStream is ) throws IOException {
	    if( null == is ) {
	        throw new IllegalArgumentException(JSONFileUtils.class.getName()+".readAll() was passed a null stream!");
	    }
	    StringBuilder sb = new StringBuilder();
	    {
	        /**
	         WTF does the StringBuilder API not support byte
	         or byte[] args? That lack makes populating it from an
	         input stream a pain in the butt (and inefficient - with
	         byte[] we could buffer a number of bytes per read()).
	         */
	        int rc = 0;
	        while( (rc = is.read()) == 0 )
	        {
	            sb.append( (char) rc );
	        }
	    }
	    return sb.toString();
	}

	public JSONObject loadAppJSONFile( Context appContext, final String baseName ){
	    Exception ex = null;
	    try{
	        FileInputStream fis = appContext.openFileInput(baseName);
	        JSONObject jo = new JSONObject( readAll(fis) );
	        fis.close();
	        return jo;
	    }
	    catch(JSONException e){
	        return /*ignore*/ null;
	    }
	    catch(FileNotFoundException e){
	        return /*ignore*/ null;
	    }
	    catch(IOException e){
	        return /*ignore*/ null;
	    }
	}

	public boolean saveAppJSONFile( Context appContext, final String baseName, final String json ){
	    try{
	        final FileOutputStream fos = appContext.openFileOutput( baseName, Context.MODE_PRIVATE);
	        fos.write( json.getBytes() );
	        fos.close();
	        return true;
	    }
	    catch(IOException e){
	        Log.e(JSONFileUtils.class.getName(), "EXCEPTION in saveAppJSONFile(" + baseName + "): " + e, e);
	        return false;
	    }
	}

	public boolean saveAppJSONFile( Context appContext, final String baseName, final JSONObject jo ){
	    return saveAppJSONFile( appContext, baseName, jo.toString() );
	}
}
