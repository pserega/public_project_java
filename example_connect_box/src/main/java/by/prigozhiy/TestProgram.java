package by.prigozhiy;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.box.boxjavalibv2.BoxClient;
import com.box.boxjavalibv2.dao.BoxFolder;
import com.box.boxjavalibv2.dao.BoxOAuthToken;
import com.box.boxjavalibv2.dao.BoxTypedObject;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxServerException;
import com.box.boxjavalibv2.requests.requestobjects.BoxOAuthRequestObject;
import com.box.restclientv2.exceptions.BoxRestException;

public class TestProgram {

	public static final int PORT = 4000;
	public static final String key = "k5dv596h0a0i41zd0eds507wo3w97mat";
	public static final String secret = "2UvxPtfTvn8MWEY8SPoD25o8TNeIfS7w";

	public static void main(String[] args) throws AuthFatalFailureException,
			BoxServerException, BoxRestException {

		String code = "";
		String url = "https://www.box.com/api/oauth2/authorize?response_type=code&client_id="
				+ key;
		try {
			Desktop.getDesktop().browse(java.net.URI.create(url));
			code = getCode();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BoxClient client = getAuthenticatedClient(code);

		BoxFolder boxFolder = client.getFoldersManager().getFolder("0", null);
		ArrayList<BoxTypedObject> stuff = boxFolder.getItemCollection()
				.getEntries();
		int folderSize = stuff.size();
		for (int i = 0; i <= folderSize - 1; i++) {
			BoxTypedObject foo = stuff.get(i);
			System.out.println("i:" + i + " Type:" + foo.getType() + " Id:"
					+ foo.getId());
		}
	}

	private static BoxClient getAuthenticatedClient(String code)
			throws BoxRestException, BoxServerException,
			AuthFatalFailureException {
		BoxClient client = new BoxClient(key, secret);
		BoxOAuthRequestObject obj = BoxOAuthRequestObject
				.createOAuthRequestObject(code, key, secret,
						"http://localhost:" + PORT);
		BoxOAuthToken bt = client.getOAuthManager().createOAuth(obj);
		client.authenticate(bt);
		return client;
	}

	private static String getCode() throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT);
		Socket socket = serverSocket.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		while (true) {
			String code = "";
			try {
				code = in.readLine();
				System.out.println(code);
				String match = "code";
				int loc = code.indexOf(match);

				if (loc > 0) {
					int httpstr = code.indexOf("HTTP") - 1;
					code = code.substring(code.indexOf(match), httpstr);
					String parts[] = code.split("=");
					code = parts[1];
				} else {
					// It doesn't have a code
				}

				return code;
			} catch (IOException e) {
				// error ("System: " + "Connection to server lost!");
				System.exit(1);
				break;
			}
		}
		return "";
	}

}
