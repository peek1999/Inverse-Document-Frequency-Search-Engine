public class WordEntry{
  String Word;
  MyLinkedList<Position> Indices = new MyLinkedList<Position>();
  WordEntry(String word){
    Word = word;
  }

  public void addPosition(Position position){
    this.Indices.Insert(position);
  }

  public void addPositions(MyLinkedList<Position> positions){
    Node temp = positions.front;
    while(temp.data != null)
    {
      this.Indices.Insert(temp.data);
      temp = temp.next;
    }
  }

  public MyLinkedList<Position> getAllPositionsForThisWord(){
    return this.Indices;
  }


}
