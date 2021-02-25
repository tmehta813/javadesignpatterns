package oopsdesign;

import java.util.ArrayList;

public class CompositDesignPattern {
	
	public static void main(String[] args) {
		
		File file1 = new Text(20);
		File file2 = new Text(30);
		
		System.out.println(file1.getSize());
		System.out.println(file2.getSize());
		
		Directory directory = new Directory();
		Directory directory1 = new Directory();
		directory1.addFile(new Text(50));
		directory.addFile(file1,file2,directory1);
		System.out.println(directory.getSize());
	}

}


interface File {
	String getFileType();
	int getSize();
}


class Text implements File {
	int size = 0;
	
	Text(int size){
	this.size = size;	
	}

	@Override
	public String getFileType() {
		return ".txt";
	}

	@Override
	public int getSize() {
		return size;
	}
	
}


class Directory implements File {
	
	ArrayList<File> files = new ArrayList<File>();
	
	void addFile(File... files) {
		for(File file:files) {
			this.files.add(file);
		}
	}
	

	@Override
	public String getFileType() {
		return ".dir";
	}

	@Override
	public int getSize() {
		int size =0 ;
		
	 for(File file : files) {
		 size += file.getSize();
	 }

		return size;
	}
	
}
