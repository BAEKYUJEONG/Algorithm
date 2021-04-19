import java.net.*;
import java.io.*;

public class SEOULG08_BAEKYUJEONG {

	// User and Launcher Information
	static final String NICKNAME = "SEOULG08_BAEKYUJEONG";
	static final String HOST = "127.0.0.1";

	// Static Value(Do not modify)
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// Predefined Variables(Do not modify)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// Beginning of Your Code
				// Put your code here to set angle and power values.
				// angle(float) must be between 0.0 and 360.0
				// power(float) must be between 0.0 and 100.0
				
				int whiteBall_x = balls[0][0];
				int whiteBall_y = balls[0][1];
				
				int targetBall_x = balls[1][0];
				int targetBall_y = balls[1][1];

				/*
				int number;
				int arr[] = new int[NUMBER_OF_BALLS];
				for(int i = 1; i < NUMBER_OF_BALLS; i++) {
					number = i;
					arr[i] = i;
				}
				
				int n = NUMBER_OF_BALLS;

				for(int i=1; i<=n; i++) {
					if(order==1) { //선일 경우
						if(number==2 || number==4)
							continue;
					}else { //선이 아닐 경우
						if(number==1 || number==3)
							continue;
					}
					
					if(공이 한개 남고 && 그 공이 8일 경우) {
					    number = 5;
					}
					
					targetBall_x = balls[number][0];
					targetBall_y = balls[number][1];
				}
				*/
				
				int width = Math.abs(targetBall_x - whiteBall_x);
				int height = Math.abs(targetBall_y - whiteBall_y);

				double radian = Math.atan(width / height);
				double distance = Math.sqrt((width * width) + (height * height));

				int place = Place(targetBall_x, targetBall_y, whiteBall_x, whiteBall_y);
				//angle = (float) ((270.0 / Math.PI) * radian);
				//stage1 -> 180.0 / stage2 -> 270.0
				
				angle = (float) Angle(place, width, height, distance);
				//angle = (float) (( aaangle / Math.PI) * radian);
				double nangle = nAlgle(place, targetBall_x, targetBall_y);
				angle+=nangle;
				power = (float) distance;
				
				
				// You can clear Stage 1 with the pre-written code above.
				// Those will help you to figure out how to clear other Stages.
				// Good luck!!
				// ENd of Your Code
				//////////////////////////////

				// Play(Send Data)
				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			//8방향을 찾아야함
			//각도 - Math.toDegrees(Math.acos(dy/len));
			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int Place(int tx, int ty, int wx, int wy) { //공의 위치가 어디인지 찾아야 각도를 잴 수 있음
		if(tx<wx && ty<wy) {
			return 1;
		}
		if(tx<wx && ty>wy) {
			return 2;
		}
		if(tx>wx && ty>wy) {
			return 3;
		}
		if(tx>wx && ty<wy) {
			return 4;
		}
		if(tx==wx && ty<wy) {
			return 5;
		}
		if(tx==wx && ty>wy) {
			return 6;
		}
		if(tx<wx && ty==wy) {
			return 7;
		}
		if(tx<wx && ty==wy) {
			return 8;
		}
		return -1;
	}
	
	private static double Angle(int place, int x, int y, double distance) {
		double angle = 0.0;
		
		if(place==1) {
			angle = Math.toDegrees(Math.acos(y/distance));
		}
		if(place==2) {
			angle = 90 + Math.toDegrees(Math.acos(x/distance));
		}
		if(place==3) {
			angle = 180 + Math.toDegrees(Math.acos(y/distance));
		}
		if(place==4) {
			angle = 270 + Math.toDegrees(Math.acos(x/distance));
		}
		if(place==5) {
			angle = 0;
		}
		if(place==6) {
			angle = 180;
		}
		if(place==7) {
			angle = 90;
		}
		if(place==8) {
			angle = 270;
		}
		return -1.0;
	}
	
	private static double nAlgle(int place, int tx, int ty) {
		double angle = 0.0;
		
		int number = 0;
		double min = (tx-HOLES[number][0]*tx-HOLES[number][0])+(ty-HOLES[number][1]*ty-HOLES[number][1]);
		for(int i=0; i<HOLES.length; i++) {
			double distance = (tx-HOLES[number][0]*tx-HOLES[number][0])+(ty-HOLES[number][1]*ty-HOLES[number][1]);
			if(min>distance) {
				min = distance;
				number = i;
			}
		}
		
		double difference = 1;
		switch (place) {
		case 1:
			if(ty<HOLES[number][1]) {
				angle = difference;
			}else {
				angle = -difference;
			}
			break;
		case 2:
			if(ty<=HOLES[number][1]) {
				angle = difference;
			}else {
				angle = -difference;
			}
			break;
		case 3:
			if(ty<=HOLES[number][1]) {
				angle = -difference;
			}else {
				angle = difference;
			}
			break;
		case 4:
			if(ty<HOLES[number][1]) {
				angle = -difference;
			}else {
				angle = difference;
			}
			break;
		case 5:
			if(tx<HOLES[number][0]) {
				angle = -difference;
			}else {
				angle = difference;
			}
			break;
		case 6:
			if(ty<HOLES[number][1]) {
				angle = difference;
			}else {
				angle = -difference;
			}
			break;
		case 7:
			if(tx<HOLES[number][0]) {
				angle = difference;
			}else {
				angle = -difference;
			}
			break;
		case 8:
			if(ty<HOLES[number][1]) {
				angle = -difference;
			}else {
				angle = difference;
			}
			break;

		default:
			break;
		}
		return angle;
	}
	
}

/*
 * 내용 - 어떤 알고리즘인지
 * 
 * 일단 현재 내 흰 공의 위치와 목적구 간의 거리를 구해야한다.
 * 그 둘을 잇는 세모가 그려진다 생각하고 밑변과 높이로 피타고라스의 공식을 이용해 두 공 간의 거리를 찾는다.
 * 그리고 삼각 함수 중 역코사인 공식을 이용해 각도를 구하고, java에서는 이것이 radius로 표기 되기 때문에 degree형식으로 바꿔서 표기해줘야한다.
 * 코사인 방식으로 구하기 때문에 8방을 나눠서 공간을 지정해주고 각도를 정해준다. 삼각형이 돌아간다고 생각하면 편하다.
 * 그 각도를 통해 목적구까지 향해 친다.
 * 각에 따라 -를 더해준다.
 * 
 * 선일 경우 2,4공을 지나치고
 * 후일 경우 1,3공을 지나친다.
 * 
 * 8 하나 남았을 경우 그것을 친다.
 * */

