package org.springbatch.batch;

import org.springbatch.encryption.CaesarCipher;
import org.springbatch.model.FileData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<FileData, FileData> {

    public Processor() {

    }

    @Override
    public FileData process(FileData fileData) throws Exception {
        String line = fileData.getLine();
        String encryptedText = CaesarCipher.encoding(line, 5);
        fileData.setLine(encryptedText);
        System.out.println(String.format("Converted from [%s] to [%s]", line, encryptedText));
        //System.out.println(String.format("Converted from [%s]", line));
        return fileData;
    }
}
