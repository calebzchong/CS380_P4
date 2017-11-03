import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Ipv6Client {
	public static void main(String[] args ){
		
		try (Socket socket = new Socket("18.221.102.182", 38004)) {
			
			System.out.println("Connected to server.");
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			OutputStream os = socket.getOutputStream();
			
			for ( int i=0, dataLength=2; i < 12; i++,dataLength*=2){
				System.out.println("data length: " + dataLength);
				Packet p = new Packet(dataLength);
				byte[] packetBytes = p.getBytes();
				os.write(packetBytes);
				System.out.print("0x");
				for ( int j = 0; j < 4; j++){
					System.out.printf("%02X", is.read());
				}
				System.out.println();
			}

		} catch ( Exception e ){
			e.printStackTrace();
		} finally {
			System.out.println("Disconnected from server.");
		}

	}

}
