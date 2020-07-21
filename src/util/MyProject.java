package util;


import java.util.ArrayList;
import java.util.Scanner;
import util.Util;

public class MyProject {
	static ArrayList<Article> list = new ArrayList<Article>();
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String cmd = null;
//		String store = null;
		
		int id = 4;
		Article article1 = new Article();
		article1.id = 1;
		article1.title = "테스트용 제목1";
		article1.body = "테스트용 내용1";
		article1.regDate = Util.getCurrentDate();
		
		Article article2 = new Article(2, "제목2", "내용2", Util.getCurrentDate());
		Article article3 = new Article(3, "제목3", "내용3", Util.getCurrentDate());
		
		list.add(article1);
		list.add(article2);
		list.add(article3);
		
				
	
		
		
		while (true) {
			System.out.println("명령어를 입력해주세요 : ");
			cmd = sc.nextLine();
			if(cmd.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
			if(cmd.equals("help")) {
				System.out.println("add : 데이터 저장");
				System.out.println("read : 데이터 읽기 또는 조회");
				System.out.println("update : 데이터 수정");
				System.out.println("delete : 데이터 삭제");
			}
			
			if(cmd.equals("add")) {
				Article article = new Article();
				article.id = id;
				id++;
				
				System.out.println("어떤 데이터를 저장하시겠습니까? : ");
				String title = sc.nextLine();
				article.title = title;
				
				article.regDate = Util.getCurrentDate();
				
				list.add(article);
				System.out.println("게시물이 등록되었습니다.");
			}
			
			if(cmd.equals("read")) {
				System.out.println("========게시물 목록========");
				for(int i = 0; i < list.size(); i++) {
					System.out.println("번호 : " + list.get(i).id);
					System.out.println("제목 : " + list.get(i).title);
					
					String str = list.get(i).regDate;
					String [] arr = str.split(" ");
					System.out.println("작성일 : " + arr[0]);
				}
			
			}
			
			if(cmd.equals("update")) {
				System.out.println("어떤 데이터를 수정하시겠습니까 : ");
				int num = Integer.parseInt(sc.nextLine());
				Article targetlist = get_article_by_id(num); 
			
				if (targetlist != null) {  // 만약 targetlist에 값이 있으면,
					System.out.println("수정할 제목을 입력해주세요 : ");
					String updated_title = sc.nextLine();
					targetlist.title = updated_title;
					System.out.println("수정이 완료되었습니다.");
				} else {
					System.out.println("없는 게시물 번호입니다.");
				}
				}
				
			if(cmd.equals("delete")) {
				System.out.println("어떤 게시물을 삭제하시겠습니까? : ");
				
				int num = Integer.parseInt(sc.nextLine());
				Article targetlist = get_article_by_id(num);
				
				if (targetlist != null) {
					list.remove(targetlist);
					System.out.println("데이터가 삭제되었습니다.");
				} else {
					System.out.println("없는 게시물 번호입니다.");
				}		
			}
		}
	}
	public static Article get_article_by_id(int id) {  // 다른문구에 도입할때 : get_article_by_id(입력할 값)
		Article article = null;
		for (int i = 0; i < list.size(); i++) {
			
			Article target = list.get(i);
			
			if(target.id == id) { // 만약 target의 id와 다른id와 같다면 멈춰라.
				article = target; // article은 target과 같다.
				break;
			}
		}
		return article; // article의 값을 돌려받는다.
	}
		

}

class Article {  // 데이터를 한곳에 담는 [데이터class]를 만든다.
	int id;
	
	String title;
	String body;
	String regDate;
	
	Article() {
		
	}
	
	Article(int id, String title, String body, String regDate) { // 생성자(지역변수)
		this.id = id;    // this는 현재안에있는 클래스를 가리킨다. 멤버id와 지역id를 헷갈릴 수 있기때문.
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		
	}
}


