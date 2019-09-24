import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>
{
    private final int maxCapacity;

    private static final float DEFAULT_LOAD_FACTOR=0.75f;

    private final Lock lock=new ReentrantLock();

    public LRULinkedHashMap(int maxCapacity)
    {
        super(maxCapacity,DEFAULT_LOAD_FACTOR,true);
        this.maxCapacity=maxCapacity;
    }

    //实现LRU的主要方法，实现removeEldestEntry方法
    //当put时size+1，size大于最大容量时返回true，并删除头元素
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
    {
        return size()>maxCapacity;
    }

    @Override
    public boolean containsKey(Object key)
    {
        try
        {
            lock.lock();
            return super.containsKey(key);
        }finally
        {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key)
    {
        try
        {
            lock.lock();
            return super.get(key);
        }finally
        {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value)
    {
        try
        {
            lock.lock();
            return super.put(key, value);
        }finally
        {
            lock.unlock();
        }
    }

    @Override
    public int size()
    {
        try
        {
            lock.lock();
            return super.size();
        }finally
        {
            lock.unlock();
        }
    }

    @Override
    public void clear()
    {
        try
        {
            lock.lock();
            super.clear();
        }finally
        {
            lock.unlock();
        }

    }

    public Collection<Map.Entry<K,V>> getAll()
    {
        try
        {
            lock.lock();
            return new ArrayList<>(super.entrySet());
        }finally
        {
            lock.unlock();
        }
    }


    public static void main(String[] args)
    {
        LRULinkedHashMap<Integer,String> lruLinkedHashMap=new LRULinkedHashMap<>(3);

        lruLinkedHashMap.put(1,"aa");
        System.out.println(lruLinkedHashMap);
        lruLinkedHashMap.put(2,"bb");
        System.out.println(lruLinkedHashMap);
        lruLinkedHashMap.put(3,"cc");
        System.out.println(lruLinkedHashMap);
        lruLinkedHashMap.put(4,"dd");
        System.out.println(lruLinkedHashMap);
        lruLinkedHashMap.get(3);
        System.out.println(lruLinkedHashMap);

    }
}
