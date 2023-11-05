public class MyHashMap<K, V> {
    public int Size() {
        return size;
    }

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> nextEntry;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNextEntry() {
            return nextEntry;
        }

        public void setNextEntry(Entry<K, V> nextEntry) {
            this.nextEntry = nextEntry;
        }
    }
    private int size = 0;

    private Entry<K, V>[] buckets;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }

    public void clear() {
        this.buckets = new Entry[10];
        size=0;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);

        size++;

        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            kvEntry.setNextEntry(buckets[bucketNumber]);
            buckets[bucketNumber] = kvEntry;
        }
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;
        size--;
        Entry<K, V> previousEntry = buckets[bucketNumber];
        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            V v = checkEquals(currentEntry, key);
            if (v != null) {
                //delete
                if(!previousEntry.getKey().equals(currentEntry.getKey())) {
                    previousEntry.setNextEntry(currentEntry.getNextEntry());
                }else{
                    previousEntry.setNextEntry(currentEntry.getNextEntry());
                }
                currentEntry.setKey(null);
                currentEntry.setValue(null);
                return;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
        //delete
        currentEntry.setKey(null);
        currentEntry.setValue(null);
        previousEntry.setNextEntry(currentEntry.getNextEntry());
        return;

    }

    public V get(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            V v = checkEquals(currentEntry, key);
            if (v != null)
                return v;

            currentEntry = currentEntry.getNextEntry();
        }
        return checkEquals(currentEntry, key);
    }

    private V checkEquals(Entry<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }
}
