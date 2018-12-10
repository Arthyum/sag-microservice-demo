package WxAPIClientUtils;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Random;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void getRandomInt (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getRandomInt)>> ---
		// @sigtype java 3.5
		// [i] field:0:required size
		// [o] field:0:required randomIntStr
		// [o] object:0:required randomInt
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();		
		String size = IDataUtil.getString(pipelineCursor, "size" );
		
		int randomInt = 0;
		try{
			int s = Integer.parseInt(size);
			randomInt = getRandomInt(s);
		} catch (NumberFormatException nfe){
			randomInt = 0;
		}
		
		String randomIntStr = "" + randomInt;
		IDataUtil.put(pipelineCursor, "randomInt", randomInt);
		IDataUtil.put(pipelineCursor, "randomIntStr", randomIntStr);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static Random hdrRndm = new Random(System.nanoTime());
	
	public static int getRandomInt(int length){
		int value = hdrRndm.nextInt(length);
		return value;
	}
	// --- <<IS-END-SHARED>> ---
}

