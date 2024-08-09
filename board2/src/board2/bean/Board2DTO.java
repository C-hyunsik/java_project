package board2.bean;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Board2DTO {
	@NonNull
	private int seq;
	@NonNull
	private String name;
	@NonNull
	private String id;
	@NonNull
	private String subject;
	@NonNull
	private String content;
}
