package book2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class BookFileReadT implements BookT {

	@Override
	public void execute(List<BookDTOT> list) {
		System.out.println();
		
		list.clear();	//list안의 항목 지우기
		
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
			
			//파일에서 List 꺼내오기
			List<BookDTOT> loadList = (List<BookDTOT>)ois.readObject();
			for(BookDTOT bookDTOT : loadList) {
				list.add(bookDTOT);
			}
			
			
			//파일에서 BookDTO 꺼내오기
			
			/*
			while(true) {
				try {
					BookDTOT bookDTOT = (BookDTOT)ois.readObject();
					list.add(bookDTOT);
				}catch(EOFException e) {
					break;
				}
			}//while
			*/
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("파일에서 모든 항목을 로드하였습니다.");
		
	}

}
