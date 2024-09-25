package _17_ArrayList;

import java.util.ArrayList;

public class ListSample {
	ArrayList<String>a=new ArrayList<>();
	ListSample(){
		System.out.println("리스트의 길이: "+a.size());
		a.add("apple");
		System.out.println("리스트의 길이: "+a.size());
		a.add("banana");
		a.add("abc초콜릿");
		a.add("샌드");
		System.out.println("리스트의 길이: "+a.size());
		System.out.println(a.get(1));
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		System.out.println();
		//a로 시작하지 않는 문자열 출력
		for(int i=0;i<a.size();i++) {
			if(a.get(i).charAt(0)!='a')
			System.out.println(a.get(i));
		}
		System.out.println();
		a.add(1,"쭈꾸미");//특정 인덱스 위치에 추가
		for(int i=0;i<a.size();i++) {
			System.out.println(i+":"+a.get(i));
		}
		System.out.println();
		a.remove(3);//특정 인덱스 삭제
		for(int i=0;i<a.size();i++) {
			System.out.println(i+":"+a.get(i));
		}
		System.out.println();
		a.set(1,"갑오징어");//특정 인덱스 수정
		for(int i=0;i<a.size();i++) {
			System.out.println(i+":"+a.get(i));
		}
		System.out.println();
		a.clear();//리스트 전체삭제
		System.out.println(a.size());
	}
}
