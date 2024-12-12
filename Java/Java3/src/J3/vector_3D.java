package J3;

public class vector_3D {
	
	private double x;
	private double y;
	private double z;
	
	public vector_3D() {
		
		x = 0.0; 
		y = 0.0; 
		z = 0.0;
		
		}
	
	public vector_3D(double a, double b, double c) {
		
		x = a;
		y = b;
		z = c;
		
		}
	
	void add(vector_3D vector) {
		
		x = vector.x + x;
		y = vector.y + y;
		z = vector.z + z;
		
	}// add()

	void sub(vector_3D vector) {
		
		x = x - vector.x;
		y = y - vector.y;
		z = z - vector.z;
		
	}// sub()

	void mul(double scale) {
		
		x = scale * x;
		y = scale * y;
		z = scale * z;
		
	}// mul()

	double inner(vector_3D vector) {
		
		double inner_x,inner_y,inner_z,inner_t;
		
		inner_x = vector.x * x;
		inner_y = vector.y * y;
		inner_z = vector.z * z;
		inner_t = inner_x + inner_y + inner_z;
		
		return inner_t;
	}// inner()

	void cross(vector_3D vector) {
		
		double cross_x, cross_y, cross_z;
		
		cross_x = y * vector.z - z * vector.y;
		cross_y = z * vector.x - x * vector.z;
		cross_z = x * vector.y - y * vector.x;
		 x = cross_x;
	     y = cross_y;
	     z = cross_z;
		
	}// cross()

	void show() {
		
		System.out.printf("(%f , %f , %f)\n", x, y, z);
		
	}// show()

}