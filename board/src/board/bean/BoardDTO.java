package board.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	@NonNull
	private int seq;
	@NonNull
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String subject;
	@NonNull
	private String content;
	@NonNull
	private String logtime;
}
