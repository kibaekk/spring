package com.itwillbs.mvc_board.mapper;

import com.itwillbs.mvc_board.vo.MemberVO;

//Service 객체에서 사용할 메서드 형태를 추상메서드로 갖는 Mapper 인터페이스 정의
// DAO 클래스 대신 사용 가능
// -> MyBatis 와 연동할 xml 파일과 연결되어 자동으로 사용됨
// -> 정의된 추상메서드는 XML 파일의 id 속성값과 같아야 함!
// Mapper 인터페이스도 Service 클래스에서 @Autowired 어노테이션을 적용 가능



public interface MemberMapper { //인터페이스는 body가 없음 
	//1. 회원가입에 필요한 insertMember() 메서드 정의
	// -> 파라미터 : MemberVO 객체 리턴타입 :int
	public int insertMember(MemberVO member);

}
