
public class MatrixTest {
	// main method begins execution of Java application
	
		public static void main( String args[] ){
			// test identity	
			System.out.printf("[---Test Identity Operation---] \n");
			Matrix3x3 matrixIdentity = new Matrix3x3();
			matrixIdentity.Identity();
			matrixIdentity.Show();

			// test transpose
			System.out.println("Test transpose:");
	        Matrix3x3 m2 = new Matrix3x3(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
	        m2.Transpose();
	        m2.Show();
	        
			// test multiply
	        System.out.println("Test multiply:");
	        Matrix3x3 m3 = new Matrix3x3(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
	        Matrix3x3 m4 = new Matrix3x3(new double[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
	        m3.Multiplication(m4.matrix);
	        m3.Show();
	        
			// test determinant
	        System.out.println("Test determinant:");
	        Matrix3x3 m5 = new Matrix3x3(new double[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}});
	        double det = m5.Determinant();
	        System.out.println("Determinant: " + det);
	        
			// test inverse
	        System.out.println("Test inverse:");
			double[][] inverse={{4.0, 0.0, 0.0}, {4.0, -2.0, 5.0}, {2.0, 8.0, 7.0}};
			Matrix3x3 matrixInverse = new Matrix3x3(inverse);
			matrixInverse.Show();

			if(matrixInverse.Inverse() == true){
					matrixInverse.Show();
					// verify the inverse
					matrixInverse.Multiplication(inverse);
					matrixInverse.Show();
			}
			else
			{
					System.out.printf("This matrix has no inverse\n");
			}//End of if-condition
		}// End of main class
}// End of MatrixTest

