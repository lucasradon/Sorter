public class ExtendedKey implements Comparable<ExtendedKey>{
    public Integer  key, pos;

    public ExtendedKey(Integer key, Integer pos){
        this.key=key;
        this.pos=pos;
    }

    @Override
    public int compareTo(ExtendedKey key){
        if(this.key > key.key)
            return 1;
        else if (this.key==key.key) {
            if (this.pos > key.pos)
                return 1;
            else if(this.pos==key.pos)
                return 0;
            else
                return -1;
        }
        else return -1;
    }

    @Override
    public String toString() {
        return "Pos: "+pos+" Key: "+key;
    }
}
