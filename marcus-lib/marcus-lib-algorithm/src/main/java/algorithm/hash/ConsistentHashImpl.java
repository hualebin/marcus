package algorithm.hash;

import cn.hutool.core.util.HashUtil;

import java.util.*;

public class ConsistentHashImpl<T>  implements ConsistentHash<T> {

    private NavigableMap<Integer, T> circle = new TreeMap<>();

    private Integer numberOfReplicas;

    private HashFunction hashFunction;

    public ConsistentHashImpl(Integer numberOfReplicas) {

        this(null, numberOfReplicas, null);

    }

    public ConsistentHashImpl(Collection<T> nodes, Integer numberOfReplicas) {

        this(nodes, numberOfReplicas, null);

    }
    public ConsistentHashImpl(Collection<T> nodes, int numberOfReplicas, HashFunction hashFunction) {
        this.numberOfReplicas = numberOfReplicas > 1 ? numberOfReplicas :  1;
        if (nodes != null) {
            for (T node: nodes) {
                addNode(node);
            }
        }

        if (hashFunction == null) {
            this.hashFunction = new HashFunction() {
                @Override
                public Integer hash(Object key) {
                    return HashUtil.fnvHash(key.toString());
                }
            };
        }
    }

    @Override
    public void addNode(T node) {
        if (node == null) {
            return;
        }
        for (int i = 1; i <= numberOfReplicas; i++) {
            this.circle.put(hashFunction.hash(node.toString() + i), node);
        }
    }

    @Override
    public Boolean removeNode(T node) {
        if (node != null) {
            for (int i = 1; i <= numberOfReplicas; i++) {
                this.circle.remove(hashFunction.hash(node.toString() + i));
            }
        }
        return true;
    }

    @Override
    public T getDistribution(Object key) {
        if (key == null) {
            throw new NullPointerException("key can not be null.");
        }

        if (this.circle.isEmpty()) {
            return null;
        }

        Integer hash = hashFunction.hash(key);

        SortedMap<Integer, T> tailMap = this.circle.tailMap(hash);

        Integer matchNodeHash = tailMap.isEmpty() ? this.circle.firstKey() : tailMap.firstKey();

        return this.circle.get(matchNodeHash);
    }

    public NavigableMap<Integer, T> getCircle() {
        return this.circle;
    }
}
