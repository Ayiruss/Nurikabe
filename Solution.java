import java.util.Scanner;

/*
 * Complete the function below.
 */
import java.util.Scanner;
class Nurikabe{
	
	static int count = 0;
	public static void main(String[] args) {
		String [][] puzzle = new String[5][5];
		Scanner in = new Scanner(System.in);
		for(int i = 0;i<5;i++) {
			for(int j=0;j<5;j++) {
				puzzle[i][j] = in.next();
			}
		}
		System.out.println(verify(puzzle));
	}

    static boolean verify(String[][] puzzle) {

	int r = puzzle.length;
		for(int i=0; i< r;i++) {
			for(int j=0;j<r;j++) {
				String ch = puzzle[i][j];
				if(ch.equals(".")){
					if(isCube(puzzle, i ,j))
						return false;
				}
				else if(!ch.equals("#")) {
					if(!isValidNumberOfSquares(puzzle,i,j))
						return false;
				}
           
				
			}
		}
		return true;
    }

	static boolean isValidNumberOfSquares(String[][] puzzle, int i, int j) {
		int ln = puzzle.length;
        int num= 1;
        try{
		 num = Integer.parseInt(puzzle[i][j]);
  
        }
        catch(Exception e){
            return false;
        }
		int count =0;
		String island = "#";
		if(i!=0 && island.equals(puzzle[i-1][j])) count ++;
		if(j!=0 && island.equals(puzzle[i][j-1])) count ++;
		if(i!=ln-1 && island.equals(puzzle[i+1][j])) count ++;
		if(j!=ln-1 && island.equals(puzzle[i][j+1])) count ++;
		if(count == num-1) return true;
		else return false;
	}
	static boolean isCube(String[][] puzzle, int i, int j) {
		int ln = puzzle.length;
		String dot = ".";
		if(i+1!=ln && j+1!=ln) {
		if(dot.equals(puzzle[i][j]) && dot.equals(puzzle[i+1][j]) && dot.equals(puzzle[i][j+1])&&dot.equals(puzzle[i+1][j+1])){
			return true;
		}
		
		}
		return false;
}

	}
