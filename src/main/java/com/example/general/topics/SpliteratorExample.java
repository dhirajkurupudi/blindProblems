package com.example.general.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SpliteratorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<Article> articles = Stream.of(new Article(1, "Java"), new Article(2, "Spring"), new Article(3, "Hibernate"), new Article(4, "DSA") );
		
		Spliterator<Article> articleSpliterator = articles.spliterator();
		//iterator check if it hasnext() then to access that element next()
		//while(articleSpliterator.tryAdvance(x -> System.out.println(x)));
		
		List<Article> articleList = Stream.generate(() -> new Article(1, "Java"))
		        .limit(10000)
		        .collect(Collectors.toList());

		    Spliterator<Article> split1 = articleList.spliterator();
		    Spliterator<Article> split2 = split1.trySplit();
		    Spliterator<Article> split3 = split2.trySplit();
		    
		    
		    List<Article> listOne = new ArrayList<>();
		    List<Article> listTwo = new ArrayList<>();
		    List<Article> listThree = new ArrayList<>(); 
		    split1.forEachRemaining(x -> listOne.add(x));
		    split2.forEachRemaining(listTwo::add);
		    split3.forEachRemaining(listThree::add);
		    
		    System.out.println("list 1 size "+listOne.size()+" list 2 size "+listTwo.size()+" list 3 size "+listThree.size());
		    

	}

}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Article {
	int id;
	String name;
}
