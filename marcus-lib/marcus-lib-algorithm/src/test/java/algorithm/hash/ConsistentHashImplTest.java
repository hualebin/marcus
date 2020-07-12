package algorithm.hash;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;

public class ConsistentHashImplTest {

	public static final String[] ips = new String[]{
			"192.168.0.10", "192.168.0.11", "192.168.0.12", "192.168.0.13", "192.168.0.14",
			"192.168.0.15", "192.168.0.16", "192.168.0.17", "192.168.0.18", "192.168.0.19"
	};

	public static final int port = 8000;

	@Test
	public void testFnvHashBalance() {
		// 每个服务器节点对应10个虚拟节点
		ConsistentHash<ServerNode> consistentHash = new ConsistentHashImpl<>(10);
		test(consistentHash);
	}

	private void test(ConsistentHash<ServerNode> consistentHash) {
		List<ServerNode> nodeList = new ArrayList<>(ips.length);
		for (String ip : ips) {
			ServerNode serverNode = new ServerNode(ip, port);
			consistentHash.addNode(serverNode);
			nodeList.add(serverNode);
		}

		// 打印虚拟节点分布
		NavigableMap<Integer, ServerNode> circle = ((ConsistentHashImpl<ServerNode>) consistentHash).getCircle();
		Iterator<Integer> it = circle.keySet().iterator();
		int num = 1;
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.printf("第%s个虚拟节点, 服务器【%s】\n", num++, circle.get(i).toString());
		}


		// 准备一百万条数据，用一致性分布算法分布在服务器上
		for (int i = 0; i < 1000000; i++) {
			String key = String.valueOf(i);
			String value = RandomUtil.randomString(6);
			consistentHash.getDistribution(key).put(key, value);
		}

		// 打印分布
		for (ServerNode serverNode : nodeList) {
			System.out.printf("服务器【%s】节点存储(%s)条数据\n", serverNode.toString(), serverNode.getDataCount());
		}

		// 标准差计算
		int total = nodeList.stream().mapToInt(ServerNode::getDataCount).sum();

		double avg = total * 1.0 / nodeList.size();

		double sum = nodeList.stream().mapToDouble(node -> Math.pow((node.getDataCount() * 1.0) - avg, 2)).sum();

		double standardDeviation = Math.sqrt(sum / nodeList.size());

		System.out.printf("标准差：%s", String.valueOf(standardDeviation));
	}
}
