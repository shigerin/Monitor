import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;


public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		CheckHosts("192.9.211");

	}

	/**
	 * @param subnet
	 */
	/**
	 * @param subnet
	 */
	public static void CheckHosts(String subnet)
	{
		try {
		System.out.println(InetAddress.getLocalHost().getAddress());

		System.out.println( "ping START");

		int timeout=3000;
		for(int i=1;i<20;i++)
		{
			String host=subnet + "." + i;

			//Pingと結果が異なる場合がある
//			if(InetAddress.getByName(host).isReachable(timeout))
//			{
//				System.out.println(host + " ping Ok");
//			}
//			else
//			{
//				System.out.println(host + " ping NG");
//			}

			try {
				boolean ret =ping(Inet4Address.getByName(host));
				if(ret)
				{
					System.out.println(host + " ping Ok");
				}
				else
				{
					System.out.println(host + " ping NG");
				}
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
		System.out.println( "ping END");
	}
		 catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

	/**
	 * Ping を実行し、ホストとの疎通を確認します。
	 *
	 * @param target 疎通確認をしたいホスト
	 * @return 疎通が確認できれば true, 確認できないなら false
	 */
	public static boolean ping(InetAddress target) throws IOException, InterruptedException{
		// Windows の場合
		String[] command = {"ping", "-n", "1", "-w", "100", target.getHostAddress()};
		// Linux の場合
		// String[] command = {"ping", "-c", "1", "-t", TIMEOUT, target.getHostAddress()};

		return new ProcessBuilder(command).start().waitFor() == 0;
	}

}






