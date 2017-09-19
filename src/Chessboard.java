/** P 291 project 9: Chessboard.java  */

public class Chessboard {

   public String[][] squares;

   public Chessboard() {        // create an empty chessboard

     squares = new String[8][8];
     for (int row=0; row<8; row++){
         for (int column=0; column<8 ;column++){
            squares[row][column]= "O";
        }}}

   public boolean checkSquare(int row, int column) {

      for (int i = 0; i < row; i++) {  // check the column if there is any queen
         if (squares[i][column] == "X") {
            return false;
         }}
      for (int i = row, j = column; i >= 0 && j < 8; i--, j++) { // check the first diagonal
         if (squares[i][j] == "X") {
            return false;
         }}
       for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) { // check the second diagonal
          if (squares[i][j] == "X") {
             return false;
         }}
      return true;
   }

   public boolean placeQueen() {
      return placeQueen(0);      // start placing queens from the first row
   }

   public boolean placeQueen(int row) {

     if(row==8){          // queens placed in all rows
         return true;
      }
     else{
        for (int column = 0; column < 8; column++) {
            if (checkSquare(row, column)) {
               squares[row][column] = "X";
              if(placeQueen(row+1)){
                  return true;
               }
               squares[row][column]="O";
           }}}
     return false;
   }

   public void printQueen() {
     if(placeQueen()){
        for (int row = 0; row < 8; row++) {
           for (int column = 0; column < 8; column++) {
              System.out.print(squares[row][column]+" ");
            }
            System.out.println();
         }}}

   public static void main(String[] args) {

      Chessboard myChessBoard = new Chessboard();
      myChessBoard.printQueen();    }

}
