package user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@NoArgsConstructor
	@AllArgsConstructor
	@Setter
	@Getter
	@ToString

	public class MemberDTO {
		private String userid;
		private String password;
		private String changePassword;
		private String name;
		private String gender;
		private String email;
	}
	
