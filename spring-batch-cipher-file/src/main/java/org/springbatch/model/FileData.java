package org.springbatch.model;

public class FileData {

    private String line;

    public FileData(String line) {
        this.line = line;
    }

    public FileData() {
    }

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "File Data [line=" + line + "]";
	}

    
}
