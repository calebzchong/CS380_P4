
public class Packet {
	public static final int IP_VERSION = 6;
	public static final int PROTOCOL_NUM = 17;
	public static final int HOP_LIMIT = 20;
	public static final int[] SRC_IP = {127,0,0,1};
	public static final int[] DEST_IP = {18,221,102,182};
	byte[] bytes;
	
	public Packet( int dataSize ){
		bytes = new byte[40 + dataSize];
		//Version
		bytes[0] = (IP_VERSION << 4);
		//Payload Length
		bytes[5] = (byte) dataSize;
		bytes[4] = (byte) (dataSize >>> 8);
		//Next Header
		bytes[6] = PROTOCOL_NUM;
		//Hop Limit
		bytes[7] = HOP_LIMIT;
		//SRC IP	
		bytes[18] = (byte)(0xFF);
		bytes[19] = (byte)(0xFF);
		bytes[20] = (byte)SRC_IP[0];
		bytes[21] = (byte)SRC_IP[1];
		bytes[22] = (byte)SRC_IP[2];
		bytes[23] = (byte)SRC_IP[3];
		//Dest IP 
		bytes[34] = (byte)(0xFF);
		bytes[35] = (byte)(0xFF);
		bytes[36] = (byte)DEST_IP[0];
		bytes[37] = (byte)DEST_IP[1];
		bytes[38] = (byte)DEST_IP[2];
		bytes[39] = (byte)DEST_IP[3];
	}
	
	public byte[] getBytes(){
		return bytes;
	}
}
