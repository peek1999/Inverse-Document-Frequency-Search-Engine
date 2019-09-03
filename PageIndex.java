public class PageIndex{
  MyLinkedList<WordEntry> wordentries;
  PageIndex()
  {
    this.wordentries = new MyLinkedList<WordEntry>();
  }
  public void addPositionForWord(String str, Position p){
    Node temp = this.wordentries.front;
    while(temp!= null){
      if(((WordEntry)temp.data).Word.equals(str)) {
        ((WordEntry)temp.data).addPosition(p);
        break;
      }
      temp = temp.next;
      if(temp == null){
        WordEntry forstr = new WordEntry(str);
        forstr.addPosition(p);
        this.wordentries.Insert(forstr);
      }
    }

  }

  public MyLinkedList<WordEntry> getWordEntries(){
    return this.wordentries;
  }
}
