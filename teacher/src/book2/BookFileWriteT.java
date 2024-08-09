package book2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class BookFileWriteT implements BookT {

	@Override
	public void execute(List<BookDTOT> list) {
		System.out.println();
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));
			//List를 파일에 저장
			oos.writeObject(list);
			
			//List를 BookDTO 꺼내서 파일에 저장
			/*
			for(BookDTOT bookDTOT : list) {
				oos.writeObject(bookDTOT);
				
				
			}//for
			*/
			oos.close();
			System.out.println("파일 저장이 완료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
