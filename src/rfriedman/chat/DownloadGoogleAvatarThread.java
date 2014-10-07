package rfriedman.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DownloadGoogleAvatarThread extends Thread {

	private ChatFrame frame;
	public final String X_JavaScript_User_Agent = "Google APIs Explorer";
	public final String Authorization = "Oauth AUthorization Key";
	public final String AVATAR_URL = "https://www.googleapis.com/plus/v1/people/me?fields=image%2Cname&key={MY_KEY}";
	private AvatarFeed avatarFeed;

	public DownloadGoogleAvatarThread(final ChatFrame frame) {
		this.frame = frame;

	}

	public void run() {
		String url = "https://www.googleapis.com/plus/v1/people/me?fields=image%2Cname&key={AIzaSyBwTpxiZ_2_C30i0i6yAZvOmRvU6F9dDtk}";
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("X-JavaScript-User-Agent",
					X_JavaScript_User_Agent);
			con.setRequestProperty("Authorization", Authorization);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			
			final JsonReader jsonReader = new JsonReader(in);
			jsonReader.setLenient(true);
			
			Gson gson = new Gson();
			avatarFeed = gson.fromJson(jsonReader, AvatarFeed.class);
			
			frame.setIconImage(avatarFeed);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
