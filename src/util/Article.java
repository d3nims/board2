package util;

class Article {  // 데이터를 한곳에 담는 [데이터class]를 만든다.
	int id;
	
	String title;
	String body;
	String regDate;
	int hit;
	
	
	Article() {
		
	}
	
	Article(int id, String title, String body, String regDate, int hit) { // 생성자(지역변수)
		this.id = id;    // this는 현재안에있는 클래스를 가리킨다. 멤버id와 지역id를 헷갈릴 수 있기때문.
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = hit;
		
	}
}
