
public class Matrix3x3 {
	// field
		double[][] 		matrix = new double[3][3];
		//constructor
		
		public Matrix3x3(){	
			for(int r=0; r < 3; r++)
				for(int c=0; c < 3; c++)
					matrix[r][c] = 0.0;	
		}// End of Matrix3x3
		
		public Matrix3x3(double[][] m){
	        for(int i=0; i<3; i++){
	            for(int j=0; j<3; j++){
	                matrix[i][j] = m[i][j];
	            }
	        }
		}// End of Matrix3x3
		//operations
		
		public void Identity(){
			for(int r=0; r < 3; r++){
				for(int c=0; c < 3; c++){
					if(r==c) matrix[r][c] = 1.0;
					else     matrix[r][c] = 0.0;
				}// End of for-loop
			}// End of for-loop
		} // End of Identity
		
	 	public void Multiplication(double[][] m){
	 		double[][] result = new double[3][3];
	 		for(int r = 0; r < 3; r++) {
	 			for(int c = 0; c < 3; c++) {
	 				result[r][c] = 0;
	 				for(int k = 0; k < 3; k++) {
	 					result[r][c] += matrix[r][k] * m[k][c];
	 				}
	 				
	 			}
	 			
	 		}
	 		matrix = result;
	 	}	
		public void Transpose(){
			double[][] result = new double[3][3];
	        for(int i=0; i<3; i++){
	            for(int j=0; j<3; j++){
	                result[i][j] = matrix[j][i];
	            }
	        }
	        matrix = result;
		}// End of Transpose
		
		public double Determinant(){
	        double det = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2])
	                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[2][0] * matrix[1][2])
	                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1]);
	        return det;
		}// End of Determinant
		
		public boolean Inverse(){
			double det = Determinant();
	        if(det == 0) return false;
	        double[][] result = new double[3][3];
	        result[0][0] = (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2]) / det;
	        result[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) / det;
	        result[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / det;
	        result[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) / det;
	        result[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / det;
	        result[1][2] = (matrix[1][0] * matrix[0][2] - matrix[0][0] * matrix[1][2]) / det;
	        result[2][0] = (matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1]) / det;
	        result[2][1] = (matrix[2][0] * matrix[0][1] - matrix[0][0] * matrix[2][1]) / det;
	        result[2][2] = (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]) / det;
	        matrix = result;
	        return true;
		}// End of Inverse (Bonus)
		
		public void	Show(){
			 for(int i=0; i<3; i++){
			        for(int j=0; j<3; j++){
			            System.out.print(matrix[i][j] + " ");
			        }
			        System.out.println();
			    }
		}// End of Matrix3x3::Show
	}// End of Matrix3x3 class

