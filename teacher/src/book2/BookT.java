package book2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BookT {
	//추상메소드
	public void execute(List<BookDTOT> list) throws IOException, ClassNotFoundException;
}
