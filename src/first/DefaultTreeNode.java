package first;

public class DefaultTreeNode implements SimpleTreeNode{
    private int CAPACITY;
    private String name;
    private SimpleTreeNode[] childs;
    private int childcnt;
    public DefaultTreeNode(String name){
        this.name = name;
        this.CAPACITY = 1;
        this.childs = new SimpleTreeNode[1];
        this.childcnt = 0;
    }
    public void addChild(SimpleTreeNode child) {
        if (this.childcnt >= this.CAPACITY){
            //Kapazitätsverdopplung ist sinnvoll, wird später noch erläutert
            //Hierdurch ist der Durchschnittliche Aufwand für das Element einfach errechenbar(?)
            this.CAPACITY *= 2;
            SimpleTreeNode[] newchilds =  new SimpleTreeNode[this.CAPACITY];
            if (this.childcnt >= 0) System.arraycopy(this.childs, 0, newchilds, 0, this.childcnt);
            this.childs = newchilds;
        }
        this.childs[this.childcnt++] = child;
    }

    @Override
    public int getChildCnt() {
        return this.childcnt;
    }

    @Override
    public SimpleTreeNode getChild(int pos) {
        return this.childs[pos];
    }
}
