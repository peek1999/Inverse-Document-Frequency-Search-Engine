import java.util.*;
import java.io.*;
import java.util.ArrayList;

class HashNode
{
  String key;
  WordEntry value;

  HashNode next;

  public HashNode(String key, WordEntry value){
    this.key = key;
    this.value = value;
  }
}
public class MyHashTable
{
  ArrayList<HashNode> bucketArray;
  int numBuckets;
  int size;

  public MyHashTable()
  {
    bucketArray = new ArrayList<>();
    numBuckets = 101;
    size = 0;

    for(int i=0; i<numBuckets; i++)
      bucketArray.add(null);
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size() == 0;
  }

  public int getHashIndex(String str){
    int hashCode = str.hashCode();
    int index = hashCode % numBuckets;
    return index;
  }

  public WordEntry get(String str)
  {
    int bucketIndex = getHashIndex(str);
    HashNode head = bucketArray.get(bucketIndex);
    while(head != null)
    {
      if(head.key.equals(str)) return head.value;
      head = head.next;
    }
    return null;
  }

  public void addPositionsForWord(WordEntry w)
  {
    String str = w.Word;
    int bucketIndex = getHashIndex(str);
    HashNode head = bucketArray.get(bucketIndex);

    while(head != null)
    {
      if(head.key.equals(str))
      {
        head.value.addPositions(w.Indices);
        return;
      }
      head = head.next;
    }

    size++;
    head = bucketArray.get(bucketIndex);
    HashNode newNode = new HashNode(str, w);
    newNode.next = head;
    bucketArray.set(bucketIndex, newNode);
    }

  }
