package util;

import java.util.ArrayList;
import java.util.Scanner;

import util.Util;

public class BoardApp {
	ArrayList<Article> articles = new ArrayList<Article>();
	

	void start() {
		
		Scanner sc = new Scanner(System.in);
		String cmd = null;
//		String store = null;
		
		int id = 4;
		Article article1 = new Article();
		article1.id = 1;
		article1.title = "테스트용 제목1";
		article1.body = "테스트용 내용1";
		article1.regDate = Util.getCurrentDate();
		article1.hit = 20;
		
		Article article2 = new Article(2, "제목2", "내용2", Util.getCurrentDate(),30);
		Article article3 = new Article(3, "제목3", "내용3", Util.getCurrentDate(),5);
		
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
		print_articles(articles);
		
				

		
		while (true) {
			System.out.println("명령어를 입력해주세요 : ");
			cmd = sc.nextLine();
			if(cmd.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
			if(cmd.equals("help")) {
				System.out.println("add : 데이터 저장");
				System.out.println("list : 게시물 목록 조회");
				System.out.println("detail : 게시물 상세 조회");
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
				
//				System.out.println("내용을 입력해주세요");
//				String body = sc.nextLine();
//				bodies.add(body);
//				article.body = body;
				
				articles.add(article);
				System.out.println("게시물이 등록되었습니다.");
				
			}
			
			if(cmd.equals("list")) {
				print_articles(articles);
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
					articles.remove(targetlist);
					System.out.println("데이터가 삭제되었습니다.");
				} else {
					System.out.println("없는 게시물 번호입니다.");
				}		
			}
			
			if(cmd.equals("search")) {
				System.out.println("검색 항목을 선택해주세요. : 1.제목, 2.내용");
				int searchFlag = Integer.parseInt(sc.nextLine());
				System.out.println("검색어를 입력해주세요");
				String keyword = sc.nextLine();
				ArrayList<Article> searchedArticles = new ArrayList<>();
				
				if(searchFlag == 1) {
					for(int i = 0; i < articles.size(); i++) {
						if(articles.get(i).title.contains(keyword)) {
							searchedArticles.add(articles.get(i));
						}
					}
				} else if(searchFlag == 2) {
					for (int i = 0; i < articles.size(); i++) {
						if(articles.get(i).body.contains(keyword)) {
							searchedArticles.add(articles.get(i));
						}
					}
				}
				print_articles(searchedArticles);
			}
			
			if(cmd.equals("detail")) {
				System.out.println("게시물 번호를 입력해주세요.");
				int articleId = Integer.parseInt(sc.nextLine());
				Article article = get_article_by_id(articleId);
				
				if(article == null) { // article값이 아무것도 없을때,
					System.out.println("없는 게시물입니다."); // "없는 게시물입니다." 라고 출력한다.
				} else {
					article.hit++;
					print_article(article);
					
				}
			}
			
		}
	}
	
	public void print_article(Article article) {
		System.out.println("=========게시물 상세=========");
		System.out.println("번호 : " + article.id);
		System.out.println("제목 : " + article.title);
		System.out.println("내용 : " + article.body);
		System.out.println("조회수 : " + article.hit);
	}
	
	public void print_articles(ArrayList<Article> articles) {
		System.out.println("========게시물 목록========");
		for(int i = 0; i < articles.size(); i++) {
			System.out.println("번호 : " + articles.get(i).id);
			System.out.println("제목 : " + articles.get(i).title);
			
			String str = articles.get(i).regDate;
			String [] arr = str.split(" ");
			System.out.println("작성일 : " + arr[0]);
			System.out.println("조회수 : " + articles.get(i).hit);		
	}
}
	
	public Article get_article_by_id(int id) {  // 다른문구에 도입할때 : get_article_by_id(입력할 값)
		Article article = null;
		for (int i = 0; i < articles.size(); i++) {
			
			Article target = articles.get(i);
			
			if(target.id == id) { // 만약 target의 id와 다른id와 같다면 멈춰라.
				article = target; // article은 target과 같다.
				break;
			}
		}
		return article; // article의 값을 돌려받는다.
	}
		

}
