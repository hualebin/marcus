package org.marcus.lib.all.jvm;

/**
 * 变量槽复用测试
 * run 加上-verbose:gc 运行参数
 *
 * @author marcus
 * @date 2020-12-18
 */
public class VariableSlotMultiplexTest {
	public static void main(String[] args) {
		// 结果 [GC (System.gc())  70779K->66264K(251392K), 0.0014098 secs] [Full GC (System.gc())  66264K->66116K(251392K), 0.0057694 secs]
		/*byte[] placeholder = new byte[64 * 1024 * 1024];
		System.gc();*/

		// 结果 [GC (System.gc())  70779K->66264K(251392K), 0.0014098 secs] [Full GC (System.gc())  66264K->66116K(251392K), 0.0057694 secs]
		/*{
			byte[] placeholder = new byte[64 * 1024 * 1024];
		}
		System.gc();*/
		{
			byte[] placeholder = new byte[64 * 1024 * 1024];
		}
		int a = 0;
		System.gc();
	}
}

