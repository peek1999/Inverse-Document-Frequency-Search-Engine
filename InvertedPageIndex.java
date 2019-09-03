  public class InvertedPageIndex{

  MyHashTable damn = new MyHashTable();

  public void addPage(PageEntry p){
    Node temp = p.getPageIndex().getWordEntries().front;
    while(temp != null)
    {
      this.damn.addPositionsForWord((WordEntry)temp.data);
      temp = temp.next;
    }
  }

  public MySet getPagesWhichContainWord(String str){
    int a = this.damn.getHashIndex(str);HashNode head=null;
    try{ head = this.damn.bucketArray.get(a);} catch (Exception en){head=null;}
    MySet ret = new MySet();
    while(head != null)
    {
      System.out.println("abc");
      if(head.key.equals(str))
      {
        Node pages = head.value.Indices.front;
        PageEntry temporary = null;
        while(pages != null)
        {
          if(temporary != ((Position)pages.data).page)
          {
          ret.addElement(((Position)pages.data).page);
          temporary = ((Position)pages.data).page;
          }
          pages = pages.next;
        }
      }
      head = head.next;
    }
    return ret;
  }
}
