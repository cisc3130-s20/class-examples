
class Film {
   String filmName;
   int releaseYear;
   Film next;
   Film prev;

   // constructor
   Film(String title, int year){
     filmName = title;
     releaseYear = year;
   }

   public void displayMovieMeta(){
     System.out.println(filmName + ", " + releaseYear);
   }
}

class FilmCollection {
   private Film first;
   private Film last;

   //constructor
   FilmCollection(){
     first = null;
     last = null;
   }
   // checks if the list is empty
   public boolean isEmpty(){
    return (first == null);
   }
   public void find(int key){
     int counter = 0;
     // start from the first node 
     Film current = first; 
     while(current != null){
     // check if key matches the year
     if (current.releaseYear == key){
      System.out.println("FOUND IT! " + current.filmName + " counter " + counter);
     }
     counter += 1;
     // if it doesn't match, 
     // move to the next node 
     current = current.next;
     } //ends while loop
  } // ends find
  public void size(){
     int counter = 0;
     // start from the first node 
     Film current = first; 
     while(current != null){
     // move forward if not at the end
     counter += 1;
     
     // move to the next node 
     current = current.next;
     } //ends while loop

    System.out.println("size = " + counter);
  } // ends find

   //display list starting from first
   public void displayList(){
     //start from the first element 
     Film current = first;
     // while loop (while not at the end)
     while(current != null){
     // display the node contents
      current.displayMovieMeta();
      current = current.next;
     }
   }
   // display list backwards starting from last
   public void displayListBackwards(){
     // start from the last node of the list 
     Film current = last;
     while(current != null){
       current.displayMovieMeta();
     // move to that node's previous 
       current = current.prev;
     }
   }
   public void insertFirst(String filmName, int releaseYear){ 
    // Create the new node
    Film newNode = new Film(filmName, releaseYear);
    if( isEmpty() ) 
      last = newNode;
    // set the new node's next to first
    newNode.next = first;
    // first is the new node
    first = newNode;
   }

   public void insertLast(String filmName, int releaseYear){
     // Create the new node
    Film newNode = new Film(filmName, releaseYear);
    // last.next is pointing the new node 
    if (isEmpty())
      first = newNode;
    else{
      last.next = newNode;
      newNode.prev = last;
    }
    //new node is the last node
    last = newNode;
    
   }
}

class FilmMain {
  public static void main(String[] args) {
    FilmCollection watchList = new FilmCollection();
    System.out.println(watchList.isEmpty());
    // watchList.insertFirst("The Matrix", 1999);
    System.out.println(watchList.isEmpty());

    // watchList.insertFirst("The Matrix Reloaded", 2003);
    // watchList.insertFirst("Bad Boys 3", 2020);
    // watchList.insertFirst("Iron Man", 2008);
    watchList.insertLast("Frozen", 2013);
    watchList.insertLast("Joker", 2019);
    watchList.insertLast("Star Wars", 2019);
    // watchList.displayList();
    // watchList.find(2020);
    // watchList.find(2019);
    // watchList.find(1990);
    watchList.size();
    watchList.displayListBackwards();
  }
}
