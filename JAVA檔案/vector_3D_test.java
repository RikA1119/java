package J3;

public class vector_3D_test {
	public static void main( String args[]){
		vector_3D v1 = new vector_3D();
		v1.show();

		vector_3D v2 = new vector_3D(1.0, 2.0, 3.0);
		v2.show();

		vector_3D v3 = new vector_3D(4.0, 5.0, 6.0);
		v3.show();

		v1.add(v2);	v1.show();

		v1.sub(v3);	v1.show();

		v1.mul(2.0);	v1.show();
		double inner_product  = v1.inner(v2);
		System.out.printf("inner product:%.2f\n", inner_product);
			
		v1.cross(v2);
		v1.show();

		}
	

}
