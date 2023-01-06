package com.ezen.demo;

import java.util.Arrays;

import lombok.Data;

@Data
class Human{
	private String name;
	private int age;
	private int favoritNumber;
}
public class SortTest2 {

	public static void main(String[] args) {
		Human h = new Human();
		h.setName("홍길동");
		h.setAge(30);
		h.setFavoritNumber(7);
		
		Human h2 = new Human();
		h2.setName("임꺽정");
		h2.setAge(15);
		h2.setFavoritNumber(11);
		
		Human h3 = new Human();
		h3.setName("임희정");
		h3.setAge(20);
		h3.setFavoritNumber(5);
		
		Human[] humans = {h,h2,h3};
		
		
		for(int i=0;i<humans.length;i++) {
			for(int j=i+1;j<humans.length;j++) {
				if(humans[i].getAge()>humans[j].getAge()) {
					int tmpAge = humans[i].getAge();
					humans[i].setAge(humans[j].getAge());
					humans[j].setAge(tmpAge);
				}
			}
		}
		
		for(Human human:humans) {
			System.out.println(human);
		}
	}
}
