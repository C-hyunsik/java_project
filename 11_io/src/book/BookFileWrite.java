package book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookFileWrite implements Book {

	@Override
	public void execute(ArrayList<BookDTO> list) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));
		System.out.println();
		oos.writeObject(list);
		System.out.println("파일 저장이 완료되었습니다.");
		oos.close();
	}

}
