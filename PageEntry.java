import java.util.Scanner;
import java.io.*;
public class PageEntry
{
  PageIndex ind;
  String read;
  String name;
  int wordCount = 0;
  int numofWordEntries;

  PageEntry(String pageName)
  {
    this.numofWordEntries = wordCount;
    this.name = pageName;
    this.ind = new PageIndex();
  }

  public float getTermFrequency(String word)
  {
    Node temp = ((PageIndex)this.ind).wordentries.front;
    int p =0;
    int q = this.numofWordEntries;
    while(temp!=null)
    {
      if(((WordEntry)temp.data).Word == word) p =((WordEntry)temp.data).Indices.size;
      temp = temp.next;
    }
    return p/q;
  }

  public PageIndex getPageIndex()
  {
    try
    {

      FileInputStream fstream = new FileInputStream(this.name);
      Scanner s = new Scanner(fstream);
      while(s.hasNextLine())
      {
        String read1 = s.nextLine();
        String read2 = read1.toLowerCase();
        String read3 = read2.replace("{", " ");
        String read4 = read3.replace("}", " ");
        String read5 = read4.replace("(", " ");
        String read6 = read5.replace(")", " ");
        String read7 = read6.replace("[", " ");
        String read8 = read7.replace("]", " ");
        String read9 = read8.replace("<", " ");
        String read10 = read9.replace(">", " ");
        String read11 = read10.replace("=", " ");
        String read12 = read11.replace(".", " ");
        String read13 = read12.replace(",", " ");
        String read14 = read13.replace(";", " ");
        String read15 = read14.replace("\'", " ");
        String read16 = read15.replace("\"", " ");
        String read17 = read16.replace("?", " ");
        String read18 = read17.replace("#", " ");
        String read19 = read18.replace("!", " ");
        String read20 = read19.replace("-", " ");
        String read21 = read20.replace(":", " ");
        int i = 0;
        String word = "";
        while(i<read21.length())
        {
          if(read21.charAt(i)==' ')
          {
            i++;
          }
          else
          {
          word = word + read21.substring(i,i+1);
          i++;
            if(i<read21.length() && read21.charAt(i) == ' ')
            {
              wordCount++;
              if(word.matches("a|an|the|they|these|this|for|is|are|was|of|or|and|does|will|whose"))
              {
                word = "";
                i++;
              }
              else
              {
                Position p = new Position(this, wordCount);
                if(word.matches("stacks|structures|applications"))
                this.ind.addPositionForWord(word.substring(0, (word.length()-2)), p);
                else
                this.ind.addPositionForWord(word, p);
                i++;
                word = "";
              }
            }
          }
        }
      }
    }
    catch(FileNotFoundException en)
    {
      System.out.println("File counldn't be located.");
    }
    return ind;
  }
}
