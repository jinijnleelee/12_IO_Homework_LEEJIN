package edu.kr.io.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import edu.kr.io.vo.Book;

public class BookService {

	private Scanner sc = new Scanner(System.in);
	
	private List<Book> bkList = new ArrayList<Book>();
	
	
	public BookService() {
		
		bkList.add(new Book("홍길동", "이민정", 15000,"재림"));
		bkList.add(new Book("달러구트", "박대가리", 90000,"한빛"));
		bkList.add(new Book("떡볶이는 괜찮아", "강사", 2000,"안키"));
	}
	
	
	public void displayMenu() {
	
		int btNum = 0;
	
	do {
		System.out.println("=====도서 목록 프로그램=====");
		System.out.println("1. 도서 등록 ");
		System.out.println("2. 도서 조회 ");
		System.out.println("3. 도서 수정 ");
		System.out.println("4. 도서 삭제 ");
		System.out.println("5. 즐겨찾기 등록");//아직 못했어요....
		System.out.println("6. 즐겨찾기 삭제");//아직 못했습니다...
		System.out.println("0. 프로그램 종료 ");
		
		System.out.println("메뉴 입력>>>");
		
		
		
		
		try {
		btNum =sc.nextInt();
		sc.nextLine();
		
		switch(btNum) {
		
		case 1: System.out.println(addBook()); break;
		case 2: selectAll();break;
		case 3:  System.out.println( updateBook());  break;
		case 4:  System.out.println( removeBook() );     break;
		case 5:     break;
		case 6:       break;
		case 0: System.out.println("프로그램 종료");break;
		default : System.out.println("네뉴에 작성된 번호만 입력해주세요!");
		
		
		
		}
		}catch(InputMismatchException e) {
			
			System.out.println("\n error : 입력 형식이 유효하지 않습니다."
					+ "다시 시도해주세요!");
			sc.nextLine();//입력 버퍼에 남아있는 잘못 입력된 문자열 제거용
			btNum = -1;//첫 반복 시 잘못 입력하는 경우 menuNum이 0을 가지고 있어 종료됨.
			//이를 방지하기 위해서 임의값 -1를 대입
			
		}
		
	}while(btNum !=0);
	
		
	}
	
	
	
	public String addBook() throws InputMismatchException {
			
		
			
			
			System.out.println("==========도서 추가========");
		
			
			
//			System.out.println("도서등록번호 : ");
//			int bkNum	= sc.nextInt();
			
			System.out.println("제목 : ");
			String bkName = sc.next();
			
			System.out.println("저자 : ");
			String writer = sc.next();
			
			
			System.out.println("가격 : ");
			int price	= sc.nextInt();
			
			
			sc.nextLine();
			System.out.println("출판사 : ");
			String company = sc.next();
			 
			
			//student 객체 생성 후 List 추가
			if(bkList.add(new Book(bkName,writer,price,company)) ) {
				return "성공";
				
			}else {
				return "실패";
			}
			
			
			
		}
		
		
	public void selectAll() {
		
		System.out.println("===== 0조 도서목록 =====");
		
		if(bkList.isEmpty()) { //studentList가 비어있으면 true반환
			System.out.println("도서정보가 없습니다.");
			
			
			return; //반환형없는( void) return 구문은 현재 메소드를 종료하고 호출한곳으로 돌아감
				//처음으로 else문을 쓴것같은 효과!
		}
		
		/*
		//일반 for문
		for(int i =0;i<studentList.size(); i++) {
			System.out.println(studentList.get(i));
			//studentList에서 i번째 인덱스 요소를 얻어와 출력
			
		}
	*/
		
		//향상된 for문(for each문)
		// - 컬렉션,배열의 모든 요소를 순차적으로 반복 접근할 수 있는for문
		// 	(순차적 : 0번 인덱스부터 마지막요소까지 인덱스를 1씩 증가)
		
		//[작성법]
		//for(컬렉션 or 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬렉션명
		//또는 배열명) {}
	
		int index = 0;
		for(Book bk :bkList) {
			//std에는 for문 반복 시 마다 0,1,2...인덱스 요소들을 한번씩 저장됨.
			System.out.print((index++) +  "번 : ");
			System.out.println(bk);
			
			
			
		}
		
	
		
	}
	
	
	
	
	public String updateBook() throws InputMismatchException{
		//List.set(int index,Student e)
		//-->List의 index 요소를 전달받은 e로 변경
		//-->반환값 Student == 변경 전 student 객체가 담겨있음
		
		System.out.print("======학생 정보 수정=======");
		System.out.println("도서등록번호 입력: ");
		int index = sc.nextInt();
		sc.nextLine();
		
		
		//1)학생 정보가 studentList에 있는가?
		if(bkList.isEmpty()) {
			return "입력된 도서 정보가 없습니당";
			//2)입력된 숫자가 0보다 작은가?(음수 X)
		}else if(index < 0) {
			return "음수는 입력할 수 없습니다";
		
		
		
		
		//+ 문자열을 입력한 경우 - throws로 예외처리
			
		//3)입력된 숫자가 studentList 범위 내 인덱스 번호인가?
		}else if(index >= bkList.size()) {
			//   5                      5 0 1 2 3 4
			return "범위를 넘어선 값을 입력할 수 없습니다";
			
		}else {
			
			//수정 코드 작성
			System.out.println(index + "번째 인덱스에 저장된 도서 정보");
			System.out.println(bkList.get(index));
			

			System.out.println("제목 : ");
			String bkName = sc.next();
			
			System.out.println("저자 : ");
			String writer = sc.next();
			
			
			System.out.println("가격 : ");
			int price	= sc.nextInt();
			
			
			sc.nextLine();
			System.out.println("출판사 : ");
			String company = sc.next();
			 
			
			
			//입력받은 index번째에 새로운 학생 정보를 세팅 == 수정
			//이때, index번째에 있던 기존 학생 정보가 반환된다
			
			
			Book temp  = bkList.set(index, new Book(bkName,writer,price,company));
		
		return temp.getBkName()+ "의 정보가 변경되었습니다";
		
	}
	}
	
	
	public String removeBook() throws InputMismatchException {
		//List.remove(int index)
		//리스트에서 index번째 요소를 제거
		//이 때,제거된 요소가 반환된다
		//*List는 중간에 비어있는 인덱스가 없게 하기 위해서
		//remove() 동작 시 뒤쪽 요소를 한 칸씩 당겨온다.
		
		System.out.println("======도서 정보 제거=====");
		
		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		
		//1)학생 정보가 studentList에 있는가?
		if(bkList.isEmpty()) {
			return "입력된 학생 정보가 없습니당";
			//2)입력된 숫자가 0보다 작은가?(음수 X)
		}else if(index < 0) {
			return "음수는 입력할 수 없습니다";
		
		
		
		
		//+ 문자열을 입력한 경우 - throws로 예외처리
			
		//3)입력된 숫자가 studentList 범위 내 인덱스 번호인가?
		}else if(index >= bkList.size()) {
			//   5                      5 0 1 2 3 4
			return "범위를 넘어선 값을 입력할 수 없습니다";
		
		}else {
			
			//학생 정보 제거
			System.out.println("정말 삭제 하시겠습니까?   (Y/N)" );
			char ch = sc.next().toUpperCase().charAt(0);
			//String --> 대문자 String ->대문자 0번째 인덱스 문자
			//String..toUpperCase() : 문자열을 대문자로 변환
			//String.toLowerCase() : 문자열을 소문자로 변환
			//문자열은 .equals()
		if(ch == 'Y') { //y를 소문자로 써서
				Book temp = bkList.remove(index);
				return temp.getBkName() + "의 정보가 제거되었습니다";
				
			}else {
				return "취소";
			}
			
			
	}
}
	
	public String addFvBook() throws InputMismatchException {
			
		
		
		
		
		return null;
		
		
		
		
	}
	
	
}

