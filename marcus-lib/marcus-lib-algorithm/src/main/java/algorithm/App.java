package algorithm;
import java.util.Arrays;

import edu.princeton.cs.algs4.*;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void draw1(){
		int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        for(int i = 1; i <= N; i++){
        	StdDraw.point(i, i);
        	StdDraw.point(i, i*i);
        	StdDraw.point(i, i*Math.log(i));
        }
	}
	
	public static void draw2(){
		int N = 50;
		double[] a = new double[N];
		for(int i = 0; i < N; i++){
			a[i] = StdRandom.random();
		}
		for(int i = 0; i < N; i++){
			double x = 1.0*i/N;
			double y = a[i]/2.0;
			double rw = 0.5/N;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	public static void draw3(){
		int N = 50;
		double[] a = new double[N];
		for(int i = 0; i < N; i++){
			a[i] = StdRandom.uniform();
		}
		Arrays.sort(a);
		for(int i = 0; i < N; i++){
			double x = 1.0*i/N;
			double y = a[i]/2.0;
			double rw = 0.5/N;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
    public static void main( String[] args )
    {
        draw3();
    }
}
