package oopsdesign;

import java.util.ArrayList;
import java.util.List;

public class MementoPattern {

	public static void main(String[] args) {
		
		CareTaker careTaker = new CareTaker();
		FileUtil filetutil1 = new FileUtil("name1","content1");
		careTaker.add(filetutil1.save());
		FileUtil filetutil2 = new FileUtil("name2","content2");
		careTaker.add(filetutil2.save());
		
		System.out.println("content: "+careTaker.undoLast().content +" filaname: " + careTaker.undoLast().fileName);

	}

}

class CareTaker {

	List<Memento> list = new ArrayList<Memento>();

	void add(Memento memento) {
		this.list.add(memento);
	}
	
	FileUtil undoLast() {
		if(list.size()>=2) {
		return list.get(list.size()-2).fileUtil;
		}
		return list.get(list.size()-1).fileUtil;
	}

}

class FileUtil {

	String fileName;
	String content;
	
	FileUtil(String fileName,String content){
		this.fileName=fileName;
		this.content=content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	Memento save() {
		System.out.println("saving: "+"filename: "+fileName +" content: "+content);
		return new Memento(this);
	}

}

class Memento {
	FileUtil fileUtil;

	public Memento(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public FileUtil getFileUtil() {
		return fileUtil;
	}

	public void setFileUtil(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}
}
