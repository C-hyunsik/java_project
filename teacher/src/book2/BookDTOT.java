package book2;


import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BookDTOT implements Serializable {
	@NonNull
	private String code;
	@NonNull
	private String title;
	@NonNull
	private String author;
	@NonNull
	private int price;
	@NonNull
	private int qty;
	private int total;

	public String toString() {
		return code + "\t" + title + "\t" + author + "\t" + price + "\t" + qty + "\t" + total;
	}

	/*
	@Override
	public int compareTo(BookDTOT b) {
		return this.title.compareTo(b.title);
	}
	*/

}
