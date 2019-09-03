import java.util.Scanner;
public class SearchEngine{
  InvertedPageIndex webset;
  public SearchEngine(){
    this.webset = new InvertedPageIndex();
  }

  public void performAction(String actionMessage){
    Scanner s = new Scanner(actionMessage);
    String action = s.next();
    if(action.equals("addPage"))
    {
      String x = s.next();
      PageEntry tempo = new PageEntry(x);
      this.webset.addPage(tempo);
    }

    else if(action.equals("queryFindPagesWhichContainWord"))
    {
      String x = s.next();
      Node temp = ((MySet)this.webset.getPagesWhichContainWord(x)).listofpages.front;
      if(temp == null) System.out.println("No webpage contains word "+x);
      else
      {
        while(temp != null)
        {
        if(temp.next != null)
        System.out.print(((PageEntry)temp.data).read + ",");
        else
        System.out.println(((PageEntry)temp.data).read);
        temp = temp.next;
        }
      }
    }

    else if(action.equals("queryFindPositionsOfWordInAPage"))
    {
      String x = s.next();
      String y = s.next();
      Node temp1 = this.webset.getPagesWhichContainWord(x).listofpages.front;
      while(temp1!=null&&temp1.data != null)
      {
        if(((PageEntry)temp1.data).name.equals(y))
        {
        Node temp2 = ((PageEntry)temp1.data).getPageIndex().getWordEntries().front;
        while(temp2 != null)
        {
          if(((WordEntry)temp2.data).Word.equals(x))
          {
          Node temp3= ((WordEntry)temp2.data).Indices.front;
          while(temp3 != null)
          {
            if(temp3.next!=null) System.out.print(((Position)temp3.data).WordIndex+",");
            else System.out.print(((Position)temp3.data).WordIndex);
            temp3 = temp3.next;
          }
          }
          temp2 = temp2.next;
        }
      }
      temp1 = temp1.next;
      }
    }
  }
}
