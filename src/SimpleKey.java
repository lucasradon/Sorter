public class SimpleKey implements Comparable<SimpleKey>{
    public Integer  key, pos;

    public SimpleKey(Integer key, Integer pos){
        this.key=key;
        this.pos=pos;
    }

    @Override
    public int compareTo(SimpleKey key){
        if(this.key > key.key)
            return 1;
        else if (this.key.equals(key.key))
            return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return ("Key: "+key+" Pos: "+pos+" | ");
    }
}
