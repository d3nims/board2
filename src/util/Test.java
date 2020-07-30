package util;


	import java.util.ArrayList;
	import java.util.Scanner;

	public class Test {
		
		public static void main(String[] args ) {
			
			// 테스트 게시물 100개
			ArrayList<Article> testList = new ArrayList<>();
			for(int i = 1; i <= 100; i++) {
				Article article = new Article(i, "제목"+i, "내용2"+i, "2020-07-29 09:49:00", 30, null);
				testList.add(article);
			}

			int currentPageNo = 1;
			int totalCountOfArticle = testList.size();
			int articlesPerPage = 3;
			
			int lastPage = totalCountOfArticle / articlesPerPage + 1; 
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				int startIndex = (currentPageNo - 1) * articlesPerPage;
				int endIndex = startIndex + articlesPerPage;
				
				for(int i = startIndex; i < endIndex; i++) {
					System.out.println("번호 : " + testList.get(i).id);
					System.out.println("제목 : " + testList.get(i).title);
					System.out.println("내용 : " + testList.get(i).body);
				}
				// 페이징
				int startPage = currentPageNo - 2;
				if(startPage <= 0) {
					startPage = 1;
				} 
				System.out.print(1 + " ... ");
				for(int i = startPage; i < startPage + 5; i++) {
					if(i == currentPageNo) {
						System.out.print("[" + i + "] ");
					} else {
						System.out.print(i + " ");
					}
				}
				System.out.print("... " + lastPage + "\n");
				
				System.out.println("1.next    2.prev");
				int cmd = Integer.parseInt(sc.nextLine());
				if(cmd == 1) {
					currentPageNo++;
				} else if(cmd == 2) {
					currentPageNo--;
				}
			}
			
		}
	}