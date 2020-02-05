package org.springbatch.batch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springbatch.model.FileData;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyFileWriter implements ItemWriter<FileData> {

	@Value("${output.file.path}")
	String outputFilePath;

    @Override
    public void write(List<? extends FileData> fileData) throws Exception {

        System.out.println("Data Saved form file: " + fileData);
        this.save(fileData);
    }
    
    public void save(List<? extends FileData> fileData) {
        try {
        	System.out.println("outputFilePath = "+outputFilePath);
        	FileWriter writer = new FileWriter(outputFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            for (FileData fileReader : fileData) {
            	bufferedWriter.write(fileReader.getLine());
                bufferedWriter.newLine();
			}
            
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    
}
