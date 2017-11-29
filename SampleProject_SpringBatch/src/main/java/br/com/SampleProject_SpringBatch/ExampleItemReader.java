package br.com.SampleProject_SpringBatch;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader")
public class ExampleItemReader implements ItemReader<String> {
	
	private String[] stringArray = {"Hello world!", null};
	
	private int index = 0;
	
	/**
	 * Método para ler o próximo item do array.
	 */
	public String read() throws Exception {
		if (index < stringArray.length) {
			return stringArray[index++];
		}else{
			return null;
		}
	}

}