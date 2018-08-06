package com.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {

    private String name;
    private int releaseYear;
    private double rating;
    private String genre;

   public Movie(String name,int releaseYear,double rating,String genre)
    {
        this.name=name;
        this.releaseYear=releaseYear;
        this.rating=rating;
        this.genre=genre;
    }
    public Integer getReleaseYear(){
       return this.releaseYear;
    }
    public Double getRating(){
        return this.rating;
    }
    public String getMovieGenre(){
        return this.genre;
    }
    public String getMovieName(){
        return this.name;
    }

}

class TestMovie{

    public void ratingEvenNumber(List<Movie> list){
        List movieList = list.stream().filter(movieName->movieName.getRating()%2==0)
                .map(Movie::getMovieName)
                .collect(Collectors.toList());
        System.out.println( movieList);
    }
    public void ratingEquals7(List<Movie> list){
        List movieList = list.stream()
                .filter((movieName)->movieName.getRating()==7 &&  movieName.getMovieGenre().equals("Sci-Fi"))
                .map(Movie::getMovieName)
                .collect(Collectors.toList());
        System.out.println( movieList);
    }
    public void ratingGreaterthan8(List<Movie> list){
        List movieList = list.stream()
                .filter(movieName->movieName.getRating()>8 && movieName.getMovieGenre().equals("Comedy"))
                 .map(Movie::getMovieName)
                .collect(Collectors.toList());
        System.out.println( movieList);
    }
    public void ratinglessthan8(List<Movie> list) {
        List movieList = list.stream()
                .filter(movieName -> movieName.getRating() < 8 && movieName.getReleaseYear() > 2000)
                .map(Movie::getMovieName)
                .collect(Collectors.toList());
        System.out.println( movieList);
    }

        public static void main(String[] args) {
        Movie movie1 = new Movie("Phir Hera Pheri",2014,9,"Comedy");
        Movie movie2 = new Movie("DDLJ",1999,8,"Romance");
        Movie movie3 = new Movie("Sonu ki twitty ki Sweety",2018,7,"Comedy");
        Movie movie4 = new Movie("Life",2017,7,"Sci-Fi");
        Movie movie5 = new Movie("Hate Story",2015,6,"Suspense");
        List<Movie> list=Arrays.asList(movie1,movie2,movie3,movie4,movie5);
        TestMovie testObj= new TestMovie();
        testObj.ratingEquals7(list);
        testObj.ratingEvenNumber(list);
        testObj.ratinglessthan8(list);
        testObj.ratingGreaterthan8(list);

    }
}



