public class MySet{
  MyLinkedList<PageEntry> listofpages = new MyLinkedList<PageEntry>();

  public void addElement(PageEntry element){
    this.listofpages.Insert(element);
  }

  public MySet union(MySet otherSet){
    Node temp = this.listofpages.front;
    while(temp != null){
      if(otherSet.listofpages.isMember(temp.data)==false)
      otherSet.listofpages.Insert(temp.data);
      temp = temp.next;
    }
    return otherSet;
  }

  public MySet intersection(MySet otherSet){
    Node temp = otherSet.listofpages.front;
    while(temp!=null){
      if(this.listofpages.isMember(temp.data) == false)
      otherSet.listofpages.Delete(temp.data);
      temp = temp.next;
    }
    return otherSet;
  }
}
