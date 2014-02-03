/**
 * 
 */
package com.algorithmHelper;

import java.util.ArrayList;
import java.util.List;

import com.portal.Name;
import com.portal.User;

/**
 * @author Kaibo
 * 
 */
public class PerformanceHelper {
	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		// I assume you will know how to create a object Person yourself...
		List<User> list = new ArrayList<User>();
		for (int i = 0; i <= 1000000; i++) {
			list.add(new User(new Name("Jim", "Knopf"), i));
		}
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.printf("It takes %sms to finish the operation.%n",
				elapsedTime);

		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.printf("Used memory is megabytes: %dM memory.%n",
				bytesToMegabytes(memory));
	}
}
