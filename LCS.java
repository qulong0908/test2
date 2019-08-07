package algorithms;

public class LCS {
	public static void main(String[] args){
		String a=new String("fa");
		String b=new String("fa");
		System.out.print(a==b);
//		String X = "ak46deetyyxaz";
//		String Y = "k6dcbtacbzeg";
//		char[] x = X.toCharArray();
//		char[] y = Y.toCharArray();
//		int[][] doubleArray = length(x, y);
//		StringBuilder longCommonSubstring = new StringBuilder();
//		longCommonSubstring = lcs(doubleArray, x, y, x.length, y.length, longCommonSubstring);
//		System.out.println(longCommonSubstring.toString());
	}
	public static int[][] length(char[] x,char[] y){
		int[][] doubleArray = new int[x.length+1][y.length+1];
		for(int i = 1; i <= x.length; i++){
			for(int j = 1;j <= y.length; j++){
				if(x[i-1] == y[j-1]) {
					doubleArray[i][j] = doubleArray[i-1][j-1] + 1;
				}else if(doubleArray[i-1][j] > doubleArray[i][j-1]){
					doubleArray[i][j] = doubleArray[i-1][j];
				}else{
					doubleArray[i][j] = doubleArray[i][j-1];
				}
			}
		}
		return doubleArray;
	}
	public static StringBuilder lcs(int[][] doubleArray, char[] x, char[] y, int xLength, int yLength, StringBuilder longCommonSubstring){
		if(xLength == 0 || yLength == 0){
			return longCommonSubstring;
		}
		if(x[xLength - 1] == y[yLength - 1]){
			longCommonSubstring.append(x[xLength - 1]);
			lcs(doubleArray, x, y, xLength - 1, yLength - 1, longCommonSubstring);
		}else if(doubleArray[xLength][yLength-1] > doubleArray[xLength-1][yLength]){
			lcs(doubleArray, x, y, xLength, yLength - 1, longCommonSubstring);
		}else{
			lcs(doubleArray, x, y, xLength - 1, yLength, longCommonSubstring);
		}
		return longCommonSubstring;
	}

}
