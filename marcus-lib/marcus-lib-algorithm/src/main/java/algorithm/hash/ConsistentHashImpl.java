package algorithm.hash;

import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;

public class ConsistentHashImpl<T>  implements ConsistentHash {

    private NavigableMap<Integer, T> circle = new TreeMap<>();

    private Integer numberOfReplicas;

    private HashFunction hashFunction;

    public ConsistentHashImpl(Collection<T> nodes, Integer numberOfReplicas) {

        this(nodes, numberOfReplicas, null);

    }
    public ConsistentHashImpl(Collection<T> nodes, int numberOfReplicas, HashFunction hashFunction) {
        this.numberOfReplicas = numberOfReplicas > 1 ? numberOfReplicas :  1;
        if (nodes != null) {
            for (T node: nodes) {
                addNode(node, numberOfReplicas);
            }
        }

        if (hashFunction == null) {
            this.hashFunction = new HashFunction() {
                public Integer hash(Object key) {
                    return HashUtil.fnvHash(key.toString());
                }
            };
        }
    }

    @Override
    public void addNode(Object node) {
        if (node == null) {
            return;
        }
    }

    @Override
    public void addNode(T node, int virtualNodeNum) {
        if (serverNode == null || StrUtil.isBlank(serverNode.getKey())) {
            return;
        }
        int num = virtualNodeNum > 1 ? virtualNodeNum : 1;
        for (int i = 1; i <= num; i++) {
            VirtualNode virtualNode = new VirtualNode(serverNode, num);
            virtualNodesMap.put(hashFunction.hash(virtualNode.getKey()), virtualNode);
        }
    }

    @Override
    public Boolean removeNode(ServerNode serverNode) {
        if (serverNode == null || StrUtil.isBlank(serverNode.getKey())) {
            return true;
        }
        Iterator<Long> it = virtualNodesMap.keySet().iterator();
        while (it.hasNext()) {
            Long key = it.next();
            VirtualNode virtualNode = virtualNodesMap.get(key);
            if (serverNode.getKey().equals(virtualNode.getServerNode().getKey())) {
                it.remove();
            }
        }
        return true;
    }

    @Override
    public T getDistribution(String key) {
        if (StrUtil.isBlank(key)) {
            throw new NullPointerException("key can not be null.");
        }

        if (virtualNodesMap.isEmpty()) {
            return null;
        }

        Long hash = hashFunction.hash(key);

        SortedMap<Long,VirtualNode<T>> tailMap = virtualNodesMap.tailMap(hash);

        Long matchVirtualNodeHash = tailMap.isEmpty() ? virtualNodesMap.firstKey() : tailMap.firstKey();

        return virtualNodesMap.get(matchVirtualNodeHash).getServerNode();
    }
}
