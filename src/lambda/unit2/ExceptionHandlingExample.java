package lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		
		int[] intArray = {1, 2, 3, 4};
		int key = 2;
		
		process(intArray, key, exceptionWrapper((a, b) -> System.out.println(a / b)));
	}

	private static void process(int[] intArray, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : intArray) {
			biConsumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> exceptionWrapper(BiConsumer<Integer, Integer> biConsumer) {
		
		return (x, y) -> {
			try {
				System.out.println("\n# Executing from inside the wrapper...");
				biConsumer.accept(x, y);
			} catch (Exception e) {
				System.out.println("Execption caught inside the wrapper!");
			}
		};
	}
}
