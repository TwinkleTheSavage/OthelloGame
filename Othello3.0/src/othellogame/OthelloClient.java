package othellogame;

import java.io.*;
import client.*;

public class OthelloClient extends AbstractClient{

	public OthelloClient(String host, int port) throws IOException{
	    super(host, port); //Call the superclass constructor
	    openConnection();
	  }

	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub
		
	}

	//accepts input from the console
	public void accept()
	{
		try
		{
			BufferedReader fromConsole =
					new BufferedReader(new InputStreamReader(System.in));
			String message;

			while (true)
			{
				message = fromConsole.readLine();
				//processmessage(message);
			}
		}
		catch (Exception ex)
		{
			System.out.println
					("Unexpected error while reading from console!");
		}


	}


}
