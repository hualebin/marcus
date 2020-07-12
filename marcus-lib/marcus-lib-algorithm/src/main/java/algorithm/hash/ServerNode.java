package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class ServerNode {

	private String ip;

	private int port;

	private Map<String, Object> cacheData = new HashMap<>();

	public ServerNode(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(ip).append(":").append(port).toString();
	}

	public void put(String key, Object value) {
		this.cacheData.put(key, value);
	}

	public Object remove(String key) {
		return cacheData.remove(key);
	}

	public Integer getDataCount() {
		return cacheData.size();
	}
}
