package algorithm.hash;

public class VirtualNode<T extends ServerNode> implements Node {

    private T serverNode;

    private int index;

    public VirtualNode(T serverNode, int index) {
        if (serverNode == null) {
            throw new NullPointerException("serverNode can not be null.");
        }
        this.serverNode = serverNode;
        this.index = index;
    }

    @Override
    public String getKey() {
        return new StringBuilder().append(serverNode.getKey()).append("#").append(index).toString();
    }

    public T getServerNode() {
        return this.serverNode;
    }

}
