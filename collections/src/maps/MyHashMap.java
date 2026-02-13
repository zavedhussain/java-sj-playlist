package maps;

class MyHashMap {

    Node[] list;

    public MyHashMap() {
        this.list = new Node[10_000];
    }

    public void put(int key, int value) {
        int idx = (int) (hashCode(key) % list.length);

        if(list[idx] == null){
            list[idx] = new Node(hashCode(key), -1,-1);
        }

        Node prev = find(key);
        if(prev.next == null){
            prev.next =  new Node(hashCode(key), key, value);
        }else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        Node prev = find(key);
        if(prev == null || prev.next == null){
            return -1;
        }else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        Node prev = find(key);
        if(prev != null && prev.next != null){
            prev.next = prev.next.next;
        }
    }

    private Node find(int key){
        int idx = (int) (hashCode(key) % list.length);
        Node prev = list[idx];
        while(prev!=null && prev.next != null){
            if(prev.next.key == key){
                return prev;
            }
            prev = prev.next;
        }
        return prev;
    }

    private int hashCode(int key){
        return key;
    }

    class Node{
        int hash;
        int key;
        int value;
        Node next;

        Node(int hash, int key, int value){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */