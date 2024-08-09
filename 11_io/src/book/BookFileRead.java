package book;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BookFileRead implements Book {

	@Override
	public void execute(ArrayList<BookDTO> list) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
		System.out.println();
		list = (ArrayList<BookDTO>)ois.readObject();
		
		System.out.println("파일을 불러왔습니다.");
		
		
	}

}
