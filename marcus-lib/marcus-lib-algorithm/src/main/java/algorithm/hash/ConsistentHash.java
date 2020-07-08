package algorithm.hash;

public interface ConsistentHash<T> {

    public void addNode(T node);

    public Boolean removeNode(T node);

    public T getDistribution(Object key);

}
