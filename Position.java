public class Position{
  PageEntry page;
  int WordIndex;
  Position(PageEntry p, int wordIndex){
    this.page = p;
    this.WordIndex = wordIndex;
  }

  public PageEntry getPageEntry(){
    return this.page;
  }

  public int getWordIndex(){
    return this.WordIndex;
  }

}
