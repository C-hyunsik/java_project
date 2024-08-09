package member.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class MemberDTO {
	@NonNull
	private String name;
	@NonNull
	private String id;
	@NonNull
	private String pw;
	@NonNull
	private String phone;
}
